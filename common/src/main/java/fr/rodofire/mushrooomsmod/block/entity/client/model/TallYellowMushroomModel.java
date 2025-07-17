package fr.rodofire.mushrooomsmod.block.entity.client.model;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.resources.ResourceLocation;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.block.entity.TallYellowMushroomsBE;
import software.bernie.geckolib.model.GeoModel;

public class TallYellowMushroomModel extends GeoModel<TallYellowMushroomsBE> {
    @Override
    public ResourceLocation getModelResource(TallYellowMushroomsBE tallYellowMushroomsBE) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "geo/tall_yellow_mushrooms.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TallYellowMushroomsBE tallYellowMushroomsBE) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/block/tall_yellow_mushrooms.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TallYellowMushroomsBE tallYellowMushroomsBE) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "animations/tall_yellow_mushrooms.animation.json");
    }
}
