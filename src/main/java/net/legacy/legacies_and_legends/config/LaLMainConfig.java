package net.legacy.legacies_and_legends.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public class LaLMainConfig {
    public static final String MOD_ID = "legacies_and_legends";

    @Contract(pure = true)
    public static @NotNull Path configPath(boolean json5) {
        return Path.of("./config/" + MOD_ID + "." + (json5 ? "json5" : "json"));
    }

    public static LaLConfig config;

    public static void initClient() {
        AutoConfig.register(LaLConfig.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(LaLConfig.class).getConfig();
    }
}
