package terriblethings.worldgen;

import cpw.mods.fml.common.registry.GameRegistry;

public class Tworldgen {
	public static void load(){
		GameRegistry.registerWorldGenerator(new TGenerator(), 1);
	}

}
