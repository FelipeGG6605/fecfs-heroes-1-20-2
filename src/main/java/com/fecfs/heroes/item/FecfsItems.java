package com.fecfs.heroes.item;

import com.fecfs.heroes.FecfsHeroes;
import com.fecfs.heroes.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FecfsItems {
    public static final Item REMOTE_ELECTRICAL_CHARGE_GUN = registerItem("remote_electrical_charge_gun",
            new RECG(new FabricItemSettings().maxCount(1)));
    public static final Item EXPLOSIVE_GEL = registerItem("explosive_gel",
            new ExplosiveGelItem(new FabricItemSettings().maxCount(1)));
    public static final Item BATARANG_ITEM = registerItem("batarang", new BatarangItem(
            new FabricItemSettings().maxCount(16)));
    public static final Item SMOKE_PELLET = registerItem("smoke_pellet", new SmokePelletItem(
            new FabricItemSettings().maxCount(8)));
    public static final Item ARMOR_TAB_ICON = registerItem("armor_tab_icon", new Item(new FabricItemSettings()));

    //The Batman 2022
    public static final Item TB_2022_HELMET = registerItem("tb_2022_helmet", new TB_2022ArmorItem(
            FecfsArmorMaterials.TB_2022, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item TB_2022_CHESTPLATE = registerItem("tb_2022_chestplate", new TB_2022ArmorItem(
            FecfsArmorMaterials.TB_2022, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item TB_2022_LEGGINGS = registerItem("tb_2022_leggings", new TB_2022ArmorItem(
            FecfsArmorMaterials.TB_2022, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item TB_2022_BOOTS = registerItem("tb_2022_boots", new TB_2022ArmorItem(
            FecfsArmorMaterials.TB_2022, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FecfsHeroes.MOD_ID, name), item);
    }
    public static void registerModItems(){
        FecfsHeroes.LOGGER.info("Registering Fecfs Items for " + FecfsHeroes.MOD_ID);
    }
}
