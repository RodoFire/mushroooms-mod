package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.wg;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.blockdata.blocklist.DividedBlockListManager;
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.util.BlockPlaceUtil;

public abstract class OrangeMushroomWG extends Feature<DefaultFeatureConfig> {
    protected BlockPos end;

    public OrangeMushroomWG(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    public boolean canGenerate(StructureWorldAccess world, BlockPos pos, int large, int largeY, int height) {
        for (int i = -1; i <= 1; ++i) {
            for (int j = 1; j <= height; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    if (BlockPlaceUtil.verifyBlock(world, false, null, pos.add(i, j, k))) continue;
                    return false;
                }
            }
        }
        for (int i = -large; i <= large; ++i) {
            for (int j = -largeY / 2; j <= largeY; ++j) {
                for (int k = -large; k <= large; ++k) {
                    if (BlockPlaceUtil.verifyBlock(world, false, null, end.add(i, j, k))) continue;
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();

        if(world.getBlockState(pos).isOf(Blocks.WATER))
            return false;
        if(!world.getBlockState(pos.down()).isIn(BlockTags.MUSHROOM_GROW_BLOCK))
            return false;

        DividedBlockListManager blockList;
        int radius;
        int radiusY;

        if (MathUtil.getRandomBoolean(0.3f)) {
            radius = random.nextBetween(5, 8);
            radiusY = (int) ((float) random.nextBetween(20, 55) / 10 * radius + random.nextBetween(2, 6));
            int height = 3 * radiusY / 4 + random.nextBetween(-3, 3);

            this.end = pos.up(height);
            if (!canGenerate(world, pos, radius, radiusY, height)) {
                return false;
            }

            blockList = this.getHugeTrunk(world, random, pos, radius, height);
            this.getCap(world, random, pos, radius, radiusY, blockList);
        } else {
            radius = random.nextBetween(3, 5);
            radiusY = (int) ((float) random.nextBetween(20, 40) / 10 * radius + random.nextBetween(2, 6));
            int height = 3 * radiusY / 4;

            this.end = pos.up(height);
            if (!canGenerate(world, pos, radius, radiusY, height)) {
                return false;
            }

            blockList = this.getTrunk(world, random, pos, radius, height);
        }
        SphereGen[] spgeres = this.getCap(world, random, pos, radius, radiusY, blockList);
        this.place(world, pos, end, blockList, spgeres[0], spgeres[1]);
        return true;
    }

    protected abstract DividedBlockListManager getHugeTrunk(StructureWorldAccess world, Random random, BlockPos pos, int radius, int height);


    protected abstract DividedBlockListManager getTrunk(StructureWorldAccess world, Random random, BlockPos pos, int radius, int height);

    protected abstract SphereGen[] getCap(StructureWorldAccess world, Random random, BlockPos pos, int radius, int radiusY, DividedBlockListManager trunk);


    protected abstract void place(StructureWorldAccess world, BlockPos pos, BlockPos pos2, DividedBlockListManager coordinates, SphereGen sphere, SphereGen secondSphere);
}
