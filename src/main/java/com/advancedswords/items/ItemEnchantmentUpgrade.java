package com.advancedswords.items;

import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEnchantmentUpgrade extends ItemMeta {
	
	public static final int TIER_COUNT = 2;
	protected Enchantment enchant;

	public ItemEnchantmentUpgrade(Enchantment enchant) {
		super(TIER_COUNT, true, false, true);
		this.enchant = enchant;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		int tier = stack.getItemDamage();
		tooltip.add("Upgrades to " + StatCollector.translateToLocal(enchant.getName()) + " " + 
		(tier * enchant.getMaxLevel() + 1) + " - " + (tier + 1) * enchant.getMaxLevel());
	}
	
	/** Get the enchantment that this upgrade represents */
	public Enchantment getEnchantment() {
		return enchant;
	}

}
