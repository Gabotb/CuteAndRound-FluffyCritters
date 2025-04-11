package net.gabotb.cuteandround.init;

import net.gabotb.cuteandround.CuteAndRound;
import net.gabotb.cuteandround.menu.FluffyCrittersGuideContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    // Registro diferido para los MenuTypes del mod
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, CuteAndRound.MOD_ID);

    // Registro del FluffyCrittersGuideContainerMenu
    public static final RegistryObject<MenuType<FluffyCrittersGuideContainerMenu>> FLUFFY_CRITTERS_GUIDE_MENU =
            MENU_TYPES.register("fluffy_critters_guide_menu",
                    () -> IForgeMenuType.create((windowId, inv, data) -> new FluffyCrittersGuideContainerMenu(windowId, inv, ContainerLevelAccess.NULL)));
}