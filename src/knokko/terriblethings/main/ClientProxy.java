package terriblethings.main;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelDragon;
import terriblethings.mobs.EntityBreaker;
import terriblethings.mobs.EntityFirebird;
import terriblethings.mobs.EntityMinotaur;
import terriblethings.mobs.ModelFirebird;
import terriblethings.mobs.ModelMinotaur;
import terriblethings.mobs.RenderBreaker;
import terriblethings.mobs.RenderFirebird;
import terriblethings.mobs.RenderMinotaur;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy{
	
	public void RegisterRenderThings(){
		RenderingRegistry.registerEntityRenderingHandler(EntityMinotaur.class, new RenderMinotaur(new ModelMinotaur(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBreaker.class, new RenderBreaker(new ModelBiped(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFirebird.class, new RenderFirebird(new ModelFirebird(), 0.3F));


	}

}
