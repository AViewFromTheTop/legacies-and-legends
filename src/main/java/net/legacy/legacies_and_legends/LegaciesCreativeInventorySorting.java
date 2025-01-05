package net.legacy.legacies_and_legends;

import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

public class LegaciesCreativeInventorySorting {

	public static void init() {
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_FAR, LegaciesItems.MUSIC_DISC_SVALL);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_11, LegaciesItems.MUSIC_DISC_TASWELL);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_OTHERSIDE, LegaciesItems.MUSIC_DISC_SHULKER);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_CREATOR_MUSIC_BOX, LegaciesItems.MUSIC_DISC_TUNDRA);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_RELIC, LegaciesItems.MUSIC_DISC_FAR_LANDS);

		addAfterInToolsAndUtilities(Items.MILK_BUCKET, LegaciesItems.WOODEN_BUCKET);
		addAfterInToolsAndUtilities(LegaciesItems.WOODEN_BUCKET, LegaciesItems.COAL_BUCKET);
		addAfterInToolsAndUtilities(LegaciesItems.COAL_BUCKET, LegaciesItems.CHARCOAL_BUCKET);

		addAfterInIngredients(Items.HEART_OF_THE_SEA, LegaciesItems.METAL_CHUNK);
		addAfterInIngredients(LegaciesItems.METAL_CHUNK, LegaciesItems.DISC_FRAGMENT_FAR_LANDS);

		addAfterInFoodAndDrinks(Items.BEETROOT, LegaciesItems.ENCHANTED_BEETROOT);
		addAfterInFoodAndDrinks(Items.BEETROOT_SOUP, LegaciesItems.ENCHANTED_BEETROOT_SOUP);

		addAfterInCombat(Items.NETHERITE_AXE, LegaciesGearItems.ANCIENT_KNIFE);
		addAfterInCombat(LegaciesGearItems.ANCIENT_KNIFE, LegaciesGearItems.HOOK);

		addAfterInCombat(Items.NETHERITE_BOOTS, LegaciesGearItems.DUNGEON_HELMET);
		addAfterInCombat(LegaciesGearItems.DUNGEON_HELMET, LegaciesGearItems.DUNGEON_CHESTPLATE);
		addAfterInCombat(LegaciesGearItems.DUNGEON_CHESTPLATE, LegaciesGearItems.DUNGEON_LEGGINGS);
		addAfterInCombat(LegaciesGearItems.DUNGEON_LEGGINGS, LegaciesGearItems.DUNGEON_BOOTS);

		addAfterInCombat(LegaciesGearItems.DUNGEON_BOOTS, LegaciesGearItems.FORTRESS_HELMET);
		addAfterInCombat(LegaciesGearItems.FORTRESS_HELMET, LegaciesGearItems.FORTRESS_CHESTPLATE);
		addAfterInCombat(LegaciesGearItems.FORTRESS_CHESTPLATE, LegaciesGearItems.FORTRESS_LEGGINGS);
		addAfterInCombat(LegaciesGearItems.FORTRESS_LEGGINGS, LegaciesGearItems.FORTRESS_BOOTS);

		addAfterInCombat(LegaciesGearItems.FORTRESS_BOOTS, LegaciesGearItems.WARD_HELMET);
		addAfterInCombat(LegaciesGearItems.WARD_HELMET, LegaciesGearItems.WARD_CHESTPLATE);
		addAfterInCombat(LegaciesGearItems.WARD_CHESTPLATE, LegaciesGearItems.WARD_LEGGINGS);
		addAfterInCombat(LegaciesGearItems.WARD_LEGGINGS, LegaciesGearItems.WARD_BOOTS);

		addAfterInBuildingBlocks(Blocks.END_STONE_BRICKS, LegaciesBlocks.CRACKED_END_STONE_BRICKS);
	}

	private static void addAfterInNaturalBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.NATURAL_BLOCKS);
	}

	private static void addBeforeInBuildingBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.BUILDING_BLOCKS);
	}

	private static void addAfterInBuildingBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.BUILDING_BLOCKS);
	}

	private static void addAfterInRedstone(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.REDSTONE_BLOCKS);
	}

	private static void addAfterInFunctionalBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.FUNCTIONAL_BLOCKS);
	}

	private static void addBeforeInRedstoneBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.REDSTONE_BLOCKS);
	}

	private static void addInToolsAndUtilities(ItemLike item) {
		FrozenCreativeTabs.add(item, CreativeModeTabs.TOOLS_AND_UTILITIES);
	}

	private static void addAfterInToolsAndUtilities(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.TOOLS_AND_UTILITIES);
	}

	private static void addBeforeInIngredients(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.INGREDIENTS);
	}

	private static void addAfterInIngredients(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.INGREDIENTS);
	}

	private static void addBeforeInFoodAndDrinks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.FOOD_AND_DRINKS);
	}

	private static void addAfterInFoodAndDrinks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.FOOD_AND_DRINKS);
	}

	private static void addAfterInCombat(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.COMBAT);
	}

	private static void addBeforeInSpawnEggs(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.SPAWN_EGGS);
	}

	private static void addAfterInSpawnEggs(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.SPAWN_EGGS);
	}
}
