package net.legacy.legacies_and_legends;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import org.jetbrains.annotations.NotNull;

public class LaLJukeboxSongs {
	public static final ResourceKey<JukeboxSong> SVALL = create("svall");
	public static final ResourceKey<JukeboxSong> TASWELL = create("taswell");
	public static final ResourceKey<JukeboxSong> SHULKER = create("shulker");
	public static final ResourceKey<JukeboxSong> TUNDRA = create("tundra");
	public static final ResourceKey<JukeboxSong> FAR_LANDS = create("far_lands");
	public static final ResourceKey<JukeboxSong> INFINITE_SPOOKY_AMETHYST = create("spooky_infinite_amethyst");

	public static void init() {
	}

	private static @NotNull ResourceKey<JukeboxSong> create(String path) {
		return ResourceKey.create(Registries.JUKEBOX_SONG, LaLConstants.id(path));
	}

	private static void register(
		@NotNull BootstrapContext<JukeboxSong> context,
		ResourceKey<JukeboxSong> registryKey,
		Holder.Reference<SoundEvent> soundEvent,
		int lengthInSeconds,
		int comparatorOutput
	) {
		context.register(
			registryKey,
			new JukeboxSong(soundEvent, Component.translatable(Util.makeDescriptionId("jukebox_song", registryKey.location())), (float)lengthInSeconds, comparatorOutput)
		);
	}

	public static void bootstrap(BootstrapContext<JukeboxSong> context) {
		register(context, SVALL, LaLSounds.MUSIC_DISC_SVALL, 244, 6);
		register(context, TASWELL, LaLSounds.MUSIC_DISC_TASWELL, 600, 7);
		register(context, SHULKER, LaLSounds.MUSIC_DISC_SHULKER, 128, 13);
		register(context, TUNDRA, LaLSounds.MUSIC_DISC_TUNDRA, 118, 5);
		register(context, FAR_LANDS, LaLSounds.MUSIC_DISC_FAR_LANDS, 266, 15);
		register(context, INFINITE_SPOOKY_AMETHYST, LaLSounds.INFINITE_SPOOKY_AMETHYST, 292, 11);
	}
}
