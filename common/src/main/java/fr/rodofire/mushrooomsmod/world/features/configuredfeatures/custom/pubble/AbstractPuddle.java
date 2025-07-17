package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.pubble;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.util.BlockPlaceUtil;
import fr.rodofire.ewc.util.FastNoiseLite;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public abstract class AbstractPuddle extends Feature<NoneFeatureConfiguration> {
    WorldGenLevel world;
    BlockPos center;
    BlockPos base;
    RandomSource random;
    final Set<BlockPos> testedBlocks = new HashSet<>();
    final Set<BlockPos> canPos = new HashSet<>();
    boolean placed = false;

    FastNoiseLite noise;

    public AbstractPuddle(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        world = context.level();
        BlockPos pos = context.origin().below();
        center = pos;
        base = pos;
        random = context.random();
        noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFrequency(0.1f);

        boolean place = false;
        for (int i = 0; i < 150; i++) {
            if (BlockPlaceUtil.verifyBlock(world, center) && world.getBlockState(center.below()).isSolidRender(world, center.below())) {
                place = true;
                break;
            }
            center = pos.offset(random.nextIntBetweenInclusive(-13, 13), random.nextIntBetweenInclusive(-20, 20), random.nextIntBetweenInclusive(-13, 13));
        }
        if (!place) {
            return false;
        }


        BlockState[] blocks = new BlockState[]{
                Blocks.COBBLESTONE_SLAB.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true),
                Blocks.MOSSY_COBBLESTONE_SLAB.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true),
                Blocks.STONE_SLAB.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true),
                Blocks.TUFF_SLAB.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true),
                Blocks.ANDESITE_SLAB.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true)
        };
        int randomSize = random.nextIntBetweenInclusive(1, blocks.length);
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
            if (!state.isSolidRender(world, north)) {
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
