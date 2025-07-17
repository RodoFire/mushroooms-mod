package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.world.features.config.FleurBerriesConfig;

public class FleurBerriesFeature extends Feature<FleurBerriesConfig> {
    public FleurBerriesFeature(Codec<FleurBerriesConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<FleurBerriesConfig> context) {
        WorldGenLevel world = context.level();
        BlockState state = ModBlocks.FLEUR_BERRIES.get().defaultBlockState();
        BlockPos pos = context.origin();
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        RandomSource random = context.random();
        FleurBerriesConfig config = context.config();

        for (int a = 0; a <= config.tries(); a++) {
            mutable.setWithOffset(pos, random.nextIntBetweenInclusive(-config.horitontalSpan(), config.horitontalSpan()), random.nextIntBetweenInclusive(-config.verticalSpan(), config.verticalSpan()), random.nextIntBetweenInclusive(-config.horitontalSpan(), config.horitontalSpan()));
            if (state.canSurvive(world, mutable) && world.getBlockState(mutable).isAir() && world.getBlockState(mutable.above()).isAir()) {
                world.setBlock(mutable, state.setValue(BlockStateProperties.AGE_3, random.nextIntBetweenInclusive(0, 3)), 2);
            }
        }
        return true;
    }
}
