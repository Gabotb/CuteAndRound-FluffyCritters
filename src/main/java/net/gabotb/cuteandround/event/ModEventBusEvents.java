package net.gabotb.cuteandround.event;

import net.gabotb.cuteandround.CuteAndRound;
import net.gabotb.cuteandround.entity.ModEntities;
import net.gabotb.cuteandround.entity.custom.LopBunnyEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CuteAndRound.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
@SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.LOP_BUNNY.get(), LopBunnyEntity.createAttributes().build());
    }
}
