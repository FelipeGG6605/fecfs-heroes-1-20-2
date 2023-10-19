package com.fecfs.heroes.item.client;

import com.fecfs.heroes.FecfsHeroes;
import com.fecfs.heroes.block.entity.ExplosiveGelBlockEntity;
import com.fecfs.heroes.item.custom.ExplosiveGelBlockItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ExplosiveGelBlockItemModel extends GeoModel<ExplosiveGelBlockItem> {
    @Override
    public Identifier getModelResource(ExplosiveGelBlockItem animatable) {
        return new Identifier(FecfsHeroes.MOD_ID, "geo/explosive_gel_block.geo.json");
    }

    @Override
    public Identifier getTextureResource(ExplosiveGelBlockItem animatable) {
        return new Identifier(FecfsHeroes.MOD_ID, "textures/block/explosive_gel_block.png");
    }

    @Override
    public Identifier getAnimationResource(ExplosiveGelBlockItem animatable) {
        return new Identifier(FecfsHeroes.MOD_ID, "animations/explosive_gel_block.animation.json");
    }
}
