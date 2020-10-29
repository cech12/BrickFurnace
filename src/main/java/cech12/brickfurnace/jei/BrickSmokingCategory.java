package cech12.brickfurnace.jei;

import cech12.brickfurnace.api.block.BrickFurnaceBlocks;
import cech12.brickfurnace.api.crafting.RecipeTypes;
import cech12.brickfurnace.config.ServerConfig;
import cech12.brickfurnace.crafting.BrickSmokingRecipe;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.plugins.vanilla.cooking.AbstractCookingCategory;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class BrickSmokingCategory extends AbstractCookingCategory<BrickSmokingRecipe> {

    public BrickSmokingCategory(IGuiHelper guiHelper) {
        super(guiHelper, BrickFurnaceBlocks.BRICK_SMOKER, "gui.jei.category.smoking", (int) (100 * ServerConfig.COOK_TIME_FACTOR.get()));
    }

    @Override
    @Nonnull
    public ResourceLocation getUid() {
        return RecipeTypes.SMOKING_ID;
    }

    @Override
    @Nonnull
    public Class<? extends BrickSmokingRecipe> getRecipeClass() {
        return BrickSmokingRecipe.class;
    }
}
