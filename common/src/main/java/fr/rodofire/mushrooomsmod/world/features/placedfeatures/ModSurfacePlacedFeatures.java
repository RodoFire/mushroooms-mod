package fr.rodofire.mushrooomsmod.world.features.placedfeatures;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;

import java.util.List;

public class ModSurfacePlacedFeatures {
    //Very huge names but anyway
    //tree
    public static final ResourceKey<PlacedFeature> CHERRY_BLOSSOM_TREE = registerKey("cherry_blossom_tree_feature");
    public static final ResourceKey<PlacedFeature> PELTOGYNE_TREE = registerKey("peltology_tree");
    public static final ResourceKey<PlacedFeature> COLORFUL_TREE = registerKey("colorful_tree");
    //Huge Mushrooms
    public static final ResourceKey<PlacedFeature> PINK_LUMINESCENT_MUSHROOM_TREE = registerKey("pink_luminescent_mushrooom_tree");
    public static final ResourceKey<PlacedFeature> BLUE_MUSHROOM_TREE = registerKey("blue_mushrooom_tree");
    public static final ResourceKey<PlacedFeature> PURPLE_MUSHROOM_TREE = registerKey("purple_mushrooom_tree");
    public static final ResourceKey<PlacedFeature> GREEN_MUSHROOM_TREE = registerKey("green_mushrooom_tree");
    public static final ResourceKey<PlacedFeature> CRYING_GREEN_MUSHROOM_TREE = registerKey("crying_green_mushrooom_tree");
    public static final ResourceKey<PlacedFeature> ORANGE_MUSHROOM_TREE = registerKey("orange_mushrooom_tree");
    public static final ResourceKey<PlacedFeature> RED_MUSHROOM_TREE = registerKey("red_mushrooom_tree");
    public static final ResourceKey<PlacedFeature> BROWN_MUSHROOM_TREE = registerKey("brown_mushrooom_tree");
    public static final ResourceKey<PlacedFeature> SINUSO_SHROOM = registerKey("sinuso_shroom");

    //Mushrooms
    public static final ResourceKey<PlacedFeature> PINK_LUMINESCENT_MUSHROOM = registerKey("pink_luminescent_mushroom");
    public static final ResourceKey<PlacedFeature> BLUE_LUMINESCENT_MUSHROOM = registerKey("luminescent_mushroom");
    public static final ResourceKey<PlacedFeature> BLUE_MUSHROOM = registerKey("blue_mushroom");
    public static final ResourceKey<PlacedFeature> GREEN_MUSHROOM = registerKey("green_mushroom");
    public static final ResourceKey<PlacedFeature> LIGHT_GREEN_MUSHROOM = registerKey("light_green_mushroom");
    public static final ResourceKey<PlacedFeature> PURPLE_MUSHROOM = registerKey("purple_mushroom");
    public static final ResourceKey<PlacedFeature> ORANGE_MUSHROOM = registerKey("orange_mushroom");
    public static final ResourceKey<PlacedFeature> LIGHT_ORANGE_MUSHROOM = registerKey("light_orange_mushroom");
    public static final ResourceKey<PlacedFeature> YELLOW_MUSHROOM = registerKey("yellow_mushroom");
    public static final ResourceKey<PlacedFeature> LIGHT_YELLOW_MUSHROOM = registerKey("light_yellow_mushroom");

    public static final ResourceKey<PlacedFeature> BIG_PURPLE_MUSHROOM_PLANT = registerKey("big_purple_mushroom_plant");
    public static final ResourceKey<PlacedFeature> TINY_PURPLE_MUSHROOM = registerKey("tiny_purple_mushroom");
    public static final ResourceKey<PlacedFeature> LITTLE_PURPLE_MUSHROOM = registerKey("little_purple_mushroom");
    public static final ResourceKey<PlacedFeature> MEDIUM_PURPLE_MUSHROOM = registerKey("medium_purple_mushroom");
    public static final ResourceKey<PlacedFeature> BIG_PURPLE_MUSHROOM = registerKey("big_purple_mushroom");
    public static final ResourceKey<PlacedFeature> TINY_GREEN_MUSHROOM = registerKey("tiny_green_mushroom");
    public static final ResourceKey<PlacedFeature> LITTLE_GREEN_MUSHROOM = registerKey("little_green_mushroom");
    public static final ResourceKey<PlacedFeature> MEDIUM_GREEN_MUSHROOM = registerKey("medium_green_mushroom");
    public static final ResourceKey<PlacedFeature> BIG_GREEN_MUSHROOM = registerKey("big_green_mushroom");
    public static final ResourceKey<PlacedFeature> BIG_GREEN_MUSHROOM_PLANT = registerKey("big_green_mushroom_plant");

    //Flowers Mushrooms
    public static final ResourceKey<PlacedFeature> STERILE_BLUE_MUSHROOM = registerKey("sterile_blue_mushroom");
    public static final ResourceKey<PlacedFeature> MUSHROOM_SMALL_BROWN = registerKey("mushroom_small_brown");
    public static final ResourceKey<PlacedFeature> MUSHROOM_SMALL_RED = registerKey("mushroom_small_red");
    public static final ResourceKey<PlacedFeature> BRIGHT_YELLOW_MUSHROOM = registerKey("bright_yellow_mushroom");
    public static final ResourceKey<PlacedFeature> BUSHY_YELLOW_MUSHROOMS = registerKey("bushy_yellow_mushrooms");

    //flowers
    public static final ResourceKey<PlacedFeature> OCULAE = registerKey("oculae");
    public static final ResourceKey<PlacedFeature> CYANUS_RUBENS = registerKey("cyanus_rubens");
    public static final ResourceKey<PlacedFeature> SOL_OCCIDENTIS = registerKey("sol_occidentis");
    public static final ResourceKey<PlacedFeature> MUSHROOM_FLOWERS = registerKey("mushroom_flowers");
    public static final ResourceKey<PlacedFeature> RED_LUMERIA = registerKey("red_lumeria");
    public static final ResourceKey<PlacedFeature> PREHISTO_PINK_SCHROOM = registerKey("prehisto_pink_schroom");
    public static final ResourceKey<PlacedFeature> PREHISTURPLE_SCHROOM = registerKey("prehisturple");
    public static final ResourceKey<PlacedFeature> PREHISTO_BLUE_SCHROOM = registerKey("prehisto_blue");
    public static final ResourceKey<PlacedFeature> PREHISTO_GREEN_SCHROOM = registerKey("prehisto_green");


    public static final ResourceKey<PlacedFeature> YELLOW_PERENNIAL = registerKey("yellow_perennial");
    public static final ResourceKey<PlacedFeature> PINK_PERENNIAL = registerKey("pink_perennial");
    public static final ResourceKey<PlacedFeature> BLUE_PERENNIAL = registerKey("blue_perennial");
    public static final ResourceKey<PlacedFeature> GREEN_PERENNIAL = registerKey("green_perennial");
    public static final ResourceKey<PlacedFeature> LUMINESCENT_PERENNIAL = registerKey("luminescent_perennial");
    public static final ResourceKey<PlacedFeature> ORANGE_PERENNIAL = registerKey("orange_perennial");
    public static final ResourceKey<PlacedFeature> PURPLE_PERENNIAL = registerKey("purple_perennial");

    public static final ResourceKey<PlacedFeature> SMALL_PATCH_YELLOW_PERENNIAL = registerKey("small_patch_yellow_perennial");
    public static final ResourceKey<PlacedFeature> SMALL_PATCH_PINK_PERENNIAL = registerKey("small_patch_pink_perennial");
    public static final ResourceKey<PlacedFeature> SMALL_PATCH_BLUE_PERENNIAL = registerKey("small_patch_blue_perennial");
    public static final ResourceKey<PlacedFeature> SMALL_PATCH_GREEN_PERENNIAL = registerKey("small_patch_green_perennial");
    public static final ResourceKey<PlacedFeature> SMALL_PATCH_LUMINESCENT_PERENNIAL = registerKey("small_patch_luminescent_perennial");
    public static final ResourceKey<PlacedFeature> SMALL_PATCH_ORANGE_PERENNIAL = registerKey("small_patch_orange_perennial");
    public static final ResourceKey<PlacedFeature> SMALL_PATCH_PURPLE_PERENNIAL = registerKey("small_patch_purple_perennial");


    public static final ResourceKey<PlacedFeature> RED_QUINCE = registerKey("red_quince");
    public static final ResourceKey<PlacedFeature> YELLOW_QUINCE = registerKey("yellow_quince");
    public static final ResourceKey<PlacedFeature> TINY_LILAC = registerKey("tiny_lilac");
    public static final ResourceKey<PlacedFeature> YELICE = registerKey("yelice");
    public static final ResourceKey<PlacedFeature> FLAMESTHYSIA = registerKey("flamesthysia");
    public static final ResourceKey<PlacedFeature> APAGANTHE = registerKey("apaganthe");
    public static final ResourceKey<PlacedFeature> PINK_HEATER = registerKey("pink_heater");
    public static final ResourceKey<PlacedFeature> WYSTERIA = registerKey("wysteria");
    public static final ResourceKey<PlacedFeature> BLUEBELL = registerKey("bluebell");
    public static final ResourceKey<PlacedFeature> VIPERIN = registerKey("viperin");
    public static final ResourceKey<PlacedFeature> HIBISCUS = registerKey("hibiscus");
    public static final ResourceKey<PlacedFeature> DIANTHUS = registerKey("dianthus");
    public static final ResourceKey<PlacedFeature> CYCAS = registerKey("cycas");
    public static final ResourceKey<PlacedFeature> ARUM = registerKey("arum");
    public static final ResourceKey<PlacedFeature> HYDRANGEA = registerKey("hydrangea");
    public static final ResourceKey<PlacedFeature> ANEMONE = registerKey("anemone");
    public static final ResourceKey<PlacedFeature> JACYNTHE = registerKey("jacynthe");
    public static final ResourceKey<PlacedFeature> ACONIT = registerKey("aconit");
    public static final ResourceKey<PlacedFeature> PERVENCHE = registerKey("pervenche");
    public static final ResourceKey<PlacedFeature> PICK_BLUE = registerKey("pick_blue");
    public static final ResourceKey<PlacedFeature> TURQUOSUM_STILUS = registerKey("turquosum_stilus");
    public static final ResourceKey<PlacedFeature> NOCTULICA = registerKey("noctulica");
    public static final ResourceKey<PlacedFeature> LIGHT_RAPANGE_FLOWERS = registerKey("fleur_berries");

    public static final ResourceKey<PlacedFeature> LIGHT_TINY_LILAC = registerKey("light_tiny_lilac");
    public static final ResourceKey<PlacedFeature> LIGHT_APAGANTHE = registerKey("light_apaganthe");
    public static final ResourceKey<PlacedFeature> LIGHT_WYSTERIA = registerKey("light_wysteria");
    public static final ResourceKey<PlacedFeature> LIGHT_BLUEBELL = registerKey("light_bluebell");
    public static final ResourceKey<PlacedFeature> LIGHT_ACONIT = registerKey("light_aconit");
    public static final ResourceKey<PlacedFeature> LIGHT_PERVENCHE = registerKey("light_pervenche");
    public static final ResourceKey<PlacedFeature> MUSHROOM_TALL_YELLOW = registerKey("tall_yellow_mushrooms");

    //Grass
    public static final ResourceKey<PlacedFeature> TINY_GRASS = registerKey("tiny_grass");
    public static final ResourceKey<PlacedFeature> GRASS = registerKey("grass");
    public static final ResourceKey<PlacedFeature> LIGHT_GRASS = registerKey("light_grass");

    //Bush
    public static final ResourceKey<PlacedFeature> BUSH_SURFACE = registerKey("bush");
    public static final ResourceKey<PlacedFeature> COLORFUL_BUSH = registerKey("colorful_bush");

    //terrain
    public static final ResourceKey<PlacedFeature> SAKURA_ARCH = registerKey("arch");
    public static final ResourceKey<PlacedFeature> SAKURA_ROCK_STRAIGHT = registerKey("sakura_rock_straight_placed");
    public static final ResourceKey<PlacedFeature> SAKURA_ROCK_FLAT = registerKey("sakura_rock_flat_placed");
    public static final ResourceKey<PlacedFeature> SPIRAL_MUSHROOM_FEATURE = registerKey("spiral_mushroom_feature");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var registererFeature = context.lookup(Registries.CONFIGURED_FEATURE);
        //tree
        register(context, CHERRY_BLOSSOM_TREE, registererFeature.getOrThrow(TreeFeatures.CHERRY), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.2f, 2), Blocks.CHERRY_SAPLING));
        register(context, PELTOGYNE_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.PELTOGYNE_TREE), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.2f, 2), ModBlocks.PELTOGYNE_SAPLING.get()));
        register(context, COLORFUL_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.COLORFUL_TREE), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 2), Blocks.OAK_SAPLING));

        //mushrooms
        register(context, GREEN_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.GREEN_MUSHROOM), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, LIGHT_GREEN_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_GREEN_MUSHROOM), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, ORANGE_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.ORANGE_MUSHROOM), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, LIGHT_ORANGE_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_ORANGE_MUSHROOM), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, YELLOW_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.YELLOW_MUSHROOM), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, LIGHT_YELLOW_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_YELLOW_MUSHROOM), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

        register(context, BIG_PURPLE_MUSHROOM_PLANT, registererFeature.getOrThrow(ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_PLANT), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, TINY_PURPLE_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.TINY_PURPLE_MUSHROOM), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, LITTLE_PURPLE_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.LITTLE_PURPLE_MUSHROOM), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, MEDIUM_PURPLE_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.MEDIUM_PURPLE_MUSHROOM), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, BIG_PURPLE_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.BIG_PURPLE_MUSHROOM), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, TINY_GREEN_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.TINY_GREEN_MUSHROOM), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, LITTLE_GREEN_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.LITTLE_GREEN_MUSHROOM), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, MEDIUM_GREEN_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.MEDIUM_GREEN_MUSHROOM), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, BIG_GREEN_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.BIG_GREEN_MUSHROOM), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, BIG_GREEN_MUSHROOM_PLANT, registererFeature.getOrThrow(ModConfiguredFeatures.BIG_GREEN_MUSHROOM_PLANT), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());


        //Mushrooms trees
        register(context, PINK_LUMINESCENT_MUSHROOM_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.PINK_LUMINESCENT_MUSHROOM_TREE), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 2), ModBlocks.LUMINESCENT_PINK_MUSHROOM.get()));
        register(context, BLUE_MUSHROOM_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_MUSHROOM_TREE_WG), VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.2f, 3), ModBlocks.BLUE_MUSHROOM.get()));
        register(context, GREEN_MUSHROOM_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.GREEN_MUSHROOM_TREE), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, CRYING_GREEN_MUSHROOM_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.CRYING_GREEN_MUSHROOM_TREE), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, PURPLE_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.PURPLE_MUSHROOM_TREE), CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, ORANGE_MUSHROOM_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.ORANGE_MUSHROOM_TREE_WG), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, BROWN_MUSHROOM_TREE, registererFeature.getOrThrow(TreeFeatures.HUGE_BROWN_MUSHROOM), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, SINUSO_SHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.SINUSO_SHROOM), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, RED_MUSHROOM_TREE, registererFeature.getOrThrow(TreeFeatures.HUGE_RED_MUSHROOM), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

        //Flowers Mushrooms
        register(context, STERILE_BLUE_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.STERILE_BLUE_MUSHROOM), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, MUSHROOM_SMALL_BROWN, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_BROWN), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, MUSHROOM_SMALL_RED, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_RED), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, BLUE_LUMINESCENT_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM), RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, BUSHY_YELLOW_MUSHROOMS, registererFeature.getOrThrow(ModConfiguredFeatures.BUSHY_YELLOW_MUSHROOMS), RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, BRIGHT_YELLOW_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.BRIGHT_YELLOW_MUSHROOM), RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        //Flowers
        register(context, OCULAE, registererFeature.getOrThrow(ModConfiguredFeatures.OCULAE), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, CYANUS_RUBENS, registererFeature.getOrThrow(ModConfiguredFeatures.CYANUS_RUBENS), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, SOL_OCCIDENTIS, registererFeature.getOrThrow(ModConfiguredFeatures.SOL_OCCIDENTIS), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, MUSHROOM_FLOWERS, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_FLOWERS), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RED_LUMERIA, registererFeature.getOrThrow(ModConfiguredFeatures.RED_LUMERIA), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        register(context, PREHISTURPLE_SCHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.PREHISTURPLE_SCHROOM), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, PREHISTO_GREEN_SCHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.PREHISTO_GREEN_SCHROOM), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, PREHISTO_BLUE_SCHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.PREHISTO_BLUE_SCHROOM), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, PREHISTO_PINK_SCHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.PREHISTO_PINK_SCHROOM), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


        register(context, YELLOW_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.YELLOW_PERENNIAL), RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, PINK_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.PINK_PERENNIAL), RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, BLUE_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_PERENNIAL), RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, GREEN_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.GREEN_PERENNIAL), RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, LUMINESCENT_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.LUMINESCENT_PERENNIAL), RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, ORANGE_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.ORANGE_PERENNIAL), RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, PURPLE_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.PURPLE_PERENNIAL), RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        register(context, SMALL_PATCH_YELLOW_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_YELLOW_PERENNIAL), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, SMALL_PATCH_PINK_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_PINK_PERENNIAL), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, SMALL_PATCH_BLUE_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_BLUE_PERENNIAL), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, SMALL_PATCH_GREEN_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_GREEN_PERENNIAL), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, SMALL_PATCH_LUMINESCENT_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_LUMINESCENT_PERENNIAL), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, SMALL_PATCH_ORANGE_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_ORANGE_PERENNIAL), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, SMALL_PATCH_PURPLE_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_PURPLE_PERENNIAL), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


        register(context, YELLOW_QUINCE, registererFeature.getOrThrow(ModConfiguredFeatures.YELLOW_QUINCE), CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, RED_QUINCE, registererFeature.getOrThrow(ModConfiguredFeatures.RED_QUINCE), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, TINY_LILAC, registererFeature.getOrThrow(ModConfiguredFeatures.TINY_LILAC), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, YELICE, registererFeature.getOrThrow(ModConfiguredFeatures.YELICE), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, FLAMESTHYSIA, registererFeature.getOrThrow(ModConfiguredFeatures.FLAMESTHYSIA), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, APAGANTHE, registererFeature.getOrThrow(ModConfiguredFeatures.APAGANTHE), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, PINK_HEATER, registererFeature.getOrThrow(ModConfiguredFeatures.PINK_HEATER), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, WYSTERIA, registererFeature.getOrThrow(ModConfiguredFeatures.WYSTERIA), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, BLUEBELL, registererFeature.getOrThrow(ModConfiguredFeatures.BLUEBELL), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, VIPERIN, registererFeature.getOrThrow(ModConfiguredFeatures.VIPERIN), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, HIBISCUS, registererFeature.getOrThrow(ModConfiguredFeatures.HIBISCUS), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        register(context, DIANTHUS, registererFeature.getOrThrow(ModConfiguredFeatures.DIANTHUS), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
        register(context, CYCAS, registererFeature.getOrThrow(ModConfiguredFeatures.CYCAS), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, ARUM, registererFeature.getOrThrow(ModConfiguredFeatures.ARUM), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, HYDRANGEA, registererFeature.getOrThrow(ModConfiguredFeatures.HYDRANGEA), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, ANEMONE, registererFeature.getOrThrow(ModConfiguredFeatures.ANEMONE), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, JACYNTHE, registererFeature.getOrThrow(ModConfiguredFeatures.JACYNTHE), CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, ACONIT, registererFeature.getOrThrow(ModConfiguredFeatures.ACONIT), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, PERVENCHE, registererFeature.getOrThrow(ModConfiguredFeatures.PERVENCHE), CountPlacement.of(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, PICK_BLUE, registererFeature.getOrThrow(ModConfiguredFeatures.PICK_BLUE), CountPlacement.of(12), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, TURQUOSUM_STILUS, registererFeature.getOrThrow(ModConfiguredFeatures.TURQUOSUM_STILUS), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, NOCTULICA, registererFeature.getOrThrow(ModConfiguredFeatures.NOCTULICA), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, LIGHT_RAPANGE_FLOWERS, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_RAPANGE_FLOWERS), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

        register(context, LIGHT_TINY_LILAC, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_TINY_LILAC), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, LIGHT_APAGANTHE, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_APAGANTHE), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, LIGHT_WYSTERIA, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_WYSTERIA), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, LIGHT_BLUEBELL, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_BLUEBELL), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, LIGHT_ACONIT, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_ACONIT), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, LIGHT_PERVENCHE, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_PERVENCHE), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, MUSHROOM_TALL_YELLOW, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_TALL_YELLOW), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

        //Grass
        register(context, TINY_GRASS, registererFeature.getOrThrow(ModConfiguredFeatures.TINY_GRASSS), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, GRASS, registererFeature.getOrThrow(ModConfiguredFeatures.GRASS), CountPlacement.of(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, LIGHT_GRASS, registererFeature.getOrThrow(ModConfiguredFeatures.GRASS), CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        //Bush
        register(context, BUSH_SURFACE, registererFeature.getOrThrow(ModConfiguredFeatures.BUSH), CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, COLORFUL_BUSH, registererFeature.getOrThrow(ModConfiguredFeatures.COLORFUL_BUSH), CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        //terrain
        register(context, SAKURA_ARCH, registererFeature.getOrThrow(ModConfiguredFeatures.SAKURA_ARCH), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, SAKURA_ROCK_STRAIGHT, registererFeature.getOrThrow(ModConfiguredFeatures.SAKURA_ROCK_STRAIGHT), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, SAKURA_ROCK_FLAT, registererFeature.getOrThrow(ModConfiguredFeatures.SAKURA_ROCK_FLAT), RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, SPIRAL_MUSHROOM_FEATURE, registererFeature.getOrThrow(ModConfiguredFeatures.SPIRAL_MUSHROOM), CountPlacement.of(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, name + "_surface"));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                                                                   Holder<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
