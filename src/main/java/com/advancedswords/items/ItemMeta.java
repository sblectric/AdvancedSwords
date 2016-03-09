package com.advancedswords.items;

import java.util.List;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.advancedswords.ref.RefStrings;
import com.advancedswords.util.JointList;

public class ItemMeta extends ItemBasic {
	
	public int nSubItems;
	public boolean sameIcon;
	public boolean[] hasEffect;
	
	public ItemMeta(int nSubItems, boolean sameIcon, boolean... hasEffect) {
		super();
		this.nSubItems = nSubItems;
		this.sameIcon = sameIcon;
		this.hasSubtypes = true;
		this.hasEffect = hasEffect;
	}
	
	public ItemMeta(int nSubItems) {
		this(nSubItems, false);
	}
	
	/** Get the sub items as a list for the creative tab */
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List sub) {
		for(int meta = 0; meta < nSubItems; meta++) {
			sub.add(new ItemStack(item, 1, meta));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
	    return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean hasEffect(ItemStack stack) {
		int index = stack.getItemDamage();
		return hasEffect[Math.min(index, hasEffect.length - 1)];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerRender(ItemModelMesher mesher) {
		JointList<ResourceLocation> names = new JointList();
		if(sameIcon) {
			for(int meta = 0; meta < nSubItems; meta++) {
				names.join(new ResourceLocation(RefStrings.MODID + ":" + this.getShorthandName()));
			}
			ModelBakery.registerItemVariants(this, names.toArray(new ResourceLocation[names.size()]));
			for(int meta = 0; meta < nSubItems; meta++) {
				mesher.register(this, meta, new ModelResourceLocation(RefStrings.MODID + ":" + this.getShorthandName(), "inventory"));
			}
		} else {
			for(int meta = 0; meta < nSubItems; meta++) {
				names.join(new ResourceLocation(RefStrings.MODID + ":" + this.getShorthandName() + "_" + meta));
			}
			ModelBakery.registerItemVariants(this, names.toArray(new ResourceLocation[names.size()]));
			for(int meta = 0; meta < nSubItems; meta++) {
				mesher.register(this, meta, new ModelResourceLocation(RefStrings.MODID + ":" + this.getShorthandName() + "_" + meta, "inventory"));
			}
		}
	}

}
