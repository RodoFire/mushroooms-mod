package fr.rodofire.mushrooomsmod;

import fr.rodofire.mushrooomsmod.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import fr.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;
import fr.rodofire.mushrooomsmod.world.features.placedfeatures.ModNetherPlacedFeatures;
import fr.rodofire.mushrooomsmod.world.features.placedfeatures.ModSurfacePlacedFeatures;
import fr.rodofire.mushrooomsmod.world.features.placedfeatures.ModUndergroundPlacedFeatures;
import fr.rodofire.mushrooomsmod.world.noises.ModNoises;
import fr.rodofire.mushrooomsmod.world.structures.ModStructures;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import org.apache.http.config.RegistryBuilder;

public class MushrooomsModFabricDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModWorldGenerator::new);

    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, ModSurfacePlacedFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, ModUndergroundPlacedFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, ModNetherPlacedFeatures::bootstrap);
        registryBuilder.add(Registries.BIOME, ModOverworldBiomes::bootstrap);
        registryBuilder.add(Registries.STRUCTURE, ModStructures::bootstrap);
        registryBuilder.add(Registries.NOISE, ModNoises::bootstrap);
    }
}
