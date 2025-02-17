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

	private static @NotNull ResourceKey<LootTable> register(String path) {
		return ResourceKey.create(Registries.LOOT_TABLE, LaLConstants.id(path));
	}
}
