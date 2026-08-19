package net.windflow3r.ginium.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.windflow3r.ginium.Ginium;

import java.util.List;

public class GiniumPlacedFeatures {
    public static final ResourceKey<PlacedFeature> GINIUM_ORE_PLACED_KEY = registerKey("ginium_ore_placed");
    public static final ResourceKey<PlacedFeature> RAINBERG_ORE_PLACED_KEY = registerKey("rainberg_deepslate_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_ROSITE_ORE_PLACED_KEY = registerKey("nether_rosite_ore_placed");
    public static final ResourceKey<PlacedFeature> END_NYLITE_ORE_PLACED_KEY = registerKey("end_nylite_ore_placed");

    public static final ResourceKey<PlacedFeature> GINITE_PLACED_KEY = registerKey("ginite_placed");
    public static final ResourceKey<PlacedFeature> NIMBITE_PLACED_KEY = registerKey("nimbite_placed");



    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, GINIUM_ORE_PLACED_KEY,configuredFeatures.getOrThrow(GiniumConfiguredFeatures.OVERWORLD_GINIUM_ORE_KEY),
                RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), GiniumOrePlacement.commonOrePlacement(13, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, RAINBERG_ORE_PLACED_KEY,configuredFeatures.getOrThrow(GiniumConfiguredFeatures.OVERWORLD_RAINBERG_ORE_KEY),
                RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), GiniumOrePlacement.commonOrePlacement(11, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-20))));

        register(context, NETHER_ROSITE_ORE_PLACED_KEY,configuredFeatures.getOrThrow(GiniumConfiguredFeatures.NETHER_ROSITE_ORE_KEY),
                RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), GiniumOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(6), VerticalAnchor.absolute(100))));

        register(context, END_NYLITE_ORE_PLACED_KEY,configuredFeatures.getOrThrow(GiniumConfiguredFeatures.END_NYLITE_ORE_KEY),
                RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), GiniumOrePlacement.commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));


        register(context, GINITE_PLACED_KEY,configuredFeatures.getOrThrow(GiniumConfiguredFeatures.OVERWORLD_GINITE_KEY), RarityFilter.onAverageOnceEvery(100), InSquarePlacement.spread(),
                GiniumOrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-42), VerticalAnchor.absolute(42))));

        register(context, NIMBITE_PLACED_KEY,configuredFeatures.getOrThrow(GiniumConfiguredFeatures.OVERWORLD_NIMBITE_KEY), RarityFilter.onAverageOnceEvery(100), InSquarePlacement.spread(),
                GiniumOrePlacement.commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-44))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Ginium.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 RarityFilter rarityFilter, InSquarePlacement spread, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
