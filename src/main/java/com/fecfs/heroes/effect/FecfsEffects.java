package com.fecfs.heroes.effect;

import com.fecfs.heroes.FecfsHeroes;
import com.fecfs.heroes.effect.custom.StaggeredEffect;
import com.fecfs.heroes.effect.custom.TB_2022Effect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FecfsEffects {
    public static final StatusEffect TB_2022EFFECT = registerStatusEffect("tb_2022_powers",
            new TB_2022Effect(StatusEffectCategory.BENEFICIAL, 0x1d1e21)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                    "425b97d4-f3ef-4194-9dfe-e67622e7a56d", 1.1f,
                    EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                            "c7b5ca1a-050c-4568-a963-cbb895fcf9cf", 6.5f,
                            EntityAttributeModifier.Operation.ADDITION)
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED,
                            "04e00fca-109e-4d9a-95dd-758cc768dfb7", 2f,
                            EntityAttributeModifier.Operation.ADDITION));

    public static final StatusEffect STAGGERED = registerStatusEffect("staggered",
            new StaggeredEffect(StatusEffectCategory.HARMFUL, 0x2c7782)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            "65e147ae-28f8-4fdd-a8a3-8936a3d9949b", -1.0f,
                            EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    public static void registerEffects() {
        FecfsHeroes.LOGGER.info("Registering effects for "+FecfsHeroes.MOD_ID);
    }
    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(FecfsHeroes.MOD_ID, name), statusEffect);
    }
}