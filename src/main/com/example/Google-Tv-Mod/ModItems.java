package com.kektola70.googletvmod;

import com.kektola70.googletvmod.item.KeyboardItem;
import com.kektola70.googletvmod.item.MouseItem;
import com.kektola70.googletvmod.item.LaserPointerItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GoogleTvMod.MODID);

    public static final RegistryObject<Item> SCREEN_BLOCK_ITEM = ITEMS.register("screen_block",
            () -> new BlockItem(ModBlocks.SCREEN_BLOCK.get(), new Item.Properties().group(ItemGroup.MISC)));

    public static final RegistryObject<Item> KEYBOARD = ITEMS.register("keyboard",
            () -> new KeyboardItem(new Item.Properties().group(ItemGroup.TOOLS)));

    public static final RegistryObject<Item> MOUSE = ITEMS.register("mouse",
            () -> new MouseItem(new Item.Properties().group(ItemGroup.TOOLS)));

    public static final RegistryObject<Item> LASER_POINTER = ITEMS.register("laser_pointer",
            () -> new LaserPointerItem(new Item.Properties().group(ItemGroup.TOOLS)));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
