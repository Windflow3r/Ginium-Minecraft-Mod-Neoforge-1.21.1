package net.windflow3r.ginium;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.windflow3r.ginium.screen.GiniumMenuTypes;
import net.windflow3r.ginium.screen.custom.PowderizerScreen;

@Mod(value = Ginium.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(
        modid = Ginium.MOD_ID,
        bus = EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public class GiniumTestClient {

    public GiniumTestClient(ModContainer container) {
        container.registerExtensionPoint(
                IConfigScreenFactory.class,
                ConfigurationScreen::new
        );
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        Ginium.LOGGER.info("HELLO FROM CLIENT SETUP");
        Ginium.LOGGER.info(
                "MINECRAFT NAME >> {}",
                Minecraft.getInstance().getUser().getName()
        );
    }

    @SubscribeEvent
    static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(
                GiniumMenuTypes.POWDERIZER_MENU.get(),
                PowderizerScreen::new
        );
    }
}