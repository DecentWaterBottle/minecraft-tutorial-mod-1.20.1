package net.tuggers.tutorialmod.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tuggers.tutorialmod.TutorialMod;
import net.tuggers.tutorialmod.entity.custom.RhinoEntity;
import net.tuggers.tutorialmod.item.custom.ThrowableSpearEntity;

import java.util.function.BiFunction;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<EntityType<RhinoEntity>> RHINO = ENTITY_TYPES.register("rhino",
            () -> EntityType.Builder.of(RhinoEntity::new, MobCategory.CREATURE)
            .sized(2.5f, 2.5f).build("rhino"));

//    public static final RegistryObject<EntityType<Entity>> THROWABLE_SPEAR = ENTITY_TYPES.register("throwable_spear",
//            () -> EntityType.Builder.of(ThrowableSpearEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).
//                    fireImmune().noSummon().setUpdateInterval(1)
//                    .setShouldReceiveVelocityUpdates(true).build("throwable_spear"));

    public static final RegistryObject<EntityType<ThrowableSpearEntity>> THROWABLE_SPEAR = registerBasic("throwable_spear", ThrowableSpearEntity::new);


//    FROM MrCrayfish
    private static <T extends Entity> RegistryObject<EntityType<T>> registerBasic(String id, BiFunction<EntityType<T>, Level, T> function)
    {
        return ENTITY_TYPES.register(id, () -> EntityType.Builder.of(function::apply, MobCategory.MISC)
                .sized(0.25F, 0.25F)
                .setTrackingRange(100)
                .setUpdateInterval(1)
                .noSummon()
                .fireImmune()
                .setShouldReceiveVelocityUpdates(true).build(id));
    }



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
