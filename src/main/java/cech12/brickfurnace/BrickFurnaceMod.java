package cech12.brickfurnace;

import cech12.brickfurnace.api.crafting.RecipeTypes;
import cech12.brickfurnace.config.Config;
import cech12.brickfurnace.crafting.BrickBlastingRecipe;
import cech12.brickfurnace.crafting.BrickSmeltingRecipe;
import cech12.brickfurnace.crafting.BrickSmokingRecipe;
import cech12.brickfurnace.crafting.EnabledCondition;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

import static cech12.brickfurnace.BrickFurnaceMod.MOD_ID;

@Mod(MOD_ID)
@Mod.EventBusSubscriber
public class BrickFurnaceMod {

    public static final String MOD_ID = "brickfurnace";

    public BrickFurnaceMod() {
        //Configs
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON, "brickfurnace-common.toml");
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(IRecipeSerializer.class, this::registerRecipeSerializers);
    }

    private void registerRecipeSerializers(RegistryEvent.Register<IRecipeSerializer<?>> event) {
        CraftingHelper.register(EnabledCondition.Serializer.INSTANCE);

        RecipeTypes.BLASTING = Registry.register(Registry.RECIPE_TYPE,
                new ResourceLocation(BrickFurnaceMod.MOD_ID, "blasting"),
                new IRecipeType<BrickBlastingRecipe>() {});
        ForgeRegistries.RECIPE_SERIALIZERS.register(BrickBlastingRecipe.SERIALIZER);

        RecipeTypes.SMELTING = Registry.register(Registry.RECIPE_TYPE,
                new ResourceLocation(BrickFurnaceMod.MOD_ID, "smelting"),
                new IRecipeType<BrickSmeltingRecipe>() {});
        ForgeRegistries.RECIPE_SERIALIZERS.register(BrickSmeltingRecipe.SERIALIZER);

        RecipeTypes.SMOKING = Registry.register(Registry.RECIPE_TYPE,
                new ResourceLocation(BrickFurnaceMod.MOD_ID, "smoking"),
                new IRecipeType<BrickSmokingRecipe>() {});
        ForgeRegistries.RECIPE_SERIALIZERS.register(BrickSmokingRecipe.SERIALIZER);
    }

}
