package com.advancedswords.items.swords;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.advancedswords.blocks.ASBlocks;
import com.advancedswords.creativetabs.ASCreativeTabs;
import com.advancedswords.util.JointList;
import com.advancedswords.util.StackHelper;

import net.minecraft.item.Item.ToolMaterial;
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
	
	private static void setupMaterials() {
		advancedWood = EnumHelper.addToolMaterial("advancedWood", 1, 236, 8.0F, 1.75F, 8);
		(advancedStone = EnumHelper.addToolMaterial("advancedStone", 2, 524, 12.0F, 3.0F, 3)).setRepairItem(new ItemStack(ASBlocks.advancedStone));
		(advancedIron = EnumHelper.addToolMaterial("advancedIron", 3, 2250, 18.0F, 10.0F, 7)).setRepairItem(new ItemStack(Blocks.iron_block));
		(advancedGold = EnumHelper.addToolMaterial("advancedGold", 2, 1561, 8.0F, 6.0F, 15)).setRepairItem(new ItemStack(Blocks.gold_block));
		(advancedEmerald = EnumHelper.addToolMaterial("advancedEmerald", 4, 3122, 12.0F, 14.0F, 22)).setRepairItem(new ItemStack(Blocks.emerald_block));
		(advancedDiamond = EnumHelper.addToolMaterial("advancedDiamond", 4, 6144, 24.0F, 20.0F, 5)).setRepairItem(new ItemStack(Blocks.diamond_block));
		(netherStar = EnumHelper.addToolMaterial("netherStar", 4, 9366, 20.0F, 26.0F, 1)).setRepairItem(new ItemStack(Items.nether_star));
		(advancedNetherStar = EnumHelper.addToolMaterial("advancedNetherStar", 5, 16384, 30.0F, 56.0F, 0)).setRepairItem(new ItemStack(ASBlocks.netherStarBlock));
	}
	
	/** Define new swords here */
	private static void addSwords() {
		swords.join(
			advancedWoodenSword = (SwordCustomRepair)new SwordCustomRepair(advancedWood).setUnlocalizedName("advancedWoodenSword").setCreativeTab(ASCreativeTabs.main),
			advancedStoneSword = (SwordBasic)new SwordBasic(advancedStone).setUnlocalizedName("advancedStoneSword").setCreativeTab(ASCreativeTabs.main),
			advancedIronSword = (SwordBasic)new SwordBasic(advancedIron).setUnlocalizedName("advancedIronSword").setCreativeTab(ASCreativeTabs.main),
			advancedGoldenSword = (SwordBasic)new SwordBasic(advancedGold).setUnlocalizedName("advancedGoldenSword").setCreativeTab(ASCreativeTabs.main),
			advancedEmeraldSword = (SwordBasic)new SwordBasic(advancedEmerald).setUnlocalizedName("advancedEmeraldSword").setCreativeTab(ASCreativeTabs.main),
			advancedDiamondSword = (SwordBasic)new SwordBasic(advancedDiamond).setUnlocalizedName("advancedDiamondSword").setCreativeTab(ASCreativeTabs.main),
			netherStarSword = (SwordBasic)new SwordShiny(netherStar).setUnlocalizedName("netherStarSword").setCreativeTab(ASCreativeTabs.main),
			advancedNetherStarSword = (SwordBasic)new SwordShiny(advancedNetherStar).setUnlocalizedName("advancedNetherStarSword").setCreativeTab(ASCreativeTabs.main)
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
		advancedWoodenSword.addRepairOres("logWood");
	}

}
