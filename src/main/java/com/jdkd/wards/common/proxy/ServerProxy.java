package com.jdkd.wards.common.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class ServerProxy extends CommonProxy {

    @Override
    public boolean isPlayerInCreativeMode(EntityPlayer player) {

        if(player instanceof EntityPlayerMP){
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
            return entityPlayerMP.interactionManager.isCreative();
        }

        return false;
    }

    @Override
    public boolean isDedicatedServer() {
        return true;
    }
}
