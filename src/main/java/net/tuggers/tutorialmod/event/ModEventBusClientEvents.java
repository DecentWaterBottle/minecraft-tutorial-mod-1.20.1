package net.tuggers.tutorialmod.event;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tuggers.tutorialmod.TutorialMod;
import net.tuggers.tutorialmod.entity.client.ModModelLayers;
import net.tuggers.tutorialmod.entity.client.RhinoModel;
import net.tuggers.tutorialmod.render.entity.SpearStoneModel;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusClientEvents {


    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.RHINO_LAYER, RhinoModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.THROWABLE_SPEAR_LAYER, SpearStoneModel::createBodyLayer);

    }
}
