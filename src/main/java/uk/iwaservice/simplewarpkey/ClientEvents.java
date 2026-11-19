package uk.iwaservice.simplewarpkey;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "simplewarpkey", value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;
        while (ModKeys.WARP.consumeClick()) {
            mc.player.connection.sendCommand("warpkey");
        }
    }

    @Mod.EventBusSubscriber(modid = "simplewarpkey", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvent{
        @SubscribeEvent
        public static void onRegisterKeys(RegisterKeyMappingsEvent event){
            event.register(ModKeys.WARP);
        }
    }
}
