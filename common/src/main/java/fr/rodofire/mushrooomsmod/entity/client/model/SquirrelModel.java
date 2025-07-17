package fr.rodofire.mushrooomsmod.entity.client.model;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.resources.ResourceLocation;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.entity.custom.SquirrelEntity;
import software.bernie.geckolib.model.GeoModel;

public class SquirrelModel extends GeoModel<SquirrelEntity> {
    @Override
    public ResourceLocation getModelResource(SquirrelEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "geo/squirrel.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SquirrelEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/entity/squirrel.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SquirrelEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "animations/squirrel.animation.json");
    }
}
