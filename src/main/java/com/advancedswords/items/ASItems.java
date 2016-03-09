package com.advancedswords.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.advancedswords.creativetabs.ASCreativeTabs;
import com.advancedswords.items.swords.SwordBasic;
import com.advancedswords.items.swords.Swords;
import com.advancedswords.ref.RefStrings;
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
	public static ItemBasic knockbackUpgrade;
	public static ItemBasic fireAspectUpgrade;
	public static ItemBasic lootingUpgrade;
	public static ItemBasic unbreakingUpgrade;
	
	/** Add items to the game */
	private static void addItems() {
		items.join(
			sharpnessUpgrade = (ItemBasic)new ItemEnchantmentUpgrade(Enchantment.sharpness).setUnlocalizedName("sharpnessUpgrade").setCreativeTab(ASCreativeTabs.main),
			smiteUpgrade = (ItemBasic)new ItemEnchantmentUpgrade(Enchantment.smite).setUnlocalizedName("smiteUpgrade").setCreativeTab(ASCreativeTabs.main),
			knockbackUpgrade = (ItemBasic)new ItemEnchantmentUpgrade(Enchantment.knockback).setUnlocalizedName("knockbackUpgrade").setCreativeTab(ASCreativeTabs.main),
			fireAspectUpgrade = (ItemBasic)new ItemEnchantmentUpgrade(Enchantment.fireAspect).setUnlocalizedName("fireAspectUpgrade").setCreativeTab(ASCreativeTabs.main),
			lootingUpgrade = (ItemBasic)new ItemEnchantmentUpgrade(Enchantment.looting).setUnlocalizedName("lootingUpgrade").setCreativeTab(ASCreativeTabs.main),
			unbreakingUpgrade = (ItemBasic)new ItemEnchantmentUpgrade(Enchantment.unbreaking).setUnlocalizedName("unbreakingUpgrade").setCreativeTab(ASCreativeTabs.main)
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
