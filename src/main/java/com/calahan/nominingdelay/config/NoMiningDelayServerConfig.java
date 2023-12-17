package com.calahan.nominingdelay.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class NoMiningDelayServerConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> BLOCK_BREAK_DELAY;

    static {
        BUILDER.push("No Mining Delay");

        BLOCK_BREAK_DELAY = BUILDER.comment(
                "How many ticks must pass between breaking one block and starting to break another?")
                .defineInRange("blockBreakDelay", 0, 0, 72000);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
