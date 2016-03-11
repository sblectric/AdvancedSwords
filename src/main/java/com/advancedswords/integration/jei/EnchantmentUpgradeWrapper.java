package com.advancedswords.integration.jei;

import java.util.LinkedList;
import java.util.List;

import mezz.jei.api.recipe.BlankRecipeWrapper;
import mezz.jei.api.recipe.wrapper.ICraftingRecipeWrapper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.advancedswords.crafting.RecipeEnchantmentUpgrade;
import com.advancedswords.util.ASUtils;
import com.advancedswords.util.JointList;

public class EnchantmentUpgradeWrapper extends BlankRecipeWrapper {

	private final RecipeEnchantmentUpgradeJEI recipe;
	
	public EnchantmentUpgradeWrapper(RecipeEnchantmentUpgradeJEI recipe) {
		this.recipe = recipe;
	}

	@Override
	public List getInputs() {
		return new JointList().join(recipe.item).join(recipe.upgrade);
	}

	@Override
	public List getOutputs() {
		return new JointList().join(recipe.output);
	}

}
