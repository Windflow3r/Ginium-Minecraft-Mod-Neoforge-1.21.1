package net.windflow3r.ginium.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.windflow3r.ginium.Ginium;
import net.windflow3r.ginium.block.GiniumBlocks;
import net.windflow3r.ginium.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class GiniumBlockTagProvider extends BlockTagsProvider {
    public GiniumBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Ginium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(GiniumBlocks.GINITE.get())
                .add(GiniumBlocks.NIMBITE.get())
                .add(GiniumBlocks.GINIUM_BLOCK.get())
                .add(GiniumBlocks.GINIUM_ORE.get())
                .add(GiniumBlocks.GINIUM_DEEPSLATE_ORE.get())
                .add(GiniumBlocks.RAINBERG_BLOCK.get())
                .add(GiniumBlocks.RAINBERG_DEEPSLATE_ORE.get())
                .add(GiniumBlocks.ROSITE_NETHER_ORE.get())
                .add(GiniumBlocks.NYLITE_END_ORE.get())
                .add(GiniumBlocks.IMBRIUM_BLOCK.get())
                .add(GiniumBlocks.SOFIUM_BLOCK.get());




        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(GiniumBlocks.GINIUM_ORE.get())
                .add(GiniumBlocks.GINIUM_DEEPSLATE_ORE.get())
                .add(GiniumBlocks.GINIUM_BLOCK.get());

        tag(ModTags.Blocks.NEEDS_GINIUM_TOOL)
                .add(GiniumBlocks.NIMBITE.get())
                .add(GiniumBlocks.RAINBERG_BLOCK.get())
                .add(GiniumBlocks.RAINBERG_DEEPSLATE_ORE.get())
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(GiniumBlocks.NIMBITE.get())
                .add(GiniumBlocks.RAINBERG_BLOCK.get())
                .add(GiniumBlocks.RAINBERG_DEEPSLATE_ORE.get());

        tag(ModTags.Blocks.NEEDS_IMBRIUM_TOOL)
                .add(GiniumBlocks.NIMBITE.get())
                .add(GiniumBlocks.RAINBERG_BLOCK.get())
                .add(GiniumBlocks.RAINBERG_DEEPSLATE_ORE.get())
                .add(GiniumBlocks.ROSITE_NETHER_ORE.get())
                .add(GiniumBlocks.NYLITE_END_ORE.get())
                .add(GiniumBlocks.IMBRIUM_BLOCK.get())
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.NEEDS_SOFIUM_TOOL)
                .add(GiniumBlocks.NIMBITE.get())
                .add(GiniumBlocks.RAINBERG_BLOCK.get())
                .add(GiniumBlocks.RAINBERG_DEEPSLATE_ORE.get())
                .add(GiniumBlocks.ROSITE_NETHER_ORE.get())
                .add(GiniumBlocks.NYLITE_END_ORE.get())
                .add(GiniumBlocks.IMBRIUM_BLOCK.get())
                .add(GiniumBlocks.SOFIUM_BLOCK.get())
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);




        tag(ModTags.Blocks.INCORRECT_FOR_GINIUM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_GINIUM_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_IMBRIUM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_IMBRIUM_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_SOFIUM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .remove(ModTags.Blocks.NEEDS_SOFIUM_TOOL);

    }
}