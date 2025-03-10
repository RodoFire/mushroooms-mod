package net.rodofire.mushrooomsmod.entity.client.model;

import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.SquirrelEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class SquirrelModel extends GeoModel<SquirrelEntity> {

    @Override
    public Identifier getModelResource(SquirrelEntity entity, @Nullable GeoRenderer<SquirrelEntity> geoRenderer) {
        return Identifier.of(MushrooomsMod.MOD_ID, "geo/squirrel.geo.json");
    }

    @Override
    public Identifier getTextureResource(SquirrelEntity entity, @Nullable GeoRenderer<SquirrelEntity> geoRenderer) {
        return Identifier.of(MushrooomsMod.MOD_ID, "textures/entity/squirrel.png");
    }

    @Override
    public Identifier getAnimationResource(SquirrelEntity animatable) {
        return Identifier.of(MushrooomsMod.MOD_ID, "animations/squirrel.animation.json");
    }
}
