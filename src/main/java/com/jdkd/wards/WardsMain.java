package com.jdkd.wards;

import com.jdkd.wards.common.block.BlockRegister;
import com.jdkd.wards.common.proxy.CommonProxy;
import com.jdkd.wards.common.tab.WardTab;
import com.jdkd.wards.common.util.WardRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = WardConstants.MODID, version = WardConstants.VERSION, name = WardConstants.MOD_NAME)
public class WardsMain {

    @Mod.Instance(WardConstants.MODID)
    public static WardsMain instance;

    @SidedProxy(clientSide = "com.jdkd.wards.client.proxy.ClientProxy", serverSide = "com.jdkd.wards.common.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static final CreativeTabs MAIN_TAB = new WardTab("wards_main", new ItemStack(Items.APPLE));

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit();
    }

}
