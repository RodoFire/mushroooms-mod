package net.rodofire.mushrooomsmod.entity.client.model;

import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.SquirrelEntity;
import software.bernie.geckolib.model.GeoModel;

public class SquirrelModel extends GeoModel<SquirrelEntity> {
    @Override
    public Identifier getModelResource(SquirrelEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "geo/squirrel.geo.json");
    }

    @Override
    public Identifier getTextureResource(SquirrelEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "textures/entity/squirrel.png");
    }

    @Override
    public Identifier getAnimationResource(SquirrelEntity animatable) {
        return new Identifier(MushrooomsMod.MOD_ID, "animations/squirrel.animation.json");
    }
}
