package com.fecfs.heroes.item.custom;

import com.fecfs.heroes.entity.custom.SmokePelletEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SmokePelletItem extends Item {
    public SmokePelletItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        //user.getItemCooldownManager().set(this, 200);
        if(!world.isClient) {
            SmokePelletEntity smokePelletEntity = new SmokePelletEntity(user, world);
            smokePelletEntity.setItem(itemStack);
            smokePelletEntity.setVelocity(user, user.getPitch(), user.getYaw(), 1.0f, 0.75f, 2f);
            world.spawnEntity(smokePelletEntity);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
