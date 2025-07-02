package net.legacy.legacies_and_legends.mixin;

import net.legacy.legacies_and_legends.registry.LaLMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.PowderSnowBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PowderSnowBlock.class)
public class PowderSnowBlockMixin {

    @Inject(method = "entityInside", at = @At(value = "TAIL"))
    private void frozenInPowderSnow(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, CallbackInfo info) {
        if (entity instanceof LivingEntity livingEntity && entity.isInPowderSnow && entity.canFreeze()) {
            livingEntity.addEffect(new MobEffectInstance(LaLMobEffects.FREEZING));
        } else if (entity instanceof LivingEntity livingEntity && entity.wasInPowderSnow && !entity.isFreezing()) {
            livingEntity.removeEffect(LaLMobEffects.FREEZING);
        }
    }
}
