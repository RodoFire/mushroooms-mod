package fr.rodofire.mushrooomsmod.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.Util;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class HangingGrowthFeatureConfig implements FeatureConfiguration {
    public static final Codec<HangingGrowthFeatureConfig> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                            BuiltInRegistries.BLOCK
                                    .byNameCodec()
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
                            RegistryCodecs.homogeneousList(Registries.BLOCK).fieldOf("can_be_placed_on").forGetter(config -> config.canPlaceOn)
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
    public final HolderSet<Block> canPlaceOn;
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
            HolderSet<Block> canPlaceOn
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
            Direction.Plane.HORIZONTAL.forEach(this.directions::add);
        }
    }

    public List<Direction> shuffleDirections(RandomSource random, Direction excluded) {
        return Util.toShuffledList(this.directions.stream().filter(direction -> direction != excluded), random);
    }

    public List<Direction> shuffleDirections(RandomSource random) {
        return Util.shuffledCopy(this.directions, random);
    }
}
