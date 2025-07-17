package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree;

import com.mojang.serialization.MapCodec;
import fr.rodofire.ewc.util.FastNoiseLite;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModFoliagePlacerTypes;

public class BlueLuminescentFoliagePlacer extends FoliagePlacer {
    public static final BlueLuminescentFoliagePlacer INSTANCE = new BlueLuminescentFoliagePlacer(ConstantInt.of(4), ConstantInt.of(1), 3);
    public static final MapCodec<BlueLuminescentFoliagePlacer> CODEC = MapCodec.unit(() -> INSTANCE);
    final int height;

    public BlueLuminescentFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacerTypes.BLUE_LUMINESCENT_FOLIAGE_PLACER;
    }

    @Override
    protected void createFoliage(LevelSimulatedReader world, FoliageSetter placer, RandomSource random, TreeConfiguration config, int trunkHeight,
                            FoliageAttachment treeNode, int foliageHeight, int radius, int offset) {

        FastNoiseLite noise = new FastNoiseLite(random.nextInt());
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetFractalType(FastNoiseLite.FractalType.FBm);
        noise.SetFractalOctaves(2);
        noise.SetFrequency(0.7f);

        int yradius = radius - random.nextIntBetweenInclusive(1, 3);

        int largexsquared = radius * radius;
        int largeysquared = yradius * yradius;

        BlockPos pos = treeNode.pos();

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        for (float x = -radius; x <= radius; ++x) {
            for (float z = -radius; z <= radius; ++z) {

                float a = 4 * noise.GetNoise(x, z);

                for (float y = -yradius; y <= yradius; ++y) {
                    if (x * x / (float) largexsquared + y * y / (float) largeysquared + z * z / (float) largexsquared <= 1.0F) {
                        mutable.setWithOffset(pos, (int) x, (int) (y + a), (int) z);
                        FoliagePlacer.tryPlaceLeaf(world, placer, random, config, mutable);
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
}
