package fr.rodofire.mushrooomsmod.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class CrystalConfig implements FeatureConfiguration {
    public static final Codec<CrystalConfig> CODEC = RecordCodecBuilder.create(instance -> {
        MapCodec<Integer> maxheight = ExtraCodecs.POSITIVE_INT.fieldOf("maxheight");
        MapCodec<Integer> spreadwidth = ExtraCodecs.POSITIVE_INT.fieldOf("spreadwidth");
        MapCodec<BlockStateProvider> blockprovider = BlockStateProvider.CODEC.fieldOf("blockprovider");

        return instance.group(
                maxheight.forGetter(config -> config.maxheight),
                spreadwidth.forGetter(config -> config.spreadwidth),
                blockprovider.forGetter(config -> config.blockprovider)
        ).apply(instance, CrystalConfig::new);
    });

    public final int maxheight;
    public final int spreadwidth;
    public final BlockStateProvider blockprovider;

    public CrystalConfig(final int maxheight,final int spreadwidth, final BlockStateProvider blockprovider) {
        this.maxheight = maxheight;
        this.spreadwidth = spreadwidth;
        this.blockprovider = blockprovider;
    }
}
