package fr.rodofire.mushrooomsmod.block.custom;

import fr.rodofire.mushrooomsmod.block.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class AmbreBlock extends Block {
    public AmbreBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!world.isClientSide) {
            if (world.getBlockState(pos.below()).getBlock() == Blocks.SAND) {
                if (RandomSource.create().nextInt(3) == 0) {
                    world.setBlockAndUpdate(pos, ModBlocks.AMBER_BLOCK_SANDIFIED.get().defaultBlockState());
                }
                double x = ((double) RandomSource.create().nextIntBetweenInclusive(110, 150) / 100) * randomDirection();
                double y = ((double) RandomSource.create().nextIntBetweenInclusive(110, 150) / 100) * randomDirection();
                double z = ((double) RandomSource.create().nextIntBetweenInclusive(110, 150) / 100) * randomDirection();
                Vec3 vec3d = new Vec3(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
                world.sendParticles(ParticleTypes.COMPOSTER,
                        vec3d.x, vec3d.y, vec3d.z, 0,0.0D, 0.0D, 0.0D, 0.0001f);
            }
        }
    }

    public int randomDirection() {
        return RandomSource.create().nextIntBetweenInclusive(0, 1) == 0 ? 1 : -1;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }


    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag options) {
        tooltip.add(Component.translatable("tooltip.mushrooomsmod.ambre_block").withStyle(ChatFormatting.GOLD));
        super.appendHoverText(stack, context, tooltip, options);
    }
}
