package net.legacy.legacies_and_legends.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.frozenblock.lib.tag.api.FrozenItemTags;
import net.legacy.legacies_and_legends.registry.LaLBlocks;
import net.legacy.legacies_and_legends.registry.LaLEquipmentItems;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public final class LaLBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public LaLBlockTagProvider(@NotNull FabricDataOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider arg) {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(LaLBlocks.SAPPHIRE_BLOCK)
                .add(LaLBlocks.SAPPHIRE_ORE)
                .add(LaLBlocks.DEEPSLATE_SAPPHIRE_ORE);

        this.getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(LaLBlocks.SAPPHIRE_BLOCK)
                .add(LaLBlocks.SAPPHIRE_ORE)
                .add(LaLBlocks.DEEPSLATE_SAPPHIRE_ORE);

        this.getOrCreateTagBuilder(BlockTags.SLABS)
                .add(LaLBlocks.WAND_PLATFORM);

        this.getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(LaLBlocks.SAPPHIRE_BLOCK);
    }
}
