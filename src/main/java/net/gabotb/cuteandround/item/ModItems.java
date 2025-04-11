package net.gabotb.cuteandround.item;

import net.gabotb.cuteandround.CuteAndRound;
import net.gabotb.cuteandround.block.ModBlocks;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CuteAndRound.MOD_ID);

    public static final RegistryObject<Item> SAND_BATH_BLOCK_ITEM = ITEMS.register("sand_bath_block",
            () -> new BlockItem(ModBlocks.SAND_BATH_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> ALFALFA_SEEDS = ITEMS.register("alfalfa_seeds",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLUFFY_GUIDE_BOOK = ITEMS.register("fluffy_guide_book",
            () -> new Item(new Item.Properties().stacksTo(1)));


    public static final RegistryObject<Item> BANANA =
            ITEMS.register("banana", () ->
                    new Item(new Item.Properties()
                            .food(new FoodProperties.Builder()
                                    .nutrition(4)
                                    .saturationMod(0.4f)
                                    .build())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
