package net.legacy.legacies_and_legends.entity;

import net.legacy.legacies_and_legends.equipment.BoomerangItem;
import net.legacy.legacies_and_legends.registry.LaLEntityTypes;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BoomerangProjectile extends AbstractArrow {
    private static final EntityDataAccessor<Boolean> WOBBLING = SynchedEntityData.defineId(BoomerangProjectile.class, EntityDataSerializers.BOOLEAN);
    private static final float WATER_INERTIA = 0.1F;
    private static final float ROTATION_AMOUNT = 55F;

    private boolean dealtDamage;
    public int loopTick = 3;
    public float spinTick = 0;

    public float prevWobbleProgress;
    public float wobbleProgress;
    public float prevYaw;
    public float yaw;
    private float lookRot;

    public BoomerangProjectile(EntityType<? extends BoomerangProjectile> entityEntityType, Level level) {
        super(entityEntityType, level);
    }

    public BoomerangProjectile(Level level, LivingEntity shooter, ItemStack pickupItemStack) {
        super(LaLEntityTypes.BOOMERANG, shooter, level, pickupItemStack, null);
    }

    public BoomerangProjectile(Level level, double x, double y, double z, ItemStack pickupItemStack) {
        super(LaLEntityTypes.BOOMERANG, x, y, z, level, pickupItemStack, pickupItemStack);
    }

    @Override
    public void shoot(double x, double y, double z, float speed, float divergence) {
        super.shoot(x, y * 0.5D, z, speed * 0.8F, divergence * 0.5F);
    }

    @Override
    protected double getDefaultGravity() {
        if (this.isInWater()){
            return 0.02D;
        }
        else if (this.wasTouchingWater || this.isInWaterOrRain()){
            return 0.015D;
        }
        else {
            return 0.01D;
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(WOBBLING, false);
    }

    @Override
    public void tick() {
        if (this.inGroundTime <= 0) {
            if (!this.isInWater()){
                this.spinTick = this.spinTick + 1;
            }
            this.loopTick = this.loopTick + 1;
            if (this.loopTick >= 4){
                this.playSound(LaLSounds.BOOMERANG_WOOSH);
                this.loopTick = 0;
            }
        }

        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }

        super.tick();
        Vec3 deltaPos = this.getDeltaPos();
        this.setAngles(deltaPos);
    }

    public void setAngles(@NotNull Vec3 deltaPos) {
        if (deltaPos.horizontalDistance() > 0.01D) {
            this.lookRot = -((float) Mth.atan2(deltaPos.x, deltaPos.z)) * Mth.RAD_TO_DEG;
        }
        float yRot = this.getYRot();
        this.setYRot(yRot + ((this.lookRot - yRot) * 0.25F));

        this.prevYaw = this.yaw;
        this.yaw -= (float) (deltaPos.length() * 2F * ROTATION_AMOUNT);

        if (this.yaw > 360F) {
            this.yaw -= 360F;
            this.prevYaw -= 360F;
        } else if (this.yaw < 0F) {
            this.yaw += 360F;
            this.prevYaw += 360F;
        }
    }

    @NotNull
    public Vec3 getDeltaPos() {
        return this.getPosition(1).subtract(this.getPosition(0));
    }

    public boolean isWobbling() {
        return this.entityData.get(WOBBLING);
    }

    public void setWobbling(boolean wobbling) {
        this.entityData.set(WOBBLING, wobbling);
    }

    public float getWobbleProgress(float partialTick) {
        return Mth.lerp(partialTick, this.prevWobbleProgress, this.wobbleProgress);
    }

    public float getSpinTick() {
        return this.spinTick;
    }

    public float getBoomerangYaw(float partialTick) {
        return Mth.lerp(partialTick, this.prevYaw, this.yaw);
    }

    @Nullable
    @Override
    protected EntityHitResult findHitEntity(Vec3 startVec, Vec3 endVec) {
        return this.dealtDamage ? null : super.findHitEntity(startVec, endVec);
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult result) {
        Entity entity = result.getEntity();
        float f = BoomerangItem.THROW_DAMAGE;
        Entity entity2 = this.getOwner();
        DamageSource damageSource = this.damageSources().trident(this, (Entity)(entity2 == null ? this : entity2));
        if (this.level() instanceof ServerLevel serverLevel) {
            f = EnchantmentHelper.modifyDamage(serverLevel, this.getWeaponItem(), entity, damageSource, f);
        }

        this.dealtDamage = true;
        if (entity.hurtOrSimulate(damageSource, f)) {
            if (entity.getType() == EntityType.ENDERMAN) return;

            if (this.level() instanceof ServerLevel serverLevel) {
                EnchantmentHelper.doPostAttackEffectsWithItemSourceOnBreak(serverLevel, entity, damageSource, this.getWeaponItem(), item -> this.kill(serverLevel));
            }

            if (entity instanceof LivingEntity livingEntity) {
                this.doKnockback(livingEntity, damageSource);
                this.doPostHurtEffects(livingEntity);
            }
        }

        this.deflect(ProjectileDeflection.REVERSE, entity, this.getOwner(), false);
        this.setDeltaMovement(this.getDeltaMovement().multiply(0.02D, 0.2D, 0.02D));
        this.playSound(LaLSounds.BOOMERANG_HIT, 1F, 1F);

    }

    @Override
    protected void hitBlockEnchantmentEffects(ServerLevel level, @NotNull BlockHitResult hitResult, ItemStack stack) {
        Vec3 vec3 = hitResult.getBlockPos().clampLocationWithin(hitResult.getLocation());
        EnchantmentHelper.onHitBlock(
                level,
                stack,
                this.getOwner() instanceof LivingEntity livingEntity ? livingEntity : null,
                this,
                null,
                vec3,
                level.getBlockState(hitResult.getBlockPos()),
                item -> this.kill(level)
        );
    }

    @Override
    public @NotNull ItemStack getWeaponItem() {
        return this.getPickupItemStackOrigin();
    }

    @Override
    protected boolean tryPickup(Player player) {
        return super.tryPickup(player) || this.isNoPhysics() && this.ownedBy(player) && player.getInventory().add(this.getPickupItem());
    }

    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return new ItemStack(LaLItems.BOOMERANG);
    }

    @Override
    protected @NotNull SoundEvent getDefaultHitGroundSoundEvent() {
        return LaLSounds.BOOMERANG_HIT;
    }

    @Override
    public void playerTouch(Player player) {
        if (this.ownedBy(player) || this.getOwner() == null) {
            super.playerTouch(player);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.dealtDamage = tag.getBoolean("DealtDamage");
        this.setWobbling(tag.getBoolean("Wobbling"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("DealtDamage", this.dealtDamage);
        tag.putBoolean("Wobbling", this.isWobbling());
    }

    @Override
    public void tickDespawn() {
        if (this.pickup != AbstractArrow.Pickup.ALLOWED) {
            super.tickDespawn();
        }
    }

    @Override
    protected float getWaterInertia() {
        return WATER_INERTIA;
    }

    @Override
    public boolean shouldRender(double x, double y, double z) {
        return true;
    }
}