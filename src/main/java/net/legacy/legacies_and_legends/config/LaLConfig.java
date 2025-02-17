package net.legacy.legacies_and_legends.config;

import net.frozenblock.lib.config.api.instance.Config;
import net.frozenblock.lib.config.api.instance.json.JsonConfig;
import net.frozenblock.lib.config.api.instance.json.JsonType;
import net.frozenblock.lib.config.api.registry.ConfigRegistry;
import net.frozenblock.lib.config.api.sync.SyncBehavior;
import net.frozenblock.lib.config.api.sync.annotation.EntrySyncData;
import net.legacy.legacies_and_legends.LaLPreLoadConstants;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.CollapsibleObject;
import static net.legacy.legacies_and_legends.LaLConstants.MOD_ID;

public final class LaLConfig {

	public static final Config<LaLConfig> INSTANCE = ConfigRegistry.register(
			new JsonConfig<>(
					MOD_ID,
					LaLConfig.class,
					LaLPreLoadConstants.configPath(true),
					JsonType.JSON5,
					null,
					null
			)
	);

	@CollapsibleObject
	public final StructuresConfig structures = new StructuresConfig();

	@CollapsibleObject
	public final LootConfig loot = new LootConfig();

	@CollapsibleObject
	public final ArtifactsConfig artifacts = new ArtifactsConfig();

	@CollapsibleObject
	public final EnchantmentsConfig enchantments = new EnchantmentsConfig();

	@CollapsibleObject
	public final MusicConfig music = new MusicConfig();

	@CollapsibleObject
	public final MiscConfig misc = new MiscConfig();

	public static LaLConfig get() {
		return get(false);
	}

	public static LaLConfig get(boolean real) {
		if (real)
			return INSTANCE.instance();
		return INSTANCE.config();
	}

	public static LaLConfig getWithSync() {
		return INSTANCE.configWithSync();
	}

	public static class StructuresConfig {
		@EntrySyncData("dungeonOverhaul")
		public boolean dungeonOverhaul = true;
		@EntrySyncData("swampHutVariants")
		public boolean swampHutVariants = true;
		@EntrySyncData("buriedTreasureRework")
		public boolean buriedTreasureRework = true;

		@EntrySyncData("newStructures")
		public boolean newStructures = true;
	}

	public static class LootConfig {
		@EntrySyncData("enchantedBeetroot")
		public boolean enchantedBeetroot = true;
		@EntrySyncData("metalChunk")
		public boolean metalChunk = true;
		@EntrySyncData("woodenBuckets")
		public boolean woodenBuckets = true;
		@EntrySyncData("musicDiscs")
		public boolean musicDiscs = true;

		@EntrySyncData("knife")
		public boolean knife = true;
		@EntrySyncData("hook")
		public boolean hook = true;

		@EntrySyncData("improvedLoot")
		public boolean improvedLoot = true;
	}

	public static class ArtifactsConfig {
		@EntrySyncData("reinforcedChestplate")
		public boolean reinforcedChestplate = true;
		@EntrySyncData("travellingStrides")
		public boolean travellingStrides = true;
		@EntrySyncData("wandererBoots")
		public boolean wandererBoots = true;

		@EntrySyncData("verdantSword")
		public boolean verdantSword = true;
		@EntrySyncData("cleavingBattleaxe")
		public boolean cleavingBattleaxe = true;
		@EntrySyncData("moltenPickaxe")
		public boolean moltenPickaxe = true;
		@EntrySyncData("prospectorShovel")
		public boolean prospectorShovel = true;
		@EntrySyncData("witheredHoe")
		public boolean witheredHoe = true;

		@EntrySyncData("totemOfVengeance")
		public boolean totemOfVengeance = true;
		@EntrySyncData("totemOfTeleportation")
		public boolean totemOfTeleportation = true;

		@EntrySyncData("tabletOfRecall")
		public boolean tabletOfRecall = true;
		@EntrySyncData("tabletOfHaste")
		public boolean tabletOfHaste = true;
		@EntrySyncData("tabletOfLevitation")
		public boolean tabletOfLevitation = true;

		@EntrySyncData("amuletOfAllure")
		public boolean amuletOfAllure = true;
		@EntrySyncData("amuletOfSynthesis")
		public boolean amuletOfSynthesis = true;
		@EntrySyncData("amuletOfEvasion")
		public boolean amuletOfEvasion = true;
	}

	public static class EnchantmentsConfig {
		@EntrySyncData("freeze")
		public boolean freeze = true;
		@EntrySyncData("tangled")
		public boolean tangled = true;
		@EntrySyncData("shatter")
		public boolean shatter = true;
		@EntrySyncData("rapidStrike")
		public boolean rapidStrike = true;
		@EntrySyncData("slaughter")
		public boolean slaughter = true;
	}

	public static class MusicConfig {
		@EntrySyncData(value = "savannaMusic", behavior = SyncBehavior.UNSYNCABLE)
		public boolean savannaMusic = true;
		@EntrySyncData(value = "snowyMusic", behavior = SyncBehavior.UNSYNCABLE)
		public boolean snowyMusic = true;

		@EntrySyncData(value = "endPortalMusic", behavior = SyncBehavior.UNSYNCABLE)
		public boolean endPortalMusic = true;

		@EntrySyncData(value = "musicAndMelody", behavior = SyncBehavior.UNSYNCABLE)
		public boolean musicAndMelody = true;
	}

	public static class MiscConfig {
		@EntrySyncData("echoShardTrim")
		public boolean echoShardTrim = true;

		@EntrySyncData("integrationDatapacks")
		public boolean integrationDatapacks = true;
	}
}