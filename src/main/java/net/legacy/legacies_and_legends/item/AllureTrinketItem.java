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

public class AllureTrinketItem extends TrinketItem {

  public AllureTrinketItem(Properties settings) {
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
}