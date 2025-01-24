package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.blockdata.blocklist.basic.DefaultBlockList;
import net.rodofire.easierworldcreator.blockdata.blocklist.ordered.comparator.DefaultOrderedBlockListComparator;
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.mushrooomsmod.world.features.config.PurpleMushroomConfig;

public abstract class CustomHugePurpleMushroomWG extends Feature<PurpleMushroomConfig> {
    /// la liste des fin des blockPos
    protected BlockPos[] end;

    public CustomHugePurpleMushroomWG(Codec<PurpleMushroomConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<PurpleMushroomConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        PurpleMushroomConfig config = context.getConfig();
        Random random = context.getRandom();

        int capNumber = MathUtil.getRandomBoolean(0.3f) ? 2 : 3;
        int[] directions = getDirections(capNumber, random);

        if (capNumber == 3) end = new BlockPos[3];
        else end = new BlockPos[3];


        DefaultOrderedBlockListComparator ordered = new DefaultOrderedBlockListComparator();

        //TODO utiliser placeAll() quand il sera implémenté
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

        this.place(world, ordered);
        return true;
    }

    private void place(StructureWorldAccess world, DefaultOrderedBlockListComparator blockListList) {
        int size = blockListList.posSize();
        for(int i = 0; i<size; i++){
            blockListList.placeLastWithDeletion(world);
        }
    }

    /**
     * méthode pour obtenir les directions, éviter que certaines branches se rencontrent
     *
     * @param caps le nombre de caps du champignon géant
     */
    int[] getDirections(int caps, Random random) {
        int actualDirection = random.nextBetween(0, 7);
        if (caps == 3) {
            int random1 = random.nextBetween(2, 4);
            int secondDirection = actualDirection + random1 % 8;
            int thirdDirection = secondDirection + random.nextBetween(2, 6 - random1) % 8;
            return new int[]{actualDirection, secondDirection, thirdDirection};
        }
        return new int[]{actualDirection, actualDirection + random.nextBetween(2, 6) % 8};
    }

    protected abstract DefaultBlockList getTrunkCoordinates(BlockPos base, int direction, int cap,PurpleMushroomConfig config);

    protected abstract DefaultOrderedBlockListComparator getCapCoordinates(BlockPos pos,PurpleMushroomConfig config);
}
