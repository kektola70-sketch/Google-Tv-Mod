package com.kektola70.googletvmod.tile;

import com.kektola70.googletvmod.ModTileEntities;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.nbt.CompoundNBT;
import java.util.ArrayList;
import java.util.List;

public class TileEntityScreen extends TileEntity {
    private final List<String> contents = new ArrayList<>();
    private int cursorX = 0;
    private int cursorY = 0;

    public TileEntityScreen() {
        super(ModTileEntities.SCREEN_TILE.get());
        contents.add("Welcome to GoogleTV Mod!");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound = super.write(compound);
        compound.putInt("cursorX", cursorX);
        compound.putInt("cursorY", cursorY);
        // TODO: сериализовать contents (List)
        return compound;
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        cursorX = compound.getInt("cursorX");
        cursorY = compound.getInt("cursorY");
        // TODO: десериализовать contents
    }

    public synchronized void appendText(String s) {
        contents.add(s);
        markDirty();
    }

    public synchronized List<String> getContents() {
        return new ArrayList<>(contents);
    }

    // TODO: методы обработки клавиатуры, мыши, загрузки URL и т.д.
}
