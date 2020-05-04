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

package com.halotroop.tconstruct.registry;

import static com.halotroop.tconstruct.registry.EverythingRegistry.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class GadgetsRegistry {
	static void registerAllGadgetsBlocks() {
		// --Gadgets Blocks-- \\
		
		// GADGETS MANY MANY BROWN BLOCKS
		for (String block_type : block_types) {
			
			String nullOrUnderscore = block_type.equals("") ? "" : ("_"); // places an _ in between if not null
			
			// "DRIED BRICKS" + SLABS + STAIRS
			registerGadgetsBlock("dried_brick" + (block_type.equals("") ? "s" : block_type),
					new Block(Block.Settings.copy(Blocks.STONE_BRICKS))
			);
			// "DRIED CLAY( BRICKS)" + SLABS + STAIRS
			for (String brown_thing : new String[] {"dried_clay", "dried_clay_bricks"}) {
				registerGadgetsBlock(brown_thing + nullOrUnderscore + block_type,
						new Block(Block.Settings.copy(Blocks.STONE_BRICKS))
				);
			}
			// "BROWNSTONE" + SLABS + STAIRS
			for (String stone_style : stone_styles) {
				registerSmelteryBlock(
						// Ex: cobbled_seared_stone_stairs, smooth_seared_stone
						(stone_style.equals("") ? "" : (stone_style + "_")) // Places an _ after if not null
								+ "brownstone"
								+ (block_type.equals("") ? "" : ("_" + block_type)), // Places an _ between if not null
						new Block(Block.Settings.copy(Blocks.STONE))
				);
			}
			// "BROWNSTONE BRICK(S)" + SLABS + STAIRS
			for (String stone_brick_style : stone_brick_styles) {
				registerSmelteryBlock(
						// Ex: inscribed_brownstone_slab, cracked_brownstone
						stone_brick_style + (stone_brick_style.equals("") ? "" : "_") // Places an _ after if not null
								+ "brownstone_brick" +
								(block_type.equals("") ? "s" : "_" ) + block_type,  // Places an s between if null or an _ if not
						new Block(Block.Settings.copy(Blocks.STONE_BRICKS)));
			}
		}
	}
	
	static void registerAllGadgetsItems() {
	}
}
