package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TwistingVinesConfig;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.block.custom.BlueLuminescentVines;

public class BlueLuminescentVinesFeature extends Feature<TwistingVinesConfig> {
    public BlueLuminescentVinesFeature(Codec<TwistingVinesConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<TwistingVinesConfig> context) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        BlockPos.MutableBlockPos secondmutable = new BlockPos.MutableBlockPos();
        RandomSource random = context.random();
        BlockPos pos = context.origin();
        WorldGenLevel world = context.level();
        TwistingVinesConfig config = context.config();

        int randomheight;
        int maxheight;
        int i = config.spreadWidth();

        mutable.set(pos);
        for (int a = 0; a <= i * i; ++a) {
            mutable.set(pos).move(random.nextIntBetweenInclusive(-i, i), randomheight = random.nextIntBetweenInclusive(3, config.maxHeight()), random.nextIntBetweenInclusive(-i, i));
            secondmutable.set(mutable);
            if ((maxheight = canGenerate(randomheight, secondmutable, world)) == 0) continue;
            if (maxheight < randomheight) randomheight = random.nextIntBetweenInclusive(0, maxheight);
            generateColumn(randomheight, world, mutable);
        }


        return true;
    }

    private static void generateColumn(int randomheight, WorldGenLevel world, BlockPos.MutableBlockPos mutable) {
        int state;
        if (randomheight <= 4) {
            for (int i = 0; i < randomheight; ++i) {
                state = randomheight - i - 1;
                world.setBlock(mutable, ModBlocks.CAERULEA_VOLUBILIS.get().defaultBlockState().setValue(BlueLuminescentVines.STAGE, state), Block.UPDATE_CLIENTS);
                mutable.move(Direction.UP);
            }
        } else {
            for (int i = 0; i <= randomheight; ++i) {
                state = randomheight - i;
                if (state == randomheight) state = 4;
                else if (state == randomheight - 1) state = 3;
                else if (state == randomheight - 2) state = 2;
                else if (state == 0) state = 0;
                else state = 1;
                world.setBlock(mutable, ModBlocks.CAERULEA_VOLUBILIS.get().defaultBlockState().setValue(BlueLuminescentVines.STAGE, state), Block.UPDATE_CLIENTS);
                mutable.move(Direction.UP);
            }
        }
    }

    public static int canGenerate(int height, BlockPos.MutableBlockPos mutable, WorldGenLevel world) {
        if (!canBePlaced(mutable, world)) return 0;
        for (int i = 0; i < height; ++i) {
            mutable.move(Direction.UP);
            if (world.isOutsideBuildHeight(mutable)) return i;
            if (world.isEmptyBlock(mutable)) continue;
            return i;
        }
        return height;
    }

    public static boolean canBePlaced(BlockPos.MutableBlockPos mutable, WorldGenLevel world) {
        return world.getBlockState(mutable.below()).is(ModBlocks.BLUE_LUMINESCENT_SCHROOM_DEEPSLATE.get());
    }
}
