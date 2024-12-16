package net.rodofire.mushrooomsmod.world.features.placedfeatures;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;

import java.util.List;

public class ModSurfacePlacedFeatures {
    //Very huge names but anyway
    //tree
    public static final RegistryKey<PlacedFeature> CHERRY_BLOSSOM_TREE_SURFACE_PLACED_FEATURE = registerKey("cherry_blossom_tree_surface_placed_feature");
    public static final RegistryKey<PlacedFeature> PELTOGYNE_TREE_SURFACED_PLACED_KEY = registerKey("peltology_tree_surface_placed_key");
    public static final RegistryKey<PlacedFeature> COLORFUL_TREE_SURFACE_PLACED_KEY = registerKey("colorful_tree_surface_placed_key");
    //Huge Mushrooms
    public static final RegistryKey<PlacedFeature> PINK_LUMINESCENT_MUSHROOM_TREE_SURFACE_PLACED_KEY = registerKey("pink_luminescent_mushrooom_tree_surface_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_MUSHROOM_TREE_SURFACE_PLACED_KEY = registerKey("blue_mushrooom_tree_surface_placed_key");
    public static final RegistryKey<PlacedFeature> PURPLE_MUSHROOM_TREE_SURFACE_PLACED_KEY = registerKey("purple_mushrooom_tree_surface_placed_key");
    public static final RegistryKey<PlacedFeature> GREEN_MUSHROOM_TREE_SURFACE_PLACED_KEY = registerKey("green_mushrooom_tree_surface_placed_key");
    public static final RegistryKey<PlacedFeature> ORANGE_MUSHROOM_TREE_SURFACE_PLACED_KEY = registerKey("orange_mushrooom_tree_surface_placed_key");
    public static final RegistryKey<PlacedFeature> YELLOW_MUSHROOM_TREE_SURFACE_PLACED_KEY_WG = registerKey("yellow_mushrooom_tree_surface_placed_key_wg");
    public static final RegistryKey<PlacedFeature> RED_MUSHROOM_TREE_SURFACE_PLACED_KEY = registerKey("red_mushrooom_tree_surface_placed_key");
    public static final RegistryKey<PlacedFeature> BROWN_MUSHROOM_TREE_SURFACE_PLACED_KEY = registerKey("brown_mushrooom_tree_surface_placed_key");

    //Mushrooms
    public static final RegistryKey<PlacedFeature> PINK_LUMINESCENT_MUSHROOM_SURFACE_PLACED_KEY = registerKey("pink_luminescent_mushroom_surface_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_MUSHROOM_SURFACE_PLACED_KEY = registerKey("luminescent_mushroom_surface_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_MUSHROOM_SURFACE_PLACED_KEY = registerKey("blue_mushroom_surface_placed_key");
    public static final RegistryKey<PlacedFeature> GREEN_MUSHROOM_SURFACE_PLACED_KEY = registerKey("green_mushroom_surface_placed_key");
    public static final RegistryKey<PlacedFeature> PURPLE_MUSHROOM_SURFACE_PLACED_KEY = registerKey("purple_mushroom_surface_placed_key");
    public static final RegistryKey<PlacedFeature> ORANGE_MUSHROOM_SURFACE_PLACED_KEY = registerKey("orange_mushroom_surface_placed_key");
    public static final RegistryKey<PlacedFeature> YELLOW_MUSHROOM_SURFACE_PLACED_KEY = registerKey("yellow_mushroom_surface_placed_key");

    //Flowers Mushrooms
    public static final RegistryKey<PlacedFeature> STERILE_BLUE_MUSHROOM_SURFACE_PLACED_KEY = registerKey("sterile_blue_mushroom_surface_placed_key");
    public static final RegistryKey<PlacedFeature> MUSHROOM_SMALL_BROWN_SURFACE_PLACED_KEY = registerKey("mushroom_small_brown_surface_placed_key");
    public static final RegistryKey<PlacedFeature> MUSHROOM_SMALL_RED_SURFACE_PLACED_KEY = registerKey("mushroom_small_red_surface_placed_key");

    //flowers
    public static final RegistryKey<PlacedFeature> OCULAE_SURFACE_PLACED_KEY = registerKey("oculae_surface_placed_key");
    public static final RegistryKey<PlacedFeature> CYANUS_RUBENS_SURFACE_PLACED_KEY = registerKey("cyanus_rubens_surface_placed_key");
    public static final RegistryKey<PlacedFeature> SOL_OCCIDENTIS_SURFACE_PLACED_KEY = registerKey("sol_occidentis_surface_placed_key");
    public static final RegistryKey<PlacedFeature> MUSHROOM_FLOWERS_SURFACE_PLACED_KEY = registerKey("mushroom_flowers_surface_placed_key");
    public static final RegistryKey<PlacedFeature> RED_LUMERIA_SURFACE_PLACED_KEY = registerKey("red_lumeria_surface_placed_key");
    public static final RegistryKey<PlacedFeature> PREHISTO_PINK_SCHROOM_SURFACE_PLACED_KEY = registerKey("prehisto_pink_schroom_surface_placed_key");
    public static final RegistryKey<PlacedFeature> PREHISTURPLE_SCHROOM_SURFACE_PLACED_KEY = registerKey("prehisturple_surface_placed_key");
    public static final RegistryKey<PlacedFeature> PREHISTO_BLUE_SCHROOM_SURFACE_PLACED_KEY = registerKey("prehisto_blue_surface_placed_key");
    public static final RegistryKey<PlacedFeature> PREHISTO_GREEN_SCHROOM_SURFACE_PLACED_KEY = registerKey("prehisto_green_surface_placed_key");


    public static final RegistryKey<PlacedFeature> YELLOW_PERENNIAL_SURFACE_PLACED_KEY = registerKey("yellow_perennial_surface_placed_key");
    public static final RegistryKey<PlacedFeature> PINK_PERENNIAL_SURFACE_PLACED_KEY = registerKey("pink_perennial_surface_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_PERENNIAL_SURFACE_PLACED_KEY = registerKey("blue_perennial_surface_placed_key");
    public static final RegistryKey<PlacedFeature> GREEN_PERENNIAL_SURFACE_PLACED_KEY = registerKey("green_perennial_surface_placed_key");
    public static final RegistryKey<PlacedFeature> LUMINESCENT_PERENNIAL_SURFACE_PLACED_KEY = registerKey("luminescent_perennial_surface_placed_key");
    public static final RegistryKey<PlacedFeature> ORANGE_PERENNIAL_SURFACE_PLACED_KEY = registerKey("orange_perennial_surface_placed_key");
    public static final RegistryKey<PlacedFeature> PURPLE_PERENNIAL_SURFACE_PLACED_KEY = registerKey("purple_perennial_surface_placed_key");

    public static final RegistryKey<PlacedFeature> SMALL_PATCH_YELLOW_PERENNIAL_SURFACE_PLACED_KEY = registerKey("small_patch_yellow_perennial_surface_placed_key");
    public static final RegistryKey<PlacedFeature> SMALL_PATCH_PINK_PERENNIAL_SURFACE_PLACED_KEY = registerKey("small_patch_pink_perennial_surface_placed_key");
    public static final RegistryKey<PlacedFeature> SMALL_PATCH_BLUE_PERENNIAL_SURFACE_PLACED_KEY = registerKey("small_patch_blue_perennial_surface_placed_key");
    public static final RegistryKey<PlacedFeature> SMALL_PATCH_GREEN_PERENNIAL_SURFACE_PLACED_KEY = registerKey("small_patch_green_perennial_surface_placed_key");
    public static final RegistryKey<PlacedFeature> SMALL_PATCH_LUMINESCENT_PERENNIAL_SURFACE_PLACED_KEY = registerKey("small_patch_luminescent_perennial_surface_placed_key");
    public static final RegistryKey<PlacedFeature> SMALL_PATCH_ORANGE_PERENNIAL_SURFACE_PLACED_KEY = registerKey("small_patch_orange_perennial_surface_placed_key");
    public static final RegistryKey<PlacedFeature> SMALL_PATCH_PURPLE_PERENNIAL_SURFACE_PLACED_KEY = registerKey("small_patch_purple_perennial_surface_placed_key");


    public static final RegistryKey<PlacedFeature> RED_QUINCE_SURFACE_PLACED_KEY = registerKey("red_quince_surface_placed_key");
    public static final RegistryKey<PlacedFeature> YELLOW_QUINCE_SURFACE_PLACED_KEY = registerKey("yellow_quince_surface_placed_key");
    public static final RegistryKey<PlacedFeature> TINY_LILAC_SURFACE_PLACED_KEY = registerKey("tiny_lilac_surface_placed_key");
    public static final RegistryKey<PlacedFeature> YELICE_SURFACE_PLACED_KEY = registerKey("yelice_surface_placed_key");
    public static final RegistryKey<PlacedFeature> FLAMESTHYSIA_SURFACE_PLACED_KEY = registerKey("flamesthysia_surface_placed_key");
    public static final RegistryKey<PlacedFeature> APAGANTHE_SURFACE_PLACED_KEY = registerKey("apaganthe_surface_placed_key");
    public static final RegistryKey<PlacedFeature> PINK_HEATER_SURFACE_PLACED_KEY = registerKey("pink_heater_surface_placed_key");
    public static final RegistryKey<PlacedFeature> WYSTERIA_SURFACE_PLACED_KEY = registerKey("wysteria_surface_placed_key");
    public static final RegistryKey<PlacedFeature> BLUEBELL_SURFACE_PLACED_KEY = registerKey("bluebell_surface_placed_key");
    public static final RegistryKey<PlacedFeature> VIPERIN_SURFACE_PLACED_KEY = registerKey("viperin_surface_placed_key");
    public static final RegistryKey<PlacedFeature> HIBISCUS_SURFACE_PLACED_KEY = registerKey("hibiscus_surface_placed_key");
    public static final RegistryKey<PlacedFeature> DIANTHUS_SURFACE_PLACED_KEY = registerKey("dianthus_surface_placed_key");
    public static final RegistryKey<PlacedFeature> CYCAS_SURFACE_PLACED_KEY = registerKey("cycas_surface_placed_key");
    public static final RegistryKey<PlacedFeature> ARUM_SURFACE_PLACED_KEY = registerKey("arum_surface_placed_key");
    public static final RegistryKey<PlacedFeature> HYDRANGEA_SURFACE_PLACED_KEY = registerKey("hydrangea_surface_placed_key");
    public static final RegistryKey<PlacedFeature> ANEMONE_SURFACE_PLACED_KEY = registerKey("anemone_surface_placed_key");
    public static final RegistryKey<PlacedFeature> JACYNTHE_SURFACE_PLACED_KEY = registerKey("jacynthe_surface_placed_key");
    public static final RegistryKey<PlacedFeature> ACONIT_SURFACE_PLACED_KEY = registerKey("aconit_surface_placed_key");
    public static final RegistryKey<PlacedFeature> PERVENCHE_SURFACE_PLACED_KEY = registerKey("pervenche_surface_placed_key");
    public static final RegistryKey<PlacedFeature> PICK_BLUE_SURFACE_PLACED_KEY = registerKey("pick_blue_surface_placed_key");

    //Grass
    public static final RegistryKey<PlacedFeature> TINY_GRASS_SURFACE_PLACED_KEY = registerKey("tiny_grass_surface_placed_key");
    public static final RegistryKey<PlacedFeature> GRASS_SURFACE_PLACED_KEY = registerKey("grass_surface_placed_key");

    //Bush
    public static final RegistryKey<PlacedFeature> BUSH_SURFACE_SURFACE_PLACED_KEY = registerKey("bush_surface_surface_placed_key");
    public static final RegistryKey<PlacedFeature> COLORFUL_BUSH_SURFACE_PLACED_KEY = registerKey("colorful_bush_surface_placed_key");

    //terrain
    public static final RegistryKey<PlacedFeature> SAKURA_ARCH_SURFACE_PLACED_KEY = registerKey("arch_surface_placed_key");
    public static final RegistryKey<PlacedFeature> SAKURA_ROCK_STRAIGHT_PLACED_KEY = registerKey("sakura_rock_straight_placed_key");
    public static final RegistryKey<PlacedFeature> SPIRAL_MUSHROOM_FEATURE = registerKey("spiral_mushroom_feature");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        //tree
        register(context, CHERRY_BLOSSOM_TREE_SURFACE_PLACED_FEATURE, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.CHERRY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.2f, 2), Blocks.CHERRY_SAPLING));
        register(context, PELTOGYNE_TREE_SURFACED_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PELTOGYNE_TREE_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.2f, 2), ModBlocks.PELTOGYNE_SAPLING));
        register(context, COLORFUL_TREE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COLORFUL_TREE_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), Blocks.OAK_SAPLING));

        //Mushrooms
        register(context, PINK_LUMINESCENT_MUSHROOM_TREE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINK_LUMINESCENT_MUSHROOM_TREE_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.LUMINESCENT_PINK_MUSHROOM));
        register(context, BLUE_MUSHROOM_TREE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_MUSHROOM_TREE_KEY_WG), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(6, 0.2f, 3), ModBlocks.BLUE_MUSHROOM));
        register(context, GREEN_MUSHROOM_TREE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GREEN_MUSHROOM_TREE_KEY), CountPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PURPLE_MUSHROOM_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PURPLE_MUSHROOM_TREE_KEY), CountPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ORANGE_MUSHROOM_TREE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGE_MUSHROOM_TREE_KEY_WG), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, YELLOW_MUSHROOM_TREE_SURFACE_PLACED_KEY_WG, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELLOW_MUSHROOM_TREE_KEY_WG), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BROWN_MUSHROOM_TREE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM), CountPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, RED_MUSHROOM_TREE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.HUGE_RED_MUSHROOM), CountPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        //Flowers Mushrooms
        register(context, STERILE_BLUE_MUSHROOM_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.STERILE_BLUE_MUSHROOM_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MUSHROOM_SMALL_BROWN_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_BROWN_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MUSHROOM_SMALL_RED_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_RED_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BLUE_LUMINESCENT_MUSHROOM_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM_KEY), RarityFilterPlacementModifier.of(8), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        //Flowers
        register(context, OCULAE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OCULAE_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, CYANUS_RUBENS_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CYANUS_RUBENS_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SOL_OCCIDENTIS_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SOL_OCCIDENTIS_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MUSHROOM_FLOWERS_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_FLOWERS_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, RED_LUMERIA_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_LUMERIA_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, PREHISTURPLE_SCHROOM_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTURPLE_SCHROOM_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PREHISTO_GREEN_SCHROOM_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTO_GREEN_SCHROOM_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PREHISTO_BLUE_SCHROOM_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTO_BLUE_SCHROOM_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PREHISTO_PINK_SCHROOM_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTO_PINK_SCHROOM_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());


        register(context, YELLOW_PERENNIAL_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELLOW_PERENNIAL_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PINK_PERENNIAL_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINK_PERENNIAL_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BLUE_PERENNIAL_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_PERENNIAL_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, GREEN_PERENNIAL_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GREEN_PERENNIAL_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUMINESCENT_PERENNIAL_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUMINESCENT_PERENNIAL_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ORANGE_PERENNIAL_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGE_PERENNIAL_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PURPLE_PERENNIAL_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PURPLE_PERENNIAL_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, SMALL_PATCH_YELLOW_PERENNIAL_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_YELLOW_PERENNIAL_KEY), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_PINK_PERENNIAL_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_PINK_PERENNIAL_KEY), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_BLUE_PERENNIAL_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_BLUE_PERENNIAL_KEY), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_GREEN_PERENNIAL_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_GREEN_PERENNIAL_KEY), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_LUMINESCENT_PERENNIAL_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_LUMINESCENT_PERENNIAL_KEY), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_ORANGE_PERENNIAL_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_ORANGE_PERENNIAL_KEY), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_PURPLE_PERENNIAL_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_PURPLE_PERENNIAL_KEY), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());


        register(context, YELLOW_QUINCE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELLOW_QUINCE_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, RED_QUINCE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_QUINCE_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, TINY_LILAC_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TINY_LILAC_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, YELICE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELICE_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, FLAMESTHYSIA_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FLAMESTHYSIA_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, APAGANTHE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.APAGANTHE_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PINK_HEATER_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINK_HEATER_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, WYSTERIA_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WYSTERIA_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BLUEBELL_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUEBELL_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, VIPERIN_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VIPERIN_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, HIBISCUS_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HIBISCUS_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, DIANTHUS_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DIANTHUS_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, BiomePlacementModifier.of());
        register(context, CYCAS_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CYCAS_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ARUM_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ARUM_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, HYDRANGEA_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HYDRANGEA_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ANEMONE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ANEMONE_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, JACYNTHE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.JACYNTHE_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ACONIT_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ACONIT_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PERVENCHE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PERVENCHE_KEY), CountPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PICK_BLUE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PICK_BLUE_KEY), CountPlacementModifier.of(12), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        //Grass
        register(context, TINY_GRASS_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TINY_GRASSS_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, GRASS_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GRASS_KEY), CountPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        //Bush
        register(context, BUSH_SURFACE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BUSH_KEY), CountPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, COLORFUL_BUSH_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COLORFUL_BUSH_KEY), CountPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        //terrain
        register(context, SAKURA_ARCH_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAKURA_ARCH_KEY), RarityFilterPlacementModifier.of(25), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SAKURA_ROCK_STRAIGHT_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAKURA_ROCK_STRAIGHT_KEY), RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SPIRAL_MUSHROOM_FEATURE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SPIRAL_MUSHROOM_KEY), CountPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MushrooomsMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
