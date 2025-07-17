package fr.rodofire.mushrooomsmod.entity;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.entity.custom.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;

public class ModEntities {
    /* ---------- Monsters ---------- */
    public static final EntityType<CrystalCreeperEntity> CRYSTAL_CREEPER = register("crystal_creeper", CrystalCreeperEntity::new, MobCategory.MONSTER, 0.6f, 1.7f);

    /* ---------- Animals ---------- */
    public static final EntityType<GrokiEntity> GROKI = register("groki", GrokiEntity::new, MobCategory.AMBIENT, 0.9f, 1.45f);
    public static final EntityType<BoleteCowEntity> BOLETE_COW = register("bolete_cow", BoleteCowEntity::new, MobCategory.AMBIENT, 1.3f, 1.8f);
    public static final EntityType<PlotiEntity> PLOTI = register("ploti", PlotiEntity::new, MobCategory.AMBIENT, 0.25f, 0.3f);
    public static final EntityType<SchroomStickEntity> SCHROOM_STICK = register("schroom_stick", SchroomStickEntity::new, MobCategory.AMBIENT, 0.4f, 1.6f);
    public static final EntityType<SquirrelEntity> SQUIRREL = register("squirrel", SquirrelEntity::new, MobCategory.CREATURE, 0.5f, 0.6f);

    /* ---------- Golems ---------- */
    public static final EntityType<CrystalGolemEntity> CRYSTAL_GOLEM = register("crystal_golem", CrystalGolemEntity::new, MobCategory.CREATURE, 1.2f, 2.8f);

    /* ---------- Misc ---------- */
    public static final EntityType<InventoryArmorStandEntity> INVENTORY_ARMOR_STAND_ENTITY = register("inventory_armor_stand", InventoryArmorStandEntity::new, MobCategory.MISC, 0.9f, 1.8f);
    public static final EntityType<LockedInventoryArmorStand> LOCKED_INVENTORY_ARMOR_STAND = register("locked_inventory_armor_stand", LockedInventoryArmorStand::new, MobCategory.MISC, 0.9f, 1.8f);


    /*public static final EntityType<SchroomStickEntity> SCHROOM_STICK = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MushrooomsModConstants.MOD_ID, "schroom_stick"), EntityType.Builder.create(SchroomStickEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.3f, 1.6f).build());*/
    /*public static final EntityType<MosquitoEntity> MOSQUITO_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MushrooomsModConstants.MOD_ID, "mosquito"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, MosquitoEntity::new)
                    .dimensions(EntityDimensions.fixed(0.2f, 0.5f)).build());*/


    public static <T extends Entity> EntityType<T> register(String name, EntityType.EntityFactory<T> factory, MobCategory spawngroup, float width, float height) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, name));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, EntityType.Builder.of(factory, spawngroup).sized(width, height).build("thekey"));
    }

    public static void registerModENtities() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Entities.");
    }

    public static void spawnRestriction() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Spawn Restrictions.");
        SpawnPlacements.register(ModEntities.CRYSTAL_GOLEM, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrystalGolemEntity::checkMobSpawnRules);
        SpawnPlacements.register(ModEntities.CRYSTAL_CREEPER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntities.PLOTI, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PlotiEntity::checkAnimalSpawnRules);
        SpawnPlacements.register(ModEntities.SCHROOM_STICK, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SchroomStickEntity::checkAnimalSpawnRules);
        SpawnPlacements.register(ModEntities.BOLETE_COW, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BoleteCowEntity::checkAnimalSpawnRules);
        SpawnPlacements.register(ModEntities.SQUIRREL, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SquirrelEntity::checkAnimalSpawnRules);
    }

}
