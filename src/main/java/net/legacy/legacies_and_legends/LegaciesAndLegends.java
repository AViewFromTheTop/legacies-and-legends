package net.legacy.legacies_and_legends;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.legacies_and_legends.config.LaLConfig;
import net.legacy.legacies_and_legends.config.LaLMainConfig;
import net.legacy.legacies_and_legends.entity.LaLEntityType;
import net.legacy.legacies_and_legends.equipment.LaLTrimItemModels;
import net.legacy.legacies_and_legends.registry.LaLCreativeInventorySorting;
import net.legacy.legacies_and_legends.registry.LaLFuelRegistry;
import net.legacy.legacies_and_legends.registry.LaLGearItems;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.sound.LaLJukeboxSongs;
import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

/**
 * by Rebel459
 */
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
		LaLEntityType.init();
		LaLMainConfig.initClient();

		ResourceManagerHelper.registerBuiltinResourcePack(
				ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID, "legacies_and_legends_asset_overrides"), modContainer.get(),
				Component.translatable("pack.legacies_and_legends.legacies_and_legends_asset_overrides"),
				ResourcePackActivationType.ALWAYS_ENABLED
		);
		if (LaLConfig.get().structures.buried_treasure_rework) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID, "music_and_melody"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.music_and_melody"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (LaLConfig.get().structures.dungeon_overhaul) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID, "dungeon_overhaul"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.reworked_buried_treasure"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (LaLConfig.get().structures.buried_treasure_rework) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID, "buried_treasure_rework"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.reworked_buried_treasure"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("wilderwild") && LaLConfig.get().integrations.wilder_wild) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID, "wilder_wild_integration"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.wilder_wild_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath("legacies_and_legends", path);
	}
}