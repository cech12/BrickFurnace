package de.cech12.brickfurnace.jei;
/*
import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.crafting.BrickBlastingRecipe;
import de.cech12.brickfurnace.crafting.BrickSmeltingRecipe;
import de.cech12.brickfurnace.crafting.BrickSmokingRecipe;
import de.cech12.brickfurnace.platform.Services;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;

import javax.annotation.Nonnull;
import java.util.stream.Collectors;

@JeiPlugin
public class BrickFurnaceJEIPlugin implements IModPlugin {

    private static BrickSmeltingCategory smeltingRecipeType;
    private static BrickSmokingCategory smokingRecipeType;
    private static BrickBlastingCategory blastingRecipeType;

    @Override
    @Nonnull
    public ResourceLocation getPluginUid() {
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
    public void registerRecipes(@Nonnull IRecipeRegistration registration) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player != null) {
            RecipeManager manager = player.connection.getRecipeManager();
            registration.addRecipes(smeltingRecipeType.getRecipeType(), manager.getAllRecipesFor(Constants.SMELTING_RECIPE_TYPE.get()));
            registration.addRecipes(smokingRecipeType.getRecipeType(), manager.getAllRecipesFor(Constants.SMOKING_RECIPE_TYPE.get()));
            registration.addRecipes(blastingRecipeType.getRecipeType(), manager.getAllRecipesFor(Constants.BLASTING_RECIPE_TYPE.get()));

            if (Services.CONFIG.areVanillaRecipesEnabled()) {
                registration.addRecipes(smeltingRecipeType.getRecipeType(), manager.getAllRecipesFor(RecipeType.SMELTING).stream()
                        .filter(recipe -> Services.CONFIG.isRecipeAllowed(recipe.id()))
                        .map(recipe -> new RecipeHolder<>(recipe.id(), BrickSmeltingRecipe.convert(recipe.value(), player.level().registryAccess())))
                        .collect(Collectors.toList()));
                registration.addRecipes(smokingRecipeType.getRecipeType(), manager.getAllRecipesFor(RecipeType.SMOKING).stream()
                        .filter(recipe -> Services.CONFIG.isRecipeAllowed(recipe.id()))
                        .map(recipe -> new RecipeHolder<>(recipe.id(), BrickSmokingRecipe.convert(recipe.value(), player.level().registryAccess())))
                        .collect(Collectors.toList()));
                registration.addRecipes(blastingRecipeType.getRecipeType(), manager.getAllRecipesFor(RecipeType.BLASTING).stream()
                        .filter(recipe -> Services.CONFIG.isRecipeAllowed(recipe.id()))
                        .map(recipe -> new RecipeHolder<>(recipe.id(), BrickBlastingRecipe.convert(recipe.value(), player.level().registryAccess())))
                        .collect(Collectors.toList()));
            }
        }
    }

    @Override
    public void registerRecipeCatalysts(@Nonnull IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(Constants.BRICK_FURNACE_BLOCK.get()),
                smeltingRecipeType.getRecipeType(), mezz.jei.api.constants.RecipeTypes.FUELING);
        registration.addRecipeCatalyst(new ItemStack(Constants.BRICK_SMOKER_BLOCK.get()),
                smokingRecipeType.getRecipeType(), mezz.jei.api.constants.RecipeTypes.FUELING);
        registration.addRecipeCatalyst(new ItemStack(Constants.BRICK_BLAST_FURNACE_BLOCK.get()),
                blastingRecipeType.getRecipeType(), mezz.jei.api.constants.RecipeTypes.FUELING);
    }

}
 */
