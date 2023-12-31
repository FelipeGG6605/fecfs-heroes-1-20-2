package com.fecfs.heroes.sound;

import com.fecfs.heroes.FecfsHeroes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class FecfsSounds {
    public static final SoundEvent RemoteElectricalChargeGunShot = registerSoundEvent("remote_electrical_charge_gun_fx");
    public static final SoundEvent BatarangThrown = registerSoundEvent("batarang_thrown");
    public static final SoundEvent ExplosiveGelPlaced = registerSoundEvent("explosive_gel_placed");
    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(FecfsHeroes.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void registerSounds() {
        FecfsHeroes.LOGGER.info("Registering sounds for " + FecfsHeroes.MOD_ID);
    }
}
