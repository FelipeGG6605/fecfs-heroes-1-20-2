package com.fecfs.heroes.item.custom;

import com.fecfs.heroes.entity.custom.BatarangEntity;
import com.fecfs.heroes.sound.FecfsSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class  BatarangItem extends Item {
    public BatarangItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        world.playSound(null, user.getX(), user.getY(), user.getZ(), FecfsSounds.BatarangThrown,
                SoundCategory.HOSTILE, 1f, 1f);

        user.getItemCooldownManager().set(this, 15);

        if (!world.isClient()) {
            BatarangEntity batarangEntity = new BatarangEntity(world, user);
            batarangEntity.setItem(itemStack);
            batarangEntity.setVelocity(user, user.getPitch(), user.getYaw(), 1.0F, 2F, 0.5F);
            world.spawnEntity(batarangEntity);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}