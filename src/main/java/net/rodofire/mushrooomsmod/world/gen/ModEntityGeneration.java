package net.rodofire.mushrooomsmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import net.rodofire.mushrooomsmod.entity.custom.*;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;

public class ModEntityGeneration {
    public static void addSpawn() {
        MushrooomsMod.LOGGER.info("|\t-Registering Entity Spawn");
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModOverworldBiomes.CRYSTAL_CAVE), SpawnGroup.CREATURE, ModEntities.CRYSTAL_GOLEM, 100, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModOverworldBiomes.CRYSTAL_CAVE), SpawnGroup.MONSTER, ModEntities.CRYSTAL_CREEPER, 150, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.TAIGA, BiomeKeys.FOREST), SpawnGroup.CREATURE, ModEntities.SQUIRREL, 10, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), SpawnGroup.CREATURE, ModEntities.PLOTI, 1500, 4, 20);
    }

    public static void spawnRestriction() {
        MushrooomsMod.LOGGER.info("|\t-Registering Spawn Restrictions");
        SpawnRestriction.register(ModEntities.CRYSTAL_GOLEM, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CrystalGolemEntity::canMobSpawn);
        SpawnRestriction.register(ModEntities.CRYSTAL_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

        SpawnRestriction.register(ModEntities.PLOTI, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PlotiEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.SCHROOM_STICK, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SchroomStickEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.BOLETE_COW, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, BoleteCowEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.SQUIRREL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SquirrelEntity::isValidNaturalSpawn);
    }
}
