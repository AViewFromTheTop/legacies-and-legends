package net.legacy.legacies_and_legends.mixin;

import net.legacy.legacies_and_legends.enchantment.LaLMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.PowderSnowBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Predicate;

@Mixin(PowderSnowBlock.class)
public class PowderSnowBlockMixin {
    @Unique
    boolean wasFrozen = false;

    @Inject(method = "entityInside", at = @At(value = "TAIL"))
    private void frozenInPowderSnow(BlockState state, Level level, BlockPos pos, Entity entity, CallbackInfo ci) {
        if (entity instanceof LivingEntity livingEntity && entity.isInPowderSnow && entity.canFreeze()) {
            livingEntity.addEffect(new MobEffectInstance(LaLMobEffects.FREEZING));
            this.wasFrozen = true;
        }
        else if (entity instanceof LivingEntity livingEntity && this.wasFrozen && !entity.isFreezing()){
            livingEntity.removeEffect(LaLMobEffects.FREEZING);
        }
    }
}
