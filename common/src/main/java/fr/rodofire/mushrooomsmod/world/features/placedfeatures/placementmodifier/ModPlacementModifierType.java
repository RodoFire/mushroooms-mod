package fr.rodofire.mushrooomsmod.world.features.placedfeatures.placementmodifier;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.mixin.world.gen.PlacementModifierTypeInvoker;
import fr.rodofire.mushrooomsmod.world.features.placedfeatures.custom.SolidStatePlacementModifier;

public class ModPlacementModifierType {
    public static final PlacementModifierType<SolidStatePlacementModifier> SOLID_STATE = PlacementModifierTypeInvoker.register("empty", SolidStatePlacementModifier.CODEC);

    public static void registerPlacementModifiers() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Placement Modifiers");
    }
}
