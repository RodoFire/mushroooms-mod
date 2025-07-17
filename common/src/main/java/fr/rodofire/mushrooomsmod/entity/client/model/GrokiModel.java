package fr.rodofire.mushrooomsmod.entity.client.model;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.entity.custom.GrokiEntity;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class GrokiModel extends GeoModel<GrokiEntity> {
    @Override
    public ResourceLocation getModelResource(GrokiEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "geo/groki.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GrokiEntity animatable) {

        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/entity/groki.png");

    }

    @Override
    public ResourceLocation getAnimationResource(GrokiEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "animations/groki.animation.json");
    }

    @Override
    public void setCustomAnimations(GrokiEntity animatable, long instanceId, AnimationState<GrokiEntity> animationState) {
        GeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
