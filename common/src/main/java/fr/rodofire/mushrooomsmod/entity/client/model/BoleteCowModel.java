package fr.rodofire.mushrooomsmod.entity.client.model;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.entity.custom.BoleteCowEntity;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class BoleteCowModel extends GeoModel<BoleteCowEntity> {

    @Override
    public ResourceLocation getModelResource(BoleteCowEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "geo/bolete_cow.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BoleteCowEntity animatable) {

        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/entity/bolete_cow.png");

    }

    @Override
    public ResourceLocation getAnimationResource(BoleteCowEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "animations/bolete_cow.animation.json");
    }

    @Override
    public void setCustomAnimations(BoleteCowEntity animatable, long instanceId, AnimationState<BoleteCowEntity> animationState) {
        GeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }


}
