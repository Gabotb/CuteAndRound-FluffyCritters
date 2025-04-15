package net.gabotb.cuteandround.item;

import net.gabotb.cuteandround.CuteAndRound;
import net.gabotb.cuteandround.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CuteAndRound.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CUTEANDROUND_TAB = CREATIVE_MODE_TABS.register("cuteandround_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BANANA.get()))
                    .title(Component.translatable("creativetab.cuteandround_tab"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BANANA.get());
                        output.accept(ModItems.ALFALFA_SEEDS.get());
                        output.accept(ModItems.FLUFFY_GUIDE_BOOK.get());
                        output.accept(ModItems.PICNIC_BASKET.get());
                        output.accept(ModItems.ALFALFA_BLOSSOM.get());
                        output.accept(ModItems.LOP_BUNNY_SPAWN_EGG.get());

                        output.accept(ModBlocks.SAND_BATH_BLOCK.get());
                        output.accept(ModBlocks.COZY_LANTERN_BLOCK.get().asItem());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
