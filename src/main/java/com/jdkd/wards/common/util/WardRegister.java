package com.jdkd.wards.common.util;

import com.jdkd.wards.WardConstants;
import com.jdkd.wards.WardsMain;
import com.jdkd.wards.common.block.BlockRegister;
import com.jdkd.wards.common.tiles.TileEntityWardedBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class WardRegister {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        BlockRegister.initialise();

        for(Block block : BlockRegister.MOD_BLOCKS) {
            event.getRegistry().register(block);
        }

        GameRegistry.registerTileEntity(TileEntityWardedBlock.class, "wards_warded_block_tile_entity");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for(Block block : BlockRegister.MOD_BLOCKS){
            event.getRegistry().registerAll(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        }
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        for(Block block : BlockRegister.MOD_BLOCKS){
            WardsMain.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, block.getRegistryName().toString());
        }
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
    }

}
