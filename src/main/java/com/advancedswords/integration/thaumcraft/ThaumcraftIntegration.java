package com.advancedswords.integration.thaumcraft;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

import com.advancedswords.items.swords.Swords;
import com.advancedswords.ref.RefStrings;
import com.advancedswords.util.JointList;

/** Class for Thaumcraft integration */
public class ThaumcraftIntegration {
	
	/** Is the integration enabled? */
	public static boolean enabled = false;
	/** Holds the list of registered researches */
	public static JointList<ResearchItem> researches;
	
	// recipes
	public static ShapedArcaneRecipe recipeAdvancedThaumiumSword;
	public static InfusionRecipe recipeAdvancedElementalSword;
	public static ShapedArcaneRecipe recipeAdvancedVoidSword;
	public static InfusionRecipe recipeAdvancedCrimsonSword;
	public static InfusionRecipe recipeAdvancedPrimalSword;
	
	// research keys and IDs
	public static final String CATEGORY = RefStrings.MODID.toUpperCase();
	public static final String KEY_ADV_THAUM = "ADVTHAUMSWORD";
	public static final String PAGE_ADV_THAUM = RefStrings.MODID + ".research." + KEY_ADV_THAUM;
	public static final String KEY_ADV_ELEM = "ADVELEMSWORD";
	public static final String PAGE_ADV_ELEM = RefStrings.MODID + ".research." + KEY_ADV_ELEM;
	public static final String KEY_ADV_VOID = "ADVVOIDSWORD";
	public static final String PAGE_ADV_VOID = RefStrings.MODID + ".research." + KEY_ADV_VOID;
	public static final String KEY_ADV_CRIMSON = "ADVCRIMSONSWORD";
	public static final String PAGE_ADV_CRIMSON = RefStrings.MODID + ".research." + KEY_ADV_CRIMSON;
	public static final String KEY_ADV_PRIMAL = "ADVPRIMALSWORD";
	public static final String PAGE_ADV_PRIMAL = RefStrings.MODID + ".research." + KEY_ADV_PRIMAL;
	
	/** Main Thaumcraft integration registry */
	public static void mainRegistry() {
		researches = new JointList();
		addRecipes();
		addResearches();
		enabled = true; // successfully loaded
	}

	/** Add the recipes */
	private static void addRecipes() {
		recipeAdvancedThaumiumSword = ThaumcraftApi.addArcaneCraftingRecipe(KEY_ADV_THAUM, new ItemStack(Swords.advancedThaumiumSword), 
				new AspectList().add(Aspect.EARTH, 150).add(Aspect.ORDER, 150).add(Aspect.ENTROPY, 150), 
				"XXX","XIX","XXX", 'I',ItemsTC.thaumiumSword, 'X',new ItemStack(BlocksTC.metal, 1, 0));
		recipeAdvancedElementalSword = ThaumcraftApi.addInfusionCraftingRecipe(KEY_ADV_ELEM, new ItemStack(Swords.advancedElementalSword), 8, 
				new AspectList().add(Aspect.AIR, 64).add(Aspect.AVERSION, 24).add(Aspect.MOTION, 24).add(Aspect.FLIGHT, 24), 
				new ItemStack(ItemsTC.elementalSword), new Object[]{
				new ItemStack(BlocksTC.metal, 1, 0), new ItemStack(BlocksTC.crystalAir), new ItemStack(Blocks.diamond_block), new ItemStack(BlocksTC.crystalAir), 
				new ItemStack(BlocksTC.metal, 1, 0), new ItemStack(BlocksTC.crystalAir), new ItemStack(Blocks.diamond_block), new ItemStack(BlocksTC.crystalAir)});
		recipeAdvancedVoidSword = ThaumcraftApi.addArcaneCraftingRecipe(KEY_ADV_VOID, new ItemStack(Swords.advancedVoidSword), 
				new AspectList().add(Aspect.EARTH, 350).add(Aspect.AIR, 350).add(Aspect.ENTROPY, 350), 
				"XXX","XIX","XXX", 'I',ItemsTC.voidSword, 'X',new ItemStack(BlocksTC.metal, 1, 1));
		recipeAdvancedCrimsonSword = ThaumcraftApi.addInfusionCraftingRecipe(KEY_ADV_CRIMSON, new ItemStack(Swords.advancedCrimsonSword), 10, 
				new AspectList().add(Aspect.FIRE, 96).add(Aspect.AVERSION, 64).add(Aspect.VOID, 64).add(Aspect.FLUX, 64), 
				new ItemStack(ItemsTC.crimsonBlade), new Object[]{
				new ItemStack(ItemsTC.crimsonRites), new ItemStack(BlocksTC.metal, 1, 1), new ItemStack(BlocksTC.crystalTaint), 
				new ItemStack(BlocksTC.metal, 1, 1), new ItemStack(BlocksTC.crystalTaint), new ItemStack(BlocksTC.metal, 1, 1)});
		recipeAdvancedPrimalSword = ThaumcraftApi.addInfusionCraftingRecipe(KEY_ADV_PRIMAL, new ItemStack(Swords.advancedPrimalSword), 12, 
				new AspectList().add(Aspect.AVERSION, 128).add(Aspect.FLUX, 96).add(Aspect.VOID, 64).add(Aspect.DEATH, 64), 
				new ItemStack(ItemsTC.primalCrusher), new Object[]{
				new ItemStack(Items.nether_star), new ItemStack(BlocksTC.metal, 1, 1), new ItemStack(Items.skull, 1, 1), new ItemStack(ItemsTC.primordialPearl),
				new ItemStack(BlocksTC.metal, 1, 1), new ItemStack(ItemsTC.primordialPearl), new ItemStack(Items.skull, 1, 1), new ItemStack(BlocksTC.metal, 1, 1)});
	}

	/** Add the researches */
	private static void addResearches() {
		// add the research category
		ResearchCategories.registerCategory(CATEGORY, "METALLURGY", new ResourceLocation(RefStrings.MODID, "textures/research/tabIcon.png"), 
				new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_1.jpg"), 
				new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_over.png"));
		
		// add the researches
		ResearchItem r;
		
		// Thaumium sword
		r = new ResearchItem(KEY_ADV_THAUM, CATEGORY, 
			new AspectList().add(Aspect.AVERSION, 2).add(Aspect.METAL, 2), 0, 0, 2, new ItemStack(Swords.advancedThaumiumSword));
		r.setParents("METALLURGY");
		r.setPages(new ResearchPage(PAGE_ADV_THAUM), new ResearchPage(recipeAdvancedThaumiumSword));
		researches.add(r);
		
		// Elemental sword
		r = new ResearchItem(KEY_ADV_ELEM, CATEGORY, 
			new AspectList().add(Aspect.AVERSION, 2).add(Aspect.METAL, 2), -2, -2, 2, new ItemStack(Swords.advancedElementalSword));
		r.setParents(KEY_ADV_THAUM, "ELEMENTALTOOLS");
		r.setPages(new ResearchPage(PAGE_ADV_ELEM), new ResearchPage(recipeAdvancedElementalSword));
		researches.add(r);
		
		// Voidmetal sword
		r = new ResearchItem(KEY_ADV_VOID, CATEGORY, 
			new AspectList().add(Aspect.AVERSION, 2).add(Aspect.METAL, 2), 2, -2, 3, new ItemStack(Swords.advancedVoidSword));
		r.setParents(KEY_ADV_THAUM, "VOIDMETAL");
		r.setPages(new ResearchPage(PAGE_ADV_VOID), new ResearchPage(recipeAdvancedVoidSword));
		researches.add(r);
		
		// Crimson sword
		r = new ResearchItem(KEY_ADV_CRIMSON, CATEGORY, 
			new AspectList().add(Aspect.AVERSION, 2).add(Aspect.METAL, 2), 4, 0, 3, new ItemStack(Swords.advancedCrimsonSword));
		r.setParents(KEY_ADV_VOID, "CRIMSON");
		r.setPages(new ResearchPage(PAGE_ADV_CRIMSON), new ResearchPage(recipeAdvancedCrimsonSword));
		researches.add(r);
		
		// Primal sword
		r = new ResearchItem(KEY_ADV_PRIMAL, CATEGORY, 
				new AspectList().add(Aspect.AVERSION, 2).add(Aspect.METAL, 2), 4, 2, 3, new ItemStack(Swords.advancedPrimalSword));
		r.setParents(KEY_ADV_CRIMSON, "PRIMALCRUSHER");
		r.setPages(new ResearchPage(PAGE_ADV_PRIMAL), new ResearchPage(recipeAdvancedPrimalSword));
		researches.add(r);
		
		// add the researches to the tab
		for(ResearchItem i : researches) {
			ResearchCategories.addResearch(i);
		}
	
	}

}
