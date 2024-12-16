package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.blockdata.blocklist.basic.DefaultBlockList;
import net.rodofire.easierworldcreator.blockdata.blocklist.ordered.comparator.DefaultOrderedBlockListComparator;
import net.rodofire.easierworldcreator.blockdata.sorter.BlockSorter;
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.easierworldcreator.placer.blocks.animator.StructurePlaceAnimator;
import net.rodofire.easierworldcreator.placer.blocks.util.BlockPlaceUtil;
import net.rodofire.mushrooomsmod.world.features.config.PurpleMushroomConfig;

public abstract class HugePurpleMushroomOTH extends Feature<PurpleMushroomConfig> {
    /// la liste des fin des blockPos
    protected BlockPos[] end;

    public HugePurpleMushroomOTH(Codec<PurpleMushroomConfig> configCodec) {
        super(configCodec);
    }

    public boolean canGenerate(StructureWorldAccess world, DefaultOrderedBlockListComparator comparator) {
        for (BlockPos pos : comparator.getBlockPosSet()) {
            if (BlockPlaceUtil.verifyBlock(world, false, null, pos))
                continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<PurpleMushroomConfig> context) {
        return generate(context, 0);
    }

    boolean generate(FeatureContext<PurpleMushroomConfig> context, int i) {
        if(i==3)
            return false;

        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        PurpleMushroomConfig config = context.getConfig();

        int capNumber = MathUtil.getRandomBoolean(0.3f) ? 2 : 3;
        Integer[] directions = getDirections(capNumber);

        if (capNumber == 3) end = new BlockPos[3];
        else end = new BlockPos[3];

        BlockSorter sorter = new BlockSorter(BlockSorter.BlockSorterType.FROM_POINT);
        sorter.setCenterPoint(pos);

        DefaultOrderedBlockListComparator ordered = new DefaultOrderedBlockListComparator();


        ///on récupère les blockList des troncs et des caps
        DefaultBlockList blockList = this.getTrunkCoordinates(pos, directions[0], 0, config);
        ordered.put(blockList.getBlockState(), blockList.getPosList());
        ordered.put(this.getCapCoordinates(end[0], config));

        blockList = this.getTrunkCoordinates(pos, directions[1], 1, config);
        ordered.put(blockList.getBlockState(), blockList.getPosList());
        ordered.put(this.getCapCoordinates(end[1], config));

        if (capNumber == 3) {
            blockList = this.getTrunkCoordinates(pos, directions[2], 2, config);
            ordered.put(blockList.getBlockState(), blockList.getPosList());
            ordered.put(this.getCapCoordinates(end[2], config));
        }

        if (!this.canGenerate(world, ordered))
            return this.generate(context, ++i);

        this.place(world, ordered);
        return true;
    }

    private void place(StructureWorldAccess world, DefaultOrderedBlockListComparator blockListList) {
        StructurePlaceAnimator animator = new StructurePlaceAnimator(world, new BlockSorter(BlockSorter.BlockSorterType.FROM_POINT), StructurePlaceAnimator.AnimatorTime.CONSTANT_BLOCKS_PER_TICK);
        animator.setBlocksPerTick(3);
        animator.place(new BlockSorter(BlockSorter.BlockSorterType.INVERSE).sortBlockList(blockListList));
    }

    /**
     * méthode pour obtenir les directions, éviter que certaines branches se rencontrent
     *
     * @param caps le nombre de caps du champignon géant
     */
    Integer[] getDirections(int caps) {
        int actualDirection = Random.create().nextBetween(0, 7);
        if (caps == 3) {
            int random1 = Random.create().nextBetween(2, 4);
            int secondDirection = actualDirection + random1 % 8;
            int thirdDirection = secondDirection + Random.create().nextBetween(2, 6 - random1) % 8;
            return new Integer[]{actualDirection, secondDirection, thirdDirection};
        }
        return new Integer[]{actualDirection, actualDirection + Random.create().nextBetween(2, 6) % 8};
    }

    protected abstract DefaultBlockList getTrunkCoordinates(BlockPos base, int direction, int cap, PurpleMushroomConfig config);

    protected abstract DefaultOrderedBlockListComparator getCapCoordinates(BlockPos pos, PurpleMushroomConfig config);
}
