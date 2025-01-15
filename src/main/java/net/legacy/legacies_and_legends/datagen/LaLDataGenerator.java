package net.legacy.legacies_and_legends.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.frozenblock.lib.feature_flag.api.FrozenFeatureFlags;
import org.jetbrains.annotations.NotNull;

public final class LaLDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(@NotNull FabricDataGenerator dataGenerator) {

		FrozenFeatureFlags.rebuild();
		final FabricDataGenerator.Pack pack = dataGenerator.createPack();

		pack.addProvider(LaLModelProvider::new);
		pack.addProvider(LaLRegistryProvider::new);
		pack.addProvider(LaLModelProvider::new);
		pack.addProvider(LaLItemTagProvider::new);
	}
}
