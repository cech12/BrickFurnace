package de.cech12.brickfurnace.platform.services;

import net.minecraft.resources.ResourceLocation;

/**
 * Common configuration helper service interface.
 */
public interface IConfigHelper {

    /** Default value of the vanilla recipe enabled option */
    boolean VANILLA_RECIPES_ENABLED_DEFAULT = true;
    /** Config description of the vanilla recipe enabled option */
    String VANILLA_RECIPES_ENABLED_DESCRIPTION = "If enabled, the vanilla blasting, smelting, and smoking recipes are used by the brick furnaces.";

    /** Default value of the cook time factor option */
    double COOK_TIME_FACTOR_DEFAULT = 1D;
    /** Config description of the cook time factor option */
    String COOK_TIME_FACTOR_DESCRIPTION = "Cook time factor of all added brick furnaces in relation to corresponding vanilla furnaces. (i. e. 0.5 - half the time, 1.0 same time, 2.0 twice the time)";
    /** Minimal value of the cook time factor option */
    double COOK_TIME_FACTOR_MIN = 0D;
    /** Maximal value of the cook time factor option */
    double COOK_TIME_FACTOR_MAX = 100D;

    /** Default value of the burn time factor option */
    double BURN_TIME_FACTOR_DEFAULT = 1D;
    /** Config description of the burn time factor option */
    String BURN_TIME_FACTOR_DESCRIPTION = "Burn time factor (fuel efficiency) of all added brick furnaces in relation to corresponding vanilla furnaces. (i. e. 0.5 - half the time [less efficient], 1.0 same time [default], 2.0 twice the time [more efficient])";
    /** Minimal value of the burn time factor option */
    double BURN_TIME_FACTOR_MIN = 0D;
    /** Maximal value of the burn time factor option */
    double BURN_TIME_FACTOR_MAX = 100D;

    /** Default value of the recipe blocked list option */
    String RECIPE_BLOCKED_LIST_DEFAULT = "";
    /** Config description of the recipe blocked list option */
    String RECIPE_BLOCKED_LIST_DESCRIPTION = "A comma separated list of all vanilla recipes that should not be used by the brick furnaces. Example: \"baked_potato,baked_potato_from_smoking,othermod:other_baked_food\"";

    /**
     * Initialization method for the Service implementations.
     */
    void init();

    /**
     * Gets the configured value of the vanilla recipe enabled option.
     *
     * @return configured value of the vanilla recipe enabled option
     */
    boolean areVanillaRecipesEnabled();

    /**
     * Gets the configured value of the cook time factor option.
     *
     * @return configured value of the cook time factor option
     */
    double getCookTimeFactor();

    /**
     * Gets the configured value of the burn time factor option.
     *
     * @return configured value of the burn time factor option
     */
    double getBurnTimeFactor();

    /**
     * Gets the configured value of the recipe blocked list option.
     *
     * @return configured value of the recipe blocked list option
     */
    String getRecipeBlockedList();

    /**
     * Checks if the given ResourceLocation is allowed taking into account the recipe blocked list.
     * @param id ResourceLocation of recipe
     * @return true, if recipe is allowed, else false
     */
    default boolean isRecipeAllowed(final ResourceLocation id) {
        String configValue = getRecipeBlockedList().trim();
        if (!configValue.isEmpty()) {
            String[] ids = configValue.split(",");
            if (ids.length < 1) {
                return !(ResourceLocation.parse(configValue).equals(id));
            } else {
                for (String recipeId : ids) {
                    if (ResourceLocation.parse(recipeId.trim()).equals(id)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}