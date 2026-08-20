package net.windflow3r.ginium.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.windflow3r.ginium.Ginium;
import net.windflow3r.ginium.block.GiniumBlocks;
import net.windflow3r.ginium.item.GiniumItems;

import java.util.LinkedHashMap;

public class GiniumItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();

    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public GiniumItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Ginium.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(GiniumItems.RAW_GINIUM.get());
        basicItem(GiniumItems.GINIUM_INGOT.get());
        basicItem(GiniumItems.GINIUM_NUGGET.get());

        handheldItem(GiniumItems.GINIUM_AXE.get());
        handheldItem(GiniumItems.GINIUM_HOE.get());
        handheldItem(GiniumItems.GINIUM_PICKAXE.get());
        handheldItem(GiniumItems.GINIUM_SHOVEL.get());
        handheldItem(GiniumItems.GINIUM_SWORD.get());
        trimmedArmorItem(GiniumItems.GINIUM_HELMET);
        trimmedArmorItem(GiniumItems.GINIUM_CHESTPLATE);
        trimmedArmorItem(GiniumItems.GINIUM_LEGGINGS);
        trimmedArmorItem(GiniumItems.GINIUM_BOOTS);

        basicItem(GiniumItems.RAW_RAINBERG.get());
        basicItem(GiniumItems.RAINBERG_INGOT.get());
        basicItem(GiniumItems.RAINBERG_NUGGET.get());
        buttonItem(GiniumBlocks.POLISHED_NIMBITE_BUTTON, GiniumBlocks.POLISHED_NIMBITE);
        wallItem(GiniumBlocks.POLISHED_NIMBITE_WALL, GiniumBlocks.POLISHED_NIMBITE);
        stairsItem(GiniumBlocks.POLISHED_NIMBITE_STAIRS, GiniumBlocks.POLISHED_NIMBITE);
        slabItem(GiniumBlocks.POLISHED_NIMBITE_SLAB, GiniumBlocks.POLISHED_NIMBITE);
        pressurePlateItem(GiniumBlocks.POLISHED_NIMBITE_PLATE, GiniumBlocks.POLISHED_NIMBITE);


        basicItem(GiniumItems.GINITE_SCRAP.get());
        basicItem(GiniumItems.NIMBITE_SCRAP.get());

        basicItem(GiniumItems.IMBRIUM_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(GiniumItems.IMBRIUM_UPGRADE_ARROW.get());

        basicItem(GiniumItems.IMBRIUM_INGOT.get());

        handheldItem(GiniumItems.IMBRIUM_AXE.get());
        handheldItem(GiniumItems.IMBRIUM_HOE.get());
        handheldItem(GiniumItems.IMBRIUM_PICKAXE.get());
        handheldItem(GiniumItems.IMBRIUM_SHOVEL.get());
        handheldItem(GiniumItems.IMBRIUM_SWORD.get());
        trimmedArmorItem(GiniumItems.IMBRIUM_HELMET);
        trimmedArmorItem(GiniumItems.IMBRIUM_CHESTPLATE);
        trimmedArmorItem(GiniumItems.IMBRIUM_LEGGINGS);
        trimmedArmorItem(GiniumItems.IMBRIUM_BOOTS);


        basicItem(GiniumItems.ROSITE_SHARD.get());
        basicItem(GiniumItems.NYLITE_SHARD.get());


        basicItem(GiniumItems.SOFIUM_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(GiniumItems.SOFIUM_INGOT.get());

        handheldItem(GiniumItems.SOFIUM_AXE.get());
        handheldItem(GiniumItems.SOFIUM_HOE.get());
        handheldItem(GiniumItems.SOFIUM_PICKAXE.get());
        handheldItem(GiniumItems.SOFIUM_SHOVEL.get());
        handheldItem(GiniumItems.SOFIUM_SWORD.get());
        trimmedArmorItem(GiniumItems.SOFIUM_HELMET);
        trimmedArmorItem(GiniumItems.SOFIUM_CHESTPLATE);
        trimmedArmorItem(GiniumItems.SOFIUM_LEGGINGS);
        trimmedArmorItem(GiniumItems.SOFIUM_BOOTS);

        basicItem(GiniumItems.GINPOWDER.get());
        basicItem(GiniumItems.GIN_APPLE.get());

        basicItem(GiniumItems.RAINPOWDER.get());
        basicItem(GiniumItems.RAIN_APPLE.get());

        basicItem(GiniumItems.ROSPOWDER.get());
        basicItem(GiniumItems.ROSE_APPLE.get());

        basicItem(GiniumItems.NYLIPOWDER.get());
        basicItem(GiniumItems.NYLI_APPLE.get());

        basicItem(GiniumItems.SOFIA_APPLE.get());


    }

    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MOD_ID = Ginium.MOD_ID; // Change this to your mod id

        if (itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace() + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Ginium.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }


    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(Ginium.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void stairsItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/stairs"))
                .texture("bottom", blockTexture(baseBlock))
                .texture("top", blockTexture(baseBlock))
                .texture("side", blockTexture(baseBlock));
    }

    public void slabItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/slab"))
                .texture("bottom", blockTexture(baseBlock))
                .texture("top", blockTexture(baseBlock))
                .texture("side", blockTexture(baseBlock));
    }

    public void pressurePlateItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/pressure_plate_up"))
                .texture("texture", blockTexture(baseBlock));
    }

    private ResourceLocation blockTexture(DeferredBlock<Block> block) {
        return ResourceLocation.fromNamespaceAndPath(
                Ginium.MOD_ID,
                "block/" + block.getId().getPath()
        );
    }
}

