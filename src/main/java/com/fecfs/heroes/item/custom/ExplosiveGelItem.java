package com.fecfs.heroes.item.custom;

import com.fecfs.heroes.block.FecfsBlocks;
import com.fecfs.heroes.sound.FecfsSounds;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class ExplosiveGelItem extends Item {
    public ExplosiveGelItem(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        int i = -1;
        BlockPos blockPos = context.getBlockPos().offset(context.getHorizontalPlayerFacing(), i);
        Block block = context.getWorld().getBlockState(blockPos).getBlock();
        context.getPlayer().getItemCooldownManager().set(this, 15);
        if (!context.getWorld().isClient()) {
            context.getWorld().setBlockState(blockPos, FecfsBlocks.EXPLOSIVE_GEL_BLOCK.getDefaultState());
            context.getWorld().playSound(null, context.getPlayer().getX(), context.getPlayer().getY(),
                    context.getPlayer().getZ(), FecfsSounds.ExplosiveGelPlaced, SoundCategory.BLOCKS, 1f, 1f);
        }
        return super.useOnBlock(context);
    }
}