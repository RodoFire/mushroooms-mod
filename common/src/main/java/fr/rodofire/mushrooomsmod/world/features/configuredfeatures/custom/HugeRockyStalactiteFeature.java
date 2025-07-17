package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.ewc.util.BlockPlaceUtil;
import fr.rodofire.ewc.util.TagUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import fr.rodofire.mushrooomsmod.util.ModTags;

import java.util.Set;

public class HugeRockyStalactiteFeature extends Feature<NoneFeatureConfiguration> {
    WorldGenLevel world;
    BlockPos pos;
    RandomSource random;
    Block[] base;
    BlockState[] basePut;
    Block[] top;
    BlockState[] topPut;

    public HugeRockyStalactiteFeature(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        world = context.level();
        pos = context.origin();
        random = context.random();

        boolean up = world.getBlockState(pos.above()).isSolidRender(world, pos.above());

        base = TagUtil.convertTag2Array(Block.class, BuiltInRegistries.BLOCK, ModTags.Blocks.ROCKY_STALACTITE_BASE);
        top = TagUtil.convertTag2Array(Block.class, BuiltInRegistries.BLOCK, ModTags.Blocks.ROCKY_STALACTITE_TOP);

        if (random.nextBoolean()) {
            placeBiBlock();
        } else {
            placeRandom();
        }

        int baseHeight = random.nextIntBetweenInclusive(6, 8);
        int maxVariation = 3;

        int distance = random.nextIntBetweenInclusive(2, 3);

        int maxDistance = 2 * distance;
        for (int i = -distance; i <= distance; i++) {
            for (int j = -distance; j <= distance; j++) {
                boolean canPlace = false;
                boolean requirePlace = !world.getBlockState(pos.offset(i, up ? 1 : -1, j)).isSolidRender(world, pos);
                for (int k = 0; k >= -10; k--) {
                    if (world.getBlockState(pos.offset(i, up ? -k : k, j)).isSolidRender(world, pos.offset(i, up ? -k : k, j))) {
                        canPlace = true;
                        break;
                    }
                }
                if (!canPlace) continue;

                for (int k = 0; k >= -10 && requirePlace; k--) {
                    requirePlace = BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), pos.offset(i, up ? -k : k, j), basePut[random.nextIntBetweenInclusive(0, basePut.length - 1)]);
                }
                int internalDistance = MathUtil.absDistance(i, j);
                double proximityFactor = 1.0 - ((double) internalDistance / maxDistance);
                int height = (int) ((baseHeight + random.nextIntBetweenInclusive(-4, maxVariation + 1)) * proximityFactor);
                for (int k = 0; k < height; k++) {
                    BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), pos.offset(i, up ? -k : k, j), basePut[random.nextIntBetweenInclusive(0, basePut.length - 1)]);
                }
                boolean bl = random.nextFloat() < 0.4f;
                if (bl) {
                    int topHeight = (int) (proximityFactor * random.nextIntBetweenInclusive(2, 6));
                    for (int k = 0; k < topHeight; k++) {
                        BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), pos.offset(i, up ? -k - height : k + height, j), topPut[random.nextIntBetweenInclusive(0, topPut.length - 1)]);
                    }
                }
            }
        }

        return true;
    }

    private void placeBiBlock() {
        basePut = new BlockState[]{base[random.nextIntBetweenInclusive(0, base.length - 1)].defaultBlockState(), base[random.nextIntBetweenInclusive(0, base.length - 1)].defaultBlockState()};
        topPut = new BlockState[]{top[random.nextIntBetweenInclusive(0, top.length - 1)].defaultBlockState(), top[random.nextIntBetweenInclusive(0, top.length - 1)].defaultBlockState()};
    }

    private void placeRandom() {
        basePut = new BlockState[base.length];
        for (int i = 0; i < base.length; i++) {
            basePut[i] = base[i].defaultBlockState();
        }
        topPut = new BlockState[top.length];
        for (int i = 0; i < top.length; i++) {
            topPut[i] = top[i].defaultBlockState();
        }
    }
}
