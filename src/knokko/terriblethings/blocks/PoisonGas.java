package terriblethings.blocks;

import java.util.Random;

import terriblethings.main.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class PoisonGas extends Block {
	private int cooldown;
	

	protected PoisonGas() {
		super(Material.air);
		this.setTickRandomly(true);
		this.setResistance(150.0F);
		this.setCreativeTab(CreativeTabs.tabMisc);
		
	}
	protected boolean needsRandomTick;
	public boolean isOpaqueCube()
    {
        return false;
    }
	public boolean isSolid(){
		return false;
	}
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
		if(this.cooldown == 0){
        entity.attackEntityFrom(DamageSource.drown, 1.0F);
        this.cooldown = 1;
		}
		if(this.cooldown >= 1){
			this.cooldown = this.cooldown + 1;
		}
		if(this.cooldown >= 30){
			this.cooldown = 0;
		}
    }
	@Override
	public void updateTick(World world, int x, int y, int z, Random random){
		Main.i = Main.i - 1;
		Main.k = Main.k + 1;
		if(Main.k >= 50){
			Main.k = 0;
		}
		
		if(world.getBlock(x, y + 1, z) == Blocks.air){
			world.setBlock(x, y + 1, z, Tblocks.poisongas);
		}
		if(world.getBlock(x, y + 1, z) != Blocks.air){
			if(world.getBlock(x + 1, y, z) == Blocks.air){
				world.setBlock(x + 1, y, z, Tblocks.poisongas);
				
			}
			if(world.getBlock(x - 1, y, z) == Blocks.air){
				world.setBlock(x - 1, y, z, Tblocks.poisongas);
				
			}
			if(world.getBlock(x, y, z + 1) == Blocks.air){
				world.setBlock(x, y, z + 1, Tblocks.poisongas);
				
			}
			if(world.getBlock(x, y, z - 1) == Blocks.air){
				world.setBlock(x, y, z - 1, Tblocks.poisongas);
				
			}
		}
		
	}
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return null;
    }
	

}
