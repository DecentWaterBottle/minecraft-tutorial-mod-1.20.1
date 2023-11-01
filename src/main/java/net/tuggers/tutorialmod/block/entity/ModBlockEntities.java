package net.tuggers.tutorialmod.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tuggers.tutorialmod.TutorialMod;
import net.tuggers.tutorialmod.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<GemPolishingStationBlockEntity>> GEM_POLISHING_BE =
            BLOCK_ENTITIES.register("gem_polishing_be", () ->
                    BlockEntityType.Builder.of(GemPolishingStationBlockEntity::new,
                            ModBlocks.GEM_POLISHING_STATION.get()).build(null));

//    public static final RegistryObject<BlockEntityType<ExampleAdvancedBlockEntity>> EXAMPLE_ADVANCED_BLOCK_ENTITY =
//            BLOCK_ENTITIES.register("example_advanced_block_entity",
//                    () -> BlockEntityType.Builder.of(ExampleAdvancedBlockEntity::new,
//                            ModBlocks.EXAMPLE_BLOCK_ENTITY.get()).build(null));

    public static final RegistryObject<BlockEntityType<ExampleAdvancedBlockEntity>> EXAMPLE_ADVANCED_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("example_advanced_block_entity", () ->
                    BlockEntityType.Builder.of(ExampleAdvancedBlockEntity::new,
                            ModBlocks.EXAMPLE_BLOCK_ENTITY.get()).build(null));

    public static final RegistryObject<BlockEntityType<ExampleTickingBlockEntity>> EXAMPLE_TICKING_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("example_ticking_block_entity", () ->
                    BlockEntityType.Builder.of(ExampleTickingBlockEntity::new,
                            ModBlocks.EXAMPLE_TICKING_BLOCK.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}