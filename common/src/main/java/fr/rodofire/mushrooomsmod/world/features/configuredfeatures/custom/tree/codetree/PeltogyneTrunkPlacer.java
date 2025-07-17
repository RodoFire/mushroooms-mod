package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree;

import com.mojang.serialization.MapCodec;
import fr.rodofire.ewc.blockdata.layer.BlockLayer;
import fr.rodofire.ewc.blockdata.layer.BlockLayerManager;
import fr.rodofire.ewc.maths.FastMaths;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.ewc.shape.block.gen.LineGen;
import fr.rodofire.ewc.shape.block.layer.LayerManager;
import fr.rodofire.ewc.shape.block.placer.LayerPlacer;
import fr.rodofire.ewc.util.WorldGenUtil;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModTrunkPlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class PeltogyneTrunkPlacer extends TrunkPlacer {
    public static final PeltogyneTrunkPlacer INSTANCE = new PeltogyneTrunkPlacer(6, 6, 6);
    public static final MapCodec<PeltogyneTrunkPlacer> CODEC = MapCodec.unit(() -> INSTANCE);

    public PeltogyneTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.PELTOGYNE_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, int height, BlockPos startPos, TreeConfiguration config) {
        generateBasicTrunk(world, replacer, random, startPos, config, height);
        generateBase(world, replacer, random, startPos, config);

        List<FoliagePlacer.FoliageAttachment> list = new ArrayList<FoliagePlacer.FoliageAttachment>();
        for (int i = 0; i < random.nextIntBetweenInclusive(3, 4); i++) {
            int heightb = random.nextIntBetweenInclusive(3, height);
            list.add(addBranch(world, replacer, random, startPos.offset(0, heightb, 0), config, WorldGenUtil.getRandomHorizontalDirection(random), heightb, height));
        }
        list.add(new FoliagePlacer.FoliageAttachment(startPos.above(height), 0, false));
        return list;
    }

    private void generateBasicTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, BlockPos startPos, TreeConfiguration config, int height) {

        for (int y = 0; y < height + random.nextIntBetweenInclusive(-2, 2); y++) {
            placeLog(world, replacer, random, startPos.offset(0, y, 0), config);
        }

    }

    private void generateBase(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, BlockPos startPos, TreeConfiguration config) {
        for (int x = -1; x <= 1; x += 1) {
            for (int z = -1; z <= 1; z += 1) {
                if (z + x == 0 || Math.abs(x) + Math.abs(z) == 2) continue;
                double a = random.nextIntBetweenInclusive(0, 4);
                for (int i = 0; i < a; i++) {
                    placeLog(world, replacer, random, startPos.offset(x, i, z), config);
                }
            }
        }
    }

    private FoliagePlacer.FoliageAttachment addBranch(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, BlockPos startPos, TreeConfiguration config, Direction dir, int height, int maxHeight) {
        int randomX = (int) (((float) maxHeight / height) / 3 * getXSign(dir) * random.nextIntBetweenInclusive(2, 5));
        int randomZ = (int) (((float) maxHeight / height) / 3 * getZSign(dir) * random.nextIntBetweenInclusive(2, 5));
        int randomY = (int) (FastMaths.getLength(randomX, randomZ) * (double) random.nextIntBetweenInclusive(10, 20) / 10);

        BlockPos direction = new BlockPos(randomX, randomY, randomZ);


        LineGen line = new LineGen(startPos, startPos.offset(direction));

        LayerManager layerManager = new LayerManager(
                LayerManager.Type.SURFACE,
                new BlockLayerManager(new BlockLayer(LayerPlacer.ofRandom(random), config.trunkProvider.getState(random, startPos)))
        );
        layerManager.place((WorldGenLevel) world, line.getShapeCoordinates());

        return new FoliagePlacer.FoliageAttachment(startPos.offset(direction), 0, false);
    }


    private int getXSign(Direction dir) {
        return switch (dir) {
            case NORTH -> 1;
            case SOUTH -> -1;
            default -> MathUtil.getRandomOpposite();
        };
    }

    private int getZSign(Direction dir) {
        return switch (dir) {
            case EAST -> 1;
            case WEST -> -1;
            default -> MathUtil.getRandomOpposite();
        };
    }
}
