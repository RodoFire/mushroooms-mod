package fr.rodofire.mushrooomsmod.effect;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import fr.rodofire.mushrooomsmod.MushrooomsMod;

public class ModStatusEffects {
    public static final Holder<MobEffect> FLICKERING = register("flickering", new FlickeringStatusEffect(MobEffectCategory.BENEFICIAL, 3402751));

    private static Holder<MobEffect> register(String id, MobEffect statusEffect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, id), statusEffect);
    }

    public static void registerEffects() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Status Effects");
    }
}
