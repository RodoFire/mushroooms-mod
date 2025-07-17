package fr.rodofire.mushrooomsmod.world.features.configuredfeatures;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TwistingVinesConfig;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.world.features.config.*;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.*;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.decorator.OakBerriesTreeDecorator;

import java.util.Collections;
import java.util.List;

public class ModConfiguredFeatures<FC extends FeatureConfiguration> {
    //Tree
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_LUMINESCENT_TREE = registerKey("blue_luminescent_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_BERRIES_TREE = registerKey("oak_berries_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PELTOGYNE_TREE = registerKey("peltogyne_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COLORFUL_TREE = registerKey("colorful_tree");

    //huge mushrooms
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_MUSHROOM_TREE = registerKey("green_mushroom_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_MUSHROOM_TREE = registerKey("purple_mushroom_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_LUMINESCENT_MUSHROOM_TREE = registerKey("blue_luminescent_mushroom_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_LUMINESCENT_MUSHROOM_TREE = registerKey("pink_luminescent_mushroom_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYING_GREEN_MUSHROOM_TREE = registerKey("crying_green_mushroom_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_RED_MUSHROOM_TREE = registerKey("big_red_mushroom_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_MUSHROOM_TREE = registerKey("blue_mushroom_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_MUSHROOM_TREE_WG = registerKey("blue_mushroom_tree_wg");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_PURPLE_MUSHROOM_TREE = registerKey("big_purple_mushroom_tre");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_MUSHROOM_TREE = registerKey("big_orange_mushroom_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_MUSHROOM_TREE_WG = registerKey("big_orange_mushroom_tree_wg");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_MUSHROOM_TREE = registerKey("big_yellow_mushroom_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SINUSO_SHROOM = registerKey("sinuso_shroom");

    //mushrooms
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_MUSHROOM = registerKey("blue_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_MUSHROOM = registerKey("green_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_GREEN_MUSHROOM = registerKey("light_green_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_MUSHROOM = registerKey("purple_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_LUMINESCENT_MUSHROOM = registerKey("pink_luminescent_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_LUMINESCENT_MUSHROOM = registerKey("luminescent_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_MUSHROOM = registerKey("orange_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_ORANGE_MUSHROOM = registerKey("light_orange_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_MUSHROOM = registerKey("yellow_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_YELLOW_MUSHROOM = registerKey("light_yellow_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MUSHROOM = registerKey("red_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_MUSHROOM = registerKey("brown_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FERTILE_RED_MUSHROOM = registerKey("fertile_red_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUSHY_YELLOW_MUSHROOMS = registerKey("bushy_yellow_mushrooms");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BRIGHT_YELLOW_MUSHROOM = registerKey("bright_yellow_mushroom");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_PURPLE_MUSHROOM_PLANT = registerKey("big_purple_mushroom_plant");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TINY_PURPLE_MUSHROOM = registerKey("tiny_purple_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LITTLE_PURPLE_MUSHROOM = registerKey("little_purple_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEDIUM_PURPLE_MUSHROOM = registerKey("medium_purple_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_PURPLE_MUSHROOM = registerKey("big_purple_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TINY_GREEN_MUSHROOM = registerKey("tiny_green_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LITTLE_GREEN_MUSHROOM = registerKey("little_green_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEDIUM_GREEN_MUSHROOM = registerKey("medium_green_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_GREEN_MUSHROOM = registerKey("big_green_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_GREEN_MUSHROOM_PLANT = registerKey("big_green_mushroom_plant");

    //Flowers Mushrooms
    public static final ResourceKey<ConfiguredFeature<?, ?>> STERILE_BLUE_MUSHROOM = registerKey("sterile_blue_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUSHROOM_SMALL_BROWN = registerKey("mushroom_small_brown");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUSHROOM_SMALL_RED = registerKey("mushroom_small_red");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUSHROOM_DEATH_TRUMPET = registerKey("mushroom_death_trumpet");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUSHROOM_SIDE_BLUE_LUMINESCENT = registerKey("mushroom_side_blue_luminescent");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUSHROOM_RED_FERTILE_FLOWER = registerKey("mushroom_red_fertile_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUSHROOM_TALL_YELLOW = registerKey("tall_yellow_mushroom");


    //flowers
    public static final ResourceKey<ConfiguredFeature<?, ?>> OCULAE = registerKey("oculae");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FUTIALI = registerKey("futiali");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUSHROOM_FLOWERS = registerKey("mushroom_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_LUMERIA = registerKey("red_lumeria");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOL_OCCIDENTIS = registerKey("sol_occidentis");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYANEA = registerKey("cynea");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYANUS_RUBENS = registerKey("cyanus_rubens");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NOCTULICA = registerKey("noctulica");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_NOCTULICA = registerKey("light_noctulica");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TURQUOSUM_STILUS = registerKey("turquosum_stilus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_TURQUOSUM_STILUS = registerKey("light_turquosum_stilus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAERULEA_VOLUBILIS = registerKey("caerulea_volubilis");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPHIRA_FLORENS = registerKey("saphira_florens");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PREHISTO_PINK_SCHROOM = registerKey("prehisto_pink_schroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PREHISTO_BLUE_SCHROOM = registerKey("prehisto_blue_schroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PREHISTO_GREEN_SCHROOM = registerKey("prehisto_green_schroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PREHISTURPLE_SCHROOM = registerKey("prehisturple_schroom");

    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_PERENNIAL = registerKey("yellow_perennial");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_PERENNIAL = registerKey("blue_perennial");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_PERENNIAL = registerKey("green_perennial");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_PERENNIAL = registerKey("orange_perennial");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_PERENNIAL = registerKey("pink_perennial");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_PERENNIAL = registerKey("purple_perennial");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LUMINESCENT_PERENNIAL = registerKey("luminescent_perennial");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_PATCH_YELLOW_PERENNIAL = registerKey("small_patch_yellow_perennial");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_PATCH_BLUE_PERENNIAL = registerKey("small_patch_blue_perennial");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_PATCH_GREEN_PERENNIAL = registerKey("small_patch_green_perennial");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_PATCH_ORANGE_PERENNIAL = registerKey("small_patch_orange_perennial");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_PATCH_PINK_PERENNIAL = registerKey("small_patch_pink_perennial");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_PATCH_PURPLE_PERENNIAL = registerKey("small_patch_purple_perennial");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_PATCH_LUMINESCENT_PERENNIAL = registerKey("small_patch_luminescent_perennial");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_QUINCE = registerKey("red_quince");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_QUINCE = registerKey("yellow_quince");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TINY_LILAC = registerKey("tiny_lilac");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_TINY_LILAC = registerKey("light_tiny_lilac");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELICE = registerKey("yelice");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLAMESTHYSIA = registerKey("flamesthysia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> APAGANTHE = registerKey("apaganthe");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_APAGANTHE = registerKey("light_apaganthe");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_HEATER = registerKey("pink_heater");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WYSTERIA = registerKey("wysteria");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_WYSTERIA = registerKey("light_wysteria");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUEBELL = registerKey("bluebell");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_BLUEBELL = registerKey("light_bluebell");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VIPERIN = registerKey("viperin");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIBISCUS = registerKey("hibiscus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLATUM = registerKey("platum");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIANTHUS = registerKey("dianthus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYCAS = registerKey("cycas");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ARUM = registerKey("arum");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HYDRANGEA = registerKey("hydrangea");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANEMONE = registerKey("anemone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JACYNTHE = registerKey("jacynthe");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ACONIT = registerKey("aconit");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_ACONIT = registerKey("light_aconit");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PERVENCHE = registerKey("pervenche");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_PERVENCHE = registerKey("light_pervenche");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RAPANGE_FLOWERS = registerKey("rapange_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLEUR_BERRIES = registerKey("fleur_berries");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_RAPANGE_FLOWERS = registerKey("light_rapange_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PICK_BLUE = registerKey("pick_blue");

    //Grass
    public static final ResourceKey<ConfiguredFeature<?, ?>> TINY_GRASSS = registerKey("tiny_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRASS = registerKey("grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIGHT_GRASS = registerKey("light_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_GRASS = registerKey("dense_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_TALL_GRASS = registerKey("dense_tall_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRASS_BLUE_LUMINESCENT = registerKey("grass_blue_luminescent");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_GRASS_BLUE_LUMINESCENT = registerKey("grass_tall_blue_luminescent");

    //Vines
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_LUMINESCENT_VINES_UP = registerKey("blue_luminescent_vines_up");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_LUMINESCENT_VINES_DOWN = registerKey("blue_luminescent_vines_down");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HANGING_ROOT = registerKey("hanging_root");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VINES = registerKey("vines");

    //Bush
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUSH = registerKey("bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COLORFUL_BUSH = registerKey("colorful_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_BUSH = registerKey("cave_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_TOP_BUSH = registerKey("cave_top_bush");

    //Crystal
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_CRYSTAL = registerKey("red_crystal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_CRYSTAL = registerKey("blue_crystal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_CRYSTAL = registerKey("white_crystal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_CRYSTAL_PILLAR = registerKey("blue_crystal_pillar");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_CRYSTAL_PILLAR = registerKey("red_crystal_pillar");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_CRYSTAL_PILLAR = registerKey("white_crystal_pillar");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTAL_BLUE = registerKey("crystal_blue");

    //Ore
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMBER_ORE = registerKey("amber_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RHYOLITE = registerKey("rhyolite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMBER_MINERAL = registerKey("amber_mineral");

    //terrain
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_ARCH = registerKey("sakura_arch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_ROCK_STRAIGHT = registerKey("sakura_rock_straight");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_ROCK_FLAT = registerKey("sakura_rock_flat");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROCKY_STALACTITE = registerKey("rocky_stalactite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOSSY_STALACTITE = registerKey("mossy_stalactite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_STALACTITE = registerKey("huge_stalactite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TINY_PUDDLE = registerKey("tiny_puddle");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPIRAL_MUSHROOM = registerKey("spiral_mushroom");

    //Dev
    public static final ResourceKey<ConfiguredFeature<?, ?>> FEATURE_TESTER = registerKey("feature_teste");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        //tree
        register(context, BLUE_LUMINESCENT_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.BLUE_LUMINESCENT_LOG.get()), new BlueLuminescentTrunkPlacer(5, 5, 4),
                BlockStateProvider.simple(ModBlocks.BLUE_LUMINESCENT_LEAVES.get()), new BlueLuminescentFoliagePlacer(ConstantInt.of(4), ConstantInt.of(1), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, OAK_BERRIES_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG), new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(ModBlocks.OAK_BERRIES_LEAVES.get().defaultBlockState().setValue(BlockStateProperties.BERRIES, false)), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).decorators(Collections.singletonList(OakBerriesTreeDecorator.INSTANCE)).build());

        register(context, PELTOGYNE_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PELTOGYNE_LOG.get()), new PeltogyneTrunkPlacer(8, 4, 3),
                BlockStateProvider.simple(ModBlocks.PELTOGYNE_LEAVES.get()), new PeltogyneFoliagePlacer(ConstantInt.of(4), ConstantInt.of(10), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, COLORFUL_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG), new ColorfulTreeTrunkPlacer(6, 3, 2),
                BlockStateProvider.simple(ModBlocks.PELTOGYNE_LEAVES.get()), new ColorfulTreeFoliagePlacer(ConstantInt.of(4), ConstantInt.of(10), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());
        //huge mushrooms
        register(context, PURPLE_MUSHROOM_TREE, ModFeatures.HUGE_PURPLE_MUSHROOM, new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(ModBlocks.PURPLE_MUSHROOM_BLOCK.get()), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), 5));
        register(context, GREEN_MUSHROOM_TREE, ModFeatures.HUGE_GREEN_MUSHROOM, new ModMushroomFeatureConfig(BlockStateProvider.simple(ModBlocks.GREEN_MUSHROOM_BLOCK.get()), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), 20));
        register(context, BLUE_LUMINESCENT_MUSHROOM_TREE, ModFeatures.HUGE_BLUE_LUMINESCENT_MUSHROOM, new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK.get()), BlockStateProvider.simple(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_STEM.get()), 3));
        register(context, PINK_LUMINESCENT_MUSHROOM_TREE, ModFeatures.HUGE_LUMINESCENT_PINK_MUSHROOM, new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK.get()), BlockStateProvider.simple(ModBlocks.TRANSPARENT_MUSHROOM_STEM.get()), 4));
        register(context, BIG_PURPLE_MUSHROOM_TREE, ModFeatures.HUGE_BIG_PURPLE_MUSHROOM, new PurpleMushroomConfig(12, 26, 2, 6));
        register(context, CRYING_GREEN_MUSHROOM_TREE, ModFeatures.CRYING_BIG_GREEN_MUSHROOM, new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(ModBlocks.GREEN_MUSHROOM_BLOCK.get()), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), 4));
        register(context, BIG_RED_MUSHROOM_TREE, ModFeatures.HUGE_BIG_RED_MUSHROOM, new ModMushroomFeatureConfig(BlockStateProvider.simple(Blocks.RED_MUSHROOM_BLOCK), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), 4));
        register(context, BLUE_MUSHROOM_TREE, ModFeatures.HUGE_BLUE_MUSHROOM, new ModMushroomFeatureConfig(BlockStateProvider.simple(ModBlocks.BLUE_MUSHROOM_BLOCK.get()), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), 4));
        register(context, BLUE_MUSHROOM_TREE_WG, ModFeatures.HUGE_BLUE_MUSHROOM_WG, new ModMushroomFeatureConfig(BlockStateProvider.simple(ModBlocks.BLUE_MUSHROOM_BLOCK.get()), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), 4));
        register(context, YELLOW_MUSHROOM_TREE, ModFeatures.HUGE_YELLOW_MUSHROOM, new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(ModBlocks.YELLOW_MUSHROOM_BLOCK.get()), BlockStateProvider.simple(Blocks.MUSHROOM_STEM), 4));
        register(context, ORANGE_MUSHROOM_TREE, ModFeatures.HUGE_BIG_ORANGE_MUSHROOM, new NoneFeatureConfiguration());
        register(context, ORANGE_MUSHROOM_TREE_WG, ModFeatures.HUGE_BIG_ORANGE_MUSHROOM_WG, new NoneFeatureConfiguration());
        register(context, FERTILE_RED_MUSHROOM, ModFeatures.FERTILE_RED_MUSHROOM, new NoneFeatureConfiguration());
        register(context, SINUSO_SHROOM, ModFeatures.SINUSO_SHROOM, new NoneFeatureConfiguration());

        register(context, BUSHY_YELLOW_MUSHROOMS, Feature.FLOWER, new RandomPatchConfiguration(10, 6, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BUSHY_YELLOW_MUSHROOM.get())))));
        register(context, BRIGHT_YELLOW_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(10, 6, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BRIGHT_YELLOW_MUSHROOM.get())))));

        WeightedStateProvider bigPurpleMushroomPlant = new WeightedStateProvider(
                SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT.get().defaultBlockState(), 1)
                        .add(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT.get().defaultBlockState().setValue(BlockStateProperties.AGE_3, 1), 1)
                        .add(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT.get().defaultBlockState().setValue(BlockStateProperties.AGE_3, 2), 1)
                        .add(ModBlocks.BIG_PURPLE_MUSHROOM_PLANT.get().defaultBlockState().setValue(BlockStateProperties.AGE_3, 3), 1)
        );
        WeightedStateProvider bigGreenMushroomPlant = new WeightedStateProvider(
                SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.BIG_GREEN_MUSHROOM_PLANT.get().defaultBlockState(), 1)
                        .add(ModBlocks.BIG_GREEN_MUSHROOM_PLANT.get().defaultBlockState().setValue(BlockStateProperties.AGE_3, 1), 1)
                        .add(ModBlocks.BIG_GREEN_MUSHROOM_PLANT.get().defaultBlockState().setValue(BlockStateProperties.AGE_3, 2), 1)
                        .add(ModBlocks.BIG_GREEN_MUSHROOM_PLANT.get().defaultBlockState().setValue(BlockStateProperties.AGE_3, 3), 1)
        );
        register(context, BIG_PURPLE_MUSHROOM_PLANT, Feature.FLOWER, new RandomPatchConfiguration(8, 6, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(bigPurpleMushroomPlant))));
        register(context, TINY_PURPLE_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(8, 6, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TINY_PURPLE_MUSHROOM.get())))));
        register(context, LITTLE_PURPLE_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(8, 6, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LITTLE_PURPLE_MUSHROOM.get())))));
        register(context, MEDIUM_PURPLE_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(8, 6, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MEDIUM_PURPLE_MUSHROOM.get())))));
        register(context, BIG_PURPLE_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(8, 6, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BIG_PURPLE_MUSHROOM.get())))));
        register(context, TINY_GREEN_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(8, 6, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TINY_GREEN_MUSHROOM.get())))));
        register(context, LITTLE_GREEN_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(8, 6, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LITTLE_GREEN_MUSHROOM.get())))));
        register(context, MEDIUM_GREEN_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(8, 6, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MEDIUM_GREEN_MUSHROOM.get())))));
        register(context, BIG_GREEN_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(8, 6, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BIG_GREEN_MUSHROOM.get())))));
        register(context, BIG_GREEN_MUSHROOM_PLANT, Feature.FLOWER, new RandomPatchConfiguration(8, 6, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(bigGreenMushroomPlant))));

        //mushrooms
        register(context, BLUE_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUE_MUSHROOM.get())))));
        register(context, GREEN_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.GREEN_MUSHROOM.get())))));
        register(context, LIGHT_GREEN_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(10, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.GREEN_MUSHROOM.get())))));
        register(context, PURPLE_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PURPLE_MUSHROOM.get())))));
        register(context, BLUE_LUMINESCENT_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(40, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUE_LUMINESCENT_MUSHROOM.get())))));
        register(context, PINK_LUMINESCENT_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LUMINESCENT_PINK_MUSHROOM.get())))));
        register(context, RED_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.RED_MUSHROOM)))));
        register(context, BROWN_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.BROWN_MUSHROOM)))));
        register(context, ORANGE_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ORANGE_MUSHROOM.get())))));
        register(context, LIGHT_ORANGE_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(10, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ORANGE_MUSHROOM.get())))));
        register(context, YELLOW_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.YELLOW_MUSHROOM.get())))));
        register(context, LIGHT_YELLOW_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(10, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.YELLOW_MUSHROOM.get())))));


        //Flowers Mushrooms
        register(context, STERILE_BLUE_MUSHROOM, Feature.FLOWER, new RandomPatchConfiguration(40, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.STERILE_BLUE_MUSHROOM.get())))));
        register(context, MUSHROOM_SMALL_BROWN, Feature.FLOWER, new RandomPatchConfiguration(40, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MUSHROOM_SMALL_BROWN.get())))));
        register(context, MUSHROOM_SMALL_RED, Feature.FLOWER, new RandomPatchConfiguration(40, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MUSHROOM_DEATH_TRUMPET.get())))));
        register(context, MUSHROOM_DEATH_TRUMPET, Feature.FLOWER, new RandomPatchConfiguration(50, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MUSHROOM_SMALL_RED.get())))));
        register(context, MUSHROOM_SIDE_BLUE_LUMINESCENT, ModFeatures.SIMPLE_BLOCK, new ModSimpleBlockFeatureConfig(BlockStateProvider.simple(ModBlocks.SIDE_MUSHROOM_BLUE_LUMINESCENT.get())));
        register(context, MUSHROOM_RED_FERTILE_FLOWER, Feature.FLOWER, new RandomPatchConfiguration(50, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.FERTILE_RED_MUSHROOM.get())))));
        register(context, MUSHROOM_TALL_YELLOW, Feature.FLOWER, new RandomPatchConfiguration(12, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TALL_YELLOW_MUSHROOMS.get())))));

        //flowers
        register(context, FUTIALI, Feature.FLOWER, new RandomPatchConfiguration(42, 14, 5, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.FUTIALI.get())))));
        register(context, OCULAE, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.OCULAE.get())))));
        register(context, RED_LUMERIA, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.RED_LUMERIA.get())))));
        register(context, MUSHROOM_FLOWERS, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MUSHROOM_FLOWERS.get())))));
        register(context, SOL_OCCIDENTIS, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SOL_OCCIDENTIS.get())))));
        register(context, CYANEA, Feature.FLOWER, new RandomPatchConfiguration(42, 14, 7, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CYANEA.get())))));
        register(context, CYANUS_RUBENS, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CYANUS_RUBENS.get())))));
        register(context, NOCTULICA, Feature.FLOWER, new RandomPatchConfiguration(40, 14, 5, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.NOCTULICA.get())))));
        register(context, LIGHT_NOCTULICA, Feature.FLOWER, new RandomPatchConfiguration(8, 16, 5, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.NOCTULICA.get())))));
        register(context, TURQUOSUM_STILUS, Feature.FLOWER, new RandomPatchConfiguration(40, 14, 10, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TURQUOSUM_STILUS.get())))));
        register(context, LIGHT_TURQUOSUM_STILUS, Feature.FLOWER, new RandomPatchConfiguration(8, 16, 10, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TURQUOSUM_STILUS.get())))));
        register(context, CAERULEA_VOLUBILIS, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CAERULEA_VOLUBILIS.get())))));
        register(context, SAPHIRA_FLORENS, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SAPHIRA_FLORENS.get())))));
        register(context, PREHISTURPLE_SCHROOM, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PREHISTURPLE_SCHROOM.get())))));
        register(context, PREHISTO_BLUE_SCHROOM, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PREHISTO_BLUE_SCHROOM.get())))));
        register(context, PREHISTO_GREEN_SCHROOM, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PREHISTO_GREEN_SCHROOM.get())))));
        register(context, PREHISTO_PINK_SCHROOM, Feature.FLOWER, new RandomPatchConfiguration(37, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PREHISTO_PINK_SCHROOM.get())))));


        register(context, PURPLE_PERENNIAL, Feature.FLOWER, new RandomPatchConfiguration(10, 3, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PURPLE_PERENNIAL.get())))));
        register(context, YELLOW_PERENNIAL, Feature.FLOWER, new RandomPatchConfiguration(10, 3, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.YELLOW_PERENNIAL.get())))));
        register(context, PINK_PERENNIAL, Feature.FLOWER, new RandomPatchConfiguration(10, 3, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PINK_PERENNIAL.get())))));
        register(context, ORANGE_PERENNIAL, Feature.FLOWER, new RandomPatchConfiguration(10, 3, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ORANGE_PERENNIAL.get())))));
        register(context, BLUE_PERENNIAL, Feature.FLOWER, new RandomPatchConfiguration(10, 3, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUE_PERENNIAL.get())))));
        register(context, GREEN_PERENNIAL, Feature.FLOWER, new RandomPatchConfiguration(10, 3, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.GREEN_PERENNIAL.get())))));
        register(context, LUMINESCENT_PERENNIAL, Feature.FLOWER, new RandomPatchConfiguration(10, 3, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LUMINESCENT_PERENNIAL.get())))));

        register(context, SMALL_PATCH_PURPLE_PERENNIAL, Feature.FLOWER, new RandomPatchConfiguration(16, 3, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PURPLE_PERENNIAL.get())))));
        register(context, SMALL_PATCH_YELLOW_PERENNIAL, Feature.FLOWER, new RandomPatchConfiguration(16, 3, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.YELLOW_PERENNIAL.get())))));
        register(context, SMALL_PATCH_PINK_PERENNIAL, Feature.FLOWER, new RandomPatchConfiguration(16, 3, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PINK_PERENNIAL.get())))));
        register(context, SMALL_PATCH_ORANGE_PERENNIAL, Feature.FLOWER, new RandomPatchConfiguration(16, 3, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ORANGE_PERENNIAL.get())))));
        register(context, SMALL_PATCH_BLUE_PERENNIAL, Feature.FLOWER, new RandomPatchConfiguration(16, 3, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUE_PERENNIAL.get())))));
        register(context, SMALL_PATCH_GREEN_PERENNIAL, Feature.FLOWER, new RandomPatchConfiguration(16, 3, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.GREEN_PERENNIAL.get())))));
        register(context, SMALL_PATCH_LUMINESCENT_PERENNIAL, Feature.FLOWER, new RandomPatchConfiguration(16, 3, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LUMINESCENT_PERENNIAL.get())))));


        register(context, RED_QUINCE, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.RED_QUINCE.get())))));
        register(context, YELLOW_QUINCE, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.YELLOW_QUINCE.get())))));
        register(context, TINY_LILAC, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TINY_LILAC.get())))));
        register(context, LIGHT_TINY_LILAC, Feature.FLOWER, new RandomPatchConfiguration(7, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TINY_LILAC.get())))));
        register(context, YELICE, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.YELICE.get())))));
        register(context, FLAMESTHYSIA, Feature.FLOWER, new RandomPatchConfiguration(7, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.FLAMESTHYSIA.get())))));
        register(context, APAGANTHE, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.APAGANTHE.get())))));
        register(context, LIGHT_APAGANTHE, Feature.FLOWER, new RandomPatchConfiguration(7, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.APAGANTHE.get())))));
        register(context, PINK_HEATER, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PINK_HEATER.get())))));
        register(context, WYSTERIA, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WYSTERIA.get())))));
        register(context, LIGHT_WYSTERIA, Feature.FLOWER, new RandomPatchConfiguration(7, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WYSTERIA.get())))));
        register(context, BLUEBELL, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUEBELL.get())))));
        register(context, LIGHT_BLUEBELL, Feature.FLOWER, new RandomPatchConfiguration(7, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUEBELL.get())))));
        register(context, VIPERIN, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.VIPERIN.get())))));
        register(context, HIBISCUS, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.HIBISCUS.get())))));
        register(context, PLATUM, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PLATUM.get())))));
        register(context, DIANTHUS, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.DIANTHUS.get())))));
        register(context, CYCAS, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CYCAS.get())))));
        register(context, ARUM, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ARUM.get())))));
        register(context, HYDRANGEA, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.HYDRANGEA.get())))));
        register(context, ANEMONE, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ANEMONE.get())))));
        register(context, JACYNTHE, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.JACYNTHE.get())))));
        register(context, ACONIT, Feature.FLOWER, new RandomPatchConfiguration(32, 14, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ACONIT.get())))));
        register(context, LIGHT_ACONIT, Feature.FLOWER, new RandomPatchConfiguration(7, 14, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ACONIT.get())))));
        register(context, PERVENCHE, Feature.FLOWER, new RandomPatchConfiguration(20, 6, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PERVENCHE.get())))));
        register(context, LIGHT_PERVENCHE, Feature.FLOWER, new RandomPatchConfiguration(7, 6, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PERVENCHE.get())))));
        register(context, PICK_BLUE, Feature.FLOWER, new RandomPatchConfiguration(12, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PICK_BLUE.get())))));

        register(context, RAPANGE_FLOWERS, Feature.FLOWER, new RandomPatchConfiguration(64, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.RAPANGE_FLOWERS.get())))));
        register(context, LIGHT_RAPANGE_FLOWERS, Feature.FLOWER, new RandomPatchConfiguration(6, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.RAPANGE_FLOWERS.get())))));
        register(context, FLEUR_BERRIES, ModFeatures.FLEUR_BERRIES, new FleurBerriesConfig(55, 9, 3));
        //Grass
        register(context, TINY_GRASSS, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TINY_GRASS.get())))));
        register(context, GRASS_BLUE_LUMINESCENT, Feature.FLOWER, new RandomPatchConfiguration(43, 12, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUE_LUMINESCENT_GRASS.get())))));
        register(context, TALL_GRASS_BLUE_LUMINESCENT, Feature.FLOWER, new RandomPatchConfiguration(43, 12, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUE_LUMINESCENT_TALL_GRASS.get())))));
        register(context, GRASS, Feature.FLOWER, new RandomPatchConfiguration(40, 12, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SHORT_GRASS)))));
        register(context, LIGHT_GRASS, Feature.FLOWER, new RandomPatchConfiguration(15, 12, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SHORT_GRASS)))));
        register(context, DENSE_GRASS, Feature.FLOWER, new RandomPatchConfiguration(80, 12, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SHORT_GRASS)))));
        register(context, DENSE_TALL_GRASS, Feature.FLOWER, new RandomPatchConfiguration(80, 12, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.TALL_GRASS)))));

        //vines
        register(context, BLUE_LUMINESCENT_VINES_UP, ModFeatures.BLUE_LUMINESCENT_VINES, new TwistingVinesConfig(8, 1, 20));
        register(context, BLUE_LUMINESCENT_VINES_DOWN, ModFeatures.SIMPLE_VINES, new DirectionConfig(Direction.DOWN, BlockStateProvider.simple(ModBlocks.BLUE_LUMINESCENT_VINES.get())));
        register(context, HANGING_ROOT, ModFeatures.SIMPLE_BLOCK, new ModSimpleBlockFeatureConfig(BlockStateProvider.simple(Blocks.HANGING_ROOTS)));
        register(context, VINES, ModFeatures.HANGING_VINES_GROW_FEATURES,
                new HangingGrowthFeatureConfig((VineBlock) Blocks.VINE,
                        20,
                        23,
                        false,
                        false,
                        true,
                        0.35f,
                        HolderSet.direct(
                                Block::builtInRegistryHolder,
                                Blocks.STONE,
                                Blocks.COBBLESTONE,
                                Blocks.MOSSY_COBBLESTONE,
                                Blocks.ANDESITE,
                                Blocks.DIORITE,
                                Blocks.GRANITE,
                                Blocks.DRIPSTONE_BLOCK,
                                Blocks.CALCITE,
                                Blocks.TUFF,
                                Blocks.DEEPSLATE
                        )));

        //Bush
        register(context, BUSH, ModFeatures.BUSH, new NoneFeatureConfiguration());
        register(context, COLORFUL_BUSH, ModFeatures.COLORFUL_BUSH, new NoneFeatureConfiguration());
        register(context, CAVE_BUSH, ModFeatures.CAVE_BUSH, new NoneFeatureConfiguration());
        register(context, CAVE_TOP_BUSH, ModFeatures.CAVE_TOP_BUSH, new NoneFeatureConfiguration());

        //Crystal
        register(context, RED_CRYSTAL, ModFeatures.CRYSTAL, new CrystalConfig(15, 9, BlockStateProvider.simple(ModBlocks.RED_CRYSTAL.get())));
        register(context, BLUE_CRYSTAL, ModFeatures.CRYSTAL, new CrystalConfig(15, 9, BlockStateProvider.simple(ModBlocks.BLUE_CRYSTAL.get())));
        register(context, WHITE_CRYSTAL, Feature.FLOWER, new RandomPatchConfiguration(33, 9, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WHITE_CRYSTAL.get())))));
        register(context, BLUE_CRYSTAL_PILLAR, ModFeatures.CRYSTAL_PILLAR, new ModSimpleBlockFeatureConfig(BlockStateProvider.simple(ModBlocks.BLUE_CRYSTAL_BLOCK.get())));
        register(context, RED_CRYSTAL_PILLAR, ModFeatures.CRYSTAL_PILLAR, new ModSimpleBlockFeatureConfig(BlockStateProvider.simple(ModBlocks.RED_CRYSTAL_BLOCK.get())));
        register(context, WHITE_CRYSTAL_PILLAR, ModFeatures.CRYSTAL_PILLAR, new ModSimpleBlockFeatureConfig(BlockStateProvider.simple(ModBlocks.WHITE_CRYSTAL_BLOCK.get())));
        register(context, CRYSTAL_BLUE, Feature.FLOWER, new RandomPatchConfiguration(10, 10, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUE_CRYSTAL_CLUSTER.get())))));

        //ore
        RuleTest stoneReplacables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> netherAmberOres = List.of(OreConfiguration.target(netherReplacables, ModBlocks.AMBER_ORE.get().defaultBlockState()));
        register(context, AMBER_ORE, Feature.ORE, new OreConfiguration(netherAmberOres, 14));
        register(context, AMBER_MINERAL, ModFeatures.AMBER_MINERAL, new NoneFeatureConfiguration());

        List<OreConfiguration.TargetBlockState> overworldRhyoliteOre = List.of(OreConfiguration.target(stoneReplacables, ModBlocks.RHYOLITE.get().defaultBlockState()));
        register(context, RHYOLITE, Feature.ORE, new OreConfiguration(overworldRhyoliteOre, 14));

        //terrain
        register(context, SAKURA_ARCH, ModFeatures.ARCH, new ArchConfig(10, 3, 60, 30, 30, 30, 30));
        register(context, SAKURA_ROCK_STRAIGHT, ModFeatures.SAKURA_ROCK_STRAIGHT, new NoneFeatureConfiguration());
        register(context, SAKURA_ROCK_FLAT, ModFeatures.SAKURA_ROCK_FLAT, new NoneFeatureConfiguration());
        register(context, ROCKY_STALACTITE, ModFeatures.ROCKY_STALACTITE, new StalactiteFeatureConfig(52));
        register(context, MOSSY_STALACTITE, ModFeatures.MOSSY_STALACTITE, new StalactiteFeatureConfig(39));
        register(context, HUGE_STALACTITE, ModFeatures.HUGE_STALACTITE, new NoneFeatureConfiguration());
        register(context, SPIRAL_MUSHROOM, ModFeatures.SPIRAL_MUSHROOM, new NoneFeatureConfiguration());
        register(context, TINY_PUDDLE, ModFeatures.TINY_PUDDLE, new NoneFeatureConfiguration());

        //Dev
        register(context, FEATURE_TESTER, ModFeatures.FEATURE_TESTER, new ModSimpleBlockFeatureConfig(BlockStateProvider.simple(Blocks.REDSTONE_BLOCK)));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                   ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
