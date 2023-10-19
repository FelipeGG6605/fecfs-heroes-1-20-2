package com.fecfs.heroes.block.entity;

import com.fecfs.heroes.FecfsHeroes;
import com.fecfs.heroes.block.FecfsBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FecfsBlockEntities {
    public static BlockEntityType<ExplosiveGelBlockEntity> EXPLOSIVE_GEL_BLOCK_ENTITY;
    public static void registerAllBlockEntities() {
        EXPLOSIVE_GEL_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(FecfsHeroes.MOD_ID, "explosive_gel_block_entity"),
                FabricBlockEntityTypeBuilder.create(ExplosiveGelBlockEntity::new,
                        FecfsBlocks.EXPLOSIVE_GEL_BLOCK).build(null));
    }
}