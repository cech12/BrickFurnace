package de.cech12.brickfurnace;

import de.cech12.brickfurnace.blockentity.AbstractBrickFurnaceBlockEntity;
import de.cech12.brickfurnace.crafting.BrickBlastingRecipe;
import de.cech12.brickfurnace.crafting.BrickSmeltingRecipe;
import de.cech12.brickfurnace.crafting.BrickSmokingRecipe;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

/**
 * Class that contains all common constants.
 */
public class Constants {

    /** mod id */
    public static final String MOD_ID = "brickfurnace";
    /** mod name*/
    public static final String MOD_NAME = "Brick Furnace";
    /** Logger instance */
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static final String BRICK_FURNACE_NAME = "brick_furnace";
    public static final String BRICK_BLAST_FURNACE_NAME = "brick_blast_furnace";
    public static final String BRICK_SMOKER_NAME = "brick_smoker";

    public static final String BLASTING_NAME = "blasting";
    public static final String SMELTING_NAME = "smelting";
    public static final String SMOKING_NAME = "smoking";

    public static Supplier<Block> BRICK_FURNACE_BLOCK;
    public static Supplier<Block> BRICK_BLAST_FURNACE_BLOCK;
    public static Supplier<Block> BRICK_SMOKER_BLOCK;

    public static Supplier<BlockEntityType<? extends AbstractBrickFurnaceBlockEntity>> BRICK_FURNACE_BLOCK_ENTITY_TYPE;
    public static Supplier<BlockEntityType<? extends AbstractBrickFurnaceBlockEntity>> BRICK_BLAST_FURNACE_BLOCK_ENTITY_TYPE;
    public static Supplier<BlockEntityType<? extends AbstractBrickFurnaceBlockEntity>> BRICK_SMOKER_BLOCK_ENTITY_TYPE;

    public static Supplier<Item> BRICK_FURNACE_ITEM;
    public static Supplier<Item> BRICK_BLAST_FURNACE_ITEM;
    public static Supplier<Item> BRICK_SMOKER_ITEM;

    public static Supplier<RecipeType<BrickBlastingRecipe>> BLASTING_RECIPE_TYPE;
    public static Supplier<RecipeType<BrickSmeltingRecipe>> SMELTING_RECIPE_TYPE;
    public static Supplier<RecipeType<BrickSmokingRecipe>> SMOKING_RECIPE_TYPE;

    private Constants() {}

    public static Identifier id(String name) {
        return Identifier.fromNamespaceAndPath(MOD_ID, name);
    }

}