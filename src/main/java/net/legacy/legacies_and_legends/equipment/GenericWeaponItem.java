package net.legacy.legacies_and_legends.equipment;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class GenericWeaponItem extends Item {
    public GenericWeaponItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(material.applySwordProperties(properties, attackDamage, attackSpeed));
    }
}