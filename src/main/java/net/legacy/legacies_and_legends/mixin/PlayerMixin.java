package net.legacy.legacies_and_legends.mixin;

import dev.emi.trinkets.TrinketSlot;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.SlotType;
import dev.emi.trinkets.api.TrinketInventory;
import dev.emi.trinkets.api.TrinketsApi;
import net.legacy.legacies_and_legends.entity.impl.LaLPlayerPlatformInterface;
import net.legacy.legacies_and_legends.item.impl.TotemUtil;
import net.legacy.legacies_and_legends.registry.LaLBlocks;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.particle.TotemParticle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.DeathProtection;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Mixin(Player.class)
public abstract class PlayerMixin implements LaLPlayerPlatformInterface {

    @Shadow public abstract Inventory getInventory();

    @Unique
    private Optional<GlobalPos> lastPlatformPos = Optional.empty();

    @Inject(method = "actuallyHurt", at = @At(value = "TAIL"))
    private void cancelTabletUse(ServerLevel level, DamageSource damageSource, float amount, CallbackInfo info) {
        Player player = Player.class.cast(this);
        if (player.getUseItem().is(LaLItemTags.TABLETS)) player.stopUsingItem();
    }

    @Inject(method = "actuallyHurt", at = @At(value = "TAIL"))
    private void activateTotem(ServerLevel level, DamageSource damageSource, float amount, CallbackInfo info) {
        Player player = Player.class.cast(this);
        if (TrinketsApi.getTrinketComponent(player).isPresent()) {
            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.TOTEM_OF_TELEPORTATION) && amount >= player.getHealth()) {
                player.setHealth(1.0F);
                LaLItems.TOTEM_OF_TELEPORTATION.getDefaultInstance().get(DataComponents.DEATH_PROTECTION).applyEffects(LaLItems.TOTEM_OF_TELEPORTATION.getDefaultInstance(), player);
                TotemUtil.playTeleportationTotemAnimation(player);
                player.addTag("used_totem");
            }
            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.TOTEM_OF_VENGEANCE) && amount >= player.getHealth()) {
                player.setHealth(1.0F);
                LaLItems.TOTEM_OF_VENGEANCE.getDefaultInstance().get(DataComponents.DEATH_PROTECTION).applyEffects(LaLItems.TOTEM_OF_VENGEANCE.getDefaultInstance(), player);
                TotemUtil.playVengeanceTotemAnimation(player);
                player.addTag("used_totem");
            }
            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(Items.TOTEM_OF_UNDYING) && amount >= player.getHealth()) {
                player.setHealth(1.0F);
                Items.TOTEM_OF_UNDYING.getDefaultInstance().get(DataComponents.DEATH_PROTECTION).applyEffects(Items.TOTEM_OF_UNDYING.getDefaultInstance(), player);
                TotemUtil.playUndyingTotemAnimation(player);
                player.addTag("used_totem");
            }
        }
    }

    @Inject(method = "killedEntity", at = @At(value = "TAIL"))
    private void killedEntityEffects(ServerLevel level, LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        Player player = (Player) level.players();
        if (TrinketsApi.getTrinketComponent(player).isPresent()) {
            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.AMULET_OF_SYNTHESIS))
                player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 4));
        }
    }

    @Inject(method = "die", at = @At("HEAD"))
    public void destroyPlatformOnDeath(DamageSource damageSource, CallbackInfo info) {
        if (this.lastPlatformPos.isEmpty()) return;

        Player player = Player.class.cast(this);
        GlobalPos globalPos = this.lastPlatformPos.get();
        if (!globalPos.dimension().equals(player.level().dimension())) return;

        BlockPos pos = globalPos.pos();
        player.level().scheduleTick(pos, LaLBlocks.WAND_PLATFORM, 5);

        player.removeTag("legacies_and_legends:wand_platform_summoned");
    }

    @Inject(method = "drop", at = @At("HEAD"))
    public void destroyPlatformOnDrop(ItemStack itemStack, boolean includeThrowerName, CallbackInfoReturnable<ItemEntity> cir) {
        if (this.lastPlatformPos.isEmpty() || this.getInventory().contains(LaLItems.WAND.getDefaultInstance())) return;

        Player player = Player.class.cast(this);
        GlobalPos globalPos = this.lastPlatformPos.get();
        if (!globalPos.dimension().equals(player.level().dimension())) return;

        BlockPos pos = globalPos.pos();
        player.level().scheduleTick(pos, LaLBlocks.WAND_PLATFORM, 5);

        player.removeTag("legacies_and_legends:wand_platform_summoned");
    }

    @Override
    public void lal$setLastPlatformPos(@NotNull Level level, BlockPos pos) {
        this.lastPlatformPos = Optional.of(GlobalPos.of(level.dimension(), pos));
    }

    @Override
    public void lal$eraseLastPlatformPos() {
        this.lastPlatformPos = Optional.empty();
    }

    @Override
    public Optional<GlobalPos> lal$getLastPlatformPos() {
        return this.lastPlatformPos;
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    public void readPlatformSaveData(CompoundTag tag, CallbackInfo info) {
        this.lastPlatformPos = tag.read("LalLastPlatformPos", GlobalPos.CODEC);
    }

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    public void addAdditionalSaveData(CompoundTag tag, CallbackInfo info) {
        this.lastPlatformPos.ifPresent(pos -> tag.store("LalLastPlatformPos", GlobalPos.CODEC, pos));
    }
}
