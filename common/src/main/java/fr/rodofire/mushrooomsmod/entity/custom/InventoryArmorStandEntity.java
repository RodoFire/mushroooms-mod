package fr.rodofire.mushrooomsmod.entity.custom;

import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import fr.rodofire.mushrooomsmod.item.ModItems;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

public class InventoryArmorStandEntity extends LivingEntity implements GeoEntity {
    protected static final EntityDataAccessor<Boolean> CAN_USE = SynchedEntityData.defineId(InventoryArmorStandEntity.class, EntityDataSerializers.BOOLEAN);
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    protected final NonNullList<ItemStack> heldItems = NonNullList.withSize(2, ItemStack.EMPTY);
    protected final NonNullList<ItemStack> armorItems = NonNullList.withSize(4, ItemStack.EMPTY);
    protected final NonNullList<ItemStack> inventory = NonNullList.withSize(36, ItemStack.EMPTY);
    private int lefttickusage;
    public long lastHitTime;
    private boolean invisible;


    public InventoryArmorStandEntity(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
        this.yBodyRot = ((int) (this.yBodyRot / 45.0f)) * 45.0f;
        this.yHeadRot = ((int) (this.yHeadRot / 45.0f)) * 45.0f;
    }

    public NonNullList<NonNullList<ItemStack>> getInventory() {
        NonNullList<NonNullList<ItemStack>> inventoryLists = NonNullList.withSize(3, NonNullList.create());

        inventoryLists.set(0, heldItems);
        inventoryLists.set(1, armorItems);
        inventoryLists.set(2, inventory);

        return inventoryLists;
    }

    public void setInventory(NonNullList<NonNullList<ItemStack>> inventory) {
        NonNullList<ItemStack> held = inventory.get(0);
        NonNullList<ItemStack> armor = inventory.get(1);
        NonNullList<ItemStack> base = inventory.get(2);
        for (int i = 0; i < held.size(); i++) {
            heldItems.set(i, held.get(i));
        }
        for (int i = 0; i < armor.size(); i++) {
            armorItems.set(i, armor.get(i));
        }
        for (int i = 0; i < base.size(); i++) {
            this.inventory.set(i, base.get(i));
        }
    }
    @Override
    public void kill() {
        this.remove(RemovalReason.KILLED);
        this.gameEvent(GameEvent.ENTITY_DIE);
    }


    @Override
    public void setYRot(float yaw) {
        yaw = ((int) (yaw / 45.0f)) * 45.0f;
        super.setYRot(yaw);
    }

    @Override
    public boolean shouldShowName() {
        return false;
    }

    @Override
    public Iterable<ItemStack> getArmorSlots() {
        return this.armorItems;
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot slot) {
        return switch (slot.getType()) {
            case HAND -> this.heldItems.get(slot.getIndex());
            case HUMANOID_ARMOR -> this.armorItems.get(slot.getIndex());
            default -> ItemStack.EMPTY;
        };
    }

    @Override
    public void setItemSlot(EquipmentSlot slot, ItemStack stack) {
        this.verifyEquippedItem(stack);
        switch (slot.getType()) {
            case HAND: {
                this.onEquipItem(slot, this.heldItems.set(slot.getIndex(), stack), stack);
                break;
            }
            case HUMANOID_ARMOR: {
                this.onEquipItem(slot, this.armorItems.set(slot.getIndex(), stack), stack);
            }
        }
    }


    @Override
    public HumanoidArm getMainArm() {
        return HumanoidArm.RIGHT;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public void playerTouch(Player player) {
        if (player.blockPosition().getX() != this.blockPosition().getX() || player.blockPosition().getY() != this.blockPosition().getY() || player.blockPosition().getZ() != this.blockPosition().getZ())
            return;
        if (!this.canUse()) return;
        if (!this.canPlayerUse(player)) return;
        //Get player inventory and store it and give the previous inventory to the player
        for (int i = 1; i < 36; i++) {
            ItemStack stack = player.getInventory().getItem(i);
            ItemStack stack2 = this.inventory.get(i);
            this.inventory.set(i, stack);
            player.getInventory().setItem(i, stack2);
        }
        //get Armor Slots
        for (int i = 0; i < 4; i++) {
            ItemStack stack = player.getInventory().getItem(i + 36);
            ItemStack stack2 = this.armorItems.get(i);
            this.armorItems.set(i, stack);
            player.getInventory().setItem(i + 36, stack2);
        }
        ItemStack pstack = player.getInventory().getItem(0);
        ItemStack pstack2 = player.getInventory().getItem(40);
        ItemStack istack = this.heldItems.get(0);
        ItemStack istack2 = this.heldItems.get(1);
        this.heldItems.set(0, pstack);
        this.heldItems.set(1, pstack2);
        player.getInventory().setItem(0, istack);
        player.getInventory().setItem(40, istack2);
        this.setUse(false);
        this.lefttickusage = 160;
    }

    @Override
    public void setYHeadRot(float headYaw) {
        headYaw = ((int) (headYaw / 45.0f)) * 45.0f;
        super.setYHeadRot(headYaw);
    }

    @Override
    public void setYBodyRot(float bodyYaw) {
        bodyYaw = ((int) (bodyYaw / 45.0f)) * 45.0f;
        super.setYBodyRot(bodyYaw);
    }

    public boolean canPlayerUse(Player entity) {
        return true;
    }

    @Override
    public void tick() {
        if (this.lefttickusage > 0) {
            --this.lefttickusage;
            if (this.lefttickusage == 0) {
                this.setUse(true);
            }
        }
        super.tick();
    }

    @Override
    public void moveTo(double x, double y, double z, float yaw, float pitch) {
        super.moveTo(x, y, z, yaw, pitch);
        this.setYHeadRot(yaw);
        this.setYBodyRot(yaw);
    }

    @Override
    protected void tickDeath() {
        if (++this.deathTime >= 1 && !this.level().isClientSide() && !this.isRemoved()) {
            this.level().broadcastEntityEvent(this, EntityEvent.POOF);
            this.remove(RemovalReason.KILLED);
        }
    }

    @Override
    protected void doPush(Entity entity) {
    }

    public boolean canUse() {
        return this.entityData.get(CAN_USE);
    }

    public void setUse(boolean bl) {
        this.entityData.set(CAN_USE, bl);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(CAN_USE, true);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        if (!this.canUse()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.inventory_armor_stand.entity_collision", Animation.LoopType.HOLD_ON_LAST_FRAME));
        } else {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.inventory_armor_stand.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isRemoved()) {
            return false;
        } else if (this.level() instanceof ServerLevel serverWorld) {
            if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                this.kill();
                return false;
            } else if (this.isInvulnerableTo(source) || this.invisible) {
                return false;
            } else if (source.is(DamageTypeTags.IS_EXPLOSION)) {
                this.onBreak(serverWorld, source);
                this.kill();
                return false;
            } else if (source.is(DamageTypeTags.IGNITES_ARMOR_STANDS)) {
                if (this.isOnFire()) {
                    this.updateHealth(serverWorld, source, 0.15F);
                } else {
                    this.igniteForSeconds(5.0F);
                }

                return false;
            } else if (source.is(DamageTypeTags.BURNS_ARMOR_STANDS) && this.getHealth() > 0.5F) {
                this.updateHealth(serverWorld, source, 4.0F);
                return false;
            } else {
                boolean bl = source.is(DamageTypeTags.CAN_BREAK_ARMOR_STAND);
                boolean bl2 = source.is(DamageTypeTags.ALWAYS_KILLS_ARMOR_STANDS);
                if (!bl && !bl2) {
                    return false;
                } else {
                    if (source.getEntity() instanceof Player playerEntity && !playerEntity.getAbilities().mayBuild) {
                        return false;
                    }

                    this.push(new Vec3(0,0.3,0));
                    this.hasImpulse = true;

                    if (source.isCreativePlayer()) {
                        this.playBreakSound();
                        this.spawnBreakParticles();
                        this.kill();
                        return true;
                    } else {
                        long l = serverWorld.getGameTime();
                        if (l - this.lastHitTime > 5L && !bl2) {
                            serverWorld.broadcastEntityEvent(this, EntityEvent.ARMORSTAND_WOBBLE);
                            this.gameEvent(GameEvent.ENTITY_DAMAGE, source.getEntity());
                            this.lastHitTime = l;
                        } else {
                            this.breakAndDropItem(serverWorld, source);
                            this.spawnBreakParticles();
                            this.kill();
                        }

                        return true;
                    }
                }
            }
        } else {
            return false;
        }
    }

    private void breakAndDropItem(ServerLevel world, DamageSource damageSource) {
        ItemStack itemStack = new ItemStack(ModItems.INVENTORY_ARMOR_STAND.get());
        itemStack.set(DataComponents.CUSTOM_NAME, this.getCustomName());
        Block.popResource(this.level(), this.blockPosition(), itemStack);
        this.onBreak(world, damageSource);
    }

    @Override
    public void handleEntityEvent(byte status) {
        if (status == EntityEvent.ARMORSTAND_WOBBLE) {
            if (this.level().isClientSide) {
                this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.ARMOR_STAND_HIT, this.getSoundSource(), 0.3F, 1.0F, false);
                this.lastHitTime = this.level().getGameTime();
            }
        } else {
            super.handleEntityEvent(status);
        }
    }

    private void spawnBreakParticles() {
        if (this.level() instanceof ServerLevel) {
            ((ServerLevel)this.level())
                    .sendParticles(
                            new BlockParticleOption(ParticleTypes.BLOCK, Blocks.OAK_PLANKS.defaultBlockState()),
                            this.getX(),
                            this.getY(0.6666666666666666),
                            this.getZ(),
                            10,
                            (double)(this.getBbWidth() / 4.0F),
                            (double)(this.getBbHeight() / 4.0F),
                            (double)(this.getBbWidth() / 4.0F),
                            0.05
                    );
        }
    }

    private void updateHealth(ServerLevel world, DamageSource damageSource, float amount) {
        float f = this.getHealth();
        f -= amount;
        if (f <= 0.5F) {
            this.onBreak(world, damageSource);
            this.kill();
        } else {
            this.setHealth(f);
            this.gameEvent(GameEvent.ENTITY_DAMAGE, damageSource.getEntity());
        }
    }

    private void playBreakSound() {
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ARMOR_STAND_BREAK, this.getSoundSource(), 1.0F, 1.0F);
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ARMOR_STAND_BREAK;
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(ModItems.INVENTORY_ARMOR_STAND.get());
    }

    protected void writeCommonNbt(CompoundTag nbt) {
        ListTag nbtList = new ListTag();
        ListTag nbtList2 = new ListTag();
        ListTag nbtList3 = new ListTag();
        for (ItemStack itemStack : this.armorItems) {
            nbtList.add(itemStack.saveOptional(this.registryAccess()));
        }
        nbt.put("ArmorItems", nbtList);

        for (ItemStack itemStack : this.heldItems) {
            nbtList2.add(itemStack.saveOptional(this.registryAccess()));
        }
        nbt.put("HeldItem", nbtList2);

        for (ItemStack itemStack : this.inventory) {
            nbtList3.add(itemStack.saveOptional(this.registryAccess()));
        }
        nbt.put("Inventory", nbtList3);
    }

    protected void readCommonNbt(CompoundTag nbt) {
        CompoundTag nbtCompound;
        if (nbt.contains("ArmorItems", Tag.TAG_LIST)) {
            ListTag nbtList = nbt.getList("ArmorItems", Tag.TAG_COMPOUND);
            for (int i = 0; i < this.armorItems.size(); ++i) {
                nbtCompound = nbtList.getCompound(i);
                this.armorItems.set(i, ItemStack.parseOptional(this.registryAccess(), nbtCompound));
            }
        }
        if (nbt.contains("HeldItem", Tag.TAG_LIST)) {
            ListTag nbtList = nbt.getList("HeldItem", Tag.TAG_COMPOUND);
            for (int i = 0; i < this.heldItems.size(); ++i) {
                nbtCompound = nbtList.getCompound(i);
                this.heldItems.set(i, ItemStack.parseOptional(this.registryAccess(), nbtCompound));
            }
        }
        if (nbt.contains("Inventory", Tag.TAG_LIST)) {
            ListTag nbtList = nbt.getList("Inventory", Tag.TAG_COMPOUND);
            for (int i = 0; i < this.inventory.size(); ++i) {
                nbtCompound = nbtList.getCompound(i);
                this.inventory.set(i, ItemStack.parseOptional(this.registryAccess(), nbtCompound));
            }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        writeCommonNbt(nbt);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        readCommonNbt(nbt);
    }

    private void onBreak(ServerLevel world, DamageSource damageSource) {
        this.playBreakSound();
        this.dropAllDeathLoot(world, damageSource);

        for (ItemStack itemStack : this.inventory) {
            this.spawnAtLocation(itemStack);
        }
        for (ItemStack itemStack : this.armorItems) {
            this.spawnAtLocation(itemStack);
        }
        for (ItemStack itemStack : this.heldItems) {
            this.spawnAtLocation(itemStack);
        }
    }

    @Override
    public void knockback(double strength, double x, double z) {
    }
}
