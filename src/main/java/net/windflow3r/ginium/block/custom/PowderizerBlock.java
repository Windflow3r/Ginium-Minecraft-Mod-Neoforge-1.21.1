package net.windflow3r.ginium.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.windflow3r.ginium.block.entity.GiniumBlockEntities;
import net.windflow3r.ginium.block.entity.PowderizerBlockEntity;
import org.jetbrains.annotations.Nullable;

public class PowderizerBlock extends BaseEntityBlock {

    public static final MapCodec<PowderizerBlock> CODEC =
            simpleCodec(PowderizerBlock::new);

    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final DirectionProperty FACING =
            BlockStateProperties.HORIZONTAL_FACING;

    public PowderizerBlock(Properties properties) {
        super(properties);

        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(LIT, false)
        );
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(
            BlockPos blockPos,
            BlockState blockState
    ) {
        return new PowderizerBlockEntity(blockPos, blockState);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected void createBlockStateDefinition(
            StateDefinition.Builder<Block, BlockState> builder
    ) {
        builder.add(FACING, LIT);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(
                        FACING,
                        context.getHorizontalDirection().getOpposite()
                );
    }

    @Override
    public void onRemove(
            BlockState pState,
            Level pLevel,
            BlockPos pPos,
            BlockState pNewState,
            boolean pIsMoving
    ) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);

            if (blockEntity instanceof PowderizerBlockEntity powderizerBlockEntity) {
                powderizerBlockEntity.drops();
            }
        }

        super.onRemove(
                pState,
                pLevel,
                pPos,
                pNewState,
                pIsMoving
        );
    }

    @Override
    protected ItemInteractionResult useItemOn(
            ItemStack pStack,
            BlockState pState,
            Level pLevel,
            BlockPos pPos,
            Player pPlayer,
            InteractionHand pHand,
            BlockHitResult pHitResult
    ) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);

            if (entity instanceof PowderizerBlockEntity powderizerBlockEntity) {
                ((ServerPlayer) pPlayer).openMenu(
                        new SimpleMenuProvider(
                                powderizerBlockEntity,
                                Component.translatable(
                                        "block.windflowersginium.powderizer"
                                )
                        ),
                        pPos
                );
            } else {
                throw new IllegalStateException(
                        "Our Container provider is missing!"
                );
            }
        }

        return ItemInteractionResult.sidedSuccess(
                pLevel.isClientSide()
        );
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level level,
            BlockState state,
            BlockEntityType<T> blockEntityType
    ) {
        if (level.isClientSide()) {
            return null;
        }

        return createTickerHelper(
                blockEntityType,
                GiniumBlockEntities.POWDERIZER_BE.get(),
                (level1, blockPos, blockState, blockEntity) ->
                        blockEntity.tick(
                                level1,
                                blockPos,
                                blockState
                        )
        );
    }
}

