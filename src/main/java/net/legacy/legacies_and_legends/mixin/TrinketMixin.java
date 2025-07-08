package net.legacy.legacies_and_legends.mixin;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketsApi;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.function.Consumer;

@Mixin(Trinket.class)
public interface TrinketMixin {

    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(ItemStack stack, SlotReference slot, LivingEntity livingEntity, CallbackInfo ci) {
        if (livingEntity instanceof Player player && TrinketsApi.getTrinketComponent(livingEntity).isPresent()) {
            if ((TrinketsApi.getTrinketComponent(livingEntity).get().isEquipped(LaLItems.TOTEM_OF_TELEPORTATION) || TrinketsApi.getTrinketComponent(livingEntity).get().isEquipped(LaLItems.TOTEM_OF_VENGEANCE) || TrinketsApi.getTrinketComponent(livingEntity).get().isEquipped(Items.TOTEM_OF_UNDYING)) && player.getTags().contains("used_totem")) {
                player.removeTag("used_totem");
                slot.inventory().removeItem(slot.index(), 1);
            }
            if (TrinketsApi.getTrinketComponent(livingEntity).get().isEquipped(LaLItems.AMULET_OF_EVASION)) {
                if (!player.hasEffect(MobEffects.INVISIBILITY)) player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, MobEffectInstance.INFINITE_DURATION));
                if (!player.hasEffect(MobEffects.WEAKNESS)) player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, MobEffectInstance.INFINITE_DURATION));
                if (!player.hasEffect(MobEffects.DARKNESS)) player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, MobEffectInstance.INFINITE_DURATION));
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "onEquip")
    private void addOnEquip(ItemStack stack, SlotReference slot, LivingEntity livingEntity, CallbackInfo ci) {
        if (livingEntity instanceof Player player && stack.is(LaLItemTags.ACCESSORIES)) {
            if (stack.is(LaLItems.AMULET_OF_ALLURE)) {
                player.addTag("equipped_amulet_of_allure");
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "onUnequip")
    private void removeOnUnequip(ItemStack stack, SlotReference slot, LivingEntity livingEntity, CallbackInfo ci) {
        if (livingEntity instanceof Player player && stack.is(LaLItemTags.ACCESSORIES)) {
            if (stack.is(LaLItems.AMULET_OF_ALLURE)) {
                player.removeTag("equipped_amulet_of_allure");
            }
            else if (stack.is(LaLItems.AMULET_OF_EVASION)) {
                if (player.getEffect(MobEffects.INVISIBILITY).getDuration() == MobEffectInstance.INFINITE_DURATION) player.removeEffect(MobEffects.INVISIBILITY);
                if (player.getEffect(MobEffects.WEAKNESS).getDuration() == MobEffectInstance.INFINITE_DURATION) player.removeEffect(MobEffects.WEAKNESS);
                if (player.getEffect(MobEffects.DARKNESS).getDuration() == MobEffectInstance.INFINITE_DURATION) player.removeEffect(MobEffects.DARKNESS);
            }
        }
    }
}