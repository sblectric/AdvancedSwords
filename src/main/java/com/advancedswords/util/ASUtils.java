package com.advancedswords.util;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ASUtils {
	
    /** An unlimited type of areItemStacksEqual, but cannot be null */
    public static boolean areItemStacksEqualandValid(ItemStack... stacks) {
    	ItemStack comp = stacks[0];
    	if(comp == null) return false;
    	for(int n = 1; n < stacks.length; n++) {
    		if(!ItemStack.areItemStacksEqual(stacks[n], comp)) return false;
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
