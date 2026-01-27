package de.cech12.brickfurnace.jei;

import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.crafting.BrickBlastingRecipe;
import de.cech12.brickfurnace.crafting.BrickSmeltingRecipe;
import de.cech12.brickfurnace.crafting.BrickSmokingRecipe;
import de.cech12.brickfurnace.platform.Services;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeMap;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

@JeiPlugin
public class BrickFurnaceJEIPlugin implements IModPlugin {

    private static BrickSmeltingCategory smeltingRecipeType;
    private static BrickSmokingCategory smokingRecipeType;
    private static BrickBlastingCategory blastingRecipeType;

    @Override
    @NotNull
    public Identifier getPluginUid() {
        return Constants.id("plugin_" + Constants.MOD_ID);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        smeltingRecipeType = new BrickSmeltingCategory(guiHelper);
        smokingRecipeType = new BrickSmokingCategory(guiHelper);
        blastingRecipeType = new BrickBlastingCategory(guiHelper);
        registration.addRecipeCategories(
                smeltingRecipeType,
                smokingRecipeType,
                blastingRecipeType);
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        if (server != null) {
            RecipeMap recipeMap = server.getRecipeManager().recipeMap();
            registration.addRecipes(smeltingRecipeType.getRecipeType(), recipeMap.byType(Constants.SMELTING_RECIPE_TYPE.get()).stream().toList());
            registration.addRecipes(smokingRecipeType.getRecipeType(), recipeMap.byType(Constants.SMOKING_RECIPE_TYPE.get()).stream().toList());
            registration.addRecipes(blastingRecipeType.getRecipeType(), recipeMap.byType(Constants.BLASTING_RECIPE_TYPE.get()).stream().toList());

            if (Services.CONFIG.areVanillaRecipesEnabled()) {
                registration.addRecipes(smeltingRecipeType.getRecipeType(), recipeMap.byType(RecipeType.SMELTING).stream()
                        .filter(recipe -> Services.CONFIG.isRecipeAllowed(recipe.id().identifier()))
                        .map(recipe -> new RecipeHolder<>(recipe.id(), BrickSmeltingRecipe.convert(recipe.value(), server.registryAccess())))
                        .collect(Collectors.toList()));
                registration.addRecipes(smokingRecipeType.getRecipeType(), recipeMap.byType(RecipeType.SMOKING).stream()
                        .filter(recipe -> Services.CONFIG.isRecipeAllowed(recipe.id().identifier()))
                        .map(recipe -> new RecipeHolder<>(recipe.id(), BrickSmokingRecipe.convert(recipe.value(), server.registryAccess())))
                        .collect(Collectors.toList()));
                registration.addRecipes(blastingRecipeType.getRecipeType(), recipeMap.byType(RecipeType.BLASTING).stream()
                        .filter(recipe -> Services.CONFIG.isRecipeAllowed(recipe.id().identifier()))
                        .map(recipe -> new RecipeHolder<>(recipe.id(), BrickBlastingRecipe.convert(recipe.value(), server.registryAccess())))
                        .collect(Collectors.toList()));
            }
        }
    }

    @Override
    public void registerRecipeCatalysts(@NotNull IRecipeCatalystRegistration registration) {
        registration.addCraftingStation(smeltingRecipeType.getRecipeType(), new ItemStack(Constants.BRICK_FURNACE_BLOCK.get()));
        registration.addCraftingStation(RecipeTypes.SMELTING_FUEL, new ItemStack(Constants.BRICK_FURNACE_BLOCK.get()));
        registration.addCraftingStation(smokingRecipeType.getRecipeType(), new ItemStack(Constants.BRICK_SMOKER_BLOCK.get()));
        registration.addCraftingStation(RecipeTypes.SMOKING_FUEL, new ItemStack(Constants.BRICK_SMOKER_BLOCK.get()));
        registration.addCraftingStation(blastingRecipeType.getRecipeType(), new ItemStack(Constants.BRICK_BLAST_FURNACE_BLOCK.get()));
        registration.addCraftingStation(RecipeTypes.BLASTING_FUEL, new ItemStack(Constants.BRICK_BLAST_FURNACE_BLOCK.get()));
    }

}
