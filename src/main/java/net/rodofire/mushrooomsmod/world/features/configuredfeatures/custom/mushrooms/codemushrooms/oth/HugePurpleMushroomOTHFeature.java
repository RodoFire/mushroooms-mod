package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.rodofire.easierworldcreator.blockdata.blocklist.basic.DefaultBlockList;
import net.rodofire.easierworldcreator.blockdata.blocklist.basic.comparator.DefaultBlockListComparator;
import net.rodofire.easierworldcreator.blockdata.blocklist.ordered.comparator.DefaultOrderedBlockListComparator;
import net.rodofire.easierworldcreator.blockdata.sorter.BlockSorter;
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.features.config.PurpleMushroomConfig;

import java.util.ArrayList;
import java.util.List;

public class HugePurpleMushroomOTHFeature extends HugePurpleMushroomOTH {
    int xDir;
    int zDir;
    int maxHeight;

    public HugePurpleMushroomOTHFeature(Codec<PurpleMushroomConfig> configCodec) {
        super(configCodec);
    }

    @Override
    protected DefaultBlockList getTrunkCoordinates(BlockPos base, int direction, int trunk, PurpleMushroomConfig config) {
        calculateDirection(direction);
        return calculateTrunkCoordinates(direction, base, trunk, config);
    }

    Integer[] getOffset(int direction) {
        //Generates coordinates in function of the direction
        int x;
        int z;

        if (direction % 4 == 0) {
            z = Random.create().nextBetween(0, 1) * this.zDir;
            x = Random.create().nextBetween(0, 5) / 5 * this.xDir;
            if (x == 0 && z == 0) z = this.zDir;
            return new Integer[]{x, z};
        }
        if (direction % 4 == 2) {
            x = Random.create().nextBetween(0, 1) * this.xDir;
            z = Random.create().nextBetween(0, 5) / 5 * this.xDir;
            if (x == 0 && z == 0) x = this.xDir;
            return new Integer[]{x, z};
        }
        z = Random.create().nextBetween(0, 1) * this.zDir;
        x = Random.create().nextBetween(0, 1) * this.xDir;
        if (x == 0 && z == 0) {
            z = this.zDir;
            x = this.xDir;
        }
        return new Integer[]{x, z};
    }

    void calculateDirection(int direction) {
        if (direction < 2 || direction > 6) {
            this.xDir = 1;
            this.zDir = MathUtil.getRandomOpposite(0.5f);
        } else if (direction > 2 && direction < 6) {
            this.xDir = -1;
            this.zDir = MathUtil.getRandomOpposite(0.5f);
        } else if (direction > 0 && direction < 4) {
            this.zDir = -1;
            this.xDir = MathUtil.getRandomOpposite(0.5f);
        } else {
            this.zDir = 1;
            this.xDir = MathUtil.getRandomOpposite(0.5f);
        }
    }

    List<BlockPos> moveTrunk(int direction, BlockPos pos, int oldHeight, int height) {
        List<BlockPos> posList = new ArrayList<>();
        Integer[] offset = getOffset(direction);
        int segmentHeight;
        if (maxHeight - height <= 0) return posList;
        if (maxHeight - height <= 10) segmentHeight = Random.create().nextBetween(1, maxHeight - height);
        else if (oldHeight < 2) segmentHeight = Random.create().nextBetween(1, 3);
        else if (oldHeight < 4) segmentHeight = Random.create().nextBetween(1, 4);
        else segmentHeight = Random.create().nextBetween(3, 7);

        for (int i = 0; i < segmentHeight; i++) {
            posList.add(pos.add(offset[0], i + 1, offset[1]));
        }
        return posList;

    }

    /**
     * méthode pour calculer les coordonnées du trunk
     */
    private DefaultBlockList calculateTrunkCoordinates(int direction, BlockPos pos, int trunk, PurpleMushroomConfig config) {
        ///on calcule la direction
        calculateDirection(direction);
        int startHeight = Random.create().nextBetween(1, 6);
        this.maxHeight = Random.create().nextBetween(config.minHeight(), config.maxHeight());
        List<BlockPos> posList = new ArrayList<>();

        ///on place les blocks jusqu'en startheight
        for (int i = 0; i < startHeight; i++)
            posList.add(pos.up(i));

        pos = pos.up(startHeight);
        DefaultBlockList blockList = new DefaultBlockList(posList, Blocks.MUSHROOM_STEM.getDefaultState());
        int actualHeight = startHeight;
        int oldHeight = 3;

        ///on ajoute un offset jusqu'a la fin
        do {
            blockList.addBlockPos(moveTrunk(direction, blockList.getLastPos(), oldHeight, actualHeight));
            oldHeight = blockList.getLastPos().getY() - actualHeight - pos.getY();
            actualHeight += oldHeight;
        } while (actualHeight < maxHeight);

        ///on met la pos de fin
        this.end[trunk] = blockList.getLastPos().up();
        return blockList;
    }


    @Override
    protected DefaultOrderedBlockListComparator getCapCoordinates(BlockPos pos, PurpleMushroomConfig config) {
        int height = Random.create().nextBetween(2, 3);
        int radius = getRadius(config);
        DefaultBlockListComparator blockLists = new DefaultBlockListComparator();


        for (int i = -radius; i <= radius; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = -radius; k < radius; k++) {
                    BlockState state = MathUtil.getRandomBoolean(0.6f) ? ModBlocks.PURPLE_MUSHROOM_BLOCK.getDefaultState() : (MathUtil.getRandomBoolean(0.3f) ? ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK.getDefaultState() : ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK.getDefaultState());
                    if (j < 2) {
                        boolean maxim1 = Math.abs(i) == radius - 1;
                        boolean maxkm1 = Math.abs(k) == radius - 1;
                        boolean maxi = Math.abs(i) == radius;
                        boolean maxk = Math.abs(k) == radius;
                        boolean secondmaxi = Math.abs(i) >= radius - 3;
                        boolean secondmaxk = Math.abs(k) >= radius - 3;
                        if ((maxi && secondmaxk) || (maxk && secondmaxi) || (maxim1 && maxkm1)) continue;
                        blockLists.put(state, pos.add(i, j, k));

                    }//Smaller Base
                    else {
                        boolean maxim2 = Math.abs(i) == radius - 2;
                        boolean maxkm2 = Math.abs(k) == radius - 2;
                        boolean maxim1 = Math.abs(i) == radius - 1;
                        boolean maxkm1 = Math.abs(k) == radius - 1;
                        boolean maxi = Math.abs(i) == radius;
                        boolean maxk = Math.abs(k) == radius;
                        boolean secondmaxi = Math.abs(i) >= radius - 3;
                        boolean secondmaxk = Math.abs(k) >= radius - 3;
                        if (maxi || maxk || maxim2 && maxkm2 || maxim1 && secondmaxk || maxkm1 && secondmaxi)
                            continue;
                        blockLists.put(state, pos.add(i, j, k));
                    }
                }
            }
        }
        BlockSorter sorter = new BlockSorter(BlockSorter.BlockSorterType.FROM_POINT_INVERTED);
        sorter.setCenterPoint(pos);
        return blockLists.getOrderedSorted(sorter);
    }

    public int getRadius(PurpleMushroomConfig config) {
        return Random.create().nextBetween(config.minCapSize(), config.maxCapSize());
    }
}
