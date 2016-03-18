package com.advancedswords.items.swords.thaumic;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import thaumcraft.api.items.IWarpingGear;

/** The advanced void sword */
@Optional.Interface(iface = "thaumcraft.api.items.IWarpingGear", modid = "thaumcraft")
public class SwordAdvancedVoid extends SwordThaumic implements IWarpingGear {

	protected int warping;

	public SwordAdvancedVoid(ToolMaterial mat) {
		super(mat);
		this.warping = 2;
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
		super.onUpdate(stack, world, entity, p_77663_4_, p_77663_5_);
		if (stack.isItemDamaged() && entity != null && entity.ticksExisted % 20 == 0 && entity instanceof EntityLivingBase) {
			stack.damageItem(-1, (EntityLivingBase)entity);
		}
	}

	@Override
	public boolean hitEntity(ItemStack is, EntityLivingBase target, EntityLivingBase hitter) {
		if (!(target.worldObj.isRemote || target instanceof EntityPlayer && hitter instanceof EntityPlayer && !MinecraftServer.getServer().isPVPEnabled())) {
			try {
				applySappingEffect(target);
			}
			catch (Exception e) {
				// empty catch block
			}
		}
		return super.hitEntity(is, target, hitter);
	}
	
	/** The sapping effect */
	public void applySappingEffect(EntityLivingBase target) {
		target.addPotionEffect(new PotionEffect(Potion.weakness.getId(), 60));
		target.addPotionEffect(new PotionEffect(Potion.hunger.getId(), 120));
	}
	
    @Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
    	String sap = getSapping();
        if(sap != null) list.add(sap);
        super.addInformation(stack, player, list, par4);
    }
    
    /** Gets the sapping effect name */
    public String getSapping() {
    	return EnumChatFormatting.GOLD + StatCollector.translateToLocal("enchantment.special.sapgreat");
    }

	@Override
	public int getWarp(ItemStack itemstack, EntityPlayer player) {
		return warping;
	}

}
