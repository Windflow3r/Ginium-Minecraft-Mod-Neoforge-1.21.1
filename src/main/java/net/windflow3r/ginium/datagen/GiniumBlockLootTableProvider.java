package net.windflow3r.ginium.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.windflow3r.ginium.block.GiniumBlocks;
import net.windflow3r.ginium.item.GiniumItems;

import java.util.Set;

public class GiniumBlockLootTableProvider extends BlockLootSubProvider {
    protected GiniumBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(GiniumBlocks.GINITE.get());

        dropSelf(GiniumBlocks.NIMBITE.get());
        dropSelf(GiniumBlocks.POLISHED_NIMBITE.get());
        dropSelf(GiniumBlocks.POLISHED_NIMBITE_STAIRS.get());
        add(GiniumBlocks.POLISHED_NIMBITE_SLAB.get(),
                blocks -> createSlabItemTable(GiniumBlocks.POLISHED_NIMBITE_SLAB.get()));
        dropSelf(GiniumBlocks.POLISHED_NIMBITE_WALL.get());
        dropSelf(GiniumBlocks.POLISHED_NIMBITE_BUTTON.get());
        dropSelf(GiniumBlocks.POLISHED_NIMBITE_PLATE.get());

        dropSelf(GiniumBlocks.GINIUM_BLOCK.get());
        dropSelf(GiniumBlocks.RAINBERG_BLOCK.get());
        dropSelf(GiniumBlocks.SOFIUM_BLOCK.get());
        dropSelf(GiniumBlocks.IMBRIUM_BLOCK.get());

        add(GiniumBlocks.GINIUM_ORE.get(),
                block ->createMultipleOreDrops(GiniumBlocks.GINIUM_ORE.get(), GiniumItems.RAW_GINIUM.get(), 1, 2));

        add(GiniumBlocks.GINIUM_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(GiniumBlocks.GINIUM_DEEPSLATE_ORE.get(), GiniumItems.RAW_GINIUM.get(), 1, 4));

        add(GiniumBlocks.RAINBERG_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(GiniumBlocks.RAINBERG_DEEPSLATE_ORE.get(), GiniumItems.RAW_RAINBERG.get(), 1, 1));

        add(GiniumBlocks.ROSITE_NETHER_ORE.get(),
                block -> createMultipleOreDrops(GiniumBlocks.ROSITE_NETHER_ORE.get(), GiniumItems.ROSITE_SHARD.get(), 1, 2));

        add(GiniumBlocks.NYLITE_END_ORE.get(),
                block -> createMultipleOreDrops(GiniumBlocks.NYLITE_END_ORE.get(), GiniumItems.NYLITE_SHARD.get(), 1, 2));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return GiniumBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}