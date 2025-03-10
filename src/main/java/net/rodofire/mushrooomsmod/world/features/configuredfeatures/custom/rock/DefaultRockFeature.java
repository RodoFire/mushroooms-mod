package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.blockdata.StructurePlacementRuleManager;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayerManager;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;
import net.rodofire.easierworldcreator.shape.block.layer.LayerManager;
import net.rodofire.easierworldcreator.shape.block.placer.ShapePlacer;
import net.rodofire.easierworldcreator.shape.block.rotations.Rotator;
import net.rodofire.easierworldcreator.util.FastNoiseLite;
import net.rodofire.easierworldcreator.util.LongPosHelper;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.util.ModTags;

import java.util.*;

public abstract class DefaultRockFeature extends Feature<DefaultFeatureConfig> {
    private int height;
    private int width;
    private BlockState block;


    public DefaultRockFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        Random random = context.getRandom();
        BlockPos pos = context.getOrigin();
        if (world.getBlockState(pos).getBlock() == Blocks.SHORT_GRASS)
            pos.add(0, -1, 0);

        if (!world.getBlockState(pos.down()).isOpaqueFullCube()) {
            return false;
        }

        BlockLayer layer = this.getBlockLayer(world.getSeed());
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
        ShapePlacer placer = new ShapePlacer(world, ShapePlacer.PlaceMoment.OTHER, pos, Identifier.of(MushrooomsMod.MOD_ID, "rock_feature"));
        placer.place(newPosMap, layerManager);

        return true;
    }

    public abstract Rotator getRotator(BlockPos pos, Random random);

    public abstract BlockLayer getBlockLayer(long seed);

    public abstract Vec3i getDimensions(Random random);


}
