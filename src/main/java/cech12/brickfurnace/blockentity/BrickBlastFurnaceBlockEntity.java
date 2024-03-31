package cech12.brickfurnace.blockentity;

import cech12.brickfurnace.config.ServerConfig;
import cech12.brickfurnace.init.ModBlockEntityTypes;
import cech12.brickfurnace.init.ModRecipeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.BlastFurnaceMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public class BrickBlastFurnaceBlockEntity extends AbstractBrickFurnaceBlockEntity {

    public BrickBlastFurnaceBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.BRICK_BLAST_FURNACE.get(), blockPos, blockState, ModRecipeTypes.BLASTING.get(), RecipeType.BLASTING);
    }

    @Override
    @Nonnull
    protected Component getDefaultName() {
        return Component.translatable("block.brickfurnace.brick_blast_furnace");
    }

    @Override
    protected int getBurnDuration(@Nonnull ItemStack stack) {
        return (int) (super.getBurnDuration(stack) * (0.5D * ServerConfig.COOK_TIME_FACTOR.get()));
    }

    @Override
    @Nonnull
    protected AbstractContainerMenu createMenu(int id, @Nonnull Inventory player) {
        return new BlastFurnaceMenu(id, player, this, this.dataAccess);
    }

}
