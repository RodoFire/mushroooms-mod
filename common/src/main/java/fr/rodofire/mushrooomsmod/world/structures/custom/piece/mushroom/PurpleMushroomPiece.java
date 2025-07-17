package fr.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom;

import com.mojang.datafixers.util.Pair;
import fr.rodofire.ewc.blockdata.blocklist.DividedBlockListManager;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.ewc.shape.block.layer.LayerManager;
import fr.rodofire.ewc.structure.MultiChunkFeaturePiece;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.world.structures.ModStructurePieceType;
import fr.rodofire.mushrooomsmod.world.structures.custom.config.mushroom.PurpleMushroomGeneratorConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

public class PurpleMushroomPiece extends MultiChunkFeaturePiece {
    PurpleMushroomGeneratorConfig config;
    BlockPos[] end;
    DividedBlockListManager dividedManager;
    RandomSource random;


    public PurpleMushroomPiece(PurpleMushroomGeneratorConfig config, BoundingBox boundingBox, ResourceLocation featureId, Set<ChunkPos> chunkPosSet) {
        super(ModStructurePieceType.PURPLE_MUSHROOM.get(), 0, boundingBox, featureId, chunkPosSet);
        this.config = config;
        this.dividedManager = config.trunk();
        this.end = config.end();
    }

    public PurpleMushroomPiece(CompoundTag nbt) {
        super(ModStructurePieceType.PURPLE_MUSHROOM.get(), nbt);
        this.config = getGeneratorConfig(nbt, PurpleMushroomGeneratorConfig.CODEC);
        this.dividedManager = config.trunk();
        this.end = config.end();
    }

    public PurpleMushroomPiece(StructurePieceSerializationContext structureContext, CompoundTag nbtCompound) {
        this(nbtCompound);
    }

    @Override
    protected void addAdditionalSaveData(StructurePieceSerializationContext context, CompoundTag nbt) {
        super.addAdditionalSaveData(context, nbt);
        writeGeneratorConfigCodec(nbt, PurpleMushroomGeneratorConfig.CODEC, config);
    }

    @Override
    public @Nullable DividedBlockListManager getDividedStructure(WorldGenLevel structureWorldAccess, StructureManager structureAccessor, ChunkGenerator chunkGenerator, RandomSource random, BoundingBox blockBox, ChunkPos chunkPos, BlockPos blockPos) {
        this.random = random;
        getCap();

        return dividedManager;
    }

    void getCap() {
        for (int i = 0; i < end.length; i++) {
            getCapCoordinates(end[i]);
        }
    }

    protected void getCapCoordinates(BlockPos pos) {
        int height = random.nextIntBetweenInclusive(2, 3);
        int radius = getRadius();


        for (int i = -radius; i <= radius; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = -radius; k <= radius; k++) {
                    BlockState state = MathUtil.getRandomBoolean(random, 0.6f) ? ModBlocks.PURPLE_MUSHROOM_BLOCK.get().defaultBlockState() : (MathUtil.getRandomBoolean(random, 0.3f) ? ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK.get().defaultBlockState() : ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK.get().defaultBlockState());
                    if (j < 2) {
                        boolean maxim1 = Math.abs(i) == radius - 1;
                        boolean maxkm1 = Math.abs(k) == radius - 1;
                        boolean maxi = Math.abs(i) == radius;
                        boolean maxk = Math.abs(k) == radius;
                        boolean secondmaxi = Math.abs(i) >= radius - 3;
                        boolean secondmaxk = Math.abs(k) >= radius - 3;
                        if ((maxi && secondmaxk) || (maxk && secondmaxi) || (maxim1 && maxkm1)) continue;
                        dividedManager.put(state, pos.offset(i, j, k));

                    }//Smaller Base
                    else {
                        boolean maxim2 = Math.abs(i) == radius - 2;
                        boolean maxkm2 = Math.abs(k) == radius - 2;
                        boolean maxim1 = Math.abs(i) == radius - 1;
                        boolean maxkm1 = Math.abs(k) == radius - 1;
                        boolean maxi = Math.abs(i) == radius;
                        boolean maxk = Math.abs(k) == radius;
                        boolean secondmaxi = Math.abs(i) >= radius - 3;
                        boolean secondmaxk = Math.abs(k) >= radius - 3;
                        if (maxi || maxk || maxim2 && maxkm2 || maxim1 && secondmaxk || maxkm1 && secondmaxi)
                            continue;
                        dividedManager.put(state, pos.offset(i, j, k));
                    }
                }
            }
        }
    }

    public int getRadius() {
        return random.nextIntBetweenInclusive(2, 7);
    }

    @Override
    public @Nullable Pair<Map<ChunkPos, LongOpenHashSet>, LayerManager> getStructurePair(WorldGenLevel structureWorldAccess, StructureManager structureAccessor, ChunkGenerator chunkGenerator, RandomSource random, BoundingBox blockBox, ChunkPos chunkPos, BlockPos blockPos) {
        return null;
    }
}
