package cech12.brickfurnace;

import cech12.brickfurnace.config.Config;
import cech12.brickfurnace.helper.BrickFurnaceRecipeSerializers;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static cech12.brickfurnace.BrickFurnaceMod.MOD_ID;

@Mod(MOD_ID)
@Mod.EventBusSubscriber
public class BrickFurnaceMod {

    public static final String MOD_ID = "brickfurnace";

    public BrickFurnaceMod() {
        //Configs
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON, "brickfurnace-common.toml");
        FMLJavaModLoadingContext.get().getModEventBus().register(new BrickFurnaceRecipeSerializers());
    }

}
