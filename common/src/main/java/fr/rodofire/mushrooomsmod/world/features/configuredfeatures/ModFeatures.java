package fr.rodofire.mushrooomsmod.world.features.configuredfeatures;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TwistingVinesConfig;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.world.features.config.*;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.*;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.bush.BushFeature;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.bush.CaveBushFeature;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.bush.CaveTopBushFeature;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.bush.ColorfulBushFeature;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.*;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth.BlueMushroomFeatureOTH;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth.HugePurpleMushroomOTHFeature;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth.OrangeMushroomFeatureOTH;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth.YellowMushroomOTHFeature;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.wg.BlueMushroomFeatureWG;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.wg.OrangeMushroomFeatureWG;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.structuremushrooms.GreenCryingMushroomFeature;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.structuremushrooms.CustomRedFertileMushroom;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.structuremushrooms.CustomRedHugeMushroomFeature;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.pubble.TinyPuddle;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock.SakuraPlainFlatRockFeature;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock.SakuraPlainStraightRockFeature;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.stalactite.MossyStalactiteFeature;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.stalactite.RockyStalactiteFeature;

public class ModFeatures<FC extends FeatureConfiguration> {

    //Huge mushroom features
    public static Feature<HugeMushroomFeatureConfiguration> HUGE_PURPLE_MUSHROOM;
    public static Feature<ModMushroomFeatureConfig> HUGE_GREEN_MUSHROOM;
    public static Feature<HugeMushroomFeatureConfiguration> HUGE_BLUE_LUMINESCENT_MUSHROOM;
    public static Feature<HugeMushroomFeatureConfiguration> HUGE_LUMINESCENT_PINK_MUSHROOM;
    public static Feature<PurpleMushroomConfig> HUGE_BIG_PURPLE_MUSHROOM;
    public static Feature<HugeMushroomFeatureConfiguration> CRYING_BIG_GREEN_MUSHROOM;
    public static Feature<ModMushroomFeatureConfig> HUGE_BIG_RED_MUSHROOM;
    public static Feature<ModMushroomFeatureConfig> HUGE_BLUE_MUSHROOM;
    public static Feature<ModMushroomFeatureConfig> HUGE_BLUE_MUSHROOM_WG;
    public static Feature<NoneFeatureConfiguration> HUGE_BIG_ORANGE_MUSHROOM;
    public static Feature<NoneFeatureConfiguration> HUGE_BIG_ORANGE_MUSHROOM_WG;
    public static Feature<HugeMushroomFeatureConfiguration> HUGE_YELLOW_MUSHROOM;
    public static Feature<NoneFeatureConfiguration> SINUSO_SHROOM;
    public static Feature<NoneFeatureConfiguration> FERTILE_RED_MUSHROOM;

    //Flowers
    public static Feature<FleurBerriesConfig> FLEUR_BERRIES;

    //Vines Features;
    public static Feature<TwistingVinesConfig> BLUE_LUMINESCENT_VINES;
    public static Feature<DirectionConfig> SIMPLE_VINES;
    public static Feature<HangingGrowthFeatureConfig> HANGING_VINES_GROW_FEATURES;

    //Crystal
    public static Feature<CrystalConfig> CRYSTAL;
    public static Feature<ModSimpleBlockFeatureConfig> CRYSTAL_PILLAR;

    //Bush;
    public static Feature<NoneFeatureConfiguration> BUSH;
    public static Feature<NoneFeatureConfiguration> COLORFUL_BUSH;
    public static Feature<NoneFeatureConfiguration> CAVE_BUSH;
    public static Feature<NoneFeatureConfiguration> CAVE_TOP_BUSH;

    //SimpleBlock
    public static Feature<ModSimpleBlockFeatureConfig> SIMPLE_BLOCK;

    //Cave related
    public static Feature<NoneFeatureConfiguration> AMBER_MINERAL;

    //terrain
    public static Feature<ArchConfig> ARCH;
    public static Feature<NoneFeatureConfiguration> SAKURA_ROCK_STRAIGHT;
    public static Feature<NoneFeatureConfiguration> SAKURA_ROCK_FLAT;
    public static Feature<StalactiteFeatureConfig> ROCKY_STALACTITE;
    public static Feature<StalactiteFeatureConfig> MOSSY_STALACTITE;
    public static Feature<NoneFeatureConfiguration> HUGE_STALACTITE;
    public static Feature<NoneFeatureConfiguration> TINY_PUDDLE;
    public static Feature<NoneFeatureConfiguration> SPIRAL_MUSHROOM;

    //dev
    public static Feature<ModSimpleBlockFeatureConfig> FEATURE_TESTER;

    public static void registerFeatures() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Features");
        HUGE_PURPLE_MUSHROOM = registerCustomFeature("huge_purple_mushroom", new CustomPurpleMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
        HUGE_GREEN_MUSHROOM = registerCustomFeature("huge_green_mushroom", new CustomGreenMushroomFeature(ModMushroomFeatureConfig.CODEC));
        HUGE_BLUE_LUMINESCENT_MUSHROOM = registerCustomFeature("huge_blue_luminescent_mushroom", new CustomLuminescentBlueMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
        HUGE_LUMINESCENT_PINK_MUSHROOM = registerCustomFeature("huge_luminescent_pink_mushroom", new CustomLuminescentPinkMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
        HUGE_BIG_PURPLE_MUSHROOM = registerCustomFeature("huge_big_purple_mushroom_feature", new HugePurpleMushroomOTHFeature(PurpleMushroomConfig.CODEC));
        CRYING_BIG_GREEN_MUSHROOM = registerCustomFeature("huge_big_green_mushroom_feature", new GreenCryingMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
        HUGE_BLUE_MUSHROOM = registerCustomFeature("huge_blue_mushroom", new BlueMushroomFeatureOTH(ModMushroomFeatureConfig.CODEC));
        HUGE_BLUE_MUSHROOM_WG = registerCustomFeature("huge_blue_mushroom_wg", new BlueMushroomFeatureWG(ModMushroomFeatureConfig.CODEC));
        HUGE_BIG_RED_MUSHROOM = registerCustomFeature("huge_red_red_mushroom_feature", new CustomRedHugeMushroomFeature(ModMushroomFeatureConfig.CODEC));
        HUGE_BIG_ORANGE_MUSHROOM = registerCustomFeature("huge_orange_mushroom_feature", new OrangeMushroomFeatureOTH(NoneFeatureConfiguration.CODEC));
        HUGE_BIG_ORANGE_MUSHROOM_WG = registerCustomFeature("huge_orange_mushroom_feature_wg", new OrangeMushroomFeatureWG(NoneFeatureConfiguration.CODEC));
        HUGE_YELLOW_MUSHROOM = registerCustomFeature("huge_yellow_mushroom_feature", new YellowMushroomOTHFeature(HugeMushroomFeatureConfiguration.CODEC));
        FERTILE_RED_MUSHROOM = registerCustomFeature("mushroom_fertile_red", new CustomRedFertileMushroom(NoneFeatureConfiguration.CODEC));
        SINUSO_SHROOM = registerCustomFeature("sinuso_shroom", new SinusoShroom(NoneFeatureConfiguration.CODEC));

        FLEUR_BERRIES = registerCustomFeature("fleur_berries_feature", new FleurBerriesFeature(FleurBerriesConfig.CODEC));

        BLUE_LUMINESCENT_VINES = registerCustomFeature("blue_luminescent_vines_feature", new BlueLuminescentVinesFeature(TwistingVinesConfig.CODEC));
        SIMPLE_VINES = registerCustomFeature("simple_vines", new SimpleVinesFeature(DirectionConfig.CODEC));
        HANGING_VINES_GROW_FEATURES = registerCustomFeature("hanging_vines_grow_feature", new HangingVinesGrowthFeature(HangingGrowthFeatureConfig.CODEC));

        CRYSTAL = registerCustomFeature("crystal", new CrystalFeature(CrystalConfig.CODEC));
        CRYSTAL_PILLAR = registerCustomFeature("crystal_pillar", new BigCrystal(ModSimpleBlockFeatureConfig.CODEC));

        BUSH = registerCustomFeature("bush_feature", new BushFeature(NoneFeatureConfiguration.CODEC));
        COLORFUL_BUSH = registerCustomFeature("colorful_bush_feature", new ColorfulBushFeature(NoneFeatureConfiguration.CODEC));
        CAVE_BUSH = registerCustomFeature("cave_bush", new CaveBushFeature(NoneFeatureConfiguration.CODEC));
        CAVE_TOP_BUSH = registerCustomFeature("cave_top_bush", new CaveTopBushFeature(NoneFeatureConfiguration.CODEC));

        SIMPLE_BLOCK = registerCustomFeature("simple_block_feature", new SimpleBlockFeature(ModSimpleBlockFeatureConfig.CODEC));

        AMBER_MINERAL = registerCustomFeature("amber_mineral_feature", new AmberFeature(NoneFeatureConfiguration.CODEC));
        ROCKY_STALACTITE = registerCustomFeature("rocky_stalactite_feature", new RockyStalactiteFeature(StalactiteFeatureConfig.CODEC));
        MOSSY_STALACTITE = registerCustomFeature("mossy_stalactite_feature", new MossyStalactiteFeature(StalactiteFeatureConfig.CODEC));
        HUGE_STALACTITE = registerCustomFeature("huge_stalactite_feature", new HugeRockyStalactiteFeature(NoneFeatureConfiguration.CODEC));
        TINY_PUDDLE = registerCustomFeature("tiny_puddle_feature", new TinyPuddle(NoneFeatureConfiguration.CODEC));

        ARCH = registerCustomFeature("arch", new SakuraArchFeature(ArchConfig.CODEC));
        SAKURA_ROCK_STRAIGHT = registerCustomFeature("sakura_rock_straight", new SakuraPlainStraightRockFeature(NoneFeatureConfiguration.CODEC));
        SAKURA_ROCK_FLAT = registerCustomFeature("sakura_rock_flat", new SakuraPlainFlatRockFeature(NoneFeatureConfiguration.CODEC));
        SPIRAL_MUSHROOM = registerCustomFeature("spiral_mushroom", new SpiralMushroom(NoneFeatureConfiguration.CODEC));

        FEATURE_TESTER = registerCustomFeature("feature_tester", new DevFeature(ModSimpleBlockFeatureConfig.CODEC));
    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> F registerCustomFeature(String name, F feature) {
        return Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, name), feature);
    }
}
