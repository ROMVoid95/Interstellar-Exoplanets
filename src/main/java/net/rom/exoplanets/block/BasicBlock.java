package net.rom.exoplanets.block;

import net.minecraft.block.material.Material;
import net.rom.core.block.BlockBaseRO;
import net.rom.exoplanets.tabs.CreativeExoTabs;

public class BasicBlock extends BlockBaseRO {

	public BasicBlock(Material materialIn) {
		super(materialIn);
		setCreativeTab(CreativeExoTabs.DECO_CREATIVE_TABS);
	}

}