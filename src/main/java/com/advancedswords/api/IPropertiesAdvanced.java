package com.advancedswords.api;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IPropertiesAdvanced {
	
	/** gets the shorthand name of this item for registering */
	public String getShorthandName();
	
	/** register this item with the renderer */
	@SideOnly(Side.CLIENT)
	public void registerRender(ItemModelMesher mesher);
	
}
