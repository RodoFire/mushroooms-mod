package net.rodofire.mushrooomsmod.entity.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.mushrooomsmod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class SchroomStickEntity extends AnimalEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    public static final EntityDimensions JUMP_DIMENSION = EntityDimensions.changing(0.5F, 0.5F).scaled(0.7F);
    public static final EntityDimensions STOP_DIMENSION = EntityDimensions.changing(0.4F, 0.4F).scaled(0.7F);

    int tick = 0;

    private static final TrackedData<Boolean> GAVING_UP =
            DataTracker.registerData(SchroomStickEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> JUMPING =
            DataTracker.registerData(SchroomStickEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> UNGAVING_UP =
            DataTracker.registerData(SchroomStickEntity.class, TrackedDataHandlerRegistry.BOOLEAN);


    public SchroomStickEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new EscapeDangerGoal(this, .6f));
        this.goalSelector.add(3, new WanderAroundGoal(this, 0.4f));
        this.goalSelector.add(3, new WanderNearTargetGoal(this, 0.4f, 15f));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.4f, 1));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(6, new GiveUpGoal(this));
        this.goalSelector.add(7, new JumpGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal<SchroomStickEntity>(this, SchroomStickEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<PlayerEntity>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<PlotiEntity>(this, PlotiEntity.class, true));
        this.targetSelector.add(4, new ActiveTargetGoal<VillagerEntity>(this, VillagerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8f);
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isJumping() && source.isOf(DamageTypes.FALL)) {
            return false;
        }
        return super.damage(source, amount);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(JUMPING, false);
        this.dataTracker.startTracking(GAVING_UP, false);
        this.dataTracker.startTracking(UNGAVING_UP, false);
    }

    public void setJump(boolean jump) {
        this.dataTracker.set(JUMPING, jump);
    }

    public void setGiveup(boolean giveup) {
        this.dataTracker.set(GAVING_UP, giveup);
    }

    public void setUngavingUp(boolean ungavingUp) {
        this.dataTracker.set(UNGAVING_UP, ungavingUp);
    }

    public boolean isJumping() {
        return this.dataTracker.get(JUMPING);
    }

    public boolean gaveUp() {
        return this.dataTracker.get(GAVING_UP);
    }

    public boolean isUnGavingUp() {
        return this.dataTracker.get(UNGAVING_UP);
    }

    @Override
    public EntityDimensions getDimensions(EntityPose pose) {
        return switch (pose) {
            case LONG_JUMPING -> JUMP_DIMENSION;
            case CROUCHING -> STOP_DIMENSION;
            default -> super.getDimensions(pose);
        };
    }

    /*@Override
    protected void playBlockFallSound() {
        System.out.println("hi");
        if (isJumping()) {
            System.out.println("hi");
            this.playSound(ModSounds.BOOST_MUSHROOM, 0.5F, 0.75F);
        } else {
            super.playBlockFallSound();
        }
    }*/

    @Override
    public FallSounds getFallSounds() {
        if (isJumping()) {
            return new FallSounds(ModSounds.BOOST_MUSHROOM, ModSounds.BOOST_MUSHROOM);
        } else {
            return super.getFallSounds();
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<GeoAnimatable>(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        if (this.gaveUp()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.schroom_stick.give_up", Animation.LoopType.HOLD_ON_LAST_FRAME));
        } else if (this.isJumping()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.schroom_stick.jump", Animation.LoopType.HOLD_ON_LAST_FRAME));
        } else if (this.isUnGavingUp()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.schroom_stick.un_gaving_up", Animation.LoopType.HOLD_ON_LAST_FRAME));
        } else if (geoAnimatableAnimationState.isMoving()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.schroom_stick.walk", Animation.LoopType.LOOP));
        } else {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.schroom_stick.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    protected void jumpHigh() {
        Vec3d vec3d = this.getVelocity();
        this.setVelocity(vec3d.x, (double) this.getJumpVelocity() * 1.85, vec3d.z);
        if (this.isSprinting()) {
            float f = this.getYaw() * (float) (Math.PI / 180.0);
            this.setVelocity(this.getVelocity().add((double) (-MathHelper.sin(f) * 0.2F), 0.0, (double) (MathHelper.cos(f) * 0.2F)));
        }

        this.velocityDirty = true;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    static class GiveUpGoal extends Goal {
        int tick;
        float yaw;
        float pitch;
        private final SchroomStickEntity schroomStickEntity;

        public GiveUpGoal(SchroomStickEntity schroomStickEntity) {
            this.schroomStickEntity = schroomStickEntity;
        }

        @Override
        public boolean canStart() {
            return !this.schroomStickEntity.isJumping() && MathUtil.getRandomBoolean(0.02f);
        }

        @Override
        public void start() {
            this.schroomStickEntity.setGiveup(true);
            this.tick = Random.create().nextBetween(100, 300);
            this.yaw = this.schroomStickEntity.getYaw();
            this.pitch = this.schroomStickEntity.getPitch();
            this.schroomStickEntity.getNavigation().stop();
            this.schroomStickEntity.velocityModified = true;
            this.schroomStickEntity.setPose(EntityPose.CROUCHING);
            this.schroomStickEntity.horizontalCollision = false;
            this.schroomStickEntity.verticalCollision = false;
        }

        @Override
        public void tick() {
            this.schroomStickEntity.setVelocity(new Vec3d(0, 0, 0));
            this.schroomStickEntity.setYaw(this.yaw);
            this.schroomStickEntity.getNavigation().stop();
            this.schroomStickEntity.setPitch(this.pitch);
            if (this.tick == 32) {
                this.schroomStickEntity.setUngavingUp(true);
                this.schroomStickEntity.setGiveup(false);
            }
            this.schroomStickEntity.velocityDirty = true;
            this.tick--;
        }

        @Override
        public boolean shouldContinue() {
            return this.tick > 0;
        }

        @Override
        public boolean canStop() {
            return this.tick <= 0;
        }

        @Override
        public void stop() {
            super.stop();
            this.schroomStickEntity.setUngavingUp(false);
            this.schroomStickEntity.setPose(EntityPose.STANDING);
            this.schroomStickEntity.setAiDisabled(false);
        }
    }

    static class JumpGoal extends Goal {
        private final SchroomStickEntity schroomStickEntity;
        private int tick;
        final int maxInt = 46;
        Vec3d direction = new Vec3d(Random.create().nextBetween(-10, 10), 0, Random.create().nextBetween(-10, 10)).normalize();

        public JumpGoal(SchroomStickEntity schroomStickEntity) {
            this.schroomStickEntity = schroomStickEntity;
        }

        @Override
        public boolean canStart() {
            return !(this.schroomStickEntity.gaveUp() || this.schroomStickEntity.isUnGavingUp()) && MathUtil.getRandomBoolean(0.02f);
        }

        @Override
        public void start() {
            super.start();
            this.tick = maxInt;
            this.schroomStickEntity.setJump(true);
            this.schroomStickEntity.setPose(EntityPose.LONG_JUMPING);
            this.applyDirectionalJump();
        }

        @Override
        public boolean shouldContinue() {
            return this.tick > 0;
        }

        @Override
        public void tick() {
            if (this.tick == maxInt - 7) {
                this.schroomStickEntity.jumpHigh();
            }
            if (this.tick == maxInt - 18) {
                this.schroomStickEntity.jumpHigh();
            }

            this.tick--;
        }

        @Override
        public boolean canStop() {
            return this.tick <= 0;
        }

        @Override
        public void stop() {
            super.stop();
            this.schroomStickEntity.setJump(false);
        }

        private void applyDirectionalJump() {
            Vec3d direction = new Vec3d(Random.create().nextBetween(-10, 10), 0, Random.create().nextBetween(-10, 10)).normalize(); // Exemple : direction diagonale
            double speed = 0.5;

            Vec3d currentVelocity = this.schroomStickEntity.getVelocity();
            Vec3d newVelocity = new Vec3d(direction.x * speed, currentVelocity.y, direction.z * speed);
            this.schroomStickEntity.setVelocity(newVelocity);

            this.schroomStickEntity.velocityModified = true;
        }
    }
}
