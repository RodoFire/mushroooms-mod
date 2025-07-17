package fr.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom;

import com.mojang.datafixers.util.Pair;
import fr.rodofire.ewc.blockdata.StructurePlacementRuleManager;
import fr.rodofire.ewc.blockdata.blocklist.DividedBlockListManager;
import fr.rodofire.ewc.blockdata.layer.BlockLayer;
import fr.rodofire.ewc.blockdata.layer.BlockLayerManager;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.ewc.shape.block.gen.CircleGen;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.shape.block.layer.LayerManager;
import fr.rodofire.ewc.shape.block.placer.LayerPlacer;
import fr.rodofire.ewc.structure.MultiChunkFeaturePiece;
import fr.rodofire.ewc.util.FastNoiseLite;
import fr.rodofire.ewc.util.LongPosHelper;
import fr.rodofire.ewc.util.WorldGenUtil;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.world.structures.ModStructurePieceType;
import fr.rodofire.mushrooomsmod.world.structures.custom.config.mushroom.GiantYellowMushroomGeneratorConfig;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GiantYellowMushroomPiece extends MultiChunkFeaturePiece {
    GiantYellowMushroomGeneratorConfig config;

    BlockPos start;
    BlockPos end;

    SphereGen cap;
    SphereGen capMask;


    public GiantYellowMushroomPiece(BoundingBox boundingBox, ResourceLocation featureId, Set<ChunkPos> chunkPosSet, GiantYellowMushroomGeneratorConfig config) {
        super(ModStructurePieceType.GIANT_YELLOW_MUSHROOM.get(), 0, boundingBox, featureId, chunkPosSet);
        this.config = config;
        this.start = config.start();
        this.end = config.end();
        this.cap = config.sphere();
        this.capMask = config.mask();
    }

    public GiantYellowMushroomPiece(CompoundTag nbt) {
        super(ModStructurePieceType.GIANT_YELLOW_MUSHROOM.get(), nbt);
        this.config = getGeneratorConfig(nbt, GiantYellowMushroomGeneratorConfig.CODEC);
        this.start = config.start();
        this.end = config.end();
        this.cap = config.sphere();
        this.capMask = config.mask();
    }

    public GiantYellowMushroomPiece(StructurePieceSerializationContext structureContext, CompoundTag nbtCompound) {
        this(nbtCompound);
    }

    @Override
    protected void addAdditionalSaveData(StructurePieceSerializationContext context, CompoundTag nbt) {
        super.addAdditionalSaveData(context, nbt);
        writeGeneratorConfigCodec(nbt, GiantYellowMushroomGeneratorConfig.CODEC, config);
    }

    @Override
    public @Nullable DividedBlockListManager getDividedStructure(WorldGenLevel world, StructureManager structureAccessor, ChunkGenerator chunkGenerator, RandomSource random, BoundingBox chunkBox, ChunkPos chunkPos, BlockPos pivot) {
        DividedBlockListManager manager = getCap(random);
        manager.put(getTrunk(world, random));


        return manager;
    }

    private DividedBlockListManager getCap(RandomSource random) {
        Map<ChunkPos, LongOpenHashSet> posCoordinates = cap.getShapeCoordinates();
        Map<ChunkPos, LongOpenHashSet> maskCoordinates = capMask.getShapeCoordinates();
        posCoordinates.forEach((chunkPos, longSet) -> {
            LongOpenHashSet maskSet = maskCoordinates.get(chunkPos);
            if (maskSet == null) return;
            longSet.removeAll(maskSet);
        });

        Map<ChunkPos, LongOpenHashSet> frogLight = new HashMap<>();
        posCoordinates.forEach(((chunkPos, longSet) -> {
            LongIterator iterator = longSet.iterator();
            int i = 0;
            while (iterator.hasNext() && i++ < longSet.size()) {
                long pos = iterator.nextLong();
                if (MathUtil.getRandomBoolean(random, 0.01f) && !longSet.contains(LongPosHelper.up(pos, -1))) {
                    iterator.remove();
                    frogLight.computeIfAbsent(chunkPos, (o) -> new LongOpenHashSet()).add(pos);
                }
            }
        }));

        LayerManager manager = new LayerManager(LayerManager.Type.SURFACE,
                new BlockLayerManager(
                        new BlockLayer(LayerPlacer.ofRandom(random),
                                List.of(ModBlocks.YELLOW_MUSHROOM_BLOCK.get().defaultBlockState(), ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK.get().defaultBlockState()),
                                List.of((short) random.nextIntBetweenInclusive(2, 5), (short) 1),
                                2,
                                new StructurePlacementRuleManager()
                        ), new BlockLayer(LayerPlacer.ofRandom(random), Blocks.MUSHROOM_STEM.defaultBlockState())
                )
        );


        DividedBlockListManager dividedManager = manager.getDivided(posCoordinates);
        dividedManager.put(Blocks.OCHRE_FROGLIGHT.defaultBlockState(), frogLight);
        return dividedManager;
    }

    private DividedBlockListManager getTrunk(WorldGenLevel world, RandomSource random) {
        int points = (int) WorldGenUtil.getDistance(start, end);

        FastNoiseLite noiseLite = new FastNoiseLite((int) world.getSeed());
        FastNoiseLite largeNoise = new FastNoiseLite((int) world.getSeed());
        FastNoiseLite bigNoise = new FastNoiseLite((int) world.getSeed());
        noiseLite.SetFrequency(0.1f);
        largeNoise.SetFrequency(0.3f);
        largeNoise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        bigNoise.SetFrequency(0.07f);

        int baseLarge = random.nextIntBetweenInclusive(3, 4);
        DividedBlockListManager divided = new DividedBlockListManager();

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


            int largeVariationX = (int) (largeNoise.GetNoise(x * 0.1f, y, z * 0.1f) * 2);
            int largeVariationZ = (int) (largeNoise.GetNoise(z * 0.1f, y, x * 0.1f) * 2);

            int largeXSquared = (largeVariationX + baseLarge) * (largeVariationX + baseLarge);
            int largeZSquared = (largeVariationZ + baseLarge) * (largeVariationZ + baseLarge);

            for (int j = (int) (-baseLarge - largeVariationX); j <= baseLarge + largeVariationX; j++) {
                int j2 = j * j;
                float dividedJ2 = (float) j2 / largeXSquared;

                for (int k = (int) (-baseLarge - largeVariationZ); k <= baseLarge + largeVariationZ; k++) {
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


        if (MathUtil.getRandomBoolean(random, 0.1f)) {
            divided.put(getTrunkMushrooms(positions, random));
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

        divided.put(state, smoothed);


        lightPosition.forEach((longPos, direction) -> {
            divided.put(Blocks.GLOW_LICHEN.defaultBlockState().setValue(MultifaceBlock.getFaceProperty(direction), true), longPos);
        });

        frogLightPositions.forEach((longPos) -> {
            divided.put(Blocks.OCHRE_FROGLIGHT.defaultBlockState(), longPos);
        });

        return divided;
    }

    private DividedBlockListManager getTrunkMushrooms(LongArrayList trunkPos, RandomSource random) {
        DividedBlockListManager dividedManager = new DividedBlockListManager();

        Map<ChunkPos, LongOpenHashSet> mushPos = new HashMap<>();

        trunkPos.forEach(aLong -> {
            if (MathUtil.getRandomBoolean(random, 0.0006f)) {
                CircleGen circleGen = new CircleGen(LongPosHelper.decodeBlockPos(aLong), random.nextIntBetweenInclusive(3, 6));
                Map<ChunkPos, LongOpenHashSet> circlePos = circleGen.getShapeCoordinates();
                circlePos.forEach((chunkPos1, longs1) -> {
                    mushPos.computeIfAbsent(chunkPos1, k -> new LongOpenHashSet()).addAll(longs1);
                });
            }
        });

        dividedManager.put(ModBlocks.YELLOW_DEGRADATED_MUSHROOM_BLOCK.get().defaultBlockState(), mushPos);
        return dividedManager;
    }

    @Override
    public @Nullable Pair<Map<ChunkPos, LongOpenHashSet>, LayerManager> getStructurePair(WorldGenLevel
                                                                                                 world, StructureManager structureAccessor, ChunkGenerator chunkGenerator, RandomSource random, BoundingBox
                                                                                                 chunkBox, ChunkPos chunkPos, BlockPos pivot) {
        return null;
    }
}
