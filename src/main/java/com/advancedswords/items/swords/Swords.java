package com.advancedswords.items.swords;

import java.util.List;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.blocks.BlocksTC;

import com.advancedswords.blocks.ASBlocks;
import com.advancedswords.creativetabs.ASCreativeTabs;
import com.advancedswords.integration.ASModIntegration;
import com.advancedswords.integration.thaumcraft.ThaumcraftIntegration;
import com.advancedswords.items.swords.thaumic.SwordAdvancedCrimson;
import com.advancedswords.items.swords.thaumic.SwordAdvancedElemental;
import com.advancedswords.items.swords.thaumic.SwordAdvancedPrimal;
import com.advancedswords.items.swords.thaumic.SwordAdvancedVoid;
import com.advancedswords.items.swords.thaumic.SwordThaumic;
import com.advancedswords.util.JointList;

/** Swords are defined here! */
public class Swords {
	
	// sword list
	private static JointList<SwordBasic> swords;
	
	public static void mainRegistry() {
		swords = new JointList();
		setupMaterials();
		addSwords();
		registerSwords();
	}
	
	/** Get the list of registered swords */
	public static List<SwordBasic> getRegisteredSwords() {
		return swords;
	}
	
	// swords and sword materials
	public static SwordCustomRepair advancedWoodenSword;
	public static SwordBasic advancedStoneSword;
	public static SwordBasic advancedIronSword;
	public static SwordBasic advancedGoldenSword;
	public static SwordBasic advancedEmeraldSword;
	public static SwordBasic advancedDiamondSword;
	public static SwordBasic netherStarSword;
	public static SwordBasic advancedNetherStarSword;
	public static ToolMaterial advancedWood;
	public static ToolMaterial advancedStone;
	public static ToolMaterial advancedIron;
	public static ToolMaterial advancedGold;
	public static ToolMaterial advancedEmerald;
	public static ToolMaterial advancedDiamond;
	public static ToolMaterial netherStar;
	public static ToolMaterial advancedNetherStar;
	
	// thaumic stuff
	public static SwordThaumic advancedThaumiumSword;
	public static SwordThaumic advancedElementalSword;
	public static SwordThaumic advancedVoidSword;
	public static SwordThaumic advancedCrimsonSword;
	public static SwordThaumic advancedPrimalSword;
	public static ToolMaterial advancedThaumium;
	public static ToolMaterial advancedElemental;
	public static ToolMaterial advancedVoid;
	public static ToolMaterial advancedCrimson;
	public static ToolMaterial advancedPrimal;
	
	private static void setupMaterials() {
		// regular materials
		advancedWood = EnumHelper.addToolMaterial("advancedWood", 1, 236, 8.0F, 1.75F, 8);
		(advancedStone = EnumHelper.addToolMaterial("advancedStone", 2, 524, 12.0F, 3.0F, 3)).setRepairItem(new ItemStack(ASBlocks.advancedStone));
		(advancedIron = EnumHelper.addToolMaterial("advancedIron", 3, 2250, 18.0F, 10.0F, 7)).setRepairItem(new ItemStack(Blocks.iron_block));
		(advancedGold = EnumHelper.addToolMaterial("advancedGold", 2, 1561, 8.0F, 6.0F, 15)).setRepairItem(new ItemStack(Blocks.gold_block));
		(advancedEmerald = EnumHelper.addToolMaterial("advancedEmerald", 4, 3122, 12.0F, 14.0F, 22)).setRepairItem(new ItemStack(Blocks.emerald_block));
		(advancedDiamond = EnumHelper.addToolMaterial("advancedDiamond", 4, 8192, 24.0F, 20.0F, 5)).setRepairItem(new ItemStack(Blocks.diamond_block));
		(netherStar = EnumHelper.addToolMaterial("netherStar", 4, 9366, 20.0F, 26.0F, 1)).setRepairItem(new ItemStack(Items.nether_star));
		(advancedNetherStar = EnumHelper.addToolMaterial("advancedNetherStar", 5, 16384, 30.0F, 56.0F, 0)).setRepairItem(new ItemStack(ASBlocks.netherStarBlock));
		
		// thaumic materials
		advancedThaumium = EnumHelper.addToolMaterial("advancedThaumium", 3, 2250, 18.0F, 11.0F, 12);
		advancedElemental = EnumHelper.addToolMaterial("advancedElemental", 4, 6144, 24.0F, 22.0F, 8);
		advancedVoid = EnumHelper.addToolMaterial("advancedVoid", 4, 524, 18.0F, 24.0F, 12);
		advancedCrimson = EnumHelper.addToolMaterial("advancedCrimson", 4, 668, 20.0F, 30.0F, 12);
		advancedPrimal = EnumHelper.addToolMaterial("advancedPrimal", 5, 937, 22.0F, 36.0F, 12);
		if(ASModIntegration.thaumcraftExists) {
			advancedThaumium.setRepairItem(new ItemStack(BlocksTC.metal, 1, 0));
			advancedVoid.setRepairItem(new ItemStack(BlocksTC.metal, 1, 1));
		}
	}
	
	/** Define new swords here */
	private static void addSwords() {
		swords.join(
			// regular swords
			advancedWoodenSword = (SwordCustomRepair)new SwordCustomRepair(advancedWood).setUnlocalizedName("advancedWoodenSword").setCreativeTab(ASCreativeTabs.main),
			advancedStoneSword = (SwordBasic)new SwordBasic(advancedStone).setUnlocalizedName("advancedStoneSword").setCreativeTab(ASCreativeTabs.main),
			advancedIronSword = (SwordBasic)new SwordBasic(advancedIron).setUnlocalizedName("advancedIronSword").setCreativeTab(ASCreativeTabs.main),
			advancedGoldenSword = (SwordBasic)new SwordBasic(advancedGold).setUnlocalizedName("advancedGoldenSword").setCreativeTab(ASCreativeTabs.main),
			advancedEmeraldSword = (SwordBasic)new SwordBasic(advancedEmerald).setUnlocalizedName("advancedEmeraldSword").setCreativeTab(ASCreativeTabs.main),
			advancedDiamondSword = (SwordBasic)new SwordBasic(advancedDiamond).setUnlocalizedName("advancedDiamondSword").setCreativeTab(ASCreativeTabs.main),
			netherStarSword = (SwordBasic)new SwordShiny(netherStar).setUnlocalizedName("netherStarSword").setCreativeTab(ASCreativeTabs.main),
			advancedNetherStarSword = (SwordBasic)new SwordShiny(advancedNetherStar).setUnlocalizedName("advancedNetherStarSword").setCreativeTab(ASCreativeTabs.main),
			
			// upgraded thaumcraft swords
			advancedThaumiumSword = (SwordThaumic)new SwordThaumic(advancedThaumium).setUnlocalizedName("advancedThaumiumSword"),
			advancedElementalSword = (SwordThaumic)new SwordAdvancedElemental(advancedElemental).setUnlocalizedName("advancedElementalSword"),
			advancedVoidSword = (SwordThaumic)new SwordAdvancedVoid(advancedVoid).setUnlocalizedName("advancedVoidSword"),
			advancedCrimsonSword = (SwordThaumic)new SwordAdvancedCrimson(advancedCrimson).setUnlocalizedName("advancedCrimsonSword"),
			advancedPrimalSword = (SwordThaumic)new SwordAdvancedPrimal(advancedPrimal).setUnlocalizedName("advancedPrimalSword")
		);
	}
	
	/** Register the swords with the game registry */
	private static void registerSwords() {
		// iterate through them
		for(SwordBasic sword : swords) {
			GameRegistry.registerItem(sword, sword.getShorthandName());
		}
	}
	
	/** Register the swords with the item model mesher */
	@SideOnly(Side.CLIENT)
	public static void registerRendering(ItemModelMesher mesher) {
		// iterate through them
		for(SwordBasic sword : swords) {
			sword.registerRender(mesher);
		}
	}
	
	/** Finish up sword information */
	public static void finalizeSwords() {
		// wooden sword repairability
		advancedWoodenSword.addRepairOres("logWood");
		
		// thaumic sword creative tabs
		for(SwordBasic sword : swords) {
			if(sword instanceof SwordThaumic) ((SwordThaumic)sword).setCreativeTab(ASCreativeTabs.main);
		}
	}

}
