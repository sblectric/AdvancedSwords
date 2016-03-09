package com.advancedswords.crafting;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;

import com.advancedswords.items.ASItems;

public abstract class RecipeTieredEnchantmentUpgrade extends RecipeEnchantmentUpgrade {
	
	public RecipeTieredEnchantmentUpgrade(ItemStack upgrade, Enchantment toUpgrade, int tier) {
		super(upgrade, toUpgrade, tier * toUpgrade.getMaxLevel(), (tier + 1) * toUpgrade.getMaxLevel());
	}
	
}
