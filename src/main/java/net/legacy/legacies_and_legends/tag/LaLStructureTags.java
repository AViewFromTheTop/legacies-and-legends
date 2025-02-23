package net.legacy.legacies_and_legends.tag;

import net.legacy.legacies_and_legends.LaLConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.jetbrains.annotations.NotNull;

public class LaLStructureTags {
	public static final TagKey<Structure> ON_DUNGEON_EXPLORER_MAPS = bind("on_dungeon_explorer_maps");

	@NotNull
	private static TagKey<Structure> bind(@NotNull String path) {
		return TagKey.create(Registries.STRUCTURE, LaLConstants.id(path));
	}

}