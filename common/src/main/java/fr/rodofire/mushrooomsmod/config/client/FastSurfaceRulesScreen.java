package fr.rodofire.mushrooomsmod.config.client;

import fr.rodofire.ewc.client.gui.screen.AbstractInfoScreen;
import fr.rodofire.ewc.client.gui.widget.ScrollBarWidget;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.MultiLineLabel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import fr.rodofire.mushrooomsmod.MushrooomsMod;

import java.util.List;

public class FastSurfaceRulesScreen extends AbstractInfoScreen {
    private int maxScroll = 0;
    private static final int PADDING = 30;
    boolean bl = false;
    ScrollBarWidget scrollBar;

    public FastSurfaceRulesScreen() {
        super(Component.nullToEmpty("fast surface rules info"), ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/gui/config_background.png"), 1920, 1080);
        scrollBar = new ScrollBarWidget(this.width - 10, 25, this.height - 25, (short) this.maxScroll, action -> bl = true, Component.nullToEmpty(""));
    }

    @Override
    protected void init() {
        super.init();
        maxScroll = calculateContentHeight() - (this.height - 2 * PADDING);

        if (maxScroll < 0) {
            maxScroll = 0; // Pas de défilement nécessaire si le contenu est plus petit que la zone visible
        }
        scrollBar.refresh(this.width - 10, 25, this.height - 25, maxScroll);
        this.addRenderableWidget(scrollBar);
    }

    @Override
    public void renderOverBackground(GuiGraphics context, int mouseX, int mouseY, float delta) {
        int scrollOffset = scrollBar.getScroll();

        // Début du test de découpe
        this.renderDarkRectangle(context, 0, PADDING - 5, this.width, this.height - PADDING + 5, 0xBA000000);
        context.enableScissor(0, PADDING, this.width, this.height - PADDING);

        int yOffset = PADDING - scrollOffset; // Position de départ du contenu, ajustée par le scroll

        // Rendu des éléments dans la zone scrollable
        MultiLineLabel.create(this.font, Component.translatable("config.mushrooomsmod.fast_surface_rules.concept"), 4 * this.width / 5)
                .renderLeftAlignedNoShadow(context, this.width / 10, yOffset, 9, 0xFFFFFF);

        int width1 = 8 * this.width / 20;
        int height1 = 9 * width1 / 16;


        context.drawCenteredString(this.font, Component.translatable("config.mushrooomsmod.fast_surface_rules.comparison"), this.width / 2, yOffset + calculateTextHeight(Component.translatable("config.mushrooomsmod.fast_surface_rules.concept").getString(), 4 * this.width / 5) + 15, 0xFFFFFF);

        context.drawCenteredString(this.font, Component.translatable("config.mushrooomsmod.fast_surface_rules.default"), this.width / 2 + (width1 + 10) / 2, yOffset + calculateTextHeight(Component.translatable("config.mushrooomsmod.fast_surface_rules.concept").getString(), 4 * this.width / 5) + 26, 0xFFFFFF);
        context.blit(
                ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/gui/info/default_surface_rules.png"),
                this.width / 2 + 10,
                yOffset + calculateTextHeight(Component.translatable("config.mushrooomsmod.fast_surface_rules.concept").getString(), 4 * this.width / 5) + 36,
                0,
                0,
                width1,
                height1,
                width1,
                height1
        );
        context.drawCenteredString(this.font, Component.translatable("config.mushrooomsmod.fast_surface_rules.fast"), this.width / 2 - (width1 - 10) / 2, yOffset + calculateTextHeight(Component.translatable("config.mushrooomsmod.fast_surface_rules.concept").getString(), 4 * this.width / 5) + 26, 0xFFFFFF);
        context.blit(
                ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/gui/info/fast_surface_rules.png"),
                this.width / 2 - width1 - 10,
                yOffset + calculateTextHeight(Component.translatable("config.mushrooomsmod.fast_surface_rules.concept").getString(), 4 * this.width / 5) + 36,
                0,
                0,
                width1,
                height1,
                width1,
                height1
        );

        context.blit(ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/gui/info/performance_comparison.png"),
                this.width / 2 - width1,
                yOffset + calculateTextHeight(Component.translatable("config.mushrooomsmod.fast_surface_rules.concept").getString(), 4 * this.width / 5) + 62 + height1,
                0,
                0,
                2 * width1,
                2 * height1,
                2 * width1,
                2 * height1
        );
        context.disableScissor();
        context.drawCenteredString(
                this.font,
                Component.translatable("config.mushrooomsmod.fast_surface_rules.graph"),
                this.width / 2,
                yOffset + calculateTextHeight(Component.translatable("config.mushrooomsmod.fast_surface_rules.concept").getString(), 4 * this.width / 5) + 45 + height1,
                0xFFFFFF
        );

        this.renderDarkRectangle(context, this.width / 2 - 75, 3, this.width / 2 + 75, 15, 0xDA000000);
        context.drawCenteredString(this.font, this.title, this.width / 2, 5, 16777215);
    }

    private int calculateContentHeight() {
        return calculateTextHeight(Component.translatable("config.mushrooomsmod.fast_surface_rules.concept").getString(), 4 * this.width / 5) + 32 + 27 * (8 * this.width / 20) / 16 + 26;
    }

    public int calculateTextHeight(String text, int maxWidth) {
        // Divise le texte en lignes, limitées à maxWidth
        List<FormattedCharSequence> wrappedLines = font.split(Component.nullToEmpty(text), maxWidth);
        return wrappedLines.size() * (font.lineHeight);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        return scrollBar.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        return scrollBar.mouseDragged(mouseX, mouseY, button, deltaX, deltaY, this.height);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        return scrollBar.mouseReleased(mouseX, mouseY, button);
    }
}
