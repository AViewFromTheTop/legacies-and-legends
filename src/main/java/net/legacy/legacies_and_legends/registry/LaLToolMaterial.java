package net.legacy.legacies_and_legends.registry;

import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
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
    public static final ToolMaterial HOOK = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 5.0F, 10, LaLItemTags.HOOK_TOOL_MATERIALS);
    public static final ToolMaterial KNIFE = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1561, 8.0F, 3.0F, 25, LaLItemTags.KNIFE_TOOL_MATERIALS);

    public static final ToolMaterial VERDANT = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 184, 4.0F, 1.0F, 10,LaLItemTags.VERDANT_TOOL_MATERIALS);
    public static final ToolMaterial CLEAVING = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 292, 6.0F, 2.0F, 12, LaLItemTags.CLEAVING_TOOL_MATERIALS);
    public static final ToolMaterial MOLTEN = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 376, 7.0F, 2.0F, 15, LaLItemTags.MOLTEN_TOOL_MATERIALS);
    public static final ToolMaterial PROSPECTOR = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 97, 10.0F, 2.0F, 18, LaLItemTags.PROSPECTOR_TOOL_MATERIALS);
    public static final ToolMaterial WITHERED = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 215, 6.0F, 2.0F, 8, LaLItemTags.WITHERED_TOOL_MATERIALS);

    private Item.Properties applyCommonProperties(Item.Properties properties) {
        return properties.durability(this.durability).repairable(this.repairItems).enchantable(this.enchantmentValue);
    }

    public Item.Properties applyToolProperties(Item.Properties properties, TagKey<Block> mineableBlocks, float attackDamage, float attackSpeed) {
        HolderGetter<Block> holderGetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);
        return this.applyCommonProperties(properties)
                .component(
                        DataComponents.TOOL,
                        new Tool(
                                List.of(
                                        Tool.Rule.deniesDrops(holderGetter.getOrThrow(this.incorrectBlocksForDrops)),
                                        Tool.Rule.minesAndDrops(holderGetter.getOrThrow(mineableBlocks), this.speed)
                                ),
                                1.0F,
                                1
                        )
                )
                .attributes(this.createToolAttributes(attackDamage, attackSpeed));
    }

    private ItemAttributeModifiers createToolAttributes(float attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, (double)(attackDamage + this.attackDamageBonus), AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, (double)attackSpeed, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }

    public Item.Properties applySwordProperties(Item.Properties properties, float attackDamage, float attackSpeed) {
        HolderGetter<Block> holderGetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);
        return this.applyCommonProperties(properties)
                .component(
                        DataComponents.TOOL,
                        new Tool(
                                List.of(
                                        Tool.Rule.minesAndDrops(HolderSet.direct(Blocks.COBWEB.builtInRegistryHolder()), 15.0F),
                                        Tool.Rule.overrideSpeed(holderGetter.getOrThrow(BlockTags.SWORD_EFFICIENT), 1.5F)
                                ),
                                1.0F,
                                2
                        )
                )
                .attributes(this.createSwordAttributes(attackDamage, attackSpeed));
    }

    private ItemAttributeModifiers createSwordAttributes(float attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, (double)(attackDamage + this.attackDamageBonus), AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, (double)attackSpeed, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }
}