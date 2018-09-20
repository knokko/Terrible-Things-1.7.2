package terriblethings.worldgen;

import java.util.Random;

import terriblethings.blocks.Tblocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import enderpower.Blocks.EnderpowerBlocks;

public class TGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case 0:
			generateSurface( world, random, chunkX * 16, chunkZ * 16);
		}

	}

	private void generateSurface(World world, Random random, int x, int z) {
		for (int i = 0; i < 1; i++) { //hoe vaak de ader voorkomt
			int Xcoord = x + random.nextInt(16);
			int Zcoord = z + random.nextInt(16);
			int Ycoord = random.nextInt(255);
			(new WorldGrassMinable(EnderpowerBlocks.cursedgrass, 10)).generate(world, random, Xcoord, Ycoord, Zcoord); //hoe groot de ader is
		}
		for (int i = 0; i < 2; i++) { //hoe vaak de ader voorkomt
			int Xcoord = x + random.nextInt(16);
			int Zcoord = z + random.nextInt(16);
			int Ycoord = random.nextInt(255);
			(new WorldGenMinable(Tblocks.poisongas, 10)).generate(world, random, Xcoord, Ycoord, Zcoord); //hoe groot de ader is
		}
		
		
	}

}
