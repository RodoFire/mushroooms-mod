package fr.rodofire.mushrooomsmod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import fr.rodofire.mushrooomsmod.block.ModBlocks;
import fr.rodofire.mushrooomsmod.block.custom.StraightCrystal;
import fr.rodofire.mushrooomsmod.sound.ModSounds;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

public class CrystalCreeperEntity extends CustomCreeperEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private int interact;
    private static final int RADIUS = 6;

    /*public CrystalCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }*/

    public CrystalCreeperEntity(EntityType<? extends CustomCreeperEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        if (geoAnimatableAnimationState.isMoving()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.crystal_creeper.walk", Animation.LoopType.LOOP));
        } else {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.crystal_creeper.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    //custom explosion
    @Override
    protected void explode() {
        if (!this.level().isClientSide) {
            float f = this.isPowered() ? 2.0f : 1.0f;
            this.dead = true;
            placeCrystal(this.level(), this.blockPosition(), RADIUS, f, random);
            this.discard();
            this.spawnEffectsCloud();
        }
    }


    private void placeCrystal(Level world, BlockPos pos, int radius, float f, RandomSource random) {
        BlockState blockState = world.getBlockState(pos.below());

        //place crystal if entity is standing on deepslate
        if (blockState.getBlock() == Blocks.DEEPSLATE || blockState.getBlock() == Blocks.COBBLED_DEEPSLATE) {
            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
            mutable.set(pos);
            for (int i = 0; i < radius * radius; i++) {
                mutable.setWithOffset(pos, random.nextIntBetweenInclusive(-radius, radius), random.nextIntBetweenInclusive(-radius, radius), random.nextIntBetweenInclusive(-radius, radius));
                if (world.getBlockState(mutable.below()).isSolidRender(world, mutable.below()) && world.getBlockState(mutable).isAir()) {
                    Block block = getCrystal();

                    //place crystal column if block is a StraightCrystal
                    if (block instanceof StraightCrystal) {
                        StraightCrystal.generateStraightCrystal(world, mutable, block.defaultBlockState(), RandomSource.create().nextIntBetweenInclusive(1, 8));
                    } else {
                        world.setBlockAndUpdate(mutable, block.defaultBlockState());
                    }
                }
            }
            world.playSound(null, pos, ModSounds.PINK_CRYSTAL_BREAK, SoundSource.HOSTILE,2.0f,1.0f);
            return;
        }
        //normal explosion
        this.level().explode(this, this.getX(), this.getY(), this.getZ(), (float) radius * f, Level.ExplosionInteraction.MOB);
    }

    private Block getCrystal() {
        return switch (RandomSource.create().nextIntBetweenInclusive(0, 3)) {
            case 0 -> ModBlocks.RED_CRYSTAL.get();
            case 1 -> ModBlocks.WHITE_CRYSTAL.get();
            //case 2 -> ModBlocks.
            default -> ModBlocks.BLUE_CRYSTAL.get();
        };
    }
}
