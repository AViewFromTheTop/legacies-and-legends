package net.legacy.legacies_and_legends.registry;

import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.equipment.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item.Properties;

import java.util.function.Function;

public final class LaLGearItems {

    // Equipment
    public static final LaLGenericWeapon HOOK = register("hook", settings -> new LaLGenericWeapon(LaLToolMaterial.HOOK, 4f, -3.2f, settings
            .stacksTo(1)
            .durability(750)
    ));
    public static final LaLGenericWeapon KNIFE = register("knife", settings -> new LaLGenericWeapon(LaLToolMaterial.KNIFE, 2f, -2f, settings
            .stacksTo(1)
            .durability(3048)
    ));

    // Artifacts
    public static final LaLVerdantSword VERDANT_SWORD = register("verdant_sword", settings -> new LaLVerdantSword(LaLToolMaterial.VERDANT, 3f, -2.4f, settings
            .stacksTo(1)
    ));
    public static final AxeItem CLEAVING_BATTLEAXE = register("cleaving_battleaxe", settings -> new LaLCleavingBattleaxe(LaLToolMaterial.CLEAVING, 5f, -3f, settings
            .stacksTo(1)
    ));
    public static final PickaxeItem MOLTEN_PICKAXE = register("molten_pickaxe", settings -> new PickaxeItem(LaLToolMaterial.MOLTEN, 1f, -2.8f, settings
            .stacksTo(1)
    ));
    public static final ShovelItem PROSPECTOR_SHOVEL = register("prospector_shovel", settings -> new ShovelItem(LaLToolMaterial.PROSPECTOR, 1.5f, -3f, settings
            .stacksTo(1)
    ));
    public static final LaLWitheredHoe WITHERED_HOE = register("withered_hoe", settings -> new LaLWitheredHoe(LaLToolMaterial.WITHERED, -1f, -1f, settings
            .stacksTo(1)
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
