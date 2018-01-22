package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;

public class GenLayerKepler22bBiomes extends GenLayer {
	protected Biome[] commonBiomes = { Kepler22bBiomes.kepler22bPlains, Kepler22bBiomes.kepler22bBlueForest, Kepler22bBiomes.kepler22bPurpleForest, Kepler22bBiomes.kepler22bRedForest,
			Kepler22bBiomes.kepler22bYellowForest, Kepler22bBiomes.kepler22bRedDesert, Kepler22bBiomes.kepler22bWasteLands, Kepler22bBiomes.kepler22bCandyLand };

	protected Biome[] rareBiomes = { Kepler22bBiomes.kepler22bBlueForest };

	public GenLayerKepler22bBiomes(long seed, GenLayer genlayer) {
		super(seed);
		this.parent = genlayer;
	}

	public GenLayerKepler22bBiomes(long seed) {
		super(seed);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);

		for (int dz = 0; dz < depth; dz++) {
			for (int dx = 0; dx < width; dx++) {
				this.initChunkSeed(dx + x, dz + z);

				if (this.nextInt(15) == 0) {
					dest[dx + dz * width] = Biome.getIdForBiome(this.rareBiomes[this.nextInt(this.rareBiomes.length)]);
				} else {
					dest[dx + dz * width] = Biome.getIdForBiome(this.commonBiomes[this.nextInt(this.commonBiomes.length)]);
				}
			}
		}
		return dest;
	}
}
