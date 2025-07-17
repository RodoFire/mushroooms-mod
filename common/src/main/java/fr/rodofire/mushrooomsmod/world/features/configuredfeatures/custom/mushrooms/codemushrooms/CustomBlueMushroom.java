package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.blocklist.BlockList;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import fr.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;

public abstract class CustomBlueMushroom extends Feature<ModMushroomFeatureConfig> {
    public CustomBlueMushroom(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    public boolean canPlace(WorldGenLevel world, BlockPos pos, int large, int height) {
        for (int i = -large + 4; i <= large - 4; i++) {
            for (int j = -height + 1; j <= height; j++) {
                for (int k = -large + 2; k <= large - 2; k++) {
                    BlockState state = world.getBlockState(pos.offset(i, j, k));
                    if (state.isAir()) {
                        continue;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean place(FeaturePlaceContext<ModMushroomFeatureConfig> context) {
        WorldGenLevel worldAccess = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();
        BlockState trunk = context.config().stemProvider.getState(random, pos);
        BlockState cap = context.config().capProvider.getState(random, pos);

        int height = random.nextIntBetweenInclusive(10, 20);
        int secondheight = 0;
        if (random.nextBoolean()) {
            secondheight = random.nextIntBetweenInclusive(2, 5);
        }
        int minlarge = random.nextIntBetweenInclusive(2, 3);
        int maxlarge = random.nextIntBetweenInclusive(minlarge + 2, minlarge + 3);
        int large = random.nextIntBetweenInclusive(maxlarge + 6, maxlarge + 10);
        int heightCap = random.nextIntBetweenInclusive(3, maxlarge);

        if (!worldAccess.getBlockState(pos.below()).is(BlockTags.DIRT)) return false;
        if (!this.canPlace(worldAccess, pos.offset(0, height + secondheight, 0), large, heightCap)) return false;
        BlockList blockLists = this.generateLargeTrunk(worldAccess, random, pos, trunk, false, height + secondheight - 1, maxlarge, minlarge);
        this.generateLargeCap(worldAccess, random, pos.offset(0, height + secondheight, 0), maxlarge, cap, large, heightCap, blockLists, secondheight + height);


        return true;
    }


    public abstract void generateLargeCap(WorldGenLevel world, RandomSource random, BlockPos pos, int maxlarge, BlockState state, int large, int height, BlockList blockLists, int yOffset);
    public abstract BlockList generateLargeTrunk(WorldGenLevel world, RandomSource random, BlockPos pos, BlockState trunk, boolean force, int height, int maxlarge, int minlarge);
}
