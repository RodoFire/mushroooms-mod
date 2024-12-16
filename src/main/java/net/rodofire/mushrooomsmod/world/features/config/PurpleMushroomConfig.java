package net.rodofire.mushrooomsmod.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.gen.feature.FeatureConfig;

public record PurpleMushroomConfig(int minHeight, int maxHeight,
                                   int minCapSize, int maxCapSize)
        implements FeatureConfig {

    public static final Codec<PurpleMushroomConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                    Codecs.POSITIVE_INT.fieldOf("minheight").orElse(12).forGetter(PurpleMushroomConfig::minHeight),
                    Codecs.POSITIVE_INT.fieldOf("maxheight").orElse(26).forGetter(PurpleMushroomConfig::maxHeight),
                    Codecs.POSITIVE_INT.fieldOf("mincapsize").orElse(2).forGetter(PurpleMushroomConfig::minCapSize),
                    Codecs.POSITIVE_INT.fieldOf("maxcapsize").orElse(6).forGetter(PurpleMushroomConfig::maxCapSize)
            ).apply(instance, PurpleMushroomConfig::new)
    );

}
