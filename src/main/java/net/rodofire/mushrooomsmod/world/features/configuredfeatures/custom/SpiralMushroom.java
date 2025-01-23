package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerComparator;
import net.rodofire.easierworldcreator.shape.block.gen.SpiralGen;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapeBase;
import net.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.List;
import java.util.Map;
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

        SpiralGen spiral = new SpiralGen(world, pos, AbstractBlockShapeBase.PlaceMoment.OTHER, large, Random.create().nextBetween(25, 50));
        spiral.setSpiralType(SpiralGen.SpiralType.LARGE_OUTLINE);

        BlockLayer layer = new BlockLayer(List.of(block, block2,  block3, block4), List.of((short)6,(short) 4,(short) 2,(short) 1));
        spiral.setBlockLayer(new BlockLayerComparator(layer));


        spiral.setOutlineRadiusX(2);
        spiral.setOutlineRadiusX(2);

        spiral.setRadiusX(new Pair<>(large, 1));
        spiral.setRadiusZ(new Pair<>(large, 1));

        spiral.setSpiralOffset(Random.create().nextBetween(0, 360));
        spiral.setYRotation(Random.create().nextBetween(-20, 20));

        Map<ChunkPos, Set<BlockPos>> posList = spiral.getBlockPos();
        if (!canPlace(world, posList.values().stream().toList())) return false;

        spiral.place(posList);

        return true;
    }
}
