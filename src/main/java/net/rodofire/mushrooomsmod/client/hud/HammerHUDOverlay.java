package net.rodofire.mushrooomsmod.client.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.item.custom.HammerItem;

public class HammerHUDOverlay implements HudRenderCallback {

    private static final Identifier HAMMER = Identifier.of(MushrooomsMod.MOD_ID,
            "textures/mushrooomsmodhud/hammeruse.png");
    private static final Identifier HAMMER_FULL = Identifier.of(MushrooomsMod.MOD_ID, "textures/mushrooomsmodhud/hammeruse_full.png");

    private void drawTexture(MinecraftClient client, DrawContext drawContext, ItemStack item) {
        int width = client.getWindow().getScaledWidth();
        int height = client.getWindow().getScaledHeight();

        int x = width / 2 - 6;
        int y = height / 2 + 10;

        RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, HAMMER);


        int progress = ((HammerItem) item.getItem()).getHammerUse();
        float proportion = 1 - ((float) progress / 200);
        int filled = (int) (16 * proportion);

        drawContext.drawTexture(RenderLayer::getGuiTextured, HAMMER, x, y, 0, 0, 16, 16, 16, 16);
        RenderSystem.setShaderTexture(0, HAMMER_FULL);
        drawContext.drawTexture(RenderLayer::getGuiTextured, HAMMER_FULL, x, y, 0, 0, filled, 16, 16, 16);
    }

    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null) return;
        PlayerEntity player = client.player;
        if (player != null) {

            ItemStack item = player.getMainHandStack();
            HitResult hit = player.raycast(5, tickCounter.getTickDelta(true), false);

            if (item.getItem() instanceof HammerItem && hit.getType() == HitResult.Type.BLOCK) {
                World world = player.getWorld();

                Vec3d seconpos = client.crosshairTarget.getPos();

                BlockPos.Mutable mutable = new BlockPos.Mutable();
                mutable.set(seconpos.x, seconpos.y, seconpos.z);

                //Had to do it like this beacause secondpos wasn't always accurate
                if (world.getBlockState(mutable).getBlock() == ModBlocks.FORGE_BLOCK
                        || world.getBlockState(mutable.up()).getBlock() == ModBlocks.FORGE_BLOCK || world.getBlockState(mutable.down()).getBlock() == ModBlocks.FORGE_BLOCK
                        || world.getBlockState(mutable.north()).getBlock() == ModBlocks.FORGE_BLOCK || world.getBlockState(mutable.south()).getBlock() == ModBlocks.FORGE_BLOCK
                        || world.getBlockState(mutable.east()).getBlock() == ModBlocks.FORGE_BLOCK || world.getBlockState(mutable.west()).getBlock() == ModBlocks.FORGE_BLOCK) {
                    drawTexture(client, drawContext, item);
                }
            }
        }
    }
}
