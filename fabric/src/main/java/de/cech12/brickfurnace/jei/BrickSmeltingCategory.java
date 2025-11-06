package de.cech12.brickfurnace.jei;

import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.crafting.BrickSmeltingRecipe;
import de.cech12.brickfurnace.platform.Services;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.types.IRecipeHolderType;
import mezz.jei.library.plugins.vanilla.cooking.AbstractCookingCategory;

public class BrickSmeltingCategory extends AbstractCookingCategory<BrickSmeltingRecipe> {

    public BrickSmeltingCategory(IGuiHelper guiHelper) {
        super(guiHelper, new IRecipeHolderType.JeiRecipeHolderType<>(Constants.id(Constants.SMELTING_NAME)),
                Constants.BRICK_FURNACE_BLOCK.get(), "gui.jei.category.smelting", (int) (200 * Services.CONFIG.getCookTimeFactor()));
    }

}
