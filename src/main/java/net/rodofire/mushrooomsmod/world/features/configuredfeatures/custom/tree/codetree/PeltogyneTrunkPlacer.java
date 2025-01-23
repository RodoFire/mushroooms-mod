package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerComparator;
import net.rodofire.easierworldcreator.maths.FastMaths;
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.easierworldcreator.shape.block.gen.LineGen;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapeBase;
import net.rodofire.easierworldcreator.util.WorldGenUtil;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModTrunkPlacerTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class PeltogyneTrunkPlacer extends TrunkPlacer {
    public static final Codec<PeltogyneTrunkPlacer> CODEC = RecordCodecBuilder.create(objectInstance -> fillTrunkPlacerFields(objectInstance).apply(objectInstance, PeltogyneTrunkPlacer::new));

    public PeltogyneTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.PELTOGYNE_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        generateBasicTrunk(world, replacer, random, startPos, config, height);
        generateBase(world, replacer, random, startPos, config);

        List<FoliagePlacer.TreeNode> list = new ArrayList<FoliagePlacer.TreeNode>();
        for (int i = 0; i < Random.create().nextBetween(3, 4); i++) {
            int heightb = Random.create().nextBetween(3, height);
            list.add(addBranch(world, replacer, random, startPos.add(0, heightb, 0), config, WorldGenUtil.getRandomHorizontalDirection(), heightb, height));
        }
        list.add(new FoliagePlacer.TreeNode(startPos.up(height), 0, false));
        return list;
    }

    private void generateBasicTrunk(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos startPos, TreeFeatureConfig config, int height) {

        for (int y = 0; y < height + Random.create().nextBetween(-2, 2); y++) {
            getAndSetState(world, replacer, random, startPos.add(0, y, 0), config);
        }

    }

    private void generateBase(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos startPos, TreeFeatureConfig config) {
        for (int x = -1; x <= 1; x += 1) {
            for (int z = -1; z <= 1; z += 1) {
                if (z + x == 0 || Math.abs(x) + Math.abs(z) == 2) continue;
                double a = Random.create().nextBetween(0, 4);
                for (int i = 0; i < a; i++) {
                    getAndSetState(world, replacer, random, startPos.add(x, i, z), config);
                }
            }
        }
    }

    private FoliagePlacer.TreeNode addBranch(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos startPos, TreeFeatureConfig config, Direction dir, int height, int maxHeight) {
        int randomX = (int) (((float) maxHeight / height) / 3 * getXSign(dir) * Random.create().nextBetween(2, 5));
        int randomZ = (int) (((float) maxHeight / height) / 3 * getZSign(dir) * Random.create().nextBetween(2, 5));
        int randomY = (int) (FastMaths.getLength(randomX, randomZ) * (double) Random.create().nextBetween(10, 20) / 10);

        BlockPos direction = new BlockPos(randomX, randomY, randomZ);


        LineGen line = new LineGen((StructureWorldAccess) world, startPos, AbstractBlockShapeBase.PlaceMoment.OTHER, startPos.add(direction));
        line.setBlockLayer(new BlockLayerComparator(new BlockLayer(config.trunkProvider.get(random, startPos))));

        line.place();

        return new FoliagePlacer.TreeNode(startPos.add(direction), 0, false);
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
