package com.fecfs.heroes.item.custom;

import com.fecfs.heroes.block.FecfsBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class ExplosiveGelItem extends Item {
    public ExplosiveGelItem(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos = context.getBlockPos();
        Block block = context.getWorld().getBlockState(blockPos).getBlock();
        if (!context.getWorld().isClient()) {
            context.getWorld().setBlockState(blockPos, FecfsBlocks.EXPLOSIVE_GEL_BLOCK.getDefaultState());
        }
        return super.useOnBlock(context);
    }
    private void setTargetBlocks(BlockPos pos, PlayerEntity player, Block block) {

    }
}