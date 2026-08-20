package net.windflow3r.ginium.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.windflow3r.ginium.Ginium;
import net.windflow3r.ginium.block.GiniumBlocks;

import java.util.function.Supplier;

public class GiniumCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ginium.MOD_ID);

    //Ginium Creative Mode Tab
    public static final Supplier<CreativeModeTab> GINIUM_ITEMS_TAB = CREATIVE_MODE_TAB.register("ginium_items_tabs",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack((ItemLike) GiniumBlocks.GINIUM_ORE.get()))
                    .title(Component.translatable("Ginium"))
                    .displayItems((itemDisplayParameters, outout) -> {

                        //Ginium
                        outout.accept(GiniumBlocks.GINIUM_ORE);
                        outout.accept(GiniumBlocks.GINIUM_DEEPSLATE_ORE);
                        outout.accept(GiniumItems.RAW_GINIUM);
                        outout.accept(GiniumItems.GINIUM_INGOT);
                        outout.accept(GiniumItems.GINIUM_NUGGET);
                        outout.accept(GiniumItems.GINITE_SCRAP);
                        outout.accept(GiniumItems.GINPOWDER);
                        outout.accept(GiniumItems.GIN_APPLE);
                        outout.accept(GiniumBlocks.GINITE);
                        outout.accept(GiniumBlocks.GINIUM_BLOCK);

                        outout.accept(GiniumItems.GINIUM_AXE);
                        outout.accept(GiniumItems.GINIUM_HOE);
                        outout.accept(GiniumItems.GINIUM_PICKAXE);
                        outout.accept(GiniumItems.GINIUM_SHOVEL);
                        outout.accept(GiniumItems.GINIUM_SWORD);
                        outout.accept(GiniumItems.GINIUM_HELMET);
                        outout.accept(GiniumItems.GINIUM_CHESTPLATE);
                        outout.accept(GiniumItems.GINIUM_LEGGINGS);
                        outout.accept(GiniumItems.GINIUM_BOOTS);

                        //Rainberg
                        outout.accept(GiniumBlocks.RAINBERG_DEEPSLATE_ORE);
                        outout.accept(GiniumItems.RAW_RAINBERG);
                        outout.accept(GiniumItems.RAINBERG_INGOT);
                        outout.accept(GiniumItems.RAINBERG_NUGGET);
                        outout.accept(GiniumItems.NIMBITE_SCRAP);
                        outout.accept(GiniumItems.RAINPOWDER);
                        outout.accept(GiniumItems.RAIN_APPLE);
                        outout.accept(GiniumBlocks.NIMBITE);
                        outout.accept(GiniumBlocks.POLISHED_NIMBITE);
                        outout.accept(GiniumBlocks.POLISHED_NIMBITE_STAIRS);
                        outout.accept(GiniumBlocks.POLISHED_NIMBITE_SLAB);
                        outout.accept(GiniumBlocks.POLISHED_NIMBITE_WALL);
                        outout.accept(GiniumBlocks.POLISHED_NIMBITE_BUTTON);
                        outout.accept(GiniumBlocks.POLISHED_NIMBITE_PLATE);
                        outout.accept(GiniumBlocks.NIMBITE_BRICKS);
                        outout.accept(GiniumBlocks.NIMBITE_BRICKS_STAIRS);
                        outout.accept(GiniumBlocks.NIMBITE_BRICKS_SLAB);
                        outout.accept(GiniumBlocks.NIMBITE_BRICKS_WALL);
                        outout.accept(GiniumBlocks.CHISELED_NIMBITE);
                        outout.accept(GiniumBlocks.RAINBERG_BLOCK);

                        //Imbrium
                        outout.accept(GiniumItems.IMBRIUM_UPGRADE_ARROW);
                        outout.accept(GiniumItems.IMBRIUM_UPGRADE_SMITHING_TEMPLATE);
                        outout.accept(GiniumItems.IMBRIUM_INGOT);

                        outout.accept(GiniumItems.IMBRIUM_AXE);
                        outout.accept(GiniumItems.IMBRIUM_HOE);
                        outout.accept(GiniumItems.IMBRIUM_PICKAXE);
                        outout.accept(GiniumItems.IMBRIUM_SHOVEL);
                        outout.accept(GiniumItems.IMBRIUM_SWORD);
                        outout.accept(GiniumItems.IMBRIUM_HELMET);
                        outout.accept(GiniumItems.IMBRIUM_CHESTPLATE);
                        outout.accept(GiniumItems.IMBRIUM_LEGGINGS);
                        outout.accept(GiniumItems.IMBRIUM_BOOTS);


                        //Rosite
                        outout.accept(GiniumItems.ROSITE_SHARD);
                        outout.accept(GiniumItems.ROSPOWDER);
                        outout.accept(GiniumItems.ROSE_APPLE);
                        outout.accept(GiniumBlocks.ROSITE_NETHER_ORE);

                        //Nylite
                        outout.accept(GiniumItems.NYLITE_SHARD);
                        outout.accept(GiniumItems.NYLIPOWDER);
                        outout.accept(GiniumItems.NYLI_APPLE);
                        outout.accept(GiniumBlocks.NYLITE_END_ORE);

                        //Sofium
                        outout.accept(GiniumItems.SOFIUM_UPGRADE_SMITHING_TEMPLATE);
                        outout.accept(GiniumItems.SOFIUM_INGOT);
                        outout.accept(GiniumItems.SOFIA_APPLE);
                        outout.accept(GiniumBlocks.SOFIUM_BLOCK);

                        outout.accept(GiniumItems.SOFIUM_AXE);
                        outout.accept(GiniumItems.SOFIUM_HOE);
                        outout.accept(GiniumItems.SOFIUM_PICKAXE);
                        outout.accept(GiniumItems.SOFIUM_SHOVEL);
                        outout.accept(GiniumItems.SOFIUM_SWORD);
                        outout.accept(GiniumItems.SOFIUM_HELMET);
                        outout.accept(GiniumItems.SOFIUM_CHESTPLATE);
                        outout.accept(GiniumItems.SOFIUM_LEGGINGS);
                        outout.accept(GiniumItems.SOFIUM_BOOTS);

                        //Misc




                    }).build());


    public  static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
