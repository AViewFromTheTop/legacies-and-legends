package net.legacy.legacies_and_legends;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorMaterial;

/**
 * by Rebel459
 */
public class LegaciesAndLegends implements ModInitializer {
	@Override
	public void onInitialize() {
		LegaciesItems.register();
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath("legacies_and_legends", path);
	}
}