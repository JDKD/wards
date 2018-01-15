package com.jdkd.wards.common.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class WardTab extends CreativeTabs {

    private ItemStack iconStack;

    public WardTab(String label, ItemStack iconStack ) {
        super(label);
        this.iconStack = iconStack;
    }

    @Override
    public ItemStack getTabIconItem() {
        return iconStack;
    }
}
