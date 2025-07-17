package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.stalactite;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.util.BlockPlaceUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import fr.rodofire.mushrooomsmod.util.ModTags;
import fr.rodofire.mushrooomsmod.world.features.config.StalactiteFeatureConfig;

import java.util.Set;

public abstract class AbstractStalactiteFeature extends Feature<StalactiteFeatureConfig> {
    WorldGenLevel world;
    BlockPos pos;
    RandomSource random;
    Block[] base;
    BlockState[] basePlace;
    Block[] top;
    BlockState[] topPlace;

    public AbstractStalactiteFeature(Codec<StalactiteFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<StalactiteFeatureConfig> context) {
        world = context.level();
        random = context.random();
        pos = context.origin();
        int tries = context.config().tries();
        base = getBaseBlock();
        top = getTopBlock();

        for (int i = 0; i < tries; i++) {
            BlockPos secondPos = pos.offset(random.nextIntBetweenInclusive(-14, 14), random.nextIntBetweenInclusive(-25, 25), random.nextIntBetweenInclusive(-14, 14));
            if (secondPos.getY() < world.getMinBuildHeight())
                continue;

            BlockState upState = world.getBlockState(secondPos.above());
            BlockState downState = world.getBlockState(secondPos.below());

            //on vérifie que l'on peut placer le stalactite et que ce ne soit pas un autre stalactite
            if (BlockPlaceUtil.verifyBlock(world, false, Set.of(), secondPos)
                    && (upState.isSolidRender(world, secondPos.above()) || downState.isSolidRender(world, secondPos.below()))
                    && !downState.is(ModTags.Blocks.ROCKY_STALACTITE_TOP) && !upState.is(ModTags.Blocks.ROCKY_STALACTITE_TOP)
            ) {

                boolean up = upState.isSolidRender(world, secondPos.above());
                switch (random.nextInt(3)) {
                    case 0:
                        placeSingularBlock(secondPos, up);
                        break;
                    case 1:
                        placeBiBlock(secondPos, up);
                        break;
                    default:
                        placeRandom(secondPos, up);
                }
            }
        }

        return true;
    }

    private void placeSingularBlock(BlockPos pos, boolean up) {
        basePlace = new BlockState[1];
        basePlace[0] = base[random.nextInt(base.length - 1)].defaultBlockState();

        topPlace = new BlockState[1];
        topPlace[0] = top[random.nextInt(top.length - 1)].defaultBlockState();
        place(pos, up);
    }

    private void placeBiBlock(BlockPos pos, boolean up) {
        basePlace = new BlockState[2];
        basePlace[0] = base[random.nextIntBetweenInclusive(0, base.length - 1)].defaultBlockState();
        basePlace[1] = base[random.nextIntBetweenInclusive(0, base.length - 1)].defaultBlockState();

        topPlace = new BlockState[2];
        topPlace[0] = top[random.nextIntBetweenInclusive(0, top.length - 1)].defaultBlockState();
        topPlace[1] = top[random.nextIntBetweenInclusive(0, top.length - 1)].defaultBlockState();
        place(pos, up);
    }


    private void placeRandom(BlockPos pos, boolean up) {
        basePlace = new BlockState[base.length];
        for(int i = 0; i < base.length; i++) {
            basePlace[i] = base[i].defaultBlockState();
        }
        topPlace = new BlockState[top.length];
        for(int i = 0; i < top.length; i++) {
            topPlace[i] = top[i].defaultBlockState();
        }

        place(pos, up);
    }

    protected void place(BlockPos pos, boolean up) {
        int baseHeight = random.nextIntBetweenInclusive(1, 6);
        int topHeight = random.nextIntBetweenInclusive(1, 4);

        placePile(pos.offset(0, 0, 0), up, baseHeight);
        for (int i = 0; i < topHeight; i++) {
            BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), pos.above(up ? -i - baseHeight : i + baseHeight), top[random.nextIntBetweenInclusive(0, top.length - 1)].defaultBlockState());
        }

        if (random.nextFloat() < 0.4) {
            int randomSideHeight = random.nextIntBetweenInclusive(0, baseHeight - 1);
            if (canPlace(pos.offset(1, 0, 0))) {
                placePile(pos.offset(1, 0, 0), up, randomSideHeight);
            }

            randomSideHeight = random.nextIntBetweenInclusive(0, baseHeight - 1);
            if (canPlace(pos.offset(-1, 0, 0))) {
                placePile(pos.offset(-1, 0, 0), up, randomSideHeight);
            }
            randomSideHeight = random.nextIntBetweenInclusive(0, baseHeight - 1);
            if (canPlace(pos.offset(0, 0, -1))) {
                placePile(pos.offset(0, 0, -1), up, randomSideHeight);
            }
            randomSideHeight = random.nextIntBetweenInclusive(0, baseHeight - 1);
            if (canPlace(pos.offset(0, 0, 1))) {
                placePile(pos.offset(0, 0, 1), up, randomSideHeight);
            }
        }
    }

    protected abstract Block[] getBaseBlock();

    protected abstract Block[] getTopBlock();

    protected void placePile(BlockPos pos, boolean up, int height) {
        for (int i = 0; i < height; i++) {
            BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(),
                    pos.above(up ? -i : i),
                    basePlace[random.nextIntBetweenInclusive(0, basePlace.length - 1)]
            );
        }
    }

    private boolean canPlace(BlockPos pos) {
        boolean canPlace = false;
        for (int i = 0; i > -10 && !canPlace; i--) {
            canPlace = !BlockPlaceUtil.verifyBlock(world, pos.above(i));
        }
        if (canPlace) {
            for (int i = 0; i > -10; i--) {
                if (!BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), pos.above(i), basePlace[random.nextIntBetweenInclusive(0, basePlace.length - 1)]))
                    break;
            }
        }
        return canPlace;
    }
}
