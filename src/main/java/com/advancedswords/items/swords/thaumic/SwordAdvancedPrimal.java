package com.advancedswords.items.swords.thaumic;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class SwordAdvancedPrimal extends SwordAdvancedVoid {

	public SwordAdvancedPrimal(ToolMaterial mat) {
		super(mat);
		this.warping = 3;
	}
	
	@Override
	public void applySappingEffect(EntityLivingBase target) {
		target.addPotionEffect(new PotionEffect(Potion.wither.getId(), 120));
	}
	
    @Override
	public String getSapping() {
        return EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("enchantment.special.sapwither");
    }
    
    @Override
    public boolean hasEffect(ItemStack blah) {
    	return true;
    }
    
    @Override
    public EnumRarity getRarity(ItemStack blah) {
    	return EnumRarity.EPIC;
    }

}
