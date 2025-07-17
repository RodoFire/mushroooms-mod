package fr.rodofire.mushrooomsmod.world.structures;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.platform.RegistryHandler;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom.GiantYellowMushroomPiece;
import fr.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom.PurpleMushroomPiece;
import fr.rodofire.mushrooomsmod.world.structures.custom.piece.mushroom.YellowMushroomPiece;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public interface ModStructurePieceType {
    List<Supplier<StructurePieceType>> STRUCTURE_PIECE_TYPES = new ArrayList<>();
    RegistryHandler<StructurePieceType> STRUCTURE_PIECE_TYPE_HANDLER = new RegistryHandler<>(BuiltInRegistries.STRUCTURE_PIECE, STRUCTURE_PIECE_TYPES);

    Supplier<StructurePieceType> YELLOW_MUSHROOM = register("yellow_mushroom", YellowMushroomPiece::new);
    Supplier<StructurePieceType> GIANT_YELLOW_MUSHROOM = register("giant_yellow_mushroom", GiantYellowMushroomPiece::new);
    Supplier<StructurePieceType> PURPLE_MUSHROOM = register("purple_mushroom", PurpleMushroomPiece::new);

    private static Supplier<StructurePieceType> register(String name, StructurePieceType type) {
        return STRUCTURE_PIECE_TYPE_HANDLER.register(name, type);
    }

    static void registerStructurePiecesType() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Structure Pieces Type");
    }
}
