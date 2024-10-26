package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.rodofire.easierworldcreator.util.FastMaths;
import net.rodofire.easierworldcreator.worldgenutil.BlockPlaceUtil;
import net.rodofire.easierworldcreator.worldgenutil.FastNoiseLite;
import net.rodofire.easierworldcreator.worldgenutil.GenLines;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;

import java.util.List;
import java.util.Set;

public class CustomBlueMushroomFeature extends CustomBlueMushroom {
    public CustomBlueMushroomFeature(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }


    @Override
    public void generateLargeCap(StructureWorldAccess world, Random random, BlockPos pos, int maxlarge, BlockState state, int large, int height) {

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        int length = 0;
        int largexsquared = large * large;
        int largeysquared = height * height;

        boolean force = true;

        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetFrequency(0.06f);

        for (float x = -large; x <= large; ++x) {
            for (float z = -large; z <= large; ++z) {

                float a = 3 * noise.GetNoise(x + pos.getX(), z + pos.getZ());

                for (float y = -height; y <= height; ++y) {
                    if (x * x / (float) largexsquared + y * y / (float) largeysquared + z * z / (float) largexsquared <= 1.0F) {
                        mutable.set(pos, (int) x, (int) (y + a), (int) z);
                        BlockPlaceUtil.setRandomBlockWithVerification(world, force, Set.of(ModBlocks.BLUE_MUSHROOM_BLOCK), List.of(state), mutable);
                    }
                }
            }
        }
    }

    @Override
    public void generateLargeTrunk(StructureWorldAccess world, Random random, BlockPos pos, BlockState trunk, boolean force, int height, int maxlarge, int minlarge) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        Vec3d vect3d = pos.toCenterPos();
        Box box = Box.of(vect3d, maxlarge, 2, maxlarge);
        for (Entity entity : world.getOtherEntities(null, box)) {
            Vec3d vect = entity.getPos().subtract(pos.toCenterPos());
            double distance = FastMaths.getLength((float) vect.x, (float) vect.z, 0.005f);
            if (distance == 0) {
                int x = 5 + pos.getX();
                entity.teleport(x, pos.getY(), pos.getZ());
            } else {
                int x = (int) ((maxlarge * vect.x / distance) + pos.getX());
                int y = pos.getY();
                int z = (int) ((maxlarge * vect.z / distance) + pos.getZ());

                entity.teleport(x, y, z);
            }
        }

        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFractalType(FastNoiseLite.FractalType.FBm);
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetFrequency(0.5f);

        double c3 = (double) 360 / height;
        for (double j = 1; j <= maxlarge; ++j) {
            double c1 = (j + (j * minlarge / maxlarge)) / 2;
            double c2 = (j - (j * minlarge / maxlarge)) / 2;

            for (int u = 0; u <= height; u++) {

                double a = c1 + c2 * FastMaths.getFastCos((float) (u * c3));

                for (double v = 0; v <= 360; v += 45 / j) {

                    int x = (int) (a * FastMaths.getFastCos((float) v));
                    int z = (int) (a * FastMaths.getFastSin((float) v));
                    mutable.set(pos, x, u, z);
                    float t = 4 * noise.GetNoise(mutable.getX(), mutable.getZ());
                    if (u == 0) {
                        GenLines.generateAxisLine(world, mutable, (int) (Math.abs(t * 4)), Direction.DOWN, trunk);
                    }
                    if (t < 1) {
                        BlockPlaceUtil.setRandomBlockWithVerification(world, force, null, List.of(trunk), mutable.down());
                    } else {
                        BlockPlaceUtil.setRandomBlockWithVerification(world, force, null, List.of(trunk), mutable);
                        if (t > 1) {
                            BlockPlaceUtil.setRandomBlockWithVerification(world, force, null, List.of(trunk), mutable.up());
                        }
                    }

                }
            }
        }
    }


}
