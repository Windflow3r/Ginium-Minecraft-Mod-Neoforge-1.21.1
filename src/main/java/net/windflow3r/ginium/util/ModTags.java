package net.windflow3r.ginium.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.windflow3r.ginium.Ginium;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_GINIUM_TOOL = createTag("needs_ginium_tool");
        public static final TagKey<Block> INCORRECT_FOR_GINIUM_TOOL = createTag("incorrect_for_ginium_tool");

        public static final TagKey<Block> NEEDS_IMBRIUM_TOOL = createTag("needs_imbrium_tool");
        public static final TagKey<Block> INCORRECT_FOR_IMBRIUM_TOOL = createTag("incorrect_for_imbrium_tool");

        public static final TagKey<Block> NEEDS_SOFIUM_TOOL = createTag("needs_sofium_tool");
        public static final TagKey<Block> INCORRECT_FOR_SOFIUM_TOOL = createTag("incorrect_for_sofium_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Ginium.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Ginium.MOD_ID, name));
        }
    }
}
