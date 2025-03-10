package net.rodofire.mushrooomsmod.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;

public record StalactiteFeatureConfig(int tries) implements FeatureConfig {
    public static final Codec<StalactiteFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("tries").forGetter(StalactiteFeatureConfig::tries)
    ).apply(instance, StalactiteFeatureConfig::new));
}
