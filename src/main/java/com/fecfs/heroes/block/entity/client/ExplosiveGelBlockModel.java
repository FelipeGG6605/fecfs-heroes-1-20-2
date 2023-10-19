package com.fecfs.heroes.block.entity.client;

import com.fecfs.heroes.FecfsHeroes;
import com.fecfs.heroes.block.entity.ExplosiveGelBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ExplosiveGelBlockModel extends GeoModel<ExplosiveGelBlockEntity> {
    @Override
    public Identifier getModelResource(ExplosiveGelBlockEntity animatable) {
        return new Identifier(FecfsHeroes.MOD_ID, "geo/explosive_gel_block.geo.json");
    }

    @Override
    public Identifier getTextureResource(ExplosiveGelBlockEntity animatable) {
        return new Identifier(FecfsHeroes.MOD_ID, "textures/block/explosive_gel_block.png");
    }

    @Override
    public Identifier getAnimationResource(ExplosiveGelBlockEntity animatable) {
        return new Identifier(FecfsHeroes.MOD_ID, "animations/explosive_gel_block.animation.json");
    }
}
