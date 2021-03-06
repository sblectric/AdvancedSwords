package com.advancedswords.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.advancedswords.blocks.ASBlocks;
import com.advancedswords.config.ASConfig;
import com.advancedswords.crafting.ASCraftingManager;
import com.advancedswords.creativetabs.ASCreativeTabs;
import com.advancedswords.integration.ASModIntegration;
import com.advancedswords.items.ASItems;
import com.advancedswords.items.swords.Swords;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		ASConfig.mainRegistry(event.getSuggestedConfigurationFile());
		ASCreativeTabs.mainRegistry();
		ASModIntegration.preInit();
	}
	
	public void onInit(FMLInitializationEvent event) {
		ASBlocks.mainRegistry();
		ASItems.mainRegistry();
		ASCreativeTabs.updateCreativeTabs();
		ASModIntegration.onInit();
	}
	
	public void postInit(FMLPostInitializationEvent event) {
		ASCraftingManager.mainRegistry();
		ASModIntegration.postInit();
		Swords.finalizeSwords();
	}
			
}
