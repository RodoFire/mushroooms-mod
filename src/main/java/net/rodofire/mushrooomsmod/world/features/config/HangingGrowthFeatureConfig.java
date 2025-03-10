package net.rodofire.mushrooomsmod.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryCodecs;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.util.Util;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.List;

public class HangingGrowthFeatureConfig implements FeatureConfig {
    public static final Codec<HangingGrowthFeatureConfig> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                            Registries.BLOCK
                                    .getCodec()
                                    .fieldOf("block")
                                    .flatXmap(HangingGrowthFeatureConfig::validateBlock, DataResult::success)
                                    .orElse((VineBlock) Blocks.VINE)
                                    .forGetter(config -> config.lichen),

                            Codec.intRange(1, 64).fieldOf("search_range").orElse(10).forGetter(config -> config.searchRange),
                            Codec.intRange(1, 64).fieldOf("hanging_height").orElse(1).forGetter(config -> config.hangingHeight),
                            Codec.BOOL.fieldOf("can_place_on_floor").orElse(false).forGetter(config -> config.placeOnFloor),
                            Codec.BOOL.fieldOf("can_place_on_ceiling").orElse(false).forGetter(config -> config.placeOnCeiling),
                            Codec.BOOL.fieldOf("can_place_on_wall").orElse(false).forGetter(config -> config.placeOnWalls),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_spreading").orElse(0.5F).forGetter(config -> config.spreadChance),
                            RegistryCodecs.entryList(RegistryKeys.BLOCK).fieldOf("can_be_placed_on").forGetter(config -> config.canPlaceOn)
                    )
                    .apply(instance, HangingGrowthFeatureConfig::new)
    );
    public final VineBlock lichen;
    public final int searchRange;
    public final int hangingHeight;
    public final boolean placeOnFloor;
    public final boolean placeOnCeiling;
    public final boolean placeOnWalls;
    public final float spreadChance;
    public final RegistryEntryList<Block> canPlaceOn;
    private final ObjectArrayList<Direction> directions;

    private static DataResult<VineBlock> validateBlock(Block block) {
        return block instanceof VineBlock vine
                ? DataResult.success(vine)
                : DataResult.error(() -> "Growth block should be a multiface block");
    }

    public HangingGrowthFeatureConfig(
            VineBlock lichen,
            int searchRange,
            int hangingHeight,
            boolean placeOnFloor,
            boolean placeOnCeiling,
            boolean placeOnWalls,
            float spreadChance,
            RegistryEntryList<Block> canPlaceOn
    ) {
        this.lichen = lichen;
        this.searchRange = searchRange;
        this.hangingHeight = hangingHeight;
        this.placeOnFloor = placeOnFloor;
        this.placeOnCeiling = placeOnCeiling;
        this.placeOnWalls = placeOnWalls;
        this.spreadChance = spreadChance;
        this.canPlaceOn = canPlaceOn;
        this.directions = new ObjectArrayList<>(6);
        if (placeOnCeiling) {
            this.directions.add(Direction.UP);
        }

        if (placeOnWalls) {
            Direction.Type.HORIZONTAL.forEach(this.directions::add);
        }
    }

    public List<Direction> shuffleDirections(Random random, Direction excluded) {
        return Util.copyShuffled(this.directions.stream().filter(direction -> direction != excluded), random);
    }

    public List<Direction> shuffleDirections(Random random) {
        return Util.copyShuffled(this.directions, random);
    }
}
