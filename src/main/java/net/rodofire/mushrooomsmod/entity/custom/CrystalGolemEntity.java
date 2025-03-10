package net.rodofire.mushrooomsmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

import java.util.List;
import java.util.UUID;

public class CrystalGolemEntity extends GolemEntity implements Angerable, GeoEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private static final UniformIntProvider ANGER_TIME_RANGE = TimeHelper.betweenSeconds(40, 68);
    private int angerTime;

    //value store on the server wich determine if an entity can be attacked and when to attack
    private int attackTicksLeft;

    //value store on the client to sync animations.
    private int attackTicksLeftClient;


    @Nullable
    private UUID angryAt;
    protected static final TrackedData<Byte> CRYSTAL_GOLEM_FLAGS = DataTracker.registerData(CrystalGolemEntity.class, TrackedDataHandlerRegistry.BYTE);

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(CRYSTAL_GOLEM_FLAGS, (byte) 0);
    }

    public CrystalGolemEntity(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1f, true));
        this.goalSelector.add(2, new WanderNearTargetGoal(this, 0.2f, 32.0f));
        this.goalSelector.add(3, new WanderAroundGoal(this, 0.2f));
        this.targetSelector.add(4, new RevengeGoal(this));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.targetSelector.add(3, new ActiveTargetGoal<PlayerEntity>(this, PlayerEntity.class, 10, true, false, this::shouldAngerAt));
        this.targetSelector.add(3, new ActiveTargetGoal<MobEntity>(this, MobEntity.class, 5, false, false, this::shouldAngerAt));
        this.targetSelector.add(4, new UniversalAngerGoal<CrystalGolemEntity>(this, false));
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return GolemEntity.createLivingAttributes().add(EntityAttributes.MOVEMENT_SPEED, 0.2f)
                .add(EntityAttributes.MAX_HEALTH, 70.0f)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 2.5)
                .add(EntityAttributes.ATTACK_DAMAGE, 15.0)
                .add(EntityAttributes.FOLLOW_RANGE, 54.5);
    }

    private float getAttackDamage() {
        return (float) this.getAttributeValue(EntityAttributes.ATTACK_DAMAGE);
    }

    @Override
    public boolean tryAttack(ServerWorld world, Entity target) {
        if (this.attackTicksLeft != 0) return false;
        this.attackTicksLeft = 100;
        this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_ATTACK_SOUND);
        return false;
    }

    @Override
    public void handleStatus(byte status) {
        if (status == EntityStatuses.PLAY_ATTACK_SOUND) {
            this.attackTicksLeftClient = 50;
        }
    }

    @Override
    public void tickMovement() {

        if (!this.getWorld().isClient) {

            this.tickAngerLogic((ServerWorld) this.getWorld(), true);

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


        super.tickMovement();
    }

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        if (source.getSource() instanceof PersistentProjectileEntity && this.random.nextInt(2) == 0) {
            return false;
        }
        return super.damage(world,source, amount);
    }

    private boolean attack() {
        Box boundingBox = this.getBoundingBox().expand(5);
        List<LivingEntity> entitiesInRadius = this.getWorld().getEntitiesByClass(LivingEntity.class, boundingBox, x -> true);
        int i =0;

        if(this.getWorld() instanceof ServerWorld serverWorld) {

            //apply knockback and damages to entites around the golem
            for (LivingEntity entity : entitiesInRadius) {
                if (entity == this) continue;
                Vec3d pull = this.getPos().subtract(entity.getPos());
                float f = this.getAttackDamage();
                float g = (int) f > 0 ? f / 2.0f + (float) this.random.nextInt((int) f) : f;
                boolean bl = entity.damage(serverWorld, this.getDamageSources().mobAttack(this), g);
                if (pull.horizontalLength() > 5 || !bl) {
                    continue;
                }
                ++i;
                if (i == 1) {
                    this.getWorld().playSound(null, this.getBlockPos(), ModSounds.STONE_DESTROYED, SoundCategory.HOSTILE, 5f, 0.2f);
                }
                pull.subtract(this.getRotationVector());

                double d = entity.getAttributeValue(EntityAttributes.KNOCKBACK_RESISTANCE);
                double e = Math.max(0.0, 1.0 - d);

                entity.setVelocity(-pull.getX() * 0.5f * e, 0.5f * e, -pull.getZ() * 0.5f * e);
                entity.velocityModified = true;
            }
        }
        return i!=0;
    }


    @Override
    public void setAngryAt(@Nullable UUID angryAt) {
        this.angryAt = angryAt;
    }

    @Override
    public int getAngerTime() {
        return angerTime;
    }

    @Override
    public void setAngerTime(int angerTime) {
        this.angerTime = angerTime;
    }

    @Nullable
    @Override
    public UUID getAngryAt() {
        return angryAt;
    }

    public boolean isAttacking() {
        return this.attackTicksLeftClient != 0;
    }


    @Override
    public void chooseRandomAngerTime() {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("PlayerCreated", this.isPlayerCreated());
        this.writeAngerToNbt(nbt);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setPlayerCreated(nbt.getBoolean("PlayerCreated"));
        this.readAngerFromNbt(this.getWorld(), nbt);
    }

    public boolean isPlayerCreated() {
        return (this.dataTracker.get(CRYSTAL_GOLEM_FLAGS) & 1) != 0;
    }

    public void setPlayerCreated(boolean playerCreated) {
        byte b = this.dataTracker.get(CRYSTAL_GOLEM_FLAGS);
        if (playerCreated) {
            this.dataTracker.set(CRYSTAL_GOLEM_FLAGS, (byte) (b | 1));
        } else {
            this.dataTracker.set(CRYSTAL_GOLEM_FLAGS, (byte) (b & 0xFFFFFFFE));
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }


    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        if (this.isAttacking()) {
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
