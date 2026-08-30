package net.windflow3r.ginium.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.windflow3r.ginium.block.GiniumBlocks;
import net.windflow3r.ginium.item.GiniumItems;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class GiniumRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public GiniumRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {



        //Ginium Block

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GiniumBlocks.GINIUM_BLOCK.get())
                .pattern("GGG")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', GiniumItems.GINIUM_INGOT.get())
                .unlockedBy("has_ginium_ingot", has(GiniumItems.GINIUM_INGOT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GiniumItems.GINIUM_INGOT.get(), 9)
                .requires(GiniumBlocks.GINIUM_BLOCK)
                .unlockedBy("has_ginium_ingot", has(GiniumBlocks.GINIUM_BLOCK)).save(recipeOutput);

        //Ginium Ingot

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GiniumItems.GINIUM_INGOT.get())
                .pattern("GGG")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', GiniumItems.GINIUM_NUGGET.get())
                .unlockedBy("has_ginium_nugget", has(GiniumItems.GINIUM_NUGGET))
                .save(recipeOutput, "ginium_ingot_from_nuggets");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GiniumItems.GINIUM_NUGGET.get(), 9)
                .requires(GiniumItems.GINIUM_INGOT)
                .unlockedBy("has_ginium_negget", has(GiniumItems.GINIUM_INGOT)).save(recipeOutput);


        //Rainberg Block

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GiniumBlocks.RAINBERG_BLOCK.get())
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', GiniumItems.RAINBERG_INGOT.get())
                .unlockedBy("has_rainberg_ingot", has(GiniumItems.RAINBERG_INGOT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GiniumItems.RAINBERG_INGOT.get(), 9)
                .requires(GiniumBlocks.RAINBERG_BLOCK)
                .unlockedBy("has_rainberg_ingot", has(GiniumItems.RAINBERG_INGOT)).save(recipeOutput);

        //Ginium Ingot

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GiniumItems.RAINBERG_INGOT.get())
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', GiniumItems.RAINBERG_NUGGET.get())
                .unlockedBy("has_rainberg_nugget", has(GiniumItems.RAINBERG_NUGGET))
                .save(recipeOutput, "rainberg_ingot_from_nuggets");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GiniumItems.RAINBERG_NUGGET.get(), 9)
                .requires(GiniumItems.RAINBERG_INGOT)
                .unlockedBy("has_rainberg_nugget", has(GiniumItems.RAINBERG_INGOT)).save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GiniumBlocks.IMBRIUM_BLOCK.get())
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', GiniumItems.IMBRIUM_INGOT.get())
                .unlockedBy("has_imbrium_ingot", has(GiniumItems.IMBRIUM_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GiniumBlocks.SOFIUM_BLOCK.get())
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', GiniumItems.SOFIUM_INGOT.get())
                .unlockedBy("has_sofium_ingot", has(GiniumItems.SOFIUM_INGOT)).save(recipeOutput);


        //Smelting
        List<ItemLike> GINIUM_INGOT_SMELTABLES = List.of(GiniumItems.RAW_GINIUM, GiniumBlocks.GINIUM_ORE, GiniumBlocks.GINIUM_DEEPSLATE_ORE);
        List<ItemLike> RAINBERG_INGOT_SMELTABLES = List.of(GiniumItems.RAW_RAINBERG, GiniumBlocks.RAINBERG_DEEPSLATE_ORE);
        List<ItemLike> ROSITE_SHARD_SMELTABLES = List.of(GiniumBlocks.ROSITE_NETHER_ORE);
        List<ItemLike> NYLITE_SHARD_SMELTABLES = List.of(GiniumBlocks.NYLITE_END_ORE);
        List<ItemLike> GINITE_SMELTABLES = List.of(GiniumBlocks.GINITE);
        List<ItemLike> NIMBITE_SMELTABLES = List.of(GiniumBlocks.NIMBITE);
        List<ItemLike> GINPOWDER_SMELTABLES = List.of(GiniumItems.GINITE_SCRAP);
        List<ItemLike> RAINPOWDER_SMELTABLES = List.of(GiniumItems.NIMBITE_SCRAP);
        List<ItemLike> ROSPOWDER_SMELTABLES = List.of(GiniumItems.ROSITE_SHARD);
        List<ItemLike> NYLIPOWDER_SMELTABLES = List.of(GiniumItems.NYLITE_SHARD);


        oreSmelting(recipeOutput, GINIUM_INGOT_SMELTABLES, RecipeCategory.MISC, GiniumItems.GINIUM_INGOT.get(), 0.35f, 200, "ginium_ingot");
        oreBlasting(recipeOutput, GINIUM_INGOT_SMELTABLES, RecipeCategory.MISC, GiniumItems.GINIUM_INGOT.get(), 0.35f, 100, "ginium_ingot");
        oreSmelting(recipeOutput, RAINBERG_INGOT_SMELTABLES, RecipeCategory.MISC, GiniumItems.RAINBERG_INGOT.get(), 0.35f, 200, "rainberg_ingot");
        oreBlasting(recipeOutput, RAINBERG_INGOT_SMELTABLES, RecipeCategory.MISC, GiniumItems.RAINBERG_INGOT.get(), 0.35f, 100, "rainberg_ingot");

        oreSmelting(recipeOutput, ROSITE_SHARD_SMELTABLES, RecipeCategory.MISC, GiniumItems.ROSITE_SHARD.get(), 0.5f, 200, "rosite_shard");
        oreBlasting(recipeOutput, ROSITE_SHARD_SMELTABLES, RecipeCategory.MISC, GiniumItems.ROSITE_SHARD.get(), 0.5f, 100, "rosite_shard");
        oreSmelting(recipeOutput, NYLITE_SHARD_SMELTABLES, RecipeCategory.MISC, GiniumItems.NYLITE_SHARD.get(), 0.5f, 200, "nylite_shard");
        oreBlasting(recipeOutput, NYLITE_SHARD_SMELTABLES, RecipeCategory.MISC, GiniumItems.NYLITE_SHARD.get(), 0.5f, 100, "nylite_shard");

        oreSmelting(recipeOutput, GINITE_SMELTABLES, RecipeCategory.MISC, GiniumItems.GINITE_SCRAP.get(), 0.75f, 250, "ginite_scrap");
        oreBlasting(recipeOutput, GINITE_SMELTABLES, RecipeCategory.MISC, GiniumItems.GINITE_SCRAP.get(), 0.75f, 150, "ginite_scrap");
        oreSmelting(recipeOutput, NIMBITE_SMELTABLES, RecipeCategory.MISC, GiniumItems.NIMBITE_SCRAP.get(), 0.75f, 250, "nimbite_scrap");
        oreBlasting(recipeOutput, NIMBITE_SMELTABLES, RecipeCategory.MISC, GiniumItems.NIMBITE_SCRAP.get(), 0.75f, 150, "nimbite_scrap");

        oreSmelting(recipeOutput, GINPOWDER_SMELTABLES, RecipeCategory.MISC, GiniumItems.GINPOWDER.get(), 1f, 250, "ginpowder");
        oreBlasting(recipeOutput, GINPOWDER_SMELTABLES, RecipeCategory.MISC, GiniumItems.GINPOWDER.get(), 1f, 150, "ginpowder");

        oreSmelting(recipeOutput, RAINPOWDER_SMELTABLES, RecipeCategory.MISC, GiniumItems.RAINPOWDER.get(), 1f, 250, "rainpowder");
        oreBlasting(recipeOutput, RAINPOWDER_SMELTABLES, RecipeCategory.MISC, GiniumItems.RAINPOWDER.get(), 1f, 150, "rainpowder");

        oreSmelting(recipeOutput, ROSPOWDER_SMELTABLES, RecipeCategory.MISC, GiniumItems.ROSPOWDER.get(), 1f, 500, "rospowder");
        oreBlasting(recipeOutput, ROSPOWDER_SMELTABLES, RecipeCategory.MISC, GiniumItems.ROSPOWDER.get(), 1f, 300, "rospowder");

        oreSmelting(recipeOutput, NYLIPOWDER_SMELTABLES, RecipeCategory.MISC, GiniumItems.NYLIPOWDER.get(), 1f, 500, "nylipowder");
        oreBlasting(recipeOutput, NYLIPOWDER_SMELTABLES, RecipeCategory.MISC, GiniumItems.NYLIPOWDER.get(), 1f, 300, "nylipowder");

        stairBuilder(GiniumBlocks.POLISHED_NIMBITE_STAIRS, Ingredient.of(GiniumBlocks.POLISHED_NIMBITE)).group("polished_nimbite").unlockedBy("has_polished_nimbite", has(GiniumBlocks.POLISHED_NIMBITE)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, GiniumBlocks.POLISHED_NIMBITE_SLAB.get(), GiniumBlocks.POLISHED_NIMBITE.get());
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, GiniumBlocks.POLISHED_NIMBITE_WALL.get(), GiniumBlocks.POLISHED_NIMBITE.get());
        buttonBuilder(GiniumBlocks.POLISHED_NIMBITE_BUTTON, Ingredient.of(GiniumBlocks.POLISHED_NIMBITE)).group("polished_nimbite").unlockedBy("has_polished_nimbite", has(GiniumBlocks.POLISHED_NIMBITE)).save(recipeOutput);
        pressurePlate(recipeOutput, GiniumBlocks.POLISHED_NIMBITE_PLATE.get(), GiniumBlocks.POLISHED_NIMBITE.get());

        stairBuilder(GiniumBlocks.NIMBITE_BRICKS_STAIRS, Ingredient.of(GiniumBlocks.NIMBITE_BRICKS)).group("nimbite_bricks").unlockedBy("has_nimbite_bricks", has(GiniumBlocks.NIMBITE_BRICKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, GiniumBlocks.NIMBITE_BRICKS_SLAB.get(), GiniumBlocks.NIMBITE_BRICKS.get());
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, GiniumBlocks.NIMBITE_BRICKS_WALL.get(), GiniumBlocks.NIMBITE_BRICKS.get());


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, GiniumItems.GINIUM_AXE.get())
                .pattern("GG ")
                .pattern("GS ")
                .pattern(" S ")
                .define('G', GiniumItems.GINIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_ginium_tools", has(GiniumItems.GINIUM_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, GiniumItems.GINIUM_HOE.get())
                .pattern("GG ")
                .pattern(" S ")
                .pattern(" S ")
                .define('G', GiniumItems.GINIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_ginium_tools", has(GiniumItems.GINIUM_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, GiniumItems.GINIUM_PICKAXE.get())
                .pattern("GGG")
                .pattern(" S ")
                .pattern(" S ")
                .define('G', GiniumItems.GINIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_ginium_tools", has(GiniumItems.GINIUM_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, GiniumItems.GINIUM_SHOVEL.get())
                .pattern(" G ")
                .pattern(" S ")
                .pattern(" S ")
                .define('G', GiniumItems.GINIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_ginium_tools", has(GiniumItems.GINIUM_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, GiniumItems.GINIUM_SWORD.get())
                .pattern(" G ")
                .pattern(" G ")
                .pattern(" S ")
                .define('G', GiniumItems.GINIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_ginium_tools", has(GiniumItems.GINIUM_INGOT)).save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, GiniumItems.GINIUM_HELMET.get())
                .pattern("GGG")
                .pattern("G G")
                .pattern("   ")
                .define('G', GiniumItems.GINIUM_INGOT.get())
                .unlockedBy("has_ginium_armour", has(GiniumItems.GINIUM_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, GiniumItems.GINIUM_CHESTPLATE.get())
                .pattern("G G")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', GiniumItems.GINIUM_INGOT.get())
                .unlockedBy("has_ginium_armour", has(GiniumItems.GINIUM_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, GiniumItems.GINIUM_LEGGINGS.get())
                .pattern("GGG")
                .pattern("G G")
                .pattern("G G")
                .define('G', GiniumItems.GINIUM_INGOT.get())
                .unlockedBy("has_ginium_armour", has(GiniumItems.GINIUM_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, GiniumItems.GINIUM_BOOTS.get())
                .pattern("   ")
                .pattern("G G")
                .pattern("G G")
                .define('G', GiniumItems.GINIUM_INGOT.get())
                .unlockedBy("has_ginium_armour", has(GiniumItems.GINIUM_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GiniumItems.IMBRIUM_UPGRADE_ARROW.get())
                .pattern(" N ")
                .pattern("NRN")
                .pattern(" R ")
                .define('R', GiniumItems.RAINBERG_INGOT.get())
                .define('N', GiniumItems.RAINBERG_NUGGET.get())
                .unlockedBy("has_imbrium_upgrade_arrow", has(GiniumItems.RAINBERG_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GiniumItems.IMBRIUM_UPGRADE_SMITHING_TEMPLATE.get())
                .pattern("IRI")
                .pattern("IAI")
                .pattern("IRI")
                .define('I', GiniumBlocks.GINITE.get())
                .define('R', GiniumItems.RAINBERG_INGOT.get())
                .define('A', GiniumItems.IMBRIUM_UPGRADE_ARROW.get())
                .unlockedBy("has_imbrium_upgrade_template_from_arrow", has(GiniumItems.IMBRIUM_UPGRADE_ARROW)).save(recipeOutput, "has_imbrium_upgrade_template_from_arrow");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GiniumItems.IMBRIUM_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("RAR")
                .pattern("RIR")
                .pattern("RRR")
                .define('I', GiniumBlocks.GINITE.get())
                .define('R', GiniumItems.RAINBERG_INGOT.get())
                .define('A', GiniumItems.IMBRIUM_UPGRADE_SMITHING_TEMPLATE.get())
                .unlockedBy("has_imbrium_upgrade_template_from_template", has(GiniumItems.IMBRIUM_UPGRADE_ARROW)).save(recipeOutput, "has_imbrium_upgrade_template_from_template");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GiniumItems.IMBRIUM_INGOT.get())
                .pattern("GGG")
                .pattern("GGN")
                .pattern("NNN")
                .define('G', GiniumItems.GINITE_SCRAP.get())
                .define('N', GiniumItems.NIMBITE_SCRAP.get())
                .unlockedBy("has_imbrium", has(GiniumItems.IMBRIUM_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GiniumItems.GIN_APPLE.get())
                .pattern("RRR")
                .pattern("RAR")
                .pattern("RRR")
                .define('R', GiniumItems.GINPOWDER.get())
                .define('A', Items.APPLE)
                .unlockedBy("has_ginpowder", has(GiniumItems.GINPOWDER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GiniumItems.RAIN_APPLE.get())
                .pattern("RRR")
                .pattern("RAR")
                .pattern("RRR")
                .define('R', GiniumItems.RAINPOWDER.get())
                .define('A', Items.APPLE)
                .unlockedBy("has_rainpowder", has(GiniumItems.RAINPOWDER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GiniumItems.ROSE_APPLE.get())
                .pattern("RRR")
                .pattern("RAR")
                .pattern("RRR")
                .define('R', GiniumItems.ROSPOWDER.get())
                .define('A', Items.APPLE)
                .unlockedBy("has_rospowder", has(GiniumItems.ROSPOWDER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, GiniumItems.NYLI_APPLE.get())
                .pattern("RRR")
                .pattern("RAR")
                .pattern("RRR")
                .define('R', GiniumItems.NYLIPOWDER.get())
                .define('A', Items.APPLE)
                .unlockedBy("has_nylipowder", has(GiniumItems.NYLIPOWDER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GiniumItems.SOFIUM_INGOT.get())
                .pattern("GGI")
                .pattern("NWI")
                .pattern("NRR")
                .define('G', GiniumItems.GINPOWDER.get())
                .define('I', GiniumItems.RAINPOWDER.get())
                .define('R', GiniumItems.ROSPOWDER.get())
                .define('N', GiniumItems.NYLIPOWDER.get())
                .define('W', Items.WATER_BUCKET)
                .unlockedBy("has_rospowder_and_nylipowder", has(GiniumItems.ROSPOWDER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GiniumItems.SOFIUM_UPGRADE_SMITHING_TEMPLATE.get())
                .pattern("RIR")
                .pattern("RNR")
                .pattern("RRR")
                .define('R', GiniumItems.ROSPOWDER.get())
                .define('I', GiniumItems.IMBRIUM_UPGRADE_SMITHING_TEMPLATE)
                .define('N', GiniumItems.NYLITE_SHARD.get())
                .unlockedBy("has_sofium_ingot", has(GiniumItems.SOFIUM_INGOT)).save(recipeOutput, "sofium_upgrade_smithing_template_from_imbrium");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GiniumItems.SOFIUM_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("NIN")
                .pattern("NRN")
                .pattern("NNN")
                .define('R', GiniumItems.ROSITE_SHARD.get())
                .define('I', GiniumItems.SOFIUM_UPGRADE_SMITHING_TEMPLATE.get())
                .define('N', GiniumItems.NYLIPOWDER.get())
                .unlockedBy("has_sofium_upgrade_smithing_template", has(GiniumItems.SOFIUM_UPGRADE_SMITHING_TEMPLATE)).save(recipeOutput, "sofium_upgrade_smithing_template_from_template");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GiniumItems.SOFIA_APPLE.get())
                .pattern("GGI")
                .pattern("NAI")
                .pattern("NRR")
                .define('G', GiniumItems.GINPOWDER.get())
                .define('I', GiniumItems.RAINPOWDER.get())
                .define('R', GiniumItems.ROSPOWDER.get())
                .define('N', GiniumItems.NYLIPOWDER.get())
                .define('A', Items.APPLE)
                .unlockedBy("has_rose_apple", has(GiniumItems.ROSE_APPLE)).save(recipeOutput);

        // NIMBITE BLOCKS

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, GiniumBlocks.POLISHED_NIMBITE.get())
                .pattern("NN ")
                .pattern("NN ")
                .pattern("   ")
                .define('N', GiniumBlocks.NIMBITE.get())
                .unlockedBy("has_nimbite", has(GiniumBlocks.NIMBITE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, GiniumBlocks.NIMBITE_BRICKS.get())
                .pattern("NN ")
                .pattern("NN ")
                .pattern("   ")
                .define('N', GiniumBlocks.POLISHED_NIMBITE.get())
                .unlockedBy("has_polished_nimbite", has(GiniumBlocks.POLISHED_NIMBITE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, GiniumBlocks.CHISELED_NIMBITE.get())
                .pattern(" N ")
                .pattern(" N ")
                .pattern("   ")
                .define('N', GiniumBlocks.POLISHED_NIMBITE_SLAB.get())
                .unlockedBy("has_nimbite", has(GiniumBlocks.NIMBITE)).save(recipeOutput, "for_chiseled");




        // ==================== IMBRIUM TOOLS ====================

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.IMBRIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.GINIUM_SWORD.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        GiniumItems.IMBRIUM_SWORD.get()
                ).unlocks("has_imbrium_ingot", has(GiniumItems.IMBRIUM_INGOT.get()))
                .save(recipeOutput, "imbrium_sword_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.IMBRIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.GINIUM_PICKAXE.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_INGOT.get()),
                        RecipeCategory.TOOLS,
                        GiniumItems.IMBRIUM_PICKAXE.get()
                ).unlocks("has_imbrium_ingot", has(GiniumItems.IMBRIUM_INGOT.get()))
                .save(recipeOutput, "imbrium_pickaxe_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.IMBRIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.GINIUM_AXE.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_INGOT.get()),
                        RecipeCategory.TOOLS,
                        GiniumItems.IMBRIUM_AXE.get()
                ).unlocks("has_imbrium_ingot", has(GiniumItems.IMBRIUM_INGOT.get()))
                .save(recipeOutput, "imbrium_axe_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.IMBRIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.GINIUM_SHOVEL.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_INGOT.get()),
                        RecipeCategory.TOOLS,
                        GiniumItems.IMBRIUM_SHOVEL.get()
                ).unlocks("has_imbrium_ingot", has(GiniumItems.IMBRIUM_INGOT.get()))
                .save(recipeOutput, "imbrium_shovel_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.IMBRIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.GINIUM_HOE.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_INGOT.get()),
                        RecipeCategory.TOOLS,
                        GiniumItems.IMBRIUM_HOE.get()
                ).unlocks("has_imbrium_ingot", has(GiniumItems.IMBRIUM_INGOT.get()))
                .save(recipeOutput, "imbrium_hoe_smithing");


// ==================== IMBRIUM ARMOUR ====================

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.IMBRIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.GINIUM_HELMET.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        GiniumItems.IMBRIUM_HELMET.get()
                ).unlocks("has_imbrium_ingot", has(GiniumItems.IMBRIUM_INGOT.get()))
                .save(recipeOutput, "imbrium_helmet_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.IMBRIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.GINIUM_CHESTPLATE.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        GiniumItems.IMBRIUM_CHESTPLATE.get()
                ).unlocks("has_imbrium_ingot", has(GiniumItems.IMBRIUM_INGOT.get()))
                .save(recipeOutput, "imbrium_chestplate_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.IMBRIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.GINIUM_LEGGINGS.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        GiniumItems.IMBRIUM_LEGGINGS.get()
                ).unlocks("has_imbrium_ingot", has(GiniumItems.IMBRIUM_INGOT.get()))
                .save(recipeOutput, "imbrium_leggings_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.IMBRIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.GINIUM_BOOTS.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        GiniumItems.IMBRIUM_BOOTS.get()
                ).unlocks("has_imbrium_ingot", has(GiniumItems.IMBRIUM_INGOT.get()))
                .save(recipeOutput, "imbrium_boots_smithing");



        // ==================== SOFIUM TOOLS ====================

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.SOFIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_SWORD.get()),
                        Ingredient.of(GiniumItems.SOFIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        GiniumItems.SOFIUM_SWORD.get()
                ).unlocks("has_sofium_ingot", has(GiniumItems.SOFIUM_INGOT.get()))
                .save(recipeOutput, "sofium_sword_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.SOFIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_PICKAXE.get()),
                        Ingredient.of(GiniumItems.SOFIUM_INGOT.get()),
                        RecipeCategory.TOOLS,
                        GiniumItems.SOFIUM_PICKAXE.get()
                ).unlocks("has_sofium_ingot", has(GiniumItems.SOFIUM_INGOT.get()))
                .save(recipeOutput, "sofium_pickaxe_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.SOFIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_AXE.get()),
                        Ingredient.of(GiniumItems.SOFIUM_INGOT.get()),
                        RecipeCategory.TOOLS,
                        GiniumItems.SOFIUM_AXE.get()
                ).unlocks("has_sofium_ingot", has(GiniumItems.SOFIUM_INGOT.get()))
                .save(recipeOutput, "sofium_axe_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.SOFIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_SHOVEL.get()),
                        Ingredient.of(GiniumItems.SOFIUM_INGOT.get()),
                        RecipeCategory.TOOLS,
                        GiniumItems.SOFIUM_SHOVEL.get()
                ).unlocks("has_sofium_ingot", has(GiniumItems.SOFIUM_INGOT.get()))
                .save(recipeOutput, "sofium_shovel_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.SOFIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_HOE.get()),
                        Ingredient.of(GiniumItems.SOFIUM_INGOT.get()),
                        RecipeCategory.TOOLS,
                        GiniumItems.SOFIUM_HOE.get()
                ).unlocks("has_sofium_ingot", has(GiniumItems.SOFIUM_INGOT.get()))
                .save(recipeOutput, "sofium_hoe_smithing");


// ==================== SOFIUM ARMOUR ====================

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.SOFIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_HELMET.get()),
                        Ingredient.of(GiniumItems.SOFIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        GiniumItems.SOFIUM_HELMET.get()
                ).unlocks("has_sofium_ingot", has(GiniumItems.SOFIUM_INGOT.get()))
                .save(recipeOutput, "sofium_helmet_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.SOFIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_CHESTPLATE.get()),
                        Ingredient.of(GiniumItems.SOFIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        GiniumItems.SOFIUM_CHESTPLATE.get()
                ).unlocks("has_sofium_ingot", has(GiniumItems.SOFIUM_INGOT.get()))
                .save(recipeOutput, "sofium_chestplate_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.SOFIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_LEGGINGS.get()),
                        Ingredient.of(GiniumItems.SOFIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        GiniumItems.SOFIUM_LEGGINGS.get()
                ).unlocks("has_sofium_ingot", has(GiniumItems.SOFIUM_INGOT.get()))
                .save(recipeOutput, "sofium_leggings_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(GiniumItems.SOFIUM_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(GiniumItems.IMBRIUM_BOOTS.get()),
                        Ingredient.of(GiniumItems.SOFIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        GiniumItems.SOFIUM_BOOTS.get()
                ).unlocks("has_sofium_ingot", has(GiniumItems.SOFIUM_INGOT.get()))
                .save(recipeOutput, "sofium_boots_smithing");

        // =========================================================
        // NIMBITE STONECUTTER RECIPES
        // =========================================================

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(GiniumBlocks.NIMBITE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        GiniumBlocks.POLISHED_NIMBITE.get()
                )
                .unlockedBy("has_nimbite", has(GiniumBlocks.NIMBITE.get()))
                .save(recipeOutput, "polished_nimbite_from_nimbite_stonecutting");

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(GiniumBlocks.NIMBITE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        GiniumBlocks.POLISHED_NIMBITE_STAIRS.get()
                )
                .unlockedBy("has_nimbite", has(GiniumBlocks.NIMBITE.get()))
                .save(recipeOutput, "polished_nimbite_stairs_from_nimbite_stonecutting");

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(GiniumBlocks.NIMBITE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        GiniumBlocks.POLISHED_NIMBITE_SLAB.get(),
                        2
                )
                .unlockedBy("has_nimbite", has(GiniumBlocks.NIMBITE.get()))
                .save(recipeOutput, "polished_nimbite_slab_from_nimbite_stonecutting");

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(GiniumBlocks.NIMBITE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        GiniumBlocks.POLISHED_NIMBITE_WALL.get()
                )
                .unlockedBy("has_nimbite", has(GiniumBlocks.NIMBITE.get()))
                .save(recipeOutput, "polished_nimbite_wall_from_nimbite_stonecutting");

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(GiniumBlocks.NIMBITE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        GiniumBlocks.NIMBITE_BRICKS.get()
                )
                .unlockedBy("has_nimbite", has(GiniumBlocks.NIMBITE.get()))
                .save(recipeOutput, "nimbite_bricks_from_nimbite_stonecutting");

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(GiniumBlocks.NIMBITE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        GiniumBlocks.NIMBITE_BRICKS_STAIRS.get()
                )
                .unlockedBy("has_nimbite", has(GiniumBlocks.NIMBITE.get()))
                .save(recipeOutput, "nimbite_bricks_stairs_from_nimbite_stonecutting");

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(GiniumBlocks.NIMBITE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        GiniumBlocks.NIMBITE_BRICKS_SLAB.get(),
                        2
                )
                .unlockedBy("has_nimbite", has(GiniumBlocks.NIMBITE.get()))
                .save(recipeOutput, "nimbite_bricks_slab_from_nimbite_stonecutting");

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(GiniumBlocks.NIMBITE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        GiniumBlocks.NIMBITE_BRICKS_WALL.get()
                )
                .unlockedBy("has_nimbite", has(GiniumBlocks.NIMBITE.get()))
                .save(recipeOutput, "nimbite_bricks_wall_from_nimbite_stonecutting");

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(GiniumBlocks.NIMBITE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        GiniumBlocks.CHISELED_NIMBITE.get()
                )
                .unlockedBy("has_nimbite", has(GiniumBlocks.NIMBITE.get()))
                .save(recipeOutput, "chiseled_nimbite_from_nimbite_stonecutting");


    }

}
