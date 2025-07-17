package fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.mixin.world.gen.TreeDecoratorTypeInvoker;
import fr.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.decorator.OakBerriesTreeDecorator;

public class ModDecoratorTypes {
    public static final TreeDecoratorType<OakBerriesTreeDecorator> RICH_TREE_DECORATOR = TreeDecoratorTypeInvoker.callRegister("mushrooomsmod:rich_tree_decorator", OakBerriesTreeDecorator.CODEC);

    public static void registerDecorators() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Decorators");
    }
}
