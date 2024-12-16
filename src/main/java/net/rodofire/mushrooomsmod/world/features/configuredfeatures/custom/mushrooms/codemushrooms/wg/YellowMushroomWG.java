package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.wg;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.blockdata.blocklist.basic.comparator.DefaultBlockListComparator;
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.easierworldcreator.placer.blocks.util.BlockPlaceUtil;
import net.rodofire.easierworldcreator.shape.block.gen.LineGen;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapeBase;

import java.util.List;
import java.util.Set;

public abstract class YellowMushroomWG extends Feature<HugeMushroomFeatureConfig> {

    public YellowMushroomWG(Codec<HugeMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    protected boolean canGenerate(StructureWorldAccess world, BlockPos start, BlockPos end, int large, boolean flat) {
        for (int i = -(int) ((flat ? 1.5f : 2) * large + 1); i < (int) ((flat ? 1.5f : 2) * large + 1); i++) {
            for (int j = (int) ((flat ? 1.5f : 2) * large + 1); j < (int) ((flat ? 1.5f : 2) * large + 1); j++) {
                for (int k = -large - 2; k < large + 2; k++) {
                    boolean bl = BlockPlaceUtil.verifyBlock(world, false, null, end.add(i, k, j));
                    if (bl)
                        continue;
                    return false;
                }
            }
        }
        LineGen line = new LineGen(world, start.up(2), AbstractBlockShapeBase.PlaceMoment.OTHER, end);
        List<Set<BlockPos>> posList = line.getBlockPos();
        for (Set<BlockPos> set : posList) {
            for (BlockPos pos : set) {
                if (BlockPlaceUtil.verifyBlock(world, false, null, pos)
                        && BlockPlaceUtil.verifyBlock(world, false, null, pos.north())
                        && BlockPlaceUtil.verifyBlock(world, false, null, pos.south())
                        && BlockPlaceUtil.verifyBlock(world, false, null, pos.east())
                        && BlockPlaceUtil.verifyBlock(world, false, null, pos.west()))
                    continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<HugeMushroomFeatureConfig> context) {
        BlockPos blockPos = context.getOrigin();
        StructureWorldAccess world = context.getWorld();
        Random random = context.getRandom();
        HugeMushroomFeatureConfig hugeMushroomFeatureConfig = context.getConfig();

        if (world.getBlockState(blockPos).isOf(Blocks.WATER))
            return false;
        if (!world.getBlockState(blockPos.down()).isIn(BlockTags.MUSHROOM_GROW_BLOCK))
            return false;
        boolean flatCap = MathUtil.getRandomBoolean(0.33f);
        int large;
        int height;

        DefaultBlockListComparator coordinates;

        BlockPos end;

        if (MathUtil.getRandomBoolean(0.3f)) {
            height = Random.create().nextBetween(12, 30);
            large = Random.create().nextBetween(5, flatCap ? 8 : 9);

            int maxXOffset = (int) (16 - (flatCap ? 2 : 1.5f) * large + 16 - blockPos.getX() % 16 - 2);
            int maxZOffset = (int) (16 - (flatCap ? 2 : 1.5f) * large + 16 - blockPos.getZ() % 16 - 2);

            end = blockPos.add(random.nextBetween(-maxXOffset, maxXOffset), height, random.nextBetween(-maxZOffset, maxZOffset));


            if (!this.canGenerate(world, blockPos, end, large, flatCap))
                return false;


            coordinates = this.generateHugeTrunk(world, blockPos, end, height, hugeMushroomFeatureConfig);
        } else {
            height = Random.create().nextBetween(6, 18);
            large = Random.create().nextBetween(3, 6);
            int maxXOffset = 16 - large + 16 - blockPos.getX() % 16 - 2;
            int maxZOffset = 16 - large + 16 - blockPos.getZ() % 16 - 2;

            end = blockPos.add(random.nextBetween(-maxXOffset, maxXOffset), height, random.nextBetween(-maxZOffset, maxZOffset));


            if (!this.canGenerate(world, blockPos, end, large, flatCap))
                return false;

            coordinates = this.generateTrunk(world, blockPos, end, height, hugeMushroomFeatureConfig);
        }
        SphereGen[] spheres;
        if (flatCap) {
            spheres = this.generateFlatterCap(world, blockPos, end, hugeMushroomFeatureConfig, height, large, coordinates);
        } else {
            spheres = this.generateCap(world, blockPos, end, hugeMushroomFeatureConfig, height, large, coordinates);
        }

        return this.place(world, blockPos, end, coordinates, spheres[0], spheres[1]);
    }

    protected abstract DefaultBlockListComparator generateHugeTrunk(StructureWorldAccess world, BlockPos pos, BlockPos pos2, int height, HugeMushroomFeatureConfig config);

    protected abstract DefaultBlockListComparator generateTrunk(StructureWorldAccess world, BlockPos pos, BlockPos pos2, int height, HugeMushroomFeatureConfig config);

    protected abstract SphereGen[] generateCap(StructureWorldAccess world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfig var6, int height, int large, DefaultBlockListComparator coordinates);

    protected abstract SphereGen[] generateFlatterCap(StructureWorldAccess world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfig var6, int height, int large, DefaultBlockListComparator coordinates);

    protected abstract boolean place(StructureWorldAccess world, BlockPos pos, BlockPos pos2, DefaultBlockListComparator coordinates, SphereGen sphere, SphereGen secondSphere);
}
