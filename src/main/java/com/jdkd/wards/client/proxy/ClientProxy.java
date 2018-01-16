package com.jdkd.wards.client.proxy;

import com.jdkd.wards.client.renderers.TileEntityWardedBlockSpecialRenderer;
import com.jdkd.wards.common.block.BlockRegister;
import com.jdkd.wards.common.proxy.CommonProxy;
import com.jdkd.wards.common.tiles.TileEntityWardedBlock;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWardedBlock.class, new TileEntityWardedBlockSpecialRenderer());
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(id, "inventory"));
    }

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
