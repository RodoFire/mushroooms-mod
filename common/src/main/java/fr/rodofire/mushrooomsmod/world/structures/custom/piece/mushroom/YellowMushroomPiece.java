package fr.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom;

import com.mojang.datafixers.util.Pair;
import fr.rodofire.ewc.blockdata.blocklist.DividedBlockListManager;
import fr.rodofire.ewc.blockdata.layer.BlockLayer;
import fr.rodofire.ewc.blockdata.layer.BlockLayerManager;
import fr.rodofire.ewc.shape.block.MultiChunkFeaturesHandler;
import fr.rodofire.ewc.shape.block.gen.LineGen;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.shape.block.layer.LayerManager;
import fr.rodofire.ewc.shape.block.placer.LayerPlacer;
import fr.rodofire.ewc.shape.block.rotations.Rotator;
import fr.rodofire.ewc.structure.MultiChunkFeaturePiece;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.world.structures.ModStructurePieceType;
import fr.rodofire.mushrooomsmod.world.structures.custom.config.mushroom.YellowMushroomGeneratorConfig;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class YellowMushroomPiece extends MultiChunkFeaturePiece {
    Rotator rotator;
    BlockPos end;
    BlockPos center;

    int radius;
    boolean flat;

    BlockLayer capLayer;
    BlockLayer trunkLayer;
    YellowMushroomGeneratorConfig config;

    public YellowMushroomPiece(BoundingBox boundingBox, YellowMushroomGeneratorConfig config, ResourceLocation structureReference, Set<ChunkPos> chunkPosSet) {
        super(ModStructurePieceType.YELLOW_MUSHROOM.get(), 0, boundingBox, structureReference, chunkPosSet);
        this.rotator = config.rotator();
        this.end = config.end();
        this.center = config.start();
        this.radius = config.radius();
        this.flat = config.flat();
        this.config = config;
    }

    public YellowMushroomPiece(CompoundTag nbt) {
        super(ModStructurePieceType.YELLOW_MUSHROOM.get(), nbt);
        this.config = getGeneratorConfig(nbt, YellowMushroomGeneratorConfig.CODEC);
        this.center = config.start();
        this.radius = config.radius();
        this.flat = config.flat();
        this.end = config.end();
        this.rotator = config.rotator();
    }

    public YellowMushroomPiece(StructurePieceSerializationContext structureContext, CompoundTag nbtCompound) {
        this(nbtCompound);
    }

    @Override
    protected void addAdditionalSaveData(StructurePieceSerializationContext context, CompoundTag nbt) {
        super.addAdditionalSaveData(context, nbt);
        writeGeneratorConfigCodec(nbt, YellowMushroomGeneratorConfig.CODEC, config);
    }

    @Override
    public DividedBlockListManager getDividedStructure(WorldGenLevel structureWorldAccess, StructureManager structureAccessor, ChunkGenerator chunkGenerator, RandomSource random, BoundingBox blockBox, ChunkPos chunkPos, BlockPos blockPos) {
        MultiChunkFeaturesHandler.add(structureWorldAccess, Set.of(chunkPos), this.featureId);

        this.capLayer = new BlockLayer(
                LayerPlacer.ofRandom(random),
                List.of(ModBlocks.YELLOW_MUSHROOM_BLOCK.get().defaultBlockState(), ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK.get().defaultBlockState()),
                List.of((short) 2, (short) 1)
        );
        this.trunkLayer = new BlockLayer(
                LayerPlacer.ofRandom(random),
                Blocks.MUSHROOM_STEM.defaultBlockState()
        );

        DividedBlockListManager dividedManager = getCap(random);
        dividedManager.put(getTrunk(random));
        return dividedManager;
    }

    @Override
    public @Nullable Pair<Map<ChunkPos, LongOpenHashSet>, LayerManager> getStructurePair(WorldGenLevel structureWorldAccess, StructureManager structureAccessor, ChunkGenerator chunkGenerator, RandomSource random, BoundingBox blockBox, ChunkPos chunkPos, BlockPos blockPos) {
        return null;
    }

    public DividedBlockListManager getTrunk(RandomSource random) {
        LineGen line = new LineGen(center, end);
        Map<ChunkPos, LongOpenHashSet> trunkCoordinates = line.getShapeCoordinates();
        Direction[] directions = {Direction.SOUTH, Direction.EAST, Direction.NORTH, Direction.WEST};

        for (int i = 0; i < 4; i++) {
            line = new LineGen(center.above(random.nextIntBetweenInclusive(-1, 1)), end.above(random.nextIntBetweenInclusive(-1, 1)));
            Map<ChunkPos, LongOpenHashSet> intermediateCoordinates = line.getShapeCoordinates();

            intermediateCoordinates.forEach((chunkPos, set) -> trunkCoordinates.computeIfAbsent(chunkPos, k -> new LongOpenHashSet()).addAll(set));

            for (Direction direction : directions) {
                line = new LineGen(center.relative(direction).above(random.nextIntBetweenInclusive(-1, 1)), end.relative(direction).above(random.nextIntBetweenInclusive(-1, 1)));
                Map<ChunkPos, LongOpenHashSet> additionalCoordinates = line.getShapeCoordinates();

                additionalCoordinates.forEach((chunkPos, set) -> trunkCoordinates.computeIfAbsent(chunkPos, k -> new LongOpenHashSet()).addAll(set));
            }
        }

        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE, new BlockLayerManager(trunkLayer));
        return layerManager.getDivided(trunkCoordinates);
    }

    public DividedBlockListManager getCap(RandomSource random) {
        Rotator maskRotator = new Rotator(end.below(this.radius), 0, this.rotator.getZRotation(), this.rotator.getSecondYRotation());

        SphereGen cap = new SphereGen(end.below(this.radius / 2), this.flat ? this.radius * 2 : (int) (this.radius * 1.5f));
        SphereGen capMask = new SphereGen(end.below(this.radius), this.flat ? (int) ((2 + (float) random.nextIntBetweenInclusive(0, 4) / 10) * (this.radius - 0.75f)) : (int) ((1.5 + (float) random.nextIntBetweenInclusive(0, 5) / 10) * (this.radius - 1)));

        cap.setRadiusY(this.radius);
        cap.setRotator(rotator);
        capMask.setRadiusY(this.radius);
        capMask.setRotator(maskRotator);

        Map<ChunkPos, LongOpenHashSet> capCoordinates = cap.getShapeCoordinates();
        Map<ChunkPos, LongOpenHashSet> maskCoordinates = capMask.getShapeCoordinates();
        capCoordinates.forEach((coordinatesChunkPos, set) -> {
            LongSet maskedSet = maskCoordinates.get(coordinatesChunkPos);
            if (maskedSet == null) return;

            set.removeAll(maskCoordinates.get(coordinatesChunkPos));
        });

        LayerManager layerManager = new LayerManager(LayerManager.Type.SURFACE, new BlockLayerManager(capLayer));
        return layerManager.getDivided(capCoordinates);
    }
}
