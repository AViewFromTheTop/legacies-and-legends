package net.legacy.legacies_and_legends.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.frozenblock.lib.tag.api.FrozenItemTags;
import net.legacy.item_tooltips.registry.ITItemTags;
import net.legacy.legacies_and_legends.registry.LaLEntityTypes;
import net.legacy.legacies_and_legends.registry.LaLEquipmentItems;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.tag.LaLEntityTags;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class LaLEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {

    public LaLEntityTagProvider(@NotNull FabricDataOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider arg) {
        this.getOrCreateTagBuilder(LaLEntityTags.DAMAGELESS_PROJECTILES)
                .add(EntityType.WIND_CHARGE)
                .add(EntityType.BREEZE_WIND_CHARGE)
                .add(EntityType.SNOWBALL)
                .add(EntityType.EGG);
    }
}
