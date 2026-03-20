package com.example.googletvmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.IEventBus;

@Mod(GoogleTvMod.MODID)
public class GoogleTvMod {
    public static final String MODID = "googletvmod";

    public GoogleTvMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.register(bus);
        ModItems.register(bus);
        ModTileEntities.register(bus);
        ModContainers.register(bus);
        NetworkHandler.register(); // register packets
    }
}
