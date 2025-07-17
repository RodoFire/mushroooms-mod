package fr.rodofire.mushrooomsmod.block.custom;

import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class FeatureTester extends Block implements BonemealableBlock {
    private final ResourceKey<ConfiguredFeature<?, ?>> key;
    public FeatureTester(Properties settings, ResourceKey<ConfiguredFeature<?, ?>> featureKey) {
        super(settings);
        this.key = featureKey;
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
        Optional<Holder.Reference<ConfiguredFeature<?, ?>>> optional = world.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(this.key);
        if (optional.isEmpty()) {
            return ;
        }
        world.removeBlock(pos, false);
        if (((ConfiguredFeature)((Holder)optional.get()).value()).place(world, world.getChunkSource().getGenerator(), random, pos)) {
            return ;
        }
        world.setBlock(pos, state, Block.UPDATE_ALL);

    }
}
