package net.windflow3r.ginium.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
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
}
