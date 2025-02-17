package net.legacy.legacies_and_legends.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.clothconfig2.api.AbstractConfigListEntry;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.impl.builders.SubCategoryBuilder;
import net.frozenblock.lib.config.api.instance.json.JsonConfig;
import net.frozenblock.lib.config.api.instance.json.JsonType;
import net.frozenblock.lib.config.api.registry.ConfigRegistry;
import net.frozenblock.lib.config.clothconfig.FrozenClothConfig;
import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.LaLPreLoadConstants;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.CollapsibleObject;
import net.minecraft.network.chat.Component;

import java.util.Arrays;

import static net.legacy.legacies_and_legends.LaLConstants.*;


@Config(name = LaLConstants.MOD_ID)
public class LaLConfig implements ConfigData {

	public static final net.frozenblock.lib.config.api.instance.Config<LaLConfig> INSTANCE = ConfigRegistry.register(
			new JsonConfig<>(
					MOD_ID,
					LaLConfig.class,
					LaLPreLoadConstants.configPath(true),
					JsonType.JSON5,
					null,
					null
			)
	);

	public static LaLConfig get() {
		return get(false);
	}

	public static LaLConfig get(boolean real) {
		if (real)
			return INSTANCE.instance();
		return INSTANCE.config();
	}

	@CollapsibleObject
	public final StructuresConfig structures = new StructuresConfig();

	@CollapsibleObject
	public LootConfig loot = new LootConfig();

	@CollapsibleObject
	public ArtifactsConfig artifacts = new ArtifactsConfig();

	@CollapsibleObject
	public EnchantmentsConfig enchantments = new EnchantmentsConfig();

	@CollapsibleObject
	public MusicConfig music = new MusicConfig();

	@CollapsibleObject
	public MiscConfig misc = new MiscConfig();

	public static class StructuresConfig {
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		@ConfigEntry.Gui.CollapsibleObject
		public boolean dungeonOverhaul = true;
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean swampHutVariants = true;
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean buriedTreasureRework = true;

		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean newStructures = true;
	}

	public static class LootConfig {
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean enchantedBeetroot = true;
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean metalChunk = true;
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean woodenBuckets = true;
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean musicDiscs = true;

		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean knife = true;
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean hook = true;

		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean improvedLoot = true;
	}

	public static class ArtifactsConfig {
		@ConfigEntry.Category("config")
		public boolean reinforcedChestplate = true;
		@ConfigEntry.Category("config")
		public boolean travellingStrides = true;
		@ConfigEntry.Category("config")
		public boolean wandererBoots = true;

		@ConfigEntry.Category("config")
		public boolean verdantSword = true;
		@ConfigEntry.Category("config")
		public boolean cleavingBattleaxe = true;
		@ConfigEntry.Category("config")
		public boolean moltenPickaxe = true;
		@ConfigEntry.Category("config")
		public boolean prospectorShovel = true;
		@ConfigEntry.Category("config")
		public boolean witheredHoe = true;

		@ConfigEntry.Category("config")
		public boolean totemOfVengeance = true;
		@ConfigEntry.Category("config")
		public boolean totemOfTeleportation = true;

		@ConfigEntry.Category("config")
		public boolean tabletOfRecall = true;
		@ConfigEntry.Category("config")
		public boolean tabletOfHaste = true;
		@ConfigEntry.Category("config")
		public boolean tabletOfLevitation = true;

		@ConfigEntry.Category("config")
		public boolean amuletOfAllure = true;
		@ConfigEntry.Category("config")
		public boolean amuletOfSynthesis = true;
		@ConfigEntry.Category("config")
		public boolean amuletOfEvasion = true;
	}

	public static class EnchantmentsConfig {
		@ConfigEntry.Category("config")
		public boolean freeze = true;
		@ConfigEntry.Category("config")
		public boolean tangled = true;
		@ConfigEntry.Category("config")
		public boolean shatter = true;
		@ConfigEntry.Category("config")
		public boolean rapidStrike = true;
		@ConfigEntry.Category("config")
		public boolean slaughter = true;
	}

	public static class MusicConfig {
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean savannaMusic = true;
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean snowyMusic = true;

		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean endPortalMusic = true;

		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean musicAndMelody = true;
	}

	public static class MiscConfig {
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean echoShardTrim = true;

		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean integrationDatapacks = true;
	}

}