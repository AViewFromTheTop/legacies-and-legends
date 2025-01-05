package net.legacy.legacies_and_legends;

import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.Map;

public interface LegaciesEquipmentAssets {
    ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID = ResourceKey.createRegistryKey(ResourceLocation.withDefaultNamespace("equipment_asset"));
    ResourceKey<EquipmentAsset> DUNGEON = createId("dungeon");

    static ResourceKey<EquipmentAsset> createId(String path) {
        return ResourceKey.create(ROOT_ID, LegaciesConstants.id(path));
    }
}
