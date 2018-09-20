package terriblethings.mobs;

import enderpower.Blocks.EnderpowerBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBreaker extends EntityMob{

	public EntityBreaker(World world) {
		super(world);
	}
	private int breaktime;
	
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(64.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
		this.setSize(0.5F, 1.8F);
	}
	
	protected boolean isAIEnabled()
    {
        return false;
    }

	public boolean hitByEntity(Entity par1Entity)
    {
		this.breaktime = 0;
        return false;
    }
	 public void onLivingUpdate()
	    {
	        this.updateArmSwingProgress();
	        float f = this.getBrightness(1.0F);

	        if (f > 0.5F)
	        {
	            this.entityAge += 2;
	        }

	        super.onLivingUpdate();
	        this.BreakAbility();
	    }
	private void BreakAbility(){
		   int x=(int) this.posX;
	        int y=(int) this.posY;
	        int z=(int) this.posZ;
	        
	        int x2 =(int) this.prevPosX;
	        int y2 =(int) this.prevPosY;
	        int z2 =(int) this.prevPosZ;
	        
	        if(x == x2 && y == y2 && z == z2){
	        	this.breaktime += 1;
	        }
	        if(this.breaktime >= 100){
	        this.breaktime = 0;
	        if(this.rotationYaw <= 45 && this.rotationYaw >= -45){
	        	if(this.breakableblocks(x - 0, y, z)){
	        	this.worldObj.setBlock(x - 0, y, z, Blocks.air);
	        }
	        	if(this.breakableblocks(x - 0, y, z + 1)){
		        	this.worldObj.setBlock(x - 0, y, z + 1, Blocks.air);
		        }
	        	if(this.breakableblocks(x - 0, y + 1, z + 1)){
		        	this.worldObj.setBlock(x - 0, y + 1, z + 1, Blocks.air);
		        }
	        }
	        if(this.rotationYaw >= 135 && this.rotationYaw <= 225 || this.rotationYaw <= -135 && this.rotationYaw >= -225){
	        	if(this.breakableblocks(x - 0, y, z - 1)){
		        	this.worldObj.setBlock(x - 0, y, z - 1, Blocks.air);
		        }
	        	if(this.breakableblocks(x - 0, y + 1, z - 1)){
		        	this.worldObj.setBlock(x - 0, y + 1, z - 1, Blocks.air);
	        	}
	        	
		        }
	        if(this.rotationYaw >= 225 && this.rotationYaw <= 315 || this.rotationYaw <= -225 && this.rotationYaw >= -315){
	        	if(this.breakableblocks(x - 1, y, z)){
		        	this.worldObj.setBlock(x - 1, y,z, Blocks.air);
		        }
	        	if(this.breakableblocks(x - 1, y + 1,z)){
		        	this.worldObj.setBlock(x - 1, y + 1, z, Blocks.air);
		        }
	        }
	        	if(this.rotationYaw >= 45 && this.rotationYaw <= 135 || this.rotationYaw <= -45 && this.rotationYaw >= -135){
	        	if(this.breakableblocks(x +1, y, z)){
		        	this.worldObj.setBlock(x+1, y,z, Blocks.air);
		        }
	        	if(this.breakableblocks(x+1, y + 1,z)){
		        	this.worldObj.setBlock(x+1, y + 1, z, Blocks.air);
		        }
	        	
	        	if(this.rotationPitch >= 1){
	        		if(this.breakableblocks(x, y-1, z)){
	        			this.worldObj.setBlock(x, y-1, z, Blocks.air);
	        		}
	        	}
	        	}
	        }
	        
	        
	        
	}
	/*
	 ** the blocks the breaker can't break
	 */
	public boolean breakableblocks(int x, int y, int z){
		if(this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.cursedgrass && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.sieblock && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.siedacaciaplanks && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.siedbirchplanks && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.siedbrick && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.siedchiseledsandstone && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.siedcobblestone && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.sieddarkoakplanks && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.siedjungleplanks && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.siedoakplanks && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.siedsandstone && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.siedsmoothsandstone && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.siedspruceplanks && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.siedstone && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.siedstonebricks && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.sielamp && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.sielamp2 && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.sieobsidian && this.worldObj.getBlock(x, y, z) != EnderpowerBlocks.sieore && this.worldObj.getBlock(x, y, z) != Blocks.bedrock && this.worldObj.getBlock(x, y, z) != Blocks.command_block && this.worldObj.getBlock(x, y, z) != Blocks.diamond_block && this.worldObj.getBlock(x, y, z) != Blocks.diamond_ore && this.worldObj.getBlock(x, y, z) != Blocks.dragon_egg && this.worldObj.getBlock(x, y, z) != Blocks.emerald_block && this.worldObj.getBlock(x, y, z) != Blocks.enchanting_table && this.worldObj.getBlock(x, y, z) != Blocks.end_portal && this.worldObj.getBlock(x, y, z) != Blocks.end_portal_frame && this.worldObj.getBlock(x, y, z) != Blocks.ender_chest && this.worldObj.getBlock(x, y, z) != Blocks.gold_block && this.worldObj.getBlock(x, y, z) != Blocks.iron_bars && this.worldObj.getBlock(x, y, z) != Blocks.iron_block && this.worldObj.getBlock(x, y, z) != Blocks.iron_door && this.worldObj.getBlock(x, y, z) != Blocks.obsidian && this.worldObj.getBlock(x, y, z) != Blocks.portal){
			return true;
		}
		else return false;
		
	}

	

}
