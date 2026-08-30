package net.windflow3r.ginium.datagen;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.windflow3r.ginium.Ginium;
import net.windflow3r.ginium.block.GiniumBlocks;
import net.windflow3r.ginium.block.custom.PowderizerBlock;

public class GiniumBlockStateProvider extends BlockStateProvider {

    public GiniumBlockStateProvider(
            PackOutput output,
            ExistingFileHelper exFileHelper
    ) {
        super(output, Ginium.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(GiniumBlocks.GINITE);

        blockWithItem(GiniumBlocks.NIMBITE);
        blockWithItem(GiniumBlocks.POLISHED_NIMBITE);

        stairsBlock(
                GiniumBlocks.POLISHED_NIMBITE_STAIRS.get(),
                blockTexture(GiniumBlocks.POLISHED_NIMBITE.get())
        );

        slabBlock(
                GiniumBlocks.POLISHED_NIMBITE_SLAB.get(),
                blockTexture(GiniumBlocks.POLISHED_NIMBITE.get()),
                blockTexture(GiniumBlocks.POLISHED_NIMBITE.get())
        );

        buttonBlock(
                GiniumBlocks.POLISHED_NIMBITE_BUTTON.get(),
                blockTexture(GiniumBlocks.POLISHED_NIMBITE.get())
        );

        pressurePlateBlock(
                GiniumBlocks.POLISHED_NIMBITE_PLATE.get(),
                blockTexture(GiniumBlocks.POLISHED_NIMBITE.get())
        );

        wallBlock(
                GiniumBlocks.POLISHED_NIMBITE_WALL.get(),
                blockTexture(GiniumBlocks.POLISHED_NIMBITE.get())
        );

        blockWithItem(GiniumBlocks.NIMBITE_BRICKS);

        stairsBlock(
                GiniumBlocks.NIMBITE_BRICKS_STAIRS.get(),
                blockTexture(GiniumBlocks.NIMBITE_BRICKS.get())
        );

        slabBlock(
                GiniumBlocks.NIMBITE_BRICKS_SLAB.get(),
                blockTexture(GiniumBlocks.NIMBITE_BRICKS.get()),
                blockTexture(GiniumBlocks.NIMBITE_BRICKS.get())
        );

        wallBlock(
                GiniumBlocks.NIMBITE_BRICKS_WALL.get(),
                blockTexture(GiniumBlocks.NIMBITE_BRICKS.get())
        );

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

        powderizer();
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(
                deferredBlock.get(),
                cubeAll(deferredBlock.get())
        );
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(
                deferredBlock.get(),
                new ModelFile.UncheckedModelFile(
                        "windflowersginium:block/"
                                + deferredBlock.getId().getPath()
                )
        );
    }

    private void blockItem(
            DeferredBlock<?> deferredBlock,
            String appendix
    ) {
        simpleBlockWithItem(
                deferredBlock.get(),
                new ModelFile.UncheckedModelFile(
                        "windflowersginium:block/"
                                + deferredBlock.getId().getPath()
                                + appendix
                )
        );
    }

    private void powderizer() {

        ModelFile powderizerOff = models().cube(
                "powderizer",

                // Bottom
                modLoc("block/powderizer_top"),

                // Top
                modLoc("block/powderizer_top"),

                // North
                modLoc("block/powderizer_side"),

                // South / Front
                modLoc("block/powderizer_front"),

                // West
                modLoc("block/powderizer_side"),

                // East
                modLoc("block/powderizer_side")
        ).texture("particle", modLoc("block/powderizer_side"));

        ModelFile powderizerOn = models().cube(
                "powderizer_on",

                // Bottom
                modLoc("block/powderizer_top"),

                // Top
                modLoc("block/powderizer_top"),

                // North
                modLoc("block/powderizer_side"),

                // South / Front
                modLoc("block/powderizer_front_on"),

                // West
                modLoc("block/powderizer_side"),

                // East
                modLoc("block/powderizer_side")
        ).texture("particle", modLoc("block/powderizer_side"));

        getVariantBuilder(GiniumBlocks.POWDERIZER.get())

                // SOUTH
                .partialState()
                .with(PowderizerBlock.FACING, Direction.SOUTH)
                .with(PowderizerBlock.LIT, false)
                .modelForState()
                .modelFile(powderizerOff)
                .rotationY(0)
                .addModel()

                // WEST
                .partialState()
                .with(PowderizerBlock.FACING, Direction.WEST)
                .with(PowderizerBlock.LIT, false)
                .modelForState()
                .modelFile(powderizerOff)
                .rotationY(90)
                .addModel()

                // NORTH
                .partialState()
                .with(PowderizerBlock.FACING, Direction.NORTH)
                .with(PowderizerBlock.LIT, false)
                .modelForState()
                .modelFile(powderizerOff)
                .rotationY(180)
                .addModel()

                // EAST
                .partialState()
                .with(PowderizerBlock.FACING, Direction.EAST)
                .with(PowderizerBlock.LIT, false)
                .modelForState()
                .modelFile(powderizerOff)
                .rotationY(270)
                .addModel()

                // SOUTH - ON
                .partialState()
                .with(PowderizerBlock.FACING, Direction.SOUTH)
                .with(PowderizerBlock.LIT, true)
                .modelForState()
                .modelFile(powderizerOn)
                .rotationY(0)
                .addModel()

                // WEST - ON
                .partialState()
                .with(PowderizerBlock.FACING, Direction.WEST)
                .with(PowderizerBlock.LIT, true)
                .modelForState()
                .modelFile(powderizerOn)
                .rotationY(90)
                .addModel()

                // NORTH - ON
                .partialState()
                .with(PowderizerBlock.FACING, Direction.NORTH)
                .with(PowderizerBlock.LIT, true)
                .modelForState()
                .modelFile(powderizerOn)
                .rotationY(180)
                .addModel()

                // EAST - ON
                .partialState()
                .with(PowderizerBlock.FACING, Direction.EAST)
                .with(PowderizerBlock.LIT, true)
                .modelForState()
                .modelFile(powderizerOn)
                .rotationY(270)
                .addModel();

        itemModels().getBuilder("powderizer")
                .parent(
                        new ModelFile.UncheckedModelFile(
                                modLoc("block/powderizer")
                        )
                );
    }
}
