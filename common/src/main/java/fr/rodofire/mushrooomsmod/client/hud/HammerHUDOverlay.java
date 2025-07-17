package fr.rodofire.mushrooomsmod.client.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.item.custom.HammerItem;

public class HammerHUDOverlay {

    private static final ResourceLocation HAMMER = ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID,
            "textures/mushrooomsmodhud/hammeruse.png");
    private static final ResourceLocation HAMMER_FULL = ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/mushrooomsmodhud/hammeruse_full.png");

    private static void drawTexture(Minecraft client, GuiGraphics drawContext, ItemStack item) {
        int width = client.getWindow().getGuiScaledWidth();
        int height = client.getWindow().getGuiScaledHeight();

        int x = width / 2 - 6;
        int y = height / 2 + 10;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, HAMMER);


        int progress = ((HammerItem) item.getItem()).getHammerUse();
        float proportion = 1 - ((float) progress / 200);
        int filled = (int) (16 * proportion);

        drawContext.blit(HAMMER, x, y, 0, 0, 16, 16, 16, 16);
        RenderSystem.setShaderTexture(0, HAMMER_FULL);
        drawContext.blit(HAMMER_FULL, x, y, 0, 0, filled, 16, 16, 16);
    }

    public static void onHudRender(GuiGraphics drawContext, DeltaTracker tickCounter) {
        Minecraft client = Minecraft.getInstance();
        if (client == null) return;
        Player player = client.player;
        if (player != null) {

            ItemStack item = player.getMainHandItem();
            HitResult hit = player.pick(5, tickCounter.getGameTimeDeltaPartialTick(true), false);

            if (item.getItem() instanceof HammerItem && hit.getType() == HitResult.Type.BLOCK) {
                Level world = player.level();

                Vec3 seconpos = client.hitResult.getLocation();

                BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
                mutable.set(seconpos.x, seconpos.y, seconpos.z);

                //Had to do it like this beacause secondpos wasn't always accurate
                if (world.getBlockState(mutable).getBlock() == ModBlocks.FORGE_BLOCK
                        || world.getBlockState(mutable.above()).getBlock() == ModBlocks.FORGE_BLOCK || world.getBlockState(mutable.below()).getBlock() == ModBlocks.FORGE_BLOCK
                        || world.getBlockState(mutable.north()).getBlock() == ModBlocks.FORGE_BLOCK || world.getBlockState(mutable.south()).getBlock() == ModBlocks.FORGE_BLOCK
                        || world.getBlockState(mutable.east()).getBlock() == ModBlocks.FORGE_BLOCK || world.getBlockState(mutable.west()).getBlock() == ModBlocks.FORGE_BLOCK) {
                    drawTexture(client, drawContext, item);
                }
            }
        }
    }
}
