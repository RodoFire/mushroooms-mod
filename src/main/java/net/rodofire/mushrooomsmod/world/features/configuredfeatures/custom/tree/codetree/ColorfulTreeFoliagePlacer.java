package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.rodofire.easierworldcreator.shapegen.SphereGen;
import net.rodofire.easierworldcreator.shapeutil.BlockLayer;
import net.rodofire.easierworldcreator.shapeutil.Shape;
import net.rodofire.easierworldcreator.util.MathUtil;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModFoliagePlacerTypes;

import java.io.IOException;

public class ColorfulTreeFoliagePlacer extends FoliagePlacer {
    public static final Codec<ColorfulTreeFoliagePlacer> CODEC = RecordCodecBuilder.create(objectInstance ->
            fillFoliagePlacerFields(objectInstance).and(Codec.intRange(0, 12).fieldOf("height")
                    .forGetter(instance -> instance.height)).apply(objectInstance, ColorfulTreeFoliagePlacer::new));

    final int height;

    public ColorfulTreeFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    protected static boolean placeFoliageBlock(TestableWorld world, FoliagePlacer.BlockPlacer placer, BlockPos pos, BlockState state) {
        if (!TreeFeature.canReplace(world, pos)) {
            return false;
        } else {
            BlockState blockState = state;
            if (blockState.contains(Properties.WATERLOGGED)) {
                blockState = blockState.with(Properties.WATERLOGGED, Boolean.valueOf(world.testFluidState(pos, fluidState -> fluidState.isEqualAndStill(Fluids.WATER))));
            }

            placer.placeBlock(pos, blockState);
            return true;
        }
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.COLORFUL_TREE_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        int radiusB = Random.create().nextBetween(4, 5);
        SphereGen sphere = new SphereGen((StructureWorldAccess) world, treeNode.getCenter(), Shape.PlaceMoment.OTHER, radiusB);
        sphere.setHalfSphere(SphereGen.SphereType.HALF);
        BlockState state = getLeaveBlock().with(Properties.PERSISTENT, true);
        sphere.setBlockLayers(new BlockLayer(state));
        try {
            sphere.place();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int x = -radiusB; x <= radiusB; x++) {
            int xx = x * x;
            for (int z = -radiusB; z <= radiusB; z++) {
                if (xx + z * z <= radiusB * radiusB) {
                    if (MathUtil.getRandomBoolean(0.8f)) {
                        for (int y = 0; y >= -Random.create().nextBetween(0, 8); y--) {
                            placeFoliageBlock(world, placer, treeNode.getCenter().add(x, y, z), state);
                        }
                    }
                }
            }
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }

    private BlockState getLeaveBlock() {
        int random = Random.create().nextBetween(0, 6);
        return switch (random) {
            case 0 -> ModBlocks.BLUE_COLORFUL_LEAVES.getDefaultState();
            case 1 -> ModBlocks.RED_COLORFUL_LEAVES.getDefaultState();
            case 2 -> ModBlocks.YELLOW_COLORFUL_LEAVES.getDefaultState();
            case 3 -> ModBlocks.GREEN_COLORFUL_LEAVES.getDefaultState();
            case 4 -> ModBlocks.ORANGE_COLORFUL_LEAVES.getDefaultState();
            case 5 -> ModBlocks.PURPLE_COLORFUL_LEAVES.getDefaultState();
            default -> ModBlocks.PINK_COLORFUL_LEAVES.getDefaultState();
        };
    }
}
