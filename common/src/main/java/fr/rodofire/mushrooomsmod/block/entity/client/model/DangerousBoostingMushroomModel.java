package fr.rodofire.mushrooomsmod.block.entity.client.model;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.resources.ResourceLocation;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.block.entity.DangerousBoostingMushroomBE;
import software.bernie.geckolib.model.GeoModel;

public class DangerousBoostingMushroomModel extends GeoModel<DangerousBoostingMushroomBE> {
    @Override
    public ResourceLocation getModelResource(DangerousBoostingMushroomBE animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "geo/mushroom_boost.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DangerousBoostingMushroomBE animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/block/mushroom_boost.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DangerousBoostingMushroomBE animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "animations/mushroom_boost.animation.json");
    }
}
