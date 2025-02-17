package de.cech12.brickfurnace.init;

import de.cech12.brickfurnace.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(Constants.MOD_ID);

    static {
        Constants.BRICK_FURNACE_ITEM = fromBlock(Constants.BRICK_FURNACE_NAME, Constants.BRICK_FURNACE_BLOCK);
        Constants.BRICK_BLAST_FURNACE_ITEM = fromBlock(Constants.BRICK_BLAST_FURNACE_NAME, Constants.BRICK_BLAST_FURNACE_BLOCK);
        Constants.BRICK_SMOKER_ITEM = fromBlock(Constants.BRICK_SMOKER_NAME, Constants.BRICK_SMOKER_BLOCK);
    }

    private static DeferredHolder<Item, Item> fromBlock(String name, Supplier<Block> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), Constants.id(name)))));
    }

}
