package com.jdkd.wards.common.block;

import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class BlockRegister {

    public static List<Block> MOD_BLOCKS = new ArrayList<>();
    public static BlockWardedBlock wardedBlockBase = new BlockWardedBlock();
    public static void initialise(){
        MOD_BLOCKS.add(wardedBlockBase);
    }

}
