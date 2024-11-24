package net.rodofire.mushrooomsmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.entity.custom.*;

import java.util.function.Function;

public class ModEntities {
    public static final EntityType<GrokiEntity> GROKI = register("groki",GrokiEntity::new, SpawnGroup.CREATURE, 0.9f, 1.45f);
    public static final EntityType<BoleteCowEntity> BOLETE_COW = register("bolete_cow",BoleteCowEntity::new, SpawnGroup.CREATURE, 1.3f, 1.8f);
    public static final EntityType<PlotiEntity> PLOTI = register("ploti", PlotiEntity::new, SpawnGroup.CREATURE, 0.25f, 0.3f);
    public static final EntityType<CrystalCreeperEntity> CRYSTAL_CREEPER = register("crystal_creeper", CrystalCreeperEntity::new, SpawnGroup.MONSTER, 0.6f, 1.7f);
    public static final EntityType<CrystalGolemEntity> CRYSTAL_GOLEM = register("crystal_golem",CrystalGolemEntity::new, SpawnGroup.CREATURE, 1.2f, 2.8f);
    public static final EntityType<LockedInventoryArmorStand> LOCKED_INVENTORY_ARMOR_STAND = register("locked_inventory_armor_stand", LockedInventoryArmorStand::new, SpawnGroup.MISC, 0.9f, 1.8f);
    public static final EntityType<InventoryArmorStandEntity> INVENTORY_ARMOR_STAND_ENTITY = register("inventory_armor_stand",InventoryArmorStandEntity::new, SpawnGroup.MISC, 0.9f, 1.8f);

    //public static final EntityType<SchroomStickEntity> SCHROOM_STICK = register("schroom_stick",SchroomStickEntity::new, SpawnGroup.CREATURE, 0.3f, 1.6f);
    /*public static final EntityType<MosquitoEntity> MOSQUITO_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MushrooomsMod.MOD_ID, "mosquito"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, MosquitoEntity::new)
                    .dimensions(EntityDimensions.fixed(0.2f, 0.5f)).build());*/
    public static <T extends Entity> EntityType<T> register(String name, EntityType.EntityFactory<T> factory, SpawnGroup spawngroup, float width, float height){
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MushrooomsMod.MOD_ID, name));
        return Registry.register(Registries.ENTITY_TYPE, key, EntityType.Builder.<T>create(factory, spawngroup).dimensions(width, height).build(key));
    }


    public static void registerModENtities() {
        MushrooomsMod.LOGGER.info("Registering Mod Entities For Mushrooomsmod");
    }

}
