package cech12.brickfurnace;

import cech12.brickfurnace.api.crafting.RecipeTypes;
import cech12.brickfurnace.config.ServerConfig;
import cech12.brickfurnace.crafting.BrickBlastingRecipe;
import cech12.brickfurnace.crafting.BrickSmeltingRecipe;
import cech12.brickfurnace.crafting.BrickSmokingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.ForgeRegistries;

import static cech12.brickfurnace.BrickFurnaceMod.MOD_ID;

@Mod(MOD_ID)
@Mod.EventBusSubscriber
public class BrickFurnaceMod {

    public static final String MOD_ID = "brickfurnace";

    public BrickFurnaceMod() {
        //Config
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ServerConfig.SERVER_CONFIG);
        ServerConfig.loadConfig(ServerConfig.SERVER_CONFIG, FMLPaths.GAMEDIR.get().resolve(FMLConfig.defaultConfigPath()).resolve(MOD_ID + "-server.toml"));

        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(IRecipeSerializer.class, this::registerRecipeSerializers);
    }

    private void registerRecipeSerializers(RegistryEvent.Register<IRecipeSerializer<?>> event) {
        RecipeTypes.BLASTING = Registry.register(Registry.RECIPE_TYPE,
                RecipeTypes.BLASTING_ID,
                new IRecipeType<BrickBlastingRecipe>() {});
        ForgeRegistries.RECIPE_SERIALIZERS.register(BrickBlastingRecipe.SERIALIZER);

        RecipeTypes.SMELTING = Registry.register(Registry.RECIPE_TYPE,
                RecipeTypes.SMELTING_ID,
                new IRecipeType<BrickSmeltingRecipe>() {});
        ForgeRegistries.RECIPE_SERIALIZERS.register(BrickSmeltingRecipe.SERIALIZER);

        RecipeTypes.SMOKING = Registry.register(Registry.RECIPE_TYPE,
                RecipeTypes.SMOKING_ID,
                new IRecipeType<BrickSmokingRecipe>() {});
        ForgeRegistries.RECIPE_SERIALIZERS.register(BrickSmokingRecipe.SERIALIZER);
    }

}
