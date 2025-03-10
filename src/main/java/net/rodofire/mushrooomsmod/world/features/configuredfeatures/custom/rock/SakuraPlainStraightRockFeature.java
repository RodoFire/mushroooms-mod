package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.rodofire.easierworldcreator.shape.block.rotations.Rotator;

public class SakuraPlainStraightRockFeature extends SakuraPlainRock {
    public SakuraPlainStraightRockFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public Rotator getRotator(BlockPos pos, Random random) {
        return new Rotator(pos, random.nextBetween(0, 180), random.nextBetween(-40, 40), 0);
    }


    @Override
    public Vec3i getDimensions(Random random) {
        return new Vec3i(random.nextBetween(1,4), random.nextBetween(3, 9), random.nextBetween(1,4));
    }
}
