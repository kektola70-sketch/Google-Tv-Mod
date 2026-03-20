package com.kektola70.googletvmod.network;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import com.kektola70.googletvmod.tile.TileEntityScreen;
import com.kektola70.googletvmod.GoogleTvMod;
import net.minecraft.util.text.StringTextComponent;

public class PacketKeyPress {
    private final String key;
    private final BlockPos pos;

    public PacketKeyPress(String key, BlockPos pos) {
        this.key = key;
        this.pos = pos;
    }

    public static void encode(PacketKeyPress pkt, PacketBuffer buf) {
        buf.writeString(pkt.key);
        buf.writeBlockPos(pkt.pos);
    }

    public static PacketKeyPress decode(PacketBuffer buf) {
        String k = buf.readString(32767);
        BlockPos p = buf.readBlockPos();
        return new PacketKeyPress(k, p);
    }

    public static void handle(PacketKeyPress pkt, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            // Серверная обработка: найти TileEntityScreen и применить нажатие
            net.minecraft.entity.player.ServerPlayerEntity sender = ctx.get().getSender();
            if (sender == null) return;
            TileEntity te = sender.getEntityWorld().getTileEntity(pkt.pos);
            if (te instanceof TileEntityScreen) {
                TileEntityScreen screen = (TileEntityScreen) te;
                screen.appendText("[" + sender.getName().getString() + "]: " + pkt.key);
                // TODO: послать обновление клиентам при необходимости
                sender.sendStatusMessage(new StringTextComponent("Key sent to screen: " + pkt.key), false);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
