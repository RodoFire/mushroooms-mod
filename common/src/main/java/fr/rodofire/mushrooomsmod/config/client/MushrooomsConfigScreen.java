package fr.rodofire.mushrooomsmod.config.client;

import fr.rodofire.ewc.EwcConstants;
import fr.rodofire.ewc.client.gui.widget.ImageButtonWidget;
import fr.rodofire.ewc.config.ConfigCategory;
import fr.rodofire.ewc.config.client.DefaultConfigScreen;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ConfirmLinkScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.config.MushrooomsClientConfig;
import org.spongepowered.asm.mixin.Unique;

import java.util.ArrayList;
import java.util.List;

public class MushrooomsConfigScreen extends DefaultConfigScreen {
    //*/icons
    private static final ResourceLocation DISCORD_ICON = ResourceLocation.fromNamespaceAndPath(EwcConstants.MOD_ID, "textures/gui/discord.png");
    private static final ResourceLocation GITHUB_ICON = ResourceLocation.fromNamespaceAndPath(EwcConstants.MOD_ID, "textures/gui/github.png");
    private static final ResourceLocation KOFI_ICON = ResourceLocation.fromNamespaceAndPath(EwcConstants.MOD_ID, "textures/gui/kofi.png");
    private static final ResourceLocation CURSEFORGE_ICON = ResourceLocation.fromNamespaceAndPath(EwcConstants.MOD_ID, "textures/gui/curseforge.png");
    private static final ResourceLocation MODRINTH_ICON = ResourceLocation.fromNamespaceAndPath(EwcConstants.MOD_ID, "textures/gui/modrinth.png");

    //links
    private static final String DISCORD_LINK = "https://discord.gg/bAQRUxNyFj";
    private static final String GITHUB_LINK = "https://github.com/McMellonTeam/mushroooms-mod";
    private static final String KOFI_LINK = "https://ko-fi.com/rodofire";
    private static final String CURSEFORGE_LINK = "https://www.curseforge.com/minecraft/mc-mods/mushroooms";
    private static final String MODRINTH_LINK = "https://modrinth.com/mod/mushroooms";

    public MushrooomsConfigScreen(Screen parent) {
        super(parent, MushrooomsClientConfig.CLIENT_CONFIG, MushrooomsModConstants.MOD_ID, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/gui/config_background.png"), 1920, 1080, 0xAFAFAFFF, 0xC8000000);
    }

    @Override
    protected void init(ConfigCategory category) {
        super.init(category);
        List<ImageButtonWidget> buttons = getButtons();
        for (ImageButtonWidget button : buttons) {
            this.addRenderableWidget(button);
        }
    }

    @Unique
    public ImageButtonWidget createButton(String link, int yOffset, ResourceLocation icon) {
        int getIconSize = getIconSize();
        Minecraft client = Minecraft.getInstance();
        return new ImageButtonWidget(
                8, client.getWindow().getGuiScaledHeight() / 2 + (int) (yOffset * (getIconSize == 24 ? 1 : 0.75)),
                getIconSize(), getIconSize(), icon,
                button -> {
                    Minecraft.getInstance().setScreen(new ConfirmLinkScreen(
                            open -> {
                                if (open) {
                                    Util.getPlatform().openUri(link);
                                }
                                Minecraft.getInstance().setScreen(this);
                            }, link, true)
                    );
                }
        );
    }

    @Unique
    public int getIconSize() {
        int large = Minecraft.getInstance().getWindow().getGuiScaledHeight();
        return large < 300 ? 20 : 24;
    }

    @Unique
    public List<ImageButtonWidget> getButtons() {
        List<ImageButtonWidget> buttons = new ArrayList<>();
        buttons.add(createButton(GITHUB_LINK, 28, GITHUB_ICON));
        buttons.add(createButton(DISCORD_LINK, 0, DISCORD_ICON));
        buttons.add(createButton(KOFI_LINK, 56, KOFI_ICON));
        buttons.add(createButton(CURSEFORGE_LINK, -28, CURSEFORGE_ICON));
        buttons.add(createButton(MODRINTH_LINK, -56, MODRINTH_ICON));
        return buttons;
    }

}
