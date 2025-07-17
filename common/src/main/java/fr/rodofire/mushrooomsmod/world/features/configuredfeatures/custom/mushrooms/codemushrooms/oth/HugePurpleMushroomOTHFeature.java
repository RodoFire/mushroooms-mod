package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms.oth;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.blocklist.BlockList;
import fr.rodofire.ewc.blockdata.blocklist.BlockListManager;
import fr.rodofire.ewc.blockdata.blocklist.OrderedBlockListManager;
import fr.rodofire.ewc.blockdata.sorter.BlockSorter;
import fr.rodofire.ewc.maths.MathUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.world.features.config.PurpleMushroomConfig;

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
    protected BlockList getTrunkCoordinates(BlockPos base, int direction, int trunk, PurpleMushroomConfig config) {
        calculateDirection(direction);
        return calculateTrunkCoordinates(direction, base, trunk, config);
    }

    Integer[] getOffset(int direction) {
        //Generates coordinates in function of the direction
        int x;
        int z;

        if (direction % 4 == 0) {
            z = random.nextIntBetweenInclusive(0, 1) * this.zDir;
            x = random.nextIntBetweenInclusive(0, 5) / 5 * this.xDir;
            if (x == 0 && z == 0) z = this.zDir;
            return new Integer[]{x, z};
        }
        if (direction % 4 == 2) {
            x = random.nextIntBetweenInclusive(0, 1) * this.xDir;
            z = random.nextIntBetweenInclusive(0, 5) / 5 * this.xDir;
            if (x == 0 && z == 0) x = this.xDir;
            return new Integer[]{x, z};
        }
        z = random.nextIntBetweenInclusive(0, 1) * this.zDir;
        x = random.nextIntBetweenInclusive(0, 1) * this.xDir;
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
        if (maxHeight - height <= 10) segmentHeight = random.nextIntBetweenInclusive(1, maxHeight - height);
        else if (oldHeight < 2) segmentHeight = random.nextIntBetweenInclusive(1, 3);
        else if (oldHeight < 4) segmentHeight = random.nextIntBetweenInclusive(1, 4);
        else segmentHeight = random.nextIntBetweenInclusive(3, 7);

        for (int i = 0; i < segmentHeight; i++) {
            posList.add(pos.offset(offset[0], i + 1, offset[1]));
        }
        return posList;

    }

    /**
     * méthode pour calculer les coordonnées du trunk
     */
    private BlockList calculateTrunkCoordinates(int direction, BlockPos pos, int trunk, PurpleMushroomConfig config) {
        ///on calcule la direction
        calculateDirection(direction);
        int startHeight = random.nextIntBetweenInclusive(1, 6);
        this.maxHeight = random.nextIntBetweenInclusive(config.minHeight(), config.maxHeight());
        List<BlockPos> posList = new ArrayList<>();

        ///on place les blocks jusqu'en startheight
        for (int i = 0; i < startHeight; i++)
            posList.add(pos.above(i));

        pos = pos.above(startHeight);
        BlockList blockList = new BlockList(Blocks.MUSHROOM_STEM.defaultBlockState(), posList);
        int actualHeight = startHeight;
        int oldHeight = 3;

        ///on ajoute un offset jusqu'a la fin
        do {
            blockList.addAllPos(moveTrunk(direction, blockList.getLastPos(), oldHeight, actualHeight));
            oldHeight = blockList.getLastPos().getY() - actualHeight - pos.getY();
            actualHeight += oldHeight;
        } while (actualHeight < maxHeight);

        ///on met la pos de fin
        this.end[trunk] = blockList.getLastPos().above();
        return blockList;
    }


    @Override
    protected OrderedBlockListManager getCapCoordinates(BlockPos pos, PurpleMushroomConfig config) {
        int height = random.nextIntBetweenInclusive(2, 3);
        int radius = getRadius(config);
        BlockListManager blockLists = new BlockListManager();


        for (int i = -radius; i <= radius; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = -radius; k < radius; k++) {
                    BlockState state = MathUtil.getRandomBoolean(random,0.6f) ? ModBlocks.PURPLE_MUSHROOM_BLOCK.get().defaultBlockState() : (MathUtil.getRandomBoolean(random,0.3f) ? ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK.get().defaultBlockState() : ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK.get().defaultBlockState());
                    if (j < 2) {
                        boolean maxim1 = Math.abs(i) == radius - 1;
                        boolean maxkm1 = Math.abs(k) == radius - 1;
                        boolean maxi = Math.abs(i) == radius;
                        boolean maxk = Math.abs(k) == radius;
                        boolean secondmaxi = Math.abs(i) >= radius - 3;
                        boolean secondmaxk = Math.abs(k) >= radius - 3;
                        if ((maxi && secondmaxk) || (maxk && secondmaxi) || (maxim1 && maxkm1)) continue;
                        blockLists.put(state, pos.offset(i, j, k));

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
                        blockLists.put(state, pos.offset(i, j, k));
                    }
                }
            }
        }
        BlockSorter sorter = new BlockSorter(BlockSorter.BlockSorterType.FROM_POINT_INVERTED);
        sorter.setCenterPoint(pos);
        return blockLists.getOrdered(sorter);
    }

    public int getRadius(PurpleMushroomConfig config) {
        return random.nextIntBetweenInclusive(config.minCapSize(), config.maxCapSize());
    }
}
