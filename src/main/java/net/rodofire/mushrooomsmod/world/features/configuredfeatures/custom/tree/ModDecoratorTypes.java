package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree;

import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.rodofire.mushrooomsmod.mixin.world.TreeDecoratorTypeInvoker;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.decorator.OakBerriesTreeDecorator;

public class ModDecoratorTypes {
    public static final TreeDecoratorType<OakBerriesTreeDecorator> RICH_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("mushrooomsmod:rich_tree_decorator", OakBerriesTreeDecorator.CODEC);

    public static void register() {
    }
}
