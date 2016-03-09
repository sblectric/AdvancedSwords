package com.advancedswords.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.advancedswords.blocks.ASBlocks;
import com.advancedswords.crafting.ASCraftingManager;
import com.advancedswords.creativetabs.ASCreativeTabs;
import com.advancedswords.items.ASItems;
import com.advancedswords.items.swords.Swords;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		ASCreativeTabs.mainRegistry();
	}
	
	public void onInit(FMLInitializationEvent event) {
		ASItems.mainRegistry();
		ASBlocks.mainRegistry();
		ASCreativeTabs.updateCreativeTabs();
	}
	
	public void postInit(FMLPostInitializationEvent event) {
		Swords.finalizeSwords();
		ASCraftingManager.mainRegistry();
	}
			
}
