package com.kektola70.googletvmod.item;

import com.kektola70.googletvmod.network.NetworkHandler;
import com.kektola70.googletvmod.network.PacketKeyPress;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class KeyboardItem extends Item {
    public KeyboardItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        PlayerEntity player = context.getPlayer();
        if (!world.isRemote && player != null) {
            // Пример: отправляем пакет с символом "A" — реальная клавиатура должна собирать ввод с GUI
            NetworkHandler.CHANNEL.sendToServer(new PacketKeyPress("A", pos));
            player.sendStatusMessage(new StringTextComponent("Sent 'A' to screen (stub)"), true);
        }
        return ActionResultType.SUCCESS;
    }
}
