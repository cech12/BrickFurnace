package cech12.brickfurnace.tileentity;

import cech12.brickfurnace.api.crafting.RecipeTypes;
import cech12.brickfurnace.api.tileentity.BrickFurnaceTileEntities;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.BlastFurnaceContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nonnull;

public class BrickBlastFurnaceTileEntity extends AbstractBrickFurnaceTileEntity {

    public BrickBlastFurnaceTileEntity() {
        super(BrickFurnaceTileEntities.BRICK_BLAST_FURNACE, RecipeTypes.BLASTING, IRecipeType.BLASTING);
    }

    @Override
    @Nonnull
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("block.brickfurnace.brick_blast_furnace");
    }

    @Override
    @Nonnull
    protected Container createMenu(int id, @Nonnull PlayerInventory player) {
        return new BlastFurnaceContainer(id, player, this, this.furnaceData);
    }

}
