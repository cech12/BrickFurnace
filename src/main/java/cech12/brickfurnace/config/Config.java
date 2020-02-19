package cech12.brickfurnace.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;
import java.util.List;

public class Config {
    public static ForgeConfigSpec COMMON;

    public static List<IResettableConfigType> allValues = new ArrayList<>();

    public static final ConfigType.Boolean CLAY_TO_BRICK_AT_CAMPFIRE = new ConfigType.Boolean(false);

    static {
        final ForgeConfigSpec.Builder common = new ForgeConfigSpec.Builder();

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
