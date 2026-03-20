package com.example.googletvmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.RegistryObject as RO;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GoogleTvMod.MODID);

    public static final RegistryObject<Block> SCREEN_BLOCK = BLOCKS.register("screen_block",
            () -> new ScreenBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(1.0f)));

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
