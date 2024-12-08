package net.rodofire.mushrooomsmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.world.Heightmap;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;

public class ModEntityGeneration {
    public static void addSpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModOverworldBiomes.CRYSTAL_CAVE), SpawnGroup.CREATURE, ModEntities.CRYSTAL_GOLEM, 100, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModOverworldBiomes.CRYSTAL_CAVE), SpawnGroup.MONSTER, ModEntities.CRYSTAL_CREEPER, 150, 1, 4);

        spawnRestriction();
    }

    public static void spawnRestriction() {
        SpawnRestriction.register(ModEntities.CRYSTAL_GOLEM, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, GolemEntity::canMobSpawn);
        SpawnRestriction.register(ModEntities.CRYSTAL_CREEPER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
    }
}
