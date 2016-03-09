package com.advancedswords.creativetabs;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ASCreativeTab extends CreativeTabs {
	
	protected Item displayItem;
 
    public ASCreativeTab(String unlocalizedName) {
        super(unlocalizedName);
    }
	
    public ASCreativeTab(String unlocalizedName, Item item) {
        this(unlocalizedName);
        this.displayItem = item;
    }
    
    public ASCreativeTab(String unlocalizedName, Block item) {
        this(unlocalizedName, Item.getItemFromBlock(item));
    }
    
    public void updateItem(Item item) {
    	this.displayItem = item;
    }
    
    public void updateItem(Block item) {
    	updateItem(Item.getItemFromBlock(item));
    }

    @Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return displayItem;
	}
    
}
