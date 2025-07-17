package fr.rodofire.mushrooomsmod.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class DirectionConfig implements FeatureConfiguration {
    public static final Codec<DirectionConfig> CODEC = RecordCodecBuilder.create(instance -> {
        MapCodec<Direction> directionprovider = Direction.CODEC.fieldOf("direction");
        MapCodec<BlockStateProvider> blockprovider = BlockStateProvider.CODEC.fieldOf("blockprovider");

        return instance.group(
                directionprovider.forGetter(config -> config.directionprovider),
                blockprovider.forGetter(config -> config.blockprovider)
        ).apply(instance, DirectionConfig::new);
    });

    public final Direction directionprovider;
    public final BlockStateProvider blockprovider;

    public DirectionConfig(final Direction directionprovider, final BlockStateProvider blockprovider) {
        this.directionprovider = directionprovider;
        this.blockprovider = blockprovider;
    }

}
