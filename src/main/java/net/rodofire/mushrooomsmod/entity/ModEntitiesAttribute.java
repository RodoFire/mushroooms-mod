package net.rodofire.mushrooomsmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.LivingEntity;
import net.rodofire.mushrooomsmod.entity.custom.*;

public class ModEntitiesAttribute {
    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.GROKI, GrokiEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BOLETE_COW, BoleteCowEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.PLOTI, PlotiEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CRYSTAL_CREEPER, CustomCreeperEntity.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CRYSTAL_GOLEM, CrystalGolemEntity.createCrystalGolemAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.SCHROOM_STICK, SchroomStickEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.INVENTORY_ARMOR_STAND_ENTITY, LivingEntity.createLivingAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.LOCKED_INVENTORY_ARMOR_STAND, LivingEntity.createLivingAttributes());
        //FabricDefaultAttributeRegistry.register(ModEntities.MOSQUITO_ENTITY, MosquitoEntity.setAttributes());
    }
}
