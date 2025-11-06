package de.cech12.brickfurnace.blockentity;

import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.platform.Services;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public class BrickFurnaceBlockEntity extends AbstractBrickFurnaceBlockEntity {

    public BrickFurnaceBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(Constants.BRICK_FURNACE_BLOCK_ENTITY_TYPE.get(), blockPos, blockState, Constants.SMELTING_RECIPE_TYPE.get(), RecipeType.SMELTING);
    }

    @Override
    @Nonnull
    protected Component getDefaultName() {
        return Component.translatable("block.brickfurnace.brick_furnace");
    }

    @Override
    protected int getBurnDuration(@Nonnull ItemStack stack) {
        return (int) (super.getBurnDuration(stack) * Services.CONFIG.getBurnTimeFactor() * Services.CONFIG.getCookTimeFactor());
    }

    @Override
    @Nonnull
    protected AbstractContainerMenu createMenu(int id, @Nonnull Inventory player) {
        return new FurnaceMenu(id, player, this, this.dataAccess);
    }

}
