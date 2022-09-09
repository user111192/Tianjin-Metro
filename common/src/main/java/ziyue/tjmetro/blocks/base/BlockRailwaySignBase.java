package ziyue.tjmetro.blocks.base;

import mtr.block.IBlock;
import mtr.mappings.*;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import ziyue.tjmetro.packet.PacketGuiServer;

import java.util.*;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.WATERLOGGED;

/**
 * @author ZiYueCommentary
 * @see mtr.block.BlockRailwaySign
 * @since 1.0b
 */

public abstract class BlockRailwaySignBase extends BlockDirectionalMapper implements EntityBlockMapper, IBlock, SimpleWaterloggedBlock
{
    public final int length;
    public final boolean isOdd;
    public static final float SMALL_SIGN_PERCENTAGE = 0.75F;

    public BlockRailwaySignBase(Properties properties, int length, boolean isOdd) {
        super(properties);
        this.length = length;
        this.isOdd = isOdd;
        registerDefaultState(defaultBlockState().setValue(WATERLOGGED, false));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult hit) {
        return IBlock.checkHoldingBrush(world, player, () -> {
            final Direction facing = IBlock.getStatePropertySafe(state, FACING);
            final BlockPos checkPos = findEndWithDirection(world, pos, facing, false);
            if (checkPos != null) {
                PacketGuiServer.openRailwaySignScreenS2C((ServerPlayer) player, checkPos);
            }
        });
    }

    @Override
    public abstract BlockState updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor world, BlockPos pos, BlockPos posFrom);

    public BlockState updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor world, BlockPos pos, BlockPos posFrom, Block middleBlock) {
        final Direction facing = IBlock.getStatePropertySafe(state, FACING);
        final boolean isNext = direction == facing.getClockWise() || state.is(middleBlock) && direction == facing.getCounterClockWise();
        if (isNext && !(newState.getBlock() instanceof BlockRailwaySignBase)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            return state;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        final Direction facing = ctx.getHorizontalDirection();
        return IBlock.isReplaceable(ctx, facing.getClockWise(), getMiddleLength() + 2) ? defaultBlockState().setValue(FACING, facing) : null;
    }

    @Override
    public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        final Direction facing = IBlock.getStatePropertySafe(state, FACING);

        final BlockPos checkPos = findEndWithDirection(world, pos, facing, true);
        if (checkPos != null) {
            IBlock.onBreakCreative(world, player, checkPos);
        }

        super.playerWillDestroy(world, pos, state, player);
    }

    @Override
    public abstract void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack);

    public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack, Block middleBlock) {
        if (!world.isClientSide) {
            final Direction facing = IBlock.getStatePropertySafe(state, FACING);
            for (int i = 1; i <= getMiddleLength(); i++) {
                world.setBlock(pos.relative(facing.getClockWise(), i), middleBlock.defaultBlockState().setValue(FACING, facing), 3);
            }
            world.setBlock(pos.relative(facing.getClockWise(), getMiddleLength() + 1), defaultBlockState().setValue(FACING, facing.getOpposite()), 3);
            world.updateNeighborsAt(pos, Blocks.AIR);
            state.updateNeighbourShapes(world, pos, 3);
        }
    }

    @Override
    public abstract VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext);

    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext, Block middleBlock) {
        final Direction facing = IBlock.getStatePropertySafe(state, FACING);
        if (state.is(middleBlock)) {
            return IBlock.getVoxelShapeByDirection(0, 0, 7, 16, 12, 9, facing);
        } else {
            final int xStart = getXStart();
            final VoxelShape main = IBlock.getVoxelShapeByDirection(xStart - 0.75, 0, 7, 16, 12, 9, facing);
            final VoxelShape pole = IBlock.getVoxelShapeByDirection(xStart - 2, 0, 7, xStart - 0.75, 16, 9, facing);
            return Shapes.or(main, pole);
        }
    }

    @Override
    public abstract String getDescriptionId();

    @Override
    public void appendHoverText(ItemStack itemStack, BlockGetter blockGetter, List<Component> tooltip, TooltipFlag tooltipFlag) {
        tooltip.add(Text.translatable("tooltip.mtr.railway_sign_length", length).withStyle(ChatFormatting.GRAY));
        tooltip.add(Text.translatable(isOdd ? "tooltip.mtr.railway_sign_odd" : "tooltip.mtr.railway_sign_even").withStyle(ChatFormatting.GRAY));
    }

    public abstract BlockEntityMapper createBlockEntity(BlockPos pos, BlockState state);

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    public int getXStart() {
        switch (length % 4) {
            default:
                return isOdd ? 8 : 16;
            case 1:
                return isOdd ? 4 : 12;
            case 2:
                return isOdd ? 16 : 8;
            case 3:
                return isOdd ? 12 : 4;
        }
    }

    protected int getMiddleLength() {
        return (length - (4 - getXStart() / 4)) / 2;
    }

    protected abstract BlockPos findEndWithDirection(Level world, BlockPos startPos, Direction direction, boolean allowOpposite);

    protected BlockPos findEndWithDirection(Level world, BlockPos startPos, Direction direction, boolean allowOpposite, Block middleBlock) {
        int i = 0;
        while (true) {
            final BlockPos checkPos = startPos.relative(direction.getCounterClockWise(), i);
            final BlockState checkState = world.getBlockState(checkPos);
            if (checkState.getBlock() instanceof BlockRailwaySignBase) {
                final Direction facing = IBlock.getStatePropertySafe(checkState, FACING);
                if (!checkState.is(middleBlock) && (facing == direction || allowOpposite && facing == direction.getOpposite())) {
                    return checkPos;
                }
            } else {
                return null;
            }
            i++;
        }
    }

    @Override
    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    public abstract static class TileEntityRailwaySign extends BlockEntityClientSerializableMapper
    {
        protected final Set<Long> selectedIds;
        protected final String[] signIds;
        protected static final String KEY_SELECTED_IDS = "selected_ids";
        protected static final String KEY_SIGN_LENGTH = "sign_length";

        public TileEntityRailwaySign(BlockEntityType<?> entity, int length, BlockPos pos, BlockState state) {
            super(entity, pos, state);
            signIds = new String[length];
            selectedIds = new HashSet<>();
        }

        @Override
        public void readCompoundTag(CompoundTag compoundTag) {
            selectedIds.clear();
            Arrays.stream(compoundTag.getLongArray(KEY_SELECTED_IDS)).forEach(selectedIds::add);
            for (int i = 0; i < signIds.length; i++) {
                final String signId = compoundTag.getString(KEY_SIGN_LENGTH + i);
                signIds[i] = signId.isEmpty() ? null : signId;
            }
        }

        @Override
        public void writeCompoundTag(CompoundTag compoundTag) {
            compoundTag.putLongArray(KEY_SELECTED_IDS, new ArrayList<>(selectedIds));
            for (int i = 0; i < signIds.length; i++) {
                compoundTag.putString(KEY_SIGN_LENGTH + i, signIds[i] == null ? "" : signIds[i]);
            }
        }

        public void setData(Set<Long> selectedIds, String[] signTypes) {
            this.selectedIds.clear();
            this.selectedIds.addAll(selectedIds);
            if (signIds.length == signTypes.length) {
                System.arraycopy(signTypes, 0, signIds, 0, signTypes.length);
            }
            setChanged();
            syncData();
        }

        public Set<Long> getSelectedIds() {
            return selectedIds;
        }

        public String[] getSignIds() {
            return signIds;
        }
    }
}
