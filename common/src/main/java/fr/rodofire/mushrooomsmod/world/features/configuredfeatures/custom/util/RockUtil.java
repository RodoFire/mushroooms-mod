package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.util;

import fr.rodofire.ewc.blockdata.layer.BlockLayer;
import fr.rodofire.ewc.maths.MathUtil;
import fr.rodofire.ewc.shape.block.placer.LayerPlacer;
import fr.rodofire.ewc.util.FastNoiseLite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class RockUtil {
    private static final BlockState[] STATES = new BlockState[]{Blocks.COBBLESTONE.defaultBlockState(), Blocks.MOSSY_COBBLESTONE.defaultBlockState(), Blocks.TUFF.defaultBlockState()};


    public static BlockLayer getRandomBlockLayer(int random, int baseRandom, BlockState base, long seed, BlockState... addition) {
        List<BlockState> blockStates = new ArrayList<>();
        for (int i = 0; i < baseRandom; i++) {
            blockStates.add(base);
        }
        for (BlockState state : addition) {
            for (int i = 0; i < RandomSource.create().nextInt(random); i++) {
                blockStates.add(state);
            }
        }
        FastNoiseLite noise = new FastNoiseLite((int) seed);
        noise.SetFrequency(0.07f);
        return new BlockLayer(LayerPlacer.of3DNoise(noise), blockStates);
    }

    public static BlockState[] getRandomStone(RandomSource random) {
        return getRandomStone(random, 0.5f, (BlockState) null);
    }

    public static BlockState[] getRandomStone(RandomSource random, float chance) {
        return getRandomStone(random, chance, (BlockState) null);
    }

    public static BlockState[] getRandomStone(RandomSource random, BlockState... exclude) {
        return getRandomStone(random, 0.5f, exclude);
    }

    public static BlockState[] getRandomStone(RandomSource random, float chance, BlockState... exclude) {
        List<BlockState> newStates = new ArrayList<>();
        for (BlockState state : STATES) {
            if (Arrays.stream(exclude).noneMatch(state::equals) && MathUtil.getRandomBoolean(random, chance)) {
                newStates.add(state);
            }
        }
        return newStates.toArray(new BlockState[0]);
    }


}
