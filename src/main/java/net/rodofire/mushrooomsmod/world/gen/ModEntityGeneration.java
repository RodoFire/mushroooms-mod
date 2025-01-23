package net.rodofire.mushrooomsmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.BiomeKeys;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;

public class ModEntityGeneration {
    public static void addSpawn() {
        MushrooomsMod.LOGGER.info("|\t-Registering Entity Spawn.");
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModOverworldBiomes.CRYSTAL_CAVE), SpawnGroup.CREATURE, ModEntities.CRYSTAL_GOLEM, 100, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModOverworldBiomes.CRYSTAL_CAVE), SpawnGroup.MONSTER, ModEntities.CRYSTAL_CREEPER, 150, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.TAIGA, BiomeKeys.FOREST), SpawnGroup.CREATURE, ModEntities.SQUIRREL, 10, 1, 2);
    }
}
