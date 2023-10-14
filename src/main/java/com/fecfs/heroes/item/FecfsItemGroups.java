package com.fecfs.heroes.item;

import com.fecfs.heroes.FecfsHeroes;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class FecfsItemGroups {
    public static final ItemGroup BatGadgets = Registry.register(Registries.ITEM_GROUP,
            new Identifier(FecfsHeroes.MOD_ID, "batgadgets"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.batgadgets"))
                    .icon(() -> new ItemStack(FecfsItems.BATARANG_ITEM)).entries((displayContext, entries) -> {
                        entries.add(FecfsItems.BATARANG_ITEM);
                    }).build());
    public static void registerItemGroups() {
        FecfsHeroes.LOGGER.info("Registering Item Groups for " + FecfsHeroes.MOD_ID);
    }
}
