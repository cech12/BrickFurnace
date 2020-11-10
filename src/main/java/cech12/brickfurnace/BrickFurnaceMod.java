package cech12.brickfurnace;

import cech12.brickfurnace.api.block.BrickFurnaceBlocks;
import cech12.brickfurnace.api.crafting.RecipeTypes;
import cech12.brickfurnace.config.ServerConfig;
import cech12.brickfurnace.crafting.BrickBlastingRecipe;
import cech12.brickfurnace.crafting.BrickSmeltingRecipe;
import cech12.brickfurnace.crafting.BrickSmokingRecipe;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;

import static cech12.brickfurnace.BrickFurnaceMod.MOD_ID;

@Mod(MOD_ID)
@Mod.EventBusSubscriber(modid= MOD_ID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class BrickFurnaceMod {

    public static final String MOD_ID = "brickfurnace";

    public BrickFurnaceMod() {
        //Config
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ServerConfig.SERVER_CONFIG);
        ServerConfig.loadConfig(ServerConfig.SERVER_CONFIG, FMLPaths.GAMEDIR.get().resolve(FMLConfig.defaultConfigPath()).resolve(MOD_ID + "-server.toml"));
    }

    @SubscribeEvent
    public static void registerRecipeSerializers(RegistryEvent.Register<IRecipeSerializer<?>> event) {
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

    @SubscribeEvent
    public static void registerVillagerWorkstations(RegistryEvent.Register<PointOfInterestType> event) {
        addBlockStatesToPOIType(PointOfInterestType.ARMORER, BrickFurnaceBlocks.BRICK_BLAST_FURNACE);
        addBlockStatesToPOIType(PointOfInterestType.BUTCHER, BrickFurnaceBlocks.BRICK_SMOKER);
    }

    private static void addBlockStatesToPOIType(PointOfInterestType poiType, Block block) {
        Set<BlockState> poiTypeStates = new HashSet<>(poiType.blockStates);
        Set<BlockState> blockStates = new HashSet<>(block.getStateContainer().getValidStates());
        poiTypeStates.addAll(blockStates);
        poiType.blockStates = ImmutableSet.copyOf(poiTypeStates);
        for (BlockState state : blockStates) {
            PointOfInterestType.POIT_BY_BLOCKSTATE.put(state, poiType);
        }
    }

}
