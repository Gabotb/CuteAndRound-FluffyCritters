package net.gabotb.cuteandround.event;

import net.gabotb.cuteandround.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModLootTables {
    public static void init() {
        MinecraftForge.EVENT_BUS.register(new ModLootTables());
    }

    @SubscribeEvent
    public void onLootTableLoad(LootTableLoadEvent event) {
        ResourceLocation plainsLootTable = ResourceLocation.tryParse("minecraft:chests/village/village_plains_house");

        ResourceLocation savannaLootTable = ResourceLocation.tryParse("minecraft:chests/village/village_savanna_house");

        if (event.getName().equals(savannaLootTable)) {
            LootPool pool = LootPool.lootPool()
                    .name("cuteandround_alfalfa_seeds_pool")
                    .setRolls(UniformGenerator.between(1, 1))
                    .add(LootItem.lootTableItem(ModItems.ALFALFA_SEEDS.get())
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                    .build();
            event.getTable().addPool(pool);
        }

        if (event.getName().equals(plainsLootTable)) {
            LootPool pool = LootPool.lootPool()
                    .name("cuteandround_alfalfa_seeds_pool")
                    .setRolls(UniformGenerator.between(1, 1))
                    .add(LootItem.lootTableItem(ModItems.ALFALFA_SEEDS.get())
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                    .build();

            event.getTable().addPool(pool);
        }
    }
}