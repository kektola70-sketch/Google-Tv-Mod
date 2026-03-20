package com.kektola70.googletvmod.client;

import com.kektola70.googletvmod.GoogleTvMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = GoogleTvMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventSubscriber {
    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        // TODO: зарегистрировать GUI/рендеры/TileEntityRenderers
    }
}
