package net.rodofire.mushrooomsmod.config.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ConfirmLinkScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.rodofire.easierworldcreator.Ewc;
import net.rodofire.easierworldcreator.client.hud.widget.ImageButtonWidget;
import net.rodofire.easierworldcreator.config.ConfigCategory;
import net.rodofire.easierworldcreator.config.client.DefaultConfigScreen;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.config.MushrooomsClientConfig;
import org.spongepowered.asm.mixin.Unique;

import java.util.ArrayList;
import java.util.List;

public class MushrooomsConfigScreen extends DefaultConfigScreen {
    //*/icons
    private static final Identifier DISCORD_ICON = new Identifier(Ewc.MOD_ID, "textures/gui/discord.png");
    private static final Identifier GITHUB_ICON = Identifier.of(Ewc.MOD_ID, "textures/gui/github.png");
    private static final Identifier KOFI_ICON = Identifier.of(Ewc.MOD_ID, "textures/gui/kofi.png");
    private static final Identifier CURSEFORGE_ICON = Identifier.of(Ewc.MOD_ID, "textures/gui/curseforge.png");
    private static final Identifier MODRINTH_ICON = Identifier.of(Ewc.MOD_ID, "textures/gui/modrinth.png");

    //links
    private static final String DISCORD_LINK = "https://discord.gg/bAQRUxNyFj";
    private static final String GITHUB_LINK = "https://github.com/McMellonTeam/mushroooms-mod";
    private static final String KOFI_LINK = "https://ko-fi.com/rodofire";
    private static final String CURSEFORGE_LINK = "https://www.curseforge.com/minecraft/mc-mods/mushroooms";
    private static final String MODRINTH_LINK = "https://modrinth.com/mod/mushroooms";

    public MushrooomsConfigScreen(Screen parent) {
        super(parent, MushrooomsClientConfig.CLIENT_CONFIG, MushrooomsMod.MOD_ID, Identifier.of(MushrooomsMod.MOD_ID, "textures/gui/config_background.png"), 1920, 1080, 0xAFAFAFFF, 0xC8000000);
    }

    @Override
    protected void init(ConfigCategory category) {
        super.init(category);
        List<ImageButtonWidget> buttons = getButtons();
        for (ImageButtonWidget button : buttons) {
            this.addDrawableChild(button);
        }
    }

    @Unique
    public ImageButtonWidget createButton(String link, int yOffset, Identifier icon) {
        int getIconSize = getIconSize();
        MinecraftClient client = MinecraftClient.getInstance();
        return new ImageButtonWidget(
                8, client.getWindow().getScaledHeight() / 2 + (int) (yOffset * (getIconSize == 24 ? 1 : 0.75)),
                getIconSize(), getIconSize(), icon,
                button -> {
                    MinecraftClient.getInstance().setScreen(new ConfirmLinkScreen(
                            open -> {
                                if (open) {
                                    Util.getOperatingSystem().open(link);
                                }
                                MinecraftClient.getInstance().setScreen(this);
                            }, link, true)
                    );
                }
        );
    }

    @Unique
    public int getIconSize() {
        int large = MinecraftClient.getInstance().getWindow().getScaledHeight();
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
