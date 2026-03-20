package com.example.googletvmod.network;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import java.util.function.Supplier;

public class PacketKeyPress {
    private final String key;
    private final int x, y, z;

    public PacketKeyPress(String key, int x, int y, int z) { this.key = key; this.x = x; this.y = y; this.z = z; }

    public static void encode(PacketKeyPress pkt, PacketBuffer buf) {
        buf.writeString(pkt.key);
        buf.writeInt(pkt.x); buf.writeInt(pkt.y); buf.writeInt(pkt.z);
    }

    public static PacketKeyPress decode(PacketBuffer buf) {
        return new PacketKeyPress(buf.readString(32767), buf.readInt(), buf.readInt(), buf.readInt());
    }

    public static void handle(PacketKeyPress pkt, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            // Найти tile entity по координатам и применить key
            // Server-side: применить изменения в TileEntityScreen
        });
        ctx.get().setPacketHandled(true);
    }
}
