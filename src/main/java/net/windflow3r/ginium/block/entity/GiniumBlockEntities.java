package net.windflow3r.ginium.block.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.windflow3r.ginium.Ginium;
import net.windflow3r.ginium.block.GiniumBlocks;

import java.util.function.Supplier;

public class GiniumBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Ginium.MOD_ID);

    public static final Supplier<BlockEntityType<PowderizerBlockEntity>> POWDERIZER_BE =
            BLOCK_ENTITIES.register("powderizer", () -> BlockEntityType.Builder.of(
                    PowderizerBlockEntity::new, GiniumBlocks.POWDERIZER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}