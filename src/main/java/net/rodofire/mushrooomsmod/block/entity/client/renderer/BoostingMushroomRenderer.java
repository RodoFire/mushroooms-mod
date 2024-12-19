package net.rodofire.mushrooomsmod.block.entity.client.renderer;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.rodofire.mushrooomsmod.block.entity.BoostingMushroomBlockEntity;
import net.rodofire.mushrooomsmod.block.entity.client.model.BoostingMushroomModel;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class BoostingMushroomRenderer extends GeoBlockRenderer<BoostingMushroomBlockEntity> {
    public BoostingMushroomRenderer(BlockEntityRendererFactory.Context context) {
        super(new BoostingMushroomModel());
    }

    @Override
    public void render(BoostingMushroomBlockEntity animatable, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight, int packedOverlay) {
        //this.builtinModelItemRenderer.render(new ItemStack(animatable.getCachedState().getBlock()), ModelTransformationMode.NONE, poseStack, bufferSource, packedLight, packedOverlay);
        //super.actuallyRender(poseStack, animatable, BakedGeoModel);
        this.animatable = animatable;

        defaultRender(poseStack, this.animatable, bufferSource, RenderLayer.getTranslucentMovingBlock(), null, partialTick, packedLight);

    }
}
