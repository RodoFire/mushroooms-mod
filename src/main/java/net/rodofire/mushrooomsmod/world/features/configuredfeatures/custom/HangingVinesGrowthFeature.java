package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ConnectingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.util.BlockPlaceUtil;
import net.rodofire.mushrooomsmod.world.features.config.HangingGrowthFeatureConfig;

import java.util.List;
import java.util.Set;

public class HangingVinesGrowthFeature extends Feature<HangingGrowthFeatureConfig> {
    public HangingVinesGrowthFeature(Codec<HangingGrowthFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<HangingGrowthFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPosBase = context.getOrigin();
        BlockPos blockPos = blockPosBase;
        Random random = context.getRandom();
        HangingGrowthFeatureConfig multifaceGrowthFeatureConfig = context.getConfig();
        boolean placed = false;
        for (int a = 0; a < 10; a++) {
            if (!isAirOrWater(structureWorldAccess.getBlockState(blockPos))) {
            } else {
                List<Direction> list = multifaceGrowthFeatureConfig.shuffleDirections(random);
                if (generate(structureWorldAccess, blockPos, structureWorldAccess.getBlockState(blockPos), multifaceGrowthFeatureConfig, random, list)) {
                    placed = true;
                } else {
                    BlockPos.Mutable mutable = blockPos.mutableCopy();

                    for (Direction direction : list) {
                        mutable.set(blockPos);
                        List<Direction> list2 = multifaceGrowthFeatureConfig.shuffleDirections(random, direction.getOpposite());

                        for (int i = 0; i < multifaceGrowthFeatureConfig.searchRange; i++) {
                            mutable.set(blockPos, direction);
                            BlockState blockState = structureWorldAccess.getBlockState(mutable);
                            if (!isAirOrWater(blockState) && !blockState.isOf(multifaceGrowthFeatureConfig.lichen)) {
                                break;
                            }

                            if (generate(structureWorldAccess, mutable, blockState, multifaceGrowthFeatureConfig, random, list2)) {
                                placed = true;
                            }
                        }
                    }
                }
            }
            blockPos = blockPosBase.add(random.nextBetween(-14, 14), random.nextBetween(-20, 20), random.nextBetween(-14, 14));
        }
        return placed;
    }

    public static boolean generate(
            StructureWorldAccess world, BlockPos pos, BlockState state, HangingGrowthFeatureConfig config, Random random, List<Direction> directions
    ) {
        BlockPos.Mutable mutable = pos.mutableCopy();

        for (Direction direction : directions) {
            BlockState blockState = world.getBlockState(mutable.set(pos, direction));
            if (blockState.isIn(config.canPlaceOn)) {
                BlockState blockState2 = config.lichen.getDefaultState()
                        .with(ConnectingBlock.NORTH, direction.equals(Direction.NORTH))
                        .with(ConnectingBlock.SOUTH, direction.equals(Direction.SOUTH))
                        .with(ConnectingBlock.EAST, direction.equals(Direction.EAST))
                        .with(ConnectingBlock.WEST, direction.equals(Direction.WEST))
                        .with(ConnectingBlock.UP, direction.equals(Direction.UP));

                world.setBlockState(pos, blockState2, Block.NOTIFY_ALL);
                int randomHeight = random.nextBetween(1, random.nextBetween((config.hangingHeight - 1) / 2, config.hangingHeight - 1) + 1);
                world.getChunk(pos).markBlockForPostProcessing(pos);

                boolean bl = direction.getAxis().isHorizontal();
                for (int i = 1; i < randomHeight && bl; i++) {
                    bl = BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), pos.down(i), blockState2);
                }
                if (random.nextFloat() < config.spreadChance && direction.getAxis().isHorizontal()) {
                    if (state.canPlaceAt(world, pos))
                        BlockPlaceUtil.placeBlock(world, pos.offset(direction.rotateYClockwise().getAxis(), random.nextBetween(0, 1) == 0 ? -1 : 1), blockState2);
                }

                return true;
            }
        }

        return false;
    }

    private static boolean isAirOrWater(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER);
    }
}
