package fr.rodofire.mushrooomsmod.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record PurpleMushroomConfig(int minHeight, int maxHeight,
                                   int minCapSize, int maxCapSize)
        implements FeatureConfiguration {

    public static final Codec<PurpleMushroomConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                    ExtraCodecs.POSITIVE_INT.fieldOf("minheight").orElse(12).forGetter(PurpleMushroomConfig::minHeight),
                    ExtraCodecs.POSITIVE_INT.fieldOf("maxheight").orElse(26).forGetter(PurpleMushroomConfig::maxHeight),
                    ExtraCodecs.POSITIVE_INT.fieldOf("mincapsize").orElse(2).forGetter(PurpleMushroomConfig::minCapSize),
                    ExtraCodecs.POSITIVE_INT.fieldOf("maxcapsize").orElse(6).forGetter(PurpleMushroomConfig::maxCapSize)
            ).apply(instance, PurpleMushroomConfig::new)
    );

}
