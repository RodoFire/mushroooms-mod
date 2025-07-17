package fr.rodofire.mushrooomsmod.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.entity.client.model.SchroomStickModel;
import fr.rodofire.mushrooomsmod.entity.custom.SchroomStickEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SchroomStickRenderer extends GeoEntityRenderer<SchroomStickEntity> {
    public SchroomStickRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SchroomStickModel());
    }

    @Override
    public ResourceLocation getTextureLocation(SchroomStickEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/entity/schroom_stick.png");
    }

    @Override
    public void render(SchroomStickEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
