package fr.rodofire.mushrooomsmod.world.structures;

import com.mojang.serialization.MapCodec;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms.GiantYellowMushroomStructure;
import fr.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms.PurpleMushroomStructure;
import fr.rodofire.mushrooomsmod.world.structures.custom.structure.mushrooms.YellowMushroomStructure;

public interface ModStructureTypes {
    StructureType<YellowMushroomStructure> YELLOW_MUSHROOM = register("yellow_mushroom", YellowMushroomStructure.CODEC);
    StructureType<GiantYellowMushroomStructure> GIANT_YELLOW_MUSHROOM = register("giant_yellow_mushroom", GiantYellowMushroomStructure.CODEC);
    StructureType<PurpleMushroomStructure> PURPLE_MUSHROOM = register("purple_mushroom", PurpleMushroomStructure.CODEC);

    private static <S extends Structure> StructureType<S> register(String id, MapCodec<S> codec) {
        return Registry.register(BuiltInRegistries.STRUCTURE_TYPE, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, id), () -> codec);
    }

    static void registerStructureTypes() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Structure Types");
    }
}
