package de.cech12.brickfurnace.init;

import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.blockentity.AbstractBrickFurnaceBlockEntity;
import de.cech12.brickfurnace.blockentity.BrickBlastFurnaceBlockEntity;
import de.cech12.brickfurnace.blockentity.BrickFurnaceBlockEntity;
import de.cech12.brickfurnace.blockentity.BrickSmokerBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public final class ModBlockEntityTypes {

    private static final BlockEntityType<? extends AbstractBrickFurnaceBlockEntity> BRICK_FURNACE_BLOCK_ENTITY_TYPE = register(Constants.BRICK_FURNACE_NAME, FabricBlockEntityTypeBuilder.create(BrickFurnaceBlockEntity::new, Constants.BRICK_FURNACE_BLOCK.get()));
    private static final BlockEntityType<? extends AbstractBrickFurnaceBlockEntity> BRICK_BLAST_FURNACE_BLOCK_ENTITY_TYPE = register(Constants.BRICK_BLAST_FURNACE_NAME, FabricBlockEntityTypeBuilder.create(BrickBlastFurnaceBlockEntity::new, Constants.BRICK_BLAST_FURNACE_BLOCK.get()));
    private static final BlockEntityType<? extends AbstractBrickFurnaceBlockEntity> BRICK_SMOKER_BLOCK_ENTITY_TYPE = register(Constants.BRICK_SMOKER_NAME, FabricBlockEntityTypeBuilder.create(BrickSmokerBlockEntity::new, Constants.BRICK_SMOKER_BLOCK.get()));

    static {
        Constants.BRICK_FURNACE_BLOCK_ENTITY_TYPE = () -> BRICK_FURNACE_BLOCK_ENTITY_TYPE;
        Constants.BRICK_BLAST_FURNACE_BLOCK_ENTITY_TYPE = () -> BRICK_BLAST_FURNACE_BLOCK_ENTITY_TYPE;
        Constants.BRICK_SMOKER_BLOCK_ENTITY_TYPE = () -> BRICK_SMOKER_BLOCK_ENTITY_TYPE;
    }

    public static void init() {}

    private static BlockEntityType<? extends AbstractBrickFurnaceBlockEntity> register(String name, FabricBlockEntityTypeBuilder<? extends AbstractBrickFurnaceBlockEntity> blockEntityTypeBuilder) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Constants.id(name), blockEntityTypeBuilder.build(null));
    }

}
