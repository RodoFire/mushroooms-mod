package net.rodofire.mushrooomsmod.world.biome.overworld;


import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;


public class ModOverworldRegionSimplified extends Region {
    public ModOverworldRegionSimplified(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.PLAINS, ModOverworldBiomes.COLORFUL_PLAINS);
        });
        /*this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.MUSHROOM_FIELDS, ModOverworldBiomes.SHROOM_ISLAND1);
        });
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.MUSHROOM_FIELDS, ModOverworldBiomes.SHROOM_ISLAND2);
        });*/
    }
}
