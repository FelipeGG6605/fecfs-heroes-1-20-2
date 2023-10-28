package com.fecfs.heroes.networking;

import com.fecfs.heroes.FecfsHeroes;
import com.fecfs.heroes.networking.packets.GetEquipmentsKeybindC2SPacket;
import com.fecfs.heroes.networking.packets.UseGadgetKeybindC2SPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class FecfsPackets {
    public static final Identifier USE_GADGET_KEYBIND_PACKET = new Identifier(FecfsHeroes.MOD_ID, "use_gadget_keybind_packet");
    public static final Identifier GET_EQUIPMENTS_KEYBIND_PACKET = new Identifier(FecfsHeroes.MOD_ID, "get_equipments_keybind_packet");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(USE_GADGET_KEYBIND_PACKET, UseGadgetKeybindC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(GET_EQUIPMENTS_KEYBIND_PACKET, GetEquipmentsKeybindC2SPacket::receive);
    }
    public static void registerS2CPackets() {

    }
}

