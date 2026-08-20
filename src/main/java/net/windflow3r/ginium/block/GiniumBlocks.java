package net.windflow3r.ginium.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.windflow3r.ginium.Ginium;
import net.windflow3r.ginium.item.GiniumItems;

import java.util.function.Supplier;

public class GiniumBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Ginium.MOD_ID);

    public static final DeferredBlock<Block> GINITE = registerBlock("ginite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
            ));

    public static final DeferredBlock<Block> GINIUM_BLOCK = registerBlock("ginium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
            ));

    public static final DeferredBlock<Block> GINIUM_ORE = registerBlock("ginium_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> GINIUM_DEEPSLATE_ORE = registerBlock("ginium_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of()
                            .strength(3f).requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE)
            ));

    //N
    public static final DeferredBlock<Block> NIMBITE = registerBlock("nimbite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
            ));

    public static final DeferredBlock<Block> POLISHED_NIMBITE = registerBlock("polished_nimbite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
            ));

    public static final DeferredBlock<StairBlock> POLISHED_NIMBITE_STAIRS = registerBlock("polished_nimbite_stairs",
            () -> new StairBlock(GiniumBlocks.POLISHED_NIMBITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
            ));

    public static final DeferredBlock<SlabBlock> POLISHED_NIMBITE_SLAB = registerBlock("polished_nimbite_slab",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
            ));

    public static final DeferredBlock<PressurePlateBlock> POLISHED_NIMBITE_PLATE = registerBlock("polished_nimbite_plate",
            () -> new PressurePlateBlock(BlockSetType.GOLD,
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
            ));

    public static final DeferredBlock<ButtonBlock> POLISHED_NIMBITE_BUTTON = registerBlock("polished_nimbite_button",
            () -> new ButtonBlock(BlockSetType.GOLD, 20, BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().noCollission()
                    .sound(SoundType.AMETHYST)
            ));

    public static final DeferredBlock<WallBlock> POLISHED_NIMBITE_WALL = registerBlock("polished_nimbite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
            ));



    public static final DeferredBlock<Block> RAINBERG_BLOCK = registerBlock("rainberg_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
            ));

    public static final DeferredBlock<Block> RAINBERG_DEEPSLATE_ORE = registerBlock("rainberg_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of()
                            .strength(3f).requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE)
            ));

    public static final DeferredBlock<Block> IMBRIUM_BLOCK = registerBlock("imbrium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
            ));

    public static final DeferredBlock<Block> ROSITE_NETHER_ORE = registerBlock("rosite_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 3),
                    BlockBehaviour.Properties.of()
                            .strength(3f).requiresCorrectToolForDrops()
                            .sound(SoundType.NETHER_ORE)
            ));

    public static final DeferredBlock<Block> NYLITE_END_ORE = registerBlock("nylite_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 3),
                    BlockBehaviour.Properties.of()
                            .strength(3f).requiresCorrectToolForDrops()
                            .sound(SoundType.SCULK)
            ));

    public static final DeferredBlock<Block> SOFIUM_BLOCK = registerBlock("sofium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
            ));




    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        GiniumItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {BLOCKS.register(eventBus);
    }

}
