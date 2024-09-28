package net.rodofire.mushrooomsmod.world.biome.overworld;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
    public ModOverworldRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    //https://mcreator.net/wiki/vanilla-biome-settings-data-list
    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        //Sakura Plain
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.NEUTRAL)
                .humidity(ParameterUtils.Humidity.HUMID)
                .continentalness(ParameterUtils.Continentalness.MID_INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_6)
                                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(ParameterUtils.Weirdness.LOW_SLICE_VARIANT_ASCENDING)
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.SAKURA_FOREST));

        //Shroom Island
        /*new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.HOT)
                .humidity(ParameterUtils.Humidity.DRY)
                .continentalness(ParameterUtils.Continentalness.MUSHROOM_FIELDS, ParameterUtils.Continentalness.NEAR_INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_0)
                .depth(ParameterUtils.Depth.UNDERGROUND)
                .weirdness(MultiNoiseUtil.ParameterRange.of(-1f, 0f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.SHROOM_ISLAND1));

        //Shroom Island 2
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.HOT)
                .humidity(ParameterUtils.Humidity.DRY)
                .continentalness(ParameterUtils.Continentalness.MUSHROOM_FIELDS, ParameterUtils.Continentalness.NEAR_INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_0)
                .depth(ParameterUtils.Depth.UNDERGROUND)
                .weirdness(MultiNoiseUtil.ParameterRange.of(0f, 1f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.SHROOM_ISLAND2));*/

        //colorful plains
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.NEUTRAL)
                .humidity(ParameterUtils.Humidity.NEUTRAL)
                .continentalness(ParameterUtils.Continentalness.INLAND)
                .erosion(MultiNoiseUtil.ParameterRange.of(-1f, 0f))
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(MultiNoiseUtil.ParameterRange.of(-1f, 0.05f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.COLORFUL_PLAINS));

        //colorful forest
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.NEUTRAL)
                .humidity(ParameterUtils.Humidity.NEUTRAL)
                .continentalness(ParameterUtils.Continentalness.INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_5, ParameterUtils.Erosion.EROSION_4)
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(MultiNoiseUtil.ParameterRange.of(-1f, 0.05f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.COLORFUL_FOREST));

        //blue mushroom forest
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.NEUTRAL)
                .humidity(ParameterUtils.Humidity.WET)
                .continentalness(ParameterUtils.Continentalness.INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_3)
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(MultiNoiseUtil.ParameterRange.of(-1f, 0.05f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.BLUE_MUSHROOM_FOREST));

        builder.build().forEach(mapper);
    }
}
