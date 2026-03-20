package com.kektola70.googletvmod.network;

import com.kektola70.googletvmod.GoogleTvMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkHandler {
    private static final String PROTOCOL = "1";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(GoogleTvMod.MODID, "main"),
            () -> PROTOCOL,
            PROTOCOL::equals,
            PROTOCOL::equals
    );

    private static int id = 0;
    private static int nextID() { return id++; }

    public static void register() {
        CHANNEL.registerMessage(nextID(), PacketKeyPress.class,
                PacketKeyPress::encode, PacketKeyPress::decode, PacketKeyPress::handle);
        // TODO: register mouse packet, screen update packet и т.д.
    }
}
