package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.util.BlockPlaceUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import fr.rodofire.mushrooomsmod.world.features.config.HangingGrowthFeatureConfig;

import java.util.List;
import java.util.Set;

public class HangingVinesGrowthFeature extends Feature<HangingGrowthFeatureConfig> {
    public HangingVinesGrowthFeature(Codec<HangingGrowthFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<HangingGrowthFeatureConfig> context) {
        WorldGenLevel structureWorldAccess = context.level();
        BlockPos blockPosBase = context.origin();
        BlockPos blockPos = blockPosBase;
        RandomSource random = context.random();
        HangingGrowthFeatureConfig multifaceGrowthFeatureConfig = context.config();
        boolean placed = false;

        for (int a = 0; a < 10; a++) {
            if (!isAirOrWater(structureWorldAccess.getBlockState(blockPos))) {
            } else {
                List<Direction> list = multifaceGrowthFeatureConfig.shuffleDirections(random);
                if (generate(structureWorldAccess, blockPos, structureWorldAccess.getBlockState(blockPos), multifaceGrowthFeatureConfig, random, list)) {
                    placed = true;
                } else {
                    BlockPos.MutableBlockPos mutable = blockPos.mutable();

                    for (Direction direction : list) {
                        mutable.set(blockPos);
                        List<Direction> list2 = multifaceGrowthFeatureConfig.shuffleDirections(random, direction.getOpposite());

                        for (int i = 0; i < multifaceGrowthFeatureConfig.searchRange; i++) {
                            mutable.setWithOffset(blockPos, direction);
                            BlockState blockState = structureWorldAccess.getBlockState(mutable);
                            if (!isAirOrWater(blockState) && !blockState.is(multifaceGrowthFeatureConfig.lichen)) {
                                break;
                            }

                            if (generate(structureWorldAccess, mutable, blockState, multifaceGrowthFeatureConfig, random, list2)) {
                                placed = true;
                            }
                        }
                    }
                }
            }
            blockPos = blockPosBase.offset(random.nextIntBetweenInclusive(-14, 14), random.nextIntBetweenInclusive(-20, 20), random.nextIntBetweenInclusive(-14, 14));
        }
        return placed;
    }

    public static boolean generate(
            WorldGenLevel world, BlockPos pos, BlockState state, HangingGrowthFeatureConfig config, RandomSource random, List<Direction> directions
    ) {
        BlockPos.MutableBlockPos mutable = pos.mutable();

        for (Direction direction : directions) {
            BlockState blockState = world.getBlockState(mutable.setWithOffset(pos, direction));
            if (blockState.is(config.canPlaceOn)) {
                BlockState blockState2 = config.lichen.defaultBlockState()
                        .setValue(PipeBlock.NORTH, direction.equals(Direction.NORTH))
                        .setValue(PipeBlock.SOUTH, direction.equals(Direction.SOUTH))
                        .setValue(PipeBlock.EAST, direction.equals(Direction.EAST))
                        .setValue(PipeBlock.WEST, direction.equals(Direction.WEST))
                        .setValue(PipeBlock.UP, direction.equals(Direction.UP));

                world.setBlock(pos, blockState2, Block.UPDATE_ALL);
                int randomHeight = random.nextIntBetweenInclusive(1, random.nextIntBetweenInclusive((config.hangingHeight - 1) / 2, config.hangingHeight - 1) + 1);
                world.getChunk(pos).markPosForPostprocessing(pos);

                boolean bl = direction.getAxis().isHorizontal();
                for (int i = 1; i < randomHeight && bl; i++) {
                    bl = BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), pos.below(i), blockState2);
                }
                if (random.nextFloat() < config.spreadChance && direction.getAxis().isHorizontal()) {
                    if (state.canSurvive(world, pos))
                        BlockPlaceUtil.placeBlock(world, pos.relative(direction.getClockWise().getAxis(), random.nextIntBetweenInclusive(0, 1) == 0 ? -1 : 1), blockState2);
                }

                return true;
            }
        }

        return false;
    }

    private static boolean isAirOrWater(BlockState state) {
        return state.isAir() || state.is(Blocks.WATER);
    }
}
