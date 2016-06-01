package com.advancedswords.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.advancedswords.creativetabs.ASCreativeTabs;
import com.advancedswords.util.JointList;

/** Item class */
public class ASBlocks {
	
	private static JointList<BlockBasic> blocks;
	
	public static void mainRegistry() {
		blocks = new JointList();
		addBlocks();
		registerBlocks();
	}
	
	// the blocks
	public static BlockBasic advancedStone;
	public static BlockBasic netherStarBlock;
	
	/** Add blocks to the game */
	private static void addBlocks() {
		blocks.join(
			advancedStone = (BlockBasic)new BlockBasic(Material.ROCK, 3, 10).setUnlocalizedName("advancedStone").setCreativeTab(ASCreativeTabs.main),
			netherStarBlock = (BlockBasic)new BlockBasic(Material.ROCK, 6, 50).setUnlocalizedName("netherStarBlock").setCreativeTab(ASCreativeTabs.main)
		);
	}
	
	/** Register the blocks */
	private static void registerBlocks() {
		// iterate through them
		for(BlockBasic block : blocks) {
			GameRegistry.registerBlock(block, block.getShorthandName());
		}
	}
	
	/** Register the renderers */
	@SideOnly(Side.CLIENT)
	public static void registerRendering() {
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
	    
		// iterate through them
		for(BlockBasic block : blocks) {
			block.registerRender(mesher);
		}
	}

}
