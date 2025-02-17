package de.cech12.brickfurnace.init;

import de.cech12.brickfurnace.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ModItems {

    private static final Item BRICK_FURNACE_ITEM = register(Constants.BRICK_FURNACE_NAME, Constants.BRICK_FURNACE_BLOCK);
    private static final Item BRICK_BLAST_FURNACE_ITEM = register(Constants.BRICK_BLAST_FURNACE_NAME, Constants.BRICK_BLAST_FURNACE_BLOCK);
    private static final Item BRICK_SMOKER_ITEM = register(Constants.BRICK_SMOKER_NAME, Constants.BRICK_SMOKER_BLOCK);

    static {
        Constants.BRICK_FURNACE_ITEM = () -> BRICK_FURNACE_ITEM;
        Constants.BRICK_BLAST_FURNACE_ITEM = () -> BRICK_BLAST_FURNACE_ITEM;
        Constants.BRICK_SMOKER_ITEM = () -> BRICK_SMOKER_ITEM;
    }

    public static void init() {}

    private static Item register(String name, Supplier<Block> block) {
        return Registry.register(BuiltInRegistries.ITEM, Constants.id(name), new BlockItem(block.get(), new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), Constants.id(name)))));
    }

}
