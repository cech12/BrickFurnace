package de.cech12.brickfurnace.crafting;

import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.platform.Services;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.SmokingRecipe;

import javax.annotation.Nonnull;

public class BrickSmokingRecipe extends AbstractCookingRecipe {

    public static final AbstractCookingRecipe.Serializer<BrickSmokingRecipe> SERIALIZER = new AbstractCookingRecipe.Serializer<>(BrickSmokingRecipe::new, 100);

    public BrickSmokingRecipe(String p_i50031_2_, CookingBookCategory category, Ingredient p_i50031_3_, ItemStack p_i50031_4_, float p_i50031_5_, int p_i50031_6_) {
        super(p_i50031_2_, category, p_i50031_3_, p_i50031_4_, p_i50031_5_, p_i50031_6_);
    }

    public static BrickSmokingRecipe convert(@Nonnull SmokingRecipe recipe, RegistryAccess registryAccess) {
        return new BrickSmokingRecipe(recipe.group(), recipe.category(), recipe.input(), recipe.assemble(new SingleRecipeInput(new ItemStack(recipe.input().items().getFirst())), registryAccess), recipe.experience(), (int) (recipe.cookingTime() * Services.CONFIG.getCookTimeFactor()));
    }

    @Override
    @Nonnull
    public RecipeSerializer<? extends AbstractCookingRecipe> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public RecipeType<? extends AbstractCookingRecipe> getType() {
        return Constants.SMOKING_RECIPE_TYPE.get();
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.SMOKER_FOOD;
    }

    @Override
    @Nonnull
    protected Item furnaceIcon() {
        return Constants.BRICK_SMOKER_BLOCK.get().asItem();
    }

}
