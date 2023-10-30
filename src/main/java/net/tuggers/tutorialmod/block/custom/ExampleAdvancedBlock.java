package net.tuggers.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.tuggers.tutorialmod.block.entity.ExampleAdvancedBlockEntity;
import net.tuggers.tutorialmod.block.entity.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class ExampleAdvancedBlock extends HorizontalDirectionalBlock implements EntityBlock {
    public ExampleAdvancedBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
    }

//    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntities.EXAMPLE_ADVANCED_BLOCK_ENTITY.get().create(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
            BlockEntity be = pLevel.getBlockEntity(pPos);
            if(be instanceof ExampleAdvancedBlockEntity blockEntity) {
                int counter = pPlayer.isCrouching() ? blockEntity.getCounter() : blockEntity.incrementCounter();
                pPlayer.sendSystemMessage(Component.literal("Block entity has been used %d times".formatted(counter)));
                return InteractionResult.sidedSuccess(pLevel.isClientSide());
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }
}
