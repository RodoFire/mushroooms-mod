package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.bush;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.util.BlockPlaceUtil;
import net.rodofire.easierworldcreator.util.FastNoiseLite;
import net.rodofire.easierworldcreator.util.LongPosHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CaveBushFeature extends Feature<DefaultFeatureConfig> {
    public CaveBushFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();

        if (!world.getBlockState(pos.down()).isOpaqueFullCube() || world.getBlockState(pos).isOpaqueFullCube()) {
            return false;
        }

        BlockState[] blocks = new BlockState[]{
                Blocks.AZALEA_LEAVES.getDefaultState().with(Properties.PERSISTENT, true),
                Blocks.FLOWERING_AZALEA_LEAVES.getDefaultState().with(Properties.PERSISTENT, true),
                Blocks.JUNGLE_LEAVES.getDefaultState().with(Properties.PERSISTENT, true),
                Blocks.OAK_LEAVES.getDefaultState().with(Properties.PERSISTENT, true)
        };

        blocks = Arrays.stream(blocks).parallel().filter(block -> random.nextFloat() < 0.5f).toArray(BlockState[]::new);
        if (blocks.length == 0) {
            blocks = new BlockState[]{
                    Blocks.JUNGLE_LEAVES.getDefaultState().with(Properties.PERSISTENT, true)
            };
        }


        SphereGen sphere = new SphereGen(pos, random.nextBetween(1, 3));
        sphere.setRadiusY(random.nextBetween(1, 2));

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

    private boolean verifyAir(BlockPos pos, Map<BlockPos, Boolean> isNearAir, StructureWorldAccess world) {
        BlockPos up = pos.up();
        if (isNearAir.containsKey(up)) {
            return isNearAir.get(up);
        }
        boolean isAir = world.isAir(up);
        isNearAir.put(up, isAir);
        return isAir;
    }
}
