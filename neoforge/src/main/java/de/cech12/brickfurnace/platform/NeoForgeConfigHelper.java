package de.cech12.brickfurnace.platform;

import de.cech12.brickfurnace.platform.services.IConfigHelper;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * The config service implementation for Forge.
 */
public class NeoForgeConfigHelper implements IConfigHelper {

    private static final ModConfigSpec SERVER_CONFIG;

    public static final ModConfigSpec.BooleanValue VANILLA_RECIPES_ENABLED;
    public static final ModConfigSpec.DoubleValue COOK_TIME_FACTOR;
    public static final ModConfigSpec.DoubleValue BURN_TIME_FACTOR;
    public static final ModConfigSpec.ConfigValue<String> RECIPE_BLOCKED_LIST;

    static {
        final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.comment("Options that affect the added furnaces.").push("Furnace Settings");

        VANILLA_RECIPES_ENABLED = builder
                .comment(VANILLA_RECIPES_ENABLED_DESCRIPTION)
                .define("vanillaRecipesEnabled", VANILLA_RECIPES_ENABLED_DEFAULT);
        COOK_TIME_FACTOR = builder
                .comment(COOK_TIME_FACTOR_DESCRIPTION)
                .defineInRange("cookTimeFactor", COOK_TIME_FACTOR_DEFAULT, COOK_TIME_FACTOR_MIN, COOK_TIME_FACTOR_MAX);
        BURN_TIME_FACTOR = builder
                .comment(BURN_TIME_FACTOR_DESCRIPTION)
                .defineInRange("burnTimeFactor", BURN_TIME_FACTOR_DEFAULT, BURN_TIME_FACTOR_MIN, BURN_TIME_FACTOR_MAX);
        RECIPE_BLOCKED_LIST = builder
                .comment(RECIPE_BLOCKED_LIST_DESCRIPTION)
                .define("recipeBlockedList", RECIPE_BLOCKED_LIST_DEFAULT);

        builder.pop();

        SERVER_CONFIG = builder.build();
    }

    @Override
    public void init() {
        ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
    }

    @Override
    public boolean areVanillaRecipesEnabled() {
        try {
            return VANILLA_RECIPES_ENABLED.get();
        } catch (IllegalStateException ex) {
            return VANILLA_RECIPES_ENABLED_DEFAULT;
        }
    }

    @Override
    public double getCookTimeFactor() {
        try {
            return COOK_TIME_FACTOR.get();
        } catch (IllegalStateException ex) {
            return COOK_TIME_FACTOR_DEFAULT;
        }
    }

    @Override
    public double getBurnTimeFactor() {
        try {
            return BURN_TIME_FACTOR.get();
        } catch (IllegalStateException ex) {
            return BURN_TIME_FACTOR_DEFAULT;
        }
    }

    @Override
    public String getRecipeBlockedList() {
        try {
            return RECIPE_BLOCKED_LIST.get();
        } catch (IllegalStateException ex) {
            return RECIPE_BLOCKED_LIST_DEFAULT;
        }
    }

}
