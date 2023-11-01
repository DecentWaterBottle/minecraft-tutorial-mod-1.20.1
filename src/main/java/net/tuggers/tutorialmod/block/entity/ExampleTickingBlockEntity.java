package net.tuggers.tutorialmod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tuggers.tutorialmod.block.entity.util.TickableBlockEntity;

public class ExampleTickingBlockEntity extends BlockEntity implements TickableBlockEntity {
    private int ticks;
    public ExampleTickingBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.EXAMPLE_TICKING_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public void tick() {
        if(this.level == null || this.level.isClientSide())
            return;

        if(this.ticks++ % 100 == 0) {
            Pig pig = EntityType.PIG.create(this.level);
            if (pig == null)
                return;

            pig.setPos(this.worldPosition.getX(), this.worldPosition.getY() + 1, this.worldPosition.getZ());
            this.level.addFreshEntity(pig);
        }

    }
}
