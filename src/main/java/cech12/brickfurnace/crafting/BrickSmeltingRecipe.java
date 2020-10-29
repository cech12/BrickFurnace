package cech12.brickfurnace.crafting;

import cech12.brickfurnace.BrickFurnaceMod;
import cech12.brickfurnace.api.block.BrickFurnaceBlocks;
import cech12.brickfurnace.api.crafting.RecipeTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class BrickSmeltingRecipe extends AbstractCookingRecipe {

    public static final CookingRecipeSerializer<BrickSmeltingRecipe> SERIALIZER = new CookingRecipeSerializer<>(BrickSmeltingRecipe::new, 200);
    static {
        SERIALIZER.setRegistryName(new ResourceLocation(BrickFurnaceMod.MOD_ID, "smelting"));
    }

    public BrickSmeltingRecipe(ResourceLocation p_i50031_1_, String p_i50031_2_, Ingredient p_i50031_3_, ItemStack p_i50031_4_, float p_i50031_5_, int p_i50031_6_) {
        super(RecipeTypes.SMELTING, p_i50031_1_, p_i50031_2_, p_i50031_3_, p_i50031_4_, p_i50031_5_, p_i50031_6_);
    }

    @Override
    @Nonnull
    public ItemStack getIcon() {
        return new ItemStack(BrickFurnaceBlocks.BRICK_FURNACE);
    }

    @Override
    @Nonnull
    public IRecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

}
