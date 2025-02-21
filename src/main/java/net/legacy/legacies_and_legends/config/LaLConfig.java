package net.legacy.legacies_and_legends.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.frozenblock.lib.config.api.instance.json.JsonConfig;
import net.frozenblock.lib.config.api.instance.json.JsonType;
import net.frozenblock.lib.config.api.registry.ConfigRegistry;
import net.legacy.legacies_and_legends.LaLConstants;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.CollapsibleObject;

import static net.legacy.legacies_and_legends.LaLConstants.*;


@Config(name = LaLConstants.MOD_ID)
public class LaLConfig implements ConfigData {

	public static final net.frozenblock.lib.config.api.instance.Config<LaLConfig> INSTANCE = ConfigRegistry.register(
			new JsonConfig<>(
					MOD_ID,
					LaLConfig.class,
					LaLMainConfig.configPath(true),
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

	@CollapsibleObject
	public IntegrationsConfig integrations = new IntegrationsConfig();

	public static class StructuresConfig {
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean dungeon_overhaul = true;
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean swamp_hut_variants = true;
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean buried_treasure_rework = true;

		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean new_structures = true;
	}

	public static class LootConfig {
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean enchanted_beetroot = true;
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean metal_chunk = true;
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean wooden_buckets = true;
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean music_discs = true;

		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean hook = true;
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean knife = true;

		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean improved_loot = true;
	}

	public static class ArtifactsConfig {
		@ConfigEntry.Category("config")
		public boolean reinforced_chestplate = true;
		@ConfigEntry.Category("config")
		public boolean travelling_strides = true;
		@ConfigEntry.Category("config")
		public boolean wanderer_boots = true;

		@ConfigEntry.Category("config")
		public boolean verdant_sword = true;
		@ConfigEntry.Category("config")
		public boolean cleaving_battleaxe = true;
		@ConfigEntry.Category("config")
		public boolean molten_pickaxe = true;
		@ConfigEntry.Category("config")
		public boolean prospector_shovel = true;
		@ConfigEntry.Category("config")
		public boolean withered_hoe = true;

		@ConfigEntry.Category("config")
		public boolean totem_of_vengeance = true;
		@ConfigEntry.Category("config")
		public boolean totem_of_teleportation = true;

		@ConfigEntry.Category("config")
		public boolean tablet_of_recall = true;
		@ConfigEntry.Category("config")
		public boolean tablet_of_haste = true;
		@ConfigEntry.Category("config")
		public boolean tablet_of_levitation = true;
		@ConfigEntry.Category("config")
		public boolean tablet_of_channeling = true;
		@ConfigEntry.Category("config")
		public boolean tablet_of_deafening = true;
		@ConfigEntry.Category("config")
		public boolean tablet_of_revealing = true;

		@ConfigEntry.Category("config")
		public boolean amulet_of_allure = true;
		@ConfigEntry.Category("config")
		public boolean amulet_of_synthesis = true;
		@ConfigEntry.Category("config")
		public boolean amulet_of_evasion = true;
	}

	public static class EnchantmentsConfig {
		@ConfigEntry.Category("config")
		public boolean freeze = true;
		@ConfigEntry.Category("config")
		public boolean tangled = true;
		@ConfigEntry.Category("config")
		public boolean shatter = true;
		@ConfigEntry.Category("config")
		public boolean rapid_strike = true;
		@ConfigEntry.Category("config")
		public boolean slaughter = true;
	}

	public static class MusicConfig {
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean savanna_music = true;
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean snowy_music = true;

		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean end_portal_music = true;

		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean music_and_melody = true;
	}

	public static class MiscConfig {
		@ConfigEntry.Category("config")
		@ConfigEntry.Gui.Tooltip
		public boolean trim_materials = true;
	}

	public static class IntegrationsConfig {
		@ConfigEntry.Category("config")
		public boolean wilder_wild = true;
		public boolean trailier_tales = true;
		public boolean variants_and_ventures = true;
	}

}