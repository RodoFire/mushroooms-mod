package net.rodofire.mushrooomsmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.LivingEntity;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.*;

public class ModEntitiesAttribute {
    public static void registerAttributes() {
        registerMonsters();
        registerAnimals();
        registerGolems();
        registerMisc();
        MushrooomsMod.LOGGER.info("|\tRegistering Entities Attributes");
    }
    public static void registerMonsters() {
        FabricDefaultAttributeRegistry.register(ModEntities.CRYSTAL_CREEPER, CustomCreeperEntity.createCreeperAttributes());
    }
    public static void registerAnimals() {
        FabricDefaultAttributeRegistry.register(ModEntities.GROKI, GrokiEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BOLETE_COW, BoleteCowEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.PLOTI, PlotiEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.SCHROOM_STICK, SchroomStickEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.SQUIRREL, SquirrelEntity.setAttributes());
    }
    public static void registerGolems() {
        FabricDefaultAttributeRegistry.register(ModEntities.CRYSTAL_GOLEM, CrystalGolemEntity.setAttributes());
    }
    public static void registerMisc(){
        FabricDefaultAttributeRegistry.register(ModEntities.INVENTORY_ARMOR_STAND_ENTITY, LivingEntity.createLivingAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.LOCKED_INVENTORY_ARMOR_STAND, LivingEntity.createLivingAttributes());
    }
}
