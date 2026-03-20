package com.kektola70.googletvmod.block;

import com.kektola70.googletvmod.tile.TileEntityScreen;
import com.kektola70.googletvmod.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.state.StateContainer;
import net.minecraft.state.IntegerProperty;

public class ScreenBlock extends ContainerBlock {
    public static final IntegerProperty ROTATION = IntegerProperty.create("rotation", 0, 3);

    public ScreenBlock(Properties properties) {
        super(properties);
        // TODO: установить default state с rotation при необходимости
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileEntityScreen();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (world.isRemote) {
            player.sendStatusMessage(new StringTextComponent("Screen opened (client)"), true);
        } else {
            player.sendStatusMessage(new StringTextComponent("Screen activated (server)"), true);
            // TODO: открыть GUI через контейнер (отправить пакет)
        }
        return ActionResultType.SUCCESS;
    }
}
