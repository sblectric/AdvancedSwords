package com.advancedswords.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ASConfig {
	
	// config file
	private static Configuration config;
	
	public static void mainRegistry(File f) {
		config = new Configuration(f);
		getConfig();
	}
	
	public static boolean enableEnchantmentUpgrades;
	public static boolean jeiIntegration;
	public static String emeraldSwordBase;
	public static int emeraldSwordDamage;
	
	/** Do it up */
	private static void getConfig() {
		final String OPTIONS = config.CATEGORY_GENERAL;
		
		config.load();
		
		enableEnchantmentUpgrades = config.getBoolean("Enable enchantment upgrades", OPTIONS, true, "");
		jeiIntegration = config.getBoolean("Show Enchantment Upgrade Recipes in JEI", OPTIONS, true, "");
		emeraldSwordBase = config.getString("Base for Advanced Emerald Sword Recipe", OPTIONS, "minecraft:golden_sword", "");
		emeraldSwordDamage = config.getInt("Emerald Sword Attack Damage", OPTIONS, 18, 15, 30, "");
		
		if(config.hasChanged()) config.save();
	}

}
