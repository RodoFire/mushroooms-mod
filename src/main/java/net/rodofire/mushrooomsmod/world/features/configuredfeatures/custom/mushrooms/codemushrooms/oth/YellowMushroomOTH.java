package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.blockdata.blocklist.BlockListManager;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.easierworldcreator.shape.block.gen.LineGen;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.placer.LayerPlacer;
import net.rodofire.easierworldcreator.util.BlockPlaceUtil;
import net.rodofire.easierworldcreator.util.LongPosHelper;
import net.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.List;
import java.util.Map;

public abstract class YellowMushroomOTH extends Feature<HugeMushroomFeatureConfig> {
    BlockLayer capLayer = new BlockLayer(
            new LayerPlacer(LayerPlacer.PlacingType.RANDOM),
            List.of(ModBlocks.YELLOW_MUSHROOM_BLOCK.getDefaultState(), ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK.getDefaultState()),
            List.of((short) 2, (short) 1)
    );

    BlockLayer trunkLayer = new BlockLayer(
            new LayerPlacer(LayerPlacer.PlacingType.RANDOM),
            Blocks.MUSHROOM_STEM.getDefaultState()
    );

    public YellowMushroomOTH(Codec<HugeMushroomFeatureConfig> configCodec) {
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
        LineGen line = new LineGen(start.up(2), end);
        Map<ChunkPos, LongOpenHashSet> posList = line.getShapeCoordinates();
        for (LongOpenHashSet set : posList.values()) {
            for (long pos : set) {
                BlockPos pos1 = LongPosHelper.decodeBlockPos(pos);
                if (BlockPlaceUtil.verifyBlock(world, false, null, pos1)
                        && BlockPlaceUtil.verifyBlock(world, false, null, pos1.north())
                        && BlockPlaceUtil.verifyBlock(world, false, null, pos1.south())
                        && BlockPlaceUtil.verifyBlock(world, false, null, pos1.east())
                        && BlockPlaceUtil.verifyBlock(world, false, null, pos1.west()))
                    continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<HugeMushroomFeatureConfig> context) {
        BlockPos origin = context.getOrigin();
        StructureWorldAccess world = context.getWorld();
        Random random = context.getRandom();
        HugeMushroomFeatureConfig hugeMushroomFeatureConfig = context.getConfig();

        if (world.getBlockState(origin).isOf(Blocks.WATER))
            return false;
        if (!world.getBlockState(origin.down()).isIn(BlockTags.MUSHROOM_GROW_BLOCK))
            return false;

        boolean flatCap = MathUtil.getRandomBoolean(0.33f);
        int large;
        int height;

        BlockListManager coordinates;

        BlockPos end;

        if (world.getBlockState(origin.east()).isOf(ModBlocks.YELLOW_MUSHROOM) || world.getBlockState(origin.north()).isOf(ModBlocks.YELLOW_MUSHROOM) || world.getBlockState(origin.south()).isOf(ModBlocks.YELLOW_MUSHROOM) || world.getBlockState(origin.west()).isOf(ModBlocks.YELLOW_MUSHROOM)) {
            height = random.nextBetween(10, 20);
            large = random.nextBetween(5, 9);

            int maxXOffset = 16 - large + 16 - origin.getX() % 16;
            int maxZOffset = 16 - large + 16 - origin.getZ() % 16;

            end = origin.add(height * random.nextBetween(-maxXOffset, maxXOffset) / 20, height, height *  random.nextBetween(-maxZOffset, maxZOffset) / 20);


            if (!this.canGenerate(world, origin, end, large, flatCap))
                return false;


            coordinates = this.generateHugeTrunk(world, origin, end, height, hugeMushroomFeatureConfig, random);
        } else {
            height = random.nextBetween(6, 12);
            large = random.nextBetween(3, 7);
            end = origin.add(random.nextBetween(-10, 10), height, random.nextBetween(-10, 10));


            if (!this.canGenerate(world, origin, end, large, flatCap))
                return false;

            coordinates = this.generateTrunk(world, origin, end, height, hugeMushroomFeatureConfig);
        }
        SphereGen[] spheres;
        if (flatCap) {
            spheres = this.generateFlatterCap(world, origin, end, hugeMushroomFeatureConfig, height, large, coordinates, random);
        } else {
            spheres = this.generateCap(world, origin, end, hugeMushroomFeatureConfig, height, large, coordinates, random);
        }

        return this.place(world, origin, end, coordinates, spheres[0], spheres[1]);
    }

    protected abstract BlockListManager generateHugeTrunk(StructureWorldAccess world, BlockPos blockPos, BlockPos pos2, int height, HugeMushroomFeatureConfig config, Random random);

    protected abstract BlockListManager generateTrunk(StructureWorldAccess world, BlockPos pos, BlockPos pos2, int height, HugeMushroomFeatureConfig config);

    protected abstract SphereGen[] generateCap(StructureWorldAccess world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfig var6, int height, int large, BlockListManager coordinates,Random random);

    protected abstract SphereGen[] generateFlatterCap(StructureWorldAccess world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfig var6, int height, int large, BlockListManager coordinates,Random random);

    protected abstract boolean place(StructureWorldAccess world, BlockPos pos, BlockPos pos2, BlockListManager coordinates, SphereGen sphere, SphereGen secondSphere);
}
