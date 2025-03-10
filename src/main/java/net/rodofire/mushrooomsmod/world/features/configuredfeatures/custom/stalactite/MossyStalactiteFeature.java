package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.stalactite;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.rodofire.easierworldcreator.tag.TagUtil;
import net.rodofire.mushrooomsmod.util.ModTags;
import net.rodofire.mushrooomsmod.world.features.config.StalactiteFeatureConfig;

public class MossyStalactiteFeature extends AbstractStalactiteFeature{
    public MossyStalactiteFeature(Codec<StalactiteFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    protected Block[] getBaseBlock() {
        return TagUtil.BlockTags.convertBlockTagToBlockArray(ModTags.Blocks.MOSSY_STALACTITE_BASE);
    }

    @Override
    protected Block[] getTopBlock() {
        return random.nextFloat() < 0.6f ? TagUtil.BlockTags.convertBlockTagToBlockArray(ModTags.Blocks.MOSSY_STALACTITE_BASE) : TagUtil.BlockTags.convertBlockTagToBlockArray(ModTags.Blocks.MOSSY_STALACTITE_TOP);
    }
}
