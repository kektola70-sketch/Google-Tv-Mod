package com.example.googletvmod.network;

import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraft.network.PacketBuffer;
import java.util.function.Supplier;

public class NetworkHandler {
    private static final String PROTOCOL = "1";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new net.minecraft.util.ResourceLocation("googletvmod", "main"),
            () -> PROTOCOL, PROTOCOL::equals, PROTOCOL::equals);

    private static int id = 0;
    private static int nextId() { return id++; }

    public static void register() {
        CHANNEL.registerMessage(nextId(), PacketKeyPress.class,
                PacketKeyPress::encode, PacketKeyPress::decode, PacketKeyPress::handle);
        CHANNEL.registerMessage(nextId(), PacketMouseEvent.class,
                PacketMouseEvent::encode, PacketMouseEvent::decode, PacketMouseEvent::handle);
    }
}
