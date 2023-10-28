package com.fecfs.heroes.entity.layer;

import com.fecfs.heroes.FecfsHeroes;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class FecfsModelLayer {
    public static final EntityModelLayer RECGEntity =
            new EntityModelLayer(new Identifier(FecfsHeroes.MOD_ID, "recgentity"), "main");
}
