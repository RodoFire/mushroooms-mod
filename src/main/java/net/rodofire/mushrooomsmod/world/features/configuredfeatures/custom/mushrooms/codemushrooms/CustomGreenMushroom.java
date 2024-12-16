package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;

public abstract class CustomGreenMushroom extends Feature<ModMushroomFeatureConfig> {
    public CustomGreenMushroom(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    protected boolean canGenerate(StructureWorldAccess world, BlockPos pos, int height, BlockPos.Mutable mutablePos, int large) {
        for (int i = 0; i <= height + 1; ++i) {
            mutablePos.set(pos, 0, i, 0);
            BlockState state = world.getBlockState(mutablePos);
            if (!state.isIn(BlockTags.LEAVES) && !state.isAir() && !state.isIn(BlockTags.FLOWERS))
                return false;
        }
        for (int i = height - 1; i <= height + 1; ++i) {
            for (int j = -large; j <= large; ++j) {
                for (int k = -large; k <= large; ++k) {
                    mutablePos.set(pos, j, i, k);
                    BlockState state = world.getBlockState(mutablePos);
                    if (!state.isIn(BlockTags.LEAVES) && !state.isAir() && !state.isIn(BlockTags.FLOWERS))
                        return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<ModMushroomFeatureConfig> context) {
        BlockPos.Mutable mutable;
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        ModMushroomFeatureConfig modMushroomFeatureConfig = context.getConfig();
        boolean bigcap = false;
        int height = Random.create().nextBetween(5, 20);
        int large = Random.create().nextBetween(2, 7);

        if (structureWorldAccess.getBlockState(blockPos).isOf(Blocks.WATER))
            return false;
        if (!structureWorldAccess.getBlockState(blockPos.down()).isIn(BlockTags.MUSHROOM_GROW_BLOCK))
            return false;

        if (!canGenerate(structureWorldAccess, blockPos, height, mutable = new BlockPos.Mutable(), large)) return false;

        this.trunkPlace(blockPos, mutable, structureWorldAccess, modMushroomFeatureConfig, height, random);

        if (Random.create().nextBetween(0, 1) == 0) bigcap = true;

        this.capPlacer(blockPos, mutable, structureWorldAccess, modMushroomFeatureConfig, large, height, random, bigcap);

        return true;
    }

    protected abstract void trunkPlace(BlockPos start, BlockPos.Mutable mutable, StructureWorldAccess world, ModMushroomFeatureConfig config, int height, Random random);

    protected abstract void capPlacer(BlockPos start, BlockPos.Mutable mutable, StructureWorldAccess world, ModMushroomFeatureConfig config, int large, int height, Random random, boolean bigcap);

}
