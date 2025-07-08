package net.legacy.legacies_and_legends.item;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.*;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class AccessoryItem extends TrinketItem {

  public AccessoryItem(Properties settings) {
    super(settings);
  }
  public static final ResourceLocation TEMPT_RANGE_ID = LaLConstants.id("tempt_range");

  public Multimap<Holder<Attribute>, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, ResourceLocation resourceLocation) {
    var modifiers = super.getModifiers(stack, slot, entity, resourceLocation);
    if (stack.getItem() == LaLItems.AMULET_OF_ALLURE) {
      modifiers.put(Attributes.TEMPT_RANGE, new AttributeModifier(TEMPT_RANGE_ID, 10, AttributeModifier.Operation.ADD_VALUE));
    }
    return modifiers;
  }

  @Override
  public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
    if (entity instanceof LivingEntity livingEntity && TrinketsApi.getTrinketComponent(livingEntity).isPresent()) {
      if (TrinketsApi.getTrinketComponent(livingEntity).get().isEquipped(LaLItems.AMULET_OF_EVASION)) {
        if (!livingEntity.hasEffect(MobEffects.INVISIBILITY)) livingEntity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, MobEffectInstance.INFINITE_DURATION));
        if (!livingEntity.hasEffect(MobEffects.WEAKNESS)) livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, MobEffectInstance.INFINITE_DURATION));
        if (!livingEntity.hasEffect(MobEffects.DARKNESS)) livingEntity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, MobEffectInstance.INFINITE_DURATION));
      }
    }
  }

}