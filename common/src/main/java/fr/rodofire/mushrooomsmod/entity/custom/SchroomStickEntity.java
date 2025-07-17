package fr.rodofire.mushrooomsmod.entity.custom;

import fr.rodofire.ewc.maths.MathUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import fr.rodofire.mushrooomsmod.sound.ModSounds;
import fr.rodofire.mushrooomsmod.util.ModTags;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

public class SchroomStickEntity extends Animal implements GeoEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    public static final EntityDimensions JUMP_DIMENSION = EntityDimensions.scalable(0.5F, 0.5F).scale(0.7F);
    public static final EntityDimensions STOP_DIMENSION = EntityDimensions.scalable(0.4F, 0.4F).scale(0.7F);


    private static final EntityDataAccessor<Boolean> GAVING_UP =
            SynchedEntityData.defineId(SchroomStickEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> JUMPING =
            SynchedEntityData.defineId(SchroomStickEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> UNGAVING_UP =
            SynchedEntityData.defineId(SchroomStickEntity.class, EntityDataSerializers.BOOLEAN);


    public SchroomStickEntity(EntityType<? extends Animal> entityType, Level world) {
        super(entityType, world);
    }

    public static boolean checkAnimalSpawnRules(EntityType<? extends Animal> type, LevelAccessor world, MobSpawnType spawnReason, BlockPos pos, RandomSource random) {
        return world.getBlockState(pos.below()).is(ModTags.Blocks.MUSHROOM_SPAWNABLE);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return false;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob entity) {
        return null;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, .6f));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.4f));
        this.goalSelector.addGoal(3, new MoveTowardsTargetGoal(this, 0.4f, 15f));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.4f, 1));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new GiveUpGoal(this));
        this.goalSelector.addGoal(7, new JumpGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, SchroomStickEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlotiEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Villager.class, true));
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.8f);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isJumping() && source.is(DamageTypes.FALL)) {
            return false;
        }
        return super.hurt(source, amount);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(GAVING_UP, false);
        builder.define(JUMPING, false);
        builder.define(UNGAVING_UP, false);
    }

    public void setJump(boolean jump) {
        this.entityData.set(JUMPING, jump);
    }

    public void setGiveup(boolean giveup) {
        this.entityData.set(GAVING_UP, giveup);
    }

    public void setUngavingUp(boolean ungavingUp) {
        this.entityData.set(UNGAVING_UP, ungavingUp);
    }

    public boolean isJumping() {
        return this.entityData.get(JUMPING);
    }

    public boolean gaveUp() {
        return this.entityData.get(GAVING_UP);
    }

    public boolean isUnGavingUp() {
        return this.entityData.get(UNGAVING_UP);
    }

    @Override
    public EntityDimensions getDefaultDimensions(Pose pose) {
        return switch (pose) {
            case LONG_JUMPING -> JUMP_DIMENSION;
            case CROUCHING -> STOP_DIMENSION;
            default -> super.getDefaultDimensions(pose);
        };
    }

    @Override
    public Fallsounds getFallSounds() {
        if (isJumping()) {
            return new Fallsounds(ModSounds.BOOST_MUSHROOM, ModSounds.BOOST_MUSHROOM);
        } else {
            return super.getFallSounds();
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
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
        Vec3 vec3d = this.getDeltaMovement();
        this.setDeltaMovement(vec3d.x, (double) this.getJumpPower() * 1.85, vec3d.z);
        if (this.isSprinting()) {
            float f = this.getYRot() * (float) (Math.PI / 180.0);
            this.setDeltaMovement(this.getDeltaMovement().add(-Mth.sin(f) * 0.2F, 0.0, Mth.cos(f) * 0.2F));
        }

        this.hasImpulse = true;
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
        public boolean canUse() {
            return !this.schroomStickEntity.isJumping() && MathUtil.getRandomBoolean(0.02f);
        }

        @Override
        public void start() {
            this.schroomStickEntity.setGiveup(true);
            this.tick = RandomSource.create().nextIntBetweenInclusive(100, 300);
            this.yaw = this.schroomStickEntity.getYRot();
            this.pitch = this.schroomStickEntity.getXRot();
            this.schroomStickEntity.getNavigation().stop();
            this.schroomStickEntity.hurtMarked = true;
            this.schroomStickEntity.setPose(Pose.CROUCHING);
            this.schroomStickEntity.horizontalCollision = false;
            this.schroomStickEntity.verticalCollision = false;
        }

        @Override
        public void tick() {
            this.schroomStickEntity.setDeltaMovement(new Vec3(0, 0, 0));
            this.schroomStickEntity.setYRot(this.yaw);
            this.schroomStickEntity.getNavigation().stop();
            this.schroomStickEntity.setXRot(this.pitch);
            if (this.tick == 32) {
                this.schroomStickEntity.setUngavingUp(true);
                this.schroomStickEntity.setGiveup(false);
            }
            this.schroomStickEntity.hasImpulse = true;
            this.tick--;
        }

        @Override
        public boolean canContinueToUse() {
            return this.tick > 0;
        }

        @Override
        public boolean isInterruptable() {
            return this.tick <= 0;
        }

        @Override
        public void stop() {
            super.stop();
            this.schroomStickEntity.setUngavingUp(false);
            this.schroomStickEntity.setPose(Pose.STANDING);
            this.schroomStickEntity.setNoAi(false);
        }
    }

    static class JumpGoal extends Goal {
        private final SchroomStickEntity schroomStickEntity;
        private int tick;
        final int maxInt = 46;

        public JumpGoal(SchroomStickEntity schroomStickEntity) {
            this.schroomStickEntity = schroomStickEntity;
        }

        @Override
        public boolean canUse() {
            return !(this.schroomStickEntity.gaveUp() || this.schroomStickEntity.isUnGavingUp()) && MathUtil.getRandomBoolean(0.02f);
        }

        @Override
        public void start() {
            super.start();
            this.tick = maxInt;
            this.schroomStickEntity.setJump(true);
            this.schroomStickEntity.setPose(Pose.LONG_JUMPING);
            this.applyDirectionalJump();
        }

        @Override
        public boolean canContinueToUse() {
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
        public boolean isInterruptable() {
            return this.tick <= 0;
        }

        @Override
        public void stop() {
            super.stop();
            this.schroomStickEntity.setJump(false);
            this.schroomStickEntity.setPose(Pose.STANDING);
        }

        private void applyDirectionalJump() {
            Vec3 direction = new Vec3(RandomSource.create().nextIntBetweenInclusive(-10, 10), 0, RandomSource.create().nextIntBetweenInclusive(-10, 10)).normalize(); // Exemple : direction diagonale
            double speed = 0.5;

            Vec3 currentVelocity = this.schroomStickEntity.getDeltaMovement();
            Vec3 newVelocity = new Vec3(direction.x * speed, currentVelocity.y, direction.z * speed);
            this.schroomStickEntity.setDeltaMovement(newVelocity);

            this.schroomStickEntity.hurtMarked = true;
        }
    }
}
