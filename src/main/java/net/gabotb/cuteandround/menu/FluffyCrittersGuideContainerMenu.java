package net.gabotb.cuteandround.menu;

import io.netty.buffer.Unpooled;
import net.gabotb.cuteandround.init.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;

public class FluffyCrittersGuideContainerMenu extends AbstractContainerMenu {

    private final ContainerLevelAccess access;

    // Constructor principal con FriendlyByteBuf
    public FluffyCrittersGuideContainerMenu(int id, Inventory playerInventory, FriendlyByteBuf extraData) {
        super(ModMenuTypes.FLUFFY_CRITTERS_GUIDE_MENU.get(), id);
        this.access = ContainerLevelAccess.NULL;
        // Agrega slots o lógica aquí si es necesario
    }

    // Constructor adicional para SimpleMenuProvider
    public FluffyCrittersGuideContainerMenu(int id, Inventory playerInventory) {
        this(id, playerInventory, new FriendlyByteBuf(Unpooled.buffer()));
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
