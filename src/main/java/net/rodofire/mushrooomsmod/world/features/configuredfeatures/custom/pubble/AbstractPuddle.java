package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.pubble;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.util.BlockPlaceUtil;
import net.rodofire.easierworldcreator.util.FastNoiseLite;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractPuddle extends Feature<DefaultFeatureConfig> {
    StructureWorldAccess world;
    BlockPos center;
    BlockPos base;
    Random random;
    final Set<BlockPos> testedBlocks = new HashSet<>();
    final Set<BlockPos> canPos = new HashSet<>();
    boolean placed = false;

    FastNoiseLite noise;

    public AbstractPuddle(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        world = context.getWorld();
        BlockPos pos = context.getOrigin().down();
        center = pos;
        base = pos;
        random = context.getRandom();
        noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFrequency(0.1f);

        boolean place = false;
        for (int i = 0; i < 150; i++) {
            if (BlockPlaceUtil.verifyBlock(world, center) && world.getBlockState(center.down()).isOpaqueFullCube()) {
                place = true;
                break;
            }
            center = pos.add(random.nextBetween(-13, 13), random.nextBetween(-20, 20), random.nextBetween(-13, 13));
        }
        if (!place) {
            return false;
        }


        BlockState[] blocks = new BlockState[]{
                Blocks.COBBLESTONE_SLAB.getDefaultState().with(Properties.WATERLOGGED, true),
                Blocks.MOSSY_COBBLESTONE_SLAB.getDefaultState().with(Properties.WATERLOGGED, true),
                Blocks.STONE_SLAB.getDefaultState().with(Properties.WATERLOGGED, true),
                Blocks.TUFF_SLAB.getDefaultState().with(Properties.WATERLOGGED, true),
                Blocks.ANDESITE_SLAB.getDefaultState().with(Properties.WATERLOGGED, true)
        };
        int randomSize = random.nextBetween(1, blocks.length);
        BlockState[] chooseFrom = new BlockState[randomSize];
        for (int i = 0; i < randomSize; i++) {
            chooseFrom[i] = blocks[random.nextInt(blocks.length - 1)];
        }
        this.generatePuddle(chooseFrom);


        return placed;
    }

    protected boolean verify(BlockPos pos) {
        BlockPos north = pos.north();
        BlockPos south = pos.south();
        BlockPos west = pos.west();
        BlockPos east = pos.east();

        return verifyForDirection(north)
                && verifyForDirection(south)
                && verifyForDirection(east)
                && verifyForDirection(west);
    }

    private boolean verifyForDirection(BlockPos north) {
        if (!canPos.contains(north)) {
            if (testedBlocks.contains(north)) {
                return false;
            }
            BlockState state = world.getBlockState(north);
            if (!state.isOpaqueFullCube()) {
                testedBlocks.add(north);
                return false;
            }
            canPos.add(north);
            return false;
        }
        return true;
    }

    protected abstract void generatePuddle(BlockState[] blocks);
}
