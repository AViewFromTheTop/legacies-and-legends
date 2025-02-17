package net.legacy.legacies_and_legends.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.material.LaLTrimMaterials;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class LaLRegistryProvider extends FabricDynamicRegistryProvider {
    protected LaLRegistryProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    public static void buildRegistry(RegistrySetBuilder registrySetBuilder) {
        registrySetBuilder.add(Registries.TRIM_MATERIAL, LaLTrimMaterials::bootstrap);
    }

    @Override
    public void configure(HolderLookup.Provider registries, Entries entries) {
        addAll(entries, registries.lookupOrThrow(Registries.TRIM_MATERIAL), LaLConstants.MOD_ID);
    }

    @Override
    public String getName() {
        return "Legacies and Legends";
    }

    @SuppressWarnings("UnusedReturnValue")
    public <T> List<Holder<T>> addAll(Entries entries, HolderLookup.RegistryLookup<T> registry, String modId) {
        return registry.listElementIds()
                .filter(registryKey -> registryKey.location().getNamespace().equals(LaLConstants.MOD_ID))
                .map(key -> entries.add(registry, key))
                .toList();
    }

}
