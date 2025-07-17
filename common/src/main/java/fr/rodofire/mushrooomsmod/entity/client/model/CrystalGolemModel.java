package fr.rodofire.mushrooomsmod.entity.client.model;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.entity.custom.CrystalGolemEntity;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CrystalGolemModel extends GeoModel<CrystalGolemEntity> {
    @Override
    public ResourceLocation getModelResource(CrystalGolemEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "geo/crystal_golem.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CrystalGolemEntity animatable) {

        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/entity/crystal_golem.png");

    }

    @Override
    public ResourceLocation getAnimationResource(CrystalGolemEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "animations/crystal_golem.animation.json");
    }

    @Override
    public void setCustomAnimations(CrystalGolemEntity animatable, long instanceId, AnimationState<CrystalGolemEntity> animationState) {
        GeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
