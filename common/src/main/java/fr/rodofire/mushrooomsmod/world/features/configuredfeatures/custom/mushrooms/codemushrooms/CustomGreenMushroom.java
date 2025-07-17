package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import fr.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;

public abstract class CustomGreenMushroom extends Feature<ModMushroomFeatureConfig> {
    public CustomGreenMushroom(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    protected boolean canGenerate(WorldGenLevel world, BlockPos pos, int height, BlockPos.MutableBlockPos mutablePos, int large) {
        for (int i = 0; i <= height + 1; ++i) {
            mutablePos.setWithOffset(pos, 0, i, 0);
            BlockState state = world.getBlockState(mutablePos);
            if (!state.is(BlockTags.LEAVES) && !state.isAir() && !state.is(BlockTags.FLOWERS))
                return false;
        }
        for (int i = height - 1; i <= height + 1; ++i) {
            for (int j = -large; j <= large; ++j) {
                for (int k = -large; k <= large; ++k) {
                    mutablePos.setWithOffset(pos, j, i, k);
                    BlockState state = world.getBlockState(mutablePos);
                    if (!state.is(BlockTags.LEAVES) && !state.isAir() && !state.is(BlockTags.FLOWERS))
                        return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean place(FeaturePlaceContext<ModMushroomFeatureConfig> context) {
        BlockPos.MutableBlockPos mutable;
        WorldGenLevel structureWorldAccess = context.level();
        BlockPos blockPos = context.origin();
        RandomSource random = context.random();
        ModMushroomFeatureConfig modMushroomFeatureConfig = context.config();
        boolean bigcap = false;
        int height = random.nextIntBetweenInclusive(5, 20);
        int large = random.nextIntBetweenInclusive(2, 7);

        if (structureWorldAccess.getBlockState(blockPos).is(Blocks.WATER))
            return false;
        if (!structureWorldAccess.getBlockState(blockPos.below()).is(BlockTags.MUSHROOM_GROW_BLOCK))
            return false;

        if (!canGenerate(structureWorldAccess, blockPos, height, mutable = new BlockPos.MutableBlockPos(), large)) return false;

        this.trunkPlace(blockPos, mutable, structureWorldAccess, modMushroomFeatureConfig, height, random);

        if (random.nextIntBetweenInclusive(0, 1) == 0) bigcap = true;

        this.capPlacer(blockPos, mutable, structureWorldAccess, modMushroomFeatureConfig, large, height, random, bigcap);

        return true;
    }

    protected abstract void trunkPlace(BlockPos start, BlockPos.MutableBlockPos mutable, WorldGenLevel world, ModMushroomFeatureConfig config, int height, RandomSource random);

    protected abstract void capPlacer(BlockPos start, BlockPos.MutableBlockPos mutable, WorldGenLevel world, ModMushroomFeatureConfig config, int large, int height, RandomSource random, boolean bigcap);

}
