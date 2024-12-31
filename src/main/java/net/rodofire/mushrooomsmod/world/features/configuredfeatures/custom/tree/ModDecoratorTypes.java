package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree;

import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.mixin.world.TreeDecoratorTypeInvoker;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.decorator.OakBerriesTreeDecorator;

public class ModDecoratorTypes {
    public static final TreeDecoratorType<OakBerriesTreeDecorator> RICH_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("oak_berries_decorator", OakBerriesTreeDecorator.CODEC);

    public static void registerDecorators() {
        MushrooomsMod.LOGGER.info("|\t-Registering Decorators");
    }
}
