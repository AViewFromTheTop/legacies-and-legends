package net.legacy.legacies_and_legends;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.legacies_and_legends.config.LaLConfig;
import net.legacy.legacies_and_legends.config.LaLMainConfig;
import net.legacy.legacies_and_legends.enchantment.LaLEnchantmentEffects;
import net.legacy.legacies_and_legends.enchantment.LaLMobEffects;
import net.legacy.legacies_and_legends.registry.*;
import net.legacy.legacies_and_legends.sound.LaLJukeboxSongs;
import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.minecraft.network.chat.Component;

import java.util.Optional;

public class LegaciesAndLegends implements ModInitializer {

	public static boolean isWilderWildLoaded = false;
	public static boolean isVariantsAndVenturesLoaded = false;
	public static boolean isTrailierTalesLoaded = false;
	public static boolean isEnchantsAndExpeditionsLoaded = false;

	@Override
	public void onInitialize() {
		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer("legacies_and_legends");

		LaLItems.init();
		LaLEquipmentItems.init();
		LaLCreativeInventorySorting.init();
		LaLJukeboxSongs.init();
		LaLSounds.init();
		LaLFuelRegistry.registerFuels();
		LaLTrimItemModels.init();
		LaLEntityTypes.init();
		LaLMainConfig.initClient();
		LaLEnchantmentEffects.register();
		LaLMobEffects.init();
		LaLLootTables.init();

		ResourceManagerHelper.registerBuiltinResourcePack(
				LaLConstants.id("asset_overrides"), modContainer.get(),
				Component.translatable("pack.legacies_and_legends.asset_overrides"),
				ResourcePackActivationType.ALWAYS_ENABLED
		);
		if (LaLConfig.get().music.music_and_melody) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("music_and_melody"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.music_and_melody"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (LaLConfig.get().structures.dungeon_overhaul) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("dungeon_overhaul"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.dungeon_overhaul"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (LaLConfig.get().structures.swamp_hut_variants) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("swamp_hut_variants"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.swamp_hut_variants"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (LaLConfig.get().structures.buried_treasure_rework) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("buried_treasure_rework"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.reworked_buried_treasure"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (!LaLConfig.get().artifacts.travelling_strides) {
			isVariantsAndVenturesLoaded = true;
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("no_travelling_strides"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.no_travelling_strides"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (!LaLConfig.get().artifacts.withered_hoe) {
			isVariantsAndVenturesLoaded = true;
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("no_withered_hoe"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.no_withered_hoe"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("enchants_and_expeditions")) {
			isEnchantsAndExpeditionsLoaded = true;
		}
		if (FabricLoader.getInstance().isModLoaded("wilderwild") && LaLConfig.get().integrations.wilder_wild) {
			isWilderWildLoaded = true;
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("wilder_wild_integration"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.wilder_wild_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("trailiertales") && LaLConfig.get().integrations.trailier_tales) {
			isTrailierTalesLoaded = true;
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("trailier_tales_integration"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.wilder_wild_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("variantsandventures") && LaLConfig.get().integrations.variants_and_ventures) {
			isVariantsAndVenturesLoaded = true;
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("variants_and_ventures_integration"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.wilder_wild_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
	}
}