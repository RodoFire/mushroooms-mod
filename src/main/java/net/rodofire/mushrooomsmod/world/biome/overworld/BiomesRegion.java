package net.rodofire.mushrooomsmod.world.biome.overworld;

import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.VanillaParameterOverlayBuilder;

public class BiomesRegion {
    private VanillaParameterOverlayBuilder builder;

    public BiomesRegion(VanillaParameterOverlayBuilder parameters) {
        this.builder = parameters;
    }

    void addBiome(float minTemp, float maxTemp,
                  float minHumidity, float maxHumidity,
                  float minContinentalness, float maxContinentalness,
                  float minErosion, float maxErosion,
                  float mindepth, float maxDepth,
                  float minWeirdness, float maxWeirdnes,
                  RegistryKey<Biome> biome) {
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(MultiNoiseUtil.ParameterRange.of(minTemp, maxTemp))
                .humidity(MultiNoiseUtil.ParameterRange.of(minHumidity, maxHumidity))
                .continentalness(MultiNoiseUtil.ParameterRange.of(minContinentalness, maxContinentalness))
                .erosion(MultiNoiseUtil.ParameterRange.of(minErosion, maxErosion))
                .depth(MultiNoiseUtil.ParameterRange.of(mindepth, maxDepth))
                .weirdness(MultiNoiseUtil.ParameterRange.of(minWeirdness, maxWeirdnes))
                .build().forEach(point -> builder.add(point, biome));
    }

    void addBiome(MultiNoiseUtil.ParameterRange temp,
                  MultiNoiseUtil.ParameterRange humidity,
                  MultiNoiseUtil.ParameterRange continentalness,
                  MultiNoiseUtil.ParameterRange erosion,
                  MultiNoiseUtil.ParameterRange depth,
                  MultiNoiseUtil.ParameterRange weirdness,
                  RegistryKey<Biome> biome) {
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(temp)
                .humidity(humidity)
                .continentalness(continentalness)
                .erosion(erosion)
                .depth(depth)
                .weirdness(weirdness)
                .build().forEach(point -> builder.add(point, biome));
    }

    void addBiome(ParameterUtils.Temperature temperature, ParameterUtils.Humidity humidity,
                  ParameterUtils.Continentalness continentalness, ParameterUtils.Erosion erosion,
                  ParameterUtils.Depth depth, ParameterUtils.Weirdness weirdness,
                  RegistryKey<Biome> biome) {
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(temperature)
                .humidity(humidity)
                .continentalness(continentalness)
                .erosion(erosion)
                .depth(depth)
                .weirdness(weirdness)
                .build().forEach(point -> builder.add(point, biome));
    }

    void addDeepOceanBiomes(ParameterUtils.Temperature temperature, ParameterUtils.Humidity humidity,
                            ParameterUtils.Erosion erosion,
                            ParameterUtils.Depth depth, ParameterUtils.Weirdness weirdness,
                            RegistryKey<Biome> biome) {
        addBiome(temperature, humidity, ParameterUtils.Continentalness.DEEP_OCEAN, erosion, depth, weirdness, biome);
    }

    void addDefaultOceanBiomes(ParameterUtils.Temperature temperature, ParameterUtils.Humidity humidity,
                               ParameterUtils.Erosion erosion,
                               ParameterUtils.Depth depth, ParameterUtils.Weirdness weirdness,
                               RegistryKey<Biome> biome) {
        addBiome(temperature, humidity, ParameterUtils.Continentalness.OCEAN, erosion, depth, weirdness, biome);
    }

    void addOceanBiomes(ParameterUtils.Temperature temperature, ParameterUtils.Humidity humidity,
                        ParameterUtils.Erosion erosion,
                        ParameterUtils.Depth depth, ParameterUtils.Weirdness weirdness,
                        RegistryKey<Biome> biome) {
        addBiome(ParameterUtils.Temperature.span(temperature, temperature),
                ParameterUtils.Humidity.span(humidity, humidity),
                ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.OCEAN, ParameterUtils.Continentalness.DEEP_OCEAN),
                ParameterUtils.Erosion.span(erosion, erosion),
                ParameterUtils.Depth.span(depth, depth),
                ParameterUtils.Weirdness.span(weirdness, weirdness),
                biome);
    }
}
