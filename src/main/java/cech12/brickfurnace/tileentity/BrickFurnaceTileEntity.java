package cech12.brickfurnace.tileentity;

import cech12.brickfurnace.api.tileentity.BrickFurnaceTileEntities;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class BrickFurnaceTileEntity extends AbstractFurnaceTileEntity {

    public BrickFurnaceTileEntity() {
        super(BrickFurnaceTileEntities.BRICK_FURNACE, IRecipeType.SMELTING);
    }

    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("block.brickfurnace.brick_furnace");
    }

    protected Container createMenu(int id, PlayerInventory player) {
        return new FurnaceContainer(id, player, this, this.furnaceData);
    }

}
