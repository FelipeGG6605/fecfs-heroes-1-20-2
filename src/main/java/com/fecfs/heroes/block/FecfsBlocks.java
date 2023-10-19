package com.fecfs.heroes.block;

import com.fecfs.heroes.FecfsHeroes;
import com.fecfs.heroes.block.custom.ExplosiveGelBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class FecfsBlocks {
    public static final Block EXPLOSIVE_GEL_BLOCK = Registry.register(Registries.BLOCK, new Identifier(FecfsHeroes.MOD_ID,
            "explosive_gel_block"), new ExplosiveGelBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(FecfsHeroes.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(FecfsHeroes.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerBlocks() {
        FecfsHeroes.LOGGER.info("Registering blocks for "+FecfsHeroes.MOD_ID);
    }
}
