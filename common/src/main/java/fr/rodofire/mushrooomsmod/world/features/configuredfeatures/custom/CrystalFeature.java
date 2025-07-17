package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import fr.rodofire.mushrooomsmod.block.custom.StraightCrystal;
import fr.rodofire.mushrooomsmod.world.features.config.CrystalConfig;


public class CrystalFeature extends Feature<CrystalConfig> {
    public CrystalFeature(Codec<CrystalConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<CrystalConfig> context) {
        CrystalConfig config = context.config();
        WorldGenLevel world = context.level();
        BlockPos pos = context.origin();
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        mutable.set(pos);
        RandomSource random = world.getRandom();

        int width = config.spreadwidth;
        int maxheight = config.maxheight;
        BlockState blockState = config.blockprovider.getState(random, pos);

        for (int i = 0; i<width; i++) {
            mutable.set(pos);
            mutable.move(random.nextIntBetweenInclusive(-width, width), random.nextIntBetweenInclusive(-width, width), random.nextIntBetweenInclusive(-width, width));
            Direction direction = getDirection(world, mutable);
            if (direction == null) continue;
            maxheight = getHeight(world, mutable, direction, maxheight);
            if (maxheight <= 0) continue;
            int height = random.nextIntBetweenInclusive(1, maxheight);
            generateColumn(world, mutable, direction, height, blockState);
        }
        return true;
    }

    public Direction getDirection(WorldGenLevel world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (world.getBlockState(pos.below()).isSolidRender(world, pos.below()) && state.isAir()) return Direction.UP;
        if (world.getBlockState(pos.above()).isSolidRender(world, pos.above()) && state.isAir()) return Direction.DOWN;
        return null;
    }

    public int getHeight(WorldGenLevel world, BlockPos pos, Direction direction, int maxheight) {
        for (int i = 0 ; i<maxheight;++i){
            if (world.getBlockState(pos.relative(direction, i)).isAir()) continue;
            return i;
        }
        return maxheight-1;
    }

    public void generateColumn(WorldGenLevel world, BlockPos pos, Direction direction, int maxheight, BlockState state) {
        for (int i = 0 ; i<maxheight;++i){
            world.setBlock(pos.relative(direction, i), state.setValue(StraightCrystal.VERTICAL_DIRECTION, direction).setValue(StraightCrystal.STAGE, 1), 2);
        }
        world.setBlock(pos.relative(direction, maxheight), state.setValue(StraightCrystal.VERTICAL_DIRECTION, direction).setValue(StraightCrystal.STAGE, 0), 2);
    }
}
