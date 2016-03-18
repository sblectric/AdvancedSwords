package com.advancedswords.util;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameData;

public class ASUtils {
	
	/** Cached for speed */
	private static JointList<ItemStack> swordCache = new JointList();
	
	/** Gets all the registered swords in FML */
	public static List<ItemStack> getAllSwords() {
		if(swordCache.isEmpty()) {
			JointList<ItemStack> list = new JointList();
			Iterable<Item> allItems = GameData.getItemRegistry().typeSafeIterable();
			for(Item i : allItems) {
				if(i instanceof ItemSword) {
					list.add(new ItemStack(i));
				}
			}
			swordCache.join(list);
		}
		return swordCache;
	}
	
    /** An unlimited type of areItemStacksEqual for crafting recipes (non-amount sensitive, cannot be null) */
    public static boolean areItemStacksEqualForCrafting(ItemStack... stacks) {
    	ItemStack comp = stacks[0];
    	if(comp == null) return false;
    	ItemStack comp1 = comp.copy(); comp1.stackSize = 1;
    	for(int n = 1; n < stacks.length; n++) {
    		if(stacks[n] == null) return false;
    		ItemStack comp2 = stacks[n].copy(); comp2.stackSize = 1;
    		if(!ItemStack.areItemStacksEqual(comp1, comp2)) return false;
    	}
    	return true;
    }
    
    /** Does a given list of ItemStacks contain comp? Not amount sensitive! */
    public static boolean doesItemStackListContain(List<ItemStack> list, ItemStack comp, boolean remove) {
    	ItemStack comp1 = comp.copy(); comp1.stackSize = 1;
    	for(ItemStack stack : list) {
    		ItemStack stack1 = stack.copy(); stack1.stackSize = 1;
    		if(ItemStack.areItemStacksEqual(stack1, comp1)) {
    			if(remove) list.remove(stack);
    			return true;
    		}
    	}
    	return false;
    }
    
    /** Does a given list of ItemStacks contain comp? Not amount sensitive! */
    public static boolean doesItemStackListContain(List<ItemStack> list, Item comp, boolean remove) {
    	return doesItemStackListContain(list, new ItemStack(comp), remove);
    }
    
    /** Does a given list of ItemStacks contain comp? Not amount sensitive! */
    public static boolean doesItemStackListContain(List<ItemStack> list, Block comp, boolean remove) {
    	return doesItemStackListContain(list, new ItemStack(comp), remove);
    }

}
