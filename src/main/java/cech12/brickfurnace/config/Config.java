package cech12.brickfurnace.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static ForgeConfigSpec COMMON;

    public static final ForgeConfigSpec.DoubleValue COOK_TIME_FACTOR;

    public static final ForgeConfigSpec.BooleanValue CLAY_TO_BRICK_AT_CAMPFIRE;

    static {
        final ForgeConfigSpec.Builder common = new ForgeConfigSpec.Builder();

        common.comment("Options that affect the added furnaces.").push("Furnace Settings");
        COOK_TIME_FACTOR = common
                .comment("Cook time factor of all added brick furnaces in relation to corresponding vanilla furnaces. (i. e. 0.5 - half the time, 1.0 same time, 2.0 twice the time)")
                .defineInRange("cookTimeFactor", 1.0, 0.0, 100.0);
        common.pop();

        common.comment("Options that affect some game mechanics.").push("Game Mechanics");
        CLAY_TO_BRICK_AT_CAMPFIRE = common
                .comment("Enables the campfire recipe to make clay to bricks.")
                .define("clayToBrickAtCampfireEnabled", false);
        common.pop();

        COMMON = common.build();
    }

}
