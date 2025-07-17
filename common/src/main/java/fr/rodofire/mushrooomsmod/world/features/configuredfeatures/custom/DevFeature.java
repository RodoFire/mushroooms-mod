package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.StructurePlacementRuleManager;
import fr.rodofire.ewc.blockdata.layer.BlockLayer;
import fr.rodofire.ewc.blockdata.layer.BlockLayerManager;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.shape.block.layer.LayerManager;
import fr.rodofire.ewc.shape.block.placer.LayerPlacer;
import fr.rodofire.ewc.shape.block.rotations.Rotator;
import fr.rodofire.ewc.util.FastNoiseLite;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.world.features.config.ModSimpleBlockFeatureConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DevFeature extends Feature<ModSimpleBlockFeatureConfig> {
    public DevFeature(Codec<ModSimpleBlockFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<ModSimpleBlockFeatureConfig> context) {
        WorldGenLevel world = context.level();
        RandomSource random = context.random();
        BlockPos start = context.origin();
        BlockState state = context.config().blockprovider.getState(random, start);
        long startTimeCartesian = System.nanoTime();

        int height = random.nextIntBetweenInclusive(60, 80);
        int points = height + 1;

        BlockPos end = start.above(height);

        FastNoiseLite noiseLite = new FastNoiseLite((int) world.getSeed());
        FastNoiseLite largeNoise = new FastNoiseLite((int) world.getSeed());
        FastNoiseLite bigNoise = new FastNoiseLite((int) world.getSeed());
        noiseLite.SetFrequency(0.1f);
        largeNoise.SetFrequency(0.3f);
        largeNoise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        bigNoise.SetFrequency(0.07f);


        List<BlockPos> positions = new ArrayList<>();

        int baseLarge = 3;

        for (int i = 0; i <= points * 2; i++) {
            float t = i / (float) (points * 2); // Progression de 0 à 1

            // Interpolation linéaire entre start et end
            float x = start.getX() + t * (end.getX() - start.getX());
            float y = start.getY() + t * (end.getY() - start.getY());
            float z = start.getZ() + t * (end.getZ() - start.getZ());

            // Ajout de bruit pour décaler X et Z (tout en gardant l'interpolation)
            float noiseFactor = 5.0f; // Intensité du bruit
            float noiseX = noiseLite.GetNoise(x * 0.1f, y * 0.1f, z * 0.1f) * noiseFactor;
            float noiseZ = noiseLite.GetNoise(z * 0.1f, x * 0.1f, y * 0.1f) * noiseFactor;

            // Atténuer le bruit au début et à la fin (pour coller à start et end)
            float attenuation = (float) Math.sin(t * Math.PI); // 0 aux extrémités, 1 au milieu
            x += noiseX * attenuation;
            z += noiseZ * attenuation;


            int largeVariationX = (int) (largeNoise.GetNoise(x * 0.1f, y, z * 0.1f) * 2);
            int largeVariationZ = (int) (largeNoise.GetNoise(z * 0.1f, y, x * 0.1f) * 2);

            int largeXSquared = (largeVariationX + baseLarge) * (largeVariationX + baseLarge);
            int largeZSquared = (largeVariationZ + baseLarge) * (largeVariationZ + baseLarge);

            for (int j = (int) (-baseLarge - largeVariationX); j <= baseLarge + largeVariationX; j++) {
                for (int k = (int) (-baseLarge - largeVariationZ); k <= baseLarge + largeVariationZ; k++) {
                    if ((float) (j * j) / largeXSquared + (float) (k * k) / largeZSquared <= 1f) {
                        for (int l = -random.nextIntBetweenInclusive(0, 3); l <= random.nextIntBetweenInclusive(0, 3); l++)
                            positions.add(new BlockPos((int) x + j, (int) y + l, (int) z + k));
                    }
                }
            }
        }

        List<BlockPos> smoothed = new ArrayList<>(positions);
        for (int i = 0; i < positions.size() - 1; i++) {
            BlockPos p0 = positions.get(i);
            BlockPos p1 = positions.get(i + 1);

            int x1 = (3 * p0.getX() + p1.getX()) / 4;
            int y1 = (3 * p0.getY() + p1.getY()) / 4;
            int z1 = (3 * p0.getZ() + p1.getZ()) / 4;

            int x2 = (p0.getX() + 3 * p1.getX()) / 4;
            int y2 = (p0.getY() + 3 * p1.getY()) / 4;
            int z2 = (p0.getZ() + 3 * p1.getZ()) / 4;

            smoothed.add(new BlockPos(x1, y1, z1));
            smoothed.add(new BlockPos(x2, y2, z2));
        }

        for (BlockPos p : smoothed) {
            world.setBlock(p, Blocks.MUSHROOM_STEM.defaultBlockState(), 2);
        }

        int down = random.nextIntBetweenInclusive(1, 3);
        SphereGen sphereGen = new SphereGen(end.below(down), random.nextIntBetweenInclusive(20, 32));
        sphereGen.setRadiusY(random.nextIntBetweenInclusive(4, 7));


        int rot1 = random.nextIntBetweenInclusive(-10, 10);
        int rot2 = random.nextIntBetweenInclusive(0, 360);
        Rotator rotator = new Rotator(end.below(down), 0, rot1, rot2);
        sphereGen.setRotator(rotator);


        int heightMask = random.nextIntBetweenInclusive(down + 1, down + 5);
        SphereGen mask = new SphereGen(end.below(heightMask), random.nextIntBetweenInclusive(20, 32));
        mask.setRadiusY(heightMask);

        Rotator rotatorMask = new Rotator(end.below(heightMask), 0, rot1, rot2);
        mask.setRotator(rotatorMask);

        Map<ChunkPos, LongOpenHashSet> posCoordinates = sphereGen.getShapeCoordinates();
        Map<ChunkPos, LongOpenHashSet> maskCoordinates = mask.getShapeCoordinates();
        posCoordinates.forEach((chunkPos, longSet) -> {
            LongOpenHashSet maskSet = maskCoordinates.get(chunkPos);
            if (maskSet == null) return;
            longSet.removeAll(maskSet);
        });


        LayerManager manager = new LayerManager(LayerManager.Type.SURFACE,
                new BlockLayerManager(
                        new BlockLayer(LayerPlacer.ofRandom(random),
                                List.of(ModBlocks.YELLOW_MUSHROOM_BLOCK.get().defaultBlockState(), ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK.get().defaultBlockState()),
                                List.of((short) 3, (short) 1),
                                2,
                                new StructurePlacementRuleManager()
                        ), new BlockLayer(LayerPlacer.ofRandom(random), Blocks.MUSHROOM_STEM.defaultBlockState())
                )
        );

        manager.place(world, posCoordinates);


        long endTimeCartesian = (System.nanoTime());
        long durationCartesian = (endTimeCartesian - startTimeCartesian) / 1000000;
        System.out.println("duration : " + durationCartesian + " ms");

        return true;
    }
}
