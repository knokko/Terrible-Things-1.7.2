package terriblethings.main;

import net.minecraft.entity.monster.EntityGhast;
import terriblethings.blocks.Tblocks;
import terriblethings.mobs.EntityBreaker;
import terriblethings.mobs.EntityFirebird;
import terriblethings.mobs.EntityMinotaur;
import terriblethings.mobs.EntityHandler;
import terriblethings.worldgen.Tworldgen;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = R.m, name = R.m ,version = R.v)

public class Main {
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){
		Tblocks.load();
		Tblocks.RegisterItems();
		proxy.RegisterRenderThings();
		
	}
	@SidedProxy(clientSide = "terriblethings.main.ClientProxy", serverSide = "terriblethings.main.ServerProxy")
	public static ServerProxy proxy;
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		Tworldgen.load();
		EntityHandler.registerMinotaur(EntityMinotaur.class, "minotaur");
		EntityHandler.RegisterBreaker(EntityBreaker.class, "breaker");
		EntityHandler.addGhastSpawn(EntityGhast.class, "ghast");
		EntityHandler.registerFirebird(EntityFirebird.class, "firebird");
		
		
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	public static int i;
	public static int k;

}
