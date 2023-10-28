package com.fecfs.heroes.datagen;

import com.fecfs.heroes.block.FecfsBlocks;
import com.fecfs.heroes.item.FecfsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class FecfsModelProvider extends FabricModelProvider {
    public FecfsModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(FecfsBlocks.EXPLOSIVEGELBLOCK);
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(FecfsItems.TB_2022_HELMET, Models.GENERATED);
        itemModelGenerator.register(FecfsItems.TB_2022_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(FecfsItems.TB_2022_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(FecfsItems.TB_2022_BOOTS, Models.GENERATED);

        itemModelGenerator.register(FecfsItems.ARMOR_TAB_ICON, Models.GENERATED);
    }
}
