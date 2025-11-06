package de.cech12.brickfurnace.jei;

import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.crafting.BrickBlastingRecipe;
import de.cech12.brickfurnace.platform.Services;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.types.IRecipeHolderType;
import mezz.jei.library.plugins.vanilla.cooking.AbstractCookingCategory;

public class BrickBlastingCategory extends AbstractCookingCategory<BrickBlastingRecipe> {

    public BrickBlastingCategory(IGuiHelper guiHelper) {
        super(guiHelper, new IRecipeHolderType.JeiRecipeHolderType<>(Constants.id(Constants.BLASTING_NAME)),
                Constants.BRICK_BLAST_FURNACE_BLOCK.get(), "gui.jei.category.blasting", (int) (100 * Services.CONFIG.getCookTimeFactor()));
    }

}
