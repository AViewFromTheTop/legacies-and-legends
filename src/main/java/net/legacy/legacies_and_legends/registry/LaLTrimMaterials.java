package net.legacy.legacies_and_legends.registry;

import net.legacy.legacies_and_legends.LaLConstants;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LaLTrimMaterials {
    public static final List<ResourceKey<TrimMaterial>> TRIM_MATERIALS = new ArrayList<>();

    public static final ResourceKey<TrimMaterial> ECHO = register("echo_shard");

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, ECHO, Items.ECHO_SHARD, Style.EMPTY.withColor(675936));
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> key, Item item, Style style) {
        ResourceLocation location = key.location();
        TrimMaterial material = TrimMaterial.create(location.getPath(), item, Component.translatable(Util.makeDescriptionId("trim_material", location)).withStyle(style), Map.of());
        context.register(key, material);
    }

    private static ResourceKey<TrimMaterial> register(String name) {
        ResourceKey<TrimMaterial> key = ResourceKey.create(Registries.TRIM_MATERIAL, LaLConstants.id(name));
        TRIM_MATERIALS.add(key);
        return key;
    }
}
