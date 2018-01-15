package com.jdkd.wards.common.proxy;

import net.minecraft.entity.player.EntityPlayer;

public abstract class CommonProxy {

    public void preInit() {
    }

    public void init() {
    }

    public void postInit() {
    }

    public abstract boolean isPlayerInCreativeMode(EntityPlayer player);

    public abstract boolean isDedicatedServer();

}
