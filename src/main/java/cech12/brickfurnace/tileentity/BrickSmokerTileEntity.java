package cech12.brickfurnace.tileentity;

import cech12.brickfurnace.api.crafting.RecipeTypes;
import cech12.brickfurnace.api.tileentity.BrickFurnaceTileEntities;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.SmokerContainer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nonnull;

public class BrickSmokerTileEntity extends AbstractBrickFurnaceTileEntity {

    public BrickSmokerTileEntity() {
        super(BrickFurnaceTileEntities.BRICK_SMOKER, RecipeTypes.SMOKING, IRecipeType.SMOKING);
    }

    @Override
    @Nonnull
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("block.brickfurnace.brick_smoker");
    }

    @Override
    @Nonnull
    protected Container createMenu(int id, @Nonnull PlayerInventory player) {
        return new SmokerContainer(id, player, this, this.furnaceData);
    }

}
