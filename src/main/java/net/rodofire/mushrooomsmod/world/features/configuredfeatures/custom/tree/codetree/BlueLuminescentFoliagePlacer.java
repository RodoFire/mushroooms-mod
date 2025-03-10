package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.rodofire.easierworldcreator.util.FastNoiseLite;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModFoliagePlacerTypes;

public class BlueLuminescentFoliagePlacer extends FoliagePlacer {
    public static final BlueLuminescentFoliagePlacer INSTANCE = new BlueLuminescentFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(1), 3);
    public static final MapCodec<BlueLuminescentFoliagePlacer> CODEC = MapCodec.unit(() -> INSTANCE);
    final int height;

    public BlueLuminescentFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.BLUE_LUMINESCENT_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight,
                            TreeNode treeNode, int foliageHeight, int radius, int offset) {

        FastNoiseLite noise = new FastNoiseLite(random.nextInt());
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetFractalType(FastNoiseLite.FractalType.FBm);
        noise.SetFractalOctaves(2);
        noise.SetFrequency(0.7f);

        int yradius = radius - Random.create().nextBetween(1, 3);

        int largexsquared = radius * radius;
        int largeysquared = yradius * yradius;

        BlockPos pos = treeNode.getCenter();

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (float x = -radius; x <= radius; ++x) {
            for (float z = -radius; z <= radius; ++z) {

                float a = 4 * noise.GetNoise(x, z);

                for (float y = -yradius; y <= yradius; ++y) {
                    if (x * x / (float) largexsquared + y * y / (float) largeysquared + z * z / (float) largexsquared <= 1.0F) {
                        mutable.set(pos, (int) x, (int) (y + a), (int) z);
                        FoliagePlacer.placeFoliageBlock(world, placer, random, config, mutable);
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
}
