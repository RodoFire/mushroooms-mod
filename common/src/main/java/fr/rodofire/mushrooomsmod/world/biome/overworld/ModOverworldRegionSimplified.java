package fr.rodofire.mushrooomsmod.world.biome.overworld;


import com.mojang.datafixers.util.Pair;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;


public class ModOverworldRegionSimplified extends Region {
    public ModOverworldRegionSimplified(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.MUSHROOM_FIELDS, ModOverworldBiomes.MUSHROOM_SHIRE);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.MUSHROOM_FIELDS, ModOverworldBiomes.MYSTIC_MUSHROGROVE);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.MUSHROOM_FIELDS, ModOverworldBiomes.GOLDEN_MYCOSHROOM);
        });
        /*this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.MUSHROOM_FIELDS, ModOverworldBiomes.SHROOM_ISLAND2);
        });*/
    }
}
