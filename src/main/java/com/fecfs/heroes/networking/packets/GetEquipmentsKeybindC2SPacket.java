package com.fecfs.heroes.networking.packets;

import com.fecfs.heroes.item.FecfsItems;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;

public class GetEquipmentsKeybindC2SPacket {


    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        Hand hand = player.getActiveHand();
        ItemStack itemStack = player.getStackInHand(hand);
        ServerWorld world = (ServerWorld) player.getWorld();
        boolean isWearingBatmanArmor = player.getInventory().getArmorStack(0).isOf(FecfsItems.TB_2022_BOOTS) &&
                player.getInventory().getArmorStack(1).isOf(FecfsItems.TB_2022_LEGGINGS) &&
                player.getInventory().getArmorStack(2).isOf(FecfsItems.TB_2022_CHESTPLATE) &&
                player.getInventory().getArmorStack(3).isOf(FecfsItems.TB_2022_HELMET);

        if(isWearingBatmanArmor &&
        !player.getInventory().contains(FecfsItems.BATARANG_ITEM.getDefaultStack()) &&
        !player.getInventory().contains(FecfsItems.SMOKE_PELLET.getDefaultStack()) &&
        !player.getInventory().contains(FecfsItems.EXPLOSIVE_GEL.getDefaultStack()) &&
        !player.getInventory().contains(FecfsItems.REMOTE_ELECTRICAL_CHARGE_GUN.getDefaultStack()))  {
            player.giveItemStack(FecfsItems.EXPLOSIVE_GEL.getDefaultStack());
            player.giveItemStack(FecfsItems.BATARANG_ITEM.getDefaultStack());
            player.giveItemStack(FecfsItems.SMOKE_PELLET.getDefaultStack());
            player.giveItemStack(FecfsItems.REMOTE_ELECTRICAL_CHARGE_GUN.getDefaultStack());

        }
    }
}
