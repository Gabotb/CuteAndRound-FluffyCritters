package net.gabotb.cuteandround.entity;

import net.gabotb.cuteandround.CuteAndRound;
import net.gabotb.cuteandround.entity.custom.LopBunnyEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CuteAndRound.MOD_ID);

    public static final RegistryObject<EntityType<LopBunnyEntity>> LOP_BUNNY =
            ENTITY_TYPES.register("lop_bunny", () -> EntityType.Builder.of(LopBunnyEntity::new, MobCategory.CREATURE)
                    .sized(0.65f, 0.6f).build("lop_bunny"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
