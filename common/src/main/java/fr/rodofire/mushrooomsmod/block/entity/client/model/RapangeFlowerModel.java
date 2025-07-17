package fr.rodofire.mushrooomsmod.block.entity.client.model;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.resources.ResourceLocation;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.block.entity.RapangeFlowersBE;
import software.bernie.geckolib.model.GeoModel;

public class RapangeFlowerModel extends GeoModel<RapangeFlowersBE> {
    @Override
    public ResourceLocation getModelResource(RapangeFlowersBE animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "geo/rapange_flower.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RapangeFlowersBE animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/block/rapange_flowers.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RapangeFlowersBE animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "animations/rapange_flower.animation.json");
    }
}
