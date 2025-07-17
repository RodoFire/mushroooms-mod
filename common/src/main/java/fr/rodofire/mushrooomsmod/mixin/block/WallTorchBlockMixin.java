package fr.rodofire.mushrooomsmod.mixin.block;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.particles.ParticleOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(WallTorchBlock.class)
public interface WallTorchBlockMixin {
    @Invoker("<init>")
    static WallTorchBlock invokeCtor(SimpleParticleType flameParticle, BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }
} 