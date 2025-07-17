package fr.rodofire.mushrooomsmod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import fr.rodofire.mushrooomsmod.block.ModBlockEntities;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;

public class RapangeFlowersBE extends BlockEntity implements GeoBlockEntity {
    private static final RawAnimation DOWN = RawAnimation.begin().then("animation.rapange_flowers.down", Animation.LoopType.HOLD_ON_LAST_FRAME);
    private static final RawAnimation UP = RawAnimation.begin().then("animation.rapange_flowers.up", Animation.LoopType.PLAY_ONCE).then("animation.rapange_flowers.idle", Animation.LoopType.LOOP);
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);


    public RapangeFlowersBE(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RAPANGE_FLOWERS_BLOCK.get(), pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, state -> {
            if (state.getAnimatable().getBlockState() == ModBlocks.RAPANGE_FLOWERS.get().defaultBlockState().setValue(BlockStateProperties.UP, true)) {
                return state.setAndContinue(UP);
            } else {
                return state.setAndContinue(DOWN);
            }
        }));
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
