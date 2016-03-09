package com.advancedswords.items.swords;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.advancedswords.api.ISwordAdvanced;
import com.advancedswords.ref.RefStrings;

import net.minecraft.item.Item.ToolMaterial;
/** Used to implement a basic sword */
public class SwordBasic extends ItemSword implements ISwordAdvanced {

	public SwordBasic(ToolMaterial material) {
		super(material);
	}

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
