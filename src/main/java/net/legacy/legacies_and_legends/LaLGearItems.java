package net.legacy.legacies_and_legends;

import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item.Properties;

import java.util.function.Function;

public final class LaLGearItems {

    // Weapons
    public static final LaLWeapon HOOK = register("hook", settings -> new LaLWeapon(LaLToolMaterial.METAL, 4f, -3.2f, settings
            .stacksTo(1)
            .durability(750)
    ));
    public static final LaLWeapon ANCIENT_KNIFE = register("ancient_knife", settings -> new LaLWeapon(LaLToolMaterial.ANCIENT, 2f, -2f, settings
            .stacksTo(1)
            .durability(3048)
    ));

    // Armor
    public static final ArmorItem DUNGEON_HELMET = register("dungeon_helmet", settings -> new ArmorItem(LaLArmorMaterials.DUNGEON, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.HELMET.getDurability(27))
    ));
    public static final ArmorItem DUNGEON_CHESTPLATE = register("dungeon_chestplate", settings -> new ArmorItem(LaLArmorMaterials.DUNGEON, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.CHESTPLATE.getDurability(27))
    ));
    public static final ArmorItem DUNGEON_LEGGINGS = register("dungeon_leggings", settings -> new ArmorItem(LaLArmorMaterials.DUNGEON, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.LEGGINGS.getDurability(27))
    ));
    public static final ArmorItem DUNGEON_BOOTS = register("dungeon_boots", settings -> new ArmorItem(LaLArmorMaterials.DUNGEON, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.BOOTS.getDurability(27))
    ));

    public static final ArmorItem FORTRESS_HELMET = register("fortress_helmet", settings -> new ArmorItem(LaLArmorMaterials.FORTRESS, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.HELMET.getDurability(23))
            .fireResistant()
    ));
    public static final ArmorItem FORTRESS_CHESTPLATE = register("fortress_chestplate", settings -> new ArmorItem(LaLArmorMaterials.FORTRESS, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.CHESTPLATE.getDurability(23))
            .fireResistant()
    ));
    public static final ArmorItem FORTRESS_LEGGINGS = register("fortress_leggings", settings -> new ArmorItem(LaLArmorMaterials.FORTRESS, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.LEGGINGS.getDurability(23))
            .fireResistant()
    ));
    public static final ArmorItem FORTRESS_BOOTS = register("fortress_boots", settings -> new ArmorItem(LaLArmorMaterials.FORTRESS, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.BOOTS.getDurability(23))
            .fireResistant()
    ));

    public static final ArmorItem WARD_HELMET = register("ward_helmet", settings -> new ArmorItem(LaLArmorMaterials.WARD, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.HELMET.getDurability(41))
    ));
    public static final ArmorItem WARD_CHESTPLATE = register("ward_chestplate", settings -> new ArmorItem(LaLArmorMaterials.WARD, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.CHESTPLATE.getDurability(41))
    ));
    public static final ArmorItem WARD_LEGGINGS = register("ward_leggings", settings -> new ArmorItem(LaLArmorMaterials.WARD, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.LEGGINGS.getDurability(41))
    ));
    public static final ArmorItem WARD_BOOTS = register("ward_boots", settings -> new ArmorItem(LaLArmorMaterials.WARD, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.BOOTS.getDurability(41))
    ));

    public static void init() {
    }

    private static @NotNull <T extends Item> T register(String name, @NotNull Function<Properties, Item> function) {
        return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, LaLConstants.id(name)), function);
    }

    private static Item register (String name) {
        return register(name, Item::new);
    }

    public static Function<Properties, Item> createBlockItemWithCustomItemName(Block block) {
        return properties -> new BlockItem(block, properties.useItemDescriptionPrefix());
    }

}
