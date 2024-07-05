package net.rodofire.mushrooomsmod.entity.client.model;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.PlotiEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class PlotiModel extends GeoModel<PlotiEntity> {
    @Override
    public Identifier getModelResource(PlotiEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "geo/ploti.geo.json");
    }

    @Override
    public Identifier getTextureResource(PlotiEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "textures/entity/ploti");
    }

    @Override
    public Identifier getAnimationResource(PlotiEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "animations/ploti.animation.json");
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