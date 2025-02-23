package net.legacy.legacies_and_legends.tag;

import net.legacy.legacies_and_legends.LaLConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import org.jetbrains.annotations.NotNull;

public class LaLBiomeTags {
    public static final TagKey<Biome> MUSIC_SNOWY = bind("music_pool/has_snowy_music");
    public static final TagKey<Biome> MUSIC_SAVANNA = bind("music_pool/has_savanna_music");
    public static final TagKey<Biome> MUSIC_DARK_FOREST = bind("music_pool/has_dark_forest_music");

    @NotNull
    private static TagKey<Biome> bind(@NotNull String path) {
        return TagKey.create(Registries.BIOME, LaLConstants.id(path));
    }

}