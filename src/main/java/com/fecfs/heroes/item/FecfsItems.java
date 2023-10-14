package com.fecfs.heroes.item;

import com.fecfs.heroes.FecfsHeroes;
import com.fecfs.heroes.item.custom.BatarangItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FecfsItems {
    public static final Item BATARANG_ITEM = registerItem("batarang", new BatarangItem(
            new FabricItemSettings().maxCount(16)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FecfsHeroes.MOD_ID, name), item);
    }
    public static void registerModItems(){
        FecfsHeroes.LOGGER.info("Registering Fecfs Items for " + FecfsHeroes.MOD_ID);
    }
}
