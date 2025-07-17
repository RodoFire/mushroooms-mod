package fr.rodofire.mushrooomsmod.mixin.block;

import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(TallGrassBlock.class)
public interface TallGrassBlockMixin {
    @Invoker("<init>")
    static TallGrassBlock invokeCtor(BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }
} 