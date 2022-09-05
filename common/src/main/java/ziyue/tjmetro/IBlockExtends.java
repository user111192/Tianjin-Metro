package ziyue.tjmetro;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.WATERLOGGED;
import static ziyue.tjmetro.TianjinMetro.LOGGER;

/**
 * Some methods similar to methods in <b>IBlock</b>.
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

    /**
     * Get left position of block.
     *
     * @param blockPos  Block's Position
     * @param direction Block's Direction
     * @return Left position of block.
     * @author ZiYueCommentary
     * @since 1.0b
     */
    static BlockPos getLeftPos(BlockPos blockPos, Direction direction) {
        switch (direction) {
            case NORTH:
                return blockPos.west();
            case SOUTH:
                return blockPos.east();
            case WEST:
                return blockPos.south();
            case EAST:
                return blockPos.north();
        }
        throw new IllegalArgumentException("\"getLeftPos\" support horizontal direction only!");
    }

    /**
     * Get right position of block.
     *
     * @param blockPos  Block's Position
     * @param direction Block's Direction
     * @return Right position of block.
     * @author ZiYueCommentary
     * @since 1.0b
     */
    static BlockPos getRightPos(BlockPos blockPos, Direction direction) {
        switch (direction) {
            case NORTH:
                return blockPos.east();
            case SOUTH:
                return blockPos.west();
            case WEST:
                return blockPos.north();
            case EAST:
                return blockPos.south();
        }
        throw new IllegalArgumentException("\"getRightPos\" support horizontal direction only!");
    }

    /**
     * Get left direction of specified direction.
     *
     * @return Left direction.
     * @author ZiYueCommentary
     * @since 1.0b
     */
    static Direction getLeftDirection(Direction direction) {
        switch (direction) {
            case NORTH:
                return Direction.WEST;
            case SOUTH:
                return Direction.EAST;
            case WEST:
                return Direction.SOUTH;
            case EAST:
                return Direction.NORTH;
        }
        throw new IllegalArgumentException("\"getLeftDirection\" support horizontal direction only!");
    }

    /**
     * Get right direction of specified direction.
     *
     * @return Right direction.
     * @author ZiYueCommentary
     * @since 1.0b
     */
    static Direction getRightDirection(Direction direction) {
        switch (direction) {
            case NORTH:
                return Direction.EAST;
            case SOUTH:
                return Direction.WEST;
            case WEST:
                return Direction.NORTH;
            case EAST:
                return Direction.SOUTH;
        }
        throw new IllegalArgumentException("\"getRightDirection\" support horizontal direction only!");
    }

    /**
     * Check the direction whether is horizontal direction.
     *
     * @author ZiYueCommentary
     * @since 1.0b
     */
    static boolean isHorizontalDirection(Direction direction) {
        return direction == Direction.EAST || direction == Direction.WEST || direction == Direction.NORTH || direction == Direction.SOUTH;
    }
}
