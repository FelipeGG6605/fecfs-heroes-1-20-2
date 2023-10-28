package com.fecfs.heroes.networking.packets;

import com.fecfs.heroes.block.FecfsBlocks;
import com.fecfs.heroes.item.FecfsItems;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UseGadgetKeybindC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                                     PacketByteBuf buf, PacketSender responseSender) {
        Hand hand = player.getActiveHand();
        ItemStack itemStack = player.getStackInHand(hand);
        ServerWorld world = (ServerWorld) player.getWorld();
        for(BlockPos pos:BlockPos.iterateOutwards(player.getBlockPos(), 7, 7, 7)) {
            if (world.getBlockState(pos).isOf(FecfsBlocks.EXPLOSIVEGELBLOCK)) {
                if (itemStack.getItem().equals(FecfsItems.EXPLOSIVE_GEL)) {
                    for (int i = 1; i <= 10; i++) {
                        Block block = world.getBlockState(pos).getBlock();
                        if (block.equals(FecfsBlocks.EXPLOSIVEGELBLOCK)) {
                            world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 2f,
                                    World.ExplosionSourceType.BLOCK);
                            world.removeBlock(pos, false);
                        }
                    }
                }
            }
        }
    }
    private static boolean isGetGelBlockRadius(ServerPlayerEntity player, ServerWorld world, int size ) {
        return BlockPos.stream(player.getBoundingBox().expand(size))
                .map(player.getWorld()::getBlockState).filter(blockState ->
                        blockState.isOf(FecfsBlocks.EXPLOSIVEGELBLOCK)).toArray().length > 0;
    }
}
