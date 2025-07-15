package net.legacy.legacies_and_legends.item.accessory;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.item.AccessoryItem;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class EvasionRingItem extends AccessoryItem {

    public EvasionRingItem(Properties settings) {
        super(settings);
    }

    @Override
    public void everyTick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof Player player && TrinketsApi.getTrinketComponent(player).isPresent()) {
            if (player.isShiftKeyDown() && !player.hasEffect(MobEffects.INVISIBILITY)) {
                player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, MobEffectInstance.INFINITE_DURATION));
                player.addTag("infinite_invisibility");
                player.addTag("evasion_crouching");
            }
            else if (!player.isShiftKeyDown() && player.getTags().contains("infinite_invisibility")) {
                player.removeEffect(MobEffects.INVISIBILITY);
                player.removeTag("infinite_invisibility");
                player.removeTag("evasion_crouching");
            }
        }
    }

    @Override
    public void resetData(LivingEntity entity) {
        if (entity instanceof Player player) {
            player.removeTag("infinite_invisibility");
            player.removeTag("evasion_crouching");
        }
    }

    @Override
    public void everySecond(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof Player player) {
            if (player.isShiftKeyDown() && new Random().nextInt(10) >= 9 && (player.getTags().contains("infinite_invisibility"))) {
                if (getAccessory(stack, slot, player).is(LaLItems.RING_OF_EVASION)) {
                    damageAccessory(stack, slot, player, 1);
                }
            }
        }
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, ResourceLocation resourceLocation) {
        var modifiers = super.getModifiers(stack, slot, entity, resourceLocation);

        if (entity instanceof Player player && player.getTags().contains("evasion_crouching")) {
            modifiers.put(Attributes.SNEAKING_SPEED, new AttributeModifier(LaLConstants.id("sneaking_speed"), 0.7, AttributeModifier.Operation.ADD_VALUE));
        }
        return modifiers;
    }
}
