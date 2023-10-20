package com.fecfs.heroes;

import com.fecfs.heroes.block.FecfsBlocks;
import com.fecfs.heroes.block.entity.FecfsBlockEntities;
import com.fecfs.heroes.block.entity.client.ExplosiveGelBlockRenderer;
import com.fecfs.heroes.entity.FecfsEntities;
import com.fecfs.heroes.item.FecfsItems;
import com.fecfs.heroes.item.custom.ExplosiveGelItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.TargetBlock;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.glfw.GLFW;

public class FecfsClient implements ClientModInitializer {
    private static KeyBinding useGadget;
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(FecfsEntities.BatarangEntityType, (context) ->
                new FlyingItemEntityRenderer(context));

        useGadget = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.fecfs-heroes.usegadget",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                "category.fecfsheroes.abilities_gadgets"
        ));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (useGadget.wasPressed()) {
                BlockPos blockPos = client.player.getBlockPos();
                Hand hand = client.player.getActiveHand();
                ItemStack itemStack = client.player.getStackInHand(hand);
                if(itemStack.getItem().equals(FecfsItems.EXPLOSIVE_GEL)) {
                    for(int i = 1; i <= 10; i++) {
                        Block block = client.world.getBlockState(blockPos).getBlock();
                        if(block.equals(FecfsBlocks.EXPLOSIVE_GEL_BLOCK)) {
                            client.world.createExplosion(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 2f,
                                    World.ExplosionSourceType.BLOCK);
                            client.world.removeBlock(blockPos, false);
                        }

                    }
                }
            }
        });

        BlockEntityRendererFactories.register(FecfsBlockEntities.EXPLOSIVE_GEL_BLOCK_ENTITY, ExplosiveGelBlockRenderer::new);
    }
}
