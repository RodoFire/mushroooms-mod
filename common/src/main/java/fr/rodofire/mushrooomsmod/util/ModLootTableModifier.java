package fr.rodofire.mushrooomsmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import fr.rodofire.mushrooomsmod.block.ModBlocks;

public class ModLootTableModifier {
    private static final ResourceLocation SNIFFER_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "gameplay/sniffer_digging");

    public static void modifyLootTable() {
        //TODO fix this
        /*LootTableEvents.MODIFY.register((key, tableBuilder, source, lookup) -> {
            if (SNIFFER_ID.equals(key.registry())) {
                LootPool.Builder pool = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(1f))
                        .add(LootItem.lootTableItem(ModBlocks.PREHISTORIC_ROSE));
                tableBuilder.withPool(pool);
            }

        });*/
    }
}
