package com.advancedswords.items.swords.thaumic;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Loader;

import com.advancedswords.integration.thaumcraft.ThaumcraftIntegration;
import com.advancedswords.items.swords.SwordBasic;

import thaumcraft.api.items.IRepairable;

/** A sword that can be repaired with the Thaumcraft repair enchantment */
public class SwordThaumic extends SwordBasic implements IRepairable {

	public SwordThaumic(ToolMaterial mat) {
		super(mat);
	}
	
    /**
     Sets the item's creative tab if Thaumcraft is enabled, otherwise it is hidden.
     */
	@Override
    public SwordThaumic setCreativeTab(CreativeTabs tab) {
    	if(ThaumcraftIntegration.enabled) {
    		return (SwordThaumic)super.setCreativeTab(tab);
    	} else {
    		return this;
    	}
    }

}
