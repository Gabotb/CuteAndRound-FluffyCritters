package net.gabotb.cuteandround.menu;

import net.gabotb.cuteandround.init.ModMenuTypes; // Asegúrate de tener el registro en ModMenuTypes
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;

public class FluffyCrittersGuideContainerMenu extends AbstractContainerMenu {

    private final ContainerLevelAccess access;

    // Constructor
    public FluffyCrittersGuideContainerMenu(int id, Inventory playerInventory, ContainerLevelAccess access) {
        super(ModMenuTypes.FLUFFY_CRITTERS_GUIDE_MENU.get(), id); // Usa el MenuType registrado
        this.access = access;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        // Implementa la lógica para mover ítems rápidamente
        return ItemStack.EMPTY; // Por defecto, devuelve un stack vacío
    }

    @Override
    public boolean stillValid(Player player) {
        // Permite que el jugador interactúe con el menú si está cerca
        return access.evaluate((world, pos) -> true, true); // Cambia la lógica según sea necesario
    }
}