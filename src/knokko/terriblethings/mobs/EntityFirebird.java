package terriblethings.mobs;

import terriblethings.projectiles.EntityFire;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityFirebird extends EntityFlying{
	/**
	 * the timer says what the entity has to do
	 */
	private int timer;

	public EntityFirebird(World world) {
		super(world);
		setSize(8.0F, 4.0F);
		this.isImmuneToFire = true;
		this.fireResistance = 20000000;
	}
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(128.0D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
		
	}
	
	public void onUpdate(){
		super.onUpdate();
		this.timer();
		this.difficulty();
	}
	private void difficulty() {
		if(this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL){
			this.setDead();
		}
	}
	/**
	 * I use this timer to say what the mob has to do.
	 */
	public void timer(){
		timer += 1;
		if(timer >= 100){
		}
		if(timer >= 1000 && timer <= 1200){
			this.moveToPlayer();
		}
		if(timer >= 1400 && timer <= 1800){
			this.fireBreath();
		}
	}
	public void fireBreath() {
		this.worldObj.spawnEntityInWorld(new EntityFire(worldObj, worldObj.getClosestPlayerToEntity(this, 200).posX, worldObj.getClosestPlayerToEntity(this, 200).posY, worldObj.getClosestPlayerToEntity(this, 200).posZ,  posX, posY, posZ));
	}
	/**
	 * This method moves the firebird to the closest player.
	 */
	
	public void moveToPlayer(){
		if(this.worldObj.getClosestPlayerToEntity(this, 200) != null){
			if(this.worldObj.getClosestPlayerToEntity(this, 200).posX >= this.posX + 0.1){
				this.moveEntity(0.1, 0, 0);
			}
			if(this.worldObj.getClosestPlayerToEntity(this, 200).posX <= this.posX - 0.1){
				this.moveEntity(-0.1, 0, 0);
			}
			if(this.worldObj.getClosestPlayerToEntity(this, 200).posY <= this.posY -0.1){
				this.moveEntity(0, -0.1, 0);
			}
			if(this.worldObj.getClosestPlayerToEntity(this, 200).posY >= this.posY + 0.1){
				this.moveEntity(0, 0.1, 0);
			}
			if(this.worldObj.getClosestPlayerToEntity(this, 200).posZ >= this.posZ + 0.1){
				this.moveEntity(0, 0, 0.1);
			}
			if(this.worldObj.getClosestPlayerToEntity(this, 200).posZ <= this.posZ - 0.1){
				this.moveEntity(0, 0, -0.1);
			}
		}
	}

	public boolean attackEntityFrom(DamageSource damage, float a){
		super.attackEntityFrom(damage, a);
		timer -= 50;
		fireAura();
		fireBreath();
		return false;
		
	}
	public void testfireAura(){
		EntityPlayer player = this.worldObj.getClosestPlayerToEntity(this, 5);
		if(player != null){
			player.attackEntityFrom(DamageSource.inFire, 5.0F);
		}
		
		this.worldObj.spawnParticle("flame", posX, posY + 1, posZ, posX, posY + 1, posZ);
		this.worldObj.spawnParticle("flame", posX, posY + 2, posZ, posX, posY + 2, posZ);
		this.worldObj.spawnParticle("flame", posX, posY + 3, posZ, posX, posY + 3, posZ);
		this.worldObj.spawnParticle("flame", posX, posY - 1, posZ, posX, posY - 1, posZ);
		this.worldObj.spawnParticle("flame", posX, posY - 2, posZ, posX, posY - 2, posZ);
		this.worldObj.spawnParticle("flame", posX, posY - 2, posZ, posX, posY - 2, posZ);
		
		this.worldObj.spawnParticle("flame", posX + 1, posY + 1, posZ, posX + 1, posY + 1, posZ);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 2, posZ, posX + 2, posY + 2, posZ);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 1, posZ, posX - 1, posY + 1, posZ);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 2, posZ, posX - 1, posY + 2, posZ);
	}
	public void fireAura(){
		this.worldObj.spawnParticle("flame", posX + 0, posY + 0, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 0, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 0, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 0, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 0, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 0, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 0, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 0, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 0, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 0, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 0, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 1, posY + 0, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 0, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 0, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 0, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 0, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 0, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 0, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 0, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 0, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 0, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 0, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 2, posY + 0, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 0, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 0, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 0, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 0, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 0, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 0, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 0, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 0, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 0, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 0, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 3, posY + 0, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 0, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 0, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 0, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 0, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 0, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 0, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 0, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 0, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 0, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 0, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 4, posY + 0, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 0, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 0, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 0, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 0, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 0, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 0, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 0, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 0, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 0, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 0, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 5, posY + 0, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 0, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 0, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 0, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 0, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 0, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 0, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 0, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 0, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 0, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 0, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 1, posY + 0, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 0, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 0, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 0, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 0, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 0, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 0, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 0, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 0, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 0, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 0, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 2, posY + 0, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 0, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 0, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 0, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 0, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 0, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 0, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 0, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 0, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 0, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 0, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 3, posY + 0, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 0, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 0, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 0, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 0, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 0, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 0, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 0, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 0, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 0, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 0, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 4, posY + 0, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 0, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 0, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 0, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 0, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 0, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 0, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 0, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 0, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 0, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 0, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 5, posY + 0, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 0, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 0, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 0, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 0, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 0, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 0, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 0, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 0, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 0, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 0, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		
		
		this.worldObj.spawnParticle("flame", posX + 0, posY + 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 1, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 1, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 1, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 1, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 1, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 1, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 1, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 1, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 1, posY + 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 1, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 1, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 1, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 1, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 1, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 1, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 1, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 1, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 2, posY + 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 1, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 1, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 1, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 1, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 1, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 1, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 1, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 1, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 3, posY + 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 1, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 1, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 1, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 1, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 1, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 1, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 1, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 1, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 4, posY + 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 1, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 1, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 1, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 1, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 1, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 1, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 1, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 1, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 5, posY + 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 1, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 1, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 1, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 1, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 1, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 1, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 1, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 1, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 1, posY + 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 1, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 1, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 1, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 1, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 1, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 1, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 1, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 1, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 2, posY + 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 1, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 1, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 1, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 1, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 1, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 1, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 1, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 1, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 3, posY + 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 1, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 1, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 1, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 1, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 1, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 1, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 1, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 1, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 4, posY + 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 1, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 1, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 1, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 1, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 1, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 1, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 1, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 1, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 5, posY + 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 1, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 1, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 1, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 1, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 1, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 1, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 1, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 1, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		
		
		this.worldObj.spawnParticle("flame", posX + 0, posY + 3, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 3, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 3, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 3, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 3, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 3, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 3, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 3, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 3, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 3, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 3, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 1, posY + 3, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 3, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 3, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 3, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 3, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 3, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 3, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 3, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 3, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 3, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 3, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 2, posY + 3, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 3, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 3, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 3, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 3, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 3, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 3, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 3, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 3, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 3, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 3, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 3, posY + 3, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 3, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 3, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 3, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 3, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 3, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 3, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 3, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 3, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 3, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 3, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 4, posY + 3, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 3, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 3, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 3, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 3, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 3, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 3, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 3, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 3, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 3, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 3, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 5, posY + 3, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 3, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 3, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 3, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 3, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 3, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 3, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 3, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 3, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 3, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 3, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 1, posY + 3, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 3, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 3, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 3, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 3, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 3, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 3, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 3, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 3, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 3, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 3, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 2, posY + 3, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 3, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 3, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 3, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 3, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 3, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 3, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 3, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 3, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 3, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 3, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 3, posY + 3, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 3, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 3, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 3, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 3, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 3, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 3, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 3, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 3, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 3, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 3, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 4, posY + 3, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 3, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 3, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 3, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 3, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 3, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 3, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 3, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 3, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 3, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 3, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 5, posY + 3, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 3, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 3, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 3, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 3, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 3, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 3, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 3, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 3, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 3, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 3, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		
		
		this.worldObj.spawnParticle("flame", posX + 0, posY + 2, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 2, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 2, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 2, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 2, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 2, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 2, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 2, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 2, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 2, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 2, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 1, posY + 2, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 2, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 2, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 2, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 2, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 2, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 2, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 2, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 2, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 2, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 2, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 2, posY + 2, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 2, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 2, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 2, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 2, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 2, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 2, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 2, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 2, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 2, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 2, posY + 2, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 3, posY + 2, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 2, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 2, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 2, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 2, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 2, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 2, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 2, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 2, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 2, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 3, posY + 2, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 4, posY + 2, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 2, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 2, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 2, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 2, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 2, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 2, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 2, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 2, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 2, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 4, posY + 2, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 5, posY + 2, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 2, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 2, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 2, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 2, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 2, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 2, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 2, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 2, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 2, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 5, posY + 2, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 1, posY + 2, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 2, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 2, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 2, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 2, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 2, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 2, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 2, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 2, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 2, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 2, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 2, posY + 2, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 2, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 2, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 2, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 2, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 2, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 2, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 2, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 2, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 2, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 2, posY + 2, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 3, posY + 2, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 2, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 2, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 2, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 2, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 2, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 2, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 2, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 2, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 2, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 3, posY + 2, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 4, posY + 2, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 2, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 2, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 2, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 2, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 2, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 2, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 2, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 2, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 2, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 4, posY + 2, posZ - 5, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 5, posY + 2, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 2, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 2, posZ + 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 2, posZ + 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 2, posZ + 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 2, posZ + 5, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 2, posZ - 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 2, posZ - 2, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 2, posZ - 3, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 2, posZ - 4, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 5, posY + 2, posZ - 5, 0.0D, 0.0D, 0.0D);
		
	}

}
