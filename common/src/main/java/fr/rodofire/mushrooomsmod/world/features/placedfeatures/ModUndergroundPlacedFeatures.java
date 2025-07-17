package fr.rodofire.mushrooomsmod.world.features.placedfeatures;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;

import java.util.List;

public class ModUndergroundPlacedFeatures {
    //Mushrooms
    public static final ResourceKey<PlacedFeature> BLUE_LUMINESCENT_MUSHROOM = registerKey("blue_luminescent_mushroom_underground");
    public static final ResourceKey<PlacedFeature> BROWN_MUSHROOM = registerKey("brown_mushroom_underground");
    public static final ResourceKey<PlacedFeature> RED_MUSHROOM = registerKey("red_mushroom_underground");
    public static final ResourceKey<PlacedFeature> FERTILE_RED_MUSHROOM = registerKey("fertile_red_mushroom_underground");
    public static final ResourceKey<PlacedFeature> RED_LUMERIA = registerKey("red_lumeria_underground");
    public static final ResourceKey<PlacedFeature> MUSHROOM_FLOWERS = registerKey("mushroom_flowers_underground");

    //Tree
    public static final ResourceKey<PlacedFeature> OAK_TREE = registerKey("oak_tree_underground");
    public static final ResourceKey<PlacedFeature> AZALEA_TREE = registerKey("alazea_tree_underground");
    public static final ResourceKey<PlacedFeature> OAK_BERRIES_TREE = registerKey("oak_berries_tree_underground");
    public static final ResourceKey<PlacedFeature> BLUE_LUMINESCENT_TREE = registerKey("blue_luminescent_tree_underground");

    //Mushrooms Flowers
    public static final ResourceKey<PlacedFeature> MUSHROOM_SIDE_BLUE_LUMINESCENT = registerKey("mushroom_side_blue_luminescent_underground");
    public static final ResourceKey<PlacedFeature> MUSHROOM_SMALL_RED = registerKey("mushroom_small_red_underground");
    public static final ResourceKey<PlacedFeature> MUSHROOM_YELLOW = registerKey("mushroom_yellow_underground");
    public static final ResourceKey<PlacedFeature> MUSHROOM_SMALL_BROWN = registerKey("mushroom_small_brown_underground");
    public static final ResourceKey<PlacedFeature> MUSHROOM_DEATH_TRUMPET = registerKey("mushroom_death_trumpet_underground");
    public static final ResourceKey<PlacedFeature> MUSHROOM_FERTILE_RED_FLOWER = registerKey("mushroom_fertile_red_flower_underground");

    //Huge Mushrooms
    public static final ResourceKey<PlacedFeature> HUGE_RED_MUSHROOM = registerKey("huge_red_mushroom_underground");
    public static final ResourceKey<PlacedFeature> HUGE_BROWN_MUSHROOM = registerKey("huge_brown_mushroom_underground");
    public static final ResourceKey<PlacedFeature> BLUE_LUMINESCENT_MUSHROOM_TREE = registerKey("blue_luminescent_mushroom_tree_underground");
    public static final ResourceKey<PlacedFeature> PURPLE_MUSHROOM_TREE = registerKey("purple_mushroom_tree_underground");
    public static final ResourceKey<PlacedFeature> HUGE_PURPLE_MUSHROOM_TREE = registerKey("huge_purple_mushroom_tree_underground");
    public static final ResourceKey<PlacedFeature> PINK_LUMINESCENT_MUSHROOM_TREE = registerKey("pink_luminescent_mushroom_tree_underground");


    //Flowers
    public static final ResourceKey<PlacedFeature> PLATUM = registerKey("platum_underground");
    public static final ResourceKey<PlacedFeature> SAPHIRA_FLORENS = registerKey("saphira_underground_florens_placed_underground");
    public static final ResourceKey<PlacedFeature> NOCTULICA = registerKey("noctulica_underground");
    public static final ResourceKey<PlacedFeature> TURQUOSUM_STILUS = registerKey("turquosum_stilus_underground");
    public static final ResourceKey<PlacedFeature> FUTIALI = registerKey("futiali_underground");
    public static final ResourceKey<PlacedFeature> CYANEA = registerKey("cyanea_underground");
    public static final ResourceKey<PlacedFeature> YELLOW_QUINCE = registerKey("yellow_quince_underground");
    public static final ResourceKey<PlacedFeature> RED_QUINCE = registerKey("red_quince_underground");
    public static final ResourceKey<PlacedFeature> PINK_HEATER = registerKey("pink_heater_underground");
    public static final ResourceKey<PlacedFeature> OCULAE = registerKey("oculae_underground");
    public static final ResourceKey<PlacedFeature> CYCAS = registerKey("cycas_underground");
    public static final ResourceKey<PlacedFeature> RAPANGE_FLOWERS = registerKey("rapange_flowers_underground");
    public static final ResourceKey<PlacedFeature> FLEUR_BERRIES = registerKey("fleur_berries_underground");
    public static final ResourceKey<PlacedFeature> YELICE = registerKey("yelice_underground");
    public static final ResourceKey<PlacedFeature> DEEP_YELICE = registerKey("deep_yelice_underground");

    //Grass
    public static final ResourceKey<PlacedFeature> TINY_GRASS = registerKey("tiny_grass_underground");
    public static final ResourceKey<PlacedFeature> GRASS = registerKey("grass_underground");
    public static final ResourceKey<PlacedFeature> DEEP_GRASS = registerKey("deep_grass_underground");
    public static final ResourceKey<PlacedFeature> DEEP_TALL_GRASS = registerKey("deep_tall_grass_underground");
    public static final ResourceKey<PlacedFeature> GRASS_BLUE_LUMINESCENT = registerKey("grass_blue_luminescent_underground");
    public static final ResourceKey<PlacedFeature> TALL_GRASS_BLUE_LUMINESCENT = registerKey("tall_grass_blue_luminescent_underground");

    //Vines
    public static final ResourceKey<PlacedFeature> BLUE_LUMINESCENT_VINES_UP = registerKey("blue_luminescent_vines_underground");
    public static final ResourceKey<PlacedFeature> BLUE_LUMINESCENT_VINES_DOWN = registerKey("blue_luminescent_vines_down_underground");
    public static final ResourceKey<PlacedFeature> HANGING_ROOTS = registerKey("hanging_roots_underground");
    public static final ResourceKey<PlacedFeature> GLOW_LICHEN = registerKey("glow_lichen_underground");
    public static final ResourceKey<PlacedFeature> VINES = registerKey("vines_underground");

    //bushes
    public static final ResourceKey<PlacedFeature> CAVE_BUSH = registerKey("cave_bush_underground");
    public static final ResourceKey<PlacedFeature> CAVE_TOP_BUSH = registerKey("cave_top_bush_underground");

    //Crystal
    public static final ResourceKey<PlacedFeature> RED_CRYSTAL = registerKey("red_crystal_underground");
    public static final ResourceKey<PlacedFeature> BLUE_CRYSTAL = registerKey("blue_crystal_underground");
    public static final ResourceKey<PlacedFeature> WHITE_CRYSTAL = registerKey("white_crystal_underground");
    public static final ResourceKey<PlacedFeature> RED_CRYSTAL_PILLAR = registerKey("red_crystal_pillar_underground");
    public static final ResourceKey<PlacedFeature> BLUE_CRYSTAL_PILLAR = registerKey("blue_crystal_pillar_underground");
    public static final ResourceKey<PlacedFeature> WHITE_CRYSTAL_PILLAR = registerKey("white_crystal_pillar_underground");
    public static final ResourceKey<PlacedFeature> CRYSTAL_BLUE = registerKey("crystal_blue_underground");

    //Ore
    public static final ResourceKey<PlacedFeature> RHYOLITE = registerKey("rhyolite_underground");
    public static final ResourceKey<PlacedFeature> AMBER_MINERAL = registerKey("amber_mineral_underground");

    //terrain
    public static final ResourceKey<PlacedFeature> ROCKY_STALACTITE = registerKey("rocky_stalactite_underground");
    public static final ResourceKey<PlacedFeature> MOSSY_STALACTITE = registerKey("mossy_stalactite_underground");
    public static final ResourceKey<PlacedFeature> HUGE_STALACTITE = registerKey("huge_stalactite_underground");
    public static final ResourceKey<PlacedFeature> TINY_PUDDLE = registerKey("tiny_puddle_underground");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> registererFeature = context.lookup(Registries.CONFIGURED_FEATURE);

        //Mushrooms
        register(context, BLUE_LUMINESCENT_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM), CountPlacement.of(20), InSquarePlacement.spread(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomeFilter.biome());
        register(context, MUSHROOM_SMALL_BROWN, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_BROWN), CountPlacement.of(50), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, MUSHROOM_SMALL_RED, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_RED), CountPlacement.of(50), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, MUSHROOM_YELLOW, registererFeature.getOrThrow(ModConfiguredFeatures.YELLOW_MUSHROOM), CountPlacement.of(50), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());
        register(context, MUSHROOM_DEATH_TRUMPET, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_RED), CountPlacement.of(60), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, BROWN_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.BROWN_MUSHROOM), CountPlacement.of(33), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, RED_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.RED_MUSHROOM), CountPlacement.of(33), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, MUSHROOM_SIDE_BLUE_LUMINESCENT, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_SIDE_BLUE_LUMINESCENT), CountPlacement.of(33), InSquarePlacement.spread(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomeFilter.biome());
        register(context, RED_LUMERIA, registererFeature.getOrThrow(ModConfiguredFeatures.RED_LUMERIA), CountPlacement.of(20), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, MUSHROOM_FLOWERS, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_FLOWERS), CountPlacement.of(18), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, MUSHROOM_FERTILE_RED_FLOWER, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_RED_FERTILE_FLOWER), CountPlacement.of(12), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());

        //Flowers
        register(context, TURQUOSUM_STILUS, registererFeature.getOrThrow(ModConfiguredFeatures.TURQUOSUM_STILUS), CountPlacement.of(11), InSquarePlacement.spread(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomeFilter.biome());
        register(context, NOCTULICA, registererFeature.getOrThrow(ModConfiguredFeatures.NOCTULICA), CountPlacement.of(11), InSquarePlacement.spread(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomeFilter.biome());
        register(context, SAPHIRA_FLORENS, registererFeature.getOrThrow(ModConfiguredFeatures.SAPHIRA_FLORENS), CountPlacement.of(11), InSquarePlacement.spread(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomeFilter.biome());
        register(context, FUTIALI, registererFeature.getOrThrow(ModConfiguredFeatures.FUTIALI), CountPlacement.of(11), InSquarePlacement.spread(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomeFilter.biome());
        register(context, PLATUM, registererFeature.getOrThrow(ModConfiguredFeatures.PLATUM), CountPlacement.of(11), InSquarePlacement.spread(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomeFilter.biome());
        register(context, CYANEA, registererFeature.getOrThrow(ModConfiguredFeatures.CYANEA), CountPlacement.of(11), InSquarePlacement.spread(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomeFilter.biome());
        register(context, YELLOW_QUINCE, registererFeature.getOrThrow(ModConfiguredFeatures.YELLOW_QUINCE), CountPlacement.of(29), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, RED_QUINCE, registererFeature.getOrThrow(ModConfiguredFeatures.RED_QUINCE), CountPlacement.of(29), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, PINK_HEATER, registererFeature.getOrThrow(ModConfiguredFeatures.PINK_HEATER), CountPlacement.of(29), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, OCULAE, registererFeature.getOrThrow(ModConfiguredFeatures.OCULAE), CountPlacement.of(29), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, CYCAS, registererFeature.getOrThrow(ModConfiguredFeatures.CYCAS), CountPlacement.of(29), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, RAPANGE_FLOWERS, registererFeature.getOrThrow(ModConfiguredFeatures.RAPANGE_FLOWERS), CountPlacement.of(24), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, FLEUR_BERRIES, registererFeature.getOrThrow(ModConfiguredFeatures.FLEUR_BERRIES), CountPlacement.of(14), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, YELICE, registererFeature.getOrThrow(ModConfiguredFeatures.YELICE), CountPlacement.of(25), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, DEEP_YELICE, registererFeature.getOrThrow(ModConfiguredFeatures.YELICE), CountPlacement.of(55), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());

        //Grass
        register(context, GRASS, registererFeature.getOrThrow(ModConfiguredFeatures.GRASS), CountPlacement.of(45), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, DEEP_GRASS, registererFeature.getOrThrow(ModConfiguredFeatures.DENSE_GRASS), CountPlacement.of(160), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());
        register(context, DEEP_TALL_GRASS, registererFeature.getOrThrow(ModConfiguredFeatures.DENSE_TALL_GRASS), CountPlacement.of(160), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());
        register(context, TINY_GRASS, registererFeature.getOrThrow(ModConfiguredFeatures.TINY_GRASSS), CountPlacement.of(14), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, GRASS_BLUE_LUMINESCENT, registererFeature.getOrThrow(ModConfiguredFeatures.GRASS_BLUE_LUMINESCENT), CountPlacement.of(11), InSquarePlacement.spread(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomeFilter.biome());
        register(context, TALL_GRASS_BLUE_LUMINESCENT, registererFeature.getOrThrow(ModConfiguredFeatures.TALL_GRASS_BLUE_LUMINESCENT), CountPlacement.of(7), InSquarePlacement.spread(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomeFilter.biome());

        //Vines
        register(context, BLUE_LUMINESCENT_VINES_UP, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_VINES_UP), CountPlacement.of(9), InSquarePlacement.spread(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomeFilter.biome());
        register(context, BLUE_LUMINESCENT_VINES_DOWN, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_VINES_DOWN), CountPlacement.of(7), InSquarePlacement.spread(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomeFilter.biome());
        register(context, HANGING_ROOTS, registererFeature.getOrThrow(ModConfiguredFeatures.HANGING_ROOT), CountPlacement.of(80), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, GLOW_LICHEN, registererFeature.getOrThrow(CaveFeatures.GLOW_LICHEN), CountPlacement.of(130), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());
        register(context, VINES, registererFeature.getOrThrow(ModConfiguredFeatures.VINES), CountPlacement.of(230), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());

        //bushes
        register(context, CAVE_BUSH, registererFeature.getOrThrow(ModConfiguredFeatures.CAVE_BUSH), CountPlacement.of(50), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());
        register(context, CAVE_TOP_BUSH, registererFeature.getOrThrow(ModConfiguredFeatures.CAVE_TOP_BUSH), CountPlacement.of(20), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());


        //Huge Mushrooms
        register(context, BLUE_LUMINESCENT_MUSHROOM_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM_TREE), CountPlacement.of(140), InSquarePlacement.spread(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomeFilter.biome());
        register(context, HUGE_BROWN_MUSHROOM, registererFeature.getOrThrow(TreeFeatures.HUGE_BROWN_MUSHROOM), CountPlacement.of(165), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, HUGE_RED_MUSHROOM, registererFeature.getOrThrow(TreeFeatures.HUGE_RED_MUSHROOM), CountPlacement.of(170), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, FERTILE_RED_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.FERTILE_RED_MUSHROOM), CountPlacement.of(240), InSquarePlacement.spread(), ModPlacedFeatures.STONE_LEVEL, BiomeFilter.biome());
        register(context, PURPLE_MUSHROOM_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.PURPLE_MUSHROOM_TREE), CountPlacement.of(240), InSquarePlacement.spread(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomeFilter.biome());
        register(context, PINK_LUMINESCENT_MUSHROOM_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.PINK_LUMINESCENT_MUSHROOM_TREE), CountPlacement.of(240), InSquarePlacement.spread(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomeFilter.biome());

        //Tree
        register(context, OAK_TREE, registererFeature.getOrThrow(TreeFeatures.OAK), ModPlacedFeatures.undergroundStoneLevelTreeModifiersWithWouldSurvive(PlacementUtils.countExtra(90, 1f, 45), Blocks.OAK_SAPLING));
        register(context, OAK_BERRIES_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.OAK_BERRIES_TREE), ModPlacedFeatures.undergroundStoneLevelTreeModifiersWithWouldSurvive(PlacementUtils.countExtra(240, 1f, 10), ModBlocks.OAK_BERRIES_SAPLING.get()));
        register(context, AZALEA_TREE, registererFeature.getOrThrow(TreeFeatures.AZALEA_TREE), ModPlacedFeatures.undergroundStoneLevelTreeModifiersWithWouldSurvive(PlacementUtils.countExtra(230, 1f, 6), Blocks.AZALEA));
        register(context, BLUE_LUMINESCENT_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_TREE), ModPlacedFeatures.undergroundDeepslateLevelTreeModifiersWithWouldSurvive(PlacementUtils.countExtra(150, 1f, 6), ModBlocks.BLUE_LUMINESCENT_SAPPLING.get()));


        //Crystal
        register(context, RED_CRYSTAL, registererFeature.getOrThrow(ModConfiguredFeatures.RED_CRYSTAL), CountPlacement.of(40), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());
        register(context, BLUE_CRYSTAL, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_CRYSTAL), CountPlacement.of(40), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());
        register(context, WHITE_CRYSTAL, registererFeature.getOrThrow(ModConfiguredFeatures.WHITE_CRYSTAL), CountPlacement.of(40), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());
        register(context, RED_CRYSTAL_PILLAR, registererFeature.getOrThrow(ModConfiguredFeatures.RED_CRYSTAL_PILLAR), CountPlacement.of(13), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());
        register(context, BLUE_CRYSTAL_PILLAR, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_CRYSTAL_PILLAR), CountPlacement.of(13), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());
        register(context, WHITE_CRYSTAL_PILLAR, registererFeature.getOrThrow(ModConfiguredFeatures.WHITE_CRYSTAL_PILLAR), CountPlacement.of(13), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());
        register(context, CRYSTAL_BLUE, registererFeature.getOrThrow(ModConfiguredFeatures.CRYSTAL_BLUE), CountPlacement.of(26), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());

        //Ore
        register(context, RHYOLITE, registererFeature.getOrThrow(ModConfiguredFeatures.RHYOLITE),
                ModOrePlacement.modifiersWithCount(12, // Veins per Chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(80))));

        register(context, AMBER_MINERAL, registererFeature.getOrThrow(ModConfiguredFeatures.AMBER_MINERAL), RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());

        //terrain
        register(context, ROCKY_STALACTITE, registererFeature.getOrThrow(ModConfiguredFeatures.ROCKY_STALACTITE), CountPlacement.of(30), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());
        register(context, MOSSY_STALACTITE, registererFeature.getOrThrow(ModConfiguredFeatures.MOSSY_STALACTITE), CountPlacement.of(18), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());
        register(context, HUGE_STALACTITE, registererFeature.getOrThrow(ModConfiguredFeatures.HUGE_STALACTITE), CountPlacement.of(25), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, ModPlacedFeatures.SOLID_STATE_CAVE, BiomeFilter.biome());
        register(context, TINY_PUDDLE, registererFeature.getOrThrow(ModConfiguredFeatures.TINY_PUDDLE), CountPlacement.of(250), InSquarePlacement.spread(), ModPlacedFeatures.CAVE_LEVEL, BiomeFilter.biome());

    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, name));
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
