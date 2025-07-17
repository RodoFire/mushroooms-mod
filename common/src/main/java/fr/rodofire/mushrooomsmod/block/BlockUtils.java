package fr.rodofire.mushrooomsmod.block;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.world.level.block.Block;
import oshi.util.tuples.Triplet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockUtils {
    public static final Map<Block, Block> stripableBlocks = new HashMap<>();
    public static final List<Triplet<Block, Integer, Integer>> flammableBlocks = new ArrayList<>();

    public static void registerStripable() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Stripable Blocks");
        
        
        stripableBlocks.put(ModBlocks.BLUE_LUMINESCENT_LOG.get(), ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG.get());
        stripableBlocks.put(ModBlocks.BLUE_LUMINESCENT_WOOD.get(), ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD.get());
        stripableBlocks.put(ModBlocks.PELTOGYNE_LOG.get(), ModBlocks.PELTOGYNE_STRIPPED_LOG.get());
        stripableBlocks.put(ModBlocks.PELTOGYNE_WOOD.get(), ModBlocks.PELTOGYNE_STRIPPED_WOOD.get());
    }

    public static void registerFlammable() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Flamable Blocks");
        flammableBlocks.add(new Triplet<>(ModBlocks.BLUE_LUMINESCENT_LOG.get(), 5, 5));
        flammableBlocks.add(new Triplet<>(ModBlocks.BLUE_LUMINESCENT_STRIPPED_LOG.get(), 5, 5));
        flammableBlocks.add(new Triplet<>(ModBlocks.BLUE_LUMINESCENT_WOOD.get(), 5, 5));
        flammableBlocks.add(new Triplet<>(ModBlocks.BLUE_LUMINESCENT_STRIPPED_WOOD.get(), 5, 5));

        flammableBlocks.add(new Triplet<>(ModBlocks.BLUE_LUMINESCENT_PLANKS.get(), 5, 20));

        flammableBlocks.add(new Triplet<>(ModBlocks.BLUE_LUMINESCENT_LEAVES.get(), 25, 50));


        flammableBlocks.add(new Triplet<>(ModBlocks.PELTOGYNE_LOG.get(), 5, 5));
        flammableBlocks.add(new Triplet<>(ModBlocks.PELTOGYNE_STRIPPED_LOG.get(), 5, 5));
        flammableBlocks.add(new Triplet<>(ModBlocks.PELTOGYNE_WOOD.get(), 5, 5));
        flammableBlocks.add(new Triplet<>(ModBlocks.PELTOGYNE_STRIPPED_WOOD.get(), 5, 5));

        flammableBlocks.add(new Triplet<>(ModBlocks.PELTOGYNE_PLANKS.get(), 5, 20));
    }
}
