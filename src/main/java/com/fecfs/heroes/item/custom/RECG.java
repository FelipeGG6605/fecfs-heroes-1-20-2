package com.fecfs.heroes.item.custom;

import com.fecfs.heroes.entity.custom.BatarangEntity;
import com.fecfs.heroes.entity.custom.RECGEntity;
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
        if (!world.isClient()) {
            RECGEntity recgEntity = new RECGEntity(world, user);
            recgEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0F, 0.3F, 1F);
            world.spawnEntity(recgEntity);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
