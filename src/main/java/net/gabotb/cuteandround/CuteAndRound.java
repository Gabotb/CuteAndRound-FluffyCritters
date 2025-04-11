package net.gabotb.cuteandround;

import net.gabotb.cuteandround.block.ModBlocks;
import net.gabotb.cuteandround.event.ModLootTables;
import net.gabotb.cuteandround.init.ModMenuTypes;
import net.gabotb.cuteandround.item.ModCreativeModTabs;
import net.gabotb.cuteandround.item.ModItems;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.gabotb.cuteandround.gui.FluffyCrittersGuideMenu;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CuteAndRound.MOD_ID)
public class CuteAndRound {
    public static final String MOD_ID = "cuteandround";

    public CuteAndRound() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModMenuTypes.MENU_TYPES.register(modEventBus);
        ModLootTables.init();

        // Registrar eventos comunes
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        // Registrar eventos de Forge
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Lógica común
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.BANANA.get());
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Lógica del servidor
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.FLUFFY_CRITTERS_GUIDE_MENU.get(), FluffyCrittersGuideMenu::new);
        }
    }
}