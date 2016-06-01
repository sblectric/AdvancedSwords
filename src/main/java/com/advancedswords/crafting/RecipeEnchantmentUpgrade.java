package com.advancedswords.crafting;

import java.util.List;
import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import com.advancedswords.util.ASUtils;
import com.advancedswords.util.JointList;

public abstract class RecipeEnchantmentUpgrade implements IRecipe {
	
	private static List<RecipeEnchantmentUpgrade> allUpgrades = new JointList();
	protected ItemStack upgrade;
	protected Enchantment enchant;
	protected int minLevel, maxLevel;
	
	protected RecipeEnchantmentUpgrade(ItemStack upgrade, Enchantment toUpgrade, int minLevel, int maxLevel) {
		this.upgrade = upgrade;
		this.enchant = toUpgrade;
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
		allUpgrades.add(this);
	}
	
	public static List<RecipeEnchantmentUpgrade> getAllUpgrades() {
		return allUpgrades;
	}
	
	/** Gets the active upgrade for this recipe */
	public ItemStack getUpgrade() {
		return upgrade;
	}
	
	/** Gets the active enchantment for this recipe */
	public Enchantment getEnchantment() {
		return enchant;
	}
	
	/** gets the minimum level of the enchantment needed on the sword to apply the upgrade */
	public int getMinLevelToApply() {
		return minLevel;
	}
	
	/** gets the maximum level of the enchantment that can be put on the sword with the upgrade */
	public int getMaxUpgradeLevel() {
		return maxLevel;
	}

	/** Gets an upgradeable stack */
	public ItemStack getUpgradableStack(List<ItemStack> s) {
		if(ASUtils.doesItemStackListContain(s, upgrade, true)) {
			ItemStack toUpgrade = s.get(0);
			if(enchant.canApply(toUpgrade) && toUpgrade.getItem() instanceof ItemSword) {
				Map<Enchantment, Integer> activeEnchs = EnchantmentHelper.getEnchantments(toUpgrade);
				for(Enchantment i : activeEnchs.keySet()) {
					if(i == enchant) {
						int level = activeEnchs.get(i);
						if(level >= maxLevel) {
							return null;
						}
					}
				}
				return toUpgrade.copy();
			}
		}
		return null;
	}
	
	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		JointList<ItemStack> s = new JointList();
		for(int i = 0; i < inv.getSizeInventory(); i++) {
			if(inv.getStackInSlot(i) != null) s.add(inv.getStackInSlot(i));
		}
		
		// 2 things in this recipe
		if(s.size() == 2) {
			if(getUpgradableStack(s) != null) return true;
		}
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		JointList<ItemStack> s = new JointList();
		for(int i = 0; i < inv.getSizeInventory(); i++) {
			if(inv.getStackInSlot(i) != null) s.add(inv.getStackInSlot(i));
		}
		
		// get the upgradable stack again
		ItemStack c = getUpgradableStack(s);
		if(c == null) return null;
		Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(c);
		int clevel = EnchantmentHelper.getEnchantmentLevel(enchant, c);
		
		// check for the enchantment
		for(Enchantment i : map.keySet()) {
			// it exists
			if(i == enchant && map.get(i) >= minLevel) {
				int newLevel = map.get(i) + 1;
				map.put(i, newLevel);
				EnchantmentHelper.setEnchantments(map, c);
				return c;
			}
		}
		
		// it does not yet exist, so give level I
		if(minLevel <= 0) {
			map.put(enchant, 1);
			EnchantmentHelper.setEnchantments(map, c);
			return c;
		} else {
			return null;
		}
	}

	@Override
	public int getRecipeSize() {
		return 2;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return new ItemStack(Blocks.AIR);
	}

	@Override
	public ItemStack[] getRemainingItems(InventoryCrafting inv) {
		return new ItemStack[inv.getSizeInventory()];
	}

}
