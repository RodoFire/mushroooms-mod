package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.util.FastNoiseLite;
import fr.rodofire.ewc.util.WorldGenUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import fr.rodofire.mushrooomsmod.block.ModBlocks;

public class AmberFeature extends Feature<NoneFeatureConfiguration> {
    public AmberFeature(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        BlockPos pos = context.origin();
        if (pos.getY() > 40) return false;

        int large = RandomSource.create().nextIntBetweenInclusive(3, 4);
        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFrequency(0.1f);
        BlockState state = ModBlocks.AMBER_MINERAL.get().defaultBlockState();
        int gain = RandomSource.create().nextIntBetweenInclusive(4, 6);
        for (int i = -large; i <= large; i++) {
            for (int j = -large; j <= large; j++) {
                float distance = WorldGenUtil.getDistance(pos, pos.offset(i, 0, j));
                float height = (distance < 0.1f ? 2 : 1 / distance) * gain * noise.GetNoise(i, j);
                for (int k = 0; k < height; k++) {
                    world.setBlock(pos.offset(i, k, j), state, 3);
                }
            }
        }


        return true;
    }
}
