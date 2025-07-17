package fr.rodofire.mushrooomsmod.world.structures;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import fr.rodofire.mushrooomsmod.MushrooomsMod;

public interface ModStructureKey {
    ResourceKey<Structure> YELLOW_MUSHROOM = of("yellow_mushroom");
    ResourceKey<Structure> GIANT_YELLOW_MUSHROOM = of("giant_yellow_mushroom");
    ResourceKey<Structure> PURPLE_MUSHROOM = of("purple_mushroom");

    private static ResourceKey<Structure> of(String id) {
        return ResourceKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, id));
    }

    static void registerStructureKeys() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Structure Keys");
    }
}
