package fr.rodofire.mushrooomsmod.world.biome.overworld;

import com.mojang.datafixers.util.Pair;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;

public class ModCaveRegion extends Region {
    public ModCaveRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        BiomesRegion region = new BiomesRegion(builder);
        //Blue Luminescent Schroom Cave
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.ICY)
                .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.WET))
                .continentalness(ParameterUtils.Continentalness.DEEP_OCEAN, ParameterUtils.Continentalness.OCEAN)
                .erosion(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_1)
                .depth(Climate.Parameter.span(0.4F, 1.1F))
                .weirdness(ParameterUtils.Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.BLUE_LUMINESCENT_SHROOM_CAVE));

        //Purple Schroom Cave
        /*new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.NEUTRAL,ParameterUtils.Temperature.WARM))
                    .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.WET))
                        .continentalness(ParameterUtils.Continentalness.DEEP_OCEAN)
                            .erosion(ParameterUtils.Erosion.EROSION_1,ParameterUtils.Erosion.EROSION_2, ParameterUtils.Erosion.EROSION_3)
                                .depth(ParameterUtils.Depth.UNDERGROUND)
                                    .weirdness(ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING, ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING)
                                        .build().forEach(point -> builder.add(point, ModOverworldBiomes.PURPLE_SHROOM_CAVE));*/

        //Vanilla Cave
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.COOL, ParameterUtils.Temperature.NEUTRAL))
                .humidity(Climate.Parameter.span(-0.2f, 0.6f))
                .continentalness(Climate.Parameter.span(0.2f, 0.75f))
                .erosion(Climate.Parameter.span(-0.5f, 0.7f))
                .depth(ParameterUtils.Depth.UNDERGROUND)
                .weirdness(Climate.Parameter.span(0.6f, 1.0f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.VANILLA_SHROOM_CAVE));

        //Crystal Cave
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(Climate.Parameter.span(0f, 1.0f))
                .humidity(Climate.Parameter.span(-1f, 0.5f))
                .continentalness(Climate.Parameter.span(0.5f, 1.0f))
                .erosion(Climate.Parameter.span(0f, 1.0f))
                .depth(Climate.Parameter.span(0.2F, 1.1F))
                .weirdness(Climate.Parameter.span(0.03f, 0.55f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.CRYSTAL_CAVE));

        //Forest Cave
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.HOT)
                .humidity(ParameterUtils.Humidity.DRY, ParameterUtils.Humidity.NEUTRAL)
                .continentalness(ParameterUtils.Continentalness.FAR_INLAND)
                .erosion(Climate.Parameter.span(-1f, 0f))
                .depth(ParameterUtils.Depth.UNDERGROUND)
                .weirdness(Climate.Parameter.span(-1f, 0.05f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.FOREST_CAVE));

        region.addBiome(
                -0.5f, 0.5f,
                -1f, -0.4f,
                0f, 1f,
                -1f, 0f,
                0.2f, 1.1f,
                0.3f, 1f,
                ModOverworldBiomes.ROCKY_CAVE
        );

        region.addBiome(
                0.2f, 0.55f,
                0.3f, 1.0f,
                0f, 1f,
                -1f, 0f,
                0.2f, 1.1f,
                0.1f, 1f,
                ModOverworldBiomes.MOSSY_CAVE
        );
        /*new ParameterUtils.ParameterPointListBuilder()
                .temperature(MultiNoiseUtil.ParameterRange.of(-1F, 0.5F))
                .humidity(MultiNoiseUtil.ParameterRange.of(-1F, 0F))
                .continentalness(MultiNoiseUtil.ParameterRange.of(0F, 1F))
                .erosion(MultiNoiseUtil.ParameterRange.of(-1f, 0f))
                .depth(MultiNoiseUtil.ParameterRange.of(0.2F, 1.1F))
                .weirdness(MultiNoiseUtil.ParameterRange.of(0f, 1f))
                .build().forEach(point -> builder.add(point, ModOverworldBiomes.ROCKY_CAVE));*/

        builder.build().forEach(mapper);
    }
}
