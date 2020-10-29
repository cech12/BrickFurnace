package cech12.brickfurnace.crafting;

import cech12.brickfurnace.api.block.BrickFurnaceBlocks;
import cech12.brickfurnace.api.crafting.RecipeTypes;
import cech12.brickfurnace.config.ServerConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.SmokingRecipe;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class BrickSmokingRecipe extends AbstractCookingRecipe {

    public static final CookingRecipeSerializer<BrickSmokingRecipe> SERIALIZER = new CookingRecipeSerializer<>(BrickSmokingRecipe::new, 100);
    static {
        SERIALIZER.setRegistryName(RecipeTypes.SMOKING_ID);
    }

    public BrickSmokingRecipe(ResourceLocation p_i50031_1_, String p_i50031_2_, Ingredient p_i50031_3_, ItemStack p_i50031_4_, float p_i50031_5_, int p_i50031_6_) {
        super(RecipeTypes.SMOKING, p_i50031_1_, p_i50031_2_, p_i50031_3_, p_i50031_4_, p_i50031_5_, p_i50031_6_);
    }

    public static BrickSmokingRecipe convert(@Nonnull SmokingRecipe recipe) {
        return new BrickSmokingRecipe(recipe.getId(), recipe.getGroup(), recipe.getIngredients().get(0), recipe.getRecipeOutput(), recipe.getExperience(), (int) (recipe.getCookTime() * ServerConfig.COOK_TIME_FACTOR.get()));
    }

    @Override
    @Nonnull
    public ItemStack getIcon() {
        return new ItemStack(BrickFurnaceBlocks.BRICK_SMOKER);
    }

    @Override
    @Nonnull
    public IRecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

}
