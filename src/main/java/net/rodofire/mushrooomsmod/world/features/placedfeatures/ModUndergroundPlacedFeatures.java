package net.rodofire.mushrooomsmod.world.features.placedfeatures;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;

import java.util.List;

public class ModUndergroundPlacedFeatures {
    //Mushrooms
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_MUSHROOM_UNDERGROUND_PLACED_KEY = registerKey("blue_luminescent_mushroom_underground_placed_key");
    public static final RegistryKey<PlacedFeature> BROWN_MUSHROOM_UNDERGROUNG_PLACED_KEY = registerKey("brown_mushroom_underground_placed_key");
    public static final RegistryKey<PlacedFeature> RED_MUSHROOM_UNDERGROUND_PLACED_KEY = registerKey("red_mushroom_underground_placed_key");
    public static final RegistryKey<PlacedFeature> FERTILE_RED_MUSHROOM_UNDERGROUND_PLACED_KEY = registerKey("fertile_red_mushroom_underground_placed_key");
    public static final RegistryKey<PlacedFeature> RED_LUMERIA_UNDERGROUND_PLACED_KEY = registerKey("red_lumeria_underground_placed_key");
    public static final RegistryKey<PlacedFeature> MUSHROOM_FLOWERS_UNDERGROUND_PLACED_KEY = registerKey("mushroom_flowers_underground_placed_key");

    //Tree
    public static final RegistryKey<PlacedFeature> OAK_TREE_UNDERGROUND_PLACED_KEY = registerKey("oak_tree_underground_placed_key");
    public static final RegistryKey<PlacedFeature> AZALEA_TREE_UNDERGROUND_PLACED_KEY = registerKey("alazea_tree_underground_placed_key");
    public static final RegistryKey<PlacedFeature> OAK_BERRIES_TREE_UNDERGROUND_PLACED_KEY = registerKey("oak_berries_tree_underground_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_TREE_UNDERGROUND_PLACED_KEY = registerKey("blue_luminescent_tree_underground_placed_key");

    //Mushrooms Flowers
    public static final RegistryKey<PlacedFeature> MUSHROOM_SIDE_BLUE_LUMINESCENT_UNDERGROUND_PLACED_KEY = registerKey("mushroom_side_blue_luminescent_underground_placed_key");
    public static final RegistryKey<PlacedFeature> MUSHROOM_SMALL_RED_UNDERGROUND_PLACED_KEY = registerKey("mushroom_small_red_underground_placed_key");
    public static final RegistryKey<PlacedFeature> MUSHROOM_SMALL_BROWN_UNDERGROUND_PLACED_KEY = registerKey("mushroom_small_brown_underground_placed_key");
    public static final RegistryKey<PlacedFeature> MUSHROOM_DEATH_TRUMPET_UNDERGROUND_PLACED_KEY = registerKey("mushroom_death_trumpet_underground_placed_key");
    public static final RegistryKey<PlacedFeature> MUSHROOM_FERTILE_RED_FLOWER_UNDERGROUND_PLACED_KEY = registerKey("mushroom_fertile_red_flower_underground_placed_key");

    //Huge Mushrooms
    public static final RegistryKey<PlacedFeature> HUGE_RED_MUSHROOM_UNDERGROUND_PLACED_KEY = registerKey("huge_red_mushroom_underground_placed_key");
    public static final RegistryKey<PlacedFeature> HUGE_BROWN_MUSHROOM_UNDERGROUND_PLACED_KEY = registerKey("huge_brown_mushroom_underground_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_MUSHROOM_TREE_UNDERGROUND_PLACED_KEY = registerKey("blue_luminescent_mushroom_tree_underground_placed_key");
    public static final RegistryKey<PlacedFeature> PURPLE_MUSHROOM_TREE_UNDERGROUND_PLACED_KEY = registerKey("purple_mushroom_tree_underground_placed_key");
    public static final RegistryKey<PlacedFeature> HUGE_PURPLE_MUSHROOM_TREE_UNDERGROUND_PLACED_KEY = registerKey("huge_purple_mushroom_tree_underground_placed_key");
    public static final RegistryKey<PlacedFeature> PINK_LUMINESCENT_MUSHROOM_TREE_UNDERGROUND_PLACED_KEY = registerKey("pink_luminescent_mushroom_tree_underground_placed_key");


    //Flowers
    public static final RegistryKey<PlacedFeature> PLATUM_UNDERGROUND_PLACED_KEY = registerKey("platum_underground_placed_key");
    public static final RegistryKey<PlacedFeature> SAPHIRA_FLORENS_UNDERGROUND_PLACED_KEY = registerKey("saphira_underground_florens_placed_key");
    public static final RegistryKey<PlacedFeature> NOCTULICA_UNDERGROUND_PLACED_KEY = registerKey("noctulica_underground_placed_key");
    public static final RegistryKey<PlacedFeature> TURQUOSUM_STILUS_UNDERGROUND_PLACED_KEY = registerKey("turquosum_stilus_underground_placed_key");
    public static final RegistryKey<PlacedFeature> FUTIALI_UNDERGROUND_PLACED_KEY = registerKey("futiali_underground_placed_key");
    public static final RegistryKey<PlacedFeature> CYANEA_UNDERGROUND_PLACED_KEY = registerKey("cyanea_underground_placed_key");
    public static final RegistryKey<PlacedFeature> YELLOW_QUINCE_UNDERGROUND_PLACED_KEY = registerKey("yellow_quince_underground_placed_key");
    public static final RegistryKey<PlacedFeature> RED_QUINCE_UNDERGROUND_PLACED_KEY = registerKey("red_quince_underground_placed_key");
    public static final RegistryKey<PlacedFeature> PINK_HEATER_UNDERGROUND_PLACED_KEY = registerKey("pink_heater_underground_placed_key");
    public static final RegistryKey<PlacedFeature> OCULAE_UNDERGROUND_PLACED_KEY = registerKey("oculae_underground_placed_key");
    public static final RegistryKey<PlacedFeature> CYCAS_UNDERGROUND_PLACED_KEY = registerKey("cycas_underground_placed_key");
    public static final RegistryKey<PlacedFeature> RAPANGE_FLOWERS_UNDERGROUND_PLACED_KEY = registerKey("rapange_flowers_underground_placed_key");
    public static final RegistryKey<PlacedFeature> FLEUR_BERRIES_UNDERGROUND_PLACED_KEY = registerKey("fleur_berries_underground_placed_key");
    public static final RegistryKey<PlacedFeature> YELICE_UNDERGROUND_PLACED_KEY = registerKey("yelice_underground_placed_key");

    //Grass
    public static final RegistryKey<PlacedFeature> TINY_GRASS_UNDERGROUND_PLACED_KEY = registerKey("tiny_grass_underground_placed_key");
    public static final RegistryKey<PlacedFeature> GRASS_UNDERGROUND_PLACED_KEY = registerKey("grass_underground_placed_key");
    public static final RegistryKey<PlacedFeature> GRASS_BLUE_LUMINESCENT_UNDERGROUND_PLACED_KEY = registerKey("grass_blue_luminescent_underground_placed_key");
    public static final RegistryKey<PlacedFeature> TALL_GRASS_BLUE_LUMINESCENT_UNDERGROUND_PLACED_KEY = registerKey("tall_grass_blue_luminescent_underground_placed_key");

    //Vines
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_VINES_UP_UNDERGROUND_PLACED_KEY = registerKey("blue_luminescent_vines_underground_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_VINES_DOWN_UNDERGROUND_PLACED_KEY = registerKey("blue_luminescent_vines_down_underground_placed_key");
    public static final RegistryKey<PlacedFeature> HANGING_ROOTS_UNDERGROUND_PLACED_KEY = registerKey("hanging_roots_underground_placed_key");

    //Crystal
    public static final RegistryKey<PlacedFeature> RED_CRYSTAL_UNDERGROUND_PLACED_KEY = registerKey("red_crystal_underground_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_CRYSTAL_UNDERGROUND_PLACED_KEY = registerKey("blue_crystal_underground_placed_key");
    public static final RegistryKey<PlacedFeature> WHITE_CRYSTAL_UNDERGROUND_PLACED_KEY = registerKey("white_crystal_underground_placed_key");
    public static final RegistryKey<PlacedFeature> RED_CRYSTAL_PILLAR_UNDERGROUND_PLACED_KEY = registerKey("red_crystal_pillar_underground_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_CRYSTAL_PILLAR_UNDERGROUND_PLACED_KEY = registerKey("blue_crystal_pillar_underground_placed_key");
    public static final RegistryKey<PlacedFeature> WHITE_CRYSTAL_PILLAR_UNDERGROUND_PLACED_KEY = registerKey("white_crystal_pillar_underground_placed_key");
    public static final RegistryKey<PlacedFeature> CRYSTAL_BLUE_UNDERGROUND_PLACED_KEY = registerKey("crystal_blue_underground_placed_key");

    //Ore
    public static final RegistryKey<PlacedFeature> RHYOLITE_UNDERGROUND_PLACED_KEY = registerKey("rhyolite_underground_placed_key");
    public static final RegistryKey<PlacedFeature> AMBER_MINERAL_UNDERGROUND_PLACED_FEATURE = registerKey("amber_mineral_underground_placed_key");
    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        //Mushrooms
        register(context, BLUE_LUMINESCENT_MUSHROOM_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM_KEY), CountPlacementModifier.of(20), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, MUSHROOM_SMALL_BROWN_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_BROWN_KEY), CountPlacementModifier.of(50), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, MUSHROOM_SMALL_RED_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_RED_KEY), CountPlacementModifier.of(50), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, MUSHROOM_DEATH_TRUMPET_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_RED_KEY), CountPlacementModifier.of(60), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, BROWN_MUSHROOM_UNDERGROUNG_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BROWN_MUSHROOM_KEY), CountPlacementModifier.of(33), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, RED_MUSHROOM_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_MUSHROOM_KEY), CountPlacementModifier.of(33), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, MUSHROOM_SIDE_BLUE_LUMINESCENT_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_SIDE_BLUE_LUMINESCENT_KEY), CountPlacementModifier.of(33), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, RED_LUMERIA_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_LUMERIA_KEY), CountPlacementModifier.of(20), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, MUSHROOM_FLOWERS_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_FLOWERS_KEY), CountPlacementModifier.of(18), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, MUSHROOM_FERTILE_RED_FLOWER_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_RED_FERTILE_FLOWER_KEY), CountPlacementModifier.of(12), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());

        //Flowers
        register(context, TURQUOSUM_STILUS_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TURQUOSUM_STILUS_KEY), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, NOCTULICA_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NOCTULICA_KEY), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, SAPHIRA_FLORENS_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAPHIRA_FLORENS_KEY), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, FUTIALI_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FUTIALI_KEY), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, PLATUM_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PLATUM_KEY), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, CYANEA_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CYANEA_KEY), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, YELLOW_QUINCE_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELLOW_QUINCE_KEY), CountPlacementModifier.of(29), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, RED_QUINCE_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_QUINCE_KEY), CountPlacementModifier.of(29), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, PINK_HEATER_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINK_HEATER_KEY), CountPlacementModifier.of(29), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, OCULAE_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OCULAE_KEY), CountPlacementModifier.of(29), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, CYCAS_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CYCAS_KEY), CountPlacementModifier.of(29), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, RAPANGE_FLOWERS_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RAPANGE_FLOWERS_KEY), CountPlacementModifier.of(24), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, FLEUR_BERRIES_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FLEUR_BERRIES_KEY), CountPlacementModifier.of(14), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, YELICE_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELICE_KEY), CountPlacementModifier.of(25), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());

        //Grass
        register(context, GRASS_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GRASS_KEY), CountPlacementModifier.of(45), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, TINY_GRASS_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TINY_GRASSS_KEY), CountPlacementModifier.of(14), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, GRASS_BLUE_LUMINESCENT_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GRASS_BLUE_LUMINESCENT_KEY), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, TALL_GRASS_BLUE_LUMINESCENT_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TALL_GRASS_BLUE_LUMINESCENT_KEY), CountPlacementModifier.of(7), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());

        //Vines
        register(context, BLUE_LUMINESCENT_VINES_UP_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_VINES_UP_KEY), CountPlacementModifier.of(9), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, BLUE_LUMINESCENT_VINES_DOWN_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_VINES_DOWN_KEY), CountPlacementModifier.of(7), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, HANGING_ROOTS_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HANGING_ROOT_KEY), CountPlacementModifier.of(80), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());

        //Huge Mushrooms
        register(context, BLUE_LUMINESCENT_MUSHROOM_TREE_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM_TREE_KEY), CountPlacementModifier.of(140), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, HUGE_BROWN_MUSHROOM_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM), CountPlacementModifier.of(165), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, HUGE_RED_MUSHROOM_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.HUGE_RED_MUSHROOM), CountPlacementModifier.of(170), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, FERTILE_RED_MUSHROOM_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FERTILE_RED_MUSHROOM_KEY), CountPlacementModifier.of(240), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, PURPLE_MUSHROOM_TREE_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PURPLE_MUSHROOM_TREE_KEY), CountPlacementModifier.of(240), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, HUGE_PURPLE_MUSHROOM_TREE_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_TREE_KEY_WG), CountPlacementModifier.of(240), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, PINK_LUMINESCENT_MUSHROOM_TREE_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINK_LUMINESCENT_MUSHROOM_TREE_KEY), CountPlacementModifier.of(240), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());

        //Tree
        register(context, OAK_TREE_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.OAK), ModPlacedFeatures.undergroundStoneLevelTreeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(90, 1f, 45), Blocks.OAK_SAPLING));
        register(context, OAK_BERRIES_TREE_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OAK_BERRIES_TREE_KEY), ModPlacedFeatures.undergroundStoneLevelTreeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(240, 1f, 10), ModBlocks.OAK_BERRIES_SAPLING));
        register(context, AZALEA_TREE_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.AZALEA_TREE), ModPlacedFeatures.undergroundStoneLevelTreeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(230, 1f, 6), Blocks.AZALEA));
        register(context, BLUE_LUMINESCENT_TREE_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_TREE_KEY), ModPlacedFeatures.undergroundDeepslateLevelTreeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(150, 1f, 6), ModBlocks.BLUE_LUMINESCENT_SAPPLING));


        //Crystal
        register(context, RED_CRYSTAL_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_CRYSTAL_KEY), CountPlacementModifier.of(40), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, BLUE_CRYSTAL_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_CRYSTAL_KEY), CountPlacementModifier.of(40), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, WHITE_CRYSTAL_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WHITE_CRYSTAL_KEY), CountPlacementModifier.of(40), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, RED_CRYSTAL_PILLAR_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_CRYSTAL_PILLAR_KEY), CountPlacementModifier.of(13), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, BLUE_CRYSTAL_PILLAR_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_CRYSTAL_PILLAR_KEY), CountPlacementModifier.of(13), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, WHITE_CRYSTAL_PILLAR_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WHITE_CRYSTAL_PILLAR_KEY), CountPlacementModifier.of(13), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, CRYSTAL_BLUE_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CRYSTAL_BLUE_KEY), CountPlacementModifier.of(26), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());

        //Ore
        register(context, RHYOLITE_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RHYOLITE_KEY),
                ModOrePlacement.modifiersWithCount(12, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(10), YOffset.fixed(80))));

        register(context, AMBER_MINERAL_UNDERGROUND_PLACED_FEATURE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AMBER_MINERAL_KEY), RarityFilterPlacementModifier.of(20), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
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
