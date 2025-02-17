package de.cech12.brickfurnace.compat.immersiveengineering;
/*
import blusunrize.immersiveengineering.api.tool.ExternalHeaterHandler;
import de.cech12.brickfurnace.blockentity.AbstractBrickFurnaceBlockEntity;
import de.cech12.brickfurnace.blockentity.BrickFurnaceBlockEntity;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BrickFurnaceHeater implements ExternalHeaterHandler.IExternalHeatable {
    private static final int FULLY_HEATED_LIT_TIME = 200;
    private final BrickFurnaceBlockEntity furnace;
    private long blockedUntilGameTime = 0;

    public BrickFurnaceHeater(BrickFurnaceBlockEntity furnace) {
        this.furnace = furnace;
    }

    boolean canCook(RegistryAccess registryAccess) {
        ItemStack input = furnace.getItem(AbstractBrickFurnaceBlockEntity.INPUT);
        if (input.isEmpty()) return false;
        RecipeHolder<?> recipe = furnace.getRecipe();
        if (recipe == null) return false;
        ItemStack outStack = recipe.value().getResultItem(registryAccess);
        if (outStack.isEmpty()) return false;
        ItemStack existingOutput = furnace.getItem(2);
        if (existingOutput.isEmpty()) return true;
        if (!ItemStack.isSameItem(existingOutput, outStack)) return false;
        int stackSize = existingOutput.getCount() + outStack.getCount();
        return stackSize <= furnace.getMaxStackSize() && stackSize <= outStack.getMaxStackSize();
    }

    @Override
    public int doHeatTick(int energyAvailable, boolean redstone) {
        long now = furnace.getLevel().getGameTime();
        if (now < blockedUntilGameTime) return 0;
        int energyConsumed = 0;
        boolean canCook = canCook(furnace.getLevel().registryAccess());
        if (canCook || redstone) {
            ContainerData furnaceData = furnace.getContainerData();
            int burnTime = furnaceData.get(AbstractFurnaceBlockEntity.DATA_LIT_TIME);
            if (burnTime < FULLY_HEATED_LIT_TIME) {
                final int heatEnergyRatio = Math.max(1, ExternalHeaterHandler.defaultFurnaceEnergyCost);
                if (burnTime == 0 && energyAvailable < heatEnergyRatio) {
                    // Turn off completely for one second if furnace goes out due to insufficient power to prevent fast
                    // on/off cycling on weak power sources
                    blockedUntilGameTime = now + 20;
                    return 0;
                }
                int heatAttempt = Math.min(4, FULLY_HEATED_LIT_TIME-burnTime);
                int energyToUse = Math.min(energyAvailable, heatAttempt*heatEnergyRatio);
                int heat = energyToUse/heatEnergyRatio;
                if (heat > 0) {
                    furnaceData.set(AbstractFurnaceBlockEntity.DATA_LIT_TIME, burnTime+heat);
                    energyConsumed += heat*heatEnergyRatio;
                    setFurnaceActive();
                }
            }
            // Speed up once fully charged
            if (canCook && furnaceData.get(AbstractFurnaceBlockEntity.DATA_LIT_TIME) >= FULLY_HEATED_LIT_TIME&&furnaceData.get(AbstractFurnaceBlockEntity.DATA_COOKING_PROGRESS) < AbstractFurnaceBlockEntity.BURN_TIME_STANDARD-1) {
                int energyToUse = ExternalHeaterHandler.defaultFurnaceSpeedupCost;
                if (energyAvailable - energyConsumed > energyToUse) {
                    energyConsumed += energyToUse;
                    furnaceData.set(AbstractFurnaceBlockEntity.DATA_COOKING_PROGRESS, furnaceData.get(AbstractFurnaceBlockEntity.DATA_COOKING_PROGRESS)+1);
                }
            }
        }
        return energyConsumed;
    }

    public void setFurnaceActive() {
        BlockState oldState = furnace.getBlockState();
        if (!oldState.getValue(AbstractFurnaceBlock.LIT)) {
            furnace.getLevel().setBlockAndUpdate(
                    furnace.getBlockPos(), oldState.setValue(AbstractFurnaceBlock.LIT, true)
            );
        }
    }
}
 */
