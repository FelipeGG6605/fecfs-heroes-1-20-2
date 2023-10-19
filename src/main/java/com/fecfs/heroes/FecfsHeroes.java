package com.fecfs.heroes;

import com.fecfs.heroes.block.FecfsBlocks;
import com.fecfs.heroes.block.entity.FecfsBlockEntities;
import com.fecfs.heroes.effect.FecfsEffects;
import com.fecfs.heroes.entity.FecfsEntities;
import com.fecfs.heroes.item.FecfsItemGroups;
import com.fecfs.heroes.item.FecfsItems;
import com.fecfs.heroes.item.custom.BatarangItem;
import com.fecfs.heroes.sound.FecfsSounds;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FecfsHeroes implements ModInitializer {
	public static  final  String MOD_ID = "fecfs-heroes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		FecfsItemGroups.registerItemGroups();
		FecfsItems.registerModItems();
		FecfsEffects.registerEffects();
		FecfsSounds.registerSounds();
		FecfsBlocks.registerBlocks();
		FecfsBlockEntities.registerAllBlockEntities();
	}
}