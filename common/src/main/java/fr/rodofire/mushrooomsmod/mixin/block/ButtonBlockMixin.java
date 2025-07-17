package fr.rodofire.mushrooomsmod.mixin.block;

import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ButtonBlock.class)
public interface ButtonBlockMixin {
    @Invoker("<init>")
    static ButtonBlock invokeCtor(BlockSetType type, int ticksToStayPressed, BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }
} 