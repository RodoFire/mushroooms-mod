package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.layer.BlockLayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.util.RockUtil;

public abstract class SakuraPlainRock extends DefaultRockFeature {
    public SakuraPlainRock(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    @Override
    public BlockLayer getBlockLayer(RandomSource random, long seed) {
        return RockUtil.getRandomBlockLayer(
                random.nextIntBetweenInclusive(3, 7),
                random.nextIntBetweenInclusive(1, 5),
                Blocks.STONE.defaultBlockState(),
                seed,
                RockUtil.getRandomStone(random, Blocks.TUFF.defaultBlockState()));
    }
}
