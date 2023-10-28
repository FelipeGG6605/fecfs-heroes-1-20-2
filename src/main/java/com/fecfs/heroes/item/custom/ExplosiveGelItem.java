package com.fecfs.heroes.item.custom;

import com.fecfs.heroes.block.FecfsBlocks;
import com.fecfs.heroes.block.custom.ExplosiveGelBlock;
import com.fecfs.heroes.particle.FecfsParticles;
import com.fecfs.heroes.sound.FecfsSounds;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class ExplosiveGelItem extends Item {
    public ExplosiveGelItem(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        int i = -1;
        BlockPos blockPos = context.getBlockPos().offset(context.getHorizontalPlayerFacing(), i);
        Block block = context.getWorld().getBlockState(blockPos).getBlock();
        context.getPlayer().getItemCooldownManager().set(this, 20);
        if (!context.getWorld().isClient()) {
            spawnPlacingParticles(context);
            context.getWorld().setBlockState(blockPos, FecfsBlocks.EXPLOSIVEGELBLOCK.getDefaultState()
                    .with(ExplosiveGelBlock.FACING, context.getHorizontalPlayerFacing()));
            context.getWorld().playSound(null, context.getPlayer().getX(), context.getPlayer().getY(),
                    context.getPlayer().getZ(), FecfsSounds.ExplosiveGelPlaced, SoundCategory.BLOCKS, 1f, 1f);
        }
        return TypedActionResult.success(context, context.getWorld().isClient()).getResult();
    }

    private void spawnPlacingParticles(ItemUsageContext context) {
        int p = 7;
        BlockPos blockPos = context.getBlockPos();
        for(int i = 0; i < 60; i++) {
            ServerWorld world = ((ServerWorld) context.getWorld());
            var vect = context.getHorizontalPlayerFacing().getVector();
            world.addParticle(ParticleTypes.GLOW_SQUID_INK,
                    blockPos.getX() + 0.5 + vect.getX() * 0.5, blockPos.getY() + 0.5 + vect.getY() *0.5,
                    blockPos.getZ() + 1.5 + vect.getZ() * 0.5, 0.1,
                    0.1d, 0.1d);
        }
    }
}