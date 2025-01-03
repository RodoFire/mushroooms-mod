package net.rodofire.mushrooomsmod.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.config.MushrooomsConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin {

    @Shadow
    private final MinecraftClient client;

    protected ClientPlayNetworkHandlerMixin(MinecraftClient client) {
        this.client = client;
    }

    @Inject(method = "onGameJoin", at = @At("TAIL"))
    private void mushroom_warning(GameJoinS2CPacket arg, CallbackInfo ci) {
        if (client.player == null) {
            return;
        }
        assert client.world != null;
        if (!client.world.isClient) {return;}

        if (client.player.getWorld().isClient()) {
            if (MushrooomsConfig.clientWarnMessage()) {
            MutableText gitissues =  Text.literal("GithubIssues")
                    .styled(style -> style.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/RodoFire/mushroooms-mod-source-1.20.1/issues")))
                    .styled(style -> style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.of("Click here to go to the GitHub"))))
                    .styled(style -> style.withColor(Formatting.BLUE))
                    .styled(style -> style.withUnderline(true));
                client.player.sendMessage(Text.of("MushrooomsMod : Note that this mod is still on beta and a lot of new things are going to come. Please be aware that some existing features provided by this mod might change. \n You can desactivate this message in the config.\n You see any bug or you have an idea on how to improve the mod : ").copy().append(gitissues));

            } else {
                MushrooomsMod.LOGGER.info("MushrooomsMod : Note that this mod is still on beta and a lot of new things are going to come. Please note that some existing features provided by this mod might change. \n You see any bug or you have an idea on how to improve the mod : https://github.com/RodoFire/mushroooms-mod-source-1.20.1/issues");
            }
        }
    }
}
