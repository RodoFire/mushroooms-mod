package fr.rodofire.mushrooomsmod.mixin.block;

import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SaplingBlock.class)
public interface SaplingBlockMixin {
    @Invoker("<init>")
    static SaplingBlock invokeCtor(TreeGrower grower, BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }
}