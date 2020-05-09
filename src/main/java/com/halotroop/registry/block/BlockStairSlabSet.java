/*
 * Copyright 2020 halotroop, SlimeKnights
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.halotroop.registry.block;
import com.halotroop.tconstruct.block.StairsBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.Item;

public class BlockStairSlabSet {
	public final BlockItemPair block, stair, slab;
	
	/*
	 * Inputs: base name for block, slab, and stairs, BLock Settings for all three, and Item settings for all three
	 * Output: A set of 3 sets of items and blocks corresponding to the block, stairs, and slab
	 * Output: Also dunamic blockstates and models for each
	 */
	public BlockStairSlabSet(String baseName, Block.Settings blockSettings, Item.Settings itemSettings) {
		this.block = new BlockItemPair(baseName, new Block(blockSettings), itemSettings);
		this.stair = new BlockItemPair(baseName + "_stairs", new StairsBlock(baseName, this.block.block.getDefaultState(), blockSettings), itemSettings);
		this.slab = new BlockItemPair(baseName + "_slab", new SlabBlock(blockSettings), itemSettings);
	}
}
