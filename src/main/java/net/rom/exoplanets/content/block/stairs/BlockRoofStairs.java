package net.rom.exoplanets.content.block.stairs;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockRoofStairs extends BlockStairs {

	public BlockRoofStairs() {
		super(Blocks.IRON_BLOCK.getDefaultState());
		this.setHardness(2F);
		this.setResistance(5F);
		this.setLightOpacity(1);
		this.setHarvestLevel("axe", 1);
		this.setSoundType(SoundType.METAL);
	}

	@Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
		return state.isOpaqueCube();
	}

}
