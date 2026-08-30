package net.windflow3r.ginium.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.windflow3r.ginium.Ginium;
import net.windflow3r.ginium.item.GiniumItems;
import net.windflow3r.ginium.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class GiniumItemTagProvider extends ItemTagsProvider {

    public GiniumItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Ginium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(GiniumItems.RAW_GINIUM.get())
                .add(GiniumItems.GINIUM_INGOT.get())
                .add(GiniumItems.GINIUM_NUGGET.get())


                .add(GiniumItems.GINIUM_AXE.get())
                .add(GiniumItems.GINIUM_HOE.get())
                .add(GiniumItems.GINIUM_PICKAXE.get())
                .add(GiniumItems.GINIUM_SHOVEL.get())
                .add(GiniumItems.GINIUM_SWORD.get())

                .add(GiniumItems.RAW_RAINBERG.get())
                .add(GiniumItems.RAINBERG_INGOT.get())
                .add(GiniumItems.RAINBERG_NUGGET.get())


                .add(GiniumItems.GINITE_SCRAP.get())
                .add(GiniumItems.NIMBITE_SCRAP.get())

                .add(GiniumItems.IMBRIUM_UPGRADE_ARROW.get())
                .add(GiniumItems.IMBRIUM_UPGRADE_SMITHING_TEMPLATE.get())

                .add(GiniumItems.IMBRIUM_INGOT.get())

                .add(GiniumItems.IMBRIUM_AXE.get())
                .add(GiniumItems.IMBRIUM_SHOVEL.get())
                .add(GiniumItems.IMBRIUM_PICKAXE.get())
                .add(GiniumItems.IMBRIUM_SHOVEL.get())
                .add(GiniumItems.IMBRIUM_SHOVEL.get())

                .add(GiniumItems.ROSITE_SHARD.get())
                .add(GiniumItems.NYLITE_SHARD.get())


                .add(GiniumItems.SOFIUM_UPGRADE_SMITHING_TEMPLATE.get())

                .add(GiniumItems.SOFIUM_INGOT.get())


                .add(GiniumItems.GINPOWDER.get())
                .add(GiniumItems.GIN_APPLE.get())

                .add(GiniumItems.RAINPOWDER.get())
                .add(GiniumItems.RAIN_APPLE.get())

                .add(GiniumItems.ROSPOWDER.get())
                .add(GiniumItems.ROSE_APPLE.get())

                .add(GiniumItems.NYLIPOWDER.get())
                .add(GiniumItems.NYLI_APPLE.get())

                .add(GiniumItems.SOFIA_APPLE.get());

        tag(ItemTags.AXES)
                .add(GiniumItems.GINIUM_AXE.get())
                .add(GiniumItems.IMBRIUM_AXE.get())
                .add(GiniumItems.SOFIUM_AXE.get());

        tag(ItemTags.HOES)
                .add(GiniumItems.GINIUM_HOE.get())
                .add(GiniumItems.IMBRIUM_HOE.get())
                .add(GiniumItems.SOFIUM_HOE.get());

        tag(ItemTags.PICKAXES)
                .add(GiniumItems.GINIUM_PICKAXE.get())
                .add(GiniumItems.IMBRIUM_PICKAXE.get())
                .add(GiniumItems.SOFIUM_PICKAXE.get());

        tag(ItemTags.SHOVELS)
                .add(GiniumItems.GINIUM_SHOVEL.get())
                .add(GiniumItems.IMBRIUM_SHOVEL.get())
                .add(GiniumItems.SOFIUM_SHOVEL.get());

        tag(ItemTags.SWORDS)
                .add(GiniumItems.GINIUM_SWORD.get())
                .add(GiniumItems.IMBRIUM_SWORD.get())
                .add(GiniumItems.SOFIUM_SWORD.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(GiniumItems.GINIUM_HELMET.get())
                .add(GiniumItems.GINIUM_CHESTPLATE.get())
                .add(GiniumItems.GINIUM_LEGGINGS.get())
                .add(GiniumItems.GINIUM_BOOTS.get());

        this.tag(ItemTags.HEAD_ARMOR)
                .add(GiniumItems.GINIUM_HELMET.get());

        this.tag(ItemTags.CHEST_ARMOR)
                .add(GiniumItems.GINIUM_CHESTPLATE.get());

        this.tag(ItemTags.LEG_ARMOR)
                .add(GiniumItems.GINIUM_LEGGINGS.get());

        this.tag(ItemTags.FOOT_ARMOR)
                .add(GiniumItems.GINIUM_BOOTS.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(GiniumItems.IMBRIUM_HELMET.get())
                .add(GiniumItems.IMBRIUM_CHESTPLATE.get())
                .add(GiniumItems.IMBRIUM_LEGGINGS.get())
                .add(GiniumItems.IMBRIUM_BOOTS.get());

        this.tag(ItemTags.HEAD_ARMOR)
                .add(GiniumItems.IMBRIUM_HELMET.get());

        this.tag(ItemTags.CHEST_ARMOR)
                .add(GiniumItems.IMBRIUM_CHESTPLATE.get());

        this.tag(ItemTags.LEG_ARMOR)
                .add(GiniumItems.IMBRIUM_LEGGINGS.get());

        this.tag(ItemTags.FOOT_ARMOR)
                .add(GiniumItems.IMBRIUM_BOOTS.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(GiniumItems.SOFIUM_HELMET.get())
                .add(GiniumItems.SOFIUM_CHESTPLATE.get())
                .add(GiniumItems.SOFIUM_LEGGINGS.get())
                .add(GiniumItems.SOFIUM_BOOTS.get());

        this.tag(ItemTags.HEAD_ARMOR)
                .add(GiniumItems.SOFIUM_HELMET.get());

        this.tag(ItemTags.CHEST_ARMOR)
                .add(GiniumItems.SOFIUM_CHESTPLATE.get());

        this.tag(ItemTags.LEG_ARMOR)
                .add(GiniumItems.SOFIUM_LEGGINGS.get());

        this.tag(ItemTags.FOOT_ARMOR)
                .add(GiniumItems.SOFIUM_BOOTS.get());

    }
}
