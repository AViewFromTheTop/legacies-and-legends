package net.legacy.legacies_and_legends.material;

import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;

public interface LaLArmorMaterials {
    net.minecraft.world.item.equipment.ArmorMaterial WANDERER = new net.minecraft.world.item.equipment.ArmorMaterial(27, Util.make(new EnumMap(ArmorType.class), enumMap -> {
        enumMap.put(ArmorType.BOOTS, 2);
    }), 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.1F, LaLItemTags.REPAIRS_WANDERER_ARMOR, LaLEquipmentAssets.WANDERER);

    net.minecraft.world.item.equipment.ArmorMaterial TRAVELLING = new net.minecraft.world.item.equipment.ArmorMaterial(9, Util.make(new EnumMap(ArmorType.class), enumMap -> {
        enumMap.put(ArmorType.LEGGINGS, 3);
    }), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, LaLItemTags.REPAIRS_TRAVELLING_ARMOR, LaLEquipmentAssets.TRAVELLING);

    net.minecraft.world.item.equipment.ArmorMaterial REINFORCED = new net.minecraft.world.item.equipment.ArmorMaterial(41, Util.make(new EnumMap(ArmorType.class), enumMap -> {
        enumMap.put(ArmorType.CHESTPLATE, 7);
    }), 8, SoundEvents.ARMOR_EQUIP_NETHERITE, 0.0F, 0.5F, LaLItemTags.REPAIRS_REINFORCED_ARMOR, LaLEquipmentAssets.REINFORCED);
}