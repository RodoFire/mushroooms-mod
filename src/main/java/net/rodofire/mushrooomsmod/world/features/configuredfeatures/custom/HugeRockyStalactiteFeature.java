package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.easierworldcreator.tag.TagUtil;
import net.rodofire.easierworldcreator.util.BlockPlaceUtil;
import net.rodofire.mushrooomsmod.util.ModTags;

import java.util.Set;

public class HugeRockyStalactiteFeature extends Feature<DefaultFeatureConfig> {
    StructureWorldAccess world;
    BlockPos pos;
    Random random;
    Block[] base;
    BlockState[] basePut;
    Block[] top;
    BlockState[] topPut;

    public HugeRockyStalactiteFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        world = context.getWorld();
        pos = context.getOrigin();
        random = context.getRandom();

        boolean up = world.getBlockState(pos.up()).isOpaqueFullCube();

        base = TagUtil.BlockTags.convertBlockTagToBlockArray(ModTags.Blocks.ROCKY_STALACTITE_BASE);
        top = TagUtil.BlockTags.convertBlockTagToBlockArray(ModTags.Blocks.ROCKY_STALACTITE_TOP);

        if (random.nextBoolean()) {
            placeBiBlock();
        } else {
            placeRandom();
        }

        int baseHeight = random.nextBetween(6, 8);
        int maxVariation = 3;

        int distance = random.nextBetween(2, 3);

        int maxDistance = 2 * distance;
        for (int i = -distance; i <= distance; i++) {
            for (int j = -distance; j <= distance; j++) {
                boolean canPlace = false;
                boolean requirePlace = !world.getBlockState(pos.add(i, up ? 1 : -1, j)).isOpaqueFullCube();
                for (int k = 0; k >= -10; k--) {
                    if (world.getBlockState(pos.add(i, up ? -k : k, j)).isOpaqueFullCube()) {
                        canPlace = true;
                        break;
                    }
                }
                if (!canPlace) continue;

                for (int k = 0; k >= -10 && requirePlace; k--) {
                    requirePlace = BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), pos.add(i, up ? -k : k, j), basePut[random.nextBetween(0, basePut.length - 1)]);
                }
                int internalDistance = MathUtil.absDistance(i, j);
                double proximityFactor = 1.0 - ((double) internalDistance / maxDistance);
                int height = (int) ((baseHeight + random.nextBetween(-4, maxVariation + 1)) * proximityFactor);
                for (int k = 0; k < height; k++) {
                    BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), pos.add(i, up ? -k : k, j), basePut[random.nextBetween(0, basePut.length - 1)]);
                }
                boolean bl = random.nextFloat() < 0.4f;
                if (bl) {
                    int topHeight = (int) (proximityFactor * random.nextBetween(2, 6));
                    for (int k = 0; k < topHeight; k++) {
                        BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), pos.add(i, up ? -k - height : k + height, j), topPut[random.nextBetween(0, topPut.length - 1)]);
                    }
                }
            }
        }

        return true;
    }

    private void placeBiBlock() {
        basePut = new BlockState[]{base[random.nextBetween(0, base.length - 1)].getDefaultState(), base[random.nextBetween(0, base.length - 1)].getDefaultState()};
        topPut = new BlockState[]{top[random.nextBetween(0, top.length - 1)].getDefaultState(), top[random.nextBetween(0, top.length - 1)].getDefaultState()};
    }

    private void placeRandom() {
        basePut = new BlockState[base.length];
        for (int i = 0; i < base.length; i++) {
            basePut[i] = base[i].getDefaultState();
        }
        topPut = new BlockState[top.length];
        for (int i = 0; i < top.length; i++) {
            topPut[i] = top[i].getDefaultState();
        }
    }
}
