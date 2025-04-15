package net.gabotb.cuteandround;

import net.gabotb.cuteandround.block.ModBlocks;
import net.gabotb.cuteandround.entity.ModEntities;
import net.gabotb.cuteandround.entity.client.LopBunnyRenderer;
import net.gabotb.cuteandround.event.ModEvents;
import net.gabotb.cuteandround.event.ModLootTables;
import net.gabotb.cuteandround.gui.FluffyCrittersGuideMenu;
import net.gabotb.cuteandround.init.ModMenuTypes;
import net.gabotb.cuteandround.item.ModCreativeModTabs;
import net.gabotb.cuteandround.item.ModItems;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Main mod class for Round & Cute: Fluffy Critters.
 */
@Mod(CuteAndRound.MOD_ID)
public class CuteAndRound {
    public static final String MOD_ID = "cuteandround";

    public CuteAndRound() {
        // Event bus del mod (requerido para el registro de contenido)
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Registro de contenido
        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModMenuTypes.MENU_TYPES.register(modEventBus);
        ModLootTables.init(); // No usa EventBus, se llama directamente

        // Listeners específicos del mod
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        // Registro a eventos generales de Forge
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new ModEvents()); // Agregar registro de ModEvents
    }

    // Setup común (cliente + servidor)
    private void commonSetup(final FMLCommonSetupEvent event) {
        // Lógica de inicialización común
        event.enqueueWork(() -> {
            // Agregar las semillas de alfalfa al compostador con la misma probabilidad que las semillas de trigo
            ComposterBlock.COMPOSTABLES.put(ModItems.ALFALFA_SEEDS.get(), 0.3f);
        });
    }

    // Agrega objetos al creative tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.BANANA.get()); // Agrega la banana al tab de comida
        }
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event){

    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.LOP_BUNNY.get(), LopBunnyRenderer::new);
        }
    }
}