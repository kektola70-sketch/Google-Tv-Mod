package com.example.googletvmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;

public class ScreenBlock extends ContainerBlock {
    public ScreenBlock(Properties properties) { super(properties); }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new com.example.googletvmod.tile.TileEntityScreen();
    }

    // Аналогично переопределить onBlockActivated для открытия GUI и взаимодействия
}
