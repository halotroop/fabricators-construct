/*
 * MIT License
 *
 * Copyright (c) 2020 SlimeKnights, halotroop2288
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.halotroop.tconstruct.registry.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.function.Supplier;

public class WoodenSet {
	public final BlockItemPair acacia, birch, dark_oak, oak, jungle;
	public final Block[] allBlocks;
	public final Item[] allBlockItems;
	
	public WoodenSet(String name, Supplier<Block> block, Item.Settings itemSettings) {
		acacia = new BlockItemPair("acacia_" + name, block.get(), itemSettings);
		birch = new BlockItemPair("birch_" + name, block.get(), itemSettings);
		dark_oak = new BlockItemPair("dark_oak_" + name, block.get(), itemSettings);
		oak = new BlockItemPair("oak_" + name, block.get(), itemSettings);
		jungle = new BlockItemPair("jungle_" + name, block.get(), itemSettings);
		// Note: For 1.16+ also add nether woods!
		
		// TODO: Terrestria woods
		allBlocks = new Block[] {acacia.block, birch.block, jungle.block, dark_oak.block, oak.block, jungle.block};
		allBlockItems = new Item[] {acacia.blockItem, birch.blockItem, jungle.blockItem, dark_oak.blockItem,
				oak.blockItem, jungle.blockItem};
	}
}
