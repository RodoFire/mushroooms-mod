package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.blocklist.BlockList;
import fr.rodofire.ewc.blockdata.blocklist.OrderedBlockListManager;
import fr.rodofire.ewc.blockdata.sorter.BlockSorter;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.ewc.shape.block.placer.animator.StructurePlaceAnimator;
import fr.rodofire.ewc.util.BlockPlaceUtil;
import fr.rodofire.ewc.util.LongPosHelper;
import it.unimi.dsi.fastutil.longs.LongShortImmutablePair;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import fr.rodofire.mushrooomsmod.world.features.config.PurpleMushroomConfig;

public abstract class HugePurpleMushroomOTH extends Feature<PurpleMushroomConfig> {
    /// la liste des fin des blockPos
    protected BlockPos[] end;

    RandomSource random;

    public HugePurpleMushroomOTH(Codec<PurpleMushroomConfig> configCodec) {
        super(configCodec);
    }

    public boolean canGenerate(WorldGenLevel world, OrderedBlockListManager manager) {
        for (LongShortImmutablePair pos : manager.getPosList()) {
            if (BlockPlaceUtil.verifyBlock(world, false, null, LongPosHelper.decodeBlockPos(pos.leftLong())))
                continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean place(FeaturePlaceContext<PurpleMushroomConfig> context) {
        return generate(context, 0);
    }

    boolean generate(FeaturePlaceContext<PurpleMushroomConfig> context, int i) {
        if (i == 3)
            return false;

        WorldGenLevel world = context.level();
        BlockPos pos = context.origin();
        PurpleMushroomConfig config = context.config();
        this.random = context.random();

        int capNumber = MathUtil.getRandomBoolean(random, 0.3f) ? 2 : 3;
        int[] directions = getDirections(capNumber);

        if (capNumber == 3) end = new BlockPos[3];
        else end = new BlockPos[3];

        BlockSorter sorter = new BlockSorter(BlockSorter.BlockSorterType.FROM_POINT);
        sorter.setCenterPoint(pos);

        OrderedBlockListManager ordered = new OrderedBlockListManager();


        ///on récupère les blockList des troncs et des caps
        BlockList blockList = this.getTrunkCoordinates(pos, directions[0], 0, config);
        ordered.put(blockList.getState(), blockList.getPosList());
        ordered.put(this.getCapCoordinates(end[0], config));

        blockList = this.getTrunkCoordinates(pos, directions[1], 1, config);
        ordered.put(blockList.getState(), blockList.getPosList());
        ordered.put(this.getCapCoordinates(end[1], config));

        if (capNumber == 3) {
            blockList = this.getTrunkCoordinates(pos, directions[2], 2, config);
            ordered.put(blockList.getState(), blockList.getPosList());
            ordered.put(this.getCapCoordinates(end[2], config));
        }

        if (!this.canGenerate(world, ordered))
            return this.generate(context, ++i);

        this.place(world, ordered);
        return true;
    }

    private void place(WorldGenLevel world, OrderedBlockListManager blockListList) {
        StructurePlaceAnimator animator = new StructurePlaceAnimator(world, new BlockSorter(BlockSorter.BlockSorterType.FROM_POINT), StructurePlaceAnimator.AnimatorTime.CONSTANT_BLOCKS_PER_TICK);
        animator.setBlocksPerTick(3);
        animator.place(new BlockSorter(BlockSorter.BlockSorterType.INVERSE).sortOrderedBlockList(blockListList));
    }

    /**
     * méthode pour obtenir les directions, éviter que certaines branches se rencontrent
     *
     * @param caps le nombre de caps du champignon géant
     */
    int[] getDirections(int caps) {
        int actualDirection = random.nextIntBetweenInclusive(0, 7);
        if (caps == 3) {
            int random1 = random.nextIntBetweenInclusive(2, 4);
            int secondDirection = actualDirection + random1 % 8;
            int thirdDirection = secondDirection + random.nextIntBetweenInclusive(2, 6 - random1) % 8;
            return new int[]{actualDirection, secondDirection, thirdDirection};
        }
        return new int[]{actualDirection, actualDirection + random.nextIntBetweenInclusive(2, 6) % 8};
    }

    protected abstract BlockList getTrunkCoordinates(BlockPos base, int direction, int cap, PurpleMushroomConfig config);

    protected abstract OrderedBlockListManager getCapCoordinates(BlockPos pos, PurpleMushroomConfig config);
}
