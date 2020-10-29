package cech12.brickfurnace.api.crafting;

import cech12.brickfurnace.BrickFurnaceMod;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;

public class RecipeTypes {

    public final static ResourceLocation BLASTING_ID = new ResourceLocation(BrickFurnaceMod.MOD_ID, "blasting");
    public final static ResourceLocation SMELTING_ID = new ResourceLocation(BrickFurnaceMod.MOD_ID, "smelting");
    public final static ResourceLocation SMOKING_ID = new ResourceLocation(BrickFurnaceMod.MOD_ID, "smoking");

    public static IRecipeType<? extends AbstractCookingRecipe> BLASTING;
    public static IRecipeType<? extends AbstractCookingRecipe> SMELTING;
    public static IRecipeType<? extends AbstractCookingRecipe> SMOKING;

}
