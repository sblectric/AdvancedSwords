package com.advancedswords.creativetabs;

import net.minecraft.creativetab.CreativeTabs;

import com.advancedswords.items.swords.Swords;

public class ASCreativeTabs {
	
	public static CreativeTabs main;
	
	public static void mainRegistry() {
		registerCreativeTabs();
	}
	
	private static void registerCreativeTabs() {
		main = new ASCreativeTab("asMain");
	}
	
	public static void updateCreativeTabs() {
		((ASCreativeTab)main).updateItem(Swords.advancedDiamondSword);
	}

}
