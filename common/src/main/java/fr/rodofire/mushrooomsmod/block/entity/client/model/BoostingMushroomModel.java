package fr.rodofire.mushrooomsmod.block.entity.client.model;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.resources.ResourceLocation;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.block.entity.BoostingMushroomBE;
import software.bernie.geckolib.model.GeoModel;

public class BoostingMushroomModel extends GeoModel<BoostingMushroomBE> {
    @Override
    public ResourceLocation getModelResource(BoostingMushroomBE animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "geo/mushroom_boost.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BoostingMushroomBE animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/block/mushroom_boost.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BoostingMushroomBE animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "animations/mushroom_boost.animation.json");
    }
}
