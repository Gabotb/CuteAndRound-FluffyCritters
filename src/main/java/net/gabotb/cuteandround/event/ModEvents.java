package net.gabotb.cuteandround.event;

import net.gabotb.cuteandround.item.ModItems;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "cuteandround", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    @SubscribeEvent
    public static void onEntityJoinLevel(EntityJoinLevelEvent event) {
        // Verifica si la entidad es un aldeano
        if (event.getEntity() instanceof Villager villager) {
            // Verifica si el aldeano es un agricultor
            if (villager.getVillagerData().getProfession() == VillagerProfession.FARMER) {
                // Verifica si el inventario del aldeano ya contiene semillas de alfalfa
                boolean hasAlfalfaSeeds = false;
                for (int i = 0; i < villager.getInventory().getContainerSize(); i++) {
                    ItemStack stack = villager.getInventory().getItem(i);
                    if (stack.getItem() == ModItems.ALFALFA_SEEDS.get()) {
                        hasAlfalfaSeeds = true;
                        break;
                    }
                }

                // Si no tiene semillas de alfalfa, agrégalas al inventario
                if (!hasAlfalfaSeeds) {
                    villager.getInventory().addItem(new ItemStack(ModItems.ALFALFA_SEEDS.get(), 8));
                }
            }
        }
    }
}