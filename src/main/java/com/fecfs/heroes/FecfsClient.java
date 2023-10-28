package com.fecfs.heroes;

import com.fecfs.heroes.entity.FecfsEntities;
import com.fecfs.heroes.entity.client.RECGEntityModel;
import com.fecfs.heroes.entity.client.RECGEntityRenderer;
import com.fecfs.heroes.entity.layer.FecfsModelLayer;
import com.fecfs.heroes.networking.FecfsPackets;
import com.fecfs.heroes.particle.FecfsParticles;
import com.fecfs.heroes.particle.SmokeParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class FecfsClient implements ClientModInitializer {
    private static KeyBinding useGadget;
    private static KeyBinding getEquipments;
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(FecfsModelLayer.RECGEntity, RECGEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(FecfsEntities.RECGEntity, RECGEntityRenderer::new);

        EntityRendererRegistry.register(FecfsEntities.BatarangEntityType, (context) ->
                new FlyingItemEntityRenderer(context));

        EntityRendererRegistry.register(FecfsEntities.SmokePelletEntityType, (context) ->
                new FlyingItemEntityRenderer(context));
        FecfsPackets.registerS2CPackets();
        ParticleFactoryRegistry.getInstance().register(FecfsParticles.SMOKE_PARTICLE, SmokeParticle.Factory::new);

        useGadget = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.fecfs-heroes.usegadget",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                "category.fecfs-heroes.abilities"
        ));
        getEquipments = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.fecfs-heroes.getequipments",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_X,
                "category.fecfs-heroes.abilities"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (useGadget.wasPressed()) {
                ClientPlayNetworking.send(FecfsPackets.USE_GADGET_KEYBIND_PACKET, PacketByteBufs.create());
            }
        });
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (getEquipments.wasPressed()) {
                ClientPlayNetworking.send(FecfsPackets.GET_EQUIPMENTS_KEYBIND_PACKET, PacketByteBufs.create());
            }
        });

    }
}
