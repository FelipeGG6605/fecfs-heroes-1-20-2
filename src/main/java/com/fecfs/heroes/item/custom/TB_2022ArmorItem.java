package com.fecfs.heroes.item.custom;

import com.fecfs.heroes.effect.FecfsEffects;
import com.fecfs.heroes.item.FecfsArmorMaterials;
import com.fecfs.heroes.item.FecfsItems;
import com.fecfs.heroes.item.client.TB_2022Renderer;
import com.fecfs.heroes.mixin.PlayerEntityRendererMixin;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class TB_2022ArmorItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);
    public TB_2022ArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private TB_2022Renderer renderer;

            @Override
            public BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                        EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
                if (this.renderer == null)
                    this.renderer = new TB_2022Renderer();

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);

                return this.renderer;
            }
        });
    }
    @Override
    public Supplier<Object> getRenderProvider() {
        return this.renderProvider;
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, "controller", 0, this::predicate));
    }
    private PlayState predicate(AnimationState animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
    private boolean isWearingFullSuitOfArmor(PlayerEntity player) {
        ItemStack b = player.getInventory().getArmorStack(0);
        ItemStack l = player.getInventory().getArmorStack(1);
        ItemStack c = player.getInventory().getArmorStack(2);
        ItemStack h = player.getInventory().getArmorStack(3);

        return !b.isEmpty() && !l.isEmpty() && !c.isEmpty() && !h.isEmpty();
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient() && entity instanceof PlayerEntity player) {
            if(player.getInventory().getArmorStack(0).isOf(FecfsItems.TB_2022_BOOTS) &&
                    player.getInventory().getArmorStack(1).isOf(FecfsItems.TB_2022_LEGGINGS) &&
                    player.getInventory().getArmorStack(2).isOf(FecfsItems.TB_2022_CHESTPLATE) &&
                    player.getInventory().getArmorStack(3).isOf(FecfsItems.TB_2022_HELMET)){
                player.addStatusEffect(new StatusEffectInstance(FecfsEffects.TB_2022EFFECT));
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}