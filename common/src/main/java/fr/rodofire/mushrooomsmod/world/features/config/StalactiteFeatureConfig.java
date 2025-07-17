package fr.rodofire.mushrooomsmod.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record StalactiteFeatureConfig(int tries) implements FeatureConfiguration {
    public static final Codec<StalactiteFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("tries").forGetter(StalactiteFeatureConfig::tries)
    ).apply(instance, StalactiteFeatureConfig::new));
}
