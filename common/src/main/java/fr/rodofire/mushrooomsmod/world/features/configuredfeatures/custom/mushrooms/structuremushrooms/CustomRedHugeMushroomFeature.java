package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.structuremushrooms;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.structure.NbtPlacer;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;

public class CustomRedHugeMushroomFeature extends CustomRedHugeMushroom {
    public CustomRedHugeMushroomFeature(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }


    @Override
    protected Integer[] trunkPlace(BlockPos start, int large, BlockPos.MutableBlockPos mutable, LevelAccessor world, ModMushroomFeatureConfig config, RandomSource random) {
        int trunkheight = random.nextIntBetweenInclusive(2, 5);
        int randx = 0;
        int randz = 0;

        BlockState blockstate = config.stemProvider.getState(random, mutable);

        if (trunkheight > 2) {
            randx = random.nextIntBetweenInclusive(-1, 1);
            randz = random.nextIntBetweenInclusive(-1, 1);
            while (randx == 0 && randz == 0) {
                randx = random.nextIntBetweenInclusive(-1, 1);
                randz = random.nextIntBetweenInclusive(-1, 1);
            }
        }

        if (!canGenerate(large, new Integer[]{randx, randz, trunkheight - 2}, world, start, mutable))
            return new Integer[]{0};

        for (int j = 0; j < 2; ++j) {
            mutable.setWithOffset(start, 0, j, 0);
            this.setBlock(world, mutable, blockstate);
        }
        for (int i = 2; i <= trunkheight; ++i) {
            mutable.setWithOffset(start, randx, i, randz);
            this.setBlock(world, mutable, blockstate);
        }

        return new Integer[]{randx, trunkheight, randz};
    }


    @Override
    protected boolean capPlacer(BlockPos start, int large, BlockPos.MutableBlockPos mutable, LevelAccessor world, ModMushroomFeatureConfig config, Integer[] coordinates, RandomSource random) {
        int large1;
        int randx = coordinates[0];
        int height1 = coordinates[1];
        int randz = coordinates[2];
        int rotation = random.nextInt(4);
        int randomcapnumber = random.nextInt(3) + 1;

        String path = "red_cap/red_cap_" + large + "_" + randomcapnumber;
        Rotation blockRotation;

        start = start.offset(randx, height1 + 1, randz);

        switch (rotation) {
            case 0:
                blockRotation = Rotation.NONE;
                large = -large;
                large1 = large;
                break;
            case 1:
                blockRotation = Rotation.CLOCKWISE_90;
                large1 = -large;
                break;
            case 2:
                blockRotation = Rotation.CLOCKWISE_180;
                large1 = large;
                break;
            default:
                blockRotation = Rotation.COUNTERCLOCKWISE_90;
                large1 = large;
                large = -large;
                break;
        }
        if (!world.isClientSide()) {
            NbtPlacer structure = new NbtPlacer((ServerLevel) world, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, path));
            structure.place(1.0f, start, new BlockPos(large, 0, large1), Mirror.NONE, blockRotation,true);
        }
        return true;
    }

    protected boolean canGenerate(int large, Integer[] coordinates, LevelAccessor world, BlockPos pos, BlockPos.MutableBlockPos mutable) {
        int randx = coordinates[0];
        int randz = coordinates[1];
        int height1 = coordinates[2];
        int height;

        if (large == 1) height = 7;
        else if (large == 2) height = 9;
        else height = 15;

        for (int i = 0; i < 2; ++i) {
            BlockState blockState2 = world.getBlockState(pos);
            pos = pos.above();
            if (blockState2.isAir() || blockState2.is(BlockTags.LEAVES)) continue;
            return false;
        }

        for (int i = 0; i < height1; ++i) {
            mutable.setWithOffset(pos, randx, i + 2, randz);
            BlockState blockState2 = world.getBlockState(pos);
            if (blockState2.isAir() || blockState2.is(BlockTags.LEAVES)) continue;
            return false;
        }

        for (int i = 0; i < height; ++i) {
            for (int j = -large; j <= large; ++j) {
                for (int k = -large; k <= large; ++k) {
                    mutable.setWithOffset(pos, j, i + height1, k);
                    BlockState blockState2 = world.getBlockState(mutable);
                    if (blockState2.isAir() || blockState2.is(BlockTags.LEAVES)) continue;
                    return false;
                }
            }
        }
        return true;
    }


}
