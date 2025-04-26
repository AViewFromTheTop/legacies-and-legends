package net.legacy.legacies_and_legends.registry;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.component.ProvidesTrimMaterial;
import net.minecraft.world.item.enchantment.Repairable;

public class LaLItemComponents {
    public static void init(){
            DefaultItemComponentEvents.MODIFY.register(context -> {
                context.modify(Items.TRIDENT, builder -> {
                    builder.set(DataComponents.ATTRIBUTE_MODIFIERS, TridentItem.createAttributes());
                    HolderGetter<Item> holderGetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.ITEM);
                    builder.set(DataComponents.REPAIRABLE, new Repairable(holderGetter.getOrThrow(LaLItemTags.TRIDENT_REPAIR_MATERIALS)));
                });
                context.modify(Items.ECHO_SHARD, builder -> {
                    builder.set(DataComponents.PROVIDES_TRIM_MATERIAL, new ProvidesTrimMaterial(LaLTrimMaterials.ECHO));
                });
            });
    }
}