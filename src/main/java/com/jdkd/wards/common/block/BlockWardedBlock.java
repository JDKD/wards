package com.jdkd.wards.common.block;

import com.jdkd.wards.WardsMain;
import com.jdkd.wards.common.tiles.TileEntityWardedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockWardedBlock extends Block {

    public BlockWardedBlock() {
        super(Material.CLAY);
        setUnlocalizedName("block_warded_base");
        setRegistryName("block_warded_base");
        setCreativeTab(WardsMain.MAIN_TAB);

        setHardness(-1f);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityWardedBlock();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        super.onBlockClicked(worldIn, pos, playerIn);

        boolean bool = new Random().nextBoolean();
        TileEntityWardedBlock te = (TileEntityWardedBlock) worldIn.getTileEntity(pos);

        if (bool) {
            te.setBlockState(Blocks.BRICK_BLOCK.getDefaultState());
        } else {
            te.setBlockState(Blocks.IRON_BLOCK.getDefaultState());
        }

    }
}
