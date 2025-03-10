package net.rodofire.mushrooomsmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.rodofire.mushrooomsmod.world.features.placedfeatures.ModNetherPlacedFeatures;
import net.rodofire.mushrooomsmod.world.features.placedfeatures.ModUndergroundPlacedFeatures;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModUndergroundPlacedFeatures.RHYOLITE_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModNetherPlacedFeatures.AMBER_ORE_NETHER_PLACED_FEATURES);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModUndergroundPlacedFeatures.AMBER_MINERAL_KEY);

    }
}
