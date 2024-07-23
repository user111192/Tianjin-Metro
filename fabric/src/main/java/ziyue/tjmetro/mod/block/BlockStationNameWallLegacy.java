package ziyue.tjmetro.mod.block;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.mapper.BlockWithEntity;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.BlockStationNameWallBase;
import org.mtr.mod.block.IBlock;
import ziyue.tjmetro.mod.BlockEntityTypes;

import javax.annotation.Nonnull;
import java.util.List;

public class BlockStationNameWallLegacy extends BlockStationNameWallBase implements BlockWithEntity
{
    public BlockStationNameWallLegacy() {
        this(BlockHelper.createBlockSettings(false));
    }

    public BlockStationNameWallLegacy(BlockSettings blockSettings) {
        super(blockSettings);
    }

    @Nonnull
    @Override
    public ActionResult onUse2(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return IBlockExtension.checkHoldingBrushOrWrench(world, player, () -> world.setBlockState(pos, state.cycle(new Property<>(COLOR.data))));
    }

    @Override
    public BlockEntityExtension createBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new BlockEntity(blockPos, blockState);
    }

    @Override
    public void addBlockProperties(List<HolderBase<?>> properties) {
        properties.add(FACING);
        properties.add(COLOR);
    }

    public static class BlockEntity extends BlockEntityWallBase
    {
        public BlockEntity(BlockPos pos, BlockState state) {
            super(BlockEntityTypes.STATION_NAME_WALL_LEGACY.get(), pos, state);
        }

        @Override
        public int getColor(BlockState state) {
            return switch (IBlock.getStatePropertySafe(state, COLOR)) {
                case 1 -> ARGB_LIGHT_GRAY;
                case 2 -> ARGB_BLACK;
                default -> ARGB_WHITE;
            };
        }
    }
}
