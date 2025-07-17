package fr.rodofire.mushrooomsmod.world.biome;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import fr.rodofire.mushrooomsmod.world.features.placedfeatures.ModSurfacePlacedFeatures;
import fr.rodofire.mushrooomsmod.world.features.placedfeatures.ModUndergroundPlacedFeatures;

/**
 * Class to manage custom biomes related features
 */
public class ModBiomeFeatures {

    /**
     * method for the default biomes features such as ores / carvers / dungeons ...
     */
    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static class SurfaceBiomes {

        public static void addColorfulPlainsFeatures(BiomeGenerationSettings.Builder builder) {
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.COLORFUL_BUSH);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PURPLE_PERENNIAL);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PINK_PERENNIAL);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.GREEN_PERENNIAL);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.ORANGE_PERENNIAL);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LUMINESCENT_PERENNIAL);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.YELLOW_PERENNIAL);
        }

        public static void addColorfulForestFeatures(BiomeGenerationSettings.Builder builder) {
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.COLORFUL_TREE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_PLAIN);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_PURPLE_PERENNIAL);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_PINK_PERENNIAL);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_GREEN_PERENNIAL);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_ORANGE_PERENNIAL);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_LUMINESCENT_PERENNIAL);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_YELLOW_PERENNIAL);
        }

        public static void addMushroomShireFeatures(BiomeGenerationSettings.Builder builder) {
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.ORANGE_MUSHROOM_TREE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.GREEN_MUSHROOM_TREE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.CRYING_GREEN_MUSHROOM_TREE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LIGHT_GREEN_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LIGHT_ORANGE_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LIGHT_YELLOW_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LIGHT_GRASS);

            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.TINY_GREEN_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LITTLE_GREEN_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.MEDIUM_GREEN_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.BIG_GREEN_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.BIG_GREEN_MUSHROOM_PLANT);
        }

        public static void addMysticMushGrove(BiomeGenerationSettings.Builder builder) {
            //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PURPLE_MUSHROOM_TREE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.RED_MUSHROOM_TREE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.BROWN_MUSHROOM_TREE);

            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.BIG_PURPLE_MUSHROOM_PLANT);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.TINY_PURPLE_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LITTLE_PURPLE_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.MEDIUM_PURPLE_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.BIG_PURPLE_MUSHROOM);

            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LIGHT_TINY_LILAC);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LIGHT_APAGANTHE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LIGHT_WYSTERIA);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LIGHT_BLUEBELL);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LIGHT_ACONIT);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LIGHT_PERVENCHE);
        }

        public static void addGoldenMycoShroom(BiomeGenerationSettings.Builder builder) {
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SINUSO_SHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LIGHT_YELLOW_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LIGHT_GRASS);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LIGHT_RAPANGE_FLOWERS);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.BUSHY_YELLOW_MUSHROOMS);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.BRIGHT_YELLOW_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.YELICE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.TURQUOSUM_STILUS);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.NOCTULICA);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_YELLOW_PERENNIAL);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.FLAMESTHYSIA);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.MUSHROOM_TALL_YELLOW);
        }

        public static void addBlueMushroomForestFeatures(BiomeGenerationSettings.Builder builder) {
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.BLUE_MUSHROOM_TREE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SPIRAL_MUSHROOM_FEATURE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PERVENCHE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PICK_BLUE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.JACYNTHE);
        }

        public static void addMagicalPlainsFeatures(BiomeGenerationSettings.Builder builder) {

        }

        public static void addSakuraForestFeatures(BiomeGenerationSettings.Builder builder) {
            builder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, ModSurfacePlacedFeatures.SAKURA_ROCK_STRAIGHT);
            builder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, ModSurfacePlacedFeatures.SAKURA_ROCK_FLAT);
            builder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, ModSurfacePlacedFeatures.SAKURA_ARCH);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.CHERRY_BLOSSOM_TREE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PELTOGYNE_TREE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_PLAIN);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PINK_HEATER);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.DIANTHUS);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.HYDRANGEA);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PINK_PERENNIAL);
        }
    }


    public static class UndergroundBiome {

        public static void addBlueLuminescentCaveFlowers(BiomeGenerationSettings.Builder builder) {
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_TREE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_MUSHROOM_TREE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_VINES_UP);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.FUTIALI);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.CYANEA);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.NOCTULICA);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.TURQUOSUM_STILUS);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.PLATUM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.SAPHIRA_FLORENS);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_VINES_DOWN);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_SIDE_BLUE_LUMINESCENT);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GRASS_BLUE_LUMINESCENT);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.TALL_GRASS_BLUE_LUMINESCENT);
        }

        public static void addMushroomCaveFeatures(BiomeGenerationSettings.Builder builder) {
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.MUSHROOM_ISLAND_VEGETATION);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.HUGE_BROWN_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.HUGE_RED_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BROWN_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.RED_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_SMALL_BROWN);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_SMALL_RED);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.FERTILE_RED_MUSHROOM);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.HANGING_ROOTS);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_DEATH_TRUMPET);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GRASS);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.TINY_GRASS);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.RED_LUMERIA);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_FLOWERS);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_FERTILE_RED_FLOWER);
        }

        public static void addCrystalCaveFeatures(BiomeGenerationSettings.Builder builder) {
            builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.RED_CRYSTAL);
            builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.RED_CRYSTAL_PILLAR);
            builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.BLUE_CRYSTAL);
            builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.BLUE_CRYSTAL_PILLAR);
            builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.WHITE_CRYSTAL);
            builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.WHITE_CRYSTAL_PILLAR);
            builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.CRYSTAL_BLUE);
        }

        public static void addForestCaveFeatures(BiomeGenerationSettings.Builder builder) {
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CavePlacements.CAVE_VINES);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.OAK_TREE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.AZALEA_TREE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.OAK_BERRIES_TREE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CavePlacements.CLASSIC_VINES);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.OCULAE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.CYCAS);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.PINK_HEATER);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.RED_QUINCE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.YELLOW_QUINCE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.RAPANGE_FLOWERS);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.FLEUR_BERRIES);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.YELICE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GRASS);
        }

        public static void addRockyCaveFeatures(BiomeGenerationSettings.Builder builder) {
            builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.ROCKY_STALACTITE);
            builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.HUGE_STALACTITE);
            builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.TINY_PUDDLE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GLOW_LICHEN);
        }

        public static void addMossyCaveFeatures(BiomeGenerationSettings.Builder builder) {
            builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.MOSSY_STALACTITE);
            builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.HUGE_STALACTITE);
            builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.TINY_PUDDLE);
            builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.CAVE_TOP_BUSH);
            builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.CAVE_BUSH);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GLOW_LICHEN);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.VINES);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CavePlacements.CAVE_VINES);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.DEEP_YELICE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_YELLOW);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.DEEP_GRASS);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.DEEP_TALL_GRASS);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CavePlacements.CLASSIC_VINES);
        }

        public static void addPurpleSchroomCaveFeatures(BiomeGenerationSettings.Builder builder) {
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.PINK_LUMINESCENT_MUSHROOM_TREE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.PURPLE_MUSHROOM_TREE);
            builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.HUGE_PURPLE_MUSHROOM_TREE);
        }

    }

}
