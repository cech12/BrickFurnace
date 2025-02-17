package de.cech12.brickfurnace.init;

import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.block.BrickBlastFurnaceBlock;
import de.cech12.brickfurnace.block.BrickFurnaceBlock;
import de.cech12.brickfurnace.block.BrickSmokerBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;

import java.util.function.ToIntFunction;

public final class ModBlocks {

    private static final Block BRICK_FURNACE_BLOCK = register(Constants.BRICK_FURNACE_NAME, new BrickFurnaceBlock(BlockBehaviour.Properties.of().setId(id(Constants.BRICK_FURNACE_NAME)).mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().strength(2.0F, 6.0F).lightLevel(getLightLevelWhenLit(13))));
    private static final Block BRICK_BLAST_FURNACE_BLOCK = register(Constants.BRICK_BLAST_FURNACE_NAME, new BrickBlastFurnaceBlock(BlockBehaviour.Properties.of().setId(id(Constants.BRICK_BLAST_FURNACE_NAME)).mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().strength(2.0F, 6.0F).lightLevel(getLightLevelWhenLit(13))));
    private static final Block BRICK_SMOKER_BLOCK = register(Constants.BRICK_SMOKER_NAME, new BrickSmokerBlock(BlockBehaviour.Properties.of().setId(id(Constants.BRICK_SMOKER_NAME)).mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().strength(2.0F, 6.0F).lightLevel(getLightLevelWhenLit(13))));

    static {
        Constants.BRICK_FURNACE_BLOCK = () -> BRICK_FURNACE_BLOCK;
        Constants.BRICK_BLAST_FURNACE_BLOCK = () -> BRICK_BLAST_FURNACE_BLOCK;
        Constants.BRICK_SMOKER_BLOCK = () -> BRICK_SMOKER_BLOCK;
    }

    public static void init() {}

    private static Block register(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, Constants.id(name), block);
    }

    private static ResourceKey<Block> id(String name) {
        return ResourceKey.create(BuiltInRegistries.BLOCK.key(), Constants.id(name));
    }

    private static ToIntFunction<BlockState> getLightLevelWhenLit(final int lightLevel) {
        return (blockState) -> blockState.getValue(BlockStateProperties.LIT) ? lightLevel : 0;
    }

}