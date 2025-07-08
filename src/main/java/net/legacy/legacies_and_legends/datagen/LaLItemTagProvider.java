package net.legacy.legacies_and_legends.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.frozenblock.lib.tag.api.FrozenItemTags;
import net.legacy.legacies_and_legends.registry.LaLEquipmentItems;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class LaLItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public LaLItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @NotNull
    private TagKey<Item> getTag(String id) {
        return TagKey.create(this.registryKey, ResourceLocation.parse(id));
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        this.getOrCreateTagBuilder(ItemTags.DECORATED_POT_SHERDS)
                .add(LaLItems.VERDANT_POTTERY_SHERD)
                .add(LaLItems.FORAGER_POTTERY_SHERD)
                .add(LaLItems.HARVEST_POTTERY_SHERD)
                .add(LaLItems.DUSK_POTTERY_SHERD);

        this.getOrCreateTagBuilder(LaLItemTags.TABLETS)
                .add(LaLItems.TABLET_OF_HASTE)
                .add(LaLItems.TABLET_OF_LEVITATION)
                .add(LaLItems.TABLET_OF_RECALL)
                .add(LaLItems.TABLET_OF_DEAFENING)
                .add(LaLItems.TABLET_OF_CHANNELING)
                .add(LaLItems.TABLET_OF_REVEALING);

        this.getOrCreateTagBuilder(LaLItemTags.AMULETS)
                .add(LaLItems.AMULET_OF_ALLURE)
                .add(LaLItems.AMULET_OF_EVASION)
                .add(LaLItems.AMULET_OF_SYNTHESIS);

        this.getOrCreateTagBuilder(LaLItemTags.TOTEMS)
                .add(Items.TOTEM_OF_UNDYING)
                .add(LaLItems.TOTEM_OF_TELEPORTATION)
                .add(LaLItems.TOTEM_OF_VENGEANCE)
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("trinkets","charm/charm"));

        this.getOrCreateTagBuilder(LaLItemTags.ACCESSORIES)
                .addTag(LaLItemTags.AMULETS)
                .addTag(LaLItemTags.TOTEMS);

        this.getOrCreateTagBuilder(LaLItemTags.HAS_ITEM_EFFECT)
                .add(LaLItems.AMULET_OF_ALLURE)
                .add(LaLItems.AMULET_OF_SYNTHESIS)
                .add(LaLItems.AMULET_OF_EVASION);
        this.getOrCreateTagBuilder(LaLItemTags.HAS_BREED_EFFECT)
                .add(LaLItems.AMULET_OF_ALLURE);
        this.getOrCreateTagBuilder(LaLItemTags.HAS_KILL_EFFECT)
                .add(LaLItems.AMULET_OF_SYNTHESIS);
        this.getOrCreateTagBuilder(LaLItemTags.HAS_USE_EFFECT)
                .add(LaLItems.TABLET_OF_CHANNELING)
                .add(LaLItems.TABLET_OF_DEAFENING)
                .add(LaLItems.TABLET_OF_REVEALING);

        this.getOrCreateTagBuilder(LaLItemTags.PROSPECTING)
                .add(LaLEquipmentItems.PROSPECTOR_SHOVEL);

        this.getOrCreateTagBuilder(LaLItemTags.REPAIRS_REINFORCED_ARMOR)
                .add(Items.ECHO_SHARD);
        this.getOrCreateTagBuilder(LaLItemTags.REPAIRS_TRAVELLING_ARMOR)
                .add(Items.RABBIT_HIDE);
        this.getOrCreateTagBuilder(LaLItemTags.REPAIRS_WANDERER_ARMOR)
                .add(LaLItems.METAL_CHUNK);

        this.getOrCreateTagBuilder(LaLItemTags.BOOMERANG_REPAIR_MATERIALS)
                .add(LaLItems.METAL_CHUNK);
        this.getOrCreateTagBuilder(LaLItemTags.WAND_REPAIR_MATERIALS)
                .add(LaLItems.SAPPHIRE);
        this.getOrCreateTagBuilder(LaLItemTags.HOOK_REPAIR_MATERIALS)
                .add(LaLItems.METAL_CHUNK);
        this.getOrCreateTagBuilder(LaLItemTags.KNIFE_REPAIR_MATERIALS)
                .addTag(ItemTags.DECORATED_POT_SHERDS);

        this.getOrCreateTagBuilder(LaLItemTags.TRIDENT_REPAIR_MATERIALS)
                .add(LaLItems.TRIDENT_SHARD);

        this.getOrCreateTagBuilder(LaLItemTags.VERDANT_TOOL_MATERIALS)
                .add(Items.MOSSY_COBBLESTONE.asItem());
        this.getOrCreateTagBuilder(LaLItemTags.CLEAVING_TOOL_MATERIALS)
                .add(LaLItems.METAL_CHUNK);
        this.getOrCreateTagBuilder(LaLItemTags.MOLTEN_TOOL_MATERIALS)
                .add(Items.NETHER_BRICK);
        this.getOrCreateTagBuilder(LaLItemTags.PROSPECTOR_TOOL_MATERIALS)
                .add(Items.EMERALD);
        this.getOrCreateTagBuilder(LaLItemTags.WITHERED_TOOL_MATERIALS)
                .add(Blocks.BLACKSTONE.asItem());

        this.getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(LaLItems.REINFORCED_CHESTPLATE);
        this.getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(LaLItems.TRAVELLING_STRIDES);
        this.getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(LaLItems.WANDERER_BOOTS);

        this.getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(LaLEquipmentItems.VERDANT_SWORD);
        this.getOrCreateTagBuilder(ItemTags.AXES)
                .add(LaLEquipmentItems.CLEAVING_BATTLEAXE);
        this.getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(LaLEquipmentItems.MOLTEN_PICKAXE);
        this.getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(LaLEquipmentItems.PROSPECTOR_SHOVEL);
        this.getOrCreateTagBuilder(ItemTags.HOES)
                .add(LaLEquipmentItems.WITHERED_HOE);

        this.getOrCreateTagBuilder(ItemTags.WEAPON_ENCHANTABLE)
                .add(LaLEquipmentItems.HOOK)
                .add(LaLEquipmentItems.KNIFE);

        this.getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(LaLItems.BOOMERANG)
                .add(LaLItems.WAND)
                .add(LaLEquipmentItems.HOOK)
                .add(LaLEquipmentItems.KNIFE);

        this.getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(Items.ECHO_SHARD)
                .add(LaLItems.SAPPHIRE);

        this.getOrCreateTagBuilder(FrozenItemTags.ALWAYS_SAVE_COOLDOWNS)
                .add(Items.SHIELD)
                .add(LaLItems.WAND)
                .addTag(LaLItemTags.TABLETS);
    }
}
