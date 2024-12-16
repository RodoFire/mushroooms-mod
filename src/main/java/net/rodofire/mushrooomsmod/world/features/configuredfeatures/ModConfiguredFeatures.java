package net.rodofire.mushrooomsmod.world.features.configuredfeatures;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.features.config.*;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.*;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.decorator.OakBerriesTreeDecorator;

import java.util.Collections;
import java.util.List;

public class ModConfiguredFeatures<FC extends FeatureConfig> {
    //Tree
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_LUMINESCENT_TREE_KEY = registerKey("blue_luminescent_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OAK_BERRIES_TREE_KEY = registerKey("oak_berries_tree_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PELTOGYNE_TREE_KEY = registerKey("peltogyne_tree_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COLORFUL_TREE_KEY = registerKey("colorful_tree_key");

    //huge mushrooms
    public static final RegistryKey<ConfiguredFeature<?, ?>> GREEN_MUSHROOM_TREE_KEY = registerKey("green_mushroom_tree_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PURPLE_MUSHROOM_TREE_KEY = registerKey("purple_mushroom_tree_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_LUMINESCENT_MUSHROOM_TREE_KEY = registerKey("blue_luminescent_mushroom_tree_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_LUMINESCENT_MUSHROOM_TREE_KEY = registerKey("pink_luminescent_mushroom_tree_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_GREEN_MUSHROOM_TREE_KEY = registerKey("big_green_mushroom_tree_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_RED_MUSHROOM_TREE_KEY = registerKey("big_red_mushroom_tree_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_MUSHROOM_TREE_KEY_WG = registerKey("wg_blue_mushroom_tree_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_MUSHROOM_TREE_KEY_OTH = registerKey("oth_blue_mushroom_tree_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_PURPLE_MUSHROOM_TREE_KEY_WG = registerKey("wg_big_purple_mushroom_tre_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_PURPLE_MUSHROOM_TREE_KEY_OTH = registerKey("oth_big_purple_mushroom_tre_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_MUSHROOM_TREE_KEY_WG = registerKey("wg_big_orange_mushroom_tree_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_MUSHROOM_TREE_KEY_OTH = registerKey("oth_big_orange_mushroom_tree_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_MUSHROOM_TREE_KEY_WG = registerKey("wg_big_yellow_mushroom_tree_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_MUSHROOM_TREE_KEY_OTH = registerKey("oth_big_yellow_mushroom_tree_key");

    //mushrooms
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_MUSHROOM_KEY = registerKey("blue_mushroom_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GREEN_MUSHROOM_KEY = registerKey("green_mushroom_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PURPLE_MUSHROOM_KEY = registerKey("purple_mushroom_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_LUMINESCENT_MUSHROOM_KEY = registerKey("pink_luminescent_mushroom_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_LUMINESCENT_MUSHROOM_KEY = registerKey("luminescent_mushroom_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_MUSHROOM_KEY = registerKey("orange_mushroom_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_MUSHROOM_KEY = registerKey("yellow_mushroom_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_MUSHROOM_KEY = registerKey("red_mushroom_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BROWN_MUSHROOM_KEY = registerKey("brown_mushroom_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FERTILE_RED_MUSHROOM_KEY = registerKey("fertile_red_mushroom_key");

    //Flowers Mushrooms
    public static final RegistryKey<ConfiguredFeature<?, ?>> STERILE_BLUE_MUSHROOM_KEY = registerKey("sterile_blue_mushroom_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MUSHROOM_SMALL_BROWN_KEY = registerKey("mushroom_small_brown_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MUSHROOM_SMALL_RED_KEY = registerKey("mushroom_small_red_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MUSHROOM_DEATH_TRUMPET_KEY = registerKey("mushroom_death_trumpet_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MUSHROOM_SIDE_BLUE_LUMINESCENT_KEY = registerKey("mushroom_side_blue_luminescent_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MUSHROOM_RED_FERTILE_FLOWER_KEY = registerKey("mushroom_red_fertile_flower_key");


    //flowers
    public static final RegistryKey<ConfiguredFeature<?, ?>> OCULAE_KEY = registerKey("oculae_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FUTIALI_KEY = registerKey("futiali_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MUSHROOM_FLOWERS_KEY = registerKey("mushroom_flowers_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_LUMERIA_KEY = registerKey("red_lumeria_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SOL_OCCIDENTIS_KEY = registerKey("sol_occidentis_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CYANEA_KEY = registerKey("cynea_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CYANUS_RUBENS_KEY = registerKey("cyanus_rubens_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NOCTULICA_KEY = registerKey("noctulica_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TURQUOSUM_STILUS_KEY = registerKey("turquosum_stilus_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CAERULEA_VOLUBILIS_KEY = registerKey("caerulea_volubilis_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPHIRA_FLORENS_KEY = registerKey("saphira_florens_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PREHISTO_PINK_SCHROOM_KEY = registerKey("prehisto_pink_schroom_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PREHISTO_BLUE_SCHROOM_KEY = registerKey("prehisto_blue_schroom_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PREHISTO_GREEN_SCHROOM_KEY = registerKey("prehisto_green_schroom_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PREHISTURPLE_SCHROOM_KEY = registerKey("prehisturple_schroom_key");

    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_PERENNIAL_KEY = registerKey("yellow_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_PERENNIAL_KEY = registerKey("blue_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GREEN_PERENNIAL_KEY = registerKey("green_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_PERENNIAL_KEY = registerKey("orange_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_PERENNIAL_KEY = registerKey("pink_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PURPLE_PERENNIAL_KEY = registerKey("purple_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUMINESCENT_PERENNIAL_KEY = registerKey("luminescent_perennial_key");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_PATCH_YELLOW_PERENNIAL_KEY = registerKey("small_patch_yellow_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_PATCH_BLUE_PERENNIAL_KEY = registerKey("small_patch_blue_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_PATCH_GREEN_PERENNIAL_KEY = registerKey("small_patch_green_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_PATCH_ORANGE_PERENNIAL_KEY = registerKey("small_patch_orange_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_PATCH_PINK_PERENNIAL_KEY = registerKey("small_patch_pink_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_PATCH_PURPLE_PERENNIAL_KEY = registerKey("small_patch_purple_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_PATCH_LUMINESCENT_PERENNIAL_KEY = registerKey("small_patch_luminescent_perennial_key");

    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_QUINCE_KEY = registerKey("red_quince_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_QUINCE_KEY = registerKey("yellow_quince_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TINY_LILAC_KEY = registerKey("tiny_lilac_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELICE_KEY = registerKey("yelice_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLAMESTHYSIA_KEY = registerKey("flamesthysia_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> APAGANTHE_KEY = registerKey("apaganthe_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_HEATER_KEY = registerKey("pink_heater_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WYSTERIA_KEY = registerKey("wysteria_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUEBELL_KEY = registerKey("bluebell_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VIPERIN_KEY = registerKey("viperin_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HIBISCUS_KEY = registerKey("hibiscus_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PLATUM_KEY = registerKey("platum_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIANTHUS_KEY = registerKey("dianthus_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CYCAS_KEY = registerKey("cycas_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ARUM_KEY = registerKey("arum_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HYDRANGEA_KEY = registerKey("hydrangea_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ANEMONE_KEY = registerKey("anemone_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> JACYNTHE_KEY = registerKey("jacynthe_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ACONIT_KEY = registerKey("aconit_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PERVENCHE_KEY = registerKey("pervenche_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RAPANGE_FLOWERS_KEY = registerKey("rapange_flowers_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLEUR_BERRIES_KEY = registerKey("fleur_berries_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PICK_BLUE_KEY = registerKey("pick_blue_key");

    //Grass
    public static final RegistryKey<ConfiguredFeature<?, ?>> TINY_GRASSS_KEY = registerKey("tiny_grass_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GRASS_KEY = registerKey("grass_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_GRASS_KEY = registerKey("dense_grass_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GRASS_BLUE_LUMINESCENT_KEY = registerKey("grass_blue_luminescent_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_GRASS_BLUE_LUMINESCENT_KEY = registerKey("grass_tall_blue_luminescent_key");

    //Vines
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_LUMINESCENT_VINES_UP_KEY = registerKey("blue_luminescent_vines_up_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_LUMINESCENT_VINES_DOWN_KEY = registerKey("blue_luminescent_vines_down_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HANGING_ROOT_KEY = registerKey("hanging_root_key");

    //Bush
    public static final RegistryKey<ConfiguredFeature<?, ?>> BUSH_KEY = registerKey("bush_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COLORFUL_BUSH_KEY = registerKey("colorful_bush_key");

    //Crystal
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_CRYSTAL_KEY = registerKey("red_crystal_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_CRYSTAL_KEY = registerKey("blue_crystal_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_CRYSTAL_KEY = registerKey("white_crystal_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_CRYSTAL_PILLAR_KEY = registerKey("blue_crystal_pillar_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_CRYSTAL_PILLAR_KEY = registerKey("red_crystal_pillar_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_CRYSTAL_PILLAR_KEY = registerKey("white_crystal_pillar_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CRYSTAL_BLUE_KEY = registerKey("crystal_blue_key");

    //Ore
    public static final RegistryKey<ConfiguredFeature<?, ?>> AMBER_ORE_KEY = registerKey("amber_ore_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RHYOLITE_KEY = registerKey("rhyolite_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AMBER_MINERAL_KEY = registerKey("amber_mineral_key");

    //terrain
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAKURA_ARCH_KEY = registerKey("sakura_arch_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAKURA_ROCK_STRAIGHT_KEY = registerKey("sakura_rock_straight_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPIRAL_MUSHROOM_KEY = registerKey("spiral_mushroom_key");

    //Dev
    public static final RegistryKey<ConfiguredFeature<?, ?>> FEATURE_TESTER_KEY = registerKey("feature_teste_key");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        //tree
        register(context, BLUE_LUMINESCENT_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.BLUE_LUMINESCENT_LOG), new BlueLuminescentTrunkPlacer(5, 5, 4),
                BlockStateProvider.of(ModBlocks.BLUE_LUMINESCENT_LEAVES), new BlueLuminescentFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(1), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, OAK_BERRIES_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG), new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.of(ModBlocks.OAK_BERRIES_LEAVES.getDefaultState().with(Properties.BERRIES, false)), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).decorators(Collections.singletonList(OakBerriesTreeDecorator.INSTANCE)).build());

        register(context, PELTOGYNE_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PELTOGYNE_LOG), new PeltogyneTrunkPlacer(8, 4, 3),
                BlockStateProvider.of(ModBlocks.PELTOGYNE_LEAVES), new PeltogyneFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(10), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, COLORFUL_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG), new ColorfulTreeTrunkPlacer(6, 3, 2),
                BlockStateProvider.of(ModBlocks.PELTOGYNE_LEAVES), new ColorfulTreeFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(10), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());
        //huge mushrooms
        register(context, PURPLE_MUSHROOM_TREE_KEY, ModFeatures.HUGE_PURPLE_MUSHROOM, new HugeMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.PURPLE_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 5));
        register(context, GREEN_MUSHROOM_TREE_KEY, ModFeatures.HUGE_GREEN_MUSHROOM, new ModMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.GREEN_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 20));
        register(context, BLUE_LUMINESCENT_MUSHROOM_TREE_KEY, ModFeatures.HUGE_BLUE_LUMINESCENT_MUSHROOM, new HugeMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK), BlockStateProvider.of(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_STEM), 3));
        register(context, PINK_LUMINESCENT_MUSHROOM_TREE_KEY, ModFeatures.HUGE_LUMINESCENT_PINK_MUSHROOM, new HugeMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK), BlockStateProvider.of(ModBlocks.TRANSPARENT_MUSHROOM_STEM), 4));
        register(context, BIG_PURPLE_MUSHROOM_TREE_KEY_WG, ModFeatures.HUGE_BIG_PURPLE_MUSHROOM_WG, new PurpleMushroomConfig(8, 20, 2, 6));
        register(context, BIG_PURPLE_MUSHROOM_TREE_KEY_OTH, ModFeatures.HUGE_BIG_PURPLE_MUSHROOM_OTH, new PurpleMushroomConfig(12, 26, 2, 6));
        register(context, BIG_GREEN_MUSHROOM_TREE_KEY, ModFeatures.HUGE_BIG_GREEN_MUSHROOM, new HugeMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.GREEN_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 4));
        register(context, BIG_RED_MUSHROOM_TREE_KEY, ModFeatures.HUGE_BIG_RED_MUSHROOM, new ModMushroomFeatureConfig(BlockStateProvider.of(Blocks.RED_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 4));
        register(context, BLUE_MUSHROOM_TREE_KEY_WG, ModFeatures.HUGE_BLUE_MUSHROOM_WG, new ModMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 4));
        register(context, BLUE_MUSHROOM_TREE_KEY_OTH, ModFeatures.HUGE_BLUE_MUSHROOM_OTH, new ModMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 4));
        register(context, YELLOW_MUSHROOM_TREE_KEY_WG, ModFeatures.HUGE_YELLOW_MUSHROOM_WG, new HugeMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.YELLOW_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 4));
        register(context, YELLOW_MUSHROOM_TREE_KEY_OTH, ModFeatures.HUGE_YELLOW_MUSHROOM_OTH, new HugeMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.YELLOW_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 4));
        register(context, ORANGE_MUSHROOM_TREE_KEY_WG, ModFeatures.HUGE_BIG_ORANGE_MUSHROOM_WG, new DefaultFeatureConfig());
        register(context, ORANGE_MUSHROOM_TREE_KEY_OTH, ModFeatures.HUGE_BIG_ORANGE_MUSHROOM_OTH, new DefaultFeatureConfig());
        register(context, FERTILE_RED_MUSHROOM_KEY, ModFeatures.FERTILE_RED_MUSHROOM, new DefaultFeatureConfig());

        //mushrooms
        register(context, BLUE_MUSHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_MUSHROOM)))));
        register(context, GREEN_MUSHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GREEN_MUSHROOM)))));
        register(context, PURPLE_MUSHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PURPLE_MUSHROOM)))));
        register(context, BLUE_LUMINESCENT_MUSHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(40, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_LUMINESCENT_MUSHROOM)))));
        register(context, PINK_LUMINESCENT_MUSHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUMINESCENT_PINK_MUSHROOM)))));
        register(context, RED_MUSHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.RED_MUSHROOM)))));
        register(context, BROWN_MUSHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.BROWN_MUSHROOM)))));


        //Flowers Mushrooms
        register(context, STERILE_BLUE_MUSHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(40, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.STERILE_BLUE_MUSHROOM)))));
        register(context, MUSHROOM_SMALL_BROWN_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(40, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MUSHROOM_SMALL_BROWN)))));
        register(context, MUSHROOM_SMALL_RED_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(40, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MUSHROOM_DEATH_TRUMPET)))));
        register(context, MUSHROOM_DEATH_TRUMPET_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(50, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MUSHROOM_SMALL_RED)))));
        register(context, MUSHROOM_SIDE_BLUE_LUMINESCENT_KEY, ModFeatures.SIMPLE_BLOCK, new ModSimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SIDE_MUSHROOM_BLUE_LUMINESCENT)));
        register(context, MUSHROOM_RED_FERTILE_FLOWER_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(50, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FERTILE_RED_MUSHROOM)))));

        //flowers
        register(context, FUTIALI_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(42, 14, 5, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FUTIALI)))));
        register(context, OCULAE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.OCULAE)))));
        register(context, RED_LUMERIA_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RED_LUMERIA)))));
        register(context, MUSHROOM_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MUSHROOM_FLOWERS)))));
        register(context, SOL_OCCIDENTIS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SOL_OCCIDENTIS)))));
        register(context, CYANEA_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(42, 14, 7, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CYANEA)))));
        register(context, CYANUS_RUBENS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CYANUS_RUBENS)))));
        register(context, NOCTULICA_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(40, 14, 5, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.NOCTULICA)))));
        register(context, TURQUOSUM_STILUS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(40, 14, 10, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TURQUOSUM_STILUS)))));
        register(context, CAERULEA_VOLUBILIS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CAERULEA_VOLUBILIS)))));
        register(context, SAPHIRA_FLORENS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SAPHIRA_FLORENS)))));
        register(context, PREHISTURPLE_SCHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PREHISTURPLE_SCHROOM)))));
        register(context, PREHISTO_BLUE_SCHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PREHISTO_BLUE_SCHROOM)))));
        register(context, PREHISTO_GREEN_SCHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PREHISTO_GREEN_SCHROOM)))));
        register(context, PREHISTO_PINK_SCHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(37, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PREHISTO_PINK_SCHROOM)))));


        register(context, PURPLE_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(28, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PURPLE_PERENNIAL)))));
        register(context, YELLOW_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(28, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.YELLOW_PERENNIAL)))));
        register(context, PINK_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(28, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PINK_PERENNIAL)))));
        register(context, ORANGE_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(28, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ORANGE_PERENNIAL)))));
        register(context, BLUE_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(28, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_PERENNIAL)))));
        register(context, GREEN_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(28, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GREEN_PERENNIAL)))));
        register(context, LUMINESCENT_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(28, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUMINESCENT_PERENNIAL)))));

        register(context, SMALL_PATCH_PURPLE_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(16, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PURPLE_PERENNIAL)))));
        register(context, SMALL_PATCH_YELLOW_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(16, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.YELLOW_PERENNIAL)))));
        register(context, SMALL_PATCH_PINK_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(16, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PINK_PERENNIAL)))));
        register(context, SMALL_PATCH_ORANGE_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(16, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ORANGE_PERENNIAL)))));
        register(context, SMALL_PATCH_BLUE_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(16, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_PERENNIAL)))));
        register(context, SMALL_PATCH_GREEN_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(16, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GREEN_PERENNIAL)))));
        register(context, SMALL_PATCH_LUMINESCENT_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(16, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUMINESCENT_PERENNIAL)))));


        register(context, RED_QUINCE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RED_QUINCE)))));
        register(context, YELLOW_QUINCE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.YELLOW_QUINCE)))));
        register(context, TINY_LILAC_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TINY_LILAC)))));
        register(context, YELICE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.YELICE)))));
        register(context, FLAMESTHYSIA_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FLAMESTHYSIA)))));
        register(context, APAGANTHE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.APAGANTHE)))));
        register(context, PINK_HEATER_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PINK_HEATER)))));
        register(context, WYSTERIA_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WYSTERIA)))));
        register(context, BLUEBELL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUEBELL)))));
        register(context, VIPERIN_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.VIPERIN)))));
        register(context, HIBISCUS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.HIBISCUS)))));
        register(context, PLATUM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PLATUM)))));
        register(context, DIANTHUS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.DIANTHUS)))));
        register(context, CYCAS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CYCAS)))));
        register(context, ARUM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ARUM)))));
        register(context, HYDRANGEA_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.HYDRANGEA)))));
        register(context, ANEMONE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ANEMONE)))));
        register(context, JACYNTHE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.JACYNTHE)))));
        register(context, ACONIT_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 14, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ACONIT)))));
        register(context, PERVENCHE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(20, 6, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PERVENCHE)))));
        register(context, ORANGE_MUSHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ORANGE_MUSHROOM)))));
        register(context, YELLOW_MUSHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.YELLOW_MUSHROOM)))));
        register(context, PICK_BLUE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(12, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PICK_BLUE)))));

        register(context, RAPANGE_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(64, 7, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RAPANGE_FLOWERS)))));
        register(context, FLEUR_BERRIES_KEY, ModFeatures.FLEUR_BERRIES, new DefaultFeatureConfig());
        //Grass
        register(context, TINY_GRASSS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TINY_GRASS)))));
        register(context, GRASS_BLUE_LUMINESCENT_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(43, 12, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_LUMINESCENT_GRASS)))));
        register(context, TALL_GRASS_BLUE_LUMINESCENT_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(43, 12, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_LUMINESCENT_TALL_GRASS)))));
        register(context, GRASS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(40, 12, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.SHORT_GRASS)))));
        register(context, DENSE_GRASS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(80, 12, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.SHORT_GRASS)))));

        //vines
        register(context, BLUE_LUMINESCENT_VINES_UP_KEY, ModFeatures.BLUE_LUMINESCENT_VINES, new TwistingVinesFeatureConfig(8, 1, 20));
        register(context, BLUE_LUMINESCENT_VINES_DOWN_KEY, ModFeatures.SIMPLE_VINES, new DirectionConfig(Direction.DOWN, BlockStateProvider.of(ModBlocks.BLUE_LUMINESCENT_VINES)));
        register(context, HANGING_ROOT_KEY, ModFeatures.SIMPLE_BLOCK, new ModSimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.HANGING_ROOTS)));

        //Bush
        register(context, BUSH_KEY, ModFeatures.BUSH, new DefaultFeatureConfig());
        register(context, COLORFUL_BUSH_KEY, ModFeatures.COLORFUL_BUSH, new DefaultFeatureConfig());

        //Crystal
        register(context, RED_CRYSTAL_KEY, ModFeatures.CRYSTAL, new CrystalConfig(15, 9, BlockStateProvider.of(ModBlocks.RED_CRYSTAL)));
        register(context, BLUE_CRYSTAL_KEY, ModFeatures.CRYSTAL, new CrystalConfig(15, 9, BlockStateProvider.of(ModBlocks.BLUE_CRYSTAL)));
        register(context, WHITE_CRYSTAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(33, 9, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WHITE_CRYSTAL)))));
        register(context, BLUE_CRYSTAL_PILLAR_KEY, ModFeatures.CRYSTAL_PILLAR, new ModSimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_CRYSTAL_BLOCK)));
        register(context, RED_CRYSTAL_PILLAR_KEY, ModFeatures.CRYSTAL_PILLAR, new ModSimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RED_CRYSTAL_BLOCK)));
        register(context, WHITE_CRYSTAL_PILLAR_KEY, ModFeatures.CRYSTAL_PILLAR, new ModSimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WHITE_CRYSTAL_BLOCK)));
        register(context, CRYSTAL_BLUE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(10, 10, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_CRYSTAL_CLUSTER)))));

        //ore
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> netherAmberOres = List.of(OreFeatureConfig.createTarget(netherReplacables, ModBlocks.AMBER_ORE.getDefaultState()));
        register(context, AMBER_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherAmberOres, 14));
        register(context, AMBER_MINERAL_KEY, ModFeatures.AMBER_MINERAL, new DefaultFeatureConfig());

        List<OreFeatureConfig.Target> overworldRhyoliteOre = List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.RHYOLITE.getDefaultState()));
        register(context, RHYOLITE_KEY, Feature.ORE, new OreFeatureConfig(overworldRhyoliteOre, 14));

        //terrain
        register(context, SAKURA_ARCH_KEY, ModFeatures.ARCH, new ArchConfig(10, 3, 60, 30, 30, 30, 30));
        register(context, SAKURA_ROCK_STRAIGHT_KEY, ModFeatures.SAKURA_ROCK_STRAIGHT, new DefaultFeatureConfig());
        register(context, SPIRAL_MUSHROOM_KEY, ModFeatures.SPIRAL_MUSHROOM, new DefaultFeatureConfig());

        //Dev
        register(context, FEATURE_TESTER_KEY, ModFeatures.FEATURE_TESTER, new ModSimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.REDSTONE_BLOCK)));


    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MushrooomsMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
