package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import fr.rodofire.mushrooomsmod.world.features.config.DirectionConfig;

public class SimpleVinesFeature extends Feature<DirectionConfig> {

    public SimpleVinesFeature(Codec<DirectionConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<DirectionConfig> context) {
        WorldGenLevel world = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();
        Direction direction = context.config().directionprovider;
        BlockState state = context.config().blockprovider.getState(random, pos);
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        for (int a = 0; a < 81; ++a) {
            mutable.set(pos).move(random.nextIntBetweenInclusive(-9, 9), random.nextIntBetweenInclusive(-9, 9), random.nextIntBetweenInclusive(-9, 9));
            int height = random.nextIntBetweenInclusive(0, getMaxHeight(world, mutable, direction));
            if (!state.canSurvive(world, mutable)) continue;
            if (height == 0) continue;
            generateColumn(height, world, mutable, direction, state);
        }
        return true;
    }

    private static void generateColumn(int maxheight, WorldGenLevel world, BlockPos pos, Direction direction, BlockState state) {
        for (int i = 0; i < maxheight; i++) {
            world.setBlock(pos.relative(direction, i), state, 2);
        }
    }

    public int getMaxHeight(WorldGenLevel world, BlockPos pos, Direction direction) {
        for (int i = 0; i < 12; i++) {
            if (world.getBlockState(pos.relative(direction, i)).isAir()) continue;
            return i;
        }
        return 12;
    }
}
