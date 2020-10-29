package cech12.brickfurnace.crafting;

import cech12.brickfurnace.BrickFurnaceMod;
import cech12.brickfurnace.config.Config;
import com.google.gson.JsonObject;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

/**
 * Condition that checks whether item is instance of IEnabled, and if it is, whether or not it is enabled.
 * Used to disable recipes for items disabled in config.
 */
public class EnabledCondition implements ICondition {
    private static final ResourceLocation ID = new ResourceLocation(BrickFurnaceMod.MOD_ID, "is_enabled");
    private final String configPath;

    public EnabledCondition(String configPath) {
        this.configPath = configPath;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public boolean test() {
        ForgeConfigSpec.BooleanValue config = Config.COMMON.getValues().get(this.configPath);
        if (config != null) {
            return config.get();
        }
        return false;
    }

    public static class Serializer implements IConditionSerializer<EnabledCondition> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void write(JsonObject json, EnabledCondition value) {
            json.addProperty("path", value.configPath);
        }

        @Override
        public EnabledCondition read(JsonObject json) {
            return new EnabledCondition(JSONUtils.getString(json, "path"));
        }

        @Override
        public ResourceLocation getID() {
            return EnabledCondition.ID;
        }
    }
}

