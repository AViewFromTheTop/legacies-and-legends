package net.legacy.legacies_and_legends.tag;

import net.legacy.legacies_and_legends.LaLConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class LaLItemTags {
    public static final TagKey<Item> BOOMERANG_REPAIR_MATERIALS = bind("boomerang_repair_materials");
    public static final TagKey<Item> HOOK_REPAIR_MATERIALS = bind("hook_repair_materials");
    public static final TagKey<Item> KNIFE_REPAIR_MATERIALS = bind("knife_repair_materials");

    public static final TagKey<Item> VERDANT_TOOL_MATERIALS = bind("verdant_tool_materials");
    public static final TagKey<Item> CLEAVING_TOOL_MATERIALS = bind("cleaving_tool_materials");
    public static final TagKey<Item> MOLTEN_TOOL_MATERIALS = bind("molten_tool_materials");
    public static final TagKey<Item> PROSPECTOR_TOOL_MATERIALS = bind("prospector_tool_materials");
    public static final TagKey<Item> WITHERED_TOOL_MATERIALS = bind("withered_tool_materials");

    public static final TagKey<Item> REPAIRS_WANDERER_ARMOR = bind("repairs_wanderer_armor");
    public static final TagKey<Item> REPAIRS_TRAVELLING_ARMOR = bind("repairs_travelling_armor");
    public static final TagKey<Item> REPAIRS_REINFORCED_ARMOR = bind("repairs_reinforced_armor");

    public static final TagKey<Item> TABLETS = bind("tablets");

    public static final TagKey<Item> HAS_ITEM_EFFECT = bind("has_item_effect");
    public static final TagKey<Item> HAS_BREED_EFFECT = bind("has_breed_effect");
    public static final TagKey<Item> HAS_KILL_EFFECT = bind("has_kill_effect");
    public static final TagKey<Item> HAS_USE_EFFECT = bind("has_use_effect");

    public static final TagKey<Item> PROSPECTING = bind("prospecting");

    @NotNull
    private static TagKey<Item> bind(@NotNull String path) {
        return TagKey.create(Registries.ITEM, LaLConstants.id(path));
    }

}