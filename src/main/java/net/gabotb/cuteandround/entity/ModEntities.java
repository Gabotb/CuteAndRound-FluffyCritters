package net.gabotb.cuteandround.entity;

import net.gabotb.cuteandround.entity.custom.LopBunnyEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES;
    public static final RegistryObject<EntityType<LopBunnyEntity>> LOP_BUNNY;

    public ModEntities() {
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

    static {
        ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "cuteandround");
        LOP_BUNNY = ENTITY_TYPES.register("lop_bunny", () -> {
            return Builder.of(LopBunnyEntity::new, MobCategory.CREATURE).sized(0.65F, 0.6F).build("lop_bunny");
        });
    }
}