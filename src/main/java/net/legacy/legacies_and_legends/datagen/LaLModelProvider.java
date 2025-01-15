package net.legacy.legacies_and_legends.datagen;

import com.mojang.datafixers.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.legacy.legacies_and_legends.*;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class LaLModelProvider extends FabricModelProvider {
	private static final List<ItemModelGenerators.TrimMaterialData> TRIM_MATERIALS = List.of(
			new ItemModelGenerators.TrimMaterialData("echo_shard", LaLTrimMaterials.ECHO, Map.of())
	);

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

	public LaLModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(@NotNull BlockModelGenerators generator) {
		generator.createTrivialCube(LaLBlocks.CRACKED_END_STONE_BRICKS);
	}

	@Override
	public void generateItemModels(@NotNull ItemModelGenerators generator) {
		generator.generateTrimmableItem(LaLGearItems.DUNGEON_HELMET, LaLEquipmentAssets.DUNGEON, "helmet", false);
		generator.generateTrimmableItem(LaLGearItems.DUNGEON_CHESTPLATE, LaLEquipmentAssets.DUNGEON, "chestplate", false);
		generator.generateTrimmableItem(LaLGearItems.DUNGEON_LEGGINGS, LaLEquipmentAssets.DUNGEON, "leggings", false);
		generator.generateTrimmableItem(LaLGearItems.DUNGEON_BOOTS, LaLEquipmentAssets.DUNGEON, "boots", false);

		generator.generateTrimmableItem(LaLGearItems.FORTRESS_HELMET, LaLEquipmentAssets.FORTRESS, "helmet", false);
		generator.generateTrimmableItem(LaLGearItems.FORTRESS_CHESTPLATE, LaLEquipmentAssets.FORTRESS, "chestplate", false);
		generator.generateTrimmableItem(LaLGearItems.FORTRESS_LEGGINGS, LaLEquipmentAssets.FORTRESS, "leggings", false);
		generator.generateTrimmableItem(LaLGearItems.FORTRESS_BOOTS, LaLEquipmentAssets.FORTRESS, "boots", false);

		generator.generateTrimmableItem(LaLGearItems.WARD_HELMET, LaLEquipmentAssets.WARD, "helmet", false);
		generator.generateTrimmableItem(LaLGearItems.WARD_CHESTPLATE, LaLEquipmentAssets.WARD, "chestplate", false);
		generator.generateTrimmableItem(LaLGearItems.WARD_LEGGINGS, LaLEquipmentAssets.WARD, "leggings", false);
		generator.generateTrimmableItem(LaLGearItems.WARD_BOOTS, LaLEquipmentAssets.WARD, "boots", false);

		generator.generateFlatItem(LaLGearItems.KNIFE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLGearItems.HOOK, ModelTemplates.FLAT_HANDHELD_ITEM);

		generator.generateFlatItem(LaLItems.METAL_CHUNK, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.DISC_FRAGMENT_FAR_LANDS, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.WOODEN_BUCKET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.CHARCOAL_BUCKET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.COAL_BUCKET, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.MUSIC_DISC_SVALL, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_TASWELL, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_TUNDRA, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_FAR_LANDS, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_SHULKER, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_INFINITE_SPOOKY_AMETHYST, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.DUSK_POTTERY_SHERD, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.HARVEST_POTTERY_SHERD, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.VERDANT_POTTERY_SHERD, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.FORAGER_POTTERY_SHERD, ModelTemplates.FLAT_ITEM);

		this.registerArmorTrims(generator, Items.TURTLE_HELMET, EquipmentAssets.TURTLE_SCUTE, "helmet", false);
		this.registerArmorTrims(generator, Items.LEATHER_HELMET, EquipmentAssets.LEATHER, "helmet", true);
		this.registerArmorTrims(generator, Items.LEATHER_CHESTPLATE, EquipmentAssets.LEATHER, "chestplate", true);
		this.registerArmorTrims(generator, Items.LEATHER_LEGGINGS, EquipmentAssets.LEATHER, "leggings", true);
		this.registerArmorTrims(generator, Items.LEATHER_BOOTS, EquipmentAssets.LEATHER, "boots", true);
		this.registerArmorTrims(generator, Items.CHAINMAIL_HELMET, EquipmentAssets.CHAINMAIL, "helmet", false);
		this.registerArmorTrims(generator, Items.CHAINMAIL_CHESTPLATE, EquipmentAssets.CHAINMAIL, "chestplate", false);
		this.registerArmorTrims(generator, Items.CHAINMAIL_LEGGINGS, EquipmentAssets.CHAINMAIL, "leggings", false);
		this.registerArmorTrims(generator, Items.CHAINMAIL_BOOTS, EquipmentAssets.CHAINMAIL, "boots", false);
		this.registerArmorTrims(generator, Items.IRON_HELMET, EquipmentAssets.IRON, "helmet", false);
		this.registerArmorTrims(generator, Items.IRON_CHESTPLATE, EquipmentAssets.IRON, "chestplate", false);
		this.registerArmorTrims(generator, Items.IRON_LEGGINGS, EquipmentAssets.IRON, "leggings", false);
		this.registerArmorTrims(generator, Items.IRON_BOOTS, EquipmentAssets.IRON, "boots", false);
		this.registerArmorTrims(generator, Items.DIAMOND_HELMET, EquipmentAssets.DIAMOND, "helmet", false);
		this.registerArmorTrims(generator, Items.DIAMOND_CHESTPLATE, EquipmentAssets.DIAMOND, "chestplate", false);
		this.registerArmorTrims(generator, Items.DIAMOND_LEGGINGS, EquipmentAssets.DIAMOND, "leggings", false);
		this.registerArmorTrims(generator, Items.DIAMOND_BOOTS, EquipmentAssets.DIAMOND, "boots", false);
		this.registerArmorTrims(generator, Items.GOLDEN_HELMET, EquipmentAssets.GOLD, "helmet", false);
		this.registerArmorTrims(generator, Items.GOLDEN_CHESTPLATE, EquipmentAssets.GOLD, "chestplate", false);
		this.registerArmorTrims(generator, Items.GOLDEN_LEGGINGS, EquipmentAssets.GOLD, "leggings", false);
		this.registerArmorTrims(generator, Items.GOLDEN_BOOTS, EquipmentAssets.GOLD, "boots", false);
		this.registerArmorTrims(generator, Items.NETHERITE_HELMET, EquipmentAssets.NETHERITE, "helmet", false);
		this.registerArmorTrims(generator, Items.NETHERITE_CHESTPLATE, EquipmentAssets.NETHERITE, "chestplate", false);
		this.registerArmorTrims(generator, Items.NETHERITE_LEGGINGS, EquipmentAssets.NETHERITE, "leggings", false);
		this.registerArmorTrims(generator, Items.NETHERITE_BOOTS, EquipmentAssets.NETHERITE, "boots", false);

		this.registerArmorTrims(generator, LaLGearItems.DUNGEON_HELMET, LaLEquipmentAssets.DUNGEON, "helmet", false);
		this.registerArmorTrims(generator, LaLGearItems.DUNGEON_CHESTPLATE, LaLEquipmentAssets.DUNGEON, "chestplate", false);
		this.registerArmorTrims(generator, LaLGearItems.DUNGEON_LEGGINGS, LaLEquipmentAssets.DUNGEON, "leggings", false);
		this.registerArmorTrims(generator, LaLGearItems.DUNGEON_BOOTS, LaLEquipmentAssets.DUNGEON, "boots", false);

		this.registerArmorTrims(generator, LaLGearItems.FORTRESS_HELMET, LaLEquipmentAssets.FORTRESS, "helmet", false);
		this.registerArmorTrims(generator, LaLGearItems.FORTRESS_CHESTPLATE, LaLEquipmentAssets.FORTRESS, "chestplate", false);
		this.registerArmorTrims(generator, LaLGearItems.FORTRESS_LEGGINGS, LaLEquipmentAssets.FORTRESS, "leggings", false);
		this.registerArmorTrims(generator, LaLGearItems.FORTRESS_BOOTS, LaLEquipmentAssets.FORTRESS, "boots", false);

		this.registerArmorTrims(generator, LaLGearItems.WARD_HELMET, LaLEquipmentAssets.WARD, "helmet", false);
		this.registerArmorTrims(generator, LaLGearItems.WARD_CHESTPLATE, LaLEquipmentAssets.WARD, "chestplate", false);
		this.registerArmorTrims(generator, LaLGearItems.WARD_LEGGINGS, LaLEquipmentAssets.WARD, "leggings", false);
		this.registerArmorTrims(generator, LaLGearItems.WARD_BOOTS, LaLEquipmentAssets.WARD, "boots", false);
	}

	@Contract("_, _ -> new")
	private static @NotNull ModelTemplate createItem(String string, TextureSlot... textureSlots) {
		return new ModelTemplate(Optional.of(net.legacy.legacies_and_legends.LaLConstants.id("item/" + string)), Optional.empty(), textureSlots);
	}

	private void uploadArmor2(ItemModelGenerators generator, ResourceLocation id, ResourceLocation layer0, ResourceLocation layer1) {
		ModelTemplates.TWO_LAYERED_ITEM.create(id, TextureMapping.layered(layer0, layer1), generator.modelOutput);
	}

	private void uploadArmor3(ItemModelGenerators generator, ResourceLocation id, ResourceLocation layer0, ResourceLocation layer1, ResourceLocation layer2) {
		ModelTemplates.THREE_LAYERED_ITEM.create(id, TextureMapping.layered(layer0, layer1, layer2), generator.modelOutput);
	}

	private void registerArmorTrims(ItemModelGenerators generator, Item armor, ResourceKey<EquipmentAsset> equipmentKey, String armorType, boolean dyeable) {
		ResourceLocation armorModelId = TextureMapping.getItemTexture(armor);
		ResourceLocation armorTextures = TextureMapping.getItemTexture(armor);
		ResourceLocation armorOverlayTextures = TextureMapping.getItemTexture(armor, "_overlay");
		for (ItemModelGenerators.TrimMaterialData trimMaterial : TRIM_MATERIALS) {
			ResourceLocation trimmedModelId = ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID,
					armorModelId.getPath()).withSuffix("_" + trimMaterial.name() + "_trim");
			ResourceLocation trimTextureId = ResourceLocation.withDefaultNamespace(
					"trims/items/" + armorType + "_trim_" + trimMaterial.textureName(equipmentKey));
			if (dyeable) {
				this.uploadArmor3(generator, trimmedModelId, armorTextures, armorOverlayTextures, trimTextureId);
			} else {
				this.uploadArmor2(generator, trimmedModelId, armorTextures, trimTextureId);
			}
		}
	}
}
