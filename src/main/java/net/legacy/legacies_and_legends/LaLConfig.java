package net.legacy.legacies_and_legends;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import net.fabricmc.loader.api.FabricLoader;

public class LaLConfig {

  public static boolean music_and_melody;
  public static boolean reworked_buried_treasure;

  public LaLConfig() {}

  public static void main() throws IOException {
    Path configPath = Path.of(FabricLoader.getInstance().getConfigDir().toString(), "legacies-and-legends-config-v1.json");
    try {
      if (configPath.toFile().createNewFile()) {
        JsonObject jsonObjects = getJsonObject();
        PrintWriter pw = new PrintWriter(configPath.toString());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        pw.print(gson.toJson(jsonObjects));
        pw.flush();
        pw.close();
      }
      JsonObject obj = (JsonObject) JsonParser.parseReader(new FileReader(configPath.toString()));
      JsonObject config = (JsonObject) obj.get("config");

      music_and_melody = config.get("music_and_melody").getAsBoolean();
      reworked_buried_treasure = config.get("reworked_buried_treasure").getAsBoolean();

    } catch (final IOException e) {
      System.err.println("An error occurred, delete the legacies and legends config file in your config/ folder and relaunch");
    }
  }

  private static JsonObject getJsonObject() {

    JsonObject jsonObjects = new JsonObject();

    JsonObject configObject = new JsonObject();
    configObject.addProperty("music_and_melody", true);
    configObject.addProperty("reworked_buried_treasure", true);
    jsonObjects.add("config", configObject);

    return jsonObjects;
  }
}
