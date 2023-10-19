package com.fecfs.heroes.block.entity.client;

import com.fecfs.heroes.block.entity.ExplosiveGelBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ExplosiveGelBlockRenderer extends GeoBlockRenderer<ExplosiveGelBlockEntity> {
    public ExplosiveGelBlockRenderer(BlockEntityRendererFactory.Context context) {
        super(new ExplosiveGelBlockModel());
    }
}
