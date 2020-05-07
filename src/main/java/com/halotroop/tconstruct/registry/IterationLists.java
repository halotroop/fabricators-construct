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

import net.minecraft.util.Util;

import java.util.Arrays;
import java.util.HashSet;

@Deprecated
class IterationLists {
	final static String[] VANILLA_METALS = new String[] {"iron", "gold"};
	final static String[] VANILLA_GEMS = new String[] {"diamond", "emerald"};
	// iron, gold, diamond, emerald
	final static String[] VANILLA_TOOL_MATERIALS = combine(VANILLA_METALS, VANILLA_GEMS);
	// leather, and all vanilla tool materials
	final static String[] VANILLA_ARMOR_MATERIALS = add("leather", VANILLA_TOOL_MATERIALS);
	final static String[] VANILLA_WOOD_TYPES = {"acacia", "oak", "birch", "dark_oak", "jungle"};
	
	final static String[] TC_METALS = new String[] {"cobalt", "ardite", "manyullyn", "knightslime", "alubrass", "pigiron"};
	final static String[] TC_GEMS = new String[] {};
	
	
	final static String[] TC_GENERIC_MATERIALS = add("silky_jewel", combine(TC_METALS, TC_GEMS));
	
	final static String[] TOOL_MATERIALS = combine(
			TC_GENERIC_MATERIALS,
			VANILLA_TOOL_MATERIALS
	);
	final static String[] ARMOR_MATERIALS = combine(
			TC_GENERIC_MATERIALS,
			VANILLA_ARMOR_MATERIALS
	);
	static final String[] WOOD_TYPES = combine(
			VANILLA_WOOD_TYPES
	);
	
	private static String[] combine(String[]... arrays) {
		return Util.make(new HashSet<String>(), self -> {
			for (String[] array : arrays) {
				if (array.length != 0)
					self.addAll(Arrays.asList(array.clone()));
			}
		}).toArray(new String[0]);
	}
	
	private static String[] add(String entry, String[] array) {return combine(new String[] {entry}, array);}
}
