package fr.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms;

import com.mojang.serialization.MapCodec;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.ewc.shape.block.gen.LineGen;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.shape.block.rotations.Rotator;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import it.unimi.dsi.fastutil.longs.LongSet;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.world.structures.ModStructureTypes;
import fr.rodofire.mushrooomsmod.world.structures.custom.config.mushroom.YellowMushroomGeneratorConfig;
import fr.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom.YellowMushroomPiece;

import java.util.Set;
import java.util.stream.Collectors;

public class YellowMushroomStructure extends MushrooomsModStructure {
    public static final MapCodec<YellowMushroomStructure> CODEC = simpleCodec(YellowMushroomStructure::new);

    public YellowMushroomStructure(StructureSettings config) {
        super(config);
    }


    @Override
    protected void getPieces(StructurePiecesBuilder builder, BlockPos pos, GenerationContext context) {
        RandomSource random = context.random();
        boolean flatCap = MathUtil.getRandomBoolean(random, 0.33f);
        int height = random.nextIntBetweenInclusive(12, 22);
        int large = random.nextIntBetweenInclusive(4, flatCap ? 9 : 10);

        int maxXOffset = 10;
        int maxZOffset = 10;

        BlockPos end = pos.offset(random.nextIntBetweenInclusive(-height * maxXOffset / 30, height * maxXOffset / 30), height, random.nextIntBetweenInclusive(-height * maxZOffset / 30, height * maxZOffset) / 30);
        LineGen lineGen = new LineGen(pos, end);


        int rot1 = random.nextIntBetweenInclusive(0, 30);
        int rot2 = random.nextIntBetweenInclusive(0, 360);

        Rotator rotator = new Rotator(end.below(large / 2), 0, rot1, rot2);

        SphereGen sphereGen = new SphereGen(end.below(large / 2), flatCap ? large * 2 : (int) (large * 1.5f));
        sphereGen.setRadiusY(large);
        sphereGen.setRotator(rotator);

        LongSet covered = lineGen.getCoveredChunks();
        covered.addAll(sphereGen.getCoveredChunks());

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "yellow_mushroom_" + random.nextLong());
        Set<ChunkPos> chunkPosSet = covered.longStream().mapToObj(ChunkPos::new).collect(Collectors.toSet());

        YellowMushroomGeneratorConfig config1 = new YellowMushroomGeneratorConfig(pos, end, flatCap, large, rotator);

        for (long encodedChunkPos : covered) {
            ChunkPos chunkPos = new ChunkPos(encodedChunkPos);

            builder.addPiece(new YellowMushroomPiece(
                    new BoundingBox(chunkPos.getMinBlockX(), 0, chunkPos.getMinBlockZ(), chunkPos.getMinBlockX() + 16, 300, chunkPos.getMinBlockZ() + 16),
                    config1,
                    id,
                    chunkPosSet
            ));
        }

    }

    @Override
    public StructureType<?> type() {
        return ModStructureTypes.YELLOW_MUSHROOM;
    }
}
