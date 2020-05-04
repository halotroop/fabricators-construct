package com.halotroop.tconstruct.block.general;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ToolForgeBlock extends Block {
	public ToolForgeBlock(String material) {
		super(Block.Settings.copy(Registry.BLOCK.get(new Identifier(material))));
	}
}
