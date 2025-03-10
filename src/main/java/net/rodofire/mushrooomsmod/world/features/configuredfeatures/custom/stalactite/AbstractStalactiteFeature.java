package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.stalactite;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.util.BlockPlaceUtil;
import net.rodofire.mushrooomsmod.util.ModTags;
import net.rodofire.mushrooomsmod.world.features.config.StalactiteFeatureConfig;

import java.util.Set;

public abstract class AbstractStalactiteFeature extends Feature<StalactiteFeatureConfig> {
    StructureWorldAccess world;
    BlockPos pos;
    Random random;
    Block[] base;
    BlockState[] basePlace;
    Block[] top;
    BlockState[] topPlace;

    public AbstractStalactiteFeature(Codec<StalactiteFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<StalactiteFeatureConfig> context) {
        world = context.getWorld();
        random = context.getRandom();
        pos = context.getOrigin();
        int tries = context.getConfig().tries();
        base = getBaseBlock();
        top = getTopBlock();

        for (int i = 0; i < tries; i++) {
            BlockPos secondPos = pos.add(random.nextBetween(-15, 15), random.nextBetween(-25, 25), random.nextBetween(-15, 15));
            if (secondPos.getY() < world.getBottomY())
                continue;

            BlockState upState = world.getBlockState(secondPos.up());
            BlockState downState = world.getBlockState(secondPos.down());

            //on vérifie que l'on peut placer le stalactite et que ce ne soit pas un autre stalactite
            if (BlockPlaceUtil.verifyBlock(world, false, Set.of(), secondPos)
                    && (upState.isOpaqueFullCube() || downState.isOpaqueFullCube())
                    && !downState.isIn(ModTags.Blocks.ROCKY_STALACTITE_TOP) && !upState.isIn(ModTags.Blocks.ROCKY_STALACTITE_TOP)
            ) {

                boolean up = upState.isOpaqueFullCube();
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
        basePlace[0] = base[random.nextInt(base.length - 1)].getDefaultState();

        topPlace = new BlockState[1];
        topPlace[0] = top[random.nextInt(top.length - 1)].getDefaultState();
        place(pos, up);
    }

    private void placeBiBlock(BlockPos pos, boolean up) {
        basePlace = new BlockState[2];
        basePlace[0] = base[random.nextBetween(0, base.length - 1)].getDefaultState();
        basePlace[1] = base[random.nextBetween(0, base.length - 1)].getDefaultState();

        topPlace = new BlockState[2];
        topPlace[0] = top[random.nextBetween(0, top.length - 1)].getDefaultState();
        topPlace[1] = top[random.nextBetween(0, top.length - 1)].getDefaultState();
        place(pos, up);
    }


    private void placeRandom(BlockPos pos, boolean up) {
        basePlace = new BlockState[base.length];
        for(int i = 0; i < base.length; i++) {
            basePlace[i] = base[i].getDefaultState();
        }
        topPlace = new BlockState[top.length];
        for(int i = 0; i < top.length; i++) {
            topPlace[i] = top[i].getDefaultState();
        }

        place(pos, up);
    }

    protected void place(BlockPos pos, boolean up) {
        int baseHeight = random.nextBetween(1, 6);
        int topHeight = random.nextBetween(1, 4);

        placePile(pos.add(0, 0, 0), up, baseHeight);
        for (int i = 0; i < topHeight; i++) {
            BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), pos.up(up ? -i - baseHeight : i + baseHeight), top[random.nextBetween(0, top.length - 1)].getDefaultState());
        }

        if (random.nextFloat() < 0.4) {
            int randomSideHeight = random.nextBetween(0, baseHeight - 1);
            if (canPlace(pos.add(1, 0, 0))) {
                placePile(pos.add(1, 0, 0), up, randomSideHeight);
            }

            randomSideHeight = random.nextBetween(0, baseHeight - 1);
            if (canPlace(pos.add(-1, 0, 0))) {
                placePile(pos.add(-1, 0, 0), up, randomSideHeight);
            }
            randomSideHeight = random.nextBetween(0, baseHeight - 1);
            if (canPlace(pos.add(0, 0, -1))) {
                placePile(pos.add(0, 0, -1), up, randomSideHeight);
            }
            randomSideHeight = random.nextBetween(0, baseHeight - 1);
            if (canPlace(pos.add(0, 0, 1))) {
                placePile(pos.add(0, 0, 1), up, randomSideHeight);
            }
        }
    }

    protected abstract Block[] getBaseBlock();

    protected abstract Block[] getTopBlock();

    protected void placePile(BlockPos pos, boolean up, int height) {
        for (int i = 0; i < height; i++) {
            BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(),
                    pos.up(up ? -i : i),
                    basePlace[random.nextBetween(0, basePlace.length - 1)]
            );
        }
    }

    private boolean canPlace(BlockPos pos) {
        boolean canPlace = false;
        for (int i = 0; i > -10 && !canPlace; i--) {
            canPlace = !BlockPlaceUtil.verifyBlock(world, pos.up(i));
        }
        if (canPlace) {
            for (int i = 0; i > -10; i--) {
                if (!BlockPlaceUtil.placeVerifiedBlock(world, false, Set.of(), pos.up(i), basePlace[random.nextBetween(0, basePlace.length - 1)]))
                    break;
            }
        }
        return canPlace;
    }
}
