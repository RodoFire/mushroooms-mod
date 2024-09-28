package net.rodofire.mushrooomsmod.world.biome.overworld;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.rodofire.mushrooomsmod.MushrooomsMod;

public class ModOverworldBiomes {
    /*----------Surface----------*/
    public static final RegistryKey<Biome> SHROOM_ISLAND1 = registerBiome("shroom_island1");
    //Schroom island with different mushrooms than the first biome
    public static final RegistryKey<Biome> SHROOM_ISLAND2 = registerBiome("shroom_island2");
    public static final RegistryKey<Biome> SAKURA_FOREST = registerBiome("sakura_forest");
    public static final RegistryKey<Biome> MAGICAL_PLAINS = registerBiome("magical_plain");
    public static final RegistryKey<Biome> COLORFUL_PLAINS = registerBiome("colorful_plain");
    public static final RegistryKey<Biome> COLORFUL_FOREST = registerBiome("colorful_forest");
    public static final RegistryKey<Biome> BLUE_MUSHROOM_FOREST = registerBiome("blue_mushroom_forest");

    /*----------Cave----------*/
    public static final RegistryKey<Biome> PURPLE_SHROOM_CAVE = registerBiome("purple_luminescent_shroom_cave");
    public static final RegistryKey<Biome> BLUE_LUMINESCENT_SHROOM_CAVE = registerBiome("blue_luminescent_shroom_cave");
    public static final RegistryKey<Biome> VANILLA_SHROOM_CAVE = registerBiome("vanilla_schroom_cave");
    public static final RegistryKey<Biome> CRYSTAL_CAVE = registerBiome("crystal_cave");
    public static final RegistryKey<Biome> FOREST_CAVE = registerBiome("forest_cave");

    public static void bootstrap(Registerable<Biome> context) {
        //Surface
        //context.register(SHROOM_ISLAND1, ModOverworldBiomeCreator.SurFaceBiomes.createShroomIsland1(context));
        //context.register(SHROOM_ISLAND2, ModOverworldBiomeCreator.SurFaceBiomes.createShroomIsland2(context));
        context.register(SAKURA_FOREST, ModOverworldBiomeCreator.SurFaceBiomes.createSakuraForest(context));
        context.register(COLORFUL_PLAINS, ModOverworldBiomeCreator.SurFaceBiomes.createColorfulPlains(context));
        context.register(COLORFUL_FOREST, ModOverworldBiomeCreator.SurFaceBiomes.createColorfulForest(context));
        context.register(BLUE_MUSHROOM_FOREST, ModOverworldBiomeCreator.SurFaceBiomes.createBlueMushroomForest(context));

        //Underground
        context.register(BLUE_LUMINESCENT_SHROOM_CAVE, ModOverworldBiomeCreator.UnderGroundBiomes.createBlueLuminescentShroomCave(context));
        //context.register(PURPLE_SHROOM_CAVE, ModOverworldBiomeCreator.UnderGroundBiomes.createPurpleSchroomCave(context));
        context.register(VANILLA_SHROOM_CAVE, ModOverworldBiomeCreator.UnderGroundBiomes.createVanillaSchroomCave(context));
        context.register(CRYSTAL_CAVE, ModOverworldBiomeCreator.UnderGroundBiomes.createCrystalCave(context));
        context.register(FOREST_CAVE, ModOverworldBiomeCreator.UnderGroundBiomes.createForestCave(context));
    }

    public static RegistryKey<Biome> registerBiome(String id) {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(MushrooomsMod.MOD_ID, id));
    }
}
