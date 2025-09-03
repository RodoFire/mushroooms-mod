package fr.rodofire.mushrooomsmod.entity;

import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import fr.rodofire.mushrooomsmod.entity.custom.*;
import fr.rodofire.mushrooomsmod.platform.Services;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;

import java.util.function.Supplier;

public class ModEntities {
    /* ---------- Monsters ---------- */
    public static final Supplier<EntityType<CrystalCreeperEntity>> CRYSTAL_CREEPER =
            register("crystal_creeper", CrystalCreeperEntity::new, MobCategory.MONSTER, 0.6f, 1.7f);

    /* ---------- Animals ---------- */
    public static final Supplier<EntityType<GrokiEntity>> GROKI =
            register("groki", GrokiEntity::new, MobCategory.AMBIENT, 0.9f, 1.45f);
    public static final Supplier<EntityType<BoleteCowEntity>> BOLETE_COW =
            register("bolete_cow", BoleteCowEntity::new, MobCategory.AMBIENT, 1.3f, 1.8f);
    public static final Supplier<EntityType<PlotiEntity>> PLOTI =
            register("ploti", PlotiEntity::new, MobCategory.AMBIENT, 0.25f, 0.3f);
    public static final Supplier<EntityType<SchroomStickEntity>> SCHROOM_STICK =
            register("schroom_stick", SchroomStickEntity::new, MobCategory.AMBIENT, 0.4f, 1.6f);
    public static final Supplier<EntityType<SquirrelEntity>> SQUIRREL =
            register("squirrel", SquirrelEntity::new, MobCategory.CREATURE, 0.5f, 0.6f);

    /* ---------- Golems ---------- */
    public static final Supplier<EntityType<CrystalGolemEntity>> CRYSTAL_GOLEM =
            register("crystal_golem", CrystalGolemEntity::new, MobCategory.CREATURE, 1.2f, 2.8f);

    /* ---------- Misc ---------- */
    public static final Supplier<EntityType<InventoryArmorStandEntity>> INVENTORY_ARMOR_STAND_ENTITY =
            register("inventory_armor_stand", InventoryArmorStandEntity::new, MobCategory.MISC, 0.9f, 1.8f);
    public static final Supplier<EntityType<LockedInventoryArmorStand>> LOCKED_INVENTORY_ARMOR_STAND =
            register("locked_inventory_armor_stand", LockedInventoryArmorStand::new, MobCategory.MISC, 0.9f, 1.8f);

    private static <T extends Entity> Supplier<EntityType<T>> register(
            String name,
            EntityType.EntityFactory<T> factory,
            MobCategory group,
            float width,
            float height
    ) {
        // La plateforme (NeoForge/Fabric) fera l’enregistrement au bon moment
        return Services.PLATFORM.registerEntityType(
                name,
                () -> EntityType.Builder.of(factory, group).sized(width, height).build(name)
        );
    }

    public static void registerModENtities() {
        MushrooomsModConstants.LOGGER.info("|\t-Registering Entities.");
        // Rien d’autre ici: l’enregistrement réel est géré par DeferredRegister via Services.PLATFORM
    }

}
