package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.shape.block.rotations.Rotator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class SakuraPlainStraightRockFeature extends SakuraPlainRock {
    public SakuraPlainStraightRockFeature(Codec<NoneFeatureConfiguration> configCodec) {
        super(configCodec);
    }

    @Override
    public Rotator getRotator(BlockPos pos, RandomSource random) {
        return new Rotator(pos, random.nextIntBetweenInclusive(0, 180), random.nextIntBetweenInclusive(-40, 40), 0);
    }


    @Override
    public Vec3i getDimensions(RandomSource random) {
        return new Vec3i(random.nextIntBetweenInclusive(1,4), random.nextIntBetweenInclusive(3, 9), random.nextIntBetweenInclusive(1,4));
    }
}
