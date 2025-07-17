package fr.rodofire.mushrooomsmod.mixin.world.gen;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PlacementModifierType.class)
public interface PlacementModifierTypeInvoker {
    @Invoker("register")
    static <P extends PlacementModifier> PlacementModifierType<P> register(String id, MapCodec<P> codec){
        throw new AssertionError();
    }
}
