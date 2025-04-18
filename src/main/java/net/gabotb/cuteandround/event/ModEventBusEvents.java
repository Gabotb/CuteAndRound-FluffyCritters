package net.gabotb.cuteandround.event;

import net.gabotb.cuteandround.entity.ModEntities;
import net.gabotb.cuteandround.entity.custom.LopBunnyEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
        modid = "cuteandround",
        bus = Bus.MOD
)
public class ModEventBusEvents {
    public ModEventBusEvents() {
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put((EntityType)ModEntities.LOP_BUNNY.get(), LopBunnyEntity.createAttributes().build());
    }
}