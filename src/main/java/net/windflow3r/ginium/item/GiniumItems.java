package net.windflow3r.ginium.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.windflow3r.ginium.Ginium;

public class GiniumItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ginium.MOD_ID);

    public static final DeferredItem<Item> RAW_GINIUM = ITEMS.register("raw_ginium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GINIUM_INGOT = ITEMS.register("ginium_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GINIUM_NUGGET = ITEMS.register("ginium_nugget",
            () -> new Item(new Item.Properties()));



    public static final DeferredItem<AxeItem> GINIUM_AXE = ITEMS.register("ginium_axe",
            () -> new AxeItem(GiniumToolTiers.GINIUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(GiniumToolTiers.GINIUM, 6.0f, -3.0f))));

    public static final DeferredItem<HoeItem> GINIUM_HOE = ITEMS.register("ginium_hoe",
            () -> new HoeItem(GiniumToolTiers.GINIUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(GiniumToolTiers.GINIUM, -2.0f, 0.0f))));

    public static final DeferredItem<PickaxeItem> GINIUM_PICKAXE = ITEMS.register("ginium_pickaxe",
            () -> new PickaxeItem(GiniumToolTiers.GINIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(GiniumToolTiers.GINIUM, 1.0f, -2.8f))));

    public static final DeferredItem<ShovelItem> GINIUM_SHOVEL = ITEMS.register("ginium_shovel",
            () -> new ShovelItem(GiniumToolTiers.GINIUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(GiniumToolTiers.GINIUM, 1.5f, -3.0f))));

    public static final DeferredItem<SwordItem> GINIUM_SWORD = ITEMS.register("ginium_sword",
            () -> new SwordItem(GiniumToolTiers.GINIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(GiniumToolTiers.GINIUM, 3.0f, -2.4f))));


    public static final DeferredItem<ArmorItem> GINIUM_HELMET = ITEMS.register("ginium_helmet",
            () -> new ArmorItem(GiniumArmorMaterials.GINIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(28))));

    public static final DeferredItem<ArmorItem> GINIUM_CHESTPLATE = ITEMS.register("ginium_chestplate",
            () -> new ArmorItem(GiniumArmorMaterials.GINIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(28))));

    public static final DeferredItem<ArmorItem> GINIUM_LEGGINGS = ITEMS.register("ginium_leggings",
            () -> new ArmorItem(GiniumArmorMaterials.GINIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(28))));

    public static final DeferredItem<ArmorItem> GINIUM_BOOTS = ITEMS.register("ginium_boots",
            () -> new ArmorItem(GiniumArmorMaterials.GINIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(28))));



    public static final DeferredItem<Item> RAW_RAINBERG = ITEMS.register("raw_rainberg",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAINBERG_INGOT = ITEMS.register("rainberg_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAINBERG_NUGGET = ITEMS.register("rainberg_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> IMBRIUM_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("imbrium_upgrade_smithing_template",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> IMBRIUM_UPGRADE_ARROW = ITEMS.register("imbrium_upgrade_arrow",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GINITE_SCRAP = ITEMS.register("ginite_scrap",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NIMBITE_SCRAP = ITEMS.register("nimbite_scrap",
            () -> new Item(new Item.Properties()));



    public static final DeferredItem<Item> IMBRIUM_INGOT = ITEMS.register("imbrium_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> IMBRIUM_NUGGET = ITEMS.register("imbrium_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> IMBRIUM_COG = ITEMS.register("imbrium_cog",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> IMBRIUM_GEARBOX = ITEMS.register("imbrium_gearbox",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<AxeItem> IMBRIUM_AXE = ITEMS.register("imbrium_axe",
            () -> new AxeItem(GiniumToolTiers.IMBRIUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(GiniumToolTiers.IMBRIUM, 6.0f, -3.0f))));

    public static final DeferredItem<HoeItem> IMBRIUM_HOE = ITEMS.register("imbrium_hoe",
            () -> new HoeItem(GiniumToolTiers.IMBRIUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(GiniumToolTiers.IMBRIUM, -2.0f, 0.0f))));

    public static final DeferredItem<PickaxeItem> IMBRIUM_PICKAXE = ITEMS.register("imbrium_pickaxe",
            () -> new PickaxeItem(GiniumToolTiers.IMBRIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(GiniumToolTiers.IMBRIUM, 1.0f, -2.8f))));

    public static final DeferredItem<ShovelItem> IMBRIUM_SHOVEL = ITEMS.register("imbrium_shovel",
            () -> new ShovelItem(GiniumToolTiers.IMBRIUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(GiniumToolTiers.IMBRIUM, 1.5f, -3.0f))));

    public static final DeferredItem<SwordItem> IMBRIUM_SWORD = ITEMS.register("imbrium_sword",
            () -> new SwordItem(GiniumToolTiers.IMBRIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(GiniumToolTiers.IMBRIUM, 3.0f, -2.4f))));

    public static final DeferredItem<ArmorItem> IMBRIUM_HELMET = ITEMS.register("imbrium_helmet",
            () -> new ArmorItem(GiniumArmorMaterials.IMBRIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(33))));

    public static final DeferredItem<ArmorItem> IMBRIUM_CHESTPLATE = ITEMS.register("imbrium_chestplate",
            () -> new ArmorItem(GiniumArmorMaterials.IMBRIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(33))));

    public static final DeferredItem<ArmorItem> IMBRIUM_LEGGINGS = ITEMS.register("imbrium_leggings",
            () -> new ArmorItem(GiniumArmorMaterials.IMBRIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(33))));

    public static final DeferredItem<ArmorItem> IMBRIUM_BOOTS = ITEMS.register("imbrium_boots",
            () -> new ArmorItem(GiniumArmorMaterials.IMBRIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(33))));

    public static final DeferredItem<Item> ROSITE_SHARD = ITEMS.register("rosite_shard",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NYLITE_SHARD = ITEMS.register("nylite_shard",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> SOFIUM_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("sofium_upgrade_smithing_template",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SOFIUM_INGOT = ITEMS.register("sofium_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<AxeItem> SOFIUM_AXE = ITEMS.register("sofium_axe",
            () -> new AxeItem(GiniumToolTiers.SOFIUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(GiniumToolTiers.IMBRIUM, 9.0f, -3.0f))));

    public static final DeferredItem<HoeItem> SOFIUM_HOE = ITEMS.register("sofium_hoe",
            () -> new HoeItem(GiniumToolTiers.SOFIUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(GiniumToolTiers.IMBRIUM, -2.0f, 0.0f))));

    public static final DeferredItem<PickaxeItem> SOFIUM_PICKAXE = ITEMS.register("sofium_pickaxe",
            () -> new PickaxeItem(GiniumToolTiers.SOFIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(GiniumToolTiers.IMBRIUM, 1.0f, -2.8f))));

    public static final DeferredItem<ShovelItem> SOFIUM_SHOVEL = ITEMS.register("sofium_shovel",
            () -> new ShovelItem(GiniumToolTiers.SOFIUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(GiniumToolTiers.IMBRIUM, 1.5f, -3.0f))));

    public static final DeferredItem<SwordItem> SOFIUM_SWORD = ITEMS.register("sofium_sword",
            () -> new SwordItem(GiniumToolTiers.SOFIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(GiniumToolTiers.IMBRIUM, 3.0f, -2.4f))));

    public static final DeferredItem<ArmorItem> SOFIUM_HELMET = ITEMS.register("sofium_helmet",
            () -> new ArmorItem(GiniumArmorMaterials.SOFIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(45))));

    public static final DeferredItem<ArmorItem> SOFIUM_CHESTPLATE = ITEMS.register("sofium_chestplate",
            () -> new ArmorItem(GiniumArmorMaterials.SOFIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(45))));

    public static final DeferredItem<ArmorItem> SOFIUM_LEGGINGS = ITEMS.register("sofium_leggings",
            () -> new ArmorItem(GiniumArmorMaterials.SOFIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(45))));

    public static final DeferredItem<ArmorItem> SOFIUM_BOOTS = ITEMS.register("sofium_boots",
            () -> new ArmorItem(GiniumArmorMaterials.SOFIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(45))));



    public static final DeferredItem<Item> GINPOWDER = ITEMS.register("ginpowder",
            () -> new Item(new Item.Properties().food(GiniumFoodProperties.GINPOWDER)));

    public static final DeferredItem<Item> GIN_APPLE = ITEMS.register("gin_apple",
            () -> new Item(new Item.Properties().food(GiniumFoodProperties.GIN_APPLE)));

    public static final DeferredItem<Item> RAINPOWDER = ITEMS.register("rainpowder",
            () -> new Item(new Item.Properties().food(GiniumFoodProperties.RAINPOWDER)));

    public static final DeferredItem<Item> RAIN_APPLE = ITEMS.register("rain_apple",
            () -> new Item(new Item.Properties().food(GiniumFoodProperties.RAIN_APPLE)));

    public static final DeferredItem<Item> ROSPOWDER = ITEMS.register("rospowder",
            () -> new Item(new Item.Properties().food(GiniumFoodProperties.ROSPOWDER)));

    public static final DeferredItem<Item> ROSE_APPLE = ITEMS.register("rose_apple",
            () -> new Item(new Item.Properties().food(GiniumFoodProperties.ROSE_APPLE)));

    public static final DeferredItem<Item> NYLIPOWDER = ITEMS.register("nylipowder",
            () -> new Item(new Item.Properties().food(GiniumFoodProperties.NYLIPOWDER)));

    public static final DeferredItem<Item> NYLI_APPLE = ITEMS.register("nyli_apple",
            () -> new Item(new Item.Properties().food(GiniumFoodProperties.NYLI_APPLE)));

    public static final DeferredItem<Item> SOFIA_APPLE = ITEMS.register("sofia_apple",
            () -> new Item(new Item.Properties().food(GiniumFoodProperties.SOFIA_APPLE)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
