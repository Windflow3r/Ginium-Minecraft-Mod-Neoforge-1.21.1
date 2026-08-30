package net.windflow3r.ginium;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.windflow3r.ginium.block.GiniumBlocks;
import net.windflow3r.ginium.block.entity.GiniumBlockEntities;
import net.windflow3r.ginium.item.GiniumCreativeModeTabs;
import net.windflow3r.ginium.item.GiniumItems;
import net.windflow3r.ginium.screen.GiniumMenuTypes;
import org.slf4j.Logger;

@Mod(Ginium.MOD_ID)
public class Ginium {
    public static final String MOD_ID = "windflowersginium";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Ginium(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        // Server/game events belong on the common NeoForge event bus.
        NeoForge.EVENT_BUS.register(this);

        GiniumCreativeModeTabs.register(modEventBus);
        GiniumItems.register(modEventBus);
        GiniumBlocks.register(modEventBus);
        GiniumBlockEntities.register(modEventBus);
        GiniumMenuTypes.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }
}