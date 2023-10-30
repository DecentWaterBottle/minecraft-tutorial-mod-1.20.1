package net.tuggers.tutorialmod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tuggers.tutorialmod.TutorialMod;

public class ExampleAdvancedBlockEntity extends BlockEntity {

    private int counter;

    public ExampleAdvancedBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.EXAMPLE_ADVANCED_BLOCK_ENTITY.get(), pos, state);
    }

    public int incrementCounter() {
        this.counter++;
        this.setChanged();
        return this.counter;
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        CompoundTag tutorialmodData = nbt.getCompound(TutorialMod.MOD_ID);
//        this.counter = nbt.getInt("Counter");
        this.counter = tutorialmodData.getInt("Counter");
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        var tutorialmodData = new CompoundTag();
        tutorialmodData.putInt("Counter", this.counter);

        nbt.put(TutorialMod.MOD_ID, tutorialmodData);
        //        nbt.putInt("Counter", this.counter);

    }

    public int getCounter() {
        return this.counter;
    }
}
