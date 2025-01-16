package net.rodofire.mushrooomsmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.*;

public class ModEntities {
    /* ---------- Monsters ---------- */
    public static final EntityType<CrystalCreeperEntity> CRYSTAL_CREEPER = register("crystal_creeper", CrystalCreeperEntity::new, SpawnGroup.MONSTER, 0.6f, 1.7f);

    /* ---------- Animals ---------- */
    public static final EntityType<GrokiEntity> GROKI = register("groki",GrokiEntity::new, SpawnGroup.AMBIENT, 0.9f, 1.45f);
    public static final EntityType<BoleteCowEntity> BOLETE_COW = register("bolete_cow",BoleteCowEntity::new, SpawnGroup.AMBIENT, 1.3f, 1.8f);
    public static final EntityType<PlotiEntity> PLOTI = register("ploti", PlotiEntity::new, SpawnGroup.AMBIENT, 0.25f, 0.3f);
    public static final EntityType<SchroomStickEntity> SCHROOM_STICK = register("schroom_stick",SchroomStickEntity::new, SpawnGroup.AMBIENT, 0.4f, 1.6f);
    public static final EntityType<SquirrelEntity> SQUIRREL = register("squirrel", SquirrelEntity::new, SpawnGroup.CREATURE, 0.5f, 0.6f);

    /* ---------- Golems ---------- */
    public static final EntityType<CrystalGolemEntity> CRYSTAL_GOLEM = register("crystal_golem",CrystalGolemEntity::new, SpawnGroup.CREATURE, 1.2f, 2.8f);

    /* ---------- Misc ---------- */
    public static final EntityType<InventoryArmorStandEntity> INVENTORY_ARMOR_STAND_ENTITY = register("inventory_armor_stand",InventoryArmorStandEntity::new, SpawnGroup.MISC, 0.9f, 1.8f);
    public static final EntityType<LockedInventoryArmorStand> LOCKED_INVENTORY_ARMOR_STAND = register("locked_inventory_armor_stand", LockedInventoryArmorStand::new, SpawnGroup.MISC, 0.9f, 1.8f);

    /*public static final EntityType<MosquitoEntity> MOSQUITO_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MushrooomsMod.MOD_ID, "mosquito"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, MosquitoEntity::new)
                    .dimensions(EntityDimensions.fixed(0.2f, 0.5f)).build());*/


    public static <T extends Entity> EntityType<T> register(String name, EntityType.EntityFactory<T> factory, SpawnGroup spawngroup, float width, float height){
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MushrooomsMod.MOD_ID, name));
        return Registry.register(Registries.ENTITY_TYPE, key, FabricEntityTypeBuilder.create(spawngroup,factory).dimensions(EntityDimensions.fixed(width, height)).build());
    }

    public static void registerModENtities(){
        MushrooomsMod.LOGGER.info("|\tRegistering Entities.");
    }

    public static void spawnRestriction() {
        MushrooomsMod.LOGGER.info("|\t-Registering Spawn Restrictions.");
        SpawnRestriction.register(ModEntities.CRYSTAL_GOLEM, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CrystalGolemEntity::canMobSpawn);
        SpawnRestriction.register(ModEntities.CRYSTAL_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

        SpawnRestriction.register(ModEntities.PLOTI, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PlotiEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.SCHROOM_STICK, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SchroomStickEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.BOLETE_COW, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, BoleteCowEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.SQUIRREL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SquirrelEntity::isValidNaturalSpawn);
    }

}
