package net.legacy.legacies_and_legends.registry;

import net.legacy.legacies_and_legends.LaLConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import org.jetbrains.annotations.NotNull;

public class LaLMapDecorationTypes {
	public static final Holder<MapDecorationType> DUNGEONS = register(
			"dungeon",
			"dungeon",
			true,
			6450790,
			false,
			true
	);

	public static void init() {
	}

	private static @NotNull Holder<MapDecorationType> register(String string, String string2, boolean showOnItemFrame, boolean trackCount) {
		return register(string, string2, showOnItemFrame, -1, trackCount, false);
	}

	private static @NotNull Holder<MapDecorationType> register(
			String string, String string2, boolean showOnItemFrame, int mapColor, boolean trackCount, boolean explorationMapElement
	) {
		ResourceKey<MapDecorationType> resourceKey = ResourceKey.create(Registries.MAP_DECORATION_TYPE, LaLConstants.id(string));
		MapDecorationType mapDecorationType = new MapDecorationType(
				LaLConstants.id(string2), showOnItemFrame, mapColor, explorationMapElement, trackCount
		);
		return Registry.registerForHolder(BuiltInRegistries.MAP_DECORATION_TYPE, resourceKey, mapDecorationType);
	}

}