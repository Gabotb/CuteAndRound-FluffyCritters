package net.gabotb.cuteandround.item;

import net.gabotb.cuteandround.init.ModMenuTypes;
import net.gabotb.cuteandround.menu.FluffyCrittersGuideContainerMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class FluffyCrittersGuideBook extends Item {

    public FluffyCrittersGuideBook(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            // Abrir GUI del menú personalizado (desde servidor)
            player.openMenu(new SimpleMenuProvider(
                    (id, inventory, p) -> new FluffyCrittersGuideContainerMenu(id, inventory),
                    Component.translatable("gui.cuteandround.fluffy_critters_guide.title")
            ));

            // Reproducir sonido desde el servidor
            level.playSound(
                    null, // null para que lo escuchen todos cerca
                    player.blockPosition(),
                    SoundEvents.BOOK_PAGE_TURN,
                    player.getSoundSource(),
                    1.0F,
                    1.0F
            );
        }

        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }
}
