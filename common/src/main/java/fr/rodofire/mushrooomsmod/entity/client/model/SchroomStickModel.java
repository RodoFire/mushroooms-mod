package fr.rodofire.mushrooomsmod.entity.client.model;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.resources.ResourceLocation;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.entity.custom.SchroomStickEntity;
import software.bernie.geckolib.model.GeoModel;

public class SchroomStickModel extends GeoModel<SchroomStickEntity> {
    @Override
    public ResourceLocation getModelResource(SchroomStickEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "geo/schroom_stick.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SchroomStickEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/entity/schroom_stick.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SchroomStickEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "animations/schroom_stick.animation.json");
    }
}
