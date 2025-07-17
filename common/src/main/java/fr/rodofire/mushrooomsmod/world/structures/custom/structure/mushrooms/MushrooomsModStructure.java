package fr.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms;

import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

public abstract class MushrooomsModStructure extends Structure {
    protected MushrooomsModStructure(StructureSettings config) {
        super(config);
    }

    @Override
    protected Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        ChunkPos chunkPos = context.chunkPos();
        int x = chunkPos.getMiddleBlockX() + context.random().nextIntBetweenInclusive(-7, 7);
        int z = chunkPos.getMiddleBlockZ() + context.random().nextIntBetweenInclusive(-7, 7);

        int y = context.chunkGenerator().getFirstFreeHeight(x, z, Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor(), context.randomState());

        if (context.chunkGenerator().getSeaLevel() == y) return Optional.empty();

        BlockPos pos = new BlockPos(x, y, z);

        return Optional.of(new GenerationStub(pos, collector -> {
            getPieces(collector, pos, context);
        }));
    }

    protected abstract void getPieces(StructurePiecesBuilder collector, BlockPos pos, GenerationContext context);

    public BoundingBox getBoundingBox(ChunkPos pos) {
        return new BoundingBox(
                pos.getMinBlockX(),
                0,
                pos.getMinBlockZ(),
                pos.getMaxBlockX(),
                128,
                pos.getMaxBlockZ()
        );
    }
}
