package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.pubble;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class TinyPuddle extends AbstractPuddle {
    public TinyPuddle(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    @Override
    protected void generatePuddle(BlockState[] blocks) {
        generatePuddle(blocks, center.below(), 1);
    }


    private void generatePuddle(BlockState[] blocks, BlockPos pos, int step) {
        if (random.nextFloat() > (0.8f / step) || Math.abs(pos.getX() - base.getX()) > 15 || Math.abs(pos.getZ() - base.getZ()) > 15) {
            return;
        }

        if (verify(pos)) {
            world.setBlock(pos, blocks[random.nextIntBetweenInclusive(0, blocks.length - 1)], 3);
            int height = (int) (3 * Math.abs(noise.GetNoise(pos.getX(), pos.getZ())) + 2);
            placed = true;
            for (int i = 0; i < height; i++) {
                if (world.getBlockState(pos.above(i)).isSolidRender(world, pos.above(i))) {
                    world.setBlock(pos.above(i), Blocks.AIR.defaultBlockState(), 3);
                }
            }
        }


        generatePuddle(blocks, pos.north(), step + 1);
        generatePuddle(blocks, pos.south(), step + 1);
        generatePuddle(blocks, pos.east(), step + 1);
        generatePuddle(blocks, pos.west(), step + 1);
    }
}
