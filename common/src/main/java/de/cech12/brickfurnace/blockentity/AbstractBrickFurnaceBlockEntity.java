package de.cech12.brickfurnace.blockentity;

import de.cech12.brickfurnace.platform.Services;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractBrickFurnaceBlockEntity extends AbstractFurnaceBlockEntity {

    protected final RecipeType<? extends AbstractCookingRecipe> specificRecipeType;
    protected final RecipeType<? extends AbstractCookingRecipe> vanillaRecipeType;

    public AbstractBrickFurnaceBlockEntity(BlockEntityType<?> blockEntityTypeIn,
                                           BlockPos blockPos,
                                           BlockState blockState,
                                           RecipeType<? extends AbstractCookingRecipe> specificRecipeTypeIn,
                                           RecipeType<? extends AbstractCookingRecipe> vanillaRecipeTypeIn) {
        super(blockEntityTypeIn, blockPos, blockState, vanillaRecipeTypeIn);
        this.specificRecipeType = specificRecipeTypeIn;
        this.vanillaRecipeType = vanillaRecipeTypeIn;
    }

    /* FOLLOWING Code is copied from "Shadows-of-Fire/FastFurnace" mod to enhance performance */

    public static final int INPUT = 0;

    protected RecipeHolder<? extends AbstractCookingRecipe> curRecipe;
    protected ItemStack failedMatch = ItemStack.EMPTY;

    public static void tick(Level level, BlockPos pos, BlockState state, AbstractBrickFurnaceBlockEntity entity) {
        boolean changed = false;
        boolean isLit;
        boolean wasLit;
        if (entity.litTimeRemaining > 0) {
            wasLit = true;
            --entity.litTimeRemaining;
            isLit = entity.litTimeRemaining > 0;
        } else {
            wasLit = false;
            isLit = false;
        }

        ItemStack fuel = entity.items.get(1);
        ItemStack ingredient = entity.items.get(0);
        boolean hasIngredient = !ingredient.isEmpty();
        boolean hasFuel = !fuel.isEmpty();
        if (isLit || hasFuel && hasIngredient) {
            if (hasIngredient) {
                SingleRecipeInput input = new SingleRecipeInput(ingredient);
                RecipeHolder<? extends AbstractCookingRecipe> recipe = entity.getRecipe(); //changed because of multiple recipe types
                if (recipe != null) {
                    int maxStackSize = entity.getMaxStackSize();
                    ItemStack burnResult = recipe.value().assemble(input);
                    if (!burnResult.isEmpty() && entity.canBurn(entity.items, maxStackSize, burnResult)) {
                        if (!isLit) {
                            int newLitTime = entity.getBurnDuration(level.fuelValues(), fuel);
                            entity.litTimeRemaining = newLitTime;
                            entity.litTotalTime = newLitTime;
                            if (newLitTime > 0) {
                                entity.consumeFuel(entity.items, fuel);
                                isLit = true;
                                changed = true;
                            }
                        }

                        if (isLit) {
                            ++entity.cookingTimer;
                            if (entity.cookingTimer == entity.cookingTotalTime) {
                                entity.cookingTimer = 0;
                                entity.cookingTotalTime = entity.getTotalCookTime(recipe); //changed because of configurable cooking time factor
                                entity.burn(entity.items, ingredient, burnResult);
                                entity.setRecipeUsed(recipe);
                                changed = true;
                            }
                        } else {
                            entity.cookingTimer = 0;
                        }
                    } else {
                        entity.cookingTimer = 0;
                    }
                }
            } else {
                entity.cookingTimer = 0;
            }
        } else if (entity.cookingTimer > 0) {
            entity.cookingTimer = Mth.clamp(entity.cookingTimer - 2, 0, entity.cookingTotalTime);
        }

        if (wasLit != isLit) {
            changed = true;
            state = state.setValue(AbstractFurnaceBlock.LIT, isLit);
            level.setBlock(pos, state, 3);
        }

        if (changed) {
            setChanged(level, pos, state);
        }
    }

    private int getTotalCookTime(RecipeHolder<? extends AbstractCookingRecipe> rec) {
        if (rec == null) {
            return 200;
        } else if (this.specificRecipeType.getClass().isInstance(rec.value().getType())) {
            return rec.value().cookingTime();
        }
        return (int) (rec.value().cookingTime() * Services.CONFIG.getCookTimeFactor());
    }

    public RecipeHolder<? extends AbstractCookingRecipe> getRecipe() {
        ItemStack input = this.getItem(INPUT);
        if (input.isEmpty() || input == failedMatch) {
            return null;
        }
        SingleRecipeInput recipeInput = new SingleRecipeInput(input);
        if (this.level != null && curRecipe != null && curRecipe.value().matches(recipeInput, level)) {
            this.cookingTotalTime = getTotalCookTime(curRecipe);
            return curRecipe;
        } else {
            RecipeHolder<? extends AbstractCookingRecipe> rec = null;
            if (this.level != null && this.level.getServer() != null) {
                rec = this.level.getServer().getRecipeManager().getRecipeFor(this.specificRecipeType, recipeInput, this.level).orElse(null);
                if (rec == null && Services.CONFIG.areVanillaRecipesEnabled()) {
                    rec = this.level.getServer().getRecipeManager().getRecipes().stream()
                            .filter(recipe -> recipe.value().getType() == this.vanillaRecipeType)
                            .filter(recipe -> recipe.value() instanceof AbstractCookingRecipe)
                            .map(recipe -> (RecipeHolder<AbstractCookingRecipe>) recipe)
                            .filter(recipe -> recipe.value().matches(recipeInput, this.level))
                            .filter(recipe -> Services.CONFIG.isRecipeAllowed(recipe.id().identifier()))
                            .findFirst().orElse(null);
                }
            }
            if (rec == null) {
                failedMatch = input;
            } else {
                failedMatch = ItemStack.EMPTY;
            }
            this.cookingTotalTime = getTotalCookTime(rec);
            return curRecipe = rec;
        }
    }

    public int getLitTotalTime() {
        return this.dataAccess.get(0);
    }

    public int getCookingTimer() {
        return this.dataAccess.get(2);
    }

    public int getCookingTotalTime() {
        return this.dataAccess.get(3);
    }

}
