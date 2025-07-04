package net.legacy.legacies_and_legends.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.config.LaLConfig;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static net.minecraft.core.registries.Registries.PLACED_FEATURE;

public class LaLFeatures {

    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE = ResourceKey.create(PLACED_FEATURE, LaLConstants.id("ore_sapphire"));
    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_DEEP = ResourceKey.create(PLACED_FEATURE, LaLConstants.id("ore_sapphire_deep"));

    public static void init() {
        if (LaLConfig.get.worldgen.sapphire) {
            BiomeModifications.addFeature(
                    BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                    GenerationStep.Decoration.UNDERGROUND_ORES,
                    SAPPHIRE_ORE
            );
            BiomeModifications.addFeature(
                    BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                    GenerationStep.Decoration.UNDERGROUND_ORES,
                    SAPPHIRE_ORE_DEEP
            );
        }
    }

}