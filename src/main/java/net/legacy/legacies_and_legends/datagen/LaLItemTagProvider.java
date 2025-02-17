package net.legacy.legacies_and_legends.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.legacy.legacies_and_legends.registry.LaLGearItems;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class LaLItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public LaLItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @NotNull
    private TagKey<Item> getTag(String id) {
        return TagKey.create(this.registryKey, ResourceLocation.parse(id));
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        this.getOrCreateTagBuilder(ItemTags.DECORATED_POT_SHERDS)
                .add(LaLItems.VERDANT_POTTERY_SHERD)
                .add(LaLItems.FORAGER_POTTERY_SHERD)
                .add(LaLItems.HARVEST_POTTERY_SHERD)
                .add(LaLItems.DUSK_POTTERY_SHERD);

        this.getOrCreateTagBuilder(LaLItemTags.TABLETS)
                .add(LaLItems.TABLET_OF_HASTE)
                .add(LaLItems.TABLET_OF_LEVITATION)
                .add(LaLItems.TABLET_OF_RECALL);

        this.getOrCreateTagBuilder(LaLItemTags.HAS_ITEM_EFFECT)
                .add(LaLItems.AMULET_OF_ALLURE)
                .add(LaLItems.AMULET_OF_SYNTHESIS)
                .add(LaLItems.AMULET_OF_EVASION);
        this.getOrCreateTagBuilder(LaLItemTags.HAS_BREED_EFFECT)
                .add(LaLItems.AMULET_OF_ALLURE);
        this.getOrCreateTagBuilder(LaLItemTags.HAS_KILL_EFFECT)
                .add(LaLItems.AMULET_OF_SYNTHESIS);
    }
}
