package fr.rodofire.mushrooomsmod.entity.client.model;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.resources.ResourceLocation;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.entity.custom.InventoryArmorStandEntity;
import software.bernie.geckolib.model.GeoModel;

public class InventoryArmorStandModel extends GeoModel<InventoryArmorStandEntity> {
    @Override
    public ResourceLocation getModelResource(InventoryArmorStandEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "geo/inventory_armor_stand.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(InventoryArmorStandEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/entity/inventory_armor_stand.png");
    }

    @Override
    public ResourceLocation getAnimationResource(InventoryArmorStandEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "animations/inventory_armor_stand.animation.json");
    }
}
