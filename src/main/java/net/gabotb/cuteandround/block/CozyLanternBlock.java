package net.gabotb.cuteandround.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class CozyLanternBlock extends Block {
    public static final BooleanProperty LIT = BooleanProperty.create("lit");

    public CozyLanternBlock(Properties properties) {
        super(properties.lightLevel(state -> state.getValue(LIT) ? 15 : 0));
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    // Al hacer clic derecho (solo si no hay redstone)
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            // Si hay redstone, no se puede usar manualmente
            if (level.hasNeighborSignal(pos)) return InteractionResult.PASS;

            boolean newLit = !state.getValue(LIT);
            level.setBlock(pos, state.setValue(LIT, newLit), 3);
        }
        return InteractionResult.SUCCESS;
    }

    // Cuando cambia el redstone cerca
    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos,
                                Block block, BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            boolean powered = level.hasNeighborSignal(pos);
            if (state.getValue(LIT) != powered) {
                level.setBlock(pos, state.setValue(LIT, powered), 3);
            }
        }
    }

    // Al colocar el bloque, que detecte si ya hay redstone
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean powered = context.getLevel().hasNeighborSignal(context.getClickedPos());
        return this.defaultBlockState().setValue(LIT, powered);
    }

    // Opcional: para que no sea opaco visualmente (como una linterna)
    @Override
    public boolean isOcclusionShapeFullBlock(BlockState state, BlockGetter level, BlockPos pos) {
        return false;
    }
}
