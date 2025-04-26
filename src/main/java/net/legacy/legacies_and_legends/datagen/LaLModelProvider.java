package net.legacy.legacies_and_legends.datagen;

import com.mojang.datafixers.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.legacy.legacies_and_legends.*;
import net.legacy.legacies_and_legends.registry.LaLEquipmentAssets;
import net.legacy.legacies_and_legends.registry.LaLEquipmentItems;
import net.legacy.legacies_and_legends.registry.LaLTrimMaterials;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class LaLModelProvider extends FabricModelProvider {
	public static final MaterialAssetGroup ECHO_SHARD = MaterialAssetGroup.create("echo_shard");

	private static final List<ItemModelGenerators.TrimMaterialData> TRIM_MATERIALS = List.of(
			new ItemModelGenerators.TrimMaterialData(ECHO_SHARD, LaLTrimMaterials.ECHO)
	);

	public LaLModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(@NotNull BlockModelGenerators generator) {
	}

	@Override
	public void generateItemModels(@NotNull ItemModelGenerators generator) {
		generator.generateTrimmableItem(LaLItems.REINFORCED_CHESTPLATE, LaLEquipmentAssets.REINFORCED, LaLConstants.id("chestplate"), false);
		generator.generateTrimmableItem(LaLItems.TRAVELLING_STRIDES, LaLEquipmentAssets.TRAVELLING, LaLConstants.id("leggings"), false);
		generator.generateTrimmableItem(LaLItems.WANDERER_BOOTS, LaLEquipmentAssets.WANDERER, LaLConstants.id("boots"), false);

		generator.generateFlatItem(LaLItems.BOOMERANG, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLEquipmentItems.KNIFE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLEquipmentItems.HOOK, ModelTemplates.FLAT_HANDHELD_ITEM);

		generator.generateFlatItem(LaLEquipmentItems.VERDANT_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLEquipmentItems.CLEAVING_BATTLEAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLEquipmentItems.MOLTEN_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLEquipmentItems.PROSPECTOR_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLEquipmentItems.WITHERED_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

		generator.generateFlatItem(LaLItems.TOTEM_OF_TELEPORTATION, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.TOTEM_OF_VENGEANCE, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.AMULET_OF_ALLURE, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.AMULET_OF_EVASION, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.AMULET_OF_SYNTHESIS, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.METAL_CHUNK, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.TRIDENT_SHARD, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.DISC_FRAGMENT_FAR_LANDS, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.WOODEN_BUCKET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.CHARCOAL_BUCKET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.COAL_BUCKET, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.MUSIC_DISC_SVALL, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_CASTLES, ModelTemplates.FLAT_ITEM);
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

		this.registerArmorTrims(generator, LaLItems.REINFORCED_CHESTPLATE, LaLEquipmentAssets.REINFORCED, "chestplate", false);
		this.registerArmorTrims(generator, LaLItems.TRAVELLING_STRIDES, LaLEquipmentAssets.TRAVELLING, "leggings", false);
		this.registerArmorTrims(generator, LaLItems.WANDERER_BOOTS, LaLEquipmentAssets.WANDERER, "boots", false);

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
					armorModelId.getPath()).withSuffix("_" + trimMaterial.assets().base().suffix() + "_trim");
			ResourceLocation trimTextureId = ResourceLocation.withDefaultNamespace(
					"trims/items/" + armorType + "_trim_" + trimMaterial.assets().assetId(equipmentKey).suffix());
			if (dyeable) {
				this.uploadArmor3(generator, trimmedModelId, armorTextures, armorOverlayTextures, trimTextureId);
			} else {
				this.uploadArmor2(generator, trimmedModelId, armorTextures, trimTextureId);
			}
		}
	}
}
