package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.bush;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.util.BlockPlaceUtil;
import fr.rodofire.ewc.util.FastNoiseLite;
import fr.rodofire.ewc.util.LongPosHelper;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class CaveBushFeature extends Feature<NoneFeatureConfiguration> {
    public CaveBushFeature(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();

        if (!world.getBlockState(pos.below()).isSolidRender(world, pos.below()) || world.getBlockState(pos).isSolidRender(world, pos)) {
            return false;
        }

        BlockState[] blocks = new BlockState[]{
                Blocks.AZALEA_LEAVES.defaultBlockState().setValue(BlockStateProperties.PERSISTENT, true),
                Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState().setValue(BlockStateProperties.PERSISTENT, true),
                Blocks.JUNGLE_LEAVES.defaultBlockState().setValue(BlockStateProperties.PERSISTENT, true),
                Blocks.OAK_LEAVES.defaultBlockState().setValue(BlockStateProperties.PERSISTENT, true)
        };

        blocks = Arrays.stream(blocks).parallel().filter(block -> random.nextFloat() < 0.5f).toArray(BlockState[]::new);
        if (blocks.length == 0) {
            blocks = new BlockState[]{
                    Blocks.JUNGLE_LEAVES.defaultBlockState().setValue(BlockStateProperties.PERSISTENT, true)
            };
        }


        SphereGen sphere = new SphereGen(pos, random.nextIntBetweenInclusive(1, 3));
        sphere.setRadiusY(random.nextIntBetweenInclusive(1, 2));

        Map<ChunkPos, LongOpenHashSet> posList = sphere.getShapeCoordinates();

        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());

        Map<BlockPos, Boolean> isAirNear = new HashMap<>();
        BlockState[] finalBlocks = blocks;
        for (LongOpenHashSet entry : posList.values()) {
            entry.forEach(
                    (blockPos) -> {
                        if (noise.GetNoise(blockPos) > 0.5f && verifyAir(LongPosHelper.decodeBlockPos(blockPos), isAirNear, world)) {
                            return;
                        }
                        BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), LongPosHelper.decodeBlockPos(blockPos), finalBlocks[finalBlocks.length == 1 ? 0 : random.nextInt(finalBlocks.length - 1)]);
                    }
            );
        }
        return true;
    }

    private boolean verifyAir(BlockPos pos, Map<BlockPos, Boolean> isNearAir, WorldGenLevel world) {
        BlockPos up = pos.above();
        if (isNearAir.containsKey(up)) {
            return isNearAir.get(up);
        }
        boolean isAir = world.isEmptyBlock(up);
        isNearAir.put(up, isAir);
        return isAir;
    }
}
