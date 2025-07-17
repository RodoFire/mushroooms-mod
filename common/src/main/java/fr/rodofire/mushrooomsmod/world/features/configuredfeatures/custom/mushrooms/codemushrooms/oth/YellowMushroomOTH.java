package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.blocklist.BlockListManager;
import fr.rodofire.ewc.blockdata.layer.BlockLayer;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.ewc.shape.block.gen.LineGen;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.shape.block.placer.LayerPlacer;
import fr.rodofire.ewc.util.BlockPlaceUtil;
import fr.rodofire.ewc.util.LongPosHelper;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import fr.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.List;
import java.util.Map;

public abstract class YellowMushroomOTH extends Feature<HugeMushroomFeatureConfiguration> {
    BlockLayer capLayer;

    BlockLayer trunkLayer;

    public YellowMushroomOTH(Codec<HugeMushroomFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    protected boolean canGenerate(WorldGenLevel world, BlockPos start, BlockPos end, int large, boolean flat) {
        for (int i = -(int) ((flat ? 1.5f : 2) * large + 1); i < (int) ((flat ? 1.5f : 2) * large + 1); i++) {
            for (int j = (int) ((flat ? 1.5f : 2) * large + 1); j < (int) ((flat ? 1.5f : 2) * large + 1); j++) {
                for (int k = -large - 2; k < large + 2; k++) {
                    boolean bl = BlockPlaceUtil.verifyBlock(world, false, null, end.offset(i, k, j));
                    if (bl)
                        continue;
                    return false;
                }
            }
        }
        LineGen line = new LineGen(start.above(2), end);
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
    public boolean place(FeaturePlaceContext<HugeMushroomFeatureConfiguration> context) {
        BlockPos origin = context.origin();
        WorldGenLevel world = context.level();
        RandomSource random = context.random();
        HugeMushroomFeatureConfiguration hugeMushroomFeatureConfig = context.config();

        capLayer = new BlockLayer(
                LayerPlacer.ofRandom(random),
                List.of(ModBlocks.YELLOW_MUSHROOM_BLOCK.get().defaultBlockState(), ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK.get().defaultBlockState()),
                List.of((short) 2, (short) 1)
        );

        trunkLayer = new BlockLayer(
                LayerPlacer.ofRandom(random),
                Blocks.MUSHROOM_STEM.defaultBlockState()
        );

        if (world.getBlockState(origin).is(Blocks.WATER))
            return false;
        if (!world.getBlockState(origin.below()).is(BlockTags.MUSHROOM_GROW_BLOCK))
            return false;

        boolean flatCap = MathUtil.getRandomBoolean(random, 0.33f);
        int large;
        int height;

        BlockListManager coordinates;

        BlockPos end;

        if (world.getBlockState(origin.east()).is(ModBlocks.YELLOW_MUSHROOM.get()) || world.getBlockState(origin.north()).is(ModBlocks.YELLOW_MUSHROOM.get()) || world.getBlockState(origin.south()).is(ModBlocks.YELLOW_MUSHROOM.get()) || world.getBlockState(origin.west()).is(ModBlocks.YELLOW_MUSHROOM.get())) {
            height = random.nextIntBetweenInclusive(10, 20);
            large = random.nextIntBetweenInclusive(5, 9);

            int maxXOffset = 16 - large + 16 - origin.getX() % 16;
            int maxZOffset = 16 - large + 16 - origin.getZ() % 16;

            end = origin.offset(height * random.nextIntBetweenInclusive(-maxXOffset, maxXOffset) / 20, height, height * random.nextIntBetweenInclusive(-maxZOffset, maxZOffset) / 20);


            if (!this.canGenerate(world, origin, end, large, flatCap))
                return false;


            coordinates = this.generateHugeTrunk(world, origin, end, height, hugeMushroomFeatureConfig, random);
        } else {
            height = random.nextIntBetweenInclusive(6, 12);
            large = random.nextIntBetweenInclusive(3, 7);
            end = origin.offset(random.nextIntBetweenInclusive(-10, 10), height, random.nextIntBetweenInclusive(-10, 10));


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

    protected abstract BlockListManager generateHugeTrunk(WorldGenLevel world, BlockPos blockPos, BlockPos pos2, int height, HugeMushroomFeatureConfiguration config, RandomSource random);

    protected abstract BlockListManager generateTrunk(WorldGenLevel world, BlockPos pos, BlockPos pos2, int height, HugeMushroomFeatureConfiguration config);

    protected abstract SphereGen[] generateCap(WorldGenLevel world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfiguration var6, int height, int large, BlockListManager coordinates, RandomSource random);

    protected abstract SphereGen[] generateFlatterCap(WorldGenLevel world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfiguration var6, int height, int large, BlockListManager coordinates, RandomSource random);

    protected abstract boolean place(WorldGenLevel world, BlockPos pos, BlockPos pos2, BlockListManager coordinates, SphereGen sphere, SphereGen secondSphere);
}
