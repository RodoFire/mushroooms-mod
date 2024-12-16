package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.rodofire.easierworldcreator.blockdata.layer.BlockLayer;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.util.RockUtil;

public abstract class SakuraPlainRock extends DefaultRockFeature {
    public SakuraPlainRock(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public BlockLayer getBlockLayer() {
        return RockUtil.getRandomBlockLayer(
                Random.create().nextBetween(3, 7),
                Random.create().nextBetween(1, 5),
                Blocks.STONE.getDefaultState(),
                RockUtil.getRandomStone(Blocks.TUFF.getDefaultState()));
    }
}
