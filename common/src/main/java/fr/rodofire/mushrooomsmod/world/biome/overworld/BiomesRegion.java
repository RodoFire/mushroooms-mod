package fr.rodofire.mushrooomsmod.world.biome.overworld;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
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
                  ResourceKey<Biome> biome) {
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(Climate.Parameter.span(minTemp, maxTemp))
                .humidity(Climate.Parameter.span(minHumidity, maxHumidity))
                .continentalness(Climate.Parameter.span(minContinentalness, maxContinentalness))
                .erosion(Climate.Parameter.span(minErosion, maxErosion))
                .depth(Climate.Parameter.span(mindepth, maxDepth))
                .weirdness(Climate.Parameter.span(minWeirdness, maxWeirdnes))
                .build().forEach(point -> builder.add(point, biome));
    }

    void addBiome(Climate.Parameter temp,
                  Climate.Parameter humidity,
                  Climate.Parameter continentalness,
                  Climate.Parameter erosion,
                  Climate.Parameter depth,
                  Climate.Parameter weirdness,
                  ResourceKey<Biome> biome) {
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
                  ResourceKey<Biome> biome) {
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
                            ResourceKey<Biome> biome) {
        addBiome(temperature, humidity, ParameterUtils.Continentalness.DEEP_OCEAN, erosion, depth, weirdness, biome);
    }

    void addDefaultOceanBiomes(ParameterUtils.Temperature temperature, ParameterUtils.Humidity humidity,
                               ParameterUtils.Erosion erosion,
                               ParameterUtils.Depth depth, ParameterUtils.Weirdness weirdness,
                               ResourceKey<Biome> biome) {
        addBiome(temperature, humidity, ParameterUtils.Continentalness.OCEAN, erosion, depth, weirdness, biome);
    }

    void addOceanBiomes(ParameterUtils.Temperature temperature, ParameterUtils.Humidity humidity,
                        ParameterUtils.Erosion erosion,
                        ParameterUtils.Depth depth, ParameterUtils.Weirdness weirdness,
                        ResourceKey<Biome> biome) {
        addBiome(ParameterUtils.Temperature.span(temperature, temperature),
                ParameterUtils.Humidity.span(humidity, humidity),
                ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.OCEAN, ParameterUtils.Continentalness.DEEP_OCEAN),
                ParameterUtils.Erosion.span(erosion, erosion),
                ParameterUtils.Depth.span(depth, depth),
                ParameterUtils.Weirdness.span(weirdness, weirdness),
                biome);
    }
}
