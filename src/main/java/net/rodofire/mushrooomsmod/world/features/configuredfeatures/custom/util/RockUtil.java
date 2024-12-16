package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.random.Random;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.easierworldcreator.maths.MathUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RockUtil {
    private static final BlockState[] STATES = new BlockState[]{Blocks.COBBLESTONE.getDefaultState(), Blocks.MOSSY_COBBLESTONE.getDefaultState(), Blocks.TUFF.getDefaultState()};


    public static BlockLayer getRandomBlockLayer(int random, int baseRandom, BlockState base, BlockState... addition) {
        List<BlockState> blockStates = new ArrayList<>();
        for (int i = 0; i < baseRandom; i++) {
            blockStates.add(base);
        }
        for (BlockState state : addition) {
            for (int i = 0; i < Random.create().nextInt(random); i++) {
                blockStates.add(state);
            }
        }
        return new BlockLayer(blockStates);
    }

    public static BlockState[] getRandomStone() {
        return getRandomStone(0.5f, (BlockState) null);
    }

    public static BlockState[] getRandomStone(float chance) {
        return getRandomStone(chance, (BlockState) null);
    }

    public static BlockState[] getRandomStone(BlockState... exclude) {
        return getRandomStone(0.5f, exclude);
    }

    public static BlockState[] getRandomStone(float chance, BlockState... exclude) {
        List<BlockState> newStates = new ArrayList<>();
        for (BlockState state : STATES) {
            if (Arrays.stream(exclude).noneMatch(state::equals) && MathUtil.getRandomBoolean(chance)) {
                newStates.add(state);
            }
        }
        return newStates.toArray(new BlockState[0]);
    }


}
