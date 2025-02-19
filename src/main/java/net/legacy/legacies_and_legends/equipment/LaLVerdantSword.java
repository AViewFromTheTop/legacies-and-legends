package net.legacy.legacies_and_legends.equipment;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ToolMaterial;

public class LaLVerdantSword extends SwordItem {

    public LaLVerdantSword(ToolMaterial material, float attackDamage, float attackSpeed, Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }

    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0), attacker);
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

}
