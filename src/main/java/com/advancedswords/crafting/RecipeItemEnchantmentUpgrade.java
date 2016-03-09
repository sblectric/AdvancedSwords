package com.advancedswords.crafting;

import com.advancedswords.items.ItemEnchantmentUpgrade;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;

/** Creates a tiered enchantment upgrade based on an ItemStack of an ItemEnchantmentUpgrade */
public class RecipeItemEnchantmentUpgrade extends RecipeTieredEnchantmentUpgrade {

	public RecipeItemEnchantmentUpgrade(ItemStack upgradeItem) {
		super(upgradeItem, ((ItemEnchantmentUpgrade)upgradeItem.getItem()).getEnchantment(), upgradeItem.getItemDamage());
	}

}
