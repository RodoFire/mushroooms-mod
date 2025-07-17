package fr.rodofire.mushrooomsmod.world.biome.overworld;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import fr.rodofire.mushrooomsmod.MushrooomsMod;

public class ModOverworldBiomes {
    /*----------Surface----------*/
    public static final ResourceKey<Biome> MUSHROOM_SHIRE = registerBiome("mushroom_shire");
    public static final ResourceKey<Biome> MYSTIC_MUSHROGROVE = registerBiome("mystic_mushgrove");
    public static final ResourceKey<Biome> GOLDEN_MYCOSHROOM = registerBiome("golden_mycoschroom");
    public static final ResourceKey<Biome> SAKURA_FOREST = registerBiome("sakura_forest");
    public static final ResourceKey<Biome> MAGICAL_PLAINS = registerBiome("magical_plain");
    public static final ResourceKey<Biome> COLORFUL_PLAINS = registerBiome("colorful_plain");
    public static final ResourceKey<Biome> COLORFUL_FOREST = registerBiome("colorful_forest");
    public static final ResourceKey<Biome> BLUE_MUSHROOM_FOREST = registerBiome("blue_mushroom_forest");

    /*----------Cave----------*/
    public static final ResourceKey<Biome> PURPLE_SHROOM_CAVE = registerBiome("purple_luminescent_shroom_cave");
    public static final ResourceKey<Biome> BLUE_LUMINESCENT_SHROOM_CAVE = registerBiome("blue_luminescent_shroom_cave");
    public static final ResourceKey<Biome> VANILLA_SHROOM_CAVE = registerBiome("vanilla_schroom_cave");
    public static final ResourceKey<Biome> CRYSTAL_CAVE = registerBiome("crystal_cave");
    public static final ResourceKey<Biome> FOREST_CAVE = registerBiome("forest_cave");
    public static final ResourceKey<Biome> ROCKY_CAVE = registerBiome("rocky_cave");
    public static final ResourceKey<Biome> MOSSY_CAVE = registerBiome("mossy_cave");

    public static void bootstrap(BootstrapContext<Biome> context) {
        //Surface
        context.register(MUSHROOM_SHIRE, ModOverworldBiomeCreator.SurFaceBiomes.createMushroomShire(context));
        context.register(MYSTIC_MUSHROGROVE, ModOverworldBiomeCreator.SurFaceBiomes.createMysticMushGrove(context));
        context.register(GOLDEN_MYCOSHROOM, ModOverworldBiomeCreator.SurFaceBiomes.createGoldenMycoShroom(context));
        context.register(BLUE_MUSHROOM_FOREST, ModOverworldBiomeCreator.SurFaceBiomes.createBlueMushroomForest(context));
        context.register(SAKURA_FOREST, ModOverworldBiomeCreator.SurFaceBiomes.createSakuraForest(context));
        context.register(COLORFUL_PLAINS, ModOverworldBiomeCreator.SurFaceBiomes.createColorfulPlains(context));
        context.register(COLORFUL_FOREST, ModOverworldBiomeCreator.SurFaceBiomes.createColorfulForest(context));

        //Underground
        context.register(BLUE_LUMINESCENT_SHROOM_CAVE, ModOverworldBiomeCreator.UnderGroundBiomes.createBlueLuminescentShroomCave(context));
        //context.register(PURPLE_SHROOM_CAVE, ModOverworldBiomeCreator.UnderGroundBiomes.createPurpleSchroomCave(context));
        context.register(VANILLA_SHROOM_CAVE, ModOverworldBiomeCreator.UnderGroundBiomes.createVanillaSchroomCave(context));
        context.register(CRYSTAL_CAVE, ModOverworldBiomeCreator.UnderGroundBiomes.createCrystalCave(context));
        context.register(FOREST_CAVE, ModOverworldBiomeCreator.UnderGroundBiomes.createForestCave(context));
        context.register(ROCKY_CAVE, ModOverworldBiomeCreator.UnderGroundBiomes.createRockyCave(context));
        context.register(MOSSY_CAVE, ModOverworldBiomeCreator.UnderGroundBiomes.createMossyCave(context));
    }

    public static ResourceKey<Biome> registerBiome(String id) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, id));
    }
}
