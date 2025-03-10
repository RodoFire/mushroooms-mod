package net.rodofire.mushrooomsmod.world.biome;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.UndergroundPlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.rodofire.mushrooomsmod.world.features.placedfeatures.ModSurfacePlacedFeatures;
import net.rodofire.mushrooomsmod.world.features.placedfeatures.ModUndergroundPlacedFeatures;

/**
 * Class to manage custom biomes related features
 */
public class ModBiomeFeatures {

    /**
     * method for the default biomes features such as ores / carvers / dungeons ...
     */
    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static class SurfaceBiomes {

        public static void addColorfulPlainsFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.COLORFUL_BUSH_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PURPLE_PERENNIAL_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PINK_PERENNIAL_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.GREEN_PERENNIAL_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.ORANGE_PERENNIAL_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LUMINESCENT_PERENNIAL_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.YELLOW_PERENNIAL_SURFACE_PLACED_KEY);
        }

        public static void addColorfulForestFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.COLORFUL_TREE_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_PLAIN);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_PURPLE_PERENNIAL_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_PINK_PERENNIAL_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_GREEN_PERENNIAL_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_ORANGE_PERENNIAL_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_LUMINESCENT_PERENNIAL_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_YELLOW_PERENNIAL_SURFACE_PLACED_KEY);
        }

        public static void addMushroomShireFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.ORANGE_MUSHROOM_TREE_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.YELLOW_MUSHROOM_TREE_SURFACE_PLACED_KEY_WG);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.GREEN_MUSHROOM_TREE_SURFACE_PLACED_KEY);
        }

        public static void addSchroomIsland2Features(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PURPLE_MUSHROOM_TREE_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.RED_MUSHROOM_TREE_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.BROWN_MUSHROOM_TREE_SURFACE_PLACED_KEY);
        }

        public static void addBlueMushroomForestFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.BLUE_MUSHROOM_TREE_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SPIRAL_MUSHROOM_FEATURE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PERVENCHE_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PICK_BLUE_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.JACYNTHE_SURFACE_PLACED_KEY);
        }

        public static void addMagicalPlainsFeatures(GenerationSettings.LookupBackedBuilder builder) {

        }

        public static void addSakuraForestFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModSurfacePlacedFeatures.SAKURA_ROCK_STRAIGHT_PLACED_KEY);
            builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModSurfacePlacedFeatures.SAKURA_ROCK_FLAT_PLACED_KEY);
            builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModSurfacePlacedFeatures.SAKURA_ARCH_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.CHERRY_BLOSSOM_TREE_SURFACE_PLACED_FEATURE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PELTOGYNE_TREE_SURFACED_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_PLAIN);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PINK_HEATER_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.DIANTHUS_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.HYDRANGEA_SURFACE_PLACED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PINK_PERENNIAL_SURFACE_PLACED_KEY);
        }
    }


    public static class UndergroundBiome {

        public static void addBlueLuminescentCaveFlowers(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_TREE_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_MUSHROOM_TREE_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_MUSHROOM_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_VINES_UP_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.FUTIALI_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.CYANEA_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.NOCTULICA_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.TURQUOSUM_STILUS_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.PLATUM_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.SAPHIRA_FLORENS_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_VINES_DOWN_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_SIDE_BLUE_LUMINESCENT_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GRASS_BLUE_LUMINESCENT_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.TALL_GRASS_BLUE_LUMINESCENT_KEY);
        }

        public static void addMushroomCaveFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.MUSHROOM_ISLAND_VEGETATION);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.HUGE_BROWN_MUSHROOM_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.HUGE_RED_MUSHROOM_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BROWN_MUSHROOM_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.RED_MUSHROOM_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_SMALL_BROWN_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_SMALL_RED_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.FERTILE_RED_MUSHROOM_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.HANGING_ROOTS_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_DEATH_TRUMPET_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GRASS_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.TINY_GRASS_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.RED_LUMERIA_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_FLOWERS_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_FERTILE_RED_FLOWER_KEY);
        }

        public static void addCrystalCaveFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.RED_CRYSTAL_KEY);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.RED_CRYSTAL_PILLAR_KEY);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.BLUE_CRYSTAL_KEY);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.BLUE_CRYSTAL_PILLAR_KEY);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.WHITE_CRYSTAL_KEY);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.WHITE_CRYSTAL_PILLAR_KEY);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.CRYSTAL_BLUE_KEY);
        }

        public static void addForestCaveFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, UndergroundPlacedFeatures.CAVE_VINES);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.OAK_TREE_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.AZALEA_TREE_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.OAK_BERRIES_TREE_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, UndergroundPlacedFeatures.CLASSIC_VINES_CAVE_FEATURE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.OCULAE_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.CYCAS_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.PINK_HEATER_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.RED_QUINCE_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.YELLOW_QUINCE_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.RAPANGE_FLOWERS_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.FLEUR_BERRIES_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.YELICE_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GRASS_KEY);
        }

        public static void addRockyCaveFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.ROCKY_STALACTITE_KEY);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.HUGE_STALACTITE_KEY);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.TINY_PUDDLE_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GLOW_LICHEN_KEY);
        }

        public static void addMossyCaveFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.MOSSY_STALACTITE_KEY);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.HUGE_STALACTITE_KEY);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.TINY_PUDDLE_KEY);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.CAVE_TOP_BUSH);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.CAVE_BUSH);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GLOW_LICHEN_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.VINES_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, UndergroundPlacedFeatures.CAVE_VINES);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.DEEP_YELICE_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_YELLOW_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.DEEP_GRASS_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.DEEP_TALL_GRASS_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, UndergroundPlacedFeatures.CLASSIC_VINES_CAVE_FEATURE);
        }

        public static void addPurpleSchroomCaveFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.PINK_LUMINESCENT_MUSHROOM_TREE_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.PURPLE_MUSHROOM_TREE_KEY);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.HUGE_PURPLE_MUSHROOM_TREE_KEY);
        }

    }

}
