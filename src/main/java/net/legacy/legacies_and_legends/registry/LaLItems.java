package net.legacy.legacies_and_legends.registry;

import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.frozenblock.lib.item.api.sherd.SherdRegistry;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.equipment.LaLBoomerang;
import net.legacy.legacies_and_legends.equipment.LaLEquipmentAssets;
import net.legacy.legacies_and_legends.equipment.LaLRecallTablet;
import net.legacy.legacies_and_legends.food.LaLFoods;
import net.legacy.legacies_and_legends.sound.LaLJukeboxSongs;
import net.legacy.legacies_and_legends.food.LaLConsumables;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.DeathProtection;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ClearAllStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.TeleportRandomlyConsumeEffect;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.List;
import java.util.function.Function;

public final class LaLItems {

    public static final ResourceLocation ARMOR_ID = ResourceLocation.withDefaultNamespace("armor");
    public static final ResourceLocation KNOCKBACK_RESISTANCE_ID = ResourceLocation.withDefaultNamespace("knockback_resistance_id");
    public static final ResourceLocation MOVEMENT_SPEED_ID = ResourceLocation.withDefaultNamespace("movement_speed");
    public static final ResourceLocation STEP_HEIGHT_ID = ResourceLocation.withDefaultNamespace("step_height");

    public static final ResourceLocation TEMPT_RANGE_ID = ResourceLocation.withDefaultNamespace("tempt_range");

    private static final ItemAttributeModifiers createAmuletOfAllureAttributes = ItemAttributeModifiers.builder()
            .add(Attributes.TEMPT_RANGE, new AttributeModifier(TEMPT_RANGE_ID, 10, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
            .add(Attributes.TEMPT_RANGE, new AttributeModifier(TEMPT_RANGE_ID, 10, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.OFFHAND)
            .build();

    private static final ItemAttributeModifiers createReinforcedChestplateAttributes = ItemAttributeModifiers.builder()
            .add(Attributes.ARMOR, new AttributeModifier(ARMOR_ID, 7, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.CHEST)
            .add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(KNOCKBACK_RESISTANCE_ID, 5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.CHEST)
            .build();

    private static final ItemAttributeModifiers createTravellingStridesAttributes = ItemAttributeModifiers.builder()
            .add(Attributes.ARMOR, new AttributeModifier(ARMOR_ID, 3, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS)
            .add(Attributes.MOVEMENT_SPEED, new AttributeModifier(MOVEMENT_SPEED_ID, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.LEGS)
            .build();

    private static final ItemAttributeModifiers createWandererBootsAttributes = ItemAttributeModifiers.builder()
            .add(Attributes.ARMOR, new AttributeModifier(ARMOR_ID, 2, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET)
            .add(Attributes.STEP_HEIGHT, new AttributeModifier(STEP_HEIGHT_ID, 1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.FEET)
            .build();

    // Boomerang
    public static final LaLBoomerang BOOMERANG = register("boomerang",
            LaLBoomerang::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.TOOL, LaLBoomerang.createToolProperties())
                    .component(DataComponents.ATTRIBUTE_MODIFIERS, LaLBoomerang.createAttributes())
    );

    // Misc Items
    public static final Item DISC_FRAGMENT_FAR_LANDS = register("disc_fragment_far_lands",
            DiscFragmentItem::new,
            new Properties()
                    .stacksTo(64)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item METAL_CHUNK = register("metal_chunk",
            Item::new,
            new Properties()
                    .stacksTo(64)
    );
    public static final Item WOODEN_BUCKET = register("wooden_bucket",
            Item::new,
            new Properties()
                    .stacksTo(16)
    );
    public static final Item COAL_BUCKET = register("coal_bucket",
            Item::new,
            new Properties()
                    .stacksTo(16)
    );
    public static final Item CHARCOAL_BUCKET = register("charcoal_bucket",
            Item::new,
            new Properties()
                    .stacksTo(16)
    );

    // Discs
    public static final Item MUSIC_DISC_SVALL = register("music_disc_svall",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(LaLJukeboxSongs.SVALL)
    );
    public static final Item MUSIC_DISC_TASWELL = register("music_disc_taswell",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(LaLJukeboxSongs.TASWELL)
    );
    public static final Item MUSIC_DISC_SHULKER = register("music_disc_shulker",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(LaLJukeboxSongs.SHULKER)
    );
    public static final Item MUSIC_DISC_TUNDRA = register("music_disc_tundra",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(LaLJukeboxSongs.TUNDRA)
    );
    public static final Item MUSIC_DISC_FAR_LANDS = register("music_disc_far_lands",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(LaLJukeboxSongs.FAR_LANDS)
    );
    public static final Item MUSIC_DISC_INFINITE_SPOOKY_AMETHYST = register("music_disc_infinite_spooky_amethyst",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(LaLJukeboxSongs.INFINITE_SPOOKY_AMETHYST)
    );

    // Sherds
    public static final Item DUSK_POTTERY_SHERD = registerSherd("dusk_pottery_sherd",
            Item::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item HARVEST_POTTERY_SHERD = registerSherd("harvest_pottery_sherd",
            Item::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item VERDANT_POTTERY_SHERD = registerSherd("verdant_pottery_sherd",
            Item::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item FORAGER_POTTERY_SHERD = registerSherd("forager_pottery_sherd",
            Item::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
    );

    // Food
    public static final Item ENCHANTED_BEETROOT = register("enchanted_beetroot",
            Item::new,
            new Properties()
                    .stacksTo(64)
                    .rarity(Rarity.RARE)
                    .food(LaLFoods.ENCHANTED_BEETROOT, LaLConsumables.ENCHANTED_BEETROOT)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
    );
    public static final Item ENCHANTED_BEETROOT_SOUP = register("enchanted_beetroot_soup",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.EPIC)
                    .food(LaLFoods.ENCHANTED_BEETROOT_SOUP, LaLConsumables.ENCHANTED_BEETROOT_SOUP)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
                    .usingConvertsTo(Items.BOWL)
    );

    // Artifacts
    public static final Item TOTEM_OF_VENGEANCE = register("totem_of_vengeance",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
                    .component(DataComponents.DEATH_PROTECTION, new DeathProtection(
                            List.of(
                                    new ClearAllStatusEffectsConsumeEffect(),
                                    new ApplyStatusEffectsConsumeEffect(
                                            List.of(
                                                    new MobEffectInstance(MobEffects.HEAL, 1, 255),
                                                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 1),
                                                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1),
                                                    new MobEffectInstance(MobEffects.WITHER, 6000, 0)
                                            )
                                    )
                            )
                    ))
    );
    public static final Item TOTEM_OF_TELEPORTATION = register("totem_of_teleporation",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .component(DataComponents.DEATH_PROTECTION, new DeathProtection(
                            List.of(
                                    new ClearAllStatusEffectsConsumeEffect(),
                                    new ApplyStatusEffectsConsumeEffect(
                                            List.of(
                                                    new MobEffectInstance(MobEffects.REGENERATION, 300, 1),
                                                    new MobEffectInstance(MobEffects.INVISIBILITY, 600, 0)
                                            )
                                    ),
                                    new TeleportRandomlyConsumeEffect()
                            )
                    ))
    );

    public static final LaLRecallTablet TABLET_OF_RECALL = register("tablet_of_recall",
            LaLRecallTablet::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_RECALL)
                    .useCooldown(300f)
    );
    public static final Item TABLET_OF_HASTE = register("tablet_of_haste",
            Item::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_HASTE)
                    .useCooldown(60f)
    );
    public static final Item TABLET_OF_LEVITATION = register("tablet_of_levitation",
            Item::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_LEVITATION)
                    .useCooldown(30f)
    );
    public static final Item TABLET_OF_CHANNELING = register("tablet_of_channeling",
            Item::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_CHANNELING)
                    .useCooldown(300f)
    );
    public static final Item TABLET_OF_DEAFENING = register("tablet_of_deafening",
            Item::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_DEAFENING)
                    .useCooldown(60f)
    );
    public static final Item TABLET_OF_REVEALING = register("tablet_of_revealing",
            Item::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_REVEALING)
                    .useCooldown(60f)
    );

    public static final Item AMULET_OF_ALLURE = register("amulet_of_allure",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .attributes(createAmuletOfAllureAttributes)
    );
    public static final Item AMULET_OF_SYNTHESIS = register("amulet_of_synthesis",
            Item::new,
            new Properties()
                    .stacksTo(1)
    );
    public static final Item AMULET_OF_EVASION = register("amulet_of_evasion",
            Item::new,
            new Properties()
                    .stacksTo(1)
    );

    public static final Item REINFORCED_CHESTPLATE = register("reinforced_chestplate",
            Item::new,
            new Properties()
                .stacksTo(1)
                .durability(731)
                .component(DataComponents.EQUIPPABLE, Equippable.builder(ArmorType.CHESTPLATE.getSlot()).setEquipSound(SoundEvents.ARMOR_EQUIP_DIAMOND).setAsset(LaLEquipmentAssets.REINFORCED).build())
                .attributes(createReinforcedChestplateAttributes)
    );
    public static final Item TRAVELLING_STRIDES = register("travelling_strides",
            Item::new,
            new Properties()
                .stacksTo(1)
                .durability(165)
                .component(DataComponents.EQUIPPABLE, Equippable.builder(ArmorType.LEGGINGS.getSlot()).setEquipSound(SoundEvents.ARMOR_EQUIP_LEATHER).setAsset(LaLEquipmentAssets.TRAVELLING).build())
                .attributes(createTravellingStridesAttributes)
    );
    public static final Item WANDERER_BOOTS = register("wanderer_boots",
            Item::new,
            new Properties()
                .stacksTo(1)
                .durability(386)
                .component(DataComponents.EQUIPPABLE, Equippable.builder(ArmorType.BOOTS.getSlot()).setEquipSound(SoundEvents.ARMOR_EQUIP_IRON).setAsset(LaLEquipmentAssets.WANDERER).build())
                .attributes(createWandererBootsAttributes)
    );

    public static void init() {
    }

    private static @NotNull <T extends Item> T register(String name, @NotNull Function<Properties, Item> function, Item.@NotNull Properties properties) {
        return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, LaLConstants.id(name)), function, properties);
    }

    public static Function<Properties, Item> createBlockItemWithCustomItemName(Block block) {
        return properties -> new BlockItem(block, properties.useItemDescriptionPrefix());
    }


    private static @org.jetbrains.annotations.NotNull <T extends Item> T registerSherd(String name, @org.jetbrains.annotations.NotNull Function<Properties, Item> function, Item.@org.jetbrains.annotations.NotNull Properties properties) {
        T item = (T) Items.registerItem(ResourceKey.create(Registries.ITEM, LaLConstants.id(name)), function, properties);
        SherdRegistry.register(item, LaLConstants.id(name.replace("sherd", "pattern")));
        return item;
    }
}
