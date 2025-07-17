package fr.rodofire.mushrooomsmod.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.entity.client.model.CrystalGolemModel;
import fr.rodofire.mushrooomsmod.entity.custom.CrystalGolemEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CrystalGolemRenderer extends GeoEntityRenderer<CrystalGolemEntity> {
    public CrystalGolemRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrystalGolemModel());
    }

    @Override
    public ResourceLocation getTextureLocation(CrystalGolemEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/entity/crystal_golem.png");
    }

    @Override
    public void render(CrystalGolemEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
