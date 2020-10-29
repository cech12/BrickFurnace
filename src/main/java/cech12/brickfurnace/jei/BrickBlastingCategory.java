package cech12.brickfurnace.jei;

import cech12.brickfurnace.api.block.BrickFurnaceBlocks;
import cech12.brickfurnace.api.crafting.RecipeTypes;
import cech12.brickfurnace.crafting.BrickBlastingRecipe;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.plugins.vanilla.cooking.AbstractCookingCategory;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class BrickBlastingCategory extends AbstractCookingCategory<BrickBlastingRecipe> {

    public BrickBlastingCategory(IGuiHelper guiHelper) {
        super(guiHelper, BrickFurnaceBlocks.BRICK_BLAST_FURNACE, "gui.jei.category.blasting", 100);
    }

    @Override
    @Nonnull
    public ResourceLocation getUid() {
        return RecipeTypes.BLASTING_ID;
    }

    @Override
    @Nonnull
    public Class<? extends BrickBlastingRecipe> getRecipeClass() {
        return BrickBlastingRecipe.class;
    }
}
