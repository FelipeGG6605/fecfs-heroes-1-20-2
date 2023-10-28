package com.fecfs.heroes.entity.client;

import com.fecfs.heroes.FecfsHeroes;
import com.fecfs.heroes.entity.layer.FecfsModelLayer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class RECGEntityRenderer extends EntityRenderer {
    public static final Identifier TEXTURE = new Identifier(FecfsHeroes.MOD_ID, "textures/entity/recgentity.png");
    protected RECGEntityModel model;
    public RECGEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        model = new RECGEntityModel(ctx.getPart(FecfsModelLayer.RECGEntity));
    }

    @Override
    public Identifier getTexture(Entity entity) {
        return TEXTURE;
    }
}
