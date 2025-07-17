package fr.rodofire.mushrooomsmod.block.entity.client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BeaconRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import fr.rodofire.mushrooomsmod.block.entity.ForgeBE;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import java.util.ArrayList;

public class ForgeBlockEntityRenderer implements BlockEntityRenderer<ForgeBE> {
    public ForgeBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(ForgeBE entity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack;
        ArrayList<ItemStack> stackList = entity.getRenderStack();
        if (stackList.size() <= 1 || stackList.get(0).getCount() == 0) {
            stack = stackList.get(0);
            if (stack.getCount() != 0) {
                if (stack.getCount() == 1) {
                    renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.5f, 1f, 0.5f, 0.35f, 0.35f, 0.35f);
                } else if (stack.getCount() <= 10) {
                    renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.5f, 1f, 0.5f, 0.35f, 0.35f, 0.35f);
                    renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.55f, 1.02f, 0.55f, 0.35f, 0.35f, 0.35f);
                } else if (stack.getCount() > 10) {
                    renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.45f, 1f, 0.45f, 0.35f, 0.35f, 0.35f);
                    renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.5f, 1.02f, 0.5f, 0.35f, 0.35f, 0.35f);
                    renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.55f, 1.04f, 0.55f, 0.35f, 0.35f, 0.35f);
                }
            } else if (stackList.size() == 2) {
                stack = stackList.get(1);
                if (stack.getCount() == 1) {
                    renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.5f, 1f, 0.5f, 0.35f, 0.35f, 0.35f);
                } else if (stack.getCount() <= 10) {
                    renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.5f, 1f, 0.5f, 0.35f, 0.35f, 0.35f);
                    renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.55f, 1.02f, 0.55f, 0.35f, 0.35f, 0.35f);
                } else if (stack.getCount() > 10) {
                    renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.45f, 1f, 0.45f, 0.35f, 0.35f, 0.35f);
                    renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.5f, 1.02f, 0.5f, 0.35f, 0.35f, 0.35f);
                    renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.55f, 1.04f, 0.55f, 0.35f, 0.35f, 0.35f);
                }
            }


        } else {
            stack = stackList.get(0);
            if (stack.getCount() <= 1) {
                renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.6f, 1f, 0.6f, 0.35f, 0.35f, 0.35f);
            } else if (stack.getCount() <= 10) {
                renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.6f, 1f, 0.6f, 0.35f, 0.35f, 0.35f);
                renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.65f, 1.02f, 0.65f, 0.35f, 0.35f, 0.35f);
            } else {
                renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.6f, 1f, 0.6f, 0.35f, 0.35f, 0.35f);
                renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.65f, 1.02f, 0.65f, 0.35f, 0.35f, 0.35f);
                renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.7f, 1.04f, 0.7f, 0.35f, 0.35f, 0.35f);
            }

            stack = stackList.get(1);
            if (stack.getCount() <= 1) {
                renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.4f, 1f, 0.4f, 0.35f, 0.35f, 0.35f);
            } else if (stack.getCount() <= 10) {
                renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.4f, 1f, 0.4f, 0.35f, 0.35f, 0.35f);
                renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.35f, 1.02f, 0.35f, 0.35f, 0.35f, 0.35f);
            } else {
                renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.4f, 1f, 0.4f, 0.4f, 0.35f, 0.35f);
                renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.35f, 1.02f, 0.35f, 0.35f, 0.35f, 0.35f);
                renderMatrix(matrices, itemRenderer, stack, entity, vertexConsumers, 0.3f, 1.04f, 0.3f, 0.35f, 0.35f, 0.35f);
            }
        }

    }

    public void renderMatrix(PoseStack matrices, ItemRenderer itemRenderer, ItemStack stack, ForgeBE entity, MultiBufferSource vertexConsumers, float x, float y, float z, float x2, float y2, float z2) {
        matrices.pushPose();
        matrices.translate(x, y, z);
        matrices.scale(x2, y2, z2);
        matrices.mulPose(Axis.XP.rotationDegrees(270));
        itemRenderer.renderStatic(stack, ItemDisplayContext.GUI, getLightLevel(entity.getLevel(),
                entity.getBlockPos()), OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, entity.getLevel(), 1);
        matrices.popPose();
    }


    private int getLightLevel(Level world, BlockPos pos) {
        int bLight = world.getBrightness(LightLayer.BLOCK, pos);
        int sLight = world.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }

}
