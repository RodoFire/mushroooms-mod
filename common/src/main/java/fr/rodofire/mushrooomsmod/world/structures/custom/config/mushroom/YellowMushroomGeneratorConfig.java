package fr.rodofire.mushrooomsmod.world.structures.custom.config.mushroom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.rodofire.ewc.shape.block.rotations.Rotator;
import fr.rodofire.ewc.structure.config.StructureGeneratorConfig;
import net.minecraft.core.BlockPos;

public record YellowMushroomGeneratorConfig(BlockPos start, BlockPos end, boolean flat, int radius, Rotator rotator) implements StructureGeneratorConfig<YellowMushroomGeneratorConfig> {
    public static final Codec<YellowMushroomGeneratorConfig> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(
                    BlockPos.CODEC.fieldOf("start").forGetter(YellowMushroomGeneratorConfig::start),
                    BlockPos.CODEC.fieldOf("end").forGetter(YellowMushroomGeneratorConfig::end),
                    Codec.BOOL.fieldOf("flat").forGetter(YellowMushroomGeneratorConfig::flat),
                    Codec.INT.fieldOf("radius").forGetter(YellowMushroomGeneratorConfig::radius),
                    Rotator.CODEC.fieldOf("rotator").forGetter(YellowMushroomGeneratorConfig::rotator)
            ).apply(instance, YellowMushroomGeneratorConfig::new));
}
