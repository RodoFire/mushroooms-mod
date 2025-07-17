package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.layer.BlockLayer;
import fr.rodofire.ewc.blockdata.layer.BlockLayerManager;
import fr.rodofire.ewc.shape.block.gen.SpiralGen;
import fr.rodofire.ewc.shape.block.layer.LayerManager;
import fr.rodofire.ewc.shape.block.placer.LayerPlacer;
import fr.rodofire.ewc.shape.block.rotations.Rotator;
import fr.rodofire.ewc.util.LongPosHelper;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import fr.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.List;
import java.util.Map;

public class SpiralMushroom extends Feature<NoneFeatureConfiguration> {
    public SpiralMushroom(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    public boolean canPlace(WorldGenLevel world, Map<ChunkPos, LongOpenHashSet> posList) {
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
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();

        if (!world.getBlockState(pos.below()).isSolidRender(world, pos.below())) return false;

        BlockState block = ModBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState();
        BlockState block2 = ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK.get().defaultBlockState();
        BlockState block3 = ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK.get().defaultBlockState();
        BlockState block4 = Blocks.MUSHROOM_STEM.defaultBlockState();

        int large = random.nextIntBetweenInclusive(5, 10);

        SpiralGen spiral = new SpiralGen(pos, large, random.nextIntBetweenInclusive(25, 50));
        spiral.setSpiralType(SpiralGen.SpiralType.LARGE_OUTLINE);

        BlockLayer layer = new BlockLayer(LayerPlacer.ofRandom(random), List.of(block, block2, block3, block4), List.of((short) 6, (short) 4, (short) 2, (short) 1));


        int outline = context.random().nextIntBetweenInclusive(1,2);
        spiral.setOutlineRadiusX(outline);
        spiral.setOutlineRadiusX(outline);

        spiral.setRadiusX(new Pair<>(large, 1));
        spiral.setRadiusZ(new Pair<>(large, 1));

        Rotator rotator = new Rotator(pos, random.nextIntBetweenInclusive(0, 360), 0,0);

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
