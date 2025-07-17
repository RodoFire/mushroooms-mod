package fr.rodofire.mushrooomsmod.mixin.block;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(StairBlock.class)
public interface StairBlockMixin {
    @Invoker("<init>")
    static StairBlock invokeCtor(BlockState state, BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }
} 