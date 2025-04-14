package net.gabotb.cuteandround.block;

import net.gabotb.cuteandround.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootContext;

import java.util.ArrayList;
import java.util.List;

public class AlfalfaCropBlock extends CropBlock {
    public static final int MAX_AGE = 7;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;

    public AlfalfaCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.ALFALFA_SEEDS.get();
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, net.minecraft.world.level.storage.loot.LootParams.Builder builder) {
        if (state.getValue(this.getAgeProperty()) >= this.getMaxAge()) {
            List<ItemStack> drops = new ArrayList<>();

            // 1–3 semillas
            int seedCount = 1 + builder.getLevel().getRandom().nextInt(3);
            drops.add(new ItemStack(ModItems.ALFALFA_SEEDS.get(), seedCount));

            // 2 flores
            drops.add(new ItemStack(ModItems.ALFALFA_BLOSSOM.get(), 2));

            return drops;
        }

        // Lógica vanilla para cultivos no maduros
        return super.getDrops(state, builder);
    }
}