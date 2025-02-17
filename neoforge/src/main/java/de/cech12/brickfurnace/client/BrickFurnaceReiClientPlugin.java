package de.cech12.brickfurnace.client;

import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.platform.Services;
import de.cech12.brickfurnace.rei.BrickFurnaceReiCommonPlugin;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;
import me.shedaniel.rei.plugin.client.categories.cooking.DefaultCookingCategory;
import me.shedaniel.rei.plugin.common.BuiltinPlugin;
import me.shedaniel.rei.plugin.common.displays.cooking.DefaultCookingDisplay;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("unused")
@REIPluginClient
public class BrickFurnaceReiClientPlugin implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registerCategory(registry, BrickFurnaceReiCommonPlugin.SMELTING_ID, Constants.BRICK_FURNACE_BLOCK.get(), Constants.BRICK_FURNACE_NAME, 200 * Services.CONFIG.getCookTimeFactor());
        registerCategory(registry, BrickFurnaceReiCommonPlugin.SMOKING_ID, Constants.BRICK_SMOKER_BLOCK.get(), Constants.BRICK_SMOKER_NAME, 100 * Services.CONFIG.getCookTimeFactor());
        registerCategory(registry, BrickFurnaceReiCommonPlugin.BLASTING_ID, Constants.BRICK_BLAST_FURNACE_BLOCK.get(), Constants.BRICK_BLAST_FURNACE_NAME, 100 * Services.CONFIG.getCookTimeFactor());
    }
    private void registerCategory(CategoryRegistry registry, CategoryIdentifier<DefaultCookingDisplay> id, Block block, String name, double defaultCookingTime) {
        registry.add(new DefaultCookingCategory(id, EntryStack.of(VanillaEntryTypes.ITEM, new ItemStack(block)), "block." + Constants.MOD_ID + "." + name, defaultCookingTime));
        registry.addWorkstations(id, EntryStacks.of(block));
        registry.addWorkstations(BuiltinPlugin.FUEL, EntryStacks.of(block));
    }

}
