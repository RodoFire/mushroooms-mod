package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.util.FastNoiseLite;
import net.rodofire.easierworldcreator.util.WorldGenUtil;
import net.rodofire.mushrooomsmod.block.ModBlocks;

public class AmberFeature extends Feature<DefaultFeatureConfig> {
    public AmberFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        if (pos.getY() > 40) return false;

        int large = Random.create().nextBetween(3, 4);
        FastNoiseLite noise = new FastNoiseLite((int) world.getSeed());
        noise.SetFrequency(0.1f);
        BlockState state = ModBlocks.AMBER_MINERAL.getDefaultState();
        int gain = Random.create().nextBetween(4, 6);
        for (int i = -large; i <= large; i++) {
            for (int j = -large; j <= large; j++) {
                float distance = WorldGenUtil.getDistance(pos, pos.add(i, 0, j));
                float height = (distance < 0.1f ? 2 : 1 / distance) * gain * noise.GetNoise(i, j);
                for (int k = 0; k < height; k++) {
                    world.setBlockState(pos.add(i, k, j), state, 3);
                }
            }
        }


        return true;
    }
}
