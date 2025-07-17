package fr.rodofire.mushrooomsmod.block.custom.PinkMushroomBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.VoxelShape;
import fr.rodofire.mushrooomsmod.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.function.ToIntFunction;

public interface PinkMushroomVines {
    VoxelShape SHAPE = Block.box(4, 0, 4, 12.0, 16, 12);
    BooleanProperty BERRIES = BlockStateProperties.BERRIES;


    static InteractionResult pickBerries(@Nullable Entity picker, BlockState state, Level world, BlockPos pos) {
        if (state.getValue(BERRIES).booleanValue()) {
            Block.popResource(world, pos, new ItemStack(ModItems.PINK_MUSHROOM_VINES_ITEM.get(), 1));
            float f = Mth.randomBetween(world.random, 0.8f, 1.2f);
            world.playSound(null, pos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0f, f);
            BlockState blockState = state.setValue(BERRIES, false);
            world.setBlock(pos, blockState, Block.UPDATE_CLIENTS);
            world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(picker, blockState));
            return InteractionResult.sidedSuccess(world.isClientSide);
        }
        return InteractionResult.PASS;
    }

    static boolean hasBerries(BlockState state) {
        return state.hasProperty(BERRIES) && state.getValue(BERRIES);
    }

    static ToIntFunction<BlockState> getLuminanceSupplier(int luminance) {
        return state -> state.getValue(BlockStateProperties.BERRIES) ? luminance : 0;
    }
}
