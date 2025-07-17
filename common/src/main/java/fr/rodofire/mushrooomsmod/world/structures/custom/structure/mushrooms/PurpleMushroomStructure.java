package fr.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms;

import com.mojang.serialization.MapCodec;
import fr.rodofire.ewc.blockdata.blocklist.DividedBlockListManager;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.world.structures.ModStructureTypes;
import fr.rodofire.mushrooomsmod.world.structures.custom.config.mushroom.PurpleMushroomGeneratorConfig;
import fr.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom.PurpleMushroomPiece;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PurpleMushroomStructure extends MushrooomsModStructure {
    public static final MapCodec<PurpleMushroomStructure> CODEC = simpleCodec(PurpleMushroomStructure::new);

    /// la liste des fin des blockPos
    protected BlockPos[] end;

    private RandomSource random;

    int xDir;
    int zDir;
    int maxHeight;

    public PurpleMushroomStructure(StructureSettings config) {
        super(config);
    }

    @Override
    protected void getPieces(StructurePiecesBuilder collector, BlockPos pos, GenerationContext context) {
        random = context.random();

        int capNumber = MathUtil.getRandomBoolean(random, 0.3f) ? 2 : 3;
        int[] directions = getDirections(capNumber);

        if (capNumber == 3) end = new BlockPos[3];
        else end = new BlockPos[2];

        ///on récupère les blockList des troncs et des caps
        DividedBlockListManager blockList = this.getTrunkCoordinates(pos, directions[0], 0);
        blockList.put(this.getTrunkCoordinates(pos, directions[1], 1));
        if (capNumber == 3) {
            blockList.put(this.getTrunkCoordinates(pos, directions[2], 2));
        }

        PurpleMushroomGeneratorConfig mushConfig = new PurpleMushroomGeneratorConfig(blockList, this.end);
        Set<ChunkPos> estimated = getEstimatedCap();
        estimated.addAll(blockList.getChunkPos());
        ResourceLocation featureId = ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "purple_mushroom" + random.nextLong());

        for (ChunkPos chunkPos : estimated) {
            collector.addPiece(new PurpleMushroomPiece(mushConfig, getBoundingBox(chunkPos), featureId, estimated));
        }
    }

    @Override
    public StructureType<?> type() {
        return ModStructureTypes.PURPLE_MUSHROOM;
    }

    Set<ChunkPos> getEstimatedCap() {
        Set<ChunkPos> estimated = new HashSet<>();
        for (int i = 0; i < end.length; i++) {
            for (int j = -7; j <= 7; j++) {
                for (int k = -7; k <= 7; k++) {
                    estimated.add(new ChunkPos(end[i].offset(j, 0, k)));
                }
            }
        }
        return estimated;
    }

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

    protected DividedBlockListManager getTrunkCoordinates(BlockPos base, int direction, int trunk) {
        calculateDirection(direction);
        return calculateTrunkCoordinates(direction, base, trunk);
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
    private DividedBlockListManager calculateTrunkCoordinates(int direction, BlockPos pos, int trunk) {
        DividedBlockListManager dividedBlockListManager = new DividedBlockListManager();
        ///on calcule la direction
        calculateDirection(direction);
        int startHeight = random.nextIntBetweenInclusive(1, 6);
        this.maxHeight = random.nextIntBetweenInclusive(12, 26);
        List<BlockPos> posList = new ArrayList<>();

        ///on place les blocks jusqu'en startheight
        for (int i = 0; i < startHeight; i++)
            dividedBlockListManager.put(Blocks.MUSHROOM_STEM.defaultBlockState(), pos.above(i));

        pos = pos.above(startHeight);
        int actualHeight = startHeight;
        int oldHeight = 3;

        ///on ajoute un offset jusqu'a la fin
        BlockPos lastPos = pos;
        do {
            List<BlockPos> positions = moveTrunk(direction, lastPos, oldHeight, actualHeight);
            dividedBlockListManager.put(Blocks.MUSHROOM_STEM.defaultBlockState(), positions);
            lastPos = positions.getLast();
            oldHeight = lastPos.getY() - actualHeight - pos.getY();
            actualHeight += oldHeight;
        } while (actualHeight < maxHeight);

        ///on met la pos de fin
        this.end[trunk] = lastPos.above();
        return dividedBlockListManager;
    }
}
