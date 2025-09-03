package fr.rodofire.mushrooomsmod.block;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.world.level.block.Block;
import oshi.util.tuples.Triplet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class BlockUtils {
    public static final Map<Supplier<Block>, Supplier<Block>> stripableBlocks = new HashMap<>();
    public static final List<Triplet<Supplier<Block>, Integer, Integer>> flammableBlocks = new ArrayList<>();

    public static void registerStripable() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Stripable Blocks");
        
        
        stripableBlocks.put(ModBlocks.BLUE_LUMINESCENT_LOG, ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG);
        stripableBlocks.put(ModBlocks.BLUE_LUMINESCENT_WOOD, ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD);
        stripableBlocks.put(ModBlocks.PELTOGYNE_LOG, ModBlocks.PELTOGYNE_STRIPPED_LOG);
        stripableBlocks.put(ModBlocks.PELTOGYNE_WOOD, ModBlocks.PELTOGYNE_STRIPPED_WOOD);
    }

    public static void registerFlammable() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Flamable Blocks");
        flammableBlocks.add(new Triplet<>(ModBlocks.BLUE_LUMINESCENT_LOG, 5, 5));
        flammableBlocks.add(new Triplet<>(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG, 5, 5));
        flammableBlocks.add(new Triplet<>(ModBlocks.BLUE_LUMINESCENT_WOOD, 5, 5));
        flammableBlocks.add(new Triplet<>(ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD, 5, 5));

        flammableBlocks.add(new Triplet<>(ModBlocks.BLUE_LUMINESCENT_PLANKS, 5, 20));

        flammableBlocks.add(new Triplet<>(ModBlocks.BLUE_LUMINESCENT_LEAVES, 25, 50));


        flammableBlocks.add(new Triplet<>(ModBlocks.PELTOGYNE_LOG, 5, 5));
        flammableBlocks.add(new Triplet<>(ModBlocks.PELTOGYNE_STRIPPED_LOG, 5, 5));
        flammableBlocks.add(new Triplet<>(ModBlocks.PELTOGYNE_WOOD, 5, 5));
        flammableBlocks.add(new Triplet<>(ModBlocks.PELTOGYNE_STRIPPED_WOOD, 5, 5));

        flammableBlocks.add(new Triplet<>(ModBlocks.PELTOGYNE_PLANKS, 5, 20));
    }
}
