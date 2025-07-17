package fr.rodofire.mushrooomsmod.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.entity.client.model.CrystalCreeperModel;
import fr.rodofire.mushrooomsmod.entity.custom.CrystalCreeperEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CrystalCreeperRenderer extends GeoEntityRenderer<CrystalCreeperEntity> {
    CrystalCreeperEntity entity;
    public CrystalCreeperRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrystalCreeperModel());
    }

    @Override
    public ResourceLocation getTextureLocation(CrystalCreeperEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/entity/crystal_creeper.png");
    }

    @Override
    public void render(CrystalCreeperEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {

        float g = entity.getClientFuseTime(partialTick);
        float h = 1.0f + Mth.sin(g * 100.0f) * g * 0.01f;
        g = Mth.clamp(g, 0.0f, 1.0f);
        g *= g;
        g *= g;
        float i = (1.0f + g * 0.4f) * h;
        float j = (1.0f + g * 0.1f) / h;

        poseStack.scale(i, j, i);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public int getPackedOverlay(CrystalCreeperEntity animatable, float u, float partialTick) {
        return super.getPackedOverlay(animatable, getSwellOverlay(animatable, u), partialTick);
    }

    protected float getSwellOverlay(CrystalCreeperEntity entity, float u) {
        float swell = entity.getClientFuseTime(u);

        return (int) (swell * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(swell, 0.5F, 1.0F);
    }

}
