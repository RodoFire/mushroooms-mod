package net.rodofire.mushrooomsmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import net.rodofire.mushrooomsmod.util.ModTags;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class PlotiEntity extends AnimalEntity implements GeoEntity {

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    protected static final TrackedData<Boolean> SIT_FLAGS = DataTracker.registerData(PlotiEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private boolean sitting;
    public int sittingtime = 0;
    public int unsittingtime = 0;

    public PlotiEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static boolean isValidNaturalSpawn(EntityType<? extends AnimalEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        System.out.println(world.getBlockState(pos.down()).isIn(ModTags.Blocks.MUSHROOM_SPAWNABLE) + "   " + world.getBlockState(pos.down()));
        return world.getBlockState(pos.down()).isIn(ModTags.Blocks.MUSHROOM_SPAWNABLE);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, escapeDanger(1.7f));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.6f, 1));
        this.goalSelector.add(4, new LookAroundGoal(this));
    }

    public Goal escapeDanger(double speed) {
        if (this.sitting) {
            this.setSit(false);
        }
        return new EscapeDangerGoal(this, speed);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.PLOTI.create(world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(SIT_FLAGS, true);
    }

    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        if (!this.isSit() && geoAnimatableAnimationState.isMoving()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.ploti.walk", Animation.LoopType.LOOP));
        } else if (this.isSit() && geoAnimatableAnimationState.isMoving()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.ploti.side_walking", Animation.LoopType.LOOP));
        } else if (this.isSitting()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.ploti.sitting", Animation.LoopType.HOLD_ON_LAST_FRAME));
        } else if (this.isUnsitting()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.ploti.unsitting", Animation.LoopType.HOLD_ON_LAST_FRAME));
        } else {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.ploti.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("sitting", sitting);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.sitting = nbt.getBoolean("sitting");
    }

    //return if the entity is sat
    public boolean isSit() {
        return this.sitting;
    }

    public void setSit(boolean sit) {
        if (sit) {
            this.sittingtime = 10;
        }
        this.unsittingtime = 10;
    }

    @Override
    public void tick() {
        if (this.sittingtime != 0) {
            if (this.sittingtime == 1) {
                this.sittingtime = 0;
                setSit(true);
            }
            this.sittingtime--;
        }
        if (this.unsittingtime != 0) {
            if (this.unsittingtime == 1) {
                this.unsittingtime = 0;
                setSit(false);
            }
            this.unsittingtime--;
        }
        if (Random.create().nextBetween(0,400)==0 && !this.moveControl.isMoving()){
            this.setSit(!this.sitting);
        }
        super.tick();
    }

    //return if the entity
    public boolean isSitting() {
        return this.sittingtime != 0;
    }

    public boolean isUnsitting() {
        return this.unsittingtime != 0;
    }
}
