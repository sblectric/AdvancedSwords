package com.advancedswords.integration.jei;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

import com.advancedswords.crafting.RecipeEnchantmentUpgrade;

public class EnchantmentUpgradeHandler implements IRecipeHandler<RecipeEnchantmentUpgradeJEI>{

	@Override
	public Class<RecipeEnchantmentUpgradeJEI> getRecipeClass() {
		return RecipeEnchantmentUpgradeJEI.class;
	}

	@Override
	public String getRecipeCategoryUid() {
		return EnchantmentUpgradeCategory.UID;
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(RecipeEnchantmentUpgradeJEI recipe) {
		return new EnchantmentUpgradeWrapper(recipe);
	}

	@Override
	public boolean isRecipeValid(RecipeEnchantmentUpgradeJEI recipe) {
		return recipe.item != null && recipe.upgrade != null && recipe.output != null;
	}

}
