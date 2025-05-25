package net.legacy.legacies_and_legends.registry;

import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.core.Holder;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.level.block.Block;

import java.util.List;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Blocks;

public record LaLToolMaterial(
        TagKey<Block> incorrectBlocksForDrops, int durability, float speed, float attackDamageBonus, int enchantmentValue, TagKey<Item> repairItems
) {
    public static final ToolMaterial HOOK = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 5.0F, 15, LaLItemTags.HOOK_REPAIR_MATERIALS);
    public static final ToolMaterial KNIFE = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1561, 8.0F, 3.0F, 15, LaLItemTags.KNIFE_REPAIR_MATERIALS);

    public static final ToolMaterial VERDANT = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 184, 4.0F, 1.0F, 10,LaLItemTags.VERDANT_TOOL_MATERIALS);
    public static final ToolMaterial CLEAVING = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 292, 6.0F, 2.0F, 12, LaLItemTags.CLEAVING_TOOL_MATERIALS);
    public static final ToolMaterial MOLTEN = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 376, 7.0F, 2.0F, 15, LaLItemTags.MOLTEN_TOOL_MATERIALS);
    public static final ToolMaterial PROSPECTOR = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 97, 10.0F, 2.0F, 18, LaLItemTags.PROSPECTOR_TOOL_MATERIALS);
    public static final ToolMaterial WITHERED = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 215, 6.0F, 2.0F, 8, LaLItemTags.WITHERED_TOOL_MATERIALS);
}