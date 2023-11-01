package net.tuggers.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.tuggers.tutorialmod.block.entity.ModBlockEntities;
import net.tuggers.tutorialmod.block.entity.util.TickableBlockEntity;
import org.jetbrains.annotations.Nullable;

public class ExampleTickingBlock extends Block implements EntityBlock {
    public ExampleTickingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntities.EXAMPLE_TICKING_BLOCK_ENTITY.get().create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return TickableBlockEntity.getTickerHelper(pLevel);
    }

}
