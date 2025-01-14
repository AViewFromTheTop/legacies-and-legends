package net.legacy.legacies_and_legends;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
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
		LaLBlocks.init();
		LaLCreativeInventorySorting.init();
		LaLFuelRegistry.registerFuels();
		LaLSounds.init();

		ResourceManagerHelper.registerBuiltinResourcePack(
				ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID, "progression_reborn_asset_overrides"), modContainer.get(),
				Component.translatable("pack.legacies_and_legends.legacies_and_legends_asset_overrides"),
				ResourcePackActivationType.ALWAYS_ENABLED
		);
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath("legacies_and_legends", path);
	}
}