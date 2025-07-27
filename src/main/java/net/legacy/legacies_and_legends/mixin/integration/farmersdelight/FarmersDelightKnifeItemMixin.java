package net.legacy.legacies_and_legends.mixin.integration.farmersdelight;

import net.legacy.legacies_and_legends.item.KnifeItem;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantable;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(KnifeItem.class)
public abstract class FarmersDelightKnifeItemMixin {


    @Inject(at = @At("HEAD"), method = "init")
    private void onKnifeKnockback(Level level, Entity entity, EquipmentSlot slot, CallbackInfo ci) {

    }
}