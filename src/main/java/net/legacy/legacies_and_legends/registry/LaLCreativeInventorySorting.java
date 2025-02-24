package net.legacy.legacies_and_legends.registry;

import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

public class LaLCreativeInventorySorting {

	public static void init() {
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_MALL, LaLItems.MUSIC_DISC_SVALL);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_STRAD, LaLItems.MUSIC_DISC_CASTLES);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_MELLOHI, LaLItems.MUSIC_DISC_TASWELL);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_PRECIPICE, LaLItems.MUSIC_DISC_SHULKER);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_FAR, LaLItems.MUSIC_DISC_TUNDRA);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_RELIC, LaLItems.MUSIC_DISC_FAR_LANDS);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_CREATOR_MUSIC_BOX, LaLItems.MUSIC_DISC_INFINITE_SPOOKY_AMETHYST);

		addAfterInToolsAndUtilities(Items.MILK_BUCKET, LaLItems.WOODEN_BUCKET);
		addAfterInToolsAndUtilities(LaLItems.WOODEN_BUCKET, LaLItems.COAL_BUCKET);
		addAfterInToolsAndUtilities(LaLItems.COAL_BUCKET, LaLItems.CHARCOAL_BUCKET);

		addAfterInToolsAndUtilities(Items.NETHERITE_HOE, LaLEquipmentItems.PROSPECTOR_SHOVEL);
		addAfterInToolsAndUtilities(LaLEquipmentItems.PROSPECTOR_SHOVEL, LaLEquipmentItems.MOLTEN_PICKAXE);
		addAfterInToolsAndUtilities(LaLEquipmentItems.MOLTEN_PICKAXE, LaLEquipmentItems.CLEAVING_BATTLEAXE);
		addAfterInToolsAndUtilities(LaLEquipmentItems.CLEAVING_BATTLEAXE, LaLEquipmentItems.WITHERED_HOE);

		addAfterInToolsAndUtilities(Items.FLINT_AND_STEEL, LaLItems.AMULET_OF_ALLURE);
		addAfterInToolsAndUtilities(LaLItems.AMULET_OF_ALLURE, LaLItems.AMULET_OF_EVASION);
		addAfterInToolsAndUtilities(LaLItems.AMULET_OF_EVASION, LaLItems.AMULET_OF_SYNTHESIS);

		addAfterInToolsAndUtilities(Items.PINK_BUNDLE, LaLItems.TABLET_OF_RECALL);
		addAfterInToolsAndUtilities(Items.PINK_BUNDLE, LaLItems.TABLET_OF_HASTE);
		addAfterInToolsAndUtilities(Items.PINK_BUNDLE, LaLItems.TABLET_OF_REVEALING);
		addAfterInToolsAndUtilities(Items.PINK_BUNDLE, LaLItems.TABLET_OF_CHANNELING);
		addAfterInToolsAndUtilities(Items.PINK_BUNDLE, LaLItems.TABLET_OF_DEAFENING);
		addAfterInToolsAndUtilities(Items.PINK_BUNDLE, LaLItems.TABLET_OF_LEVITATION);

		addAfterInIngredients(Items.HEART_OF_THE_SEA, LaLItems.METAL_CHUNK);
		addAfterInIngredients(LaLItems.METAL_CHUNK, LaLItems.DISC_FRAGMENT_FAR_LANDS);

		addAfterInIngredients(Items.DANGER_POTTERY_SHERD, LaLItems.DUSK_POTTERY_SHERD);
		addAfterInIngredients(Items.FLOW_POTTERY_SHERD, LaLItems.FORAGER_POTTERY_SHERD);
		addAfterInIngredients(Items.HEARTBREAK_POTTERY_SHERD, LaLItems.HARVEST_POTTERY_SHERD);
		addAfterInIngredients(Items.SNORT_POTTERY_SHERD, LaLItems.VERDANT_POTTERY_SHERD);

		addAfterInFoodAndDrinks(Items.BEETROOT, LaLItems.ENCHANTED_BEETROOT);
		addAfterInFoodAndDrinks(Items.BEETROOT_SOUP, LaLItems.ENCHANTED_BEETROOT_SOUP);

		addAfterInCombat(Items.NETHERITE_SWORD, LaLEquipmentItems.VERDANT_SWORD);
		addAfterInCombat(Items.NETHERITE_AXE, LaLEquipmentItems.CLEAVING_BATTLEAXE);

		addBeforeInCombat(Items.MACE, LaLEquipmentItems.KNIFE);
		addBeforeInCombat(Items.TRIDENT, LaLEquipmentItems.HOOK);
		addAfterInCombat(Items.CROSSBOW, LaLItems.BOOMERANG);

		addAfterInCombat(Items.TURTLE_HELMET, LaLItems.REINFORCED_CHESTPLATE);
		addAfterInCombat(LaLItems.REINFORCED_CHESTPLATE, LaLItems.TRAVELLING_STRIDES);
		addAfterInCombat(LaLItems.TRAVELLING_STRIDES, LaLItems.WANDERER_BOOTS);

		addAfterInCombat(Items.TOTEM_OF_UNDYING, LaLItems.TOTEM_OF_VENGEANCE);
		addAfterInCombat(LaLItems.TOTEM_OF_VENGEANCE, LaLItems.TOTEM_OF_TELEPORTATION);

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

	private static void addBeforeInCombat(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.COMBAT);
	}

	private static void addBeforeInSpawnEggs(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.SPAWN_EGGS);
	}

	private static void addAfterInSpawnEggs(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.SPAWN_EGGS);
	}
}
