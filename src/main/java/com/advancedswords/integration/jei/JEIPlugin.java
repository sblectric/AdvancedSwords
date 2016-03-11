package com.advancedswords.integration.jei;

import mezz.jei.api.IItemRegistry;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.IRecipeRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.advancedswords.items.swords.Swords;
import com.advancedswords.ref.Log;

@mezz.jei.api.JEIPlugin
public class JEIPlugin implements IModPlugin {
	
	public static IJeiHelpers jeiHelpers;
	
	/** Store the helpers */
	@Override
	public void onJeiHelpersAvailable(IJeiHelpers helpers) {
		jeiHelpers = helpers;
	}
	
	/** Register this mod plugin with the mod registry. */
	@Override
	public void register(IModRegistry reg) {
		
		// hide the addon swords when the mods aren't available
		for(Item item : Swords.getRegisteredSwords()) {
			if(item.getCreativeTab() == null) jeiHelpers.getItemBlacklist().addItemToBlacklist(new ItemStack(item));
		}
		
		// add the recipes
		reg.addRecipes(RecipeEnchantmentUpgradeJEI.getRecipeList());
		
		// register the categories
		reg.addRecipeCategories(
				new EnchantmentUpgradeCategory(jeiHelpers.getGuiHelper())
		);
		
		// and the handlers
		reg.addRecipeHandlers(
				new EnchantmentUpgradeHandler()
		);
		
		Log.logger.info("JEI integration complete.");
	}

	@Override
	public void onItemRegistryAvailable(IItemRegistry arg0) {}

	@Override
	public void onRecipeRegistryAvailable(IRecipeRegistry arg0) {}

	@Override
	public void onRuntimeAvailable(IJeiRuntime arg0) {}

}
