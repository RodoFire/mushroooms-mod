package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.pubble;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class TinyPuddle extends AbstractPuddle {
    public TinyPuddle(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    protected void generatePuddle(BlockState[] blocks) {
        generatePuddle(blocks, center.down(), 1);
    }


    private void generatePuddle(BlockState[] blocks, BlockPos pos, int step) {
        if (random.nextFloat() > (0.8f / step) || Math.abs(pos.getX() - base.getX()) > 15 || Math.abs(pos.getZ() - base.getZ()) > 15) {
            return;
        }

        if (verify(pos)) {
            world.setBlockState(pos, blocks[random.nextBetween(0, blocks.length - 1)], 3);
            int height = (int) (3 * Math.abs(noise.GetNoise(pos.getX(), pos.getZ())) + 2);
            placed = true;
            for (int i = 0; i < height; i++) {
                if (world.getBlockState(pos.up(i)).isOpaqueFullCube()) {
                    world.setBlockState(pos.up(i), Blocks.AIR.getDefaultState(), 3);
                }
            }
        }


        generatePuddle(blocks, pos.north(), step + 1);
        generatePuddle(blocks, pos.south(), step + 1);
        generatePuddle(blocks, pos.east(), step + 1);
        generatePuddle(blocks, pos.west(), step + 1);
    }
}
