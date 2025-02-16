package net.legacy.legacies_and_legends;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentAsset;

public interface LaLEquipmentAssets {
    ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID = ResourceKey.createRegistryKey(ResourceLocation.withDefaultNamespace("equipment_asset"));
    ResourceKey<EquipmentAsset> WANDERER = createId("wanderer");
    ResourceKey<EquipmentAsset> TRAVELLING = createId("travelling");
    ResourceKey<EquipmentAsset> REINFORCED = createId("reinforced");

    static ResourceKey<EquipmentAsset> createId(String name) {
        return ResourceKey.create(ROOT_ID, ResourceLocation.withDefaultNamespace(name));
    }
}
