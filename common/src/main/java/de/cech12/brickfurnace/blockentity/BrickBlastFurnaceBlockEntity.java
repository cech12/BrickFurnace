package de.cech12.brickfurnace.blockentity;

import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.platform.Services;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.BlastFurnaceMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.FuelValues;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BrickBlastFurnaceBlockEntity extends AbstractBrickFurnaceBlockEntity {

    public BrickBlastFurnaceBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(Constants.BRICK_BLAST_FURNACE_BLOCK_ENTITY_TYPE.get(), blockPos, blockState, Constants.BLASTING_RECIPE_TYPE.get(), RecipeType.BLASTING);
    }

    @Override
    @NotNull
    protected Component getDefaultName() {
        return Component.translatable("block.brickfurnace.brick_blast_furnace");
    }

    @Override
    protected int getBurnDuration(@NotNull FuelValues fuelValues, @NotNull ItemStack stack) {
        return (int) (super.getBurnDuration(fuelValues, stack) * Services.CONFIG.getBurnTimeFactor() * (0.5D * Services.CONFIG.getCookTimeFactor()));
    }

    @Override
    @NotNull
    protected AbstractContainerMenu createMenu(int id, @NotNull Inventory player) {
        return new BlastFurnaceMenu(id, player, this, this.dataAccess);
    }

}
