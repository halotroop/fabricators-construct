package com.halotroop.tconstruct.block.general;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class PartBuilderBlock extends Block {
	public PartBuilderBlock() {
		super(Block.Settings.copy(Blocks.CRAFTING_TABLE));
	}
}
