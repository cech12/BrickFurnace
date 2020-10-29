package cech12.brickfurnace.config;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static ForgeConfigSpec COMMON;

    public static final ForgeConfigSpec.BooleanValue VANILLA_RECIPES_ENABLED;
    public static final ForgeConfigSpec.DoubleValue COOK_TIME_FACTOR;
    public static final ForgeConfigSpec.ConfigValue<String> RECIPE_BLACKLIST;

    public static final ForgeConfigSpec.BooleanValue CLAY_TO_BRICK_AT_CAMPFIRE;

    static {
        final ForgeConfigSpec.Builder common = new ForgeConfigSpec.Builder();

        common.comment("Options that affect the added furnaces.").push("Furnace Settings");
        VANILLA_RECIPES_ENABLED = common
                .comment("If enabled, the vanilla blasting, smelting, and smoking recipes are used by the brick furnaces.")
                .define("vanillaRecipesEnabled", true);
        COOK_TIME_FACTOR = common
                .comment("Cook time factor of all added brick furnaces in relation to corresponding vanilla furnaces. (i. e. 0.5 - half the time, 1.0 same time, 2.0 twice the time)")
                .defineInRange("cookTimeFactor", 1.0, 0.0, 100.0);
        RECIPE_BLACKLIST = common
                .comment("A comma separated list of all vanilla recipes that should not be used by the brick furnaces. Example: \"baked_potato,baked_potato_from_smoking,othermod:other_baked_food\"")
                .define("recipeBlacklist", "");
        common.pop();

        common.comment("Options that affect some game mechanics.").push("Game Mechanics");
        CLAY_TO_BRICK_AT_CAMPFIRE = common
                .comment("Enables the campfire recipe to make clay to bricks.")
                .define("clayToBrickAtCampfireEnabled", false);
        common.pop();

        COMMON = common.build();
    }

    public static boolean isRecipeNotBlacklisted(final ResourceLocation id) {
        String configValue = RECIPE_BLACKLIST.get().trim();
        if (!configValue.isEmpty()) {
            String[] ids = configValue.split(",");
            if (ids.length < 1) {
                return !(new ResourceLocation(configValue).equals(id));
            } else {
                for (String recipeId : ids) {
                    if (new ResourceLocation(recipeId.trim()).equals(id)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
