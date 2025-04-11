package net.gabotb.cuteandround.item;

import net.gabotb.cuteandround.menu.FluffyCrittersGuideContainerMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class FluffyCrittersGuideBook extends Item {
    // Constructor para el ítem
    public FluffyCrittersGuideBook(Properties properties) {
        super(properties);
    }

    // Sobrescribimos el método useOn() para abrir la GUI al hacer clic derecho
    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide && context.getPlayer() != null) { // Asegura que esté en el servidor y el jugador no sea nulo
            Player player = context.getPlayer();

            // Abre la GUI personalizada cuando el jugador hace clic derecho con el libro
            player.openMenu(new MenuProvider() {
                @Override
                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                    // Asegúrate de usar el contenedor del lado del servidor
                    return new FluffyCrittersGuideContainerMenu(id, inventory, null);
                }

                @Override
                public Component getDisplayName() {
                    return Component.literal("Fluffy Critters Guide");
                }
            });
        }
        return InteractionResult.sidedSuccess(context.getLevel().isClientSide);
    }
}