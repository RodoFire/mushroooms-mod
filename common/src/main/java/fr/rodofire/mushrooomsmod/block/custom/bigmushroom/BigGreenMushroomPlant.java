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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.item.ModItems;

public class BigGreenMushroomPlant extends CropBlock implements BonemealableBlock {
    public static int MAX_AGE = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    public static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{Block.box(1, 0, 1, 15, 7, 15), Block.box(0, 0, 0, 16, 10, 16), Block.box(0, 0, 0, 16, 14, 16), Block.box(0, 0, 0, 16, 20, 16)};


    public BigGreenMushroomPlant(Properties settings, Block stage0, Block stage1, Block stage2, Block stage3) {
        super(settings);
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
            world.setBlock(pos, getAgeToBlockstate(getAge(state)), Block.UPDATE_CLIENTS);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }


    public static BlockState getAgeToBlockstate(int age) {
        if (age == 0) {
            return ModBlocks.TINY_GREEN_MUSHROOM.get().defaultBlockState();
        } else if (age == 1) {
            return ModBlocks.LITTLE_GREEN_MUSHROOM.get().defaultBlockState();
        } else if (age == 2) {
            return ModBlocks.MEDIUM_GREEN_MUSHROOM.get().defaultBlockState();
        } else {
            return ModBlocks.BIG_GREEN_MUSHROOM.get().defaultBlockState();
        }
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


    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return AGE_TO_SHAPE[this.getAge(state)];
    }
}
