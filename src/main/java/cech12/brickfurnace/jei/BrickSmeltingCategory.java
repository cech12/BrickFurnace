package cech12.brickfurnace.jei;

import cech12.brickfurnace.api.block.BrickFurnaceBlocks;
import cech12.brickfurnace.api.crafting.RecipeTypes;
import cech12.brickfurnace.crafting.BrickSmeltingRecipe;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.plugins.vanilla.cooking.AbstractCookingCategory;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class BrickSmeltingCategory extends AbstractCookingCategory<BrickSmeltingRecipe> {

    public BrickSmeltingCategory(IGuiHelper guiHelper) {
        super(guiHelper, BrickFurnaceBlocks.BRICK_FURNACE, "gui.jei.category.smelting", 200);
    }

    @Override
    @Nonnull
    public ResourceLocation getUid() {
        return RecipeTypes.SMELTING_ID;
    }

    @Override
    @Nonnull
    public Class<? extends BrickSmeltingRecipe> getRecipeClass() {
        return BrickSmeltingRecipe.class;
    }
}
