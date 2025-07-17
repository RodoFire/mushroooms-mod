package fr.rodofire.mushrooomsmod.mixin.block;

import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PressurePlateBlock.class)
public interface PressurePlateBlockMixin {
    @Invoker("<init>")
    static PressurePlateBlock invokeCtor(BlockSetType type, BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }
} 