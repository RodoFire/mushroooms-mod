package fr.rodofire.mushrooomsmod.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import fr.rodofire.mushrooomsmod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

import java.util.List;
import java.util.UUID;

public class CrystalGolemEntity extends AbstractGolem implements NeutralMob, GeoEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private static final UniformInt ANGER_TIME_RANGE = TimeUtil.rangeOfSeconds(40, 68);
    private int angerTime;

    //value store on the server wich determine if an entity can be attacked and when to attack
    private int attackTicksLeft;

    //value store on the client to sync animations.
    private int attackTicksLeftClient;


    @Nullable
    private UUID angryAt;
    protected static final EntityDataAccessor<Byte> CRYSTAL_GOLEM_FLAGS = SynchedEntityData.defineId(CrystalGolemEntity.class, EntityDataSerializers.BYTE);

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(CRYSTAL_GOLEM_FLAGS, (byte) 0);
    }

    public CrystalGolemEntity(EntityType<? extends AbstractGolem> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1f, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.2f, 32.0f));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.2f));
        this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<Player>(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<Mob>(this, Mob.class, 5, false, false, this::isAngryAt));
        this.targetSelector.addGoal(4, new ResetUniversalAngerTargetGoal<CrystalGolemEntity>(this, false));
    }

    public static AttributeSupplier.Builder setAttributes() {
        return AbstractGolem.createLivingAttributes().add(Attributes.MOVEMENT_SPEED, 0.2f)
                .add(Attributes.MAX_HEALTH, 70.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 2.5)
                .add(Attributes.ATTACK_DAMAGE, 15.0)
                .add(Attributes.FOLLOW_RANGE, 54.5);
    }

    private float getAttackDamage() {
        return (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        if (this.attackTicksLeft != 0) return false;
        this.attackTicksLeft = 100;
        this.level().broadcastEntityEvent(this, EntityEvent.START_ATTACKING);
        return false;
    }

    @Override
    public void handleEntityEvent(byte status) {
        if (status == EntityEvent.START_ATTACKING) {
            this.attackTicksLeftClient = 50;
        }
    }

    @Override
    public void aiStep() {

        if (!this.level().isClientSide) {

            this.updatePersistentAnger((ServerLevel) this.level(), true);

            if (this.attackTicksLeft > 0) {
                --this.attackTicksLeft;
                if (this.attackTicksLeft == 76) {
                    this.attack();
                }
            }
        } else {
            if (this.attackTicksLeftClient != 0) {
                --this.attackTicksLeftClient;
            }
        }


        super.aiStep();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getDirectEntity() instanceof AbstractArrow && this.random.nextInt(2) == 0) {
            return false;
        }
        return super.hurt(source, amount);
    }

    private boolean attack() {
        AABB boundingBox = this.getBoundingBox().inflate(5);
        List<LivingEntity> entitiesInRadius = this.level().getEntitiesOfClass(LivingEntity.class, boundingBox, x -> true);
        int i =0;

        //apply knockback and damages to entites around the golem
        for (LivingEntity entity : entitiesInRadius) {
            if (entity == this) continue;
            Vec3 pull = this.position().subtract(entity.position());
            float f = this.getAttackDamage();
            float g = (int) f > 0 ? f / 2.0f + (float) this.random.nextInt((int) f) : f;

            boolean bl = entity.hurt(this.damageSources().mobAttack(this), g);
            if (pull.horizontalDistance() > 5 || !bl) {
                continue;
            }
            ++i;
            if(i==1){
                this.level().playSound(null, this.blockPosition(), ModSounds.STONE_DESTROYED, SoundSource.HOSTILE, 5f,0.2f);
            }
            pull.subtract(this.getLookAngle());

            double d = entity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
            double e = Math.max(0.0, 1.0 - d);

            entity.setDeltaMovement(-pull.x() * 0.5f * e, 0.5f * e, -pull.z() * 0.5f * e);
            entity.hurtMarked = true;
        }
        return i!=0;
    }


    @Override
    public void setPersistentAngerTarget(@Nullable UUID angryAt) {
        this.angryAt = angryAt;
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return angerTime;
    }

    @Override
    public void setRemainingPersistentAngerTime(int angerTime) {
        this.angerTime = angerTime;
    }

    @Nullable
    @Override
    public UUID getPersistentAngerTarget() {
        return angryAt;
    }

    public boolean isAggressive() {
        return this.attackTicksLeftClient != 0;
    }


    @Override
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(ANGER_TIME_RANGE.sample(this.random));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putBoolean("PlayerCreated", this.isPlayerCreated());
        this.addPersistentAngerSaveData(nbt);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        this.setPlayerCreated(nbt.getBoolean("PlayerCreated"));
        this.readPersistentAngerSaveData(this.level(), nbt);
    }

    public boolean isPlayerCreated() {
        return (this.entityData.get(CRYSTAL_GOLEM_FLAGS) & 1) != 0;
    }

    public void setPlayerCreated(boolean playerCreated) {
        byte b = this.entityData.get(CRYSTAL_GOLEM_FLAGS);
        if (playerCreated) {
            this.entityData.set(CRYSTAL_GOLEM_FLAGS, (byte) (b | 1));
        } else {
            this.entityData.set(CRYSTAL_GOLEM_FLAGS, (byte) (b & 0xFFFFFFFE));
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }


    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        if (this.isAggressive()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.crystal_golem.attack", Animation.LoopType.PLAY_ONCE));
        } else if (geoAnimatableAnimationState.isMoving()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.crystal_golem.walk", Animation.LoopType.LOOP));
        } else {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.crystal_golem.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
