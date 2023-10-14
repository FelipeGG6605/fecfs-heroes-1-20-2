package com.fecfs.heroes.entity.custom;

import com.fecfs.heroes.effect.FecfsEffects;
import com.fecfs.heroes.entity.FecfsEntities;
import com.fecfs.heroes.item.FecfsItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class BatarangEntity extends ThrownItemEntity {
    public BatarangEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    public BatarangEntity(World world, LivingEntity owner) {
        super(FecfsEntities.BatarangEntityType, owner, world);
    }
    public BatarangEntity(World world, double x, double y, double z) {
        super(FecfsEntities.BatarangEntityType, x, y, z, world);
    }
    @Override
    protected Item getDefaultItem() {
        return FecfsItems.BATARANG_ITEM;
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        int i =  2;
        entity.damage(getDamageSources().mobProjectile((Entity) this, (LivingEntity) this.getOwner()), (float)i);

        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addStatusEffect((new StatusEffectInstance(FecfsEffects.STAGGERED, 15, 1)));
        }
    }
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            if (getBlockStateAtPos().isOf(Blocks.GLASS) || getBlockStateAtPos().isOf(Blocks.GLASS_PANE) ||
                    getBlockStateAtPos().isOf(Blocks.GRAY_STAINED_GLASS) || getBlockStateAtPos().isOf(Blocks.GRAY_STAINED_GLASS_PANE) ||
                    getBlockStateAtPos().isOf(Blocks.BLACK_STAINED_GLASS) || getBlockStateAtPos().isOf(Blocks.BLACK_STAINED_GLASS_PANE) ||
                    getBlockStateAtPos().isOf(Blocks.GREEN_STAINED_GLASS) || getBlockStateAtPos().isOf(Blocks.GREEN_STAINED_GLASS_PANE) ||
                    getBlockStateAtPos().isOf(Blocks.BLUE_STAINED_GLASS) || getBlockStateAtPos().isOf(Blocks.BLUE_STAINED_GLASS_PANE) ||
                    getBlockStateAtPos().isOf(Blocks.CYAN_STAINED_GLASS) || getBlockStateAtPos().isOf(Blocks.CYAN_STAINED_GLASS_PANE) ||
                    getBlockStateAtPos().isOf(Blocks.RED_STAINED_GLASS) || getBlockStateAtPos().isOf(Blocks.RED_STAINED_GLASS_PANE) ||
                    getBlockStateAtPos().isOf(Blocks.LIGHT_BLUE_STAINED_GLASS) || getBlockStateAtPos().isOf(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE) ||
                    getBlockStateAtPos().isOf(Blocks.LIGHT_GRAY_STAINED_GLASS) || getBlockStateAtPos().isOf(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE) ||
                    getBlockStateAtPos().isOf(Blocks.LIME_STAINED_GLASS) || getBlockStateAtPos().isOf(Blocks.LIME_STAINED_GLASS_PANE) ||
                    getBlockStateAtPos().isOf(Blocks.MAGENTA_STAINED_GLASS) || getBlockStateAtPos().isOf(Blocks.MAGENTA_STAINED_GLASS_PANE) ||
                    getBlockStateAtPos().isOf(Blocks.ORANGE_STAINED_GLASS) || getBlockStateAtPos().isOf(Blocks.ORANGE_STAINED_GLASS_PANE) ||
                    getBlockStateAtPos().isOf(Blocks.PINK_STAINED_GLASS) || getBlockStateAtPos().isOf(Blocks.PINK_STAINED_GLASS_PANE) ||
                    getBlockStateAtPos().isOf(Blocks.PURPLE_STAINED_GLASS) || getBlockStateAtPos().isOf(Blocks.PURPLE_STAINED_GLASS_PANE) ||
                    getBlockStateAtPos().isOf(Blocks.WHITE_STAINED_GLASS) || getBlockStateAtPos().isOf(Blocks.WHITE_STAINED_GLASS_PANE) ||
                    getBlockStateAtPos().isOf(Blocks.YELLOW_STAINED_GLASS) || getBlockStateAtPos().isOf(Blocks.YELLOW_STAINED_GLASS_PANE) ||
                    getBlockStateAtPos().isOf(Blocks.TINTED_GLASS)) {
                this.getWorld().breakBlock(getBlockPos(), false);
                this.kill();
            }
        }else{
            this.kill();
        }

    }
}