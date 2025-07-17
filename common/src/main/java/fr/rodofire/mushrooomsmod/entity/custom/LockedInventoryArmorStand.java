package fr.rodofire.mushrooomsmod.entity.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class LockedInventoryArmorStand extends InventoryArmorStandEntity {
    private final List<UUID> autorizedPlayers = new ArrayList<>();
    private UUID keyUUID;

    public LockedInventoryArmorStand(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    public UUID getKeyUUID() {
        return keyUUID;
    }

    public void setKeyUUID(UUID keyUUID) {
        System.out.println("uuid: " + this.keyUUID);
        this.keyUUID = keyUUID;
        System.out.println("uuid: " + this.keyUUID);
    }

    public void addAutorizedPlayer(UUID uuid) {
        autorizedPlayers.add(uuid);
    }

    public List<UUID> getAutorizedPlayers() {
        return autorizedPlayers;
    }

    @Override
    public boolean canPlayerUse(Player entity) {
        return autorizedPlayers.contains(entity.getUUID());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        writeCommonNbt(nbt);
        ListTag nbtList4 = new ListTag();
        for (UUID uuid : autorizedPlayers) {
            CompoundTag nbtCompound2 = new CompoundTag();
            nbtCompound2.putUUID("uuid", uuid);

            nbtList4.add(nbtCompound2);
        }

        nbt.put("player_uuid", nbtList4);

        CompoundTag keyCompound = new CompoundTag();

        if (keyUUID != null)
            keyCompound.putUUID("key_uuid_most", keyUUID);

        nbt.put("key_uuid", keyCompound);
    }


    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        readCommonNbt(nbt);
        if (nbt.contains("player_uuid")) {
            ListTag nbtList = nbt.getList("player_uuid", Tag.TAG_COMPOUND);
            for (int i = 0; i < nbtList.size(); ++i) {
                this.autorizedPlayers.add(i, nbtList.getCompound(i).getUUID("uuid"));
            }
        }
        if (nbt.contains("key_uuid")) {
            CompoundTag nbtCompound = nbt.getCompound("key_uuid");
            keyUUID = nbtCompound.getUUID("key_uuid_most");
        }
    }
}
