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
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.SmokingRecipe;
import org.jetbrains.annotations.NotNull;

public class BrickSmokingRecipe extends AbstractCookingRecipe {

    public static final MapCodec<BrickSmokingRecipe> MAP_CODEC = cookingMapCodec(BrickSmokingRecipe::new, 100);
    public static final StreamCodec<RegistryFriendlyByteBuf, BrickSmokingRecipe> STREAM_CODEC = cookingStreamCodec(BrickSmokingRecipe::new);
    public static final RecipeSerializer<BrickSmokingRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

    public BrickSmokingRecipe(Recipe.CommonInfo commonInfo, AbstractCookingRecipe.CookingBookInfo bookInfo, Ingredient ingredient, ItemStackTemplate result, float experience, int cookingTime) {
        super(commonInfo, bookInfo, ingredient, result, experience, cookingTime);
    }

    public static BrickSmokingRecipe convert(@NotNull SmokingRecipe recipe) {
        ItemStack resultStack = recipe.assemble(new SingleRecipeInput(new ItemStack(recipe.input().items().findFirst().get())));
        return new BrickSmokingRecipe(new CommonInfo(recipe.showNotification()), new CookingBookInfo(recipe.category(), recipe.group()), recipe.input(), ItemStackTemplate.fromNonEmptyStack(resultStack), recipe.experience(), (int) (recipe.cookingTime() * Services.CONFIG.getCookTimeFactor()));
    }

    @Override
    @NotNull
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
    @NotNull
    protected Item furnaceIcon() {
        return Constants.BRICK_SMOKER_BLOCK.get().asItem();
    }

}
