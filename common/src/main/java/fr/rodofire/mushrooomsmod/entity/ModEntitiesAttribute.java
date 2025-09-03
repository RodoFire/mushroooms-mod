package fr.rodofire.mushrooomsmod.entity;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.entity.custom.*;
import fr.rodofire.mushrooomsmod.platform.Services;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;

public class ModEntitiesAttribute {
    public static AttributeSupplier.Builder CRYSTAL_CREEPER;
    public static AttributeSupplier.Builder GROKI;

    // Centralisation des autres attributs d'entités ici
    public static AttributeSupplier.Builder BOLETE_COW;
    public static AttributeSupplier.Builder PLOTI;
    public static AttributeSupplier.Builder SCHROOM_STICK;
    public static AttributeSupplier.Builder SQUIRREL;
    public static AttributeSupplier.Builder CRYSTAL_GOLEM;

    public static void registerAttributes() {
        registerAtributes();
        registerMonsters();
        registerAnimals();
        registerGolems();
        registerMisc();
        MushrooomsModConstants.LOGGER.info("|\t-Registering Entities Attributes");
    }

    public static void registerAtributes(){
        // Attributs explicitement définis ici
        CRYSTAL_CREEPER = Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.MAX_HEALTH, 10.0D);

        GROKI = Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.35f);

        BOLETE_COW = Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.45f);

        PLOTI = Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25f);
        SCHROOM_STICK = Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.8f);
        SQUIRREL = Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 12.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.6f);
        CRYSTAL_GOLEM = AbstractGolem.createLivingAttributes().add(Attributes.MOVEMENT_SPEED, 0.2f)
                .add(Attributes.MAX_HEALTH, 70.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 2.5)
                .add(Attributes.ATTACK_DAMAGE, 15.0)
                .add(Attributes.FOLLOW_RANGE, 54.5);
    }

    public static void registerMonsters() {
        Services.PLATFORM.registerEntityAtributes(ModEntities.CRYSTAL_CREEPER, CRYSTAL_CREEPER);
    }

    public static void registerAnimals() {
        Services.PLATFORM.registerEntityAtributes(ModEntities.GROKI, GROKI);
        Services.PLATFORM.registerEntityAtributes(ModEntities.BOLETE_COW, BOLETE_COW);
        Services.PLATFORM.registerEntityAtributes(ModEntities.PLOTI, PLOTI);
        Services.PLATFORM.registerEntityAtributes(ModEntities.SCHROOM_STICK, SCHROOM_STICK);
        Services.PLATFORM.registerEntityAtributes(ModEntities.SQUIRREL, SQUIRREL);
    }

    public static void registerGolems() {
        Services.PLATFORM.registerEntityAtributes(ModEntities.CRYSTAL_GOLEM, CRYSTAL_GOLEM);
    }

    public static void registerMisc(){
        Services.PLATFORM.registerEntityAtributes(ModEntities.INVENTORY_ARMOR_STAND_ENTITY, LivingEntity.createLivingAttributes());
        Services.PLATFORM.registerEntityAtributes(ModEntities.LOCKED_INVENTORY_ARMOR_STAND, LivingEntity.createLivingAttributes());
    }
}
