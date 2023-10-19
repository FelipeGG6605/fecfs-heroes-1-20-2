package com.fecfs.heroes.item.client;

import com.fecfs.heroes.FecfsHeroes;
import com.fecfs.heroes.item.custom.TB_2022ArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TB_2022Model extends GeoModel<TB_2022ArmorItem> {
    @Override
    public Identifier getModelResource(TB_2022ArmorItem animatable) {
        return new Identifier(FecfsHeroes.MOD_ID, "geo/tb_2022.geo.json");
    }

    @Override
    public Identifier getTextureResource(TB_2022ArmorItem animatable) {
        return new Identifier(FecfsHeroes.MOD_ID, "textures/armor/tb_2022.png");
    }

    @Override
    public Identifier getAnimationResource(TB_2022ArmorItem animatable) {
        return new Identifier(FecfsHeroes.MOD_ID, "animations/tb_2022.animation.json");
    }
}
