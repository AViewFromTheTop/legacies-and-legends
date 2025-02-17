package net.legacy.legacies_and_legends.material;

import net.legacy.legacies_and_legends.LaLConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;

import java.util.List;

public class LaLTrimMaterials {
    public static final List<String> TRIM_MATERIALS = List.of("echo_shard");

    public static final ResourceKey<TrimMaterial> ECHO = createResourceKey("echo_shard");

    public static void bootstrap(BootstrapContext<TrimMaterial> bootstrapContext) {
        TrimMaterials.register(bootstrapContext, ECHO, Items.ECHO_SHARD, Style.EMPTY.withColor(675936));
    }

    private static ResourceKey<TrimMaterial> createResourceKey(String string) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID, string));
    }
}