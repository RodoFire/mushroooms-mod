package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.StructurePlacementRuleManager;
import fr.rodofire.ewc.blockdata.layer.BlockLayer;
import fr.rodofire.ewc.blockdata.layer.BlockLayerManager;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.shape.block.layer.LayerManager;
import fr.rodofire.ewc.shape.block.placer.ShapePlacer;
import fr.rodofire.ewc.shape.block.rotations.Rotator;
import fr.rodofire.ewc.util.FastNoiseLite;
import fr.rodofire.ewc.util.LongPosHelper;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.util.ModTags;

import java.util.*;

public abstract class DefaultRockFeature extends Feature<NoneFeatureConfiguration> {
    private int height;
    private int width;
    private BlockState block;


    public DefaultRockFeature(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        RandomSource random = context.random();
        BlockPos pos = context.origin();
        if (world.getBlockState(pos).getBlock() == Blocks.SHORT_GRASS)
            pos.offset(0, -1, 0);

        if (!world.getBlockState(pos.below()).isSolidRender(world, pos)) {
            return false;
        }

        BlockLayer layer = this.getBlockLayer(random, world.getSeed());
        Vec3i dimensions = this.getDimensions(random);

        SphereGen circleGen = new SphereGen(pos, 0);
        circleGen.setHalfSphere(SphereGen.SphereType.HALF);

        circleGen.setRadiusX(dimensions.getX());
        circleGen.setRadiusY(dimensions.getY());
        circleGen.setRadiusZ(dimensions.getZ());

        circleGen.setRotator(getRotator(pos, random));

        StructurePlacementRuleManager ruleManager = new StructurePlacementRuleManager();
        ruleManager.addTagKey(BlockTags.DIRT);
        ruleManager.addTagKey(BlockTags.FLOWERS);
        ruleManager.addTagKey(BlockTags.LEAVES);
        ruleManager.addTagKey(ModTags.Blocks.FLUIDS);

        layer.setRuler(ruleManager);

        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFrequency(0.075f);

        Map<ChunkPos, LongOpenHashSet> posList = circleGen.getShapeCoordinates();
        Map<ChunkPos, LongOpenHashSet> newPosMap = circleGen.getShapeCoordinates();
        for (Map.Entry<ChunkPos, LongOpenHashSet> entry : posList.entrySet()) {
            LongOpenHashSet newSet = new LongOpenHashSet(entry.getValue().size());
            for (long encodedPos : entry.getValue()) {
                float value = noise.GetNoise(encodedPos);
                if (value > 0.8f) {
                    newSet.add(LongPosHelper.up(encodedPos, 1));
                } else if (value < 0.8f) {
                    newSet.add(LongPosHelper.up(encodedPos, -1));
                } else {
                    newSet.add(encodedPos);
                }
            }
            newPosMap.put(entry.getKey(), newSet);
        }


        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE, new BlockLayerManager(layer));
        ShapePlacer placer = new ShapePlacer(world, ShapePlacer.PlaceMoment.OTHER, pos, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "rock_feature"));
        placer.place(newPosMap, layerManager);

        return true;
    }

    public abstract Rotator getRotator(BlockPos pos, RandomSource random);

    public abstract BlockLayer getBlockLayer(RandomSource random, long seed);

    public abstract Vec3i getDimensions(RandomSource random);


}
