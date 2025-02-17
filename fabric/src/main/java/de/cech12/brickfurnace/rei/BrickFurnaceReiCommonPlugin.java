package de.cech12.brickfurnace.rei;

import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.crafting.BrickBlastingRecipe;
import de.cech12.brickfurnace.crafting.BrickSmeltingRecipe;
import de.cech12.brickfurnace.crafting.BrickSmokingRecipe;
import de.cech12.brickfurnace.platform.Services;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.plugins.REICommonPlugin;
import me.shedaniel.rei.api.common.registry.display.ServerDisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.plugin.common.displays.cooking.DefaultCookingDisplay;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.crafting.SmokingRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
public class BrickFurnaceReiCommonPlugin implements REICommonPlugin {

    public static final CategoryIdentifier<DefaultCookingDisplay> SMELTING_ID = CategoryIdentifier.of(Constants.MOD_ID, Constants.SMELTING_NAME);
    public static final CategoryIdentifier<DefaultCookingDisplay> SMOKING_ID = CategoryIdentifier.of(Constants.MOD_ID, Constants.SMOKING_NAME);
    public static final CategoryIdentifier<DefaultCookingDisplay> BLASTING_ID = CategoryIdentifier.of(Constants.MOD_ID, Constants.BLASTING_NAME);

    @Override
    public void registerDisplays(ServerDisplayRegistry registry) {
        registry.beginRecipeFiller(BrickSmeltingRecipe.class).filterType(Constants.SMELTING_RECIPE_TYPE.get()).fill(BrickSmeltingDisplay::new);
        registry.beginRecipeFiller(BrickSmokingRecipe.class).filterType(Constants.SMOKING_RECIPE_TYPE.get()).fill(BrickSmokingDisplay::new);
        registry.beginRecipeFiller(BrickBlastingRecipe.class).filterType(Constants.BLASTING_RECIPE_TYPE.get()).fill(BrickBlastingDisplay::new);
        if (Services.CONFIG.areVanillaRecipesEnabled()) {
            registry.beginRecipeFiller(SmeltingRecipe.class).filterType(RecipeType.SMELTING).filter(recipeHolder -> Services.CONFIG.isRecipeAllowed(recipeHolder.id().location())).fill(BrickSmeltingDisplay::new);
            registry.beginRecipeFiller(SmokingRecipe.class).filterType(RecipeType.SMOKING).filter(recipeHolder -> Services.CONFIG.isRecipeAllowed(recipeHolder.id().location())).fill(BrickSmokingDisplay::new);
            registry.beginRecipeFiller(BlastingRecipe.class).filterType(RecipeType.BLASTING).filter(recipeHolder -> Services.CONFIG.isRecipeAllowed(recipeHolder.id().location())).fill(BrickBlastingDisplay::new);
        }
    }

    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
        registry.register(Constants.id(Constants.SMELTING_NAME), BrickSmeltingDisplay.SERIALIZER);
        registry.register(Constants.id(Constants.SMOKING_NAME), BrickSmokingDisplay.SERIALIZER);
        registry.register(Constants.id(Constants.BLASTING_NAME), BrickBlastingDisplay.SERIALIZER);
    }

    static class BrickSmeltingDisplay extends DefaultCookingDisplay {
        public static DisplaySerializer<BrickSmeltingDisplay> SERIALIZER = serializer(BrickSmeltingDisplay::new);

        public BrickSmeltingDisplay(RecipeHolder<? extends AbstractCookingRecipe> recipe) {
            super(List.of(EntryIngredients.ofIngredient((recipe.value()).input())), List.of(EntryIngredients.of(recipe.value().assemble(new SingleRecipeInput(new ItemStack(recipe.value().input().items().getFirst().value())), null))),
                    Optional.of(recipe.id().location()), recipe.value().experience(), recipe.value() instanceof BrickSmeltingRecipe ? recipe.value().cookingTime() : recipe.value().cookingTime() * Services.CONFIG.getCookTimeFactor());
        }

        public BrickSmeltingDisplay(List<EntryIngredient> input, List<EntryIngredient> output, Optional<ResourceLocation> id, float xp, double cookTime) {
            super(input, output, id, xp, cookTime);
        }

        @Override
        public CategoryIdentifier<?> getCategoryIdentifier() {
            return SMELTING_ID;
        }

        @Override
        public @Nullable DisplaySerializer<? extends Display> getSerializer() {
            return SERIALIZER;
        }
    }

    static class BrickSmokingDisplay extends DefaultCookingDisplay {
        public static DisplaySerializer<BrickSmokingDisplay> SERIALIZER = serializer(BrickSmokingDisplay::new);

        public BrickSmokingDisplay(RecipeHolder<? extends AbstractCookingRecipe> recipe) {
            super(List.of(EntryIngredients.ofIngredient((recipe.value()).input())), List.of(EntryIngredients.of(recipe.value().assemble(new SingleRecipeInput(new ItemStack(recipe.value().input().items().getFirst().value())), null))),
                    Optional.of(recipe.id().location()), recipe.value().experience(), recipe.value() instanceof BrickSmokingRecipe ? recipe.value().cookingTime() : recipe.value().cookingTime() * Services.CONFIG.getCookTimeFactor());
        }

        public BrickSmokingDisplay(List<EntryIngredient> input, List<EntryIngredient> output, Optional<ResourceLocation> id, float xp, double cookTime) {
            super(input, output, id, xp, cookTime);
        }

        @Override
        public CategoryIdentifier<?> getCategoryIdentifier() {
            return SMOKING_ID;
        }

        @Override
        public @Nullable DisplaySerializer<? extends Display> getSerializer() {
            return SERIALIZER;
        }
    }

    static class BrickBlastingDisplay extends DefaultCookingDisplay {
        public static DisplaySerializer<BrickBlastingDisplay> SERIALIZER = serializer(BrickBlastingDisplay::new);

        public BrickBlastingDisplay(RecipeHolder<? extends AbstractCookingRecipe> recipe) {
            super(List.of(EntryIngredients.ofIngredient((recipe.value()).input())), List.of(EntryIngredients.of(recipe.value().assemble(new SingleRecipeInput(new ItemStack(recipe.value().input().items().getFirst().value())), null))),
                    Optional.of(recipe.id().location()), recipe.value().experience(), recipe.value() instanceof BrickBlastingRecipe ? recipe.value().cookingTime() : recipe.value().cookingTime() * Services.CONFIG.getCookTimeFactor());
        }

        public BrickBlastingDisplay(List<EntryIngredient> input, List<EntryIngredient> output, Optional<ResourceLocation> id, float xp, double cookTime) {
            super(input, output, id, xp, cookTime);
        }

        @Override
        public CategoryIdentifier<?> getCategoryIdentifier() {
            return BLASTING_ID;
        }

        @Override
        public @Nullable DisplaySerializer<? extends Display> getSerializer() {
            return SERIALIZER;
        }
    }

}
