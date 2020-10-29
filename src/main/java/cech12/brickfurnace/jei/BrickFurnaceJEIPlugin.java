package cech12.brickfurnace.jei;

import cech12.brickfurnace.BrickFurnaceMod;
import cech12.brickfurnace.api.block.BrickFurnaceBlocks;
import cech12.brickfurnace.api.crafting.RecipeTypes;
import cech12.brickfurnace.config.Config;
import cech12.brickfurnace.crafting.BrickBlastingRecipe;
import cech12.brickfurnace.crafting.BrickSmeltingRecipe;
import cech12.brickfurnace.crafting.BrickSmokingRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.stream.Collectors;

@JeiPlugin
public class BrickFurnaceJEIPlugin implements IModPlugin {

    @Override
    @Nonnull
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(BrickFurnaceMod.MOD_ID, "plugin_" + BrickFurnaceMod.MOD_ID);
    }

    @Override
    public void registerRecipes(@Nonnull IRecipeRegistration registration) {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        if (player != null) {
            RecipeManager manager = player.connection.getRecipeManager();
            registration.addRecipes(manager.func_241447_a_(RecipeTypes.SMELTING), RecipeTypes.SMELTING_ID);
            registration.addRecipes(manager.func_241447_a_(RecipeTypes.SMOKING), RecipeTypes.SMOKING_ID);
            registration.addRecipes(manager.func_241447_a_(RecipeTypes.BLASTING), RecipeTypes.BLASTING_ID);

            if (Config.VANILLA_RECIPES_ENABLED.get()) {
                registration.addRecipes(manager.func_241447_a_(IRecipeType.SMELTING).stream()
                        .filter(recipe -> Config.isRecipeNotBlacklisted(recipe.getId()))
                        .map(BrickSmeltingRecipe::convert)
                        .collect(Collectors.toList()), RecipeTypes.SMELTING_ID);
                registration.addRecipes(manager.func_241447_a_(IRecipeType.SMOKING).stream()
                        .filter(recipe -> Config.isRecipeNotBlacklisted(recipe.getId()))
                        .map(BrickSmokingRecipe::convert)
                        .collect(Collectors.toList()), RecipeTypes.SMOKING_ID);
                registration.addRecipes(manager.func_241447_a_(IRecipeType.BLASTING).stream()
                        .filter(recipe -> Config.isRecipeNotBlacklisted(recipe.getId()))
                        .map(BrickBlastingRecipe::convert)
                        .collect(Collectors.toList()), RecipeTypes.BLASTING_ID);
            }
        }
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(
                new BrickSmeltingCategory(guiHelper),
                new BrickSmokingCategory(guiHelper),
                new BrickBlastingCategory(guiHelper));
    }

    @Override
    public void registerRecipeCatalysts(@Nonnull IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(BrickFurnaceBlocks.BRICK_FURNACE),
                RecipeTypes.SMELTING_ID, VanillaRecipeCategoryUid.FUEL);
        registration.addRecipeCatalyst(new ItemStack(BrickFurnaceBlocks.BRICK_SMOKER),
                RecipeTypes.SMOKING_ID, VanillaRecipeCategoryUid.FUEL);
        registration.addRecipeCatalyst(new ItemStack(BrickFurnaceBlocks.BRICK_BLAST_FURNACE),
                RecipeTypes.BLASTING_ID, VanillaRecipeCategoryUid.FUEL);
    }

}
