package com.fecfs.heroes.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ElectrifiedEffect extends StatusEffect {
    public ElectrifiedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.getWorld().isClient()) {
            double x = pLivingEntity.getX();
            double y = pLivingEntity.getY();
            double z = pLivingEntity.getZ();

            pLivingEntity.teleport(x, y, z);
            pLivingEntity.setVelocity(0,0,0);
            if (pLivingEntity.getHealth() > 4.0f) {
                pLivingEntity.damage(pLivingEntity.getDamageSources().magic(), 0.25f);
            }
        }
        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }
    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        int i = 25 >> pAmplifier;
        if (i > 0) {
            return pDuration % i == 0;
        }
        return true;
    }
}
