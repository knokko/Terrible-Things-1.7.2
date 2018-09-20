package terriblethings.blocks;

import terriblethings.main.R;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class Tblocks {
	public static Block poisongas;
	
	
	
	public static void RegisterItems(){
		GameRegistry.registerBlock(poisongas, "poisongas");
	}
	
	public static void load(){
		poisongas = new PoisonGas().setBlockName("poisongas").setBlockTextureName("minecraft:netherrack");
	}

}
