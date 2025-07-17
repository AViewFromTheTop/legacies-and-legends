package net.legacy.legacies_and_legends.mixin.integration.trailiertales;

import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.frozenblock.trailiertales.config.TTEntityConfig;
import net.frozenblock.trailiertales.registry.TTItems;
import net.frozenblock.trailiertales.registry.TTLootTables;
import net.frozenblock.trailiertales.registry.TTMapDecorationTypes;
import net.frozenblock.trailiertales.tag.TTStructureTags;
import net.legacy.legacies_and_legends.config.LaLConfig;
import net.legacy.legacies_and_legends.registry.LaLEquipmentItems;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ExplorationMapFunction;
import net.minecraft.world.level.storage.loot.functions.SetNameFunction;
import net.minecraft.world.level.storage.loot.functions.SetStewEffectFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.apache.commons.lang3.BooleanUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TTLootTables.class)
public abstract class TTLootTablesMixin {

    @Inject(method = "init", at = @At(value = "TAIL"), cancellable = true)
    private static void injectLoot(CallbackInfo ci) {
        LootTableEvents.REPLACE.register((key, lootTable, source, registries) -> {
            if (BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE.equals(key)) {
                // Removed Burn
                // Removed Danger
                // Added Protection
                // Added Crescent
                // Added Catacombs Explorer Map
                // LEGACIES AND LEGENDS: Added Ring of Construction
                // LEGACIES AND LEGENDS: Added Knife
                return LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1F))
                                        .add(
                                                LootItem.lootTableItem(Items.MAP)
                                                        .apply(
                                                                ExplorationMapFunction.makeExplorationMap()
                                                                        .setDestination(TTStructureTags.ON_CATACOMBS_EXPLORER_MAPS)
                                                                        .setMapDecoration(TTMapDecorationTypes.CATACOMBS)
                                                                        .setZoom((byte)1)
                                                                        .setSkipKnownStructures(false)
                                                        )
                                                        .apply(SetNameFunction.setName(Component.translatable("filled_map.trailiertales.catacombs"), SetNameFunction.Target.ITEM_NAME))
                                        )
                                        .add(LootItem.lootTableItem(TTItems.PROTECTION_POTTERY_SHERD))
                                        .add(LootItem.lootTableItem(Items.SHEAF_POTTERY_SHERD))
                                        .add(LootItem.lootTableItem(Items.FRIEND_POTTERY_SHERD))
                                        .add(LootItem.lootTableItem(Items.HEART_POTTERY_SHERD))
                                        .add(LootItem.lootTableItem(Items.HEARTBREAK_POTTERY_SHERD))
                                        .add(LootItem.lootTableItem(Items.HOWL_POTTERY_SHERD))
                                        .add(LootItem.lootTableItem(TTItems.CRESCENT_POTTERY_SHERD))
                                        .add(LootItem.lootTableItem(Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE))
                                        .add(LootItem.lootTableItem(Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE))
                                        .add(LootItem.lootTableItem(Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE))
                                        .add(LootItem.lootTableItem(Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE))
                                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_RELIC))
                                        .add(LootItem.lootTableItem(LaLItems.RING_OF_CONSTRUCTION).setWeight(BooleanUtils.toInteger(LaLConfig.get.accessories.ring_of_construction)))
                                        .add(LootItem.lootTableItem(LaLEquipmentItems.KNIFE).setWeight(BooleanUtils.toInteger(LaLConfig.get.loot.knife)))
                        ).build();
            }

            return null;
        });
    }
}
