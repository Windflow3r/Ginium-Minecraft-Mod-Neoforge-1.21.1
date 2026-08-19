package net.windflow3r.ginium.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.windflow3r.ginium.Ginium;
import net.windflow3r.ginium.block.GiniumBlocks;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

public class GiniumConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_GINIUM_ORE_KEY =registerKey("ginium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_RAINBERG_ORE_KEY =registerKey("rainberg_deepslate_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ROSITE_ORE_KEY =registerKey("nether_rosite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_NYLITE_ORE_KEY =registerKey("end_nylite_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_GINITE_KEY =registerKey("ginite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_NIMBITE_KEY =registerKey("nimbite");



    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldGiniumOre = List.of(
                OreConfiguration.target(stoneReplaceables, GiniumBlocks.GINIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, GiniumBlocks.GINIUM_DEEPSLATE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldGinite = List.of(
                OreConfiguration.target(stoneReplaceables, GiniumBlocks.GINITE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, GiniumBlocks.GINITE.get().defaultBlockState()));

        register(context, OVERWORLD_GINIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldGiniumOre, 9));
        register(context, OVERWORLD_RAINBERG_ORE_KEY, Feature.ORE, new OreConfiguration(deepslateReplaceables, GiniumBlocks.RAINBERG_DEEPSLATE_ORE.get().defaultBlockState(), 8));
        register(context, NETHER_ROSITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, GiniumBlocks.ROSITE_NETHER_ORE.get().defaultBlockState(), 6));
        register(context, END_NYLITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, GiniumBlocks.NYLITE_END_ORE.get().defaultBlockState(), 5));

        register(context, OVERWORLD_GINITE_KEY, Feature.ORE,
                new OreConfiguration(overworldGinite, 37));


        register(context, OVERWORLD_NIMBITE_KEY, Feature.ORE,
                new OreConfiguration(
                        List.of(
                                OreConfiguration.target(
                                        deepslateReplaceables,
                                        GiniumBlocks.NIMBITE.get().defaultBlockState()
                                )
                        ),
                        34
                ));


    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Ginium.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}