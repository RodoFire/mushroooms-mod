package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree;

import com.mojang.serialization.MapCodec;
import fr.rodofire.ewc.blockdata.layer.BlockLayerManager;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.shape.block.layer.LayerManager;
import fr.rodofire.ewc.shape.block.placer.LayerPlacer;
import fr.rodofire.ewc.shape.block.placer.ShapePlacer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.material.Fluids;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModFoliagePlacerTypes;

public class ColorfulTreeFoliagePlacer extends FoliagePlacer {
    public static final ColorfulTreeFoliagePlacer INSTANCE = new ColorfulTreeFoliagePlacer(ConstantInt.of(4), ConstantInt.of(1), 3);
    public static final MapCodec<ColorfulTreeFoliagePlacer> CODEC = MapCodec.unit(() -> INSTANCE);

    final int height;

    public ColorfulTreeFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    protected static boolean placeFoliageBlock(LevelSimulatedReader world, FoliageSetter placer, BlockPos pos, BlockState state) {
        if (!TreeFeature.validTreePos(world, pos)) {
            return false;
        } else {
            BlockState blockState = state;
            if (blockState.hasProperty(BlockStateProperties.WATERLOGGED)) {
                blockState = blockState.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(world.isFluidAtPosition(pos, fluidState -> fluidState.isSourceOfType(Fluids.WATER))));
            }

            placer.set(pos, blockState);
            return true;
        }
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacerTypes.COLORFUL_TREE_FOLIAGE_PLACER;
    }

    @Override
    protected void createFoliage(LevelSimulatedReader world, FoliageSetter placer, RandomSource random, TreeConfiguration config, int trunkHeight, FoliageAttachment treeNode, int foliageHeight, int radius, int offset) {
        int radiusB = random.nextIntBetweenInclusive(4, 5);
        SphereGen sphere = new SphereGen(treeNode.pos(), radiusB);
        sphere.setHalfSphere(SphereGen.SphereType.HALF);
        BlockState state = getLeaveBlock(random).setValue(BlockStateProperties.PERSISTENT, true);

        ShapePlacer placer1 = new ShapePlacer((WorldGenLevel) world, ShapePlacer.PlaceMoment.OTHER, treeNode.pos());
        placer1.place(sphere.getShapeCoordinates(), new LayerManager(
                LayerManager.Type.SURFACE,
                new BlockLayerManager(LayerPlacer.of2DNoise(), state, (short) 1)
        ));

        for (int x = -radiusB; x <= radiusB; x++) {
            int xx = x * x;
            for (int z = -radiusB; z <= radiusB; z++) {
                if (xx + z * z <= radiusB * radiusB) {
                    if (MathUtil.getRandomBoolean(0.8f)) {
                        for (int y = 0; y >= -random.nextIntBetweenInclusive(0, 8); y--) {
                            placeFoliageBlock(world, placer, treeNode.pos().offset(x, y, z), state);
                        }
                    }
                }
            }
        }
    }

    @Override
    public int foliageHeight(RandomSource random, int trunkHeight, TreeConfiguration config) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }

    private BlockState getLeaveBlock(RandomSource random) {
        int randomInt = random.nextIntBetweenInclusive(0, 6);
        return switch (randomInt) {
            case 0 -> ModBlocks.BLUE_COLORFUL_LEAVES.get().defaultBlockState();
            case 1 -> ModBlocks.RED_COLORFUL_LEAVES.get().defaultBlockState();
            case 2 -> ModBlocks.YELLOW_COLORFUL_LEAVES.get().defaultBlockState();
            case 3 -> ModBlocks.GREEN_COLORFUL_LEAVES.get().defaultBlockState();
            case 4 -> ModBlocks.ORANGE_COLORFUL_LEAVES.get().defaultBlockState();
            case 5 -> ModBlocks.PURPLE_COLORFUL_LEAVES.get().defaultBlockState();
            default -> ModBlocks.PINK_COLORFUL_LEAVES.get().defaultBlockState();
        };
    }
}
