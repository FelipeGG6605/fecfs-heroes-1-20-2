package com.fecfs.heroes;

import com.fecfs.heroes.entity.FecfsEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class FecfsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(FecfsEntities.BatarangEntityType, (context) ->
                new FlyingItemEntityRenderer(context));
    }
}
