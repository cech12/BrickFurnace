package de.cech12.brickfurnace.blockentity;

import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.platform.Services;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.SmokerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.FuelValues;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public class BrickSmokerBlockEntity extends AbstractBrickFurnaceBlockEntity {

    public BrickSmokerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(Constants.BRICK_SMOKER_BLOCK_ENTITY_TYPE.get(), blockPos, blockState, Constants.SMOKING_RECIPE_TYPE.get(), RecipeType.SMOKING);
    }

    @Override
    @Nonnull
    protected Component getDefaultName() {
        return Component.translatable("block.brickfurnace.brick_smoker");
    }

    @Override
    protected int getBurnDuration(@Nonnull FuelValues fuelValues, @Nonnull ItemStack stack) {
        return (int) (super.getBurnDuration(fuelValues, stack) * (0.5D * Services.CONFIG.getCookTimeFactor()));
    }

    @Override
    @Nonnull
    protected AbstractContainerMenu createMenu(int id, @Nonnull Inventory player) {
        return new SmokerMenu(id, player, this, this.dataAccess);
    }

}
