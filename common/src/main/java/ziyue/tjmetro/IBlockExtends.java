package ziyue.tjmetro;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.WATERLOGGED;
import static ziyue.tjmetro.TianjinMetro.LOGGER;

/**
 * Some methods similar to methods in IBlock.
 *
 * @see mtr.block.IBlock
 * @since 1.0b
 */

public interface IBlockExtends
{
    /**
     * Fence's collision height.
     *
     * @since 1.0b
     */
    byte FENCE_HEIGHT = 24;

    /**
     * Replace block with air.
     *
     * @param pos Block's Position
     * @author ZiYueCommentary
     * @since 1.0b
     */
    static void breakBlock(Level world, BlockPos pos) {
        try {
            world.setBlock(pos, world.getBlockState(pos).getValue(WATERLOGGED) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState(), 35);
        } catch (Exception exception) {
            LOGGER.warn("[" + pos.toShortString() + "] Property \"waterlogged\" not found - Replace with air");
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 35);
        }
    }

    /**
     * Specify a block, if block in pos is specified block, then replace it with air.
     *
     * @param pos   Block's Position
     * @param block Specified Block
     * @author ZiYueCommentary
     * @since 1.0b
     */
    static void breakBlock(Level world, BlockPos pos, Block block) {
        try {
            if (world.getBlockState(pos).getBlock() == block) {
                world.setBlock(pos, world.getBlockState(pos).getValue(WATERLOGGED) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState(), 35);
            }
        } catch (Exception exception) {
            LOGGER.warn("[" + pos.toShortString() + "] Property \"waterlogged\" not found - Replace with air");
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 35);
        }
    }
}
