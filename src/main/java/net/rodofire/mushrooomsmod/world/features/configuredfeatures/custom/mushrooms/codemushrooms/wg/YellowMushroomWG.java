package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.wg;

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
import net.rodofire.easierworldcreator.blockdata.blocklist.DividedBlockListManager;
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

public abstract class YellowMushroomWG extends Feature<HugeMushroomFeatureConfig> {
    BlockLayer capLayer = new BlockLayer(
            new LayerPlacer(LayerPlacer.PlacingType.RANDOM),
            List.of(ModBlocks.YELLOW_MUSHROOM_BLOCK.getDefaultState(), ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK.getDefaultState()),
            List.of((short) 2, (short) 1)
    );

    BlockLayer trunkLayer = new BlockLayer(
            new LayerPlacer(LayerPlacer.PlacingType.RANDOM),
            Blocks.MUSHROOM_STEM.getDefaultState()
    );
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
        LineGen line = new LineGen( start.up(2),  end);
        Map<ChunkPos, LongOpenHashSet> posList = line.getShapeCoordinates();
        for (LongOpenHashSet set : posList.values()) {
            for (long encodedPos : set) {
                BlockPos pos = LongPosHelper.decodeBlockPos(encodedPos);
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

        DividedBlockListManager coordinates;

        BlockPos end;

        if (MathUtil.getRandomBoolean(0.3f)) {
            height = Random.create().nextBetween(12, 30);
            large = Random.create().nextBetween(5, flatCap ? 8 : 9);

            int maxXOffset = (int) (16 - (flatCap ? 2 : 1.5f) * large + 16 - blockPos.getX() % 16 - 2);
            int maxZOffset = (int) (16 - (flatCap ? 2 : 1.5f) * large + 16 - blockPos.getZ() % 16 - 2);

            end = blockPos.add(random.nextBetween(-maxXOffset, maxXOffset), height, random.nextBetween(-maxZOffset, maxZOffset));


            if (!this.canGenerate(world, blockPos, end, large, flatCap))
                return false;


            coordinates = this.generateHugeTrunk(world, blockPos, end, height, hugeMushroomFeatureConfig, random);
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
            spheres = this.generateFlatterCap(world, blockPos, end, hugeMushroomFeatureConfig, height, large, coordinates, random);
        } else {
            spheres = this.generateCap(world, blockPos, end, hugeMushroomFeatureConfig, height, large, coordinates, random);
        }

        return this.place(world, blockPos, end, coordinates, spheres[0], spheres[1]);
    }

    protected abstract DividedBlockListManager generateHugeTrunk(StructureWorldAccess world, BlockPos pos, BlockPos pos2, int height, HugeMushroomFeatureConfig config, Random random);

    protected abstract DividedBlockListManager generateTrunk(StructureWorldAccess world, BlockPos pos, BlockPos pos2, int height, HugeMushroomFeatureConfig config);

    protected abstract SphereGen[] generateCap(StructureWorldAccess world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfig var6, int height, int large, DividedBlockListManager coordinates, Random random);

    protected abstract SphereGen[] generateFlatterCap(StructureWorldAccess world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfig var6, int height, int large, DividedBlockListManager coordinates, Random random);

    protected abstract boolean place(StructureWorldAccess world, BlockPos pos, BlockPos pos2, DividedBlockListManager coordinates, SphereGen sphere, SphereGen secondSphere);
}
