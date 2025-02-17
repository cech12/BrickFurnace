package de.cech12.brickfurnace.platform;

import de.cech12.brickfurnace.platform.services.IPlatformHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

/**
 * The platform service implementation for Forge.
 */
public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Forge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return stack.getCraftingRemainder() != null && !stack.getCraftingRemainder().isEmpty();
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        return stack.getCraftingRemainder();
    }

}
