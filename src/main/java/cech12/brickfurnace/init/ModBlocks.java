package cech12.brickfurnace.init;


import cech12.brickfurnace.BrickFurnaceMod;
import cech12.brickfurnace.api.block.BrickFurnaceBlocks;
import cech12.brickfurnace.block.BrickBlastFurnaceBlock;
import cech12.brickfurnace.block.BrickFurnaceBlock;
import cech12.brickfurnace.block.BrickSmokerBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid= BrickFurnaceMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModBlocks {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        BrickFurnaceBlocks.BRICK_FURNACE = registerBlock("brick_furnace", ItemGroup.DECORATIONS, new BrickFurnaceBlock(Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(2.0F, 6.0F).lightValue(13)));
        BrickFurnaceBlocks.BRICK_BLAST_FURNACE = registerBlock("brick_blast_furnace", ItemGroup.DECORATIONS, new BrickBlastFurnaceBlock(Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(2.0F, 6.0F).lightValue(13)));
        BrickFurnaceBlocks.BRICK_SMOKER = registerBlock("brick_smoker", ItemGroup.DECORATIONS, new BrickSmokerBlock(Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(2.0F, 6.0F).lightValue(13)));
    }

    public static Block registerBlock(String name, ItemGroup itemGroup, Block block) {
        BlockItem itemBlock = new BlockItem(block, new Item.Properties().group(itemGroup));
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);
        return block;
    }

}