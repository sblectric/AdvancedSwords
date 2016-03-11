package com.advancedswords.items.swords.thaumic;

import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

/** The advanced crimson blade */
public class SwordAdvancedCrimson extends SwordAdvancedVoid {

	public SwordAdvancedCrimson(ToolMaterial mat) {
		super(mat);
		this.warping = 3;
	}
	
	@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
		World world = player.worldObj;
		if(player.ticksExisted % 5 == 0) { // once per 1/4 second
			for(Entity e : world.loadedEntityList) {
				if(e instanceof EntityMob && e.getDistanceToEntity(player) <= 16 && !e.isBurning()) {
					int level = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, stack);
					e.setFire(5 + level); // 5 seconds, plus 2 seconds per Fire Aspect level
					stack.damageItem(5, player); // takes 5 damage per entity lit
				}
			}
		}
	}
	
	@Override
	public void applySappingEffect(EntityLivingBase target) {
		target.addPotionEffect(new PotionEffect(Potion.weakness.getId(), 90, 1));
		target.addPotionEffect(new PotionEffect(Potion.hunger.getId(), 180, 1));
	}
	
    @Override
	public String getSapping() {
    	return EnumChatFormatting.GOLD + StatCollector.translateToLocal("enchantment.special.sapmost");
    }
    
    @Override
    public EnumRarity getRarity(ItemStack blah) {
    	return EnumRarity.EPIC;
    }

}
