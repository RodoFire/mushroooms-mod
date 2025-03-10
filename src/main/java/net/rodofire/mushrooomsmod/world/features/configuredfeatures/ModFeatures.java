package net.rodofire.mushrooomsmod.world.features.configuredfeatures;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.world.features.config.*;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.SimpleBlockFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.*;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.bush.BushFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.bush.CaveBushFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.bush.CaveTopBushFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.bush.ColorfulBushFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.CustomGreenMushroomFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.CustomLuminescentBlueMushroomFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.CustomLuminescentPinkMushroomFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.CustomPurpleMushroomFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth.BlueMushroomFeatureOTH;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth.HugePurpleMushroomOTHFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth.OrangeMushroomFeatureOTH;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth.YellowMushroomOTHFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.wg.CustomBlueMushroomFeatureWG;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.wg.OrangeMushroomFeatureWG;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.wg.YellowMushroomWGFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.structuremushrooms.CustomGreenSecondMushroomFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.structuremushrooms.CustomRedFertileMushroom;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.structuremushrooms.CustomRedHugeMushroomFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.pubble.TinyPuddle;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock.SakuraPlainFlatRockFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock.SakuraPlainStraightRockFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.stalactite.MossyStalactiteFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.stalactite.RockyStalactiteFeature;

public class ModFeatures<FC extends FeatureConfig> {

    //Huge mushroom features
    public static Feature<HugeMushroomFeatureConfig> HUGE_PURPLE_MUSHROOM;
    public static Feature<ModMushroomFeatureConfig> HUGE_GREEN_MUSHROOM;
    public static Feature<HugeMushroomFeatureConfig> HUGE_BLUE_LUMINESCENT_MUSHROOM;
    public static Feature<HugeMushroomFeatureConfig> HUGE_LUMINESCENT_PINK_MUSHROOM;
    public static Feature<PurpleMushroomConfig> HUGE_BIG_PURPLE_MUSHROOM_OTH;
    public static Feature<PurpleMushroomConfig> HUGE_BIG_PURPLE_MUSHROOM_WG;
    public static Feature<HugeMushroomFeatureConfig> HUGE_BIG_GREEN_MUSHROOM;
    public static Feature<ModMushroomFeatureConfig> HUGE_BIG_RED_MUSHROOM;
    public static Feature<ModMushroomFeatureConfig> HUGE_BLUE_MUSHROOM_WG;
    public static Feature<ModMushroomFeatureConfig> HUGE_BLUE_MUSHROOM_OTH;
    public static Feature<DefaultFeatureConfig> HUGE_BIG_ORANGE_MUSHROOM_WG;
    public static Feature<DefaultFeatureConfig> HUGE_BIG_ORANGE_MUSHROOM_OTH;
    public static Feature<HugeMushroomFeatureConfig> HUGE_YELLOW_MUSHROOM_WG;
    public static Feature<HugeMushroomFeatureConfig> HUGE_YELLOW_MUSHROOM_OTH;
    public static Feature<DefaultFeatureConfig> FERTILE_RED_MUSHROOM;

    //Flowers
    public static Feature<DefaultFeatureConfig> FLEUR_BERRIES;

    //Vines Features;
    public static Feature<TwistingVinesFeatureConfig> BLUE_LUMINESCENT_VINES;
    public static Feature<DirectionConfig> SIMPLE_VINES;
    public static Feature<HangingGrowthFeatureConfig> HANGING_VINES_GROW_FEATURES;

    //Crystal
    public static Feature<CrystalConfig> CRYSTAL;
    public static Feature<ModSimpleBlockFeatureConfig> CRYSTAL_PILLAR;

    //Bush;
    public static Feature<DefaultFeatureConfig> BUSH;
    public static Feature<DefaultFeatureConfig> COLORFUL_BUSH;
    public static Feature<DefaultFeatureConfig> CAVE_BUSH;
    public static Feature<DefaultFeatureConfig> CAVE_TOP_BUSH;

    //SimpleBlock
    public static Feature<ModSimpleBlockFeatureConfig> SIMPLE_BLOCK;

    //Cave related
    public static Feature<DefaultFeatureConfig> AMBER_MINERAL;

    //terrain
    public static Feature<ArchConfig> ARCH;
    public static Feature<DefaultFeatureConfig> SAKURA_ROCK_STRAIGHT;
    public static Feature<DefaultFeatureConfig> SAKURA_ROCK_FLAT;
    public static Feature<StalactiteFeatureConfig> ROCKY_STALACTITE;
    public static Feature<StalactiteFeatureConfig> MOSSY_STALACTITE;
    public static Feature<DefaultFeatureConfig> HUGE_STALACTITE;
    public static Feature<DefaultFeatureConfig> TINY_PUDDLE;
    public static Feature<DefaultFeatureConfig> SPIRAL_MUSHROOM;

    //dev
    public static Feature<ModSimpleBlockFeatureConfig> FEATURE_TESTER;

    public static void registerFeatures() {
        MushrooomsMod.LOGGER.info("|\t-Registering Features");
        HUGE_PURPLE_MUSHROOM = registerCustomFeature("huge_purple_mushroom", new CustomPurpleMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        HUGE_GREEN_MUSHROOM = registerCustomFeature("huge_green_mushroom", new CustomGreenMushroomFeature(ModMushroomFeatureConfig.CODEC));
        HUGE_BLUE_LUMINESCENT_MUSHROOM = registerCustomFeature("huge_blue_luminescent_mushroom", new CustomLuminescentBlueMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        HUGE_LUMINESCENT_PINK_MUSHROOM = registerCustomFeature("huge_luminescent_pink_mushroom", new CustomLuminescentPinkMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        HUGE_BIG_PURPLE_MUSHROOM_WG = registerCustomFeature("wg_huge_big_purple_mushroom_feature", new HugePurpleMushroomOTHFeature(PurpleMushroomConfig.CODEC));
        HUGE_BIG_PURPLE_MUSHROOM_OTH = registerCustomFeature("oth_huge_big_purple_mushroom_feature", new HugePurpleMushroomOTHFeature(PurpleMushroomConfig.CODEC));
        HUGE_BIG_GREEN_MUSHROOM = registerCustomFeature("huge_big_green_mushroom_feature", new CustomGreenSecondMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        HUGE_BLUE_MUSHROOM_WG = registerCustomFeature("wg_huge_blue_mushroom", new CustomBlueMushroomFeatureWG(ModMushroomFeatureConfig.CODEC));
        HUGE_BLUE_MUSHROOM_OTH = registerCustomFeature("oth_huge_blue_mushroom", new BlueMushroomFeatureOTH(ModMushroomFeatureConfig.CODEC));
        HUGE_BIG_RED_MUSHROOM = registerCustomFeature("huge_red_red_mushroom_feature", new CustomRedHugeMushroomFeature(ModMushroomFeatureConfig.CODEC));
        HUGE_BIG_ORANGE_MUSHROOM_WG = registerCustomFeature("wg_huge_orange_mushroom_feature", new OrangeMushroomFeatureWG(DefaultFeatureConfig.CODEC));
        HUGE_BIG_ORANGE_MUSHROOM_OTH = registerCustomFeature("oth_huge_orange_mushroom_feature", new OrangeMushroomFeatureOTH(DefaultFeatureConfig.CODEC));
        HUGE_YELLOW_MUSHROOM_WG = registerCustomFeature("wg_huge_yellow_mushroom_feature", new YellowMushroomWGFeature(HugeMushroomFeatureConfig.CODEC));
        HUGE_YELLOW_MUSHROOM_OTH = registerCustomFeature("oth_huge_yellow_mushroom_feature", new YellowMushroomOTHFeature(HugeMushroomFeatureConfig.CODEC));
        FERTILE_RED_MUSHROOM = registerCustomFeature("mushroom_fertile_red", new CustomRedFertileMushroom(DefaultFeatureConfig.CODEC));

        FLEUR_BERRIES = registerCustomFeature("fleur_berries_feature", new FleurBerriesFeature(DefaultFeatureConfig.CODEC));

        BLUE_LUMINESCENT_VINES = registerCustomFeature("blue_luminescent_vines_feature", new BlueLuminescentVinesFeature(TwistingVinesFeatureConfig.CODEC));
        SIMPLE_VINES = registerCustomFeature("simple_vines", new SimpleVinesFeature(DirectionConfig.CODEC));
        HANGING_VINES_GROW_FEATURES = registerCustomFeature("hanging_vines_grow_feature", new HangingVinesGrowthFeature(HangingGrowthFeatureConfig.CODEC));

        CRYSTAL = registerCustomFeature("crystal", new CrystalFeature(CrystalConfig.CODEC));
        CRYSTAL_PILLAR = registerCustomFeature("crystal_pillar", new BigCrystal(ModSimpleBlockFeatureConfig.CODEC));

        BUSH = registerCustomFeature("bush_feature", new BushFeature(DefaultFeatureConfig.CODEC));
        COLORFUL_BUSH = registerCustomFeature("colorful_bush_feature", new ColorfulBushFeature(DefaultFeatureConfig.CODEC));
        CAVE_BUSH = registerCustomFeature("cave_bush", new CaveBushFeature(DefaultFeatureConfig.CODEC));
        CAVE_TOP_BUSH = registerCustomFeature("cave_top_bush", new CaveTopBushFeature(DefaultFeatureConfig.CODEC));

        SIMPLE_BLOCK = registerCustomFeature("simple_block_feature", new SimpleBlockFeature(ModSimpleBlockFeatureConfig.CODEC));

        AMBER_MINERAL = registerCustomFeature("amber_mineral_feature", new AmberFeature(DefaultFeatureConfig.CODEC));
        ROCKY_STALACTITE = registerCustomFeature("rocky_stalactite_feature", new RockyStalactiteFeature(StalactiteFeatureConfig.CODEC));
        MOSSY_STALACTITE = registerCustomFeature("mossy_stalactite_feature", new MossyStalactiteFeature(StalactiteFeatureConfig.CODEC));
        HUGE_STALACTITE = registerCustomFeature("huge_stalactite_feature", new HugeRockyStalactiteFeature(DefaultFeatureConfig.CODEC));
        TINY_PUDDLE = registerCustomFeature("tiny_puddle_feature", new TinyPuddle(DefaultFeatureConfig.CODEC));

        ARCH = registerCustomFeature("arch", new SakuraArchFeature(ArchConfig.CODEC));
        SAKURA_ROCK_STRAIGHT = registerCustomFeature("sakura_rock_straight", new SakuraPlainStraightRockFeature(DefaultFeatureConfig.CODEC));
        SAKURA_ROCK_FLAT = registerCustomFeature("sakura_rock_flat", new SakuraPlainFlatRockFeature(DefaultFeatureConfig.CODEC));
        SPIRAL_MUSHROOM = registerCustomFeature("spiral_mushroom", new SpiralMushroom(DefaultFeatureConfig.CODEC));

        FEATURE_TESTER = registerCustomFeature("feature_tester", new DevFeature(ModSimpleBlockFeatureConfig.CODEC));
    }

    private static <C extends FeatureConfig, F extends Feature<C>> F registerCustomFeature(String name, F feature) {
        return Registry.register(Registries.FEATURE, name, feature);
    }
}
