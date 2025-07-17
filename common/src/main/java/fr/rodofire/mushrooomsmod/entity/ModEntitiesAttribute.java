package fr.rodofire.mushrooomsmod.entity;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.entity.custom.*;
import fr.rodofire.mushrooomsmod.platform.Services;
import net.minecraft.world.entity.LivingEntity;

public class ModEntitiesAttribute {
    public static void registerAttributes() {
        registerMonsters();
        registerAnimals();
        registerGolems();
        registerMisc();
        MushrooomsModConstants.LOGGER.info("|\t-Registering Entities Attributes");
    }
    public static void registerMonsters() {
        Services.PLATFORM.registerEntityAtributes(ModEntities.CRYSTAL_CREEPER, CustomCreeperEntity.createCreeperAttributes());
    }
    public static void registerAnimals() {
        Services.PLATFORM.registerEntityAtributes(ModEntities.GROKI, GrokiEntity.setAttributes());
        Services.PLATFORM.registerEntityAtributes(ModEntities.BOLETE_COW, BoleteCowEntity.setAttributes());
        Services.PLATFORM.registerEntityAtributes(ModEntities.PLOTI, PlotiEntity.setAttributes());
        Services.PLATFORM.registerEntityAtributes(ModEntities.SCHROOM_STICK, SchroomStickEntity.setAttributes());
        Services.PLATFORM.registerEntityAtributes(ModEntities.SQUIRREL, SquirrelEntity.setAttributes());
    }
    public static void registerGolems() {
        Services.PLATFORM.registerEntityAtributes(ModEntities.CRYSTAL_GOLEM, CrystalGolemEntity.setAttributes());
    }
    public static void registerMisc(){
        Services.PLATFORM.registerEntityAtributes(ModEntities.INVENTORY_ARMOR_STAND_ENTITY, LivingEntity.createLivingAttributes());
        Services.PLATFORM.registerEntityAtributes(ModEntities.LOCKED_INVENTORY_ARMOR_STAND, LivingEntity.createLivingAttributes());
    }
}
