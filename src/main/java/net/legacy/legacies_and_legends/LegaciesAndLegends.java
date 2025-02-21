package net.legacy.legacies_and_legends;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.legacies_and_legends.config.LaLConfig;
import net.legacy.legacies_and_legends.config.LaLMainConfig;
import net.legacy.legacies_and_legends.registry.LaLEntityTypes;
import net.legacy.legacies_and_legends.registry.LaLTrimItemModels;
import net.legacy.legacies_and_legends.registry.LaLCreativeInventorySorting;
import net.legacy.legacies_and_legends.registry.LaLFuelRegistry;
import net.legacy.legacies_and_legends.registry.LaLGearItems;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.sound.LaLJukeboxSongs;
import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.minecraft.network.chat.Component;

import java.util.Optional;

public class LegaciesAndLegends implements ModInitializer {

	@Override
	public void onInitialize() {
		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer("legacies_and_legends");

		LaLItems.init();
		LaLGearItems.init();
		LaLCreativeInventorySorting.init();
		LaLJukeboxSongs.init();
		LaLSounds.init();
		LaLFuelRegistry.registerFuels();
		LaLTrimItemModels.init();
		LaLEntityTypes.init();
		LaLMainConfig.initClient();

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
		if (FabricLoader.getInstance().isModLoaded("wilderwild") && LaLConfig.get().integrations.wilder_wild) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("wilder_wild_integration"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.wilder_wild_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("trailiertales") && LaLConfig.get().integrations.trailier_tales) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("trailier_tales_integration"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.wilder_wild_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("variantsandventures") && LaLConfig.get().integrations.variants_and_ventures) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("variants_and_ventures_integration"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.wilder_wild_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
	}
}