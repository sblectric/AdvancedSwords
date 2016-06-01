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
import com.advancedswords.config.ASConfig;
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
		OreDictionary.registerOre("skullSkeleton", new ItemStack(Items.SKULL, 1, 0));
		OreDictionary.registerOre("skullSkeleton", new ItemStack(Items.SKULL, 1, 1));
	}
	
	private static void addCraftingRecipes() {
		// blocks
		RecipeHelper.addShapedOreRecipe(new ItemStack(ASBlocks.advancedStone, 1), "IXI","XIX","IXI", 'X',StackHelper.anyStone, 'I',"cobblestone");
		GameRegistry.addRecipe(new ItemStack(ASBlocks.netherStarBlock, 1), "XXX","XXX","XXX", 'X',Items.NETHER_STAR);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.NETHER_STAR, 9), new ItemStack(ASBlocks.netherStarBlock, 1));
		
		// items
		if(ASConfig.enableEnchantmentUpgrades) {
			RecipeHelper.addShapedOreRecipe(new ItemStack(ASItems.sharpnessUpgrade, 1, TIER_1),
					"IXI","XAX","IXI", 'X',Items.FLINT, 'I',Items.PAPER, 'A',Items.IRON_SWORD);
			RecipeHelper.addShapedOreRecipe(new ItemStack(ASItems.smiteUpgrade, 1, TIER_1),
					"IXI","XAX","IXI", 'X',Items.ROTTEN_FLESH, 'I',Items.PAPER, 'A',Items.BONE);
			RecipeHelper.addShapedOreRecipe(new ItemStack(ASItems.spiderUpgrade, 1, TIER_1),
					"IXI","XAX","IXI", 'X',Items.SPIDER_EYE, 'I',Items.PAPER, 'A',Items.STRING);
			RecipeHelper.addShapedOreRecipe(new ItemStack(ASItems.knockbackUpgrade, 1, TIER_1),
					"IXI","XAX","IXI", 'X',Blocks.PISTON, 'I',Items.PAPER, 'A',"blockSlime");
			RecipeHelper.addShapedOreRecipe(new ItemStack(ASItems.fireAspectUpgrade, 1, TIER_1),
					"IXI","XAX","IXI", 'X',Items.FIRE_CHARGE, 'I',Items.PAPER, 'A',"blockCoal");
			RecipeHelper.addShapedOreRecipe(new ItemStack(ASItems.lootingUpgrade, 1, TIER_1),
					"IXI","XAX","IXI", 'X',"ingotGold", 'I',Items.PAPER, 'A',Items.GOLDEN_SWORD);
			RecipeHelper.addShapedOreRecipe(new ItemStack(ASItems.unbreakingUpgrade, 1, TIER_1),
					"IXI","XAX","IXI", 'X',Blocks.OBSIDIAN, 'I',Items.PAPER, 'A',Items.DIAMOND_CHESTPLATE);
			RecipeHelper.addShapedOreRecipe(new ItemStack(ASItems.mendingUpgrade, 1, TIER_1),
					"IXI","XAX","IXI", 'X',Blocks.ANVIL, 'I',Items.PAPER, 'A',Items.CHORUS_FRUIT_POPPED);
			RecipeHelper.addShapedOreRecipe(new ItemStack(ASItems.sharpnessUpgrade, 1, TIER_2),
					"IXI","XAX","IXI", 'X',Items.DIAMOND_SWORD, 'I',Items.PRISMARINE_SHARD, 'A',new ItemStack(ASItems.sharpnessUpgrade, 1, TIER_1));
			RecipeHelper.addShapedOreRecipe(new ItemStack(ASItems.smiteUpgrade, 1, TIER_2),
					"IXI","XAX","IXI", 'X',new ItemStack(Items.SKULL, 1, 2), 'I',"skullSkeleton", 'A',new ItemStack(ASItems.smiteUpgrade, 1, TIER_1));
			RecipeHelper.addShapedOreRecipe(new ItemStack(ASItems.spiderUpgrade, 1, TIER_2),
					"IXI","XAX","IXI", 'X',Items.FERMENTED_SPIDER_EYE, 'I',Blocks.WEB, 'A',new ItemStack(ASItems.spiderUpgrade, 1, TIER_1));
			RecipeHelper.addShapedOreRecipe(new ItemStack(ASItems.knockbackUpgrade, 1, TIER_2),
					"IXI","XAX","IXI", 'X',Blocks.STICKY_PISTON, 'I',"blockSlime", 'A',new ItemStack(ASItems.knockbackUpgrade, 1, TIER_1));
			RecipeHelper.addShapedOreRecipe(new ItemStack(ASItems.fireAspectUpgrade, 1, TIER_2),
					"IXI","XAX","IXI", 'X',Blocks.COAL_BLOCK, 'I',Items.BLAZE_ROD, 'A',new ItemStack(ASItems.fireAspectUpgrade, 1, TIER_1));
			RecipeHelper.addShapedOreRecipe(new ItemStack(ASItems.lootingUpgrade, 1, TIER_2),
					"IXI","XAX","IXI", 'X',"blockGold", 'I',"blockLapis", 'A',new ItemStack(ASItems.lootingUpgrade, 1, TIER_1));
			RecipeHelper.addShapedOreRecipe(new ItemStack(ASItems.unbreakingUpgrade, 1, TIER_2),
					"IXI","XAX","IXI", 'X',Items.GHAST_TEAR, 'I',"blockDiamond", 'A',new ItemStack(ASItems.unbreakingUpgrade, 1, TIER_1));
		}
		
		// swords
		ItemStack emeraldBase = GameRegistry.makeItemStack(ASConfig.emeraldSwordBase, 0, 1, null);
		if(emeraldBase == null) emeraldBase = new ItemStack(Items.GOLDEN_SWORD);
		RecipeHelper.addShapedOreRecipe(new ItemStack(Swords.advancedWoodenSword, 1), "XXX","XIX","XXX", 'X',"logWood", 'I',Items.WOODEN_SWORD);
		RecipeHelper.addShapedOreRecipe(new ItemStack(Swords.advancedStoneSword, 1), "XXX","XIX","XXX", 'X',ASBlocks.advancedStone, 'I',Items.STONE_SWORD);
		RecipeHelper.addShapedOreRecipe(new ItemStack(Swords.advancedIronSword, 1), "XXX","XIX","XXX", 'X',"blockIron", 'I',Items.IRON_SWORD);
		RecipeHelper.addShapedOreRecipe(new ItemStack(Swords.advancedGoldenSword, 1), "XXX","XIX","XXX", 'X',"blockGold", 'I',Items.GOLDEN_SWORD);
		RecipeHelper.addShapedOreRecipe(new ItemStack(Swords.advancedEmeraldSword, 1), "XXX","XIX","XXX", 'X',"blockEmerald", 'I',emeraldBase);
		RecipeHelper.addShapedOreRecipe(new ItemStack(Swords.advancedDiamondSword, 1), "XXX","XIX","XXX", 'X',"blockDiamond", 'I',Items.DIAMOND_SWORD);
		RecipeHelper.addShapedOreRecipe(new ItemStack(Swords.netherStarSword, 1), "X","X","I", 'X',Items.NETHER_STAR, 'I',"stickWood");
		RecipeHelper.addShapedOreRecipe(new ItemStack(Swords.advancedNetherStarSword, 1),
				" B ","ZIZ"," X ", 'X',"blockNetherStar", 'I',Swords.netherStarSword, 'Z',new ItemStack(Items.GOLDEN_APPLE, 1, 1), 'B',Blocks.BEACON);
		
		// upgrades
		if(ASConfig.enableEnchantmentUpgrades) {
			RecipeSorter.register(RefStrings.MODID + ":ItemEnchantmentUpgrade", RecipeItemEnchantmentUpgrade.class, Category.SHAPED, "after:minecraft:shaped");
			for(int i = TIER_1; i < ItemEnchantmentUpgrade.TIER_COUNT; i++) {
				GameRegistry.addRecipe(new RecipeItemEnchantmentUpgrade(new ItemStack(ASItems.sharpnessUpgrade, 1, i)));
				GameRegistry.addRecipe(new RecipeItemEnchantmentUpgrade(new ItemStack(ASItems.smiteUpgrade, 1, i)));
				GameRegistry.addRecipe(new RecipeItemEnchantmentUpgrade(new ItemStack(ASItems.spiderUpgrade, 1, i)));
				GameRegistry.addRecipe(new RecipeItemEnchantmentUpgrade(new ItemStack(ASItems.knockbackUpgrade, 1, i)));
				GameRegistry.addRecipe(new RecipeItemEnchantmentUpgrade(new ItemStack(ASItems.fireAspectUpgrade, 1, i)));
				GameRegistry.addRecipe(new RecipeItemEnchantmentUpgrade(new ItemStack(ASItems.lootingUpgrade, 1, i)));
				GameRegistry.addRecipe(new RecipeItemEnchantmentUpgrade(new ItemStack(ASItems.unbreakingUpgrade, 1, i)));
				if(i == TIER_1) GameRegistry.addRecipe(new RecipeItemEnchantmentUpgrade(new ItemStack(ASItems.mendingUpgrade, 1, i)));
			}
		}
	
	}

}
