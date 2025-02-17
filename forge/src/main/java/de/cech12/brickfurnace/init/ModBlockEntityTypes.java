package de.cech12.brickfurnace.init;

import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.blockentity.BrickBlastFurnaceBlockEntity;
import de.cech12.brickfurnace.blockentity.BrickFurnaceBlockEntity;
import de.cech12.brickfurnace.blockentity.BrickSmokerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;

public final class ModBlockEntityTypes {

    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Constants.MOD_ID);

    static {
        Constants.BRICK_FURNACE_BLOCK_ENTITY_TYPE = BLOCK_ENTITY_TYPES.register(Constants.BRICK_FURNACE_NAME, () -> new BlockEntityType<>(BrickFurnaceBlockEntity::new, Set.of(Constants.BRICK_FURNACE_BLOCK.get())));
        Constants.BRICK_BLAST_FURNACE_BLOCK_ENTITY_TYPE = BLOCK_ENTITY_TYPES.register(Constants.BRICK_BLAST_FURNACE_NAME, () -> new BlockEntityType<>(BrickBlastFurnaceBlockEntity::new, Set.of(Constants.BRICK_BLAST_FURNACE_BLOCK.get())));
        Constants.BRICK_SMOKER_BLOCK_ENTITY_TYPE = BLOCK_ENTITY_TYPES.register(Constants.BRICK_SMOKER_NAME, () -> new BlockEntityType<>(BrickSmokerBlockEntity::new, Set.of(Constants.BRICK_SMOKER_BLOCK.get())));
    }

}
