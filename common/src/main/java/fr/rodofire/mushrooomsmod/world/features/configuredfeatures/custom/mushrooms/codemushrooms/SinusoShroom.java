package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.blocklist.BlockListManager;
import fr.rodofire.ewc.blockdata.layer.BlockLayerManager;
import fr.rodofire.ewc.maths.FastMaths;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.shape.block.layer.LayerManager;
import fr.rodofire.ewc.shape.block.placer.LayerPlacer;
import fr.rodofire.ewc.util.FastNoiseLite;
import fr.rodofire.ewc.util.LongPosHelper;
import fr.rodofire.ewc.util.WorldGenUtil;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import fr.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SinusoShroom extends Feature<NoneFeatureConfiguration> {
    BlockPos start;
    BlockPos end;
    SinusDirection sinusDirection;

    public SinusoShroom(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    public boolean canPlace(WorldGenLevel world, int radius) {
        for (int i = -radius + 1; i < radius; i++) {
            for (int j = -radius + 1; j < radius; j++) {
                for (int k = -3; k < 3; k++) {
                    if (!world.isEmptyBlock(end.offset(i, k, j))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        RandomSource random = context.random();

        int radius = random.nextIntBetweenInclusive(9, 14);
        int radiusY = random.nextIntBetweenInclusive(2, 5);

        this.start = context.origin();
        if (!world.getBlockState(start.below()).isSolidRender(world, start.below())) return false;
        this.end = this.start.offset(random.nextIntBetweenInclusive(-2, 2), random.nextIntBetweenInclusive(15, 25), random.nextIntBetweenInclusive(-2, 2));

        if (!canPlace(world, radius))
            return false;

        BlockListManager manager = getTrunk(world, random);

        SphereGen sphereGen = new SphereGen(end, radius);
        sphereGen.setRadiusY(radiusY);

        Map<ChunkPos, LongOpenHashSet> positions = sphereGen.getShapeCoordinates();
        Map<ChunkPos, LongOpenHashSet> newPositions = new HashMap<>();
        Map<ChunkPos, LongOpenHashSet> shroomLightPositions = new HashMap<>();

        this.sinusDirection = SinusDirection.values()[random.nextIntBetweenInclusive(0, 2)];

        int divide = random.nextIntBetweenInclusive(2 + radiusY, 7);
        int multiply = random.nextIntBetweenInclusive(3, 5);
        int baseYOffset = (int) getYOffset(end.getX(), end.getZ(), divide, multiply);


        for (Map.Entry<ChunkPos, LongOpenHashSet> entry : positions.entrySet()) {
            ChunkPos chunkPos = entry.getKey();
            LongOpenHashSet originalSet = entry.getValue();
            LongOpenHashSet modifiedSet = new LongOpenHashSet();
            LongOpenHashSet shroomSet = new LongOpenHashSet();

            for (long packedPos : originalSet) {

                BlockPos pos = LongPosHelper.decodeBlockPos(packedPos);
                if (Math.abs(pos.getZ() - start.getZ()) > 16 || Math.abs(pos.getX() - start.getX()) > 16) {
                    System.out.println(pos);
                }

                double wave = getYOffset(pos.getX(), pos.getZ(), divide, multiply);
                int newY = (int) (pos.getY() + wave - baseYOffset);

                BlockPos newPos = new BlockPos(pos.getX(), newY, pos.getZ());

                if (MathUtil.getRandomBoolean(random, 0.045f)) shroomSet.add(LongPosHelper.encodeBlockPos(newPos));
                else modifiedSet.add(LongPosHelper.encodeBlockPos(newPos));
            }

            newPositions.put(chunkPos, modifiedSet);
            shroomLightPositions.put(chunkPos, shroomSet);
        }

        manager.placeAll(world);
        manager.clear();

        BlockLayerManager blockLayerManager = new BlockLayerManager(
                LayerPlacer.ofRandom(random),
                List.of(
                        ModBlocks.YELLOW_MUSHROOM_BLOCK.get().defaultBlockState(),
                        ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK.get().defaultBlockState()),
                List.of((short) 3, (short) 1)
        );

        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE, blockLayerManager);
        layerManager.place(world, newPositions);
        shroomLightPositions.forEach((chunkPos, longs) -> {
            longs.forEach(aLong -> {
                world.setBlock(LongPosHelper.decodeBlockPos(aLong), Blocks.OCHRE_FROGLIGHT.defaultBlockState(), 3);
            });
        });


        return true;
    }

    private BlockListManager getTrunk(WorldGenLevel world, RandomSource random) {
        int points = (int) WorldGenUtil.getDistance(start, end);

        FastNoiseLite noiseLite = new FastNoiseLite((int) world.getSeed());
        FastNoiseLite largeNoise = new FastNoiseLite((int) world.getSeed());
        FastNoiseLite bigNoise = new FastNoiseLite((int) world.getSeed());
        noiseLite.SetFrequency(0.1f);
        largeNoise.SetFrequency(0.3f);
        largeNoise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        bigNoise.SetFrequency(0.07f);

        int baseLarge = random.nextIntBetweenInclusive(1, 2);
        BlockListManager manager = new BlockListManager();

        BlockState state = Blocks.MUSHROOM_STEM.defaultBlockState();

        LongArrayList positions = new LongArrayList();
        LongArrayList frogLightPositions = new LongArrayList();
        Long2ObjectOpenHashMap<Direction> lightPosition = new Long2ObjectOpenHashMap<>();

        for (int i = -20; i <= points * 2; i++) {
            float t = i / (float) (points * 2);

            float x = start.getX() + t * (end.getX() - start.getX());
            float y = start.getY() + t * (end.getY() - start.getY());
            float z = start.getZ() + t * (end.getZ() - start.getZ());

            float noiseFactor = 5.0f;
            float noiseX = noiseLite.GetNoise(x * 0.1f, y * 0.1f, z * 0.1f) * noiseFactor;
            float noiseZ = noiseLite.GetNoise(z * 0.1f, x * 0.1f, y * 0.1f) * noiseFactor;

            float attenuation = (float) Math.sin(t * Math.PI);
            x += noiseX * attenuation;
            z += noiseZ * attenuation;

            int largeXSquared = +baseLarge * baseLarge;
            int largeZSquared = +baseLarge * baseLarge;

            for (int j = -baseLarge; j <= baseLarge; j++) {
                int j2 = j * j;
                float dividedJ2 = (float) j2 / largeXSquared;

                for (int k = -baseLarge; k <= baseLarge; k++) {
                    int k2 = k * k;
                    float dividedK2 = (float) k2 / largeZSquared;
                    if (dividedJ2 + dividedK2 <= 1f) {
                        for (int l = -random.nextIntBetweenInclusive(0, 3); l <= random.nextIntBetweenInclusive(0, 3); l++) {
                            if (l > end.getY()) continue;

                            long pos = LongPosHelper.encodeBlockPos((int) x + j, (int) y + l, (int) z + k);


                            if (dividedJ2 + dividedK2 <= 1.05f && dividedJ2 + dividedK2 >= 0.95f) {
                                if (MathUtil.getRandomBoolean(random, 0.1f)) {
                                    frogLightPositions.add(pos);
                                } else {
                                    positions.add(pos);
                                }


                                if (MathUtil.getRandomBoolean(random, 0.05f)) {
                                    Direction direction;

                                    if (Math.abs(j) > Math.abs(k)) {
                                        direction = j > 0 ? Direction.WEST : Direction.EAST;
                                    } else {
                                        direction = k > 0 ? Direction.NORTH : Direction.SOUTH;
                                    }

                                    lightPosition.put(LongPosHelper.offset(direction, pos, 1), direction);
                                }
                            } else {
                                positions.add(pos);
                            }
                        }
                    }
                }
            }
        }

        LongArrayList smoothed = new LongArrayList(positions);
        for (int i = 0; i < positions.size() - 1; i++) {
            BlockPos p0 = LongPosHelper.decodeBlockPos(positions.getLong(i));
            BlockPos p1 = LongPosHelper.decodeBlockPos(positions.getLong(i + 1));

            int x1 = (3 * p0.getX() + p1.getX()) / 4;
            int y1 = (3 * p0.getY() + p1.getY()) / 4;
            int z1 = (3 * p0.getZ() + p1.getZ()) / 4;

            int x2 = (p0.getX() + 3 * p1.getX()) / 4;
            int y2 = (p0.getY() + 3 * p1.getY()) / 4;
            int z2 = (p0.getZ() + 3 * p1.getZ()) / 4;

            if (y1 <= end.getY())
                smoothed.add(LongPosHelper.encodeBlockPos(x1, y1, z1));
            if (y2 <= end.getY())
                smoothed.add(LongPosHelper.encodeBlockPos(x2, y2, z2));
        }

        manager.put(state, smoothed);


        manager.put(Blocks.OCHRE_FROGLIGHT.defaultBlockState(), frogLightPositions);
        lightPosition.forEach((longPos, direction) -> {
            manager.put(Blocks.GLOW_LICHEN.defaultBlockState().setValue(MultifaceBlock.getFaceProperty(direction), true), longPos);
        });

        return manager;
    }

    public double getYOffset(int x, int z, int divide, int multiply) {
        return switch (this.sinusDirection) {
            case X -> FastMaths.getFastSin((float) 45 * x / divide) * multiply;
            case Z -> FastMaths.getFastSin((float) 45 * z / divide) * multiply;
            case X_Z -> FastMaths.getFastSin((float) 45 * (x + z) / divide) * multiply;
            case MX_Z -> FastMaths.getFastSin((float) 45 * (x - z) / divide) * multiply;
        };
    }

    enum SinusDirection {
        X,
        Z,
        X_Z,
        MX_Z,
    }
}
