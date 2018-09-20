package terriblethings.projectiles;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFire extends EntityThrowable {
	private double targetX;
	private double targetY;
	private double targetZ;
	
	private double Xmotion;
	private double Ymotion;
	private double Zmotion;
	
	private double Xmotion1;
	private double Ymotion1;
	private double Zmotion1;
	
	private double multiplier;
	
	private List hitEntities;

	public EntityFire(World world, double targetX, double targetY, double targetZ, double Xpos, double Ypos, double Zpos) {
		super(world);
		this.targetX = targetX;
		this.targetY = targetY;
		this.targetZ = targetZ;
		this.posX = Xpos;
		this.posY = Ypos;
		this.posZ = Zpos;
		
		this.Xmotion1 = this.targetX - this.posX;
		this.Ymotion1 = this.targetY - this.posY;
		this.Zmotion1 = this.targetZ - this.posZ;
		
		this.Xmotion = this.Xmotion1 * 0.01;
		this.Ymotion = this.Ymotion1 * 0.01;
		this.Zmotion = this.Zmotion1 * 0.01;
		
		this.setSize(0.3F, 0.3F);
		
		
		
	}

	@Override
	protected void entityInit() {
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		targetX = nbt.getDouble("targetX");
		targetY = nbt.getDouble("targetY");
		targetZ = nbt.getDouble("targetZ");
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setDouble("targetX", targetX);
		nbt.setDouble("targetY", targetY);
		nbt.setDouble("targetZ", targetZ);
	}
	public void onUpdate(){
		moveToTarget();
		fireAura();
		playerHit();
		hitBlock();
		super.onEntityUpdate();
		
		
	}

	private void hitBlock() {
		if(this.isEntityInsideOpaqueBlock()){
			this.setDead();
			if(this.worldObj.isAirBlock((int)posX,(int) posY + 1,(int) posZ)){
				this.worldObj.setBlock((int)posX,(int) posY + 1,(int) posZ, Blocks.fire);
			}
		}
	}

	public void playerHit() {
		EntityPlayer player = this.worldObj.getClosestPlayerToEntity(this, 2);
		if(player != null){
			player.attackEntityFrom(DamageSource.inFire, 5.0F);
			
		}
		
	}

	private void fireAura() {
		this.worldObj.spawnParticle("flame", posX, posY, posZ, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 1, posY + 0, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 0, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 0, posZ - 1, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 1, posY - 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY - 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY - 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 1, posY + 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 1, posY + 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		
		
		this.worldObj.spawnParticle("flame", posX + 0, posY + 0, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 0, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 0, posZ - 1, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 0, posY - 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY - 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY - 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX + 0, posY + 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX + 0, posY + 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		
		
		this.worldObj.spawnParticle("flame", posX - 1, posY + 0, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 0, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 0, posZ - 1, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 1, posY - 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY - 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY - 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		
		this.worldObj.spawnParticle("flame", posX - 1, posY + 1, posZ + 0, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 1, posZ + 1, 0.0D, 0.0D, 0.0D);
		this.worldObj.spawnParticle("flame", posX - 1, posY + 1, posZ - 1, 0.0D, 0.0D, 0.0D);
		
	}

	private void moveToTarget() {
		this.Xmotion *= 1.01;
		this.Ymotion *= 1.01;
		this.Zmotion *= 1.01;
		
		this.posX += this.Xmotion;
		this.posY += this.Ymotion;
		this.posZ += this.Zmotion;
		
		if(this.ticksExisted >= 1200){
			this.setDead();
		}
		
	}

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if(mop.entityHit != null){
			mop.entityHit.attackEntityFrom(DamageSource.inFire, 5.0F);
		}
		this.setDead();
		System.out.println("omImpact is called succesfully");
		
	}
	
	

}
