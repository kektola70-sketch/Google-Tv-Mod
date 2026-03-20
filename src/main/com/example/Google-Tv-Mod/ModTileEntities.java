package com.kektola70.googletvmod;

import com.kektola70.googletvmod.tile.TileEntityScreen;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, GoogleTvMod.MODID);

    public static final RegistryObject<TileEntityType<TileEntityScreen>> SCREEN_TILE = TILE_ENTITIES.register("screen_tile",
            () -> TileEntityType.Builder.create(TileEntityScreen::new, ModBlocks.SCREEN_BLOCK.get()).build(null));

    public static void register(IEventBus bus) {
        TILE_ENTITIES.register(bus);
    }
}
