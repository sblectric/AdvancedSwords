package com.advancedswords.items;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.advancedswords.api.IItemAdvanced;
import com.advancedswords.ref.RefStrings;

/** Used to implement a basic item */
public class ItemBasic extends Item implements IItemAdvanced {

	@Override
	public String getShorthandName() {
		return this.getUnlocalizedName().substring(5);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerRender(ItemModelMesher mesher) {
		mesher.register(this, 0, new ModelResourceLocation(RefStrings.MODID + ":" + this.getShorthandName(), "inventory"));
	}

}
