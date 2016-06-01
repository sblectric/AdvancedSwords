package com.advancedswords.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.init.Enchantments;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.advancedswords.config.ASConfig;
import com.advancedswords.creativetabs.ASCreativeTabs;
import com.advancedswords.items.swords.Swords;
import com.advancedswords.util.JointList;

/** Item class */
public class ASItems {
	
	private static JointList<ItemBasic> items;
	
	public static void mainRegistry() {
		Swords.mainRegistry();
		items = new JointList();
		addItems();
		registerItems();
	}
	
	public static ItemBasic sharpnessUpgrade;
	public static ItemBasic smiteUpgrade;
	public static ItemBasic spiderUpgrade;
	public static ItemBasic knockbackUpgrade;
	public static ItemBasic fireAspectUpgrade;
	public static ItemBasic lootingUpgrade;
	public static ItemBasic unbreakingUpgrade;
	public static ItemBasic mendingUpgrade;
	
	/** Add items to the game */
	private static void addItems() {
		if(ASConfig.enableEnchantmentUpgrades) items.join(
			sharpnessUpgrade = (ItemBasic)new ItemEnchantmentUpgrade(Enchantments.SHARPNESS).setUnlocalizedName("sharpnessUpgrade").setCreativeTab(ASCreativeTabs.main),
			smiteUpgrade = (ItemBasic)new ItemEnchantmentUpgrade(Enchantments.SMITE).setUnlocalizedName("smiteUpgrade").setCreativeTab(ASCreativeTabs.main),
			spiderUpgrade = (ItemBasic)new ItemEnchantmentUpgrade(Enchantments.BANE_OF_ARTHROPODS).setUnlocalizedName("spiderUpgrade").setCreativeTab(ASCreativeTabs.main),
			knockbackUpgrade = (ItemBasic)new ItemEnchantmentUpgrade(Enchantments.KNOCKBACK).setUnlocalizedName("knockbackUpgrade").setCreativeTab(ASCreativeTabs.main),
			fireAspectUpgrade = (ItemBasic)new ItemEnchantmentUpgrade(Enchantments.FIRE_ASPECT).setUnlocalizedName("fireAspectUpgrade").setCreativeTab(ASCreativeTabs.main),
			lootingUpgrade = (ItemBasic)new ItemEnchantmentUpgrade(Enchantments.LOOTING).setUnlocalizedName("lootingUpgrade").setCreativeTab(ASCreativeTabs.main),
			unbreakingUpgrade = (ItemBasic)new ItemEnchantmentUpgrade(Enchantments.UNBREAKING).setUnlocalizedName("unbreakingUpgrade").setCreativeTab(ASCreativeTabs.main),
			mendingUpgrade = (ItemBasic)new ItemEnchantmentUpgrade(Enchantments.MENDING, true).setUnlocalizedName("mendingUpgrade").setCreativeTab(ASCreativeTabs.main)
		);
	}
	
	/** Register the items */
	private static void registerItems() {
		// iterate through them
		for(ItemBasic item : items) {
			GameRegistry.registerItem(item, item.getShorthandName());
		}
	}
	
	/** Register the renderers */
	@SideOnly(Side.CLIENT)
	public static void registerRendering() {
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		Swords.registerRendering(mesher);
	    
		// iterate through them
		for(ItemBasic item : items) {
			item.registerRender(mesher);
		}
	}

}
