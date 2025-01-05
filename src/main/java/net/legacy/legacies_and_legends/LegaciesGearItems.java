package net.legacy.legacies_and_legends;

import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item.Properties;

import java.util.function.Function;

public final class LegaciesGearItems {


    // Weapons
    public static final LegaciesWeapon HOOK = register("hook", settings -> new LegaciesWeapon(LegaciesToolMaterial.METAL, 4f, -3.2f, settings
            .stacksTo(1)
            .durability(750)
    ));
    public static final LegaciesWeapon ANCIENT_KNIFE = register("ancient_knife", settings -> new LegaciesWeapon(LegaciesToolMaterial.ANCIENT, 2f, -2f, settings
            .stacksTo(1)
            .durability(3048)
    ));

    // Armor
    public static final ArmorItem DUNGEON_HELMET = register("dungeon_helmet", settings -> new ArmorItem(LegaciesArmorMaterials.DUNGEON, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.HELMET.getDurability(27))
    ));

    public static void init() {
    }

    private static @NotNull <T extends Item> T register(String name, @NotNull Function<Properties, Item> function) {
        return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, LegaciesConstants.id(name)), function);
    }

    private static Item register (String name) {
        return register(name, Item::new);
    }

    public static Function<Properties, Item> createBlockItemWithCustomItemName(Block block) {
        return properties -> new BlockItem(block, properties.useItemDescriptionPrefix());
    }

}
