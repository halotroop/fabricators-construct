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

import com.halotroop.tconstruct.block.general.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.item.Item;

public class GeneralRegistry {
	static void registerAllGeneralBlocks() {
		// GROUT
		registerGeneralBlock("grout", new FallingBlock(Block.Settings.copy(Blocks.CLAY)));
		
		// STATIONS
		registerGeneralBlock("crafting_station", new CraftingStationBlock());
		registerGeneralBlock("tool_station", new ToolStationBlock());
		
		// PART BUILDER/STENCIL TABLE
		for (String wood_type : IterationLists.WOOD_TYPES) {
			registerGeneralBlock(wood_type.toLowerCase() + "_part_builder", new PartBuilderBlock());
			registerGeneralBlock(wood_type.toLowerCase() + "_stencil_table", new StencilTableBlock());
		}
		// TOOL FORGE
		for (String metal : IterationLists.TC_METALS) {
			registerGeneralBlock(metal.toLowerCase() + "_tool_forge", new ToolForgeBlock(metal));
		}
		// MATERIAL STORAGE BLOCKS
		for (String name : IterationLists.TC_GENERIC_MATERIALS) {
			registerGeneralBlock(name + "_block", new Block(Block.Settings.copy(Blocks.DIAMOND_BLOCK)));
		}
	}
	
	static void registerAllGeneralItems() {
		for (String material : IterationLists.TC_GEMS) {
			registerGeneralItem(material, new Item(new Item.Settings()
					.group(ItemGroupsRegistry.GENERAL.group)));
		}
		for (String material : IterationLists.TC_METALS) {
			for (String type : new String[] {"nugget", "ingot"})
				registerGeneralItem(material + "_" + type, new Item(new Item.Settings()
						.group(ItemGroupsRegistry.GENERAL.group)));
		}
	}
}
