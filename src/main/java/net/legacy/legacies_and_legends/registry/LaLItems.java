package net.legacy.legacies_and_legends.registry;

import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.frozenblock.lib.item.api.sherd.SherdRegistry;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.equipment.LaLRecallTablet;
import net.legacy.legacies_and_legends.food.LaLFoods;
import net.legacy.legacies_and_legends.sound.LaLJukeboxSongs;
import net.legacy.legacies_and_legends.food.LaLConsumables;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.DeathProtection;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ClearAllStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.TeleportRandomlyConsumeEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item.Properties;

import java.util.List;
import java.util.function.Function;

public final class LaLItems {

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

    public static final Item AMULET_OF_ALLURE = register("amulet_of_allure",
            Item::new,
            new Properties()
                    .stacksTo(1)
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
