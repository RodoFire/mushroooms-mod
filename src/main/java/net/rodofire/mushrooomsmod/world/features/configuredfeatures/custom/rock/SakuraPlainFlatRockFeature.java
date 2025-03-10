package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.rodofire.easierworldcreator.shape.block.rotations.Rotator;

public class SakuraPlainFlatRockFeature extends SakuraPlainRock {
    @Override
    public Vec3i getDimensions(Random random) {
        return new Vec3i(random.nextBetween(4, 9), random.nextBetween(1, 3), random.nextBetween(4, 9));
    }

    public SakuraPlainFlatRockFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public Rotator getRotator(BlockPos pos, Random random) {
        return new Rotator(pos, random.nextBetween(0, 360), 0, 0);
    }
}
