package fr.rodofire.mushrooomsmod.mixin.client;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientCommonPacketListenerImpl;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.CommonListenerCookie;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.config.MushrooomsConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPacketListener.class)
public abstract class ClientPlayNetworkHandlerMixin extends ClientCommonPacketListenerImpl {
    protected ClientPlayNetworkHandlerMixin(Minecraft client, Connection connection, CommonListenerCookie connectionState) {
        super(client, connection, connectionState);
    }

    @Inject(method = "handleLogin", at = @At("TAIL"))
    private void mushroom_warning(ClientboundLoginPacket arg, CallbackInfo ci) {
        if (minecraft.player == null) {
            return;
        }
        if (minecraft.level == null) {
            return;
        }
        if (!minecraft.level.isClientSide) {
            return;
        }

        if (minecraft.player.level().isClientSide()) {

            if (MushrooomsConfig.clientWarnMessage()) {
            MutableComponent gitissues =  Component.literal("GithubIssues")

                    .withStyle(style -> style.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/RodoFire/mushroooms-mod-source-1.20.1/issues")))
                    .withStyle(style -> style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.nullToEmpty("Click here to go to the GitHub"))))
                    .withStyle(style -> style.withColor(ChatFormatting.BLUE))
                    .withStyle(style -> style.withUnderlined(true));
                minecraft.player.sendSystemMessage(Component.nullToEmpty("MushrooomsMod : Note that this mod is still on beta and a lot of new things are going to come. Please be aware that some existing features provided by this mod might change. \n You can desactivate this message in the config.\n You see any bug or you have an idea on how to improve the mod : ").copy().append(gitissues));

            } else {
                MushrooomsModConstants.LOGGER.info("MushrooomsMod : Note that this mod is still on beta and a lot of new things are going to come. Please note that some existing features provided by this mod might change. \n You see any bug or you have an idea on how to improve the mod : https://github.com/RodoFire/mushroooms-mod-source-1.20.1/issues");
            }

        }
    }
}
