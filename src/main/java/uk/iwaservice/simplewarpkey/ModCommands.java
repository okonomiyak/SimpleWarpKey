package uk.iwaservice.simplewarpkey;

import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "simplewarpkey")
public class ModCommands {

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("warpkey")
                .requires(src -> src.hasPermission(2))
                .executes(
                ctx -> {
                    ServerPlayer sp = ctx.getSource().getPlayerOrException();
                    return WarpHelper.warp(sp) ? 1 : 0;
                }));
    }
}
