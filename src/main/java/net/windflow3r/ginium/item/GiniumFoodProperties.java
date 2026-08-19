package net.windflow3r.ginium.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class GiniumFoodProperties {

    // =========================================================
    // ROSPOWDER - SWEET / ENERGETIC / NETHER
    // =========================================================

    public static final FoodProperties ROSPOWDER =
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.5f)
                    .alwaysEdible()

                    // Positive - energetic / Nether
                    .effect(() -> new MobEffectInstance(
                                    MobEffects.SATURATION,
                                    200 + (int) (Math.random() * 401),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.MOVEMENT_SPEED,
                                    200 + (int) (Math.random() * 401),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.JUMP,
                                    200 + (int) (Math.random() * 401),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.FIRE_RESISTANCE,
                                    200 + (int) (Math.random() * 401)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.REGENERATION,
                                    200 + (int) (Math.random() * 401),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.DAMAGE_BOOST,
                                    200 + (int) (Math.random() * 401),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.51f))

                    // Negative - unstable
                    .effect(() -> new MobEffectInstance(
                                    MobEffects.HUNGER,
                                    100 + (int) (Math.random() * 201),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.41f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.WEAKNESS,
                                    100 + (int) (Math.random() * 201),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.71f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.POISON,
                                    100 + (int) (Math.random() * 201),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.DARKNESS,
                                    100 + (int) (Math.random() * 201)),
                            0.10f + (float) (Math.random() * 0.61f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.CONFUSION,
                                    100 + (int) (Math.random() * 201),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.41f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.GLOWING,
                                    100 + (int) (Math.random() * 201)),
                            0.05f)

                    .build();


    // =========================================================
    // NYLIPOWDER - DARK / EVIL / END
    // =========================================================

    public static final FoodProperties NYLIPOWDER =
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.5f)
                    .alwaysEdible()

                    // Positive - strange / End
                    .effect(() -> new MobEffectInstance(
                                    MobEffects.INVISIBILITY,
                                    200 + (int) (Math.random() * 401)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.NIGHT_VISION,
                                    200 + (int) (Math.random() * 401)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.LEVITATION,
                                    100 + (int) (Math.random() * 201),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.61f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.SLOW_FALLING,
                                    200 + (int) (Math.random() * 401)),
                            0.10f + (float) (Math.random() * 0.51f))

                    // Negative - dark / unstable
                    .effect(() -> new MobEffectInstance(
                                    MobEffects.DARKNESS,
                                    100 + (int) (Math.random() * 201)),
                            0.10f + (float) (Math.random() * 0.61f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.CONFUSION,
                                    100 + (int) (Math.random() * 201),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.41f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.WEAKNESS,
                                    100 + (int) (Math.random() * 201),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.61f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.GLOWING,
                                    100 + (int) (Math.random() * 201)),
                            0.05f)

                    .build();


    // =========================================================
    // GINPOWDER - CLEVER / CALM / GROUNDED
    // =========================================================

    public static final FoodProperties GINPOWDER =
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.5f)
                    .alwaysEdible()

                    // Positive - intelligence / stability
                    .effect(() -> new MobEffectInstance(
                                    MobEffects.SATURATION,
                                    200 + (int) (Math.random() * 401),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.DIG_SPEED,
                                    200 + (int) (Math.random() * 401),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.DAMAGE_RESISTANCE,
                                    200 + (int) (Math.random() * 401),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.NIGHT_VISION,
                                    200 + (int) (Math.random() * 401)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.REGENERATION,
                                    200 + (int) (Math.random() * 401),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.SLOW_FALLING,
                                    200 + (int) (Math.random() * 401)),
                            0.10f + (float) (Math.random() * 0.51f))

                    // Negative - mental / physical fatigue
                    .effect(() -> new MobEffectInstance(
                                    MobEffects.WEAKNESS,
                                    100 + (int) (Math.random() * 201),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.61f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.MOVEMENT_SLOWDOWN,
                                    100 + (int) (Math.random() * 201),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.DIG_SLOWDOWN,
                                    100 + (int) (Math.random() * 201),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .build();


    // =========================================================
    // RAINPOWDER - LIGHT / THIN / CLOUD
    // =========================================================

    public static final FoodProperties RAINPOWDER =
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.5f)
                    .alwaysEdible()

                    // Positive - light / airy
                    .effect(() -> new MobEffectInstance(
                                    MobEffects.INVISIBILITY,
                                    200 + (int) (Math.random() * 401)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.SATURATION,
                                    200 + (int) (Math.random() * 401),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.MOVEMENT_SPEED,
                                    200 + (int) (Math.random() * 401),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.JUMP,
                                    200 + (int) (Math.random() * 401),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.SLOW_FALLING,
                                    200 + (int) (Math.random() * 401)),
                            0.10f + (float) (Math.random() * 0.51f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.WATER_BREATHING,
                                    200 + (int) (Math.random() * 401)),
                            0.10f + (float) (Math.random() * 0.51f))

                    // Negative - unpredictable weather
                    .effect(() -> new MobEffectInstance(
                                    MobEffects.LEVITATION,
                                    100 + (int) (Math.random() * 201),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.61f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.CONFUSION,
                                    100 + (int) (Math.random() * 201),
                                    (int) (Math.random() * 3)),
                            0.10f + (float) (Math.random() * 0.41f))

                    .effect(() -> new MobEffectInstance(
                                    MobEffects.DARKNESS,
                                    100 + (int) (Math.random() * 201)),
                            0.10f + (float) (Math.random() * 0.61f))

                    .build();


    // =========================================================
    // ROSE APPLE - REFINED ROSPOWDER
    // =========================================================

    public static final FoodProperties ROSE_APPLE =
            new FoodProperties.Builder()
                    .nutrition(7)
                    .saturationModifier(2.5f)
                    .alwaysEdible()

                    .effect(() -> new MobEffectInstance(
                            MobEffects.SATURATION, 200, 1), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.MOVEMENT_SPEED, 3000, 1), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.JUMP, 2000, 1), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.FIRE_RESISTANCE, 4000), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.REGENERATION, 200, 1), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.DAMAGE_BOOST, 2500, 3), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.GLOWING, 2000), 1.0f)

                    .build();


    // =========================================================
    // GIN APPLE - REFINED GINPOWDER
    // =========================================================

    public static final FoodProperties GIN_APPLE =
            new FoodProperties.Builder()
                    .nutrition(7)
                    .saturationModifier(2.5f)
                    .alwaysEdible()

                    .effect(() -> new MobEffectInstance(
                            MobEffects.SATURATION, 500, 3), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.DIG_SPEED, 2000, 2), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.DAMAGE_RESISTANCE, 4000, 2), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.NIGHT_VISION, 3000), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.REGENERATION, 1500, 2), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.SLOW_FALLING, 3500), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.GLOWING, 2000), 1.0f)

                    .build();


    // =========================================================
    // RAIN APPLE - REFINED RAINPOWDER
    // =========================================================

    public static final FoodProperties RAIN_APPLE =
            new FoodProperties.Builder()
                    .nutrition(7)
                    .saturationModifier(2.5f)
                    .alwaysEdible()

                    .effect(() -> new MobEffectInstance(
                            MobEffects.INVISIBILITY, 1500), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.SATURATION, 500, 2), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.MOVEMENT_SPEED, 4000, 2), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.JUMP, 4500, 1), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.SLOW_FALLING, 1000), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.WATER_BREATHING, 4000), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.GLOWING, 2000), 1.0f)

                    .build();


    // =========================================================
    // NYLI APPLE - REFINED NYLIPOWDER
    // =========================================================

    public static final FoodProperties NYLI_APPLE =
            new FoodProperties.Builder()
                    .nutrition(7)
                    .saturationModifier(2.5f)
                    .alwaysEdible()

                    .effect(() -> new MobEffectInstance(
                            MobEffects.INVISIBILITY, 6000), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.NIGHT_VISION, 5000), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.LEVITATION, 3000, 1), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.SLOW_FALLING, 6000), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.GLOWING, 2000), 1.0f)

                    .build();


    // =========================================================
    // Sofia's APPLE - REFINED ALL THE POWDERS
    // =========================================================

    public static final FoodProperties SOFIA_APPLE =
            new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationModifier(3.0f)
                    .alwaysEdible()

                    // 🌹 Rosite / Nether
                    .effect(() -> new MobEffectInstance(
                            MobEffects.SATURATION, 2000, 2), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.FIRE_RESISTANCE, 5500), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.REGENERATION, 2000, 2), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.DAMAGE_BOOST, 3000, 2), 1.0f)

                    // 🖤 Nylite / End
                    .effect(() -> new MobEffectInstance(
                            MobEffects.INVISIBILITY, 4500), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.NIGHT_VISION, 7000), 1.0f)

                    // 💎 Ginium / Grounded
                    .effect(() -> new MobEffectInstance(
                            MobEffects.DIG_SPEED, 7500, 2), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.DAMAGE_RESISTANCE, 12000, 2), 1.0f)

                    // ☁️ Rainberg / Clouds
                    .effect(() -> new MobEffectInstance(
                            MobEffects.MOVEMENT_SPEED, 10000, 2), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.JUMP, 6000, 2), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.SLOW_FALLING, 9000), 1.0f)

                    .effect(() -> new MobEffectInstance(
                            MobEffects.WATER_BREATHING, 12000), 1.0f)

                    // ✨ Refined / Convergence
                    .effect(() -> new MobEffectInstance(
                            MobEffects.GLOWING, 200), 1.0f)

                    .build();
}