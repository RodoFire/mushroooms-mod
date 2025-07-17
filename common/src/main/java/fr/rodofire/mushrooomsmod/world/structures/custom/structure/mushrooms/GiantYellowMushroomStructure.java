package fr.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms;

import com.mojang.serialization.MapCodec;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.shape.block.rotations.Rotator;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.world.structures.ModStructureTypes;
import fr.rodofire.mushrooomsmod.world.structures.custom.config.mushroom.GiantYellowMushroomGeneratorConfig;
import fr.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom.GiantYellowMushroomPiece;

import java.util.Set;
import java.util.stream.Collectors;

public class GiantYellowMushroomStructure extends MushrooomsModStructure {
    public static final MapCodec<GiantYellowMushroomStructure> CODEC = simpleCodec(GiantYellowMushroomStructure::new);

    public GiantYellowMushroomStructure(StructureSettings config) {
        super(config);
    }


    @Override
    protected void getPieces(StructurePiecesBuilder builder, BlockPos pos, GenerationContext context) {
        RandomSource random = context.random();
        BlockPos end = pos.offset(random.nextIntBetweenInclusive(-8, 8), random.nextIntBetweenInclusive(50, 80), random.nextIntBetweenInclusive(-8, 8));

        int down = random.nextIntBetweenInclusive(1, 3);
        int radius = random.nextIntBetweenInclusive(20, 32);
        SphereGen sphereGen = new SphereGen(end, radius);
        sphereGen.setRadiusY(random.nextIntBetweenInclusive(4, 7));


        int rot1 = random.nextIntBetweenInclusive(-10, 10);
        int rot2 = random.nextIntBetweenInclusive(0, 360);
        Rotator rotator = new Rotator(end, 0, rot1, rot2);
        sphereGen.setRotator(rotator);


        int heightMask = random.nextIntBetweenInclusive(down + 2, down + 6);
        SphereGen mask = new SphereGen(end.below(heightMask), random.nextIntBetweenInclusive(19, radius));
        mask.setRadiusY(heightMask);

        Rotator rotatorMask = new Rotator(end.below(heightMask - down), 0, rot1, rot2);
        mask.setRotator(rotatorMask);

        LongOpenHashSet covered = sphereGen.getCoveredChunks();

        GiantYellowMushroomGeneratorConfig config = new GiantYellowMushroomGeneratorConfig(sphereGen, mask, pos, end);

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "giant_yellow_mushroom_" + random.nextLong());
        Set<ChunkPos> chunkPosSet = covered.longStream().mapToObj(ChunkPos::new).collect(Collectors.toSet());
        for (long encodedChunkPos : covered) {
            ChunkPos chunkPos = new ChunkPos(encodedChunkPos);

            BoundingBox blockBox = new BoundingBox(chunkPos.getMinBlockX(), 0, chunkPos.getMinBlockZ(), chunkPos.getMinBlockX() + 16, 300, chunkPos.getMinBlockZ() + 16);
            builder.addPiece(new GiantYellowMushroomPiece(blockBox, id, chunkPosSet, config));
        }

    }

    @Override
    public StructureType<?> type() {
        return ModStructureTypes.GIANT_YELLOW_MUSHROOM;
    }
}
