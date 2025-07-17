package fr.rodofire.mushrooomsmod.block.custom.bigmushroom;

import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BigGreenMushroom extends BigMushroom implements BonemealableBlock {
    private final ResourceKey<ConfiguredFeature<?, ?>> featureKey;

    public BigGreenMushroom(Properties settings, ResourceKey<ConfiguredFeature<?, ?>> featureKey) {
        super(settings);
        this.featureKey = featureKey;
    }

    public static final VoxelShape SHAPE = Block.box(0f, 0f, 0f, 16f, 20f, 16f);

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        this.trySpawningBigMushroom(world, pos, state, random);
    }

    public boolean trySpawningBigMushroom(ServerLevel world, BlockPos pos, BlockState state, RandomSource random) {
        Optional<Holder.Reference<ConfiguredFeature<?, ?>>> optional = world.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(this.featureKey);
        if (optional.isEmpty()) {
            return false;
        }
        world.removeBlock(pos, false);
        if (((ConfiguredFeature) ((Holder) optional.get()).value()).place(world, world.getChunkSource().getGenerator(), random, pos)) {
            return true;
        }
        world.setBlock(pos, state, Block.UPDATE_ALL);
        return false;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

}
