package com.halotroop.tconstruct.block.general;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class ToolStationBlock extends Block {
	public ToolStationBlock() {
		super(Block.Settings.copy(Blocks.CRAFTING_TABLE));
	}
}
