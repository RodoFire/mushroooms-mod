package fr.rodofire.mushrooomsmod.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import fr.rodofire.mushrooomsmod.entity.ModEntities;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

public class PlotiEntity extends Animal implements GeoEntity {

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    protected static final EntityDataAccessor<Boolean> SIT_FLAGS = SynchedEntityData.defineId(PlotiEntity.class, EntityDataSerializers.BOOLEAN);
    private boolean sitting;
    public int sittingtime = 0;
    public int unsittingtime = 0;

    public PlotiEntity(EntityType<? extends Animal> entityType, Level world) {
        super(entityType, world);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, escapeDanger(1.7f));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.6f, 1));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }

    public Goal escapeDanger(double speed) {
        if (this.sitting) {
            this.setSit(false);
        }
        return new PanicGoal(this, speed);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob entity) {
        return ModEntities.PLOTI.get().create(world);
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
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SIT_FLAGS, false);
    }

    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        if (!this.isSit() && geoAnimatableAnimationState.isMoving()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.ploti.walk", Animation.LoopType.LOOP));
        } else if (this.isSit() && geoAnimatableAnimationState.isMoving()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.ploti.side_walking", Animation.LoopType.LOOP));
        } else if (this.isSitting()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.ploti.sit", Animation.LoopType.HOLD_ON_LAST_FRAME));
        } else if (this.isUnsitting()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.ploti.unsit", Animation.LoopType.HOLD_ON_LAST_FRAME));
        } else {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.ploti.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putBoolean("sitting", sitting);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        this.sitting = nbt.getBoolean("sitting");
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return false;
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
        if (RandomSource.create().nextIntBetweenInclusive(0,400)==0 && !this.moveControl.hasWanted()){
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
