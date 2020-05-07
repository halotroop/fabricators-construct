package com.halotroop.tconstruct.registry.block;
import com.halotroop.tconstruct.block.StairsBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.Item;

public class BlockStairSlabSet {
	public final TConBlock block, stair, slab;
	
	/*
	 * Inputs: base name for block, slab, and stairs, BLock Settings for all three, and Item settings for all three
	 * Output: A set of 3 sets of items and blocks corresponding to the block, stairs, and slab
	 * Output: Also dunamic blockstates and models for each
	 */
	public BlockStairSlabSet(String baseName, Block.Settings blockSettings, Item.Settings itemSettings) {
		this.block = new TConBlock(baseName, new Block(blockSettings), itemSettings);
		this.stair = new TConBlock(baseName + "_stairs", new StairsBlock(baseName, this.block.block.getDefaultState(), blockSettings), itemSettings);
		this.slab = new TConBlock(baseName + "_slab", new SlabBlock(blockSettings), itemSettings);
	}
	
}
