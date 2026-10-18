package de.cech12.brickfurnace.blockentity;

import de.cech12.brickfurnace.Constants;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.SmokerMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BrickSmokerBlockEntity extends AbstractBrickFurnaceBlockEntity {

    public BrickSmokerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(Constants.BRICK_SMOKER_BLOCK_ENTITY_TYPE.get(), blockPos, blockState, Constants.SMOKING_RECIPE_TYPE.get(), RecipeType.SMOKING);
    }

    @Override
    @NotNull
    protected Component getDefaultName() {
        return Component.translatable("block.brickfurnace.brick_smoker");
    }

    @Override
    @NotNull
    protected AbstractContainerMenu createMenu(int id, @NotNull Inventory player) {
        return new SmokerMenu(id, player, this, this.dataAccess);
    }

}
