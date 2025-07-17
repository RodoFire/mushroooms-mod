package fr.rodofire.mushrooomsmod.world.gen;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.platform.Services;
import fr.rodofire.mushrooomsmod.world.features.placedfeatures.ModNetherPlacedFeatures;
import fr.rodofire.mushrooomsmod.world.features.placedfeatures.ModSurfacePlacedFeatures;
import fr.rodofire.mushrooomsmod.world.features.placedfeatures.ModUndergroundPlacedFeatures;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.HashSet;
import java.util.Set;

public class ModWorldGeneration {
    public static void registerModWorldGen() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering World Generation.");
        generateGrass();
        generateFlowers();
        generateOres();

    }

    public static void generateFlowers() {
        registerModification(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.WYSTERIA, Biomes.SWAMP, Biomes.MANGROVE_SWAMP);
        registerModification(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.ACONIT, Biomes.SWAMP);
    }

    public static void generateGrass() {
        registerModification(GenerationStep.Decoration.VEGETAL_DECORATION, ModSurfacePlacedFeatures.TINY_GRASS, Biomes.PLAINS);
    }

    public static void generateOres() {
        registerModification(GenerationStep.Decoration.UNDERGROUND_ORES, ModUndergroundPlacedFeatures.RHYOLITE, BiomeTags.IS_OVERWORLD);
        registerModification(GenerationStep.Decoration.UNDERGROUND_ORES, ModNetherPlacedFeatures.AMBER_ORE_NETHER_PLACED_FEATURES, BiomeTags.IS_NETHER);
        registerModification(GenerationStep.Decoration.UNDERGROUND_ORES, ModUndergroundPlacedFeatures.AMBER_MINERAL, BiomeTags.IS_OVERWORLD);

    }

    @SafeVarargs
    private static void registerModification(GenerationStep.Decoration step, ResourceKey<PlacedFeature> placedFeature, ResourceKey<Biome>... biome) {
        Services.PLATFORM.registerBiomeModfication(step, placedFeature, biome);
    }

    @SafeVarargs
    private static void registerModification(GenerationStep.Decoration step, ResourceKey<PlacedFeature> placedFeature, TagKey<Biome>... biome) {
        Services.PLATFORM.registerBiomeModfication(step, placedFeature, biome);
    }

    public static void generateVines() {
        //BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.BLUE_LUMINESCENT_VINES_PLACED_KEY);
    }
}
