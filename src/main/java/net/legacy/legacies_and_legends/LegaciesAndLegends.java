package net.legacy.legacies_and_legends;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

/**
 * by Rebel459
 */
public class LegaciesAndLegends implements ModInitializer {
	@Override
	public void onInitialize() {
		LegaciesItems.init();
		LegaciesGearItems.init();
		LegaciesBlocks.init();
		LegaciesCreativeInventorySorting.init();
		LegaciesFuelRegistry.registerFuels();
		LegaciesSounds.init();
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath("legacies_and_legends", path);
	}
}