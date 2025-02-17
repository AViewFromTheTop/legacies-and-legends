package net.legacy.legacies_and_legends.config;

import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.frozenblock.lib.config.api.instance.Config;
import net.frozenblock.lib.config.clothconfig.FrozenClothConfig;
import org.jetbrains.annotations.NotNull;

import static net.legacy.legacies_and_legends.LaLConstants.text;
import static net.legacy.legacies_and_legends.LaLConstants.tooltip;

@Environment(EnvType.CLIENT)
public final class LaLConfigGUI {

	public static void setupEntries(@NotNull ConfigCategory category, @NotNull ConfigEntryBuilder entryBuilder) {
		var config = LaLConfig.get(true);
		var modifiedConfig = LaLConfig.getWithSync();
		Class<? extends LaLConfig> clazz = config.getClass();
		Config<? extends LaLConfig> configInstance = LaLConfig.INSTANCE;
		var defaultConfig = LaLConfig.INSTANCE.defaultInstance();
		var structures = config.structures;
		var loot = config.loot;
		var artifacts = config.artifacts;
		var enchantments = config.enchantments;
		var music = config.music;
		var misc = config.misc;

		// Structures

		var dungeonOverhaul = entryBuilder.startBooleanToggle(text("dungeon_overhaul"), structures.dungeonOverhaul)
				.setDefaultValue(defaultConfig.structures.dungeonOverhaul)
				.setSaveConsumer(newValue -> structures.dungeonOverhaul = newValue)
				.setTooltip(tooltip("dungeon_overhaul"))
				.requireRestart()
				.build();
		var swampHutVariants = entryBuilder.startBooleanToggle(text("swamp_hut_variants"), structures.swampHutVariants)
				.setDefaultValue(defaultConfig.structures.swampHutVariants)
				.setSaveConsumer(newValue -> structures.swampHutVariants = newValue)
				.setTooltip(tooltip("swamp_hut_variants"))
				.requireRestart()
				.build();
		var buriedTreasureRework = entryBuilder.startBooleanToggle(text("buried_treasure_rework"), structures.buriedTreasureRework)
				.setDefaultValue(defaultConfig.structures.buriedTreasureRework)
				.setSaveConsumer(newValue -> structures.buriedTreasureRework = newValue)
				.setTooltip(tooltip("buried_treasure_rework"))
				.requireRestart()
				.build();

		var newStructures = entryBuilder.startBooleanToggle(text("new_structures"), structures.newStructures)
				.setDefaultValue(defaultConfig.structures.newStructures)
				.setSaveConsumer(newValue -> structures.newStructures = newValue)
				.setTooltip(tooltip("new_structures"))
				.requireRestart()
				.build();

		var structuresCategory = FrozenClothConfig.createSubCategory(entryBuilder, category, text("structures"),
				false,
				tooltip("structures"),
				dungeonOverhaul, swampHutVariants, buriedTreasureRework, newStructures
		);

		// Loot

		var enchantedBeetroot = entryBuilder.startBooleanToggle(text("enchanted_beetroot"), loot.enchantedBeetroot)
				.setDefaultValue(defaultConfig.loot.enchantedBeetroot)
				.setSaveConsumer(newValue -> loot.enchantedBeetroot = newValue)
				.setTooltip(tooltip("enchanted_beetroot"))
				.requireRestart()
				.build();
		var metalChunk = entryBuilder.startBooleanToggle(text("metal_chunk"), loot.metalChunk)
				.setDefaultValue(defaultConfig.loot.metalChunk)
				.setSaveConsumer(newValue -> loot.metalChunk = newValue)
				.setTooltip(tooltip("metal_chunk"))
				.requireRestart()
				.build();
		var woodenBuckets = entryBuilder.startBooleanToggle(text("wooden_buckets"), loot.woodenBuckets)
				.setDefaultValue(defaultConfig.loot.woodenBuckets)
				.setSaveConsumer(newValue -> loot.woodenBuckets = newValue)
				.setTooltip(tooltip("wooden_buckets"))
				.requireRestart()
				.build();
		var musicDiscs = entryBuilder.startBooleanToggle(text("music_discs"), loot.musicDiscs)
				.setDefaultValue(defaultConfig.loot.musicDiscs)
				.setSaveConsumer(newValue -> loot.musicDiscs = newValue)
				.setTooltip(tooltip("music_discs"))
				.requireRestart()
				.build();

		var knife = entryBuilder.startBooleanToggle(text("knife"), loot.knife)
				.setDefaultValue(defaultConfig.loot.knife)
				.setSaveConsumer(newValue -> loot.knife = newValue)
				.setTooltip(tooltip("knife"))
				.requireRestart()
				.build();
		var hook = entryBuilder.startBooleanToggle(text("hook"), loot.hook)
				.setDefaultValue(defaultConfig.loot.hook)
				.setSaveConsumer(newValue -> loot.hook = newValue)
				.setTooltip(tooltip("hook"))
				.requireRestart()
				.build();

		var improvedLoot = entryBuilder.startBooleanToggle(text("improved_loot"), loot.improvedLoot)
				.setDefaultValue(defaultConfig.loot.improvedLoot)
				.setSaveConsumer(newValue -> loot.improvedLoot = newValue)
				.setTooltip(tooltip("improved_loot"))
				.requireRestart()
				.build();

		var lootCategory = FrozenClothConfig.createSubCategory(entryBuilder, category, text("loot"),
				false,
				tooltip("loot"),
				enchantedBeetroot, metalChunk, woodenBuckets, musicDiscs, knife, hook, improvedLoot
		);

		// Artifacts

		var reinforcedChestplate = entryBuilder.startBooleanToggle(text("reinforced_chestplate"), artifacts.reinforcedChestplate)
				.setDefaultValue(defaultConfig.artifacts.reinforcedChestplate)
				.setSaveConsumer(newValue -> artifacts.reinforcedChestplate = newValue)
				.requireRestart()
				.build();
		var travellingStrides = entryBuilder.startBooleanToggle(text("travelling_strides"), artifacts.travellingStrides)
				.setDefaultValue(defaultConfig.artifacts.travellingStrides)
				.setSaveConsumer(newValue -> artifacts.travellingStrides = newValue)
				.requireRestart()
				.build();
		var wandererBoots = entryBuilder.startBooleanToggle(text("wanderer_boots"), artifacts.wandererBoots)
				.setDefaultValue(defaultConfig.artifacts.wandererBoots)
				.setSaveConsumer(newValue -> artifacts.wandererBoots = newValue)
				.requireRestart()
				.build();
		var verdantSword = entryBuilder.startBooleanToggle(text("verdant_sword"), artifacts.verdantSword)
				.setDefaultValue(defaultConfig.artifacts.verdantSword)
				.setSaveConsumer(newValue -> artifacts.verdantSword = newValue)
				.requireRestart()
				.build();
		var cleavingBattleaxe = entryBuilder.startBooleanToggle(text("cleaving_battleaxe"), artifacts.cleavingBattleaxe)
				.setDefaultValue(defaultConfig.artifacts.cleavingBattleaxe)
				.setSaveConsumer(newValue -> artifacts.cleavingBattleaxe = newValue)
				.requireRestart()
				.build();
		var moltenPickaxe = entryBuilder.startBooleanToggle(text("molten_pickaxe"), artifacts.moltenPickaxe)
				.setDefaultValue(defaultConfig.artifacts.moltenPickaxe)
				.setSaveConsumer(newValue -> artifacts.moltenPickaxe = newValue)
				.requireRestart()
				.build();
		var prospectorShovel = entryBuilder.startBooleanToggle(text("prospector_shovel"), artifacts.prospectorShovel)
				.setDefaultValue(defaultConfig.artifacts.prospectorShovel)
				.setSaveConsumer(newValue -> artifacts.prospectorShovel = newValue)
				.requireRestart()
				.build();
		var witheredHoe = entryBuilder.startBooleanToggle(text("withered_hoe"), artifacts.witheredHoe)
				.setDefaultValue(defaultConfig.artifacts.witheredHoe)
				.setSaveConsumer(newValue -> artifacts.witheredHoe = newValue)
				.requireRestart()
				.build();
		var totemOfVengeance = entryBuilder.startBooleanToggle(text("totem_of_vengeance"), artifacts.totemOfVengeance)
				.setDefaultValue(defaultConfig.artifacts.totemOfVengeance)
				.setSaveConsumer(newValue -> artifacts.totemOfVengeance = newValue)
				.requireRestart()
				.build();
		var totemOfTeleportation = entryBuilder.startBooleanToggle(text("totem_of_teleporation"), artifacts.totemOfTeleportation)
				.setDefaultValue(defaultConfig.artifacts.totemOfTeleportation)
				.setSaveConsumer(newValue -> artifacts.totemOfTeleportation = newValue)
				.requireRestart()
				.build();
		var tabletOfRecall = entryBuilder.startBooleanToggle(text("tablet_of_recall"), artifacts.tabletOfRecall)
				.setDefaultValue(defaultConfig.artifacts.tabletOfRecall)
				.setSaveConsumer(newValue -> artifacts.tabletOfRecall = newValue)
				.requireRestart()
				.build();
		var tabletOfHaste = entryBuilder.startBooleanToggle(text("tablet_of_haste"), artifacts.tabletOfHaste)
				.setDefaultValue(defaultConfig.artifacts.tabletOfHaste)
				.setSaveConsumer(newValue -> artifacts.tabletOfHaste = newValue)
				.requireRestart()
				.build();
		var tabletOfLevitation = entryBuilder.startBooleanToggle(text("tablet_of_levitation"), artifacts.tabletOfLevitation)
				.setDefaultValue(defaultConfig.artifacts.tabletOfLevitation)
				.setSaveConsumer(newValue -> artifacts.tabletOfLevitation = newValue)
				.requireRestart()
				.build();
		var amuletOfAllure = entryBuilder.startBooleanToggle(text("amulet_of_allure"), artifacts.amuletOfAllure)
				.setDefaultValue(defaultConfig.artifacts.amuletOfAllure)
				.setSaveConsumer(newValue -> artifacts.amuletOfAllure = newValue)
				.requireRestart()
				.build();
		var amuletOfSynthesis = entryBuilder.startBooleanToggle(text("amulet_of_synthesis"), artifacts.amuletOfSynthesis)
				.setDefaultValue(defaultConfig.artifacts.amuletOfSynthesis)
				.setSaveConsumer(newValue -> artifacts.amuletOfSynthesis = newValue)
				.requireRestart()
				.build();
		var amuletOfEvasion = entryBuilder.startBooleanToggle(text("amulet_of_evasion"), artifacts.amuletOfEvasion)
				.setDefaultValue(defaultConfig.artifacts.amuletOfEvasion)
				.setSaveConsumer(newValue -> artifacts.amuletOfEvasion = newValue)
				.requireRestart()
				.build();

		var artifactsCategory = FrozenClothConfig.createSubCategory(entryBuilder, category, text("artifacts"),
				false,
				tooltip("artifacts"),
				reinforcedChestplate, travellingStrides, wandererBoots, verdantSword, cleavingBattleaxe, moltenPickaxe, prospectorShovel, witheredHoe, totemOfVengeance, totemOfTeleportation, tabletOfRecall, tabletOfHaste, tabletOfLevitation, amuletOfAllure, amuletOfSynthesis, amuletOfEvasion
		);

		// Enchantments

		var freeze = entryBuilder.startBooleanToggle(text("freeze"), enchantments.freeze)
				.setDefaultValue(defaultConfig.enchantments.freeze)
				.setSaveConsumer(newValue -> enchantments.freeze = newValue)
				.requireRestart()
				.build();
		var tangled = entryBuilder.startBooleanToggle(text("tangled"), enchantments.tangled)
				.setDefaultValue(defaultConfig.enchantments.tangled)
				.setSaveConsumer(newValue -> enchantments.tangled = newValue)
				.requireRestart()
				.build();
		var shatter = entryBuilder.startBooleanToggle(text("shatter"), enchantments.shatter)
				.setDefaultValue(defaultConfig.enchantments.shatter)
				.setSaveConsumer(newValue -> enchantments.shatter = newValue)
				.requireRestart()
				.build();
		var rapidStrike = entryBuilder.startBooleanToggle(text("rapid_strike"), enchantments.rapidStrike)
				.setDefaultValue(defaultConfig.enchantments.rapidStrike)
				.setSaveConsumer(newValue -> enchantments.rapidStrike = newValue)
				.requireRestart()
				.build();
		var slaughter = entryBuilder.startBooleanToggle(text("slaughter"), enchantments.slaughter)
				.setDefaultValue(defaultConfig.enchantments.slaughter)
				.setSaveConsumer(newValue -> enchantments.slaughter = newValue)
				.requireRestart()
				.build();

		var enchantmentsCategory = FrozenClothConfig.createSubCategory(entryBuilder, category, text("enchantments"),
				false,
				tooltip("enchantments"),
				freeze, tangled, shatter, rapidStrike, slaughter
		);

		// Music

		var savannaMusic = entryBuilder.startBooleanToggle(text("savanna_music"), music.savannaMusic)
				.setDefaultValue(defaultConfig.music.savannaMusic)
				.setSaveConsumer(newValue -> music.savannaMusic = newValue)
				.setTooltip(tooltip("savanna_music"))
				.requireRestart()
				.build();
		var snowyMusic = entryBuilder.startBooleanToggle(text("snowy_music"), music.savannaMusic)
				.setDefaultValue(defaultConfig.music.snowyMusic)
				.setSaveConsumer(newValue -> music.snowyMusic = newValue)
				.setTooltip(tooltip("snowy_music"))
				.requireRestart()
				.build();

		var endPortalMusic = entryBuilder.startBooleanToggle(text("end_portal_music"), music.endPortalMusic)
				.setDefaultValue(defaultConfig.music.endPortalMusic)
				.setSaveConsumer(newValue -> music.endPortalMusic = newValue)
				.setTooltip(tooltip("end_portal_music"))
				.requireRestart()
				.build();

		var musicAndMelody = entryBuilder.startBooleanToggle(text("music_and_melody"), music.musicAndMelody)
				.setDefaultValue(defaultConfig.music.musicAndMelody)
				.setSaveConsumer(newValue -> music.musicAndMelody = newValue)
				.setTooltip(tooltip("music_and_melody"))
				.requireRestart()
				.build();

		var musicCategory = FrozenClothConfig.createSubCategory(entryBuilder, category, text("music"),
				false,
				tooltip("music"),
				savannaMusic, snowyMusic, endPortalMusic, musicAndMelody
		);

		// Misc

		var echoShardTrim = entryBuilder.startBooleanToggle(text("echo_shard_trim"), misc.echoShardTrim)
				.setDefaultValue(defaultConfig.misc.echoShardTrim)
				.setSaveConsumer(newValue -> misc.echoShardTrim = newValue)
				.setTooltip(tooltip("echo_shard_trim"))
				.requireRestart()
				.build();

		var integrationDatapacks = entryBuilder.startBooleanToggle(text("integration_datapacks"), misc.integrationDatapacks)
				.setDefaultValue(defaultConfig.misc.integrationDatapacks)
				.setSaveConsumer(newValue -> misc.integrationDatapacks = newValue)
				.setTooltip(tooltip("integration_datapacks"))
				.requireRestart()
				.build();

		var miscCategory = FrozenClothConfig.createSubCategory(entryBuilder, category, text("misc"),
				false,
				tooltip("misc"),
				echoShardTrim, integrationDatapacks
		);
	}
}
