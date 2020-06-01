/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2020, ROMVoid95 <rom.readonlydev@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package net.rom.exoplanets.astronomy.trappist1.c;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Predicate;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.rom.exoplanets.astronomy.trappist1.TrappistBlocks;

public class BiomeDecoratorTrappist1C extends BiomeDecoratorSpace {

	private World currentWorld;

	private WorldGenerator dirtGen, gravelGen;

	public BiomeDecoratorTrappist1C() {

		dirtGen = new WorldGenMinableMeta(TrappistBlocks.SharedTerrain.HOT_GROUND_2, 30, 0, true, TrappistBlocks.TrappistC.T1C_TOP, 0);
		gravelGen = new WorldGenMinableMeta(TrappistBlocks.SharedTerrain.HOT_GROUND_1, 30, 0, true, TrappistBlocks.TrappistC.T1C_TOP, 0);
	}

	@Override
	protected void setCurrentWorld(World world) {
		this.currentWorld = world;
	}

	@Override
	protected World getCurrentWorld() {
		return this.currentWorld;
	}

	@Override
	protected void decorate() {

		this.generateOre(40, dirtGen, 5, 180);
		this.generateOre(60, gravelGen, 5, 180);
	}

	static class TrappistStonePredicate implements Predicate<IBlockState> {
		List<IBlockState> states = new ArrayList<IBlockState>();

		private TrappistStonePredicate() {
			states.add(TrappistBlocks.SharedTerrain.HOT_GROUND_1.getDefaultState());
		}

		public boolean apply(IBlockState state) {
			if (state != null && states.contains(state)) {
				return true;
			}
			return false;
		}
	}

}
