package com.fecfs.heroes.item.client;

import com.fecfs.heroes.item.custom.TB_2022ArmorItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class TB_2022Renderer extends GeoArmorRenderer<TB_2022ArmorItem> {
    public TB_2022Renderer() {
        super(new TB_2022Model());
    }
}
