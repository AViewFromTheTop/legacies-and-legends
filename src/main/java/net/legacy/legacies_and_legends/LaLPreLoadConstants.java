package net.legacy.legacies_and_legends;

import java.nio.file.Path;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class LaLPreLoadConstants {
	public static final String MOD_ID = "legacies_and_legends";

	@Contract(pure = true)
	public static @NotNull Path configPath(boolean json5) {
		return Path.of("./config/" + MOD_ID + "." + (json5 ? "json5" : "json"));
	}
}
