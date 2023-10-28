package com.fecfs.heroes.entity.custom;

import com.fecfs.heroes.entity.FecfsEntities;
import com.fecfs.heroes.particle.FecfsParticles;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SmokePelletEntity extends ThrownItemEntity {
    public SmokePelletEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    public SmokePelletEntity(LivingEntity livingEntity, World world) {
        super(FecfsEntities.SmokePelletEntityType, livingEntity, world);
    }
    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }
    @Override
    protected Item getDefaultItem() {
        return null;
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if(!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            BlockPos pos = this.getBlockPos();
            spawnSmoke(blockHitResult);
        }
        this.discard();
        super.onBlockHit(blockHitResult);
    }

    private void spawnSmoke(BlockHitResult blockHitResult) {
        ServerWorld world = ((ServerWorld) this.getWorld());
        BlockPos blockPos = blockHitResult.getBlockPos();
        for(int i = 0; i < 60; i++) {
            world.spawnParticles(FecfsParticles.SMOKE_PARTICLE,
                    blockPos.getX(), blockPos.getY() + 1.5d, blockPos.getZ(), 20,
                    1d, 1d, 1d, 0);
        }
    }
}
