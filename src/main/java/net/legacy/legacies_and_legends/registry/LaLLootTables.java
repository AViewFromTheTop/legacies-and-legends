package net.legacy.legacies_and_legends.registry;

import net.legacy.legacies_and_legends.LaLConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import org.jetbrains.annotations.NotNull;

public class LaLLootTables {
	public static final ResourceKey<LootTable> BIRCH_RUINS = register("chests/forest_ruins/birch");
	public static final ResourceKey<LootTable> CHERRY_RUINS = register("chests/forest_ruins/cherry");
	public static final ResourceKey<LootTable> MAPLE_RUINS = register("chests/forest_ruins/maple");

	public static final ResourceKey<LootTable> DEEP_RUINS = register("chests/deep_ruins/deep");
	public static final ResourceKey<LootTable> SCULK_RUINS = register("chests/deep_ruins/sculk");

	public static final ResourceKey<LootTable> PALE_CABIN = register("chests/pale_cabin/chest");
	public static final ResourceKey<LootTable> PALE_CABIN_SECRET = register("chests/pale_cabin/secret");

	public static final ResourceKey<LootTable> RUINED_AETHER_PORTAL = register("chests/ruined_aether_portal");

	public static final ResourceKey<LootTable> RUINED_LIBRARY = register("chests/ruined_library");

	public static final ResourceKey<LootTable> UNDERGROUND_REMAINS = register("chests/underground_remains");

	public static final ResourceKey<LootTable> END_RUINS = register("chests/end_ruins");

	public static final ResourceKey<LootTable> RUINS = register("chests/ruins");
	public static final ResourceKey<LootTable> RUINS_ARCHAEOLOGY = register("archaeology/ruins");

	public static final ResourceKey<LootTable> OBELISK_ARCHAEOLOGY = register("archaeology/obelisk");

	public static final ResourceKey<LootTable> DUNGEON_CHEST = register("chests/dungeon/chest");
	public static final ResourceKey<LootTable> DUNGEON_BARREL = register("chests/dungeon/barrel");
	public static final ResourceKey<LootTable> DUNGEON_LIBRARY = register("chests/dungeon/library");
	public static final ResourceKey<LootTable> DUNGEON_SIMPLE_CHEST = register("chests/dungeon/simple/chest");
	public static final ResourceKey<LootTable> DUNGEON_SIMPLE_BARREL = register("chests/dungeon/simple/barrel");
	public static final ResourceKey<LootTable> DUNGEON_SIMPLE_LIBRARY = register("chests/dungeon/simple/library");
	public static final ResourceKey<LootTable> DUNGEON_DEEP_CHEST = register("chests/dungeon/deep/chest");
	public static final ResourceKey<LootTable> DUNGEON_DEEP_BARREL = register("chests/dungeon/deep/barrel");
	public static final ResourceKey<LootTable> DUNGEON_DEEP_LIBRARY = register("chests/dungeon/deep/library");
	public static final ResourceKey<LootTable> DUNGEON_ARID_CHEST = register("chests/dungeon/arid/chest");
	public static final ResourceKey<LootTable> DUNGEON_ARID_BARREL = register("chests/dungeon/arid/barrel");
	public static final ResourceKey<LootTable> DUNGEON_ARID_LIBRARY = register("chests/dungeon/arid/library");
	public static final ResourceKey<LootTable> DUNGEON_FROZEN_CHEST = register("chests/dungeon/frozen/chest");
	public static final ResourceKey<LootTable> DUNGEON_FROZEN_BARREL = register("chests/dungeon/frozen/barrel");
	public static final ResourceKey<LootTable> DUNGEON_FROZEN_LIBRARY = register("chests/dungeon/frozen/library");
	public static final ResourceKey<LootTable> DUNGEON_VERDANT_CHEST = register("chests/dungeon/verdant/chest");
	public static final ResourceKey<LootTable> DUNGEON_VERDANT_BARREL = register("chests/dungeon/verdant/barrel");
	public static final ResourceKey<LootTable> DUNGEON_VERDANT_LIBRARY = register("chests/dungeon/verdant/library");
	public static final ResourceKey<LootTable> DUNGEON_INFERNAL_CHEST = register("chests/dungeon/infernal/chest");
	public static final ResourceKey<LootTable> DUNGEON_INFERNAL_BARREL = register("chests/dungeon/infernal/barrel");
	public static final ResourceKey<LootTable> DUNGEON_INFERNAL_LIBRARY = register("chests/dungeon/infernal/library");

	private static @NotNull ResourceKey<LootTable> register(String path) {
		return ResourceKey.create(Registries.LOOT_TABLE, LaLConstants.id(path));
	}
}
