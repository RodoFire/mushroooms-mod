package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.wg;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.blocklist.DividedBlockListManager;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.util.BlockPlaceUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public abstract class OrangeMushroomWG extends Feature<NoneFeatureConfiguration> {
    protected BlockPos end;
    protected RandomSource random;

    public OrangeMushroomWG(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    public boolean canGenerate(WorldGenLevel world, BlockPos pos, int large, int largeY, int height) {
        for (int i = -1; i <= 1; ++i) {
            for (int j = 1; j <= height; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    if (BlockPlaceUtil.verifyBlock(world, false, null, pos.offset(i, j, k))) continue;
                    return false;
                }
            }
        }
        for (int i = -large; i <= large; ++i) {
            for (int j = -largeY / 2; j <= largeY; ++j) {
                for (int k = -large; k <= large; ++k) {
                    if (BlockPlaceUtil.verifyBlock(world, false, null, end.offset(i, j, k))) continue;
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();
        this.random = random;

        if(world.getBlockState(pos).is(Blocks.WATER))
            return false;
        if(!world.getBlockState(pos.below()).is(BlockTags.MUSHROOM_GROW_BLOCK))
            return false;

        DividedBlockListManager blockList;
        int radius;
        int radiusY;

        if (MathUtil.getRandomBoolean(random, 0.3f)) {
            radius = random.nextIntBetweenInclusive(5, 8);
            radiusY = (int) ((float) random.nextIntBetweenInclusive(20, 55) / 10 * radius + random.nextIntBetweenInclusive(2, 6));
            int height = 3 * radiusY / 4 + random.nextIntBetweenInclusive(-3, 3);

            this.end = pos.above(height);
            if (!canGenerate(world, pos, radius, radiusY, height)) {
                return false;
            }

            blockList = this.getHugeTrunk(world, random, pos, radius, height);
            this.getCap(world, random, pos, radius, radiusY, blockList);
        } else {
            radius = random.nextIntBetweenInclusive(3, 5);
            radiusY = (int) ((float) random.nextIntBetweenInclusive(20, 40) / 10 * radius + random.nextIntBetweenInclusive(2, 6));
            int height = 3 * radiusY / 4;

            this.end = pos.above(height);
            if (!canGenerate(world, pos, radius, radiusY, height)) {
                return false;
            }

            blockList = this.getTrunk(world, random, pos, radius, height);
        }
        SphereGen[] spgeres = this.getCap(world, random, pos, radius, radiusY, blockList);
        this.place(world, pos, end, blockList, spgeres[0], spgeres[1]);
        return true;
    }

    protected abstract DividedBlockListManager getHugeTrunk(WorldGenLevel world, RandomSource random, BlockPos pos, int radius, int height);


    protected abstract DividedBlockListManager getTrunk(WorldGenLevel world, RandomSource random, BlockPos pos, int radius, int height);

    protected abstract SphereGen[] getCap(WorldGenLevel world, RandomSource random, BlockPos pos, int radius, int radiusY, DividedBlockListManager trunk);


    protected abstract void place(WorldGenLevel world, BlockPos pos, BlockPos pos2, DividedBlockListManager coordinates, SphereGen sphere, SphereGen secondSphere);
}
