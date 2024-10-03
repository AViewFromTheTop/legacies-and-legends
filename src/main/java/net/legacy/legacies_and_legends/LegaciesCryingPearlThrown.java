package net.legacy.legacies_and_legends;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class LegaciesCryingPearlThrown extends ThrowableItemProjectile {
    public LegaciesCryingPearlThrown(EntityType<? extends net.minecraft.world.entity.projectile.ThrownEnderpearl> entityType, Level level) {
        super(entityType, level);
    }

    public LegaciesCryingPearlThrown(Level level, LivingEntity shooter) {
        super(EntityType.ENDER_PEARL, shooter, level);
    }

    protected Item getDefaultItem() {
        return Items.ENDER_PEARL;
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        result.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), 0.0F);
    }

    protected void onHit(HitResult result) {
        super.onHit(result);

        for(int i = 0; i < 32; ++i) {
            this.level().addParticle(ParticleTypes.PORTAL, this.getX(), this.getY() + this.random.nextDouble() * 2.0, this.getZ(), this.random.nextGaussian(), 0.0, this.random.nextGaussian());
        }

        Level var3 = this.level();
        if (var3 instanceof ServerLevel serverLevel) {
            if (!this.isRemoved()) {
                Entity entity = this.getOwner();
                if (entity != null && isAllowedToTeleportOwner(entity, serverLevel)) {
                    if (entity.isPassenger()) {
                        entity.unRide();
                    }

                    if (entity instanceof ServerPlayer) {
                        ServerPlayer serverPlayer = (ServerPlayer)entity;
                        if (serverPlayer.connection.isAcceptingMessages()) {
                            if (this.random.nextFloat() <= 1.00F && serverLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
                                Endermite endermite = (Endermite)EntityType.ENDERMITE.create(serverLevel);
                                if (endermite != null) {
                                    endermite.moveTo(entity.getX(), entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
                                    serverLevel.addFreshEntity(endermite);
                                }
                            }

                            entity.changeDimension(new DimensionTransition(serverLevel, this.position(), entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), DimensionTransition.DO_NOTHING));
                            entity.resetFallDistance();
                            serverPlayer.resetCurrentImpulseContext();
                            entity.hurt(this.damageSources().fall(), 3.0F);
                            this.playSound(serverLevel, this.position());
                        }
                    } else {
                        entity.changeDimension(new DimensionTransition(serverLevel, this.position(), entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), DimensionTransition.DO_NOTHING));
                        entity.resetFallDistance();
                        this.playSound(serverLevel, this.position());
                    }

                    this.discard();
                    return;
                }

                this.discard();
                return;
            }
        }

    }

    private static boolean isAllowedToTeleportOwner(Entity entity, Level level) {
        if (entity.level().dimension() == level.dimension()) {
            if (!(entity instanceof LivingEntity)) {
                return entity.isAlive();
            } else {
                LivingEntity livingEntity = (LivingEntity)entity;
                return livingEntity.isAlive() && !livingEntity.isSleeping();
            }
        } else {
            return entity.canUsePortal(true);
        }
    }

    public void tick() {
        Entity entity = this.getOwner();
        if (entity instanceof ServerPlayer && !entity.isAlive() && this.level().getGameRules().getBoolean(GameRules.RULE_ENDER_PEARLS_VANISH_ON_DEATH)) {
            this.discard();
        } else {
            super.tick();
        }

    }

    private void playSound(Level level, Vec3 pos) {
        level.playSound((Player)null, pos.x, pos.y, pos.z, SoundEvents.PLAYER_TELEPORT, SoundSource.PLAYERS);
    }

    public boolean canChangeDimensions(Level oldLevel, Level newLevel) {
        if (oldLevel.dimension() == Level.END) {
            Entity var4 = this.getOwner();
            if (var4 instanceof ServerPlayer) {
                ServerPlayer serverPlayer = (ServerPlayer)var4;
                return super.canChangeDimensions(oldLevel, newLevel) && serverPlayer.seenCredits;
            }
        }

        return super.canChangeDimensions(oldLevel, newLevel);
    }

    protected void onInsideBlock(BlockState state) {
        super.onInsideBlock(state);
        if (state.is(Blocks.END_GATEWAY)) {
            Entity var3 = this.getOwner();
            if (var3 instanceof ServerPlayer) {
                ServerPlayer serverPlayer = (ServerPlayer)var3;
                serverPlayer.onInsideBlock(state);
            }
        }

    }
}
