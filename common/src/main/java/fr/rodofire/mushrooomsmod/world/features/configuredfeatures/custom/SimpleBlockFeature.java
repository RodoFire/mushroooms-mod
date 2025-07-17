package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import fr.rodofire.mushrooomsmod.world.features.config.ModSimpleBlockFeatureConfig;

public class SimpleBlockFeature extends Feature<ModSimpleBlockFeatureConfig> implements FeatureConfiguration {
    public SimpleBlockFeature(Codec<ModSimpleBlockFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<ModSimpleBlockFeatureConfig> context) {
        WorldGenLevel world = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();
        BlockState blockState = context.config().blockprovider.getState(random, pos);
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        for (int i = 0; i < 81; i++) {
            mutable.set(pos).move(random.nextIntBetweenInclusive(-9, 9), random.nextIntBetweenInclusive(-9, 9), random.nextIntBetweenInclusive(-9, 9));
            if (!world.getBlockState(mutable).isAir() || !blockState.canSurvive(world, mutable)) continue;
            world.setBlock(mutable, blockState, 2);
        }
        return true;
    }
}
