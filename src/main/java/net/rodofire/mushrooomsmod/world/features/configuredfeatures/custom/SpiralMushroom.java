package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.shapegen.SpiralGen;
import net.rodofire.easierworldcreator.shapeutil.BlockLayer;
import net.rodofire.easierworldcreator.shapeutil.Shape;
import net.rodofire.mushrooomsmod.block.ModBlocks;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class SpiralMushroom extends Feature<DefaultFeatureConfig> {
    public SpiralMushroom(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    public boolean canPlace(StructureWorldAccess world, List<Set<BlockPos>> posList) {
        for (Set<BlockPos> set : posList) {
            for (BlockPos blockPos : set) {
                BlockState blockState = world.getBlockState(blockPos);
                if (blockState.isAir()) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();

        if (!world.getBlockState(pos.down()).isOpaqueFullCube(world, pos.down())) return false;

        BlockState block = ModBlocks.BLUE_MUSHROOM_BLOCK.getDefaultState();
        BlockState block2 = ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK.getDefaultState();
        BlockState block3 = ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK.getDefaultState();
        BlockState block4 = Blocks.MUSHROOM_STEM.getDefaultState();

        int large = Random.create().nextBetween(5, 10);

        SpiralGen spiral = new SpiralGen(world, pos, Shape.PlaceMoment.OTHER, large, Random.create().nextBetween(25, 50));
        spiral.setSpiralType(SpiralGen.SpiralType.LARGE_OUTLINE);

        spiral.setBlockLayers(new BlockLayer(List.of(block, block, block, block, block, block, block2, block2, block2, block2, block3, block3, block4)));


        spiral.setOutlineRadiusX(2);
        spiral.setOutlineRadiusX(2);

        spiral.setRadiusX(new Pair<>(large, 1));
        spiral.setRadiusX(new Pair<>(large, 1));

        spiral.setOffset(Random.create().nextBetween(0, 360));
        spiral.setYRotation(Random.create().nextBetween(-20, 20));

        List<Set<BlockPos>> posList = spiral.getBlockPos();
        if (!canPlace(world, posList)) return false;

        try {
            spiral.place(posList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
