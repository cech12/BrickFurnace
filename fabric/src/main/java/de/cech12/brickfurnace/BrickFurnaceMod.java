package de.cech12.brickfurnace;

import de.cech12.brickfurnace.init.ModBlockEntityTypes;
import de.cech12.brickfurnace.init.ModBlocks;
import de.cech12.brickfurnace.init.ModItems;
import de.cech12.brickfurnace.init.ModRecipeTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.CreativeModeTabs;

public class BrickFurnaceMod implements ModInitializer {

    private static MinecraftServer serverInstance;

    @Override
    public void onInitialize() {
        ModBlocks.init();
        ModBlockEntityTypes.init();
        ModItems.init();
        ModRecipeTypes.init();
        CommonLoader.init();
        //init POI types
        CommonLoader.initPoiStates(BuiltInRegistries.POINT_OF_INTEREST_TYPE::get);
        //Register item in the creative tab.
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(content -> {
            content.accept(Constants.BRICK_FURNACE_ITEM.get());
            content.accept(Constants.BRICK_BLAST_FURNACE_ITEM.get());
            content.accept(Constants.BRICK_SMOKER_ITEM.get());
        });
        //register server instance listener
        ServerLifecycleEvents.SERVER_STARTED.register(server -> serverInstance = server);
    }

    public static MinecraftServer getServer() {
        return serverInstance;
    }

}
