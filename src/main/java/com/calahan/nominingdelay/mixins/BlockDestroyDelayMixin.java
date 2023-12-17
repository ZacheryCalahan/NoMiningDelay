package com.calahan.nominingdelay.mixins;

import com.calahan.nominingdelay.config.NoMiningDelayServerConfig;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(MultiPlayerGameMode.class)
public abstract class BlockDestroyDelayMixin {
    @ModifyConstant(
            method = {
                    "continueDestroyBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;)Z",
                    "startDestroyBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;)Z"
            },
            constant = @Constant(intValue = 5, log = true),
            expect = 3
    )
    private int nominingdelay_blockDestroyDelayChange(int value)
    {
        return NoMiningDelayServerConfig.BLOCK_BREAK_DELAY.get();
    }
}
