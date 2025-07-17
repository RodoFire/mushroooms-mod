package fr.rodofire.mushrooomsmod.world.biome.overworld;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import fr.rodofire.mushrooomsmod.world.biome.ModBiomeFeatures;

public class ModOverworldBiomeCreator {
    static class SurFaceBiomes {
        public static Biome createMushroomShire(BootstrapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


            BiomeDefaultFeatures.farmAnimals(spawnBuilder);

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                            context.lookup(Registries.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

            ModBiomeFeatures.SurfaceBiomes.addMushroomShireFeatures(biomeBuilder);

            return new Biome.BiomeBuilder()
                    .hasPrecipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .mobSpawnSettings(spawnBuilder.build())
                    .specialEffects((new BiomeSpecialEffects.Builder())
                            .waterColor(0x6fb1ec)
                            .waterFogColor(0xc2def6)
                            .skyColor(0x84d7f6)
                            .foliageColorOverride(0xd203fc)
                            .fogColor(0xc2e9f6)
                            .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                            .build())
                    .build();
        }

        public static Biome createMysticMushGrove(BootstrapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

            spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

            BiomeDefaultFeatures.farmAnimals(spawnBuilder);

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                            context.lookup(Registries.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            BiomeDefaultFeatures.addDefaultOres(biomeBuilder);


            ModBiomeFeatures.SurfaceBiomes.addMysticMushGrove(biomeBuilder);

            return new Biome.BiomeBuilder()
                    .hasPrecipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .mobSpawnSettings(spawnBuilder.build())
                    .specialEffects((new BiomeSpecialEffects.Builder())
                            .waterColor(0x3fceda)
                            .waterFogColor(0xbf1b26)
                            .skyColor(0xa8fffb)
                            .grassColorOverride(0x91ff8b)
                            .foliageColorOverride(0x91ff8b)
                            .fogColor(0xc3fffc)
                            .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                            .build())
                    .build();
        }

        public static Biome createGoldenMycoShroom(BootstrapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

            spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

            BiomeDefaultFeatures.farmAnimals(spawnBuilder);

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                            context.lookup(Registries.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            BiomeDefaultFeatures.addDefaultOres(biomeBuilder);


            ModBiomeFeatures.SurfaceBiomes.addGoldenMycoShroom(biomeBuilder);

            return new Biome.BiomeBuilder()
                    .hasPrecipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .mobSpawnSettings(spawnBuilder.build())
                    .specialEffects((new BiomeSpecialEffects.Builder())
                            .waterColor(0x29A7FF)
                            .waterFogColor(0x066AAF)
                            .skyColor(0x18A4E6)
                            .grassColorOverride(0xDAA520)
                            .foliageColorOverride(0xFFD700)
                            .fogColor(0x7BC5E8)
                            .build())
                    .build();
        }

        public static Biome createSakuraForest(BootstrapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

            spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

            BiomeDefaultFeatures.farmAnimals(spawnBuilder);
            BiomeDefaultFeatures.commonSpawns(spawnBuilder);

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                            context.lookup(Registries.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            ModBiomeFeatures.SurfaceBiomes.addSakuraForestFeatures(biomeBuilder);


            return new Biome.BiomeBuilder()
                    .hasPrecipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .mobSpawnSettings(spawnBuilder.build())
                    .specialEffects((new BiomeSpecialEffects.Builder())
                            .waterColor(4159204)
                            .waterFogColor(329011)
                            .skyColor(0x8bc5fa)
                            .fogColor(12638463)
                            .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                            .build())

                    .build();
        }

        public static Biome createColorfulPlains(BootstrapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

            BiomeDefaultFeatures.farmAnimals(spawnBuilder);
            BiomeDefaultFeatures.commonSpawns(spawnBuilder);

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                            context.lookup(Registries.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS);
            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_PLAIN);
            ModBiomeFeatures.SurfaceBiomes.addColorfulPlainsFeatures(biomeBuilder);

            return new Biome.BiomeBuilder()
                    .hasPrecipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .mobSpawnSettings(spawnBuilder.build())
                    .specialEffects((new BiomeSpecialEffects.Builder())
                            .waterColor(0x29A7FF)
                            .waterFogColor(0x066AAF)
                            .skyColor(0x18A4E6)
                            .grassColorOverride(0x69D54D)
                            .foliageColorOverride(0x6CD152)
                            .fogColor(0x7BC5E8)
                            .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                            .build())
                    .build();
        }

        public static Biome createColorfulForest(BootstrapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

            BiomeDefaultFeatures.farmAnimals(spawnBuilder);
            BiomeDefaultFeatures.commonSpawns(spawnBuilder);

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                            context.lookup(Registries.CONFIGURED_CARVER));

            BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeBuilder);
            BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder);
            BiomeDefaultFeatures.addDefaultMonsterRoom(biomeBuilder);
            BiomeDefaultFeatures.addDefaultSprings(biomeBuilder);
            BiomeDefaultFeatures.addSurfaceFreezing(biomeBuilder);
            BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

            ModBiomeFeatures.SurfaceBiomes.addColorfulForestFeatures(biomeBuilder);

            return new Biome.BiomeBuilder()
                    .hasPrecipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .mobSpawnSettings(spawnBuilder.build())
                    .specialEffects((new BiomeSpecialEffects.Builder())
                            .waterColor(0x29A7FF)
                            .waterFogColor(0x066AAF)
                            .skyColor(0x18A4E6)
                            .grassColorOverride(0x69D54D)
                            .foliageColorOverride(0x6CD152)
                            .fogColor(0x7BC5E8)
                            .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                            .build())
                    .build();
        }

        public static Biome createBlueMushroomForest(BootstrapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


            BiomeDefaultFeatures.farmAnimals(spawnBuilder);
            BiomeDefaultFeatures.commonSpawns(spawnBuilder);

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                            context.lookup(Registries.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            BiomeDefaultFeatures.addForestGrass(biomeBuilder);
            BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
            BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

            ModBiomeFeatures.SurfaceBiomes.addBlueMushroomForestFeatures(biomeBuilder);


            return new Biome.BiomeBuilder()
                    .hasPrecipitation(true)
                    .temperature(0.7F)
                    .downfall(0.8F)
                    .generationSettings(biomeBuilder.build())
                    .mobSpawnSettings(spawnBuilder.build())
                    .specialEffects(
                            new BiomeSpecialEffects.Builder()
                                    .waterColor(4159204)
                                    .waterFogColor(329011)
                                    .fogColor(12638463)
                                    .skyColor(OverworldBiomes.calculateSkyColor(0.7F))
                                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.DARK_FOREST)
                                    .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                    .build())
                    .build();
        }
    }


    static class UnderGroundBiomes {
        public static Biome createVanillaSchroomCave(BootstrapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

            BiomeDefaultFeatures.mooshroomSpawns(spawnBuilder);

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                            context.lookup(Registries.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

            ModBiomeFeatures.UndergroundBiome.addMushroomCaveFeatures(biomeBuilder);

            return new Biome.BiomeBuilder()
                    .hasPrecipitation(true)
                    .downfall(0.3f)
                    .temperature(0.5f)
                    .generationSettings(biomeBuilder.build())
                    .mobSpawnSettings(spawnBuilder.build())
                    .specialEffects((new BiomeSpecialEffects.Builder())
                            .waterColor(4159204)
                            .waterFogColor(329011)
                            .skyColor(0x18A4E6)
                            .fogColor(0x7BC5E8)
                            .build())
                    .build();
        }

        public static Biome createCrystalCave(BootstrapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


            BiomeDefaultFeatures.farmAnimals(spawnBuilder);
            BiomeDefaultFeatures.commonSpawns(spawnBuilder);

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                            context.lookup(Registries.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            ModBiomeFeatures.UndergroundBiome.addCrystalCaveFeatures(biomeBuilder);

            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS);


            return new Biome.BiomeBuilder()
                    .hasPrecipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .mobSpawnSettings(spawnBuilder.build())
                    .specialEffects((new BiomeSpecialEffects.Builder())
                            .waterColor(4159204)
                            .waterFogColor(329011)
                            .skyColor(0x30c918)
                            .fogColor(12638463)
                            .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                            .build())
                    .build();
        }

        public static Biome createForestCave(BootstrapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

            BiomeDefaultFeatures.farmAnimals(spawnBuilder);

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                            context.lookup(Registries.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

            ModBiomeFeatures.UndergroundBiome.addForestCaveFeatures(biomeBuilder);

            return new Biome.BiomeBuilder()
                    .hasPrecipitation(true)
                    .downfall(0.3f)
                    .temperature(0.5f)
                    .generationSettings(biomeBuilder.build())
                    .mobSpawnSettings(spawnBuilder.build())
                    .specialEffects((new BiomeSpecialEffects.Builder())
                            .waterColor(4159204)
                            .waterFogColor(329011)
                            .skyColor(0x18A4E6)
                            .fogColor(0x7BC5E8)
                            .build())
                    .build();
        }

        public static Biome createRockyCave(BootstrapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                            context.lookup(Registries.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

            ModBiomeFeatures.UndergroundBiome.addRockyCaveFeatures(biomeBuilder);

            return new Biome.BiomeBuilder()
                    .hasPrecipitation(true)
                    .downfall(0.3f)
                    .temperature(0.5f)
                    .generationSettings(biomeBuilder.build())
                    .mobSpawnSettings(spawnBuilder.build())
                    .specialEffects((new BiomeSpecialEffects.Builder())
                            .waterColor(4159204)
                            .waterFogColor(329011)
                            .skyColor(0x18A4E6)
                            .fogColor(0x7BC5E8)
                            .build())
                    .build();
        }

        public static Biome createMossyCave(BootstrapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                            context.lookup(Registries.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

            ModBiomeFeatures.UndergroundBiome.addMossyCaveFeatures(biomeBuilder);

            return new Biome.BiomeBuilder()
                    .hasPrecipitation(true)
                    .downfall(0.9f)
                    .temperature(0.95f)
                    .generationSettings(biomeBuilder.build())
                    .mobSpawnSettings(spawnBuilder.build())
                    .specialEffects((new BiomeSpecialEffects.Builder())
                            .waterColor(4159204)
                            .waterFogColor(329011)
                            .skyColor(0x18A4E6)
                            .fogColor(0x7BC5E8)
                            .build())
                    .build();
        }


        public static Biome createBlueLuminescentShroomCave(BootstrapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


            BiomeDefaultFeatures.farmAnimals(spawnBuilder);
            BiomeDefaultFeatures.commonSpawns(spawnBuilder);

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                            context.lookup(Registries.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);

            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS);

            ModBiomeFeatures.UndergroundBiome.addBlueLuminescentCaveFlowers(biomeBuilder);

            return new Biome.BiomeBuilder()
                    .hasPrecipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .mobSpawnSettings(spawnBuilder.build())
                    .specialEffects((new BiomeSpecialEffects.Builder())
                            .waterColor(4159204)
                            .waterFogColor(329011)
                            .skyColor(0x30c918)
                            .fogColor(12638463)
                            .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                            .build())
                    .build();
        }

        public static Biome createPurpleSchroomCave(BootstrapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

            spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

            BiomeDefaultFeatures.farmAnimals(spawnBuilder);
            BiomeDefaultFeatures.commonSpawns(spawnBuilder);

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                            context.lookup(Registries.CONFIGURED_CARVER));

            ModBiomeFeatures.globalOverworldGeneration(biomeBuilder);
            ModBiomeFeatures.UndergroundBiome.addPurpleSchroomCaveFeatures(biomeBuilder);

            return new Biome.BiomeBuilder()
                    .hasPrecipitation(true)
                    .downfall(0.4f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .mobSpawnSettings(spawnBuilder.build())
                    .specialEffects((new BiomeSpecialEffects.Builder())
                            .waterColor(0x3fceda)
                            .waterFogColor(0xbf1b26)
                            .skyColor(0x90a8b4)
                            .grassColorOverride(0x6d7521)
                            .foliageColorOverride(0xe597c1)
                            .fogColor(0xecc9cd)
                            .build())
                    .build();
        }
    }
}
