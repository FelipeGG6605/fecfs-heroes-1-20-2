package com.fecfs.heroes.mixin;

import com.fecfs.heroes.item.FecfsItems;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin extends
        LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
    public PlayerEntityRendererMixin(EntityRendererFactory.Context ctx, PlayerEntityModel<AbstractClientPlayerEntity> model, float shadowRadius) {
        super(ctx, model, shadowRadius);
    }
    @Inject(method = "render(Lnet/minecraft/client/network/AbstractClientPlayerEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", at = @At(value = "HEAD"))
    private void render(AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (abstractClientPlayerEntity.getInventory().getArmorStack(0).isOf(FecfsItems.TB_2022_BOOTS) &&
                abstractClientPlayerEntity.getInventory().getArmorStack(1).isOf(FecfsItems.TB_2022_LEGGINGS) &&
                abstractClientPlayerEntity.getInventory().getArmorStack(2).isOf(FecfsItems.TB_2022_CHESTPLATE) &&
                abstractClientPlayerEntity.getInventory().getArmorStack(3).isOf(FecfsItems.TB_2022_HELMET)) {
            abstractClientPlayerEntity.setInvisible(true);
        } else if (!(abstractClientPlayerEntity.getInventory().getArmorStack(0).isOf(FecfsItems.TB_2022_BOOTS)) &&
                !(abstractClientPlayerEntity.getInventory().getArmorStack(1).isOf(FecfsItems.TB_2022_LEGGINGS)) &&
                !(abstractClientPlayerEntity.getInventory().getArmorStack(2).isOf(FecfsItems.TB_2022_CHESTPLATE)) &&
                !(abstractClientPlayerEntity.getInventory().getArmorStack(3).isOf(FecfsItems.TB_2022_HELMET)) ||
                (abstractClientPlayerEntity.getInventory().getArmorStack(0).isOf(FecfsItems.TB_2022_BOOTS)) ||
                (abstractClientPlayerEntity.getInventory().getArmorStack(1).isOf(FecfsItems.TB_2022_LEGGINGS)) ||
                (abstractClientPlayerEntity.getInventory().getArmorStack(2).isOf(FecfsItems.TB_2022_CHESTPLATE)) ||
                (abstractClientPlayerEntity.getInventory().getArmorStack(3).isOf(FecfsItems.TB_2022_HELMET))) {
            abstractClientPlayerEntity.setInvisible(false);
        }
    }
}