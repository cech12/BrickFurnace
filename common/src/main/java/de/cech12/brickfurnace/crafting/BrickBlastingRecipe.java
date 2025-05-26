package de.cech12.brickfurnace.crafting;

import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.platform.Services;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;

import javax.annotation.Nonnull;

public class BrickBlastingRecipe extends AbstractCookingRecipe {

    public static final RecipeSerializer<BrickBlastingRecipe> SERIALIZER = new AbstractCookingRecipe.Serializer<>(BrickBlastingRecipe::new, 100);

    public BrickBlastingRecipe(String p_i50031_2_, CookingBookCategory category, Ingredient p_i50031_3_, ItemStack p_i50031_4_, float p_i50031_5_, int p_i50031_6_) {
        super(p_i50031_2_, category, p_i50031_3_, p_i50031_4_, p_i50031_5_, p_i50031_6_);
    }

    public static BrickBlastingRecipe convert(@Nonnull BlastingRecipe recipe, RegistryAccess registryAccess) {
        return new BrickBlastingRecipe(recipe.group(), recipe.category(), recipe.input(), recipe.assemble(new SingleRecipeInput(new ItemStack(recipe.input().items().findFirst().get())), registryAccess), recipe.experience(), (int) (recipe.cookingTime() * Services.CONFIG.getCookTimeFactor()));
    }

    @Override
    @Nonnull
    public RecipeType<? extends AbstractCookingRecipe> getType() {
        return Constants.BLASTING_RECIPE_TYPE.get();
    }

    @Override
    @Nonnull
    public RecipeBookCategory recipeBookCategory() {
        return switch (this.category()) {
            case BLOCKS -> RecipeBookCategories.BLAST_FURNACE_BLOCKS;
            case FOOD, MISC -> RecipeBookCategories.BLAST_FURNACE_MISC;
        };
    }

    @Override
    @Nonnull
    public Item furnaceIcon() {
        return Constants.BRICK_BLAST_FURNACE_BLOCK.get().asItem();
    }

    @Override
    @Nonnull
    public RecipeSerializer<? extends AbstractCookingRecipe> getSerializer() {
        return RecipeSerializer.BLASTING_RECIPE;
    }

}
