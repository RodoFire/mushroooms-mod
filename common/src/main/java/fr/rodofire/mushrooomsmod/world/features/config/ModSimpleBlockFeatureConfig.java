package fr.rodofire.mushrooomsmod.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ModSimpleBlockFeatureConfig implements FeatureConfiguration {
    public static final Codec<ModSimpleBlockFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> {
        MapCodec<BlockStateProvider> blockprovider = BlockStateProvider.CODEC.fieldOf("blockprovider");

        return instance.group(
                blockprovider.forGetter(config -> config.blockprovider)
        ).apply(instance, ModSimpleBlockFeatureConfig::new);
    });

    public final BlockStateProvider blockprovider;

    public ModSimpleBlockFeatureConfig(final BlockStateProvider blockprovider) {
        this.blockprovider = blockprovider;
    }
}
