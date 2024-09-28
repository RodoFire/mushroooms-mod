package net.rodofire.mushrooomsmod.world.biome.overworld;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.rodofire.mushrooomsmod.world.biome.ModBiomeFeatures;

public class ModOverworldBiomeCreator {
    static class SurFaceBiomes {
        public static Biome createShroomIsland1(Registerable<Biome> context) {
            SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

            spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));

            DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
            DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

            GenerationSettings.LookupBackedBuilder biomeBuilder =
                    new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                            context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
            DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

            biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);

            ModBiomeFeatures.SurfaceBiomes.addSchroomIsland1Features(biomeBuilder);

            return new Biome.Builder()
                    .precipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .spawnSettings(spawnBuilder.build())
                    .effects((new BiomeEffects.Builder())
                            .waterColor(0x3fceda)
                            .waterFogColor(0xbf1b26)
                            .skyColor(0x30c918)
                            .grassColor(0x7f03fc)
                            .foliageColor(0xd203fc)
                            .fogColor(0x22a1e6)
                            .moodSound(BiomeMoodSound.CAVE)
                            .build())
                    .build();
        }

        public static Biome createShroomIsland2(Registerable<Biome> context) {
            SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

            spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));

            DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
            DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

            GenerationSettings.LookupBackedBuilder biomeBuilder =
                    new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                            context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
            DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

            biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);

            ModBiomeFeatures.SurfaceBiomes.addSchroomIsland1Features(biomeBuilder);

            return new Biome.Builder()
                    .precipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .spawnSettings(spawnBuilder.build())
                    .effects((new BiomeEffects.Builder())
                            .waterColor(0x3fceda)
                            .waterFogColor(0xbf1b26)
                            .skyColor(0x30c918)
                            .grassColor(0x7f03fc)
                            .foliageColor(0xd203fc)
                            .fogColor(0x22a1e6)
                            .moodSound(BiomeMoodSound.CAVE)
                            .build())
                    .build();
        }

        public static Biome createSakuraForest(Registerable<Biome> context) {
            SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

            spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));

            DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
            DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

            GenerationSettings.LookupBackedBuilder biomeBuilder =
                    new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                            context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            ModBiomeFeatures.SurfaceBiomes.addSakuraForestFeatures(biomeBuilder);


            return new Biome.Builder()
                    .precipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .spawnSettings(spawnBuilder.build())
                    .effects((new BiomeEffects.Builder())
                            .waterColor(4159204)
                            .waterFogColor(329011)
                            .skyColor(0x8bc5fa)
                            .fogColor(12638463)
                            .moodSound(BiomeMoodSound.CAVE)
                            .build())

                    .build();
        }

        public static Biome createColorfulPlains(Registerable<Biome> context) {
            SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

            DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
            DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

            GenerationSettings.LookupBackedBuilder biomeBuilder =
                    new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                            context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

            biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
            biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_PLAIN);
            ModBiomeFeatures.SurfaceBiomes.addColorfulPlainsFeatures(biomeBuilder);

            return new Biome.Builder()
                    .precipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .spawnSettings(spawnBuilder.build())
                    .effects((new BiomeEffects.Builder())
                            .waterColor(0x29A7FF)
                            .waterFogColor(0x066AAF)
                            .skyColor(0x18A4E6)
                            .grassColor(0x69D54D)
                            .foliageColor(0x6CD152)
                            .fogColor(0x7BC5E8)
                            .moodSound(BiomeMoodSound.CAVE)
                            .build())
                    .build();
        }

        public static Biome createColorfulForest(Registerable<Biome> context) {
            SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

            DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
            DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

            GenerationSettings.LookupBackedBuilder biomeBuilder =
                    new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                            context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

            DefaultBiomeFeatures.addLandCarvers(biomeBuilder);
            DefaultBiomeFeatures.addAmethystGeodes(biomeBuilder);
            DefaultBiomeFeatures.addDungeons(biomeBuilder);
            DefaultBiomeFeatures.addSprings(biomeBuilder);
            DefaultBiomeFeatures.addFrozenTopLayer(biomeBuilder);
            DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

            ModBiomeFeatures.SurfaceBiomes.addColorfulForestFeatures(biomeBuilder);

            return new Biome.Builder()
                    .precipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .spawnSettings(spawnBuilder.build())
                    .effects((new BiomeEffects.Builder())
                            .waterColor(0x29A7FF)
                            .waterFogColor(0x066AAF)
                            .skyColor(0x18A4E6)
                            .grassColor(0x69D54D)
                            .foliageColor(0x6CD152)
                            .fogColor(0x7BC5E8)
                            .moodSound(BiomeMoodSound.CAVE)
                            .build())
                    .build();
        }

        public static Biome createBlueMushroomForest(Registerable<Biome> context) {
            SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();


            DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
            DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

            GenerationSettings.LookupBackedBuilder biomeBuilder =
                    new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                            context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            DefaultBiomeFeatures.addForestGrass(biomeBuilder);
            DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
            DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

            ModBiomeFeatures.SurfaceBiomes.addBlueMushroomForestFeatures(biomeBuilder);


            return new Biome.Builder()
                    .precipitation(true)
                    .temperature(0.7F)
                    .downfall(0.8F)
                    .generationSettings(biomeBuilder.build())
                    .spawnSettings(spawnBuilder.build())
                    .effects(
                            new BiomeEffects.Builder()
                                    .waterColor(4159204)
                                    .waterFogColor(329011)
                                    .fogColor(12638463)
                                    .skyColor(OverworldBiomeCreator.getSkyColor(0.7F))
                                    .grassColorModifier(BiomeEffects.GrassColorModifier.DARK_FOREST)
                                    .moodSound(BiomeMoodSound.CAVE)
                                    .build())
                    .build();
        }
    }


    static class UnderGroundBiomes {
        public static Biome createVanillaSchroomCave(Registerable<Biome> context) {
            SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

            DefaultBiomeFeatures.addMushroomMobs(spawnBuilder);

            GenerationSettings.LookupBackedBuilder biomeBuilder =
                    new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                            context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

            ModBiomeFeatures.UndergroundBiome.addMushroomCaveFeatures(biomeBuilder);

            return new Biome.Builder()
                    .precipitation(true)
                    .downfall(0.3f)
                    .temperature(0.5f)
                    .generationSettings(biomeBuilder.build())
                    .spawnSettings(spawnBuilder.build())
                    .effects((new BiomeEffects.Builder())
                            .waterColor(4159204)
                            .waterFogColor(329011)
                            .skyColor(0x18A4E6)
                            .fogColor(0x7BC5E8)
                            .build())
                    .build();
        }

        public static Biome createCrystalCave(Registerable<Biome> context) {
            SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();


            DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
            DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

            GenerationSettings.LookupBackedBuilder biomeBuilder =
                    new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                            context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            ModBiomeFeatures.UndergroundBiome.addCrystalCaveFeatures(biomeBuilder);

            biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);


            return new Biome.Builder()
                    .precipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .spawnSettings(spawnBuilder.build())
                    .effects((new BiomeEffects.Builder())
                            .waterColor(4159204)
                            .waterFogColor(329011)
                            .skyColor(0x30c918)
                            .fogColor(12638463)
                            .moodSound(BiomeMoodSound.CAVE)
                            .build())
                    .build();
        }

        public static Biome createForestCave(Registerable<Biome> context) {
            SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

            DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);

            GenerationSettings.LookupBackedBuilder biomeBuilder =
                    new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                            context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

            ModBiomeFeatures.UndergroundBiome.addForestCaveFeatures(biomeBuilder);

            return new Biome.Builder()
                    .precipitation(true)
                    .downfall(0.3f)
                    .temperature(0.5f)
                    .generationSettings(biomeBuilder.build())
                    .spawnSettings(spawnBuilder.build())
                    .effects((new BiomeEffects.Builder())
                            .waterColor(4159204)
                            .waterFogColor(329011)
                            .skyColor(0x18A4E6)
                            .fogColor(0x7BC5E8)
                            .build())
                    .build();
        }

        public static Biome createBlueLuminescentShroomCave(Registerable<Biome> context) {
            SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();


            DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
            DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

            GenerationSettings.LookupBackedBuilder biomeBuilder =
                    new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                            context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);

            biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);

            ModBiomeFeatures.UndergroundBiome.addBlueLuminescentCaveFlowers(biomeBuilder);

            return new Biome.Builder()
                    .precipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .spawnSettings(spawnBuilder.build())
                    .effects((new BiomeEffects.Builder())
                            .waterColor(4159204)
                            .waterFogColor(329011)
                            .skyColor(0x30c918)
                            .fogColor(12638463)
                            .moodSound(BiomeMoodSound.CAVE)
                            .build())
                    .build();
        }

        public static Biome createPurpleSchroomCave(Registerable<Biome> context) {
            SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

            spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));

            DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
            DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

            GenerationSettings.LookupBackedBuilder biomeBuilder =
                    new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                            context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            ModBiomeFeatures.UndergroundBiome.addPurpleSchroomCaveFeatures(biomeBuilder);

            return new Biome.Builder()
                    .precipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .spawnSettings(spawnBuilder.build())
                    .effects((new BiomeEffects.Builder())
                            .waterColor(0x3fceda)
                            .waterFogColor(0xbf1b26)
                            .skyColor(0x90a8b4)
                            .grassColor(0x6d7521)
                            .foliageColor(0xe597c1)
                            .fogColor(0xecc9cd)
                            .build())
                    .build();
        }
    }
}
