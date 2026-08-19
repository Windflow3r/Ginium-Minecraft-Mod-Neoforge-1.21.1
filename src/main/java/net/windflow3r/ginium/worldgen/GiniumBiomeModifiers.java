package net.windflow3r.ginium.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.windflow3r.ginium.Ginium;

public class GiniumBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_GINIUM_ORE = registerKey("add_ginium_ore");
    public static final ResourceKey<BiomeModifier> ADD_RAINBERG_DEEPSLATE_ORE = registerKey("add_rainberg_deepslate_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_ROSITE_ORE = registerKey("add_nether_rosite_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_NYLITE_ORE = registerKey("add_end_nylite_ore");

    public static final ResourceKey<BiomeModifier> ADD_GINITE = registerKey("add_ginite");
    public static final ResourceKey<BiomeModifier> ADD_NIMBITE = registerKey("add_nimbite");



    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        // CF -> PF -> BM
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_GINIUM_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GiniumPlacedFeatures.GINIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_RAINBERG_DEEPSLATE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GiniumPlacedFeatures.RAINBERG_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NETHER_ROSITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(GiniumPlacedFeatures.NETHER_ROSITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_END_NYLITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(GiniumPlacedFeatures.END_NYLITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));



        context.register(ADD_GINITE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GiniumPlacedFeatures.GINITE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NIMBITE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GiniumPlacedFeatures.NIMBITE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Ginium.MOD_ID, name));
    }
}
