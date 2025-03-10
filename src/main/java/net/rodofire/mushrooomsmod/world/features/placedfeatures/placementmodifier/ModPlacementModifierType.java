package net.rodofire.mushrooomsmod.world.features.placedfeatures.placementmodifier;

import net.minecraft.world.gen.placementmodifier.PlacementModifierType;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.mixin.world.gen.PlacementModifierTypeInvoker;
import net.rodofire.mushrooomsmod.world.features.placedfeatures.custom.SolidStatePlacementModifier;

public class ModPlacementModifierType {
    public static final PlacementModifierType<SolidStatePlacementModifier> SOLID_STATE = PlacementModifierTypeInvoker.register("empty", SolidStatePlacementModifier.CODEC);

    public static void registerPlacementModifiers() {
        MushrooomsMod.LOGGER.info("|\t-Registering Placement Modifiers");
    }
}
