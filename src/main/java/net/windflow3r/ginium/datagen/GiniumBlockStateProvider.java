package net.windflow3r.ginium.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.windflow3r.ginium.Ginium;
import net.windflow3r.ginium.block.GiniumBlocks;

public class GiniumBlockStateProvider extends BlockStateProvider {
    public GiniumBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Ginium.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(GiniumBlocks.GINITE);

        blockWithItem(GiniumBlocks.NIMBITE);
        blockWithItem(GiniumBlocks.POLISHED_NIMBITE);
        stairsBlock(GiniumBlocks.POLISHED_NIMBITE_STAIRS.get(), blockTexture(GiniumBlocks.POLISHED_NIMBITE.get()));
        slabBlock(GiniumBlocks.POLISHED_NIMBITE_SLAB.get(), blockTexture(GiniumBlocks.POLISHED_NIMBITE.get()), blockTexture(GiniumBlocks.POLISHED_NIMBITE.get()));
        buttonBlock(GiniumBlocks.POLISHED_NIMBITE_BUTTON.get(), blockTexture(GiniumBlocks.POLISHED_NIMBITE.get()));
        pressurePlateBlock(GiniumBlocks.POLISHED_NIMBITE_PLATE.get(), blockTexture(GiniumBlocks.POLISHED_NIMBITE.get()));
        wallBlock(GiniumBlocks.POLISHED_NIMBITE_WALL.get(), blockTexture(GiniumBlocks.POLISHED_NIMBITE.get()));
        blockWithItem(GiniumBlocks.NIMBITE_BRICKS);
        stairsBlock(GiniumBlocks.NIMBITE_BRICKS_STAIRS.get(), blockTexture(GiniumBlocks.NIMBITE_BRICKS.get()));
        slabBlock(GiniumBlocks.NIMBITE_BRICKS_SLAB.get(), blockTexture(GiniumBlocks.NIMBITE_BRICKS.get()), blockTexture(GiniumBlocks.NIMBITE_BRICKS.get()));
        wallBlock(GiniumBlocks.NIMBITE_BRICKS_WALL.get(), blockTexture(GiniumBlocks.NIMBITE_BRICKS.get()));
        blockWithItem(GiniumBlocks.CHISELED_NIMBITE);


        blockWithItem(GiniumBlocks.GINIUM_BLOCK);
        blockWithItem(GiniumBlocks.RAINBERG_BLOCK);


        blockWithItem(GiniumBlocks.GINIUM_ORE);
        blockWithItem(GiniumBlocks.GINIUM_DEEPSLATE_ORE);
        blockWithItem(GiniumBlocks.RAINBERG_DEEPSLATE_ORE);

        blockWithItem(GiniumBlocks.IMBRIUM_BLOCK);

        blockWithItem(GiniumBlocks.ROSITE_NETHER_ORE);
        blockWithItem(GiniumBlocks.NYLITE_END_ORE);

        blockWithItem(GiniumBlocks.SOFIUM_BLOCK);


    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("windflowersginium:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockWithItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("windflowersginium:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
