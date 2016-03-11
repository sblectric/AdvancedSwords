package com.advancedswords.integration;

import com.advancedswords.integration.thaumcraft.ThaumcraftIntegration;
import com.advancedswords.ref.Log;

import net.minecraftforge.fml.common.Loader;

public class ASModIntegration {
	
	/** Mods that need integration in the pre-init phase */
	public static void preInit() {
	}
	
	/** Mods that need integration in the init phase */
	public static void onInit() {
	}
	
	/** Mods that need integration in the post-init phase */
	public static void postInit() {
		// Thaumcraft
		if(Loader.isModLoaded("Thaumcraft")) {
			ThaumcraftIntegration.mainRegistry();
			Log.logger.info("Thaumcraft integration complete.");
		} else {
			Log.logger.info("Thaumcraft not found, skipping integration.");
		}
	}

}
