package net.rodofire.mushrooomsmod.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;

public class ModStatusEffects {
    public static final RegistryEntry<StatusEffect> FLICKERING = register("flickering", new FlickeringStatusEffect(StatusEffectCategory.BENEFICIAL, 3402751));

    private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MushrooomsMod.MOD_ID, id), statusEffect);
    }

    public static void registerEffects() {
        MushrooomsMod.LOGGER.info("|\t-Registering Status Effects");
    }
}
