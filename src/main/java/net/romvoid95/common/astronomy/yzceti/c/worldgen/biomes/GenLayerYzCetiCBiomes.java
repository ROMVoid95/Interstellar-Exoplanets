package net.romvoid95.common.astronomy.yzceti.c.worldgen.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeAdaptive;

import micdoodle8.mods.miccore.IntCache;
import net.romvoid95.core.initialization.Planets;

public class GenLayerYzCetiCBiomes extends GenLayer {
	public static final Biome[] biomes = BiomeAdaptive.getBiomesListFor(Planets.yzcetic).toArray(new Biome[0]);

	public GenLayerYzCetiCBiomes(long l, GenLayer parent) {
		super(l);
		this.parent = parent;
	}

	public GenLayerYzCetiCBiomes(long l) {
		super(l);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);

		for (int k = 0; k < depth; ++k) {
			for (int i = 0; i < width; ++i) {
				initChunkSeed(x + i, z + k);
				dest[i + k * width] = Biome.getIdForBiome(biomes[nextInt(biomes.length)]);
			}
		}

		return dest;
	}
}