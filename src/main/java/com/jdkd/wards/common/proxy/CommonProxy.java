package com.jdkd.wards.common.proxy;

import com.jdkd.wards.common.block.BlockRegister;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public abstract class CommonProxy {

    public void preInit() {
    }

    public void init() {
    }

    public void postInit() {
    }

    public void registerItemRenderer(Item item, int meta, String id){

    }

    public abstract boolean isPlayerInCreativeMode(EntityPlayer player);

    public abstract boolean isDedicatedServer();

}
