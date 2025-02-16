package net.legacy.legacies_and_legends.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.NotNull;

import static net.legacy.legacies_and_legends.LaLConstants.text;

public final class LaLMainConfigGui {

	public static Screen buildScreen(@NotNull Screen parent) {
		var configBuilder = ConfigBuilder.create().setParentScreen(parent).setTitle(text("component.title"));
		configBuilder.setSavingRunnable(() -> {
			LaLConfig.INSTANCE.save();
		});

		ConfigEntryBuilder entryBuilder = configBuilder.entryBuilder();

		var config = configBuilder.getOrCreateCategory(text("config"));
		LaLConfigGUI.setupEntries(config, entryBuilder);
		return configBuilder.build();
	}

}
