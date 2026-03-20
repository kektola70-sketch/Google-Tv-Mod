package com.example.googletvmod.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.nbt.CompoundNBT;
import java.util.ArrayList;
import java.util.List;

public class TileEntityScreen extends TileEntity {
    // Простейшее состояние экрана: список строк текста
    private List<String> contents = new ArrayList<>();
    private int cursorX = 0, cursorY = 0;

    public TileEntityScreen() {
        super(ModTileEntities.SCREEN_TILE.get());
        contents.add("Welcome to GoogleTV Mod!");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        // Сериализация состояния
        compound.putInt("cursorX", cursorX);
        compound.putInt("cursorY", cursorY);
        // простая сериализация списка строк
        // (в реале используйте ListNBT)
        return super.write(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        cursorX = compound.getInt("cursorX");
        cursorY = compound.getInt("cursorY");
    }

    // Методы для обновления содержимого, обработки клавиатуры и мыши
    public void appendText(String s) { contents.add(s); markDirty(); }
}
