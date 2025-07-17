package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.decorator;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.ModDecoratorTypes;

public class OakBerriesTreeDecorator extends TreeDecorator {
    public static final OakBerriesTreeDecorator INSTANCE = new OakBerriesTreeDecorator();

    // Our constructor doesn't have any arguments, so we create a unit codec that returns the singleton instance
    public static final MapCodec<OakBerriesTreeDecorator> CODEC = MapCodec.unit(() -> INSTANCE);

    private OakBerriesTreeDecorator() {
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return ModDecoratorTypes.RICH_TREE_DECORATOR;
    }

    @Override
    public void place(Context generator) {
        generator.leaves().forEach(pos -> {
            RandomSource random = generator.random();
            if (random.nextInt(4) == 0) {
                generator.setBlock(pos, ModBlocks.OAK_BERRIES_LEAVES.get().defaultBlockState().setValue(BlockStateProperties.BERRIES, true));
            }
        });
    }
}