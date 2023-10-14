package com.fecfs.heroes.entity;

import com.fecfs.heroes.FecfsHeroes;
import com.fecfs.heroes.entity.custom.BatarangEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FecfsEntities {
    public static final EntityType<BatarangEntity> BatarangEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(FecfsHeroes.MOD_ID, "batarang"),
            FabricEntityTypeBuilder.<BatarangEntity>create(SpawnGroup.MISC, BatarangEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );
}
