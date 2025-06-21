package de.cech12.brickfurnace;

import de.cech12.brickfurnace.init.ModBlockEntityTypes;
import de.cech12.brickfurnace.init.ModBlocks;
import de.cech12.brickfurnace.init.ModItems;
import de.cech12.brickfurnace.init.ModRecipeTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.registries.RegisterEvent;

@SuppressWarnings("unused")
@Mod(Constants.MOD_ID)
@EventBusSubscriber(modid= Constants.MOD_ID)
public class BrickFurnaceMod {

    public BrickFurnaceMod(IEventBus eventBus) {
        ModBlocks.BLOCKS.register(eventBus);
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModRecipeTypes.RECIPE_TYPES.register(eventBus);
        ModRecipeTypes.RECIPE_SERIALIZERS.register(eventBus);

        CommonLoader.init();

        //The One Probe registration.
        //if (ModList.get().isLoaded("theoneprobe") && !ModList.get().isLoaded("topaddons")) {
        //    TOPCompat.register();
        //}
    }

    @SubscribeEvent
    public static void register(RegisterEvent event) {
        if (event.getRegistry() == BuiltInRegistries.POINT_OF_INTEREST_TYPE) {
            event.register(BuiltInRegistries.POINT_OF_INTEREST_TYPE.key(), pointOfInterestTypeRegisterHelper -> CommonLoader.initPoiStates(BuiltInRegistries.POINT_OF_INTEREST_TYPE::get));
        }
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, Constants.BRICK_FURNACE_BLOCK_ENTITY_TYPE.get(), SidedInvWrapper::new);
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, Constants.BRICK_BLAST_FURNACE_BLOCK_ENTITY_TYPE.get(), SidedInvWrapper::new);
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, Constants.BRICK_SMOKER_BLOCK_ENTITY_TYPE.get(), SidedInvWrapper::new);
    }

    @SubscribeEvent
    public static void addItemsToTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(Constants.BRICK_FURNACE_ITEM.get());
            event.accept(Constants.BRICK_BLAST_FURNACE_ITEM.get());
            event.accept(Constants.BRICK_SMOKER_ITEM.get());
        }
    }

}
