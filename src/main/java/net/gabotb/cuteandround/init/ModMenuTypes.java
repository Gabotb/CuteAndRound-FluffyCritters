package net.gabotb.cuteandround.init;

import net.gabotb.cuteandround.menu.FluffyCrittersGuideContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, "cuteandround");

    public static final RegistryObject<MenuType<FluffyCrittersGuideContainerMenu>> FLUFFY_CRITTERS_GUIDE_MENU =
            MENU_TYPES.register("fluffy_critters_guide_menu",
                    () -> IForgeMenuType.create((windowId, playerInventory, data) ->
                            new FluffyCrittersGuideContainerMenu(windowId, playerInventory, data)));

    public static void register(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
    }
}