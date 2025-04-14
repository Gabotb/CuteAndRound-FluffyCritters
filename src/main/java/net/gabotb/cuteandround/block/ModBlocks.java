package net.gabotb.cuteandround.block;

import net.gabotb.cuteandround.CuteAndRound;
import net.gabotb.cuteandround.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    // Registro de bloques usando DeferredRegister
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CuteAndRound.MOD_ID);

    // Registro del Sand Bath Block
    public static final RegistryObject<Block> SAND_BATH_BLOCK = BLOCKS.register("sand_bath_block",
            () -> new Block(Block.Properties.copy(Blocks.SAND)) // Usa las propiedades de arena o ajusta según sea necesario
    );

    public static final RegistryObject<Block> COZY_LANTERN_BLOCK = registerBlock("cozy_lantern_block",
            () -> new CozyLanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)));

    public static final RegistryObject<Block> ALFALFA_CROP =
            BLOCKS.register("alfalfa_crop", () -> new AlfalfaCropBlock(
                    BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().noOcclusion()
            ));

    // Método para registrar bloques y sus ítems
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Método para registrar el ítem del bloque
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Método para registrar todo en el EventBus
    public static void register (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
