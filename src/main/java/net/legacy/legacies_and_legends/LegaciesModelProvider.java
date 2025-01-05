package net.legacy.legacies_and_legends;

import com.mojang.datafixers.util.Pair;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class LegaciesModelProvider extends FabricModelProvider {
	public static final List<Pair<BooleanProperty, Function<ResourceLocation, Variant>>> MULTIFACE_GENERATOR_NO_UV_LOCK = List.of(
		Pair.of(BlockStateProperties.NORTH, model -> Variant.variant().with(VariantProperties.MODEL, model)),
		Pair.of(
			BlockStateProperties.EAST,
			model -> Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
		),
		Pair.of(
			BlockStateProperties.SOUTH,
			model -> Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
		),
		Pair.of(
			BlockStateProperties.WEST,
			model -> Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
		),
		Pair.of(
			BlockStateProperties.UP,
			model -> Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
		),
		Pair.of(
			BlockStateProperties.DOWN,
			resourceLocation -> Variant.variant()
				.with(VariantProperties.MODEL, resourceLocation)
				.with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
		)
	);

	public LegaciesModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(@NotNull BlockModelGenerators generator) {
		generator.createTrivialCube(LegaciesBlocks.CRACKED_END_STONE_BRICKS);
	}

	@Override
	public void generateItemModels(@NotNull ItemModelGenerators generator) {
		generator.generateTrimmableItem(LegaciesGearItems.DUNGEON_HELMET, LegaciesEquipmentAssets.DUNGEON, "helmet", false);
		generator.generateTrimmableItem(LegaciesGearItems.DUNGEON_CHESTPLATE, LegaciesEquipmentAssets.DUNGEON, "chestplate", false);
		generator.generateTrimmableItem(LegaciesGearItems.DUNGEON_LEGGINGS, LegaciesEquipmentAssets.DUNGEON, "leggings", false);
		generator.generateTrimmableItem(LegaciesGearItems.DUNGEON_BOOTS, LegaciesEquipmentAssets.DUNGEON, "boots", false);

		generator.generateTrimmableItem(LegaciesGearItems.FORTRESS_HELMET, LegaciesEquipmentAssets.FORTRESS, "helmet", false);
		generator.generateTrimmableItem(LegaciesGearItems.FORTRESS_CHESTPLATE, LegaciesEquipmentAssets.FORTRESS, "chestplate", false);
		generator.generateTrimmableItem(LegaciesGearItems.FORTRESS_LEGGINGS, LegaciesEquipmentAssets.FORTRESS, "leggings", false);
		generator.generateTrimmableItem(LegaciesGearItems.FORTRESS_BOOTS, LegaciesEquipmentAssets.FORTRESS, "boots", false);

		generator.generateTrimmableItem(LegaciesGearItems.WARD_HELMET, LegaciesEquipmentAssets.WARD, "helmet", false);
		generator.generateTrimmableItem(LegaciesGearItems.WARD_CHESTPLATE, LegaciesEquipmentAssets.WARD, "chestplate", false);
		generator.generateTrimmableItem(LegaciesGearItems.WARD_LEGGINGS, LegaciesEquipmentAssets.WARD, "leggings", false);
		generator.generateTrimmableItem(LegaciesGearItems.WARD_BOOTS, LegaciesEquipmentAssets.WARD, "boots", false);

		generator.generateFlatItem(LegaciesGearItems.ANCIENT_KNIFE, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LegaciesGearItems.HOOK, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LegaciesItems.METAL_CHUNK, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LegaciesItems.DISC_FRAGMENT_FAR_LANDS, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LegaciesItems.WOODEN_BUCKET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LegaciesItems.CHARCOAL_BUCKET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LegaciesItems.COAL_BUCKET, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LegaciesItems.MUSIC_DISC_SVALL, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LegaciesItems.MUSIC_DISC_TASWELL, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LegaciesItems.MUSIC_DISC_TUNDRA, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LegaciesItems.MUSIC_DISC_FAR_LANDS, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LegaciesItems.MUSIC_DISC_SHULKER, ModelTemplates.FLAT_ITEM);
	}

	@Contract("_, _ -> new")
	private static @NotNull ModelTemplate createItem(String string, TextureSlot... textureSlots) {
		return new ModelTemplate(Optional.of(LegaciesConstants.id("item/" + string)), Optional.empty(), textureSlots);
	}
}
