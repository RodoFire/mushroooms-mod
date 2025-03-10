package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
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
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerManager;
import net.rodofire.easierworldcreator.shape.block.gen.SpiralGen;
import net.rodofire.easierworldcreator.shape.block.layer.LayerManager;
import net.rodofire.easierworldcreator.shape.block.placer.LayerPlacer;
import net.rodofire.easierworldcreator.shape.block.rotations.Rotator;
import net.rodofire.easierworldcreator.util.LongPosHelper;
import net.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.List;
import java.util.Map;

public class SpiralMushroom extends Feature<DefaultFeatureConfig> {
    public SpiralMushroom(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    public boolean canPlace(StructureWorldAccess world, Map<ChunkPos, LongOpenHashSet> posList) {
        for (LongOpenHashSet set : posList.values()) {
            for (long blockPos : set) {
                BlockState blockState = world.getBlockState(LongPosHelper.decodeBlockPos(blockPos));
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
        Random random = context.getRandom();

        if (!world.getBlockState(pos.down()).isOpaqueFullCube()) return false;

        BlockState block = ModBlocks.BLUE_MUSHROOM_BLOCK.getDefaultState();
        BlockState block2 = ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK.getDefaultState();
        BlockState block3 = ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK.getDefaultState();
        BlockState block4 = Blocks.MUSHROOM_STEM.getDefaultState();

        int large = Random.create().nextBetween(5, 10);

        SpiralGen spiral = new SpiralGen(pos, large, Random.create().nextBetween(25, 50));
        spiral.setSpiralType(SpiralGen.SpiralType.LARGE_OUTLINE);

        BlockLayer layer = new BlockLayer(new LayerPlacer(LayerPlacer.PlacingType.RANDOM), List.of(block, block2, block3, block4), List.of((short) 6, (short) 4, (short) 2, (short) 1));


        int outline = context.getRandom().nextBetween(1,2);
        spiral.setOutlineRadiusX(outline);
        spiral.setOutlineRadiusX(outline);

        spiral.setRadiusX(new Pair<>(large, 1));
        spiral.setRadiusZ(new Pair<>(large, 1));

        Rotator rotator = new Rotator(pos, random.nextBetween(0, 360), 0,0);

        spiral.setRotator(rotator);

        Map<ChunkPos, LongOpenHashSet> posList = spiral.getShapeCoordinates();
        if (!canPlace(world, posList)) return false;

        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE,
                new BlockLayerManager(layer)
        );
        layerManager.place(world, spiral.getShapeCoordinates());

        return true;
    }
}
