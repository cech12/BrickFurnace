package cech12.brickfurnace.crafting;

import cech12.brickfurnace.api.block.BrickFurnaceBlocks;
import cech12.brickfurnace.api.crafting.RecipeTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.BlastingRecipe;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class BrickBlastingRecipe extends AbstractCookingRecipe {

    public static final CookingRecipeSerializer<BrickBlastingRecipe> SERIALIZER = new CookingRecipeSerializer<>(BrickBlastingRecipe::new, 100);
    static {
        SERIALIZER.setRegistryName(RecipeTypes.BLASTING_ID);
    }

    public BrickBlastingRecipe(ResourceLocation p_i50031_1_, String p_i50031_2_, Ingredient p_i50031_3_, ItemStack p_i50031_4_, float p_i50031_5_, int p_i50031_6_) {
        super(RecipeTypes.BLASTING, p_i50031_1_, p_i50031_2_, p_i50031_3_, p_i50031_4_, p_i50031_5_, p_i50031_6_);
    }

    public static BrickBlastingRecipe convert(@Nonnull BlastingRecipe recipe) {
        return new BrickBlastingRecipe(recipe.getId(), recipe.getGroup(), recipe.getIngredients().get(0), recipe.getRecipeOutput(), recipe.getExperience(), recipe.getCookTime());
    }

    @Override
    @Nonnull
    public ItemStack getIcon() {
        return new ItemStack(BrickFurnaceBlocks.BRICK_BLAST_FURNACE);
    }

    @Override
    @Nonnull
    public IRecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

}
