package net.legacy.legacies_and_legends.equipment;

import net.legacy.legacies_and_legends.registry.LaLToolMaterial;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

public class CleavingBattleAxeItem extends AxeItem {

    public CleavingBattleAxeItem(Properties properties) {
        super(LaLToolMaterial.CLEAVING, -3F, 10F, properties);
    }

    @Override
    public void postHurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, LivingEntity attacker) {
        target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0), attacker);
    }

}