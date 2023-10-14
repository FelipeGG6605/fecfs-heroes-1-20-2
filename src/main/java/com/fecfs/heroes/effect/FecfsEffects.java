package com.fecfs.heroes.effect;

import com.fecfs.heroes.FecfsHeroes;
import com.fecfs.heroes.effect.custom.StaggeredEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FecfsEffects {
    public static StatusEffect STAGGERED;
    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(FecfsHeroes.MOD_ID, name),
                new StaggeredEffect(StatusEffectCategory.HARMFUL, 10673141));
    }
    public static void registerEffects() {
        STAGGERED = registerStatusEffect("staggered");
    }
}
