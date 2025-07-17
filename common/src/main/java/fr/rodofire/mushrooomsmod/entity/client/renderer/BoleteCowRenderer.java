package fr.rodofire.mushrooomsmod.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.entity.client.model.BoleteCowModel;
import fr.rodofire.mushrooomsmod.entity.custom.BoleteCowEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BoleteCowRenderer extends GeoEntityRenderer<BoleteCowEntity> {
    public BoleteCowRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BoleteCowModel());
    }

    @Override
    public ResourceLocation getTextureLocation(BoleteCowEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/entity/bolete_cow.png");
    }

    @Override
    public void render(BoleteCowEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
