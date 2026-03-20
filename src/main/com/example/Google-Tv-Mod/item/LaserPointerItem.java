package com.kektola70.googletvmod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;

public class LaserPointerItem extends Item {
    public LaserPointerItem(Properties properties) {
        super(properties);
    }

    // Простая имитация: при использовании испускает луч и сигнализирует на блок
    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        if (player == null) return ActionResultType.FAIL;
        Vector3d eye = player.getEyePosition(1.0F);
        Vector3d look = player.getLook(1.0F);
        Vector3d end = eye.add(look.x * 50, look.y * 50, look.z * 50);
        BlockRayTraceResult ray = world.rayTraceBlocks(new RayTraceContext(eye, end, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, player));
        if (ray.getType() == BlockRayTraceResult.Type.BLOCK) {
            BlockPos pos = ray.getPos();
            if (!world.isRemote) {
                player.sendStatusMessage(new StringTextComponent("Laser hit: " + pos.toString()), true);
                // TODO: отправить событие клика на экран в pos
            }
        }
        return ActionResultType.SUCCESS;
    }
}
