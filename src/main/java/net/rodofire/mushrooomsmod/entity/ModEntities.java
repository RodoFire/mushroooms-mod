package net.rodofire.mushrooomsmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.*;

public class ModEntities {
    public static final EntityType<GrokiEntity> GROKI = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID, "groki"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GrokiEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 1.45f)).build());

    public static final EntityType<BoleteCowEntity> BOLETE_COW = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID, "bolete_cow"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BoleteCowEntity::new)
                    .dimensions(EntityDimensions.fixed(1.3f, 1.8f)).build());

    public static final EntityType<PlotiEntity> PLOTI = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID, "ploti"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PlotiEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.3f)).build());

    public static final EntityType<CrystalCreeperEntity> CRYSTAL_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID, "crystal_creeper"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CrystalCreeperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.7f)).build());

    public static final EntityType<CrystalGolemEntity> CRYSTAL_GOLEM = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID, "crystal_golem"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CrystalGolemEntity::new)
                    .dimensions(EntityDimensions.fixed(1.2f,2.8f)).build());

    public static final EntityType<SchroomStickEntity> SCHROOM_STICK = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID, "schroom_stick"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SchroomStickEntity::new)
                    .dimensions(EntityDimensions.fixed(0.3f,1.6f)).build());

    public static final EntityType<InventoryArmorStandEntity> INVENTORY_ARMOR_STAND_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID, "inventory_armor_stand"), FabricEntityTypeBuilder.create(SpawnGroup.MISC, InventoryArmorStandEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 1.8f)).build());
    public static final EntityType<LockedInventoryArmorStand> LOCKED_INVENTORY_ARMOR_STAND = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID, "locked_inventory_armor_stand"), FabricEntityTypeBuilder.create(SpawnGroup.MISC, LockedInventoryArmorStand::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 1.8f)).build());

    /*public static final EntityType<MosquitoEntity> MOSQUITO_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID, "mosquito"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, MosquitoEntity::new)
                    .dimensions(EntityDimensions.fixed(0.2f, 0.5f)).build());*/




    public static void registerModENtities(){
        MushrooomsMod.LOGGER.info("Registering Mod Entities For Mushrooomsmod");
    }

}
