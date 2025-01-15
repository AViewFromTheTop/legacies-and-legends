package net.legacy.legacies_and_legends;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.io.IOException;
import java.util.Optional;

/**
 * by Rebel459
 */
public class LegaciesAndLegends implements ModInitializer {
	@Override
	public void onInitialize() {
		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer("legacies_and_legends");
		try {
			LaLConfig.main();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		LaLItems.init();
		LaLGearItems.init();
		LaLBlocks.init();
		LaLCreativeInventorySorting.init();
		LaLJukeboxSongs.init();
		LaLSounds.init();
		LaLFuelRegistry.registerFuels();

		ResourceManagerHelper.registerBuiltinResourcePack(
				ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID, "legacies_and_legends_asset_overrides"), modContainer.get(),
				Component.translatable("pack.legacies_and_legends.legacies_and_legends_asset_overrides"),
				ResourcePackActivationType.ALWAYS_ENABLED
		);
		if (LaLConfig.music_and_melody) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID, "music_and_melody"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.music_and_melody"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (LaLConfig.reworked_buried_treasure) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID, "reworked_buried_treasure"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.reworked_buried_treasure"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath("legacies_and_legends", path);
	}
}