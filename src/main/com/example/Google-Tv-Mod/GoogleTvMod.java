package com.kektola70.googletvmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(GoogleTvMod.MODID)
public class GoogleTvMod {
    public static final String MODID = "googletvmod";

    public GoogleTvMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.register(bus);
        ModItems.register(bus);
        ModTileEntities.register(bus);
        NetworkHandler.register();

        // Общая и клиентская инициализация
        bus.addListener(this::setup);
        bus.addListener(this::clientSetup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // TODO: общая настройка
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        // TODO: регистрация GUI (ScreenManager.registerFactory ...) — реализовано в ClientEventSubscriber
    }
}
