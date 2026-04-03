package de.cech12.brickfurnace.crafting;

import com.mojang.serialization.MapCodec;
import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.platform.Services;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import org.jetbrains.annotations.NotNull;

public class BrickBlastingRecipe extends AbstractCookingRecipe {

    public static final MapCodec<BrickSmeltingRecipe> MAP_CODEC = cookingMapCodec(BrickSmeltingRecipe::new, 100);
    public static final StreamCodec<RegistryFriendlyByteBuf, BrickSmeltingRecipe> STREAM_CODEC = cookingStreamCodec(BrickSmeltingRecipe::new);
    public static final RecipeSerializer<BrickSmeltingRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

    public BrickBlastingRecipe(Recipe.CommonInfo commonInfo, AbstractCookingRecipe.CookingBookInfo bookInfo, Ingredient ingredient, ItemStackTemplate result, float experience, int cookingTime) {
        super(commonInfo, bookInfo, ingredient, result, experience, cookingTime);
    }

    public static BrickBlastingRecipe convert(@NotNull BlastingRecipe recipe) {
        ItemStack resultStack = recipe.assemble(new SingleRecipeInput(new ItemStack(recipe.input().items().findFirst().get())));
        return new BrickBlastingRecipe(new CommonInfo(recipe.showNotification()), new CookingBookInfo(recipe.category(), recipe.group()), recipe.input(), ItemStackTemplate.fromNonEmptyStack(resultStack), recipe.experience(), (int) (recipe.cookingTime() * Services.CONFIG.getCookTimeFactor()));
    }

    @Override
    @NotNull
    public RecipeType<? extends AbstractCookingRecipe> getType() {
        return Constants.BLASTING_RECIPE_TYPE.get();
    }

    @Override
    @NotNull
    public RecipeBookCategory recipeBookCategory() {
        return switch (this.category()) {
            case BLOCKS -> RecipeBookCategories.BLAST_FURNACE_BLOCKS;
            case FOOD, MISC -> RecipeBookCategories.BLAST_FURNACE_MISC;
        };
    }

    @Override
    @NotNull
    public Item furnaceIcon() {
        return Constants.BRICK_BLAST_FURNACE_BLOCK.get().asItem();
    }

    @Override
    @NotNull
    public RecipeSerializer<? extends AbstractCookingRecipe> getSerializer() {
        return SERIALIZER;
    }

}
