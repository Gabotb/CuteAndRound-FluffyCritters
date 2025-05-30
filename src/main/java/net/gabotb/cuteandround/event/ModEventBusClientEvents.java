package net.gabotb.cuteandround.event;

import net.gabotb.cuteandround.entity.client.LopBunnyModel;
import net.gabotb.cuteandround.entity.client.ModModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
        modid = "cuteandround",
        bus = Bus.MOD,
        value = {Dist.CLIENT}
)
public class ModEventBusClientEvents {
    public ModEventBusClientEvents() {
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.LOP_BUNNY_LAYER, LopBunnyModel::createBodyLayer);
    }
}
