package net.legacy.legacies_and_legends.registry;

import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.item.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item.Properties;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class LaLEquipmentItems {

    // Equipment
    public static final GenericWeaponItem HOOK = register("hook", settings -> new GenericWeaponItem(LaLToolMaterial.HOOK, 3F, -3.2F, settings
            .stacksTo(1)
            .durability(750)
            .enchantable(15)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final GenericWeaponItem KNIFE = register("knife", settings -> new GenericWeaponItem(LaLToolMaterial.KNIFE, 2F, -1.4F, settings
            .stacksTo(1)
            .durability(3048)
            .enchantable(15)
            .rarity(Rarity.RARE)
    ));

    // Artifacts
    public static final VerdantSwordItem VERDANT_SWORD = register("verdant_sword", settings -> new VerdantSwordItem(settings
            .stacksTo(1)
            .rarity(Rarity.UNCOMMON)
            .sword(LaLToolMaterial.VERDANT, 3F, -2.4F)
    ));
    public static final CleavingBattleAxeItem CLEAVING_BATTLEAXE = register("cleaving_battleaxe", settings -> new CleavingBattleAxeItem(settings
            .stacksTo(1)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final Item MOLTEN_PICKAXE = register("molten_pickaxe", settings -> new Item(settings
            .stacksTo(1)
            .rarity(Rarity.RARE)
            .pickaxe(LaLToolMaterial.MOLTEN, 1F, -2.8F)
    ));
    public static final ShovelItem PROSPECTOR_SHOVEL = register("prospector_shovel", settings -> new ShovelItem(LaLToolMaterial.PROSPECTOR, 1.5F, -3F, settings
            .stacksTo(1)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final WitheredHoeItem WITHERED_HOE = register("withered_hoe", settings -> new WitheredHoeItem(LaLToolMaterial.WITHERED, -1F, -1F, settings
            .stacksTo(1)
            .rarity(Rarity.UNCOMMON)
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
