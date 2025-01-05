package net.legacy.legacies_and_legends;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.level.ItemLike;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public interface LegaciesArmorMaterials {
    net.minecraft.world.item.equipment.ArmorMaterial DUNGEON = new net.minecraft.world.item.equipment.ArmorMaterial(5, Util.make(new EnumMap(ArmorType.class), enumMap -> {
        enumMap.put(ArmorType.BOOTS, 2);
        enumMap.put(ArmorType.LEGGINGS, 5);
        enumMap.put(ArmorType.CHESTPLATE, 6);
        enumMap.put(ArmorType.HELMET, 3);
        enumMap.put(ArmorType.BODY, 5);
    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.1F, LegaciesItemTags.REPAIRS_DUNGEON_ARMOR, LegaciesEquipmentAssets.DUNGEON);
}


/*
public class LegaciesArmorMaterialsOld {
    public static final Holder<ArmorMaterial> DUNGEON;
    public static final Holder<ArmorMaterial> FORTRESS;
    public static final Holder<ArmorMaterial> WARD;

    public LegaciesArmorMaterials() {
    }

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(ResourceLocation.withDefaultNamespace(name)));
        return register(name, defense, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngridient, List<ArmorMaterial.Layer> layers) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);
        ArmorItem.Type[] var9 = ArmorItem.Type.values();
        int var10 = var9.length;

        for(int var11 = 0; var11 < var10; ++var11) {
            ArmorItem.Type type = var9[var11];
            enumMap.put(type, (Integer)defense.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, ResourceLocation.withDefaultNamespace(name), new ArmorMaterial(enumMap, enchantmentValue, equipSound, repairIngridient, layers, toughness, knockbackResistance));
    }

    static {
        DUNGEON = register("dungeon", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (enumMap) -> {
            enumMap.put(ArmorItem.Type.BOOTS, 2);
            enumMap.put(ArmorItem.Type.LEGGINGS, 5);
            enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
            enumMap.put(ArmorItem.Type.HELMET, 3);
            enumMap.put(ArmorItem.Type.BODY, 5);
        }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.1F, () -> {
            return Ingredient.of(new ItemLike[]{Items.IRON_INGOT});
        });
        FORTRESS = register("fortress", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (enumMap) -> {
            enumMap.put(ArmorItem.Type.BOOTS, 3);
            enumMap.put(ArmorItem.Type.LEGGINGS, 6);
            enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
            enumMap.put(ArmorItem.Type.HELMET, 3);
            enumMap.put(ArmorItem.Type.BODY, 7);
        }), 16, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.1F, () -> {
            return Ingredient.of(new ItemLike[]{Items.BLAZE_ROD});
        });
        WARD = register("ward", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (enumMap) -> {
            enumMap.put(ArmorItem.Type.BOOTS, 3);
            enumMap.put(ArmorItem.Type.LEGGINGS, 6);
            enumMap.put(ArmorItem.Type.CHESTPLATE, 7);
            enumMap.put(ArmorItem.Type.HELMET, 4);
            enumMap.put(ArmorItem.Type.BODY, 11);
        }), 8, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.2F, () -> {
            return Ingredient.of(new ItemLike[]{Items.ECHO_SHARD});
        });
    }
}*/
