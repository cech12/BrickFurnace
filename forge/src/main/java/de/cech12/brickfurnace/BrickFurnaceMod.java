package de.cech12.brickfurnace;

import de.cech12.brickfurnace.init.ModBlockEntityTypes;
import de.cech12.brickfurnace.init.ModBlocks;
import de.cech12.brickfurnace.init.ModItems;
import de.cech12.brickfurnace.init.ModRecipeTypes;
import de.cech12.brickfurnace.mixin.PoiTypeAccessor;
import de.cech12.brickfurnace.mixin.PoiTypesAccessor;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import java.util.HashSet;
import java.util.Set;

@Mod(Constants.MOD_ID)
@Mod.EventBusSubscriber(modid=Constants.MOD_ID)
public class BrickFurnaceMod {

    public BrickFurnaceMod(FMLJavaModLoadingContext context) {
        final BusGroup eventBus = context.getModBusGroup();
        ModBlocks.BLOCKS.register(eventBus);
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModRecipeTypes.RECIPE_TYPES.register(eventBus);
        ModRecipeTypes.RECIPE_SERIALIZERS.register(eventBus);

        CommonLoader.init();
    }

    @SubscribeEvent
    public static void register(RegisterEvent event) {
        if (ForgeRegistries.POI_TYPES.equals(event.getForgeRegistry())) {
            event.register(ForgeRegistries.Keys.POI_TYPES, pointOfInterestTypeRegisterHelper -> {
                //CommonLoader.initPoiStates(key -> ForgeRegistries.POI_TYPES.getDelegate(key).get().get(), key -> ForgeRegistries.POI_TYPES.getHolder(key).get());

                Set<BlockState> addedStates = new HashSet<>(Constants.BRICK_BLAST_FURNACE_BLOCK.get().getStateDefinition().getPossibleStates());
                Set<BlockState> newStates = new HashSet<>();
                newStates.addAll(((PoiTypeAccessor)(Object)ForgeRegistries.POI_TYPES.getValue(PoiTypes.ARMORER.identifier())).getMatchingStates());
                newStates.addAll(addedStates);
                PoiType pointOfInterestType = new PoiType(newStates, 1, 1);
                ForgeRegistries.POI_TYPES.register("minecraft:armorer", pointOfInterestType);
                PoiTypesAccessor.setArmorer(ForgeRegistries.POI_TYPES.getHolder(pointOfInterestType).get().unwrapKey().get());

                addedStates = new HashSet<>(Constants.BRICK_SMOKER_BLOCK.get().getStateDefinition().getPossibleStates());
                newStates = new HashSet<>();
                newStates.addAll(((PoiTypeAccessor)(Object)ForgeRegistries.POI_TYPES.getValue(PoiTypes.BUTCHER.identifier())).getMatchingStates());
                newStates.addAll(addedStates);
                pointOfInterestType = new PoiType(newStates, 1, 1);
                ForgeRegistries.POI_TYPES.register("minecraft:butcher", pointOfInterestType);
                PoiTypesAccessor.setButcher(ForgeRegistries.POI_TYPES.getHolder(pointOfInterestType).get().unwrapKey().get());
            });
        }
    }

    @SubscribeEvent
    public static void addItemsToTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(Constants.BRICK_FURNACE_ITEM);
            event.accept(Constants.BRICK_BLAST_FURNACE_ITEM);
            event.accept(Constants.BRICK_SMOKER_ITEM);
        }
    }

}
