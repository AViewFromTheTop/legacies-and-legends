package net.legacy.legacies_and_legends.equipment;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class VerdantSwordItem extends Item {

    public VerdantSwordItem(Properties properties) {
        super(properties);
    }

    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0), attacker);
    }

}
