package fr.rodofire.mushrooomsmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import fr.rodofire.mushrooomsmod.MushrooomsMod;

public class ForgeScreen /*extends AbstractContainerScreen<ForgeScreenHandler>*/ {
   /* private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/gui/forge_gui.png");

    public ForgeScreen(ForgeScreenHandler handler, Inventory inventory, Component title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleLabelY = 1000;
        inventoryLabelY = 1000;
    }

    @Override
    protected void renderBg(GuiGraphics context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        context.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
    }


    @Override
    public void render(GuiGraphics context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX,mouseY,delta);
        super.render(context, mouseX, mouseY, delta);
        renderTooltip(context, mouseX, mouseY);
    }*/
}
