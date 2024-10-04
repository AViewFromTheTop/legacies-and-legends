package net.legacy.legacies_and_legends;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public final class LegaciesItems {
    private LegaciesItems() {}

    public static final Item DISC_FRAGMENT_FAR_LANDS = new Item(new Item.Properties().stacksTo(64));
    public static final Item METAL_CHUNK = new Item(new Item.Properties().stacksTo(64));

    public static final Item MUSIC_DISC_SVALL = new Item(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(LegaciesJukeboxSongs.SVALL));
    public static final Item MUSIC_DISC_TASWELL = new Item(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(LegaciesJukeboxSongs.TASWELL));
    public static final Item MUSIC_DISC_SHULKER = new Item(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(LegaciesJukeboxSongs.SHULKER));
    public static final Item MUSIC_DISC_TUNDRA = new Item(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(LegaciesJukeboxSongs.TUNDRA));
    public static final Item MUSIC_DISC_FAR_LANDS = new Item(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(LegaciesJukeboxSongs.FAR_LANDS));

    public static final Item HOOK = new LegaciesWeapon(LegaciesTiers.HOOK, (new Item.Properties()).attributes(LegaciesWeapon.createAttributes(LegaciesTiers.HOOK, 4, -3.2F)).stacksTo(1).durability(750));
    public static final Item ANCIENT_KNIFE = new LegaciesWeapon(LegaciesTiers.ANCIENT, (new Item.Properties()).attributes(LegaciesWeapon.createAttributes(LegaciesTiers.ANCIENT, 2, -2F)).stacksTo(1).durability(3048));

    public static final Item ENCHANTED_BEETROOT = new Item(new Item.Properties().rarity(Rarity.RARE).food(LegaciesFoods.ENCHANTED_BEETROOT).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final Item ENCHANTED_BEETROOT_SOUP = new Item(new Item.Properties().rarity(Rarity.EPIC).food(LegaciesFoods.ENCHANTED_BEETROOT_SOUP).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true).stacksTo(1));

    public static final Item CRYING_PEARL = new LegaciesCryingPearl((new Item.Properties()).stacksTo(16));

    public static final Item WOODEN_BUCKET = new Item(new Item.Properties().stacksTo(16));
    public static final Item COAL_BUCKET = new Item(new Item.Properties().stacksTo(16));
    public static final Item CHARCOAL_BUCKET = new Item(new Item.Properties().stacksTo(16));

    public static final Block CRACKED_END_STONE_BRICKS = new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS));

    public static final Item DUNGEON_HELMET = new ArmorItem(LegaciesArmorMaterials.DUNGEON, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(27)));
    public static final Item DUNGEON_CHESTPLATE = new ArmorItem(LegaciesArmorMaterials.DUNGEON, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(27)));
    public static final Item DUNGEON_LEGGINGS = new ArmorItem(LegaciesArmorMaterials.DUNGEON, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(27)));
    public static final Item DUNGEON_BOOTS = new ArmorItem(LegaciesArmorMaterials.DUNGEON, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(27)));

    public static final Item FORTRESS_HELMET = new ArmorItem(LegaciesArmorMaterials.FORTRESS, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(23)));
    public static final Item FORTRESS_CHESTPLATE = new ArmorItem(LegaciesArmorMaterials.FORTRESS, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(23)));
    public static final Item FORTRESS_LEGGINGS = new ArmorItem(LegaciesArmorMaterials.FORTRESS, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(23)));
    public static final Item FORTRESS_BOOTS = new ArmorItem(LegaciesArmorMaterials.FORTRESS, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(23)));

    public static final Item WARD_HELMET = new ArmorItem(LegaciesArmorMaterials.WARD, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(41)));
    public static final Item WARD_CHESTPLATE = new ArmorItem(LegaciesArmorMaterials.WARD, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(41)));
    public static final Item WARD_LEGGINGS = new ArmorItem(LegaciesArmorMaterials.WARD, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(41)));
    public static final Item WARD_BOOTS = new ArmorItem(LegaciesArmorMaterials.WARD, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(41)));

    public static void register() {
        registerItemAfter(Items.NETHERITE_AXE, ANCIENT_KNIFE, "ancient_knife", CreativeModeTabs.COMBAT);
        registerItemAfter(ANCIENT_KNIFE, HOOK, "hook", CreativeModeTabs.COMBAT);

        registerItemAfter(Items.MUSIC_DISC_FAR, MUSIC_DISC_SVALL, "music_disc_svall", CreativeModeTabs.TOOLS_AND_UTILITIES);
        registerItemAfter(Items.MUSIC_DISC_11, MUSIC_DISC_TASWELL, "music_disc_taswell", CreativeModeTabs.TOOLS_AND_UTILITIES);
        registerItemAfter(Items.MUSIC_DISC_OTHERSIDE, MUSIC_DISC_SHULKER, "music_disc_shulker", CreativeModeTabs.TOOLS_AND_UTILITIES);
        registerItemAfter(Items.MUSIC_DISC_CREATOR_MUSIC_BOX, MUSIC_DISC_TUNDRA, "music_disc_tundra", CreativeModeTabs.TOOLS_AND_UTILITIES);
        registerItemAfter(Items.MUSIC_DISC_RELIC, MUSIC_DISC_FAR_LANDS, "music_disc_far_lands", CreativeModeTabs.TOOLS_AND_UTILITIES);

        registerItemAfter(Items.HEART_OF_THE_SEA, METAL_CHUNK, "metal_chunk", CreativeModeTabs.INGREDIENTS);
        registerItemAfter(METAL_CHUNK, DISC_FRAGMENT_FAR_LANDS, "disc_fragment_far_lands", CreativeModeTabs.INGREDIENTS);
        registerItemAfter(Items.BEETROOT, ENCHANTED_BEETROOT, "enchanted_beetroot", CreativeModeTabs.FOOD_AND_DRINKS);
        registerItemAfter(Items.BEETROOT_SOUP, ENCHANTED_BEETROOT_SOUP, "enchanted_beetroot_soup", CreativeModeTabs.FOOD_AND_DRINKS);
        registerItemAfter(Items.NETHER_STAR, CRYING_PEARL, "crying_pearl", CreativeModeTabs.TOOLS_AND_UTILITIES);
        registerItemAfter(Items.MILK_BUCKET, WOODEN_BUCKET, "wooden_bucket", CreativeModeTabs.TOOLS_AND_UTILITIES);
        registerItemAfter(WOODEN_BUCKET, COAL_BUCKET, "coal_bucket", CreativeModeTabs.TOOLS_AND_UTILITIES);
        registerItemAfter(COAL_BUCKET, CHARCOAL_BUCKET, "charcoal_bucket", CreativeModeTabs.TOOLS_AND_UTILITIES);

        registerItemAfter(Items.NETHERITE_BOOTS, DUNGEON_HELMET, "dungeon_helmet", CreativeModeTabs.COMBAT);
        registerItemAfter(DUNGEON_HELMET, DUNGEON_CHESTPLATE, "dungeon_chestplate", CreativeModeTabs.COMBAT);
        registerItemAfter(DUNGEON_CHESTPLATE, DUNGEON_LEGGINGS, "dungeon_leggings", CreativeModeTabs.COMBAT);
        registerItemAfter(DUNGEON_LEGGINGS, DUNGEON_BOOTS, "dungeon_boots", CreativeModeTabs.COMBAT);

        registerItemAfter(DUNGEON_BOOTS, FORTRESS_HELMET, "fortress_helmet", CreativeModeTabs.COMBAT);
        registerItemAfter(FORTRESS_HELMET, FORTRESS_CHESTPLATE, "fortress_chestplate", CreativeModeTabs.COMBAT);
        registerItemAfter(FORTRESS_CHESTPLATE, FORTRESS_LEGGINGS, "fortress_leggings", CreativeModeTabs.COMBAT);
        registerItemAfter(FORTRESS_LEGGINGS, FORTRESS_BOOTS, "fortress_boots", CreativeModeTabs.COMBAT);

        registerItemAfter(FORTRESS_BOOTS, WARD_HELMET, "ward_helmet", CreativeModeTabs.COMBAT);
        registerItemAfter(WARD_HELMET, WARD_CHESTPLATE, "ward_chestplate", CreativeModeTabs.COMBAT);
        registerItemAfter(WARD_CHESTPLATE, WARD_LEGGINGS, "ward_leggings", CreativeModeTabs.COMBAT);
        registerItemAfter(WARD_LEGGINGS, WARD_BOOTS, "ward_boots", CreativeModeTabs.COMBAT);

        FuelRegistry.INSTANCE.add(LegaciesItems.COAL_BUCKET, 19200);
        FuelRegistry.INSTANCE.add(LegaciesItems.WOODEN_BUCKET, 300);
        FuelRegistry.INSTANCE.add(LegaciesItems.CHARCOAL_BUCKET, 19200);

        registerBlockAfter(Blocks.END_STONE_BRICKS, "cracked_end_stone_bricks", CRACKED_END_STONE_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);
    }

    @SafeVarargs
    private static void registerBlockAfter(ItemLike comparedItem, String path, Block block, ResourceKey<CreativeModeTab>... tabs) {
        registerBlockItemAfter(comparedItem, path, block, tabs);
        actualRegisterBlock(path, block);
    }

    @SafeVarargs
    private static void registerBlockItemAfter(ItemLike comparedItem, String name, Block block, ResourceKey<CreativeModeTab>... tabs) {
        registerBlockItemAfter(comparedItem, name, block, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
    }

    @SafeVarargs
    private static void registerBlockItemAfter(ItemLike comparedItem, String path, Block block, CreativeModeTab.TabVisibility visibility, ResourceKey<CreativeModeTab>... tabs) {
        actualRegisterBlockItem(path, block);
        FrozenCreativeTabs.addAfter(comparedItem, block, visibility, tabs);
    }

    private static void actualRegisterBlock(String path, Block block) {
        if (BuiltInRegistries.BLOCK.getOptional(LegaciesConstants.id(path)).isEmpty()) {
            Registry.register(BuiltInRegistries.BLOCK, LegaciesConstants.id(path), block);
        }
    }

    private static void actualRegisterBlockItem(String path, Block block) {
        if (BuiltInRegistries.ITEM.getOptional(LegaciesConstants.id(path)).isEmpty()) {
            Registry.register(BuiltInRegistries.ITEM, LegaciesConstants.id(path), new BlockItem(block, new Item.Properties()));
        }
    }


    @SafeVarargs
    private static void registerItemAfter(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull ResourceKey<CreativeModeTab>... tabs) {
        registerItemAfter(comparedItem, item, path, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
    }

    @SafeVarargs
    private static void registerItemAfter(@NotNull ItemLike comparedItem, @NotNull Item item, @NotNull String path, @NotNull CreativeModeTab.TabVisibility tabVisibility, @NotNull ResourceKey<CreativeModeTab>... tabs) {
        actualRegister(item, path);
        FrozenCreativeTabs.addAfter(comparedItem, item, tabVisibility, tabs);
    }

    private static void actualRegister(@NotNull Item item, @NotNull String path) {
        if (BuiltInRegistries.ITEM.getOptional(LegaciesConstants.id(path)).isEmpty()) {
            Registry.register(BuiltInRegistries.ITEM, LegaciesConstants.id(path), item);
        }
    }
}
