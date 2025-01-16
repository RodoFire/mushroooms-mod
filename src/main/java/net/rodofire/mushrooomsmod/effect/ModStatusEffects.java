package net.rodofire.mushrooomsmod.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;

public class ModStatusEffects {
    public static final StatusEffect FLICKERING = registerStatusEffect("flickering", new FlickeringStatusEffect(StatusEffectCategory.BENEFICIAL, 3523212));

    public static StatusEffect registerStatusEffect(String name, StatusEffect entry) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(MushrooomsMod.MOD_ID, name), entry);
    }

    public static void registerEffects() {
        MushrooomsMod.LOGGER.info("|\t-Registering Status Effects");
    }
}
