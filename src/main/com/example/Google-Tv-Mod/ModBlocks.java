package com.kektola70.googletvmod;

import com.kektola70.googletvmod.block.ScreenBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GoogleTvMod.MODID);

    public static final RegistryObject<Block> SCREEN_BLOCK = BLOCKS.register("screen_block",
            () -> new ScreenBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f)));

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
