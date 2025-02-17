package net.legacy.legacies_and_legends.registry;

import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.material.LaLToolMaterial;
import net.legacy.legacies_and_legends.misc.LaLWeapon;
import net.legacy.legacies_and_legends.material.LaLArmorMaterials;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item.Properties;

import java.util.function.Function;

public final class LaLGearItems {

    // Equipment
    public static final LaLWeapon HOOK = register("hook", settings -> new LaLWeapon(LaLToolMaterial.HOOK, 4f, -3.2f, settings
            .stacksTo(1)
            .durability(750)
    ));
    public static final LaLWeapon KNIFE = register("knife", settings -> new LaLWeapon(LaLToolMaterial.KNIFE, 2f, -2f, settings
            .stacksTo(1)
            .durability(3048)
    ));

    // Artifacts
    public static final ArmorItem REINFORCED_CHESTPLATE = register("reinforced_chestplate", settings -> new ArmorItem(LaLArmorMaterials.REINFORCED, ArmorType.CHESTPLATE, settings
            .stacksTo(1)
    ));
    public static final ArmorItem TRAVELLING_STRIDES = register("travelling_strides", settings -> new ArmorItem(LaLArmorMaterials.TRAVELLING, ArmorType.LEGGINGS, settings
            .stacksTo(1)
    ));
    public static final ArmorItem WANDERER_BOOTS = register("wanderer_boots", settings -> new ArmorItem(LaLArmorMaterials.WANDERER, ArmorType.BOOTS, settings
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

    public static ItemAttributeModifiers createAmuletOfAllureAttributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.TEMPT_RANGE, new AttributeModifier(TEMPT_RANGE_ID, 10, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HEAD)
                .build();
    }

    public static final ResourceLocation TEMPT_RANGE_ID = ResourceLocation.withDefaultNamespace("tempt_range");

}
