package cech12.brickfurnace.init;

import cech12.brickfurnace.BrickFurnaceMod;
import cech12.brickfurnace.api.block.BrickFurnaceBlocks;
import cech12.brickfurnace.api.tileentity.BrickFurnaceTileEntities;
import cech12.brickfurnace.tileentity.BrickBlastFurnaceTileEntity;
import cech12.brickfurnace.tileentity.BrickFurnaceTileEntity;
import cech12.brickfurnace.tileentity.BrickSmokerTileEntity;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid= BrickFurnaceMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModTileEntities {

    @SubscribeEvent
    public static void registerTileEntities(RegistryEvent.Register<TileEntityType<?>> event) {
        BrickFurnaceTileEntities.BRICK_FURNACE = register(BrickFurnaceTileEntity::new, "brick_furnace", BrickFurnaceBlocks.BRICK_FURNACE, event);
        BrickFurnaceTileEntities.BRICK_BLAST_FURNACE = register(BrickBlastFurnaceTileEntity::new, "brick_blast_furnace", BrickFurnaceBlocks.BRICK_BLAST_FURNACE, event);
        BrickFurnaceTileEntities.BRICK_SMOKER = register(BrickSmokerTileEntity::new, "brick_smoker", BrickFurnaceBlocks.BRICK_SMOKER, event);
    }

    private static <T extends TileEntity> TileEntityType<T> register(Supplier<T> supplier, String registryName, Block block, RegistryEvent.Register<TileEntityType<?>> registryEvent) {
        TileEntityType<T> tileEntityType = TileEntityType.Builder.create(supplier, block).build(null);
        tileEntityType.setRegistryName(registryName);
        registryEvent.getRegistry().register(tileEntityType);
        return tileEntityType;
    }

}
