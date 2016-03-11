package com.advancedswords.items.swords.thaumic;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

import org.apache.http.util.EntityUtils;

/** Class for the Blade of the Cyclone */
public class SwordAdvancedElemental extends SwordThaumic {

	public SwordAdvancedElemental(ToolMaterial mat) {
		super(mat);
	}

	/** Become one with the air */
	@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
		if(player.getItemInUseDuration() == 0 && player.onGround) {
			player.motionY = 5; // WHOA!!
			player.isAirBorne = true;
			player.worldObj.playSoundAtEntity((Entity)player, "fireworks.largeBlast", 15.0f, 0.9f + player.worldObj.rand.nextFloat() * 0.2f);
			stack.damageItem(50, player); // 50 damage per use
		}
	}
	
    @Override
    public EnumRarity getRarity(ItemStack blah) {
    	return EnumRarity.RARE;
    }

}
