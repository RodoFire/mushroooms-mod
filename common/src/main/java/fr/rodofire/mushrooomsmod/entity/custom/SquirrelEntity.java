package fr.rodofire.mushrooomsmod.entity.custom;

import fr.rodofire.ewc.util.WorldGenUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import fr.rodofire.mushrooomsmod.entity.ModEntities;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

import java.util.HashSet;
import java.util.Set;

public class SquirrelEntity extends Animal implements GeoEntity {
    AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private static final EntityDataAccessor<Boolean> jump = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> onLeaves = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.BOOLEAN);
    Set<BlockPos> airPos = new HashSet<>();
    Set<BlockPos> leavesPos = new HashSet<>();

    public SquirrelEntity(EntityType<? extends Animal> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return false;
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 0.8f));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.6f));
        //this.goalSelector.add(1, new JumpGoal(this, 10, 15));
    }


    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel world, AgeableMob entity) {
        return ModEntities.SQUIRREL.get().create(world);
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
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(jump, false);
        builder.define(onLeaves, false);
    }

    public boolean isJumping() {
        return this.entityData.get(jump);
    }

    public void setJumping(boolean jumping) {
        this.entityData.set(jump, jumping);
    }

    public boolean isOnLeaves() {
        return this.entityData.get(onLeaves);
    }

    public void setOnLeaves(boolean onLeaves) {
        this.entityData.set(SquirrelEntity.onLeaves, onLeaves);
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
        Vec3 vec;
        int tick;

        public JumpGoal(SquirrelEntity entity, int radius, int height) {
            this.entity = entity;
            this.radius = radius;
            this.height = height;
        }

        @Override
        public boolean canUse() {
            return /*this.entity.random.nextFloat() < 0.02f && */!this.entity.isOnLeaves() && canJump();
        }

        @Override
        public void start() {
            this.entity.setDeltaMovement(this.vec);
            this.entity.hasImpulse = true;
        }

        @Override
        public void tick() {
            super.tick();
            this.entity.getNavigation().stop();
            this.entity.getLookControl().setLookAt(vec);
            this.entity.hasImpulse = true;
            this.tick--;
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.setOnLeaves(true);
            this.entity.setJumping(false);
        }

        @Override
        public boolean canContinueToUse() {
            return this.tick > 0;
        }

        @Override
        public boolean isInterruptable() {
            return this.tick <= 0;
        }

        boolean canJump() {
            for (int i = -radius; i <= radius; i++) {
                for (int j = 0; j <= height; j++) {
                    for (int k = -radius; k <= radius; k++) {
                        BlockPos pos = this.entity.blockPosition().offset(i, j, k);

                        BlockState state = this.entity.level().getBlockState(pos);
                        if (state.is(BlockTags.LEAVES)) {
                            this.entity.leavesPos.add(pos);
                        } else if (state.is(Blocks.AIR) || !state.isSolidRender(this.entity.level(), pos)) {
                            this.entity.airPos.add(pos);
                        }
                    }
                }
            }

            //ici
            for (BlockPos pos : this.entity.leavesPos) {
                if (this.entity.airPos.contains(pos.above())) {
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
            int overshoot = this.entity.random.nextIntBetweenInclusive(1, 3);
            boolean bl = true;
            for (int i = 0; i < 1; i++) {
                calculateJumpVelocity(this.entity.blockPosition(), pos, overshoot);
                int distance = (int) (1.3 * WorldGenUtil.getDistance(this.entity.blockPosition(), pos));
                double totalTime = (2 * this.vY) / 0.08;
                this.tick = (int) Math.ceil(totalTime);

                // on calcule les positions par lesquelles l'écureuil va passer
                for (int j = 0; j < distance; j++) {
                    int tick = (int) (totalTime * ((double) j / distance));

                    int x = (int) (vec.x * tick);
                    int y = (int) (vec.y * tick - 0.08 * tick * tick);
                    int z = (int) (vec.z * tick);
                    BlockPos internalPos = this.entity.blockPosition().offset(x, y, z);
                    if (internalPos.equals(this.entity.blockPosition()) || internalPos.equals(pos)) {
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

            this.vec = new Vec3(vX, this.vY, vZ);
        }
    }

    public static class jumpFromTreeGoal extends Goal {
        SquirrelEntity entity;

        public jumpFromTreeGoal(SquirrelEntity entity) {
            this.entity = entity;
        }

        @Override
        public boolean canUse() {
            return this.entity.isOnLeaves() && this.entity.random.nextFloat() < 0.7f;
        }
    }
}
