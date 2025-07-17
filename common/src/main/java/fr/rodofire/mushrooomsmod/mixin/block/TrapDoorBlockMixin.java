package fr.rodofire.mushrooomsmod.mixin.block;

import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(TrapDoorBlock.class)
public interface TrapDoorBlockMixin {
    @Invoker("<init>")
    static TrapDoorBlock invokeCtor(BlockSetType type, BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }
} 