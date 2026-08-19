package net.windflow3r.ginium.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.windflow3r.ginium.Ginium;
import net.windflow3r.ginium.worldgen.GiniumBiomeModifiers;
import net.windflow3r.ginium.worldgen.GiniumConfiguredFeatures;
import net.windflow3r.ginium.worldgen.GiniumPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class GiniumDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            //.add(Registries.TRIM_MATERIAL, GiniumTrimMaterials::bootstrap)
            //.add(Registries.TRIM_PATTERN, GiniumTrimPatterns::bootstrap)
            //.add(Registries.ENCHANTMENT, GiniumEnchantments::bootstrap)

            .add(Registries.CONFIGURED_FEATURE, GiniumConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, GiniumPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, GiniumBiomeModifiers::bootstrap);

    public GiniumDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Ginium.MOD_ID));
    }
}