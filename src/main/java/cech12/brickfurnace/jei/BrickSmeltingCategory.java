package cech12.brickfurnace.jei;

import cech12.brickfurnace.config.ServerConfig;
import cech12.brickfurnace.crafting.BrickSmeltingRecipe;
import cech12.brickfurnace.init.ModBlocks;
import cech12.brickfurnace.init.ModRecipeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.library.plugins.vanilla.cooking.AbstractCookingCategory;

public class BrickSmeltingCategory extends AbstractCookingCategory<BrickSmeltingRecipe> {

    public BrickSmeltingCategory(IGuiHelper guiHelper) {
        super(guiHelper, new RecipeType<>(ModRecipeTypes.SMELTING.getId(), BrickSmeltingRecipe.class),
                ModBlocks.BRICK_FURNACE.get(), "gui.jei.category.smelting", (int) (200 * ServerConfig.COOK_TIME_FACTOR.get()));
    }

}
