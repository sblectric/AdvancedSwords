package com.advancedswords.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.advancedswords.blocks.ASBlocks;
import com.advancedswords.items.ASItems;
import com.advancedswords.items.ItemEnchantmentUpgrade;
import com.advancedswords.items.swords.Swords;
import com.advancedswords.ref.RefStrings;
import com.advancedswords.util.StackHelper;

public class ASCraftingManager {
	
	public static void mainRegistry() {
		addOreDictEntries();
		addCraftingRecipes();
	}
	
	// tiers of upgrades
	public static final int TIER_1 = 0;
	public static final int TIER_2 = 1;
	
	private static void addOreDictEntries() {
		OreDictionary.registerOre("blockNetherStar", new ItemStack(ASBlocks.netherStarBlock));
		OreDictionary.registerOre("skullSkeleton", new ItemStack(Items.skull, 1, 0));
		OreDictionary.registerOre("skullSkeleton", new ItemStack(Items.skull, 1, 1));
	}
	
	private static void addCraftingRecipes() {
		// blocks
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ASBlocks.advancedStone, 1), "IXI","XIX","IXI", 'X',StackHelper.anyStone, 'I',"cobblestone"));
		GameRegistry.addRecipe(new ItemStack(ASBlocks.netherStarBlock, 1), "XXX","XXX","XXX", 'X',Items.nether_star);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.nether_star, 9), new ItemStack(ASBlocks.netherStarBlock, 1));
		
		// items
		GameRegistry.addRecipe(new ItemStack(ASItems.sharpnessUpgrade, 1, TIER_1), "IXI","XAX","IXI", 'X',Items.flint, 'I',Items.paper, 'A',Items.iron_sword);
		GameRegistry.addRecipe(new ItemStack(ASItems.smiteUpgrade, 1, TIER_1), "IXI","XAX","IXI", 'X',Items.rotten_flesh, 'I',Items.paper, 'A',Items.bone);
		GameRegistry.addRecipe(new ItemStack(ASItems.knockbackUpgrade, 1, TIER_1), "IXI","XAX","IXI", 'X',Blocks.piston, 'I',Items.paper, 'A',Blocks.slime_block);
		GameRegistry.addRecipe(new ItemStack(ASItems.fireAspectUpgrade, 1, TIER_1), "IXI","XAX","IXI", 'X',Items.fire_charge, 'I',Items.paper, 'A',Blocks.coal_block);
		GameRegistry.addRecipe(new ItemStack(ASItems.lootingUpgrade, 1, TIER_1), "IXI","XAX","IXI", 'X',Items.gold_ingot, 'I',Items.paper, 'A',Items.golden_sword);
		GameRegistry.addRecipe(new ItemStack(ASItems.unbreakingUpgrade, 1, TIER_1), "IXI","XAX","IXI", 'X',Blocks.obsidian, 'I',Items.paper, 'A',Items.diamond_chestplate);
		GameRegistry.addRecipe(new ItemStack(ASItems.sharpnessUpgrade, 1, TIER_2), "IXI","XAX","IXI", 'X',Items.diamond_sword, 'I',Items.prismarine_shard, 'A',new ItemStack(ASItems.sharpnessUpgrade, 1, TIER_1));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ASItems.smiteUpgrade, 1, TIER_2), "IXI","XAX","IXI", 'X',new ItemStack(Items.skull, 1, 2), 'I',"skullSkeleton", 'A',new ItemStack(ASItems.smiteUpgrade, 1, TIER_1)));
		GameRegistry.addRecipe(new ItemStack(ASItems.knockbackUpgrade, 1, TIER_2), "IXI","XAX","IXI", 'X',Blocks.sticky_piston, 'I',Blocks.slime_block, 'A',new ItemStack(ASItems.knockbackUpgrade, 1, TIER_1));
		GameRegistry.addRecipe(new ItemStack(ASItems.fireAspectUpgrade, 1, TIER_2), "IXI","XAX","IXI", 'X',Blocks.coal_block, 'I',Items.blaze_rod, 'A',new ItemStack(ASItems.fireAspectUpgrade, 1, TIER_1));
		GameRegistry.addRecipe(new ItemStack(ASItems.lootingUpgrade, 1, TIER_2), "IXI","XAX","IXI", 'X',Blocks.gold_block, 'I',Blocks.lapis_block, 'A',new ItemStack(ASItems.lootingUpgrade, 1, TIER_1));
		GameRegistry.addRecipe(new ItemStack(ASItems.unbreakingUpgrade, 1, TIER_2), "IXI","XAX","IXI", 'X',Items.ghast_tear, 'I',Blocks.diamond_block, 'A',new ItemStack(ASItems.unbreakingUpgrade, 1, TIER_1));
		
		// swords
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Swords.advancedWoodenSword, 1), "XXX","XIX","XXX", 'X',"logWood", 'I',Items.wooden_sword));
		GameRegistry.addRecipe(new ItemStack(Swords.advancedStoneSword, 1), "XXX","XIX","XXX", 'X',ASBlocks.advancedStone, 'I',Items.stone_sword);
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Swords.advancedIronSword, 1), "XXX","XIX","XXX", 'X',"blockIron", 'I',Items.iron_sword));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Swords.advancedGoldenSword, 1), "XXX","XIX","XXX", 'X',"blockGold", 'I',Items.golden_sword));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Swords.advancedEmeraldSword, 1), "XXX","XIX","XXX", 'X',"blockEmerald", 'I',Items.golden_sword));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Swords.advancedDiamondSword, 1), "XXX","XIX","XXX", 'X',"blockDiamond", 'I',Items.diamond_sword));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Swords.netherStarSword, 1), "X","X","I", 'X',Items.nether_star, 'I',"stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Swords.advancedNetherStarSword, 1), " B ","ZIZ"," X ", 'X',"blockNetherStar", 'I',Swords.netherStarSword, 'Z',new ItemStack(Items.golden_apple, 1, 1), 'B',Blocks.beacon));
		
		// upgrades
		for(int i = 0; i < ItemEnchantmentUpgrade.TIER_COUNT; i++) {
			GameRegistry.addRecipe(new RecipeItemEnchantmentUpgrade(new ItemStack(ASItems.sharpnessUpgrade, 1, i)));
			GameRegistry.addRecipe(new RecipeItemEnchantmentUpgrade(new ItemStack(ASItems.smiteUpgrade, 1, i)));
			GameRegistry.addRecipe(new RecipeItemEnchantmentUpgrade(new ItemStack(ASItems.knockbackUpgrade, 1, i)));
			GameRegistry.addRecipe(new RecipeItemEnchantmentUpgrade(new ItemStack(ASItems.fireAspectUpgrade, 1, i)));
			GameRegistry.addRecipe(new RecipeItemEnchantmentUpgrade(new ItemStack(ASItems.lootingUpgrade, 1, i)));
			GameRegistry.addRecipe(new RecipeItemEnchantmentUpgrade(new ItemStack(ASItems.unbreakingUpgrade, 1, i)));
		}
		RecipeSorter.register(RefStrings.MODID + ":TieredEnchantmentUpgrade", RecipeTieredEnchantmentUpgrade.class, Category.SHAPELESS, "after:minecraft:shapeless");
	
	}

}
