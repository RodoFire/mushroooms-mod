package fr.rodofire.mushrooomsmod.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.entity.client.model.GrokiModel;
import fr.rodofire.mushrooomsmod.entity.custom.GrokiEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GrokiRenderer extends GeoEntityRenderer<GrokiEntity> {
    public GrokiRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GrokiModel());
    }

    @Override
    public ResourceLocation getTextureLocation(GrokiEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/entity/groki.png");
    }

    @Override
    public void render(GrokiEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

}
