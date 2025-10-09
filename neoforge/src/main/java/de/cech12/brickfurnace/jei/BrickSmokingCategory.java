package de.cech12.brickfurnace.jei;

import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.crafting.BrickSmokingRecipe;
import de.cech12.brickfurnace.platform.Services;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.types.IRecipeHolderType;
import mezz.jei.library.plugins.vanilla.cooking.AbstractCookingCategory;

public class BrickSmokingCategory extends AbstractCookingCategory<BrickSmokingRecipe> {

    public BrickSmokingCategory(IGuiHelper guiHelper) {
        super(guiHelper, new IRecipeHolderType.JeiRecipeHolderType<>(Constants.id(Constants.SMOKING_NAME)),
                Constants.BRICK_SMOKER_BLOCK.get(), "gui.jei.category.smoking", (int) (100 * Services.CONFIG.getCookTimeFactor()));
    }

}
