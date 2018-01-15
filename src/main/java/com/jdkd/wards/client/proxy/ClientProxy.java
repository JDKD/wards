package com.jdkd.wards.client.proxy;

import com.jdkd.wards.common.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class ClientProxy extends CommonProxy {

    @Override
    public boolean isPlayerInCreativeMode(EntityPlayer player) {
        if(player instanceof EntityPlayerMP){
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
            return entityPlayerMP.interactionManager.isCreative();
        } else if (player instanceof EntityPlayerSP) {
            return Minecraft.getMinecraft().playerController.isInCreativeMode();
        }

        return false;
    }

    @Override
    public boolean isDedicatedServer() {
        return false;
    }
}
