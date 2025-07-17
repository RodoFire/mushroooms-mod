package fr.rodofire.mushrooomsmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

//I had absolutely no idea on how to name this class
public class BlockBrushableBlock extends Block {
    //Brushabe block that return block without returning an item
    public Block block;

    public BlockBrushableBlock(Properties settings, Block block) {
        super(settings);
        this.block = block;
    }

    public boolean brush(long worldTime, Player player, BlockPos pos, int i) {
        if (i <= 120) return false;
        finishBrushing(player, pos);
        return true;
    }

    private void finishBrushing(Player player, BlockPos pos) {
        Level world = player.getCommandSenderWorld();
        world.setBlockAndUpdate(pos, this.block.defaultBlockState());
    }
}
