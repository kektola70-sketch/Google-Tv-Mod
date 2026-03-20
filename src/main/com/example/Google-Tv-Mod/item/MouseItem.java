package com.kektola70.googletvmod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

public class MouseItem extends Item {
    public MouseItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        PlayerEntity player = context.getPlayer();
        if (!world.isRemote && player != null) {
            player.sendStatusMessage(new StringTextComponent("Clicked screen block at " + pos.toString()), true);
            // TODO: отправить пакет клика мыши на сервер
        }
        return ActionResultType.SUCCESS;
    }
}
