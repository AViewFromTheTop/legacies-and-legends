package net.legacy.legacies_and_legends.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class TransparentSlabBlock extends TransparentBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<TransparentSlabBlock> CODEC = simpleCodec(TransparentSlabBlock::new);
    public static final EnumProperty<SlabType> TYPE;
    public static final BooleanProperty WATERLOGGED;
    private static final VoxelShape SHAPE_BOTTOM;
    private static final VoxelShape SHAPE_TOP;

    public MapCodec<? extends TransparentSlabBlock> codec() {
        return CODEC;
    }

    public TransparentSlabBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM)).setValue(WATERLOGGED, false));
    }

    protected boolean useShapeForLightOcclusion(BlockState state) {
        return state.getValue(TYPE) != SlabType.DOUBLE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{TYPE, WATERLOGGED});
    }

    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        VoxelShape var10000;
        switch ((SlabType)state.getValue(TYPE)) {
            case TOP -> var10000 = SHAPE_TOP;
            case BOTTOM -> var10000 = SHAPE_BOTTOM;
            case DOUBLE -> var10000 = Shapes.block();
            default -> throw new MatchException((String)null, (Throwable)null);
        }

        return var10000;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        BlockState blockState = context.getLevel().getBlockState(blockPos);
        if (blockState.is(this)) {
            return (BlockState)((BlockState)blockState.setValue(TYPE, SlabType.DOUBLE)).setValue(WATERLOGGED, false);
        } else {
            FluidState fluidState = context.getLevel().getFluidState(blockPos);
            BlockState blockState2 = (BlockState)((BlockState)this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM)).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
            Direction direction = context.getClickedFace();
            return direction != Direction.DOWN && (direction == Direction.UP || !(context.getClickLocation().y - (double)blockPos.getY() > (double)0.5F)) ? blockState2 : (BlockState)blockState2.setValue(TYPE, SlabType.TOP);
        }
    }

    protected boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        ItemStack itemStack = useContext.getItemInHand();
        SlabType slabType = (SlabType)state.getValue(TYPE);
        if (slabType != SlabType.DOUBLE && itemStack.is(this.asItem())) {
            if (useContext.replacingClickedOnBlock()) {
                boolean bl = useContext.getClickLocation().y - (double)useContext.getClickedPos().getY() > (double)0.5F;
                Direction direction = useContext.getClickedFace();
                if (slabType == SlabType.BOTTOM) {
                    return direction == Direction.UP || bl && direction.getAxis().isHorizontal();
                } else {
                    return direction == Direction.DOWN || !bl && direction.getAxis().isHorizontal();
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    protected FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState state, FluidState fluidState) {
        return state.getValue(TYPE) != SlabType.DOUBLE && SimpleWaterloggedBlock.super.placeLiquid(level, pos, state, fluidState);
    }

    public boolean canPlaceLiquid(@Nullable LivingEntity owner, BlockGetter level, BlockPos pos, BlockState state, Fluid fluid) {
        return state.getValue(TYPE) != SlabType.DOUBLE && SimpleWaterloggedBlock.super.canPlaceLiquid(owner, level, pos, state, fluid);
    }

    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if ((Boolean)state.getValue(WATERLOGGED)) {
            scheduledTickAccess.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, level, scheduledTickAccess, pos, direction, neighborPos, neighborState, random);
    }

    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        switch (pathComputationType) {
            case LAND -> {
                return false;
            }
            case WATER -> {
                return state.getFluidState().is(FluidTags.WATER);
            }
            case AIR -> {
                return false;
            }
            default -> {
                return false;
            }
        }
    }

    static {
        TYPE = BlockStateProperties.SLAB_TYPE;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        SHAPE_BOTTOM = Block.column((double)16.0F, (double)0.0F, (double)8.0F);
        SHAPE_TOP = Block.column((double)16.0F, (double)8.0F, (double)16.0F);
    }
}
