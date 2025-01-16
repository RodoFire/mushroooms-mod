package net.rodofire.mushrooomsmod.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.rodofire.easierworldcreator.util.WorldGenUtil;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.HashSet;
import java.util.Set;

public class SquirrelEntity extends AnimalEntity implements GeoEntity {
    AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private static final TrackedData<Boolean> jump = DataTracker.registerData(SquirrelEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> onLeaves = DataTracker.registerData(SquirrelEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    Set<BlockPos> airPos = new HashSet<>();
    Set<BlockPos> leavesPos = new HashSet<>();

    public SquirrelEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 12.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new EscapeDangerGoal(this, 0.8f));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 0.6f));
        //this.goalSelector.add(1, new JumpGoal(this, 10, 15));
    }


    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.SQUIRREL.create(world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        if (geoAnimatableAnimationState.isMoving()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.squirrel.un_go_idle", Animation.LoopType.PLAY_ONCE).then("animation.squirrel.walk", Animation.LoopType.LOOP));
            geoAnimatableAnimationState.getController().setAnimationSpeed(this.isSprinting() ? 2f : 1.6f);
        } else {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.squirrel.go_idle", Animation.LoopType.PLAY_ONCE).then("animation.squirrel.idle", Animation.LoopType.LOOP));
            geoAnimatableAnimationState.getController().setAnimationSpeed(1f);
        }
        return PlayState.CONTINUE;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(onLeaves, false);
        this.dataTracker.startTracking(jump, false);
    }

    public boolean isJumping() {
        return this.dataTracker.get(jump);
    }

    public void setJumping(boolean jumping) {
        this.dataTracker.set(jump, jumping);
    }

    public boolean isOnLeaves() {
        return this.dataTracker.get(onLeaves);
    }

    public void setOnLeaves(boolean onLeaves) {
        this.dataTracker.set(SquirrelEntity.onLeaves, onLeaves);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    /**
     * goal qui permet a l'entité de sauter sur un arbre
     */
    public static class JumpGoal extends Goal {
        SquirrelEntity entity;
        int radius;
        int height;
        double vY = 0;
        Vec3d vec;
        int tick;

        public JumpGoal(SquirrelEntity entity, int radius, int height) {
            this.entity = entity;
            this.radius = radius;
            this.height = height;
        }

        @Override
        public boolean canStart() {
            return /*this.entity.random.nextFloat() < 0.02f && */!this.entity.isOnLeaves() && canJump();
        }

        @Override
        public void start() {
            this.entity.setVelocity(this.vec);
            this.entity.velocityDirty = true;
        }

        @Override
        public void tick() {
            super.tick();
            this.entity.getNavigation().stop();
            this.entity.getLookControl().lookAt(vec);
            this.entity.velocityDirty = true;
            this.tick--;
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.setOnLeaves(true);
            this.entity.setJumping(false);
        }

        @Override
        public boolean shouldContinue() {
            return this.tick > 0;
        }

        @Override
        public boolean canStop() {
            return this.tick <= 0;
        }

        boolean canJump() {
            for (int i = -radius; i <= radius; i++) {
                for (int j = 0; j <= height; j++) {
                    for (int k = -radius; k <= radius; k++) {
                        BlockPos pos = this.entity.getBlockPos().add(i, j, k);

                        BlockState state = this.entity.getWorld().getBlockState(pos);
                        if (state.isIn(BlockTags.LEAVES)) {
                            this.entity.leavesPos.add(pos);
                        } else if (state.isOf(Blocks.AIR) || !state.isOpaqueFullCube(this.entity.getWorld(), pos)) {
                            this.entity.airPos.add(pos);
                        }
                    }
                }
            }

            //ici
            for (BlockPos pos : this.entity.leavesPos) {
                if (this.entity.airPos.contains(pos.up())) {
                    if (manageJump(pos)) {
                        System.out.println("manageJump");
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * on vérifie si une configuration existe de manière a ce que l'écureil passe sans se cogner contre des blocks
         */
        boolean manageJump(BlockPos pos) {
            int overshoot = this.entity.random.nextBetween(1, 3);
            boolean bl = true;
            for (int i = 0; i < 1; i++) {
                calculateJumpVelocity(this.entity.getBlockPos(), pos, overshoot);
                int distance = (int) (1.3 * WorldGenUtil.getDistance(this.entity.getBlockPos(), pos));
                double totalTime = (2 * this.vY) / 0.08;
                this.tick = (int) Math.ceil(totalTime);

                // on calcule les positions par lesquelles l'écureuil va passer
                for (int j = 0; j < distance; j++) {
                    int tick = (int) (totalTime * ((double) j / distance));

                    int x = (int) (vec.x * tick);
                    int y = (int) (vec.y * tick - 0.08 * tick * tick);
                    int z = (int) (vec.z * tick);
                    BlockPos internalPos = this.entity.getBlockPos().add(x, y, z);
                    if (internalPos.equals(this.entity.getBlockPos()) || internalPos.equals(pos)) {
                        continue;
                    }
                    if (this.entity.airPos.contains(internalPos))
                        continue;
                    bl = false;
                    //on détecte une collision, pas besoin de continuer les calculs
                    // /kill @e[type=mushrooomsmod:squirrel]
                    break;
                }
                if (bl)
                    return true;
                overshoot = overshoot % 3 + 1;
            }
            return false;

            /*
            ExecutorService executor = Executors.newCachedThreadPool();
    List<Future<Boolean>> futures = new ArrayList<>();

    // Lancer plusieurs threads pour vérifier les trajectoires possibles
    for (int i = 0; i < 3; i++) {
        final int overshoot = this.entity.random.nextBetween(1, 3);
        futures.add(executor.submit(() -> {
            calculateJumpVelocity(this.entity.getBlockPos(), pos, overshoot);
            int distance = (int) (1.3 * WorldGenUtil.getDistance(this.entity.getBlockPos(), pos));
            double totalTime = (2 * this.vY) / 0.08;

            for (int j = 0; j < distance; j++) {
                int tick = (int) (totalTime * ((double) j / distance));
                int x = (int) (vec.x * tick);
                int y = (int) (vec.y * tick - 0.08 * tick * tick);
                int z = (int) (vec.z * tick);
                BlockPos internalPos = this.entity.getBlockPos().add(x, y, z);

                if (!this.entity.airPos.contains(internalPos)) {
                    return false; // Collision détectée
                }
            }
            return true; // Aucun problème détecté
        }));
    }

    // Vérifier les résultats
    for (Future<Boolean> future : futures) {
        try {
            if (future.get()) {
                executor.shutdownNow(); // Arrêter les autres threads
                return true;
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    executor.shutdown();
    return false;
             */
        }

        /**
         * on calcule le vecteur initial selon les paramètres donnés
         */
        public void calculateJumpVelocity(BlockPos pos1, BlockPos pos2, int overshoot) {
            double gravity = -0.08;
            double yMax = pos2.getY() + overshoot;

            double deltaX = pos2.getX() - pos1.getX();
            double deltaZ = pos2.getZ() - pos1.getZ();

            this.vY = Math.sqrt(-2 * gravity * (yMax - pos1.getY()));

            double totalTime = (2 * this.vY) / -gravity;

            double sqrt = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);
            double vXZ = sqrt / totalTime;
            double vX = vXZ * (deltaX / sqrt);
            double vZ = vXZ * (deltaZ / sqrt);

            this.vec = new Vec3d(vX, this.vY, vZ);
        }
    }

    public static class jumpFromTreeGoal extends Goal {
        SquirrelEntity entity;

        public jumpFromTreeGoal(SquirrelEntity entity) {
            this.entity = entity;
        }

        @Override
        public boolean canStart() {
            return this.entity.isOnLeaves() && this.entity.random.nextFloat() < 0.7f;
        }
    }
}
