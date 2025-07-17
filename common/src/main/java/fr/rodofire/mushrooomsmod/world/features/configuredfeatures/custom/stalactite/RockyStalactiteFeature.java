package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.stalactite;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.util.TagUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import fr.rodofire.mushrooomsmod.util.ModTags;
import fr.rodofire.mushrooomsmod.world.features.config.StalactiteFeatureConfig;

public class RockyStalactiteFeature extends AbstractStalactiteFeature {
    public RockyStalactiteFeature(Codec<StalactiteFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    protected Block[] getBaseBlock() {
        return TagUtil.convertTag2Array(Block.class, BuiltInRegistries.BLOCK, ModTags.Blocks.ROCKY_STALACTITE_BASE);
    }

    @Override
    protected Block[] getTopBlock() {
        return TagUtil.convertTag2Array(Block.class, BuiltInRegistries.BLOCK, ModTags.Blocks.ROCKY_STALACTITE_TOP);
    }
}
