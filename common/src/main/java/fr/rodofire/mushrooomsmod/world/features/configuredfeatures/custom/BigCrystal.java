package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.maths.FastMaths;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.ewc.shape.block.simplegen.GenLines;
import fr.rodofire.ewc.shape.block.simplegen.GenSpheres;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import fr.rodofire.mushrooomsmod.world.features.config.ModSimpleBlockFeatureConfig;

public class BigCrystal extends Feature<ModSimpleBlockFeatureConfig> {

    public BigCrystal(Codec<ModSimpleBlockFeatureConfig> configCodec) {
        super(configCodec);
    }


    @Override
    public boolean place(FeaturePlaceContext<ModSimpleBlockFeatureConfig> context) {
        RandomSource random = context.random();
        BlockPos pos = context.origin();
        if (random.nextIntBetweenInclusive(0, 4) == 0) {
            BlockPos secondPos = pos.offset(random.nextIntBetweenInclusive(1, 16) * MathUtil.getRandomOpposite(random), random.nextIntBetweenInclusive(6, 30) * MathUtil.getRandomOpposite(random), random.nextIntBetweenInclusive(1, 16) * MathUtil.getRandomOpposite(random));
            BlockPos thirdPos = pos.offset(random.nextIntBetweenInclusive(1, 16) * MathUtil.getRandomOpposite(random), random.nextIntBetweenInclusive(6, 30) * MathUtil.getSign(secondPos.getY()), random.nextIntBetweenInclusive(1, 16) * MathUtil.getRandomOpposite(random));

            ModSimpleBlockFeatureConfig config = context.config();
            WorldGenLevel world = context.level();
            BlockState state = config.blockprovider.getState(random, pos);
            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

            mutable.set(pos);

            BlockPos middleState = new BlockPos((secondPos.getX() + pos.getX()) / 2, (secondPos.getY() + pos.getY()) / 2, (secondPos.getZ() + pos.getZ()) / 2);
            BlockPos secondMiddleState = new BlockPos((thirdPos.getX() + pos.getX()) / 2, (thirdPos.getY() + pos.getY()) / 2, (thirdPos.getZ() + pos.getZ()) / 2);
            BlockState state1 = world.getBlockState(pos);
            BlockState state2 = world.getBlockState(middleState);
            BlockState state3 = world.getBlockState(secondMiddleState);

            if (!generatePillar(secondPos, pos, state2, state1, world, mutable, state, random)) return false;
            return generatePillar(thirdPos, pos, state3, state1, world, mutable, state, random);
        } else {
            BlockPos secondpos = pos.offset(random.nextIntBetweenInclusive(1, 16) * MathUtil.getRandomOpposite(random), random.nextIntBetweenInclusive(6, 30) * MathUtil.getRandomOpposite(random), random.nextIntBetweenInclusive(1, 16) * MathUtil.getRandomOpposite(random));

            ModSimpleBlockFeatureConfig config = context.config();
            WorldGenLevel world = context.level();
            BlockState state = config.blockprovider.getState(random, pos);
            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

            mutable.set(pos);

            BlockPos middlestate = new BlockPos((secondpos.getX() + pos.getX()) / 2, (secondpos.getY() + pos.getY()) / 2, (secondpos.getZ() + pos.getZ()) / 2);
            BlockState state1 = world.getBlockState(pos);
            BlockState state2 = world.getBlockState(middlestate);
            return this.generatePillar(secondpos, pos, state2, state1, world, mutable, state, random);
        }
    }

    private boolean generatePillar(BlockPos secondpos, BlockPos pos, BlockState state2, BlockState state1, WorldGenLevel world, BlockPos.MutableBlockPos mutable, BlockState state, RandomSource random) {
        Direction direction;
        if (secondpos.getY() - pos.getY() > 0) direction = Direction.DOWN;
        else direction = Direction.UP;

        if (!state2.isAir()) return false;
        if (state1.isAir() && world.getBlockState(mutable.below()).isAir() && world.getBlockState(mutable.above()).isAir())
            return false;

        //create a round base
        int baseLarge = random.nextIntBetweenInclusive(2, 5);
        for (int i = 1; i <= baseLarge; i++) {
            for (float j = (float) 0; j < 360; j += (float) 45 / i) {
                int x = (int) ((i) * FastMaths.getFastCos(j));
                int z = (int) ((i) * FastMaths.getFastSin(j));
                mutable.setWithOffset(pos, x, 0, z);
                world.setBlock(mutable, state, 2);

                GenLines.drawLine(world, mutable, secondpos, state);
            }
        }
        GenSpheres.generateHalfFullSphere(world, baseLarge, pos, direction, state);
        return true;
    }

}
