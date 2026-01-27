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
import org.jetbrains.annotations.NotNull;

public class BrickSmeltingRecipe extends AbstractCookingRecipe {

    public static final AbstractCookingRecipe.Serializer<BrickSmeltingRecipe> SERIALIZER = new AbstractCookingRecipe.Serializer<>(BrickSmeltingRecipe::new, 200);

    public BrickSmeltingRecipe(String p_i50031_2_, CookingBookCategory category, Ingredient p_i50031_3_, ItemStack p_i50031_4_, float p_i50031_5_, int p_i50031_6_) {
        super(p_i50031_2_, category, p_i50031_3_, p_i50031_4_, p_i50031_5_, p_i50031_6_);
    }

    public static BrickSmeltingRecipe convert(@NotNull SmeltingRecipe recipe, RegistryAccess registryAccess) {
        return new BrickSmeltingRecipe(recipe.group(), recipe.category(), recipe.input(), recipe.assemble(new SingleRecipeInput(new ItemStack(recipe.input().items().findFirst().get())), registryAccess), recipe.experience(), (int) (recipe.cookingTime() * Services.CONFIG.getCookTimeFactor()));
    }

    @Override
    @NotNull
    public RecipeType<? extends AbstractCookingRecipe> getType() {
        return Constants.SMELTING_RECIPE_TYPE.get();
    }

    @Override
    @NotNull
    public RecipeBookCategory recipeBookCategory() {
        return switch (this.category()) {
            case BLOCKS -> RecipeBookCategories.FURNACE_BLOCKS;
            case FOOD -> RecipeBookCategories.FURNACE_FOOD;
            case MISC -> RecipeBookCategories.FURNACE_MISC;
        };
    }

    @Override
    @NotNull
    protected Item furnaceIcon() {
        return Constants.BRICK_FURNACE_BLOCK.get().asItem();
    }

    @Override
    @NotNull
    public RecipeSerializer<? extends AbstractCookingRecipe> getSerializer() {
        return SERIALIZER;
    }


}
