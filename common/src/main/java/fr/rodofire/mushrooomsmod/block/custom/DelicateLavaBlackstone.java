package fr.rodofire.mushrooomsmod.block.custom;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class DelicateLavaBlackstone extends Block {
    private static int maxboom;
    public static IntegerProperty RECEIVED_BOOM = IntegerProperty.create("received_boom", 0, 20);

    public DelicateLavaBlackstone(Properties settings, int maxboom) {
        super(settings);
        DelicateLavaBlackstone.maxboom = maxboom;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(RECEIVED_BOOM);
    }
    
    /*public boolean isbreakable(World world, BlockPos blockPos,BlockState blockState){
        if (blockState.)

    }*/

}
