package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.shapegen.SphereGen;
import net.rodofire.easierworldcreator.shapeutil.BlockLayer;
import net.rodofire.easierworldcreator.shapeutil.Shape;
import net.rodofire.easierworldcreator.worldgenutil.FastNoiseLite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
        BlockPos pos = context.getOrigin();
        if (world.getBlockState(pos).getBlock() == Blocks.GRASS)
            pos.add(0, -1, 0);

        if (!world.getBlockState(pos.down()).isOpaqueFullCube(world, pos)) {
            return false;
        }
        BlockLayer layer = this.getBlockLayer();
        Vec3i dimensions = this.getDimesions();

        SphereGen circleGen = new SphereGen(world, pos, Shape.PlaceMoment.WORLD_GEN, 0);
        circleGen.setHalfSphere(SphereGen.SphereType.HALF);

        circleGen.setRadiusX(dimensions.getX());
        circleGen.setRadiusY(dimensions.getY());
        circleGen.setRadiusZ(dimensions.getZ());

        circleGen.setYRotation(Random.create().nextBetween(-20, 20));
        circleGen.setZRotation(Random.create().nextBetween(-20, 20));

        layer.addBlocksToForce(Set.of(Blocks.GRASS_BLOCK, Blocks.DIRT));
        circleGen.setBlockLayers(layer);


        circleGen.setLayerPlace(Shape.LayerPlace.NOISE3D);
        FastNoiseLite placeNoise = new FastNoiseLite((int) world.getSeed());
        placeNoise.SetFrequency(0.2f);
        circleGen.setNoise(placeNoise);

        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFrequency(0.1f);

        List<Set<BlockPos>> posList = circleGen.getBlockPos();
        for (Set<BlockPos> set : posList) {
            List<BlockPos> toAdd = new ArrayList<>();
            Iterator<BlockPos> iter = set.iterator();
            while (iter.hasNext()) {
                BlockPos blockPos = iter.next();
                float value = noise.GetNoise(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                if (value > 0.8f) {
                    toAdd.add(blockPos.up());
                } else if (value < 0.1f && value > -0.1f) {
                    iter.remove();
                } else if (value < 0.8f) {
                    toAdd.add(blockPos.down());
                }
            }
            set.addAll(toAdd);
        }

        try {
            circleGen.place(posList);
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public abstract BlockLayer getBlockLayer();

    public abstract Vec3i getDimesions();


}
