package net.legacy.legacies_and_legends.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

public class LaLMainConfig {

    public static LaLConfig config;

    public static void initClient() {
        AutoConfig.register(LaLConfig.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(LaLConfig.class).getConfig();
    }
}
