package fr.rodofire.mushrooomsmod.world.structures.custom.config.mushroom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.rodofire.ewc.shape.block.gen.SphereGen;
import fr.rodofire.ewc.structure.config.StructureGeneratorConfig;
import net.minecraft.core.BlockPos;

public record GiantYellowMushroomGeneratorConfig(SphereGen sphere, SphereGen mask, BlockPos start, BlockPos end) implements StructureGeneratorConfig<GiantYellowMushroomGeneratorConfig> {
    public static final Codec<GiantYellowMushroomGeneratorConfig> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    SphereGen.CODEC.fieldOf("sphere").forGetter(GiantYellowMushroomGeneratorConfig::sphere),
                    SphereGen.CODEC.fieldOf("mask").forGetter(GiantYellowMushroomGeneratorConfig::mask),
                    BlockPos.CODEC.fieldOf("start").forGetter(GiantYellowMushroomGeneratorConfig::start),
                    BlockPos.CODEC.fieldOf("end").forGetter(GiantYellowMushroomGeneratorConfig::end)
            ).apply(instance, GiantYellowMushroomGeneratorConfig::new));

}
