package fr.rodofire.mushrooomsmod.entity.client.model;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.resources.ResourceLocation;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.entity.custom.PlotiEntity;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class PlotiModel extends GeoModel<PlotiEntity> {
    @Override
    public ResourceLocation getModelResource(PlotiEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "geo/ploti.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PlotiEntity animatable) {

        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/entity/ploti.png");

    }

    @Override
    public ResourceLocation getAnimationResource(PlotiEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "animations/ploti.animation.json");
    }

    @Override
    public void setCustomAnimations(PlotiEntity animatable, long instanceId, AnimationState<PlotiEntity> animationState) {
        /*CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }*/
    }
}
