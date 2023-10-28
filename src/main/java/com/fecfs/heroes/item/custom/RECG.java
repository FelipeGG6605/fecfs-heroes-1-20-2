package com.fecfs.heroes.item.custom;

import com.fecfs.heroes.sound.FecfsSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RECG extends Item {
    public RECG(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), FecfsSounds.RemoteElectricalChargeGunShot,
                SoundCategory.HOSTILE, 1f, 1f);
        user.getItemCooldownManager().set(this, 30);
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
