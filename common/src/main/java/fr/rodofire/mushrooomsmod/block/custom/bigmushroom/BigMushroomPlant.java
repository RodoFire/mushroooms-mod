package fr.rodofire.mushrooomsmod.block.custom.bigmushroom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.item.ModItems;

public class BigMushroomPlant extends CropBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    public static int MAX_AGE = 3;
    public static Block stage0;
    public static Block stage1;
    public static Block stage2;
    public static Block stage3;


    public BigMushroomPlant(Properties settings, Block stage0, Block stage1, Block stage2, Block stage3) {
        super(settings);
        BigMushroomPlant.stage0 = stage0;
        BigMushroomPlant.stage1 = stage1;
        BigMushroomPlant.stage2 = stage2;
        BigMushroomPlant.stage3 = stage3;

    }

    public static BlockState getAgeToBlockstate(int age) {
        if (age == 0) {
            return stage0.defaultBlockState();
        } else if (age == 1) {
            return stage1.defaultBlockState();
        } else if (age == 2) {
            return stage2.defaultBlockState();
        } else {
            return stage3.defaultBlockState();
        }
    }

    public void growCrops(Level world, BlockPos pos, BlockState state) {
        int j;
        int i = this.getAge(state) + this.getBonemealAgeIncrease(world);
        if (i > (j = this.getMaxAge())) {
            i = j;
        }
        world.setBlock(pos, this.getStateForAge(i), Block.UPDATE_CLIENTS);
    }

    protected int getBonemealAgeIncrease(Level world) {
        return Mth.nextInt(world.random, 1, 1);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        ItemStack itemStack = player.getMainHandItem();
        if (itemStack.getItem() == ModItems.PURPLE_MUSHROOM_POWDER) {
            world.setBlock(pos, getAgeToBlockstate(this.getAge(state)), Block.UPDATE_CLIENTS);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        this.growCrops(world, pos, state);
    }

    @Override
    public ItemLike getBaseSeedId() {
        return ModItems.BIG_PURPLE_MUSHROOM_SEED.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected boolean mayPlaceOn(BlockState floor, BlockGetter world, BlockPos pos) {
        return floor.isSolidRender(world, pos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockPos = pos.below();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.is(BlockTags.MUSHROOM_GROW_BLOCK) || blockState.is(ModBlocks.COMPRESSED_PURPLE_MUSHROOM.get())) {
            return true;
        }
        return world.getRawBrightness(pos, 0) < 13 && this.mayPlaceOn(blockState, world, blockPos);
    }
}
