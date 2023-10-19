package com.fecfs.heroes.item.client;

import com.fecfs.heroes.item.custom.ExplosiveGelBlockItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ExplosiveGelBlockItemRenderer extends GeoItemRenderer<ExplosiveGelBlockItem> {
    public ExplosiveGelBlockItemRenderer() {
        super(new ExplosiveGelBlockItemModel());
    }
}
