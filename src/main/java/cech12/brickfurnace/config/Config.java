package cech12.brickfurnace.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;
import java.util.List;

public class Config {
    public static ForgeConfigSpec COMMON;

    public static List<IResettableConfigType> allValues = new ArrayList<>();

    public static final ConfigType.Double COOK_TIME_FACTOR = new ConfigType.Double(1.0);

    public static final ConfigType.Boolean CLAY_TO_BRICK_AT_CAMPFIRE = new ConfigType.Boolean(false);

    static {
        final ForgeConfigSpec.Builder common = new ForgeConfigSpec.Builder();

        common.comment("Options that affect the added furnaces.").push("Furnace Settings");
        COOK_TIME_FACTOR.configObj = common
                .comment("Cook time factor of all added brick furnaces in relation to corresponding vanilla furnaces. (i. e. 0.5 - half the time, 1.0 same time, 2.0 twice the time)")
                .defineInRange("cookTimeFactor", COOK_TIME_FACTOR.getDefaultValue(), 0.0, 100.0);
        common.pop();

        common.comment("Options that affect some game mechanics.").push("Game Mechanics");
        CLAY_TO_BRICK_AT_CAMPFIRE.configObj = common
                .comment("Enables the campfire recipe to make clay to bricks.")
                .define("clayToBrickAtCampfireEnabled", CLAY_TO_BRICK_AT_CAMPFIRE.getDefaultValue());
        common.pop();

        COMMON = common.build();
    }

    public static void resetConfig() {
        for (IResettableConfigType par : allValues){
            par.reset();
        }
    }
}
