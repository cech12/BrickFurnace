package cech12.brickfurnace.jei;

import cech12.brickfurnace.BrickFurnaceMod;
import cech12.brickfurnace.api.block.BrickFurnaceBlocks;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

@JeiPlugin
public class BrickFurnaceJEIPlugin implements IModPlugin {

    @Override
    @Nonnull
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(BrickFurnaceMod.MOD_ID, "plugin_" + BrickFurnaceMod.MOD_ID);
    }

    @Override
    public void registerRecipeCatalysts(@Nonnull IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(BrickFurnaceBlocks.BRICK_FURNACE), VanillaRecipeCategoryUid.FURNACE);
        registration.addRecipeCatalyst(new ItemStack(BrickFurnaceBlocks.BRICK_FURNACE), VanillaRecipeCategoryUid.FUEL);

        registration.addRecipeCatalyst(new ItemStack(BrickFurnaceBlocks.BRICK_BLAST_FURNACE), VanillaRecipeCategoryUid.BLASTING);
        registration.addRecipeCatalyst(new ItemStack(BrickFurnaceBlocks.BRICK_BLAST_FURNACE), VanillaRecipeCategoryUid.FUEL);

        registration.addRecipeCatalyst(new ItemStack(BrickFurnaceBlocks.BRICK_SMOKER), VanillaRecipeCategoryUid.SMOKING);
        registration.addRecipeCatalyst(new ItemStack(BrickFurnaceBlocks.BRICK_SMOKER), VanillaRecipeCategoryUid.FUEL);
    }

}
