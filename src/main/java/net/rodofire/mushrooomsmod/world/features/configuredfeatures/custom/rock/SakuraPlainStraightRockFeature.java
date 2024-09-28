package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class SakuraPlainStraightRockFeature extends SakuraPlainRock {
    public SakuraPlainStraightRockFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }


    @Override
    public Vec3i getDimesions() {
        return new Vec3i(Random.create().nextInt(4), Random.create().nextBetween(3, 9), Random.create().nextInt(4));
    }
}
