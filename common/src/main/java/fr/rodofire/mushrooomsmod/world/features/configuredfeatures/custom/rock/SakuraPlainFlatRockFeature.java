package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.shape.block.rotations.Rotator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class SakuraPlainFlatRockFeature extends SakuraPlainRock {
    @Override
    public Vec3i getDimensions(RandomSource random) {
        return new Vec3i(random.nextIntBetweenInclusive(4, 9), random.nextIntBetweenInclusive(1, 3), random.nextIntBetweenInclusive(4, 9));
    }

    public SakuraPlainFlatRockFeature(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    @Override
    public Rotator getRotator(BlockPos pos, RandomSource random) {
        return new Rotator(pos, random.nextIntBetweenInclusive(0, 360), 0, 0);
    }
}
