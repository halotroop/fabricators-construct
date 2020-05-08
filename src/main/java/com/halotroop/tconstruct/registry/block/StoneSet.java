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
import org.jetbrains.annotations.Nullable;

public class StoneSet {
	public final BlockStairSlabSet smooth, cobbled, cracked, fancy, square, road, triangle, small, tile, inscribed;
	
	public StoneSet(@Nullable String prefix, String baseName, Block.Settings blockSettings, Item.Settings itemSettings) {
		String fixedPrefix = (prefix != null) ? prefix+"_" : "";
		String fixedSuffix = "_" + baseName.toLowerCase();

		smooth = new BlockStairSlabSet(fixedPrefix + "smooth" + fixedSuffix, blockSettings, itemSettings);
		cobbled = new BlockStairSlabSet(fixedPrefix + "cobbled" + fixedSuffix, blockSettings, itemSettings);
		cracked = new BlockStairSlabSet(fixedPrefix + "cracked" + fixedSuffix, blockSettings, itemSettings);
		fancy = new BlockStairSlabSet(fixedPrefix + "fancy" + fixedSuffix, blockSettings, itemSettings);
		square = new BlockStairSlabSet(fixedPrefix + "square" + fixedSuffix, blockSettings, itemSettings);
		road = new BlockStairSlabSet(fixedPrefix + "road" + fixedSuffix, blockSettings, itemSettings);
		triangle = new BlockStairSlabSet(fixedPrefix + "triangle" + fixedSuffix, blockSettings, itemSettings);
		small = new BlockStairSlabSet(fixedPrefix + "small" + fixedSuffix, blockSettings, itemSettings);
		tile = new BlockStairSlabSet(fixedPrefix + "tile" + fixedSuffix, blockSettings, itemSettings);
		inscribed = new BlockStairSlabSet(fixedPrefix + "inscribed" + fixedSuffix, blockSettings, itemSettings);
	}
}
