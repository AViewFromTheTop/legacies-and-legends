package net.legacy.legacies_and_legends.item;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
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

public class EvasionTrinketItem extends TrinketItem {

  public EvasionTrinketItem(Properties settings) {
    super(settings);
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