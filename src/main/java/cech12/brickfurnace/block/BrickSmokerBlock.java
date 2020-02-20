package cech12.brickfurnace.block;

import cech12.brickfurnace.tileentity.BrickSmokerTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.SmokerBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BrickSmokerBlock extends SmokerBlock {

    public BrickSmokerBlock(Block.Properties builder) {
        super(builder);
    }

    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new BrickSmokerTileEntity();
    }

    /**
     * Interface for handling interaction with blocks that impliment AbstractFurnaceBlock. Called in onBlockActivated
     * inside AbstractFurnaceBlock.
     */
    protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof BrickSmokerTileEntity) {
            player.openContainer((INamedContainerProvider)tileentity);
            player.addStat(Stats.INTERACT_WITH_SMOKER);
        }

    }
}
