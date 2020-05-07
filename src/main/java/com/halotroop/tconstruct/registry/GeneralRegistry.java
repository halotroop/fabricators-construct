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

import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.block.general.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.List;

@Deprecated
public class GeneralRegistry {
	static void registerAllGeneralBlocks() {
		
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
			Block block = registerBlock(name + "_block", new Block(Block.Settings.copy(Blocks.DIAMOND_BLOCK)));
			registerGeneralItem(name + "block", new BlockItem(block, new Item.Settings().group(TConstruct.GENERAL_TAB)) {
				@Override
				public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
					tooltip.add(new TranslatableText("block.tconstruct.metal.tooltip"));
				}
			});
		}
	}
	
	static void registerAllGeneralItems() {
		for (String material : IterationLists.TC_GEMS) {
			registerGeneralItem(material, new Item(new Item.Settings()
					.group(TConstruct.GENERAL_TAB)));
		}
		for (String material : IterationLists.TC_METALS) {
			for (String type : new String[] {"nugget", "ingot"}) {
				if (Registry.ITEM.get(new Identifier("c", material + type)).equals(Items.AIR)) {
					registerGeneralItem(material + "_" + type, new Item(new Item.Settings()
							.group(TConstruct.GENERAL_TAB)));
				}
			}
		}
	}
	
	static void registerGeneralBlock(String name, Block entry) {
		registerGeneralItem(name, new BlockItem(
				registerBlock(name, entry),
				new Item.Settings().group(TConstruct.GENERAL_TAB)));
	}
}
