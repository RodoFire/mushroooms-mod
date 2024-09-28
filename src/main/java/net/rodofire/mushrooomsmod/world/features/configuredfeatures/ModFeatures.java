package net.rodofire.mushrooomsmod.world.features.configuredfeatures;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.rodofire.mushrooomsmod.world.features.config.*;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.SimpleBlockFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.*;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.*;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.structuremushrooms.CustomGreenSecondMushroomFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.structuremushrooms.CustomRedFertileMushroom;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.structuremushrooms.CustomRedHugeMushroomFeature;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock.SakuraPlainStraightRockFeature;

public abstract class ModFeatures<FC extends FeatureConfig> {

    //Huge mushroom features
    public static Feature<ModMushroomFeatureConfig> HUGE_BLUE_MUSHROOM;
    public static Feature<HugeMushroomFeatureConfig> HUGE_PURPLE_MUSHROOM;
    public static Feature<ModMushroomFeatureConfig> HUGE_GREEN_MUSHROOM;
    public static Feature<HugeMushroomFeatureConfig> HUGE_BLUE_LUMINESCENT_MUSHROOM;
    public static Feature<HugeMushroomFeatureConfig> HUGE_LUMINESCENT_PINK_MUSHROOM;
    public static Feature<ModMushroomFeatureConfig> HUGE_BIG_PURPLE_MUSHROOM;
    public static Feature<HugeMushroomFeatureConfig> HUGE_BIG_GREEN_MUSHROOM;
    public static Feature<ModMushroomFeatureConfig> HUGE_BIG_RED_MUSHROOM;
    public static Feature<HugeMushroomFeatureConfig> HUGE_BIG_ORANGE_MUSHROOM;
    public static Feature<HugeMushroomFeatureConfig> HUGE_BIG_YELLOW_MUSHROOM;
    public static Feature<DefaultFeatureConfig> FERTILE_RED_MUSHROOM;

    //Flowers
    public static Feature<DefaultFeatureConfig> FLEUR_BERRIES;

    //Vines Features;
    public static Feature<TwistingVinesFeatureConfig> BLUE_LUMINESCENT_VINES;
    public static Feature<DirectionConfig> SIMPLE_VINES;

    //Crystal
    public static Feature<CrystalConfig> CRYSTAL;
    public static Feature<ModSimpleBlockFeatureConfig> CRYSTAL_PILLAR;

    //Bush;
    public static Feature<DefaultFeatureConfig> BUSH;
    public static Feature<DefaultFeatureConfig> COLORFUL_BUSH;

    //SimpleBlock
    public static Feature<ModSimpleBlockFeatureConfig> SIMPLE_BLOCK;

    //Cave related
    public static Feature<DefaultFeatureConfig> AMBER_MINERAL;

    //terrain
    public static Feature<ArchConfig> ARCH;
    public static Feature<DefaultFeatureConfig> SAKURA_ROCK_STRAIGHT;
    public static Feature<DefaultFeatureConfig> SPIRAL_MUSHROOM;

    //dev
    public static Feature<ModSimpleBlockFeatureConfig> FEATURE_TESTER;

    public static void addFeatures() {
        HUGE_BLUE_MUSHROOM = registercustomfeature("huge_blue_mushroom", new CustomBlueMushroomFeature(ModMushroomFeatureConfig.CODEC));
        HUGE_PURPLE_MUSHROOM = registercustomfeature("huge_purple_mushroom", new CustomPurpleMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        HUGE_GREEN_MUSHROOM = registercustomfeature("huge_green_mushroom", new CustomGreenMushroomFeature(ModMushroomFeatureConfig.CODEC));
        HUGE_BLUE_LUMINESCENT_MUSHROOM = registercustomfeature("huge_blue_luminescent_mushroom", new CustomLuminescentBlueMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        HUGE_LUMINESCENT_PINK_MUSHROOM = registercustomfeature("huge_luminescent_pink_mushroom", new CustomLuminescentPinkMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        HUGE_BIG_PURPLE_MUSHROOM = registercustomfeature("huge_big_purple_mushroom_feature", new CustomPurpleSecondMushroompFeature(ModMushroomFeatureConfig.CODEC));
        HUGE_BIG_GREEN_MUSHROOM = registercustomfeature("huge_big_green_mushroom_feature", new CustomGreenSecondMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        HUGE_BIG_RED_MUSHROOM = registercustomfeature("huge_red_red_mushroom_feature", new CustomRedHugeMushroomFeature(ModMushroomFeatureConfig.CODEC));
        HUGE_BIG_ORANGE_MUSHROOM = registercustomfeature("huge_orange_mushroom_feature", new CustomOrangeMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        HUGE_BIG_YELLOW_MUSHROOM = registercustomfeature("huge_yellow_mushroom_feature", new CustomYellowMushroomFeature(HugeMushroomFeatureConfig.CODEC));
        FERTILE_RED_MUSHROOM = registercustomfeature("mushroom_fertile_red", new CustomRedFertileMushroom(DefaultFeatureConfig.CODEC));

        FLEUR_BERRIES = registercustomfeature("fleur_berries_feature", new FleurBerriesFeature(DefaultFeatureConfig.CODEC));

        BLUE_LUMINESCENT_VINES = registercustomfeature("blue_luminescent_vines_feature", new BlueLuminescentVinesFeature(TwistingVinesFeatureConfig.CODEC));
        SIMPLE_VINES = registercustomfeature("simple_vines", new SimpleVinesFeature(DirectionConfig.CODEC));

        CRYSTAL = registercustomfeature("crystal", new CrystalFeature(CrystalConfig.CODEC));
        CRYSTAL_PILLAR = registercustomfeature("crystal_pillar", new BigCrystal(ModSimpleBlockFeatureConfig.CODEC));

        BUSH = registercustomfeature("bush_feature", new BushFeature(DefaultFeatureConfig.CODEC));
        COLORFUL_BUSH = registercustomfeature("colorful_bush_feature", new ColorfulBushFeature(DefaultFeatureConfig.CODEC));

        SIMPLE_BLOCK = registercustomfeature("simple_block_feature", new SimpleBlockFeature(ModSimpleBlockFeatureConfig.CODEC));

        AMBER_MINERAL = registercustomfeature("amber_mineral_feature", new AmberFeature(DefaultFeatureConfig.CODEC));

        ARCH = registercustomfeature("arch", new SakuraArchFeature(ArchConfig.CODEC));
        SAKURA_ROCK_STRAIGHT = registercustomfeature("sakura_rock_straight", new SakuraPlainStraightRockFeature(DefaultFeatureConfig.CODEC));
        SPIRAL_MUSHROOM = registercustomfeature("spiral_mushroom", new SpiralMushroom(DefaultFeatureConfig.CODEC));

        FEATURE_TESTER = registercustomfeature("feature_tester", new DevFeature(ModSimpleBlockFeatureConfig.CODEC));
    }

    private static <C extends FeatureConfig, F extends Feature<C>> F registercustomfeature(String name, F feature) {
        return Registry.register(Registries.FEATURE, name, feature);
    }
}
