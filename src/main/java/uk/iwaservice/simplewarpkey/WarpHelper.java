package uk.iwaservice.simplewarpkey;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class WarpHelper {

    public static boolean warp(ServerPlayer sp){
        if (!sp.isCreative() && !sp.isSpectator()){
            sp.displayClientMessage(Component.translatable("message.simplewarpkey.creative_only"), true);
            return false;
        }
        Level level = sp.level();
        HitResult hitResult = sp.pick(1000, 0, false);
        if(hitResult.getType() != HitResult.Type.BLOCK) return false;

        BlockPos above = ((BlockHitResult) hitResult).getBlockPos().above();
        boolean free = level.getBlockState(above).getCollisionShape(level,above).isEmpty()
                && level.getBlockState(above.above()).getCollisionShape(level,above.above()).isEmpty();
        if (!free) return false;

        sp.connection.teleport(above.getX() + 0.5, above.getY(), above.getZ() + 0.5, sp.getYRot(), sp.getXRot());
        sp.resetFallDistance();
        return true;
    }
}
