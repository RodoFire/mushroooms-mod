package fr.rodofire.mushrooomsmod.mixin.block;

import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(HalfTransparentBlock.class)
public interface HalfTransparentBlockMixin {
    @Invoker("<init>")
    static HalfTransparentBlock invokeCtor(BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }
} 