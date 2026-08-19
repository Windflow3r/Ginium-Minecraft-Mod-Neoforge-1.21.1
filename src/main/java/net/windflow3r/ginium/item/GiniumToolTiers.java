package net.windflow3r.ginium.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.windflow3r.ginium.util.ModTags;

public class GiniumToolTiers {
    public static final Tier GINIUM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_GINIUM_TOOL,
            1000, 7f, 2.5f, 15, () -> Ingredient.of(GiniumItems.GINIUM_INGOT));

    public static final Tier IMBRIUM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_IMBRIUM_TOOL,
            2000, 10f, 4.0f, 20, () -> Ingredient.of(GiniumItems.IMBRIUM_INGOT));

    public static final Tier SOFIUM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_SOFIUM_TOOL,
            3500, 10f, 6.0f, 30, () -> Ingredient.of(GiniumItems.SOFIUM_INGOT));


}
// Iron - uses: 250, speed: 6.0F, attack: 2.0F, enchantment: 14

// Ginium - uses: 1000, speed: 7.0F, attack: 2.5F, enchantment: 15

// Diamond - uses: 1561, speed: 8.0F, attack: 3.0F, enchantment: 10

// Imbrium - uses: 2000, speed: 10.0F, attack: 4.0F, enchantment: 20

// Netherite - uses: 2031, speed: 9.0F, attack: 4.0F, enchantment: 15

// Sofium - uses: 2500, speed: 10.0F, attack: 5.0F, enchantment: 30