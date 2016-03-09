package com.advancedswords.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.advancedswords.api.IBlockAdvanced;
import com.advancedswords.ref.RefStrings;

/** Used to implement a basic block */
public class BlockBasic extends Block implements IBlockAdvanced {

	public BlockBasic(Material mat, float hardness, float resistance) {
		super(mat);
		this.setHardness(hardness);
		this.setResistance(resistance);
	}

	@Override
	public String getShorthandName() {
		return this.getUnlocalizedName().substring(5);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerRender(ItemModelMesher mesher) {
		mesher.register(Item.getItemFromBlock(this), 0, new ModelResourceLocation(RefStrings.MODID + ":" + this.getShorthandName(), "inventory"));
	}
	
}
