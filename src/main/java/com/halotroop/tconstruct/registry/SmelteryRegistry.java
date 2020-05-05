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

import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.block.smeltery.SmelteryPieceBlock;
import static com.halotroop.tconstruct.registry.EverythingRegistry.*;

import com.halotroop.tconstruct.item.CastItem;
import com.halotroop.tconstruct.item.TinkersToolItem;
import com.halotroop.tconstruct.item.TinkersToolPartItem;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class SmelteryRegistry {
	
	static void registerAllSmelteryBlocks() {
		// --Smeltery Blocks-- \\
		
		// SEARED GLASS
		registerSmelteryBlock("seared_glass", new Block(Block.Settings.copy(Blocks.GLASS)));
		
		for (String block_type : block_types) {
			// "SEARED STONE" + SLABS + STAIRS
			for (String stone_style : stone_styles) {
				registerSmelteryBlock(
						// Ex: cobbled_seared_stone_stairs, smooth_seared_stone
						(stone_style.equals("") ? "" : (stone_style + "_")) // Places an _ after if not null
								+ "seared"
								+ (block_type.equals("") ? "" : ("_" + block_type)) // Places an _ between if not null
								+ "_stone",
						new Block(Block.Settings.copy(Blocks.STONE))
				);
			}
			// "SEARED BRICK(S)" + SLABS + STAIRS
			for (String stone_brick_style : stone_brick_styles) {
				registerSmelteryBlock(
						// Ex: inscribed_brownstone_slab, cracked_brownstone
						stone_brick_style + (stone_brick_style.equals("") ? "" : "_") // Places an _ after if not null
								+ "seared_brick" +
								(block_type.equals("") ? "s" : "_" ) + block_type,  // Places an s between if null or an _ if not
						new Block(Block.Settings.copy(Blocks.STONE_BRICKS)));
			}
		}
		
		// SMELTERY PIECES
		// TODO: Give each of these their own type!
		registerSmelteryBlock("smeltery_controller", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("seared_tank", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("seared_gauge", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("seared_faucet", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("casting_channel", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("casting_table", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("casting_basin", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("seared_drain", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("seared_furnace_controller", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
		registerSmelteryBlock("tinker_tank_controller", new SmelteryPieceBlock(Block.Settings.of(Material.STONE)));
	}
	
	static void registerAllSmelteryItems() {
		registerSmelteryItem("blank_cast", new CastItem(false));
		for (TinkersToolPartItem.ToolPart part : TinkersToolPartItem.ToolPart.values()) {
			String name = part.name().toLowerCase() + "_cast";
			registerSmelteryItem(name, new CastItem(false));
			registerSmelteryItem("clay_" + name, new CastItem(true));
		}
	}
	
	static void registerSmelteryBlock(String name, Block entry) {
		Block block = registerBlock(name, entry, SMELTERY_BLOCKS);
		registerSmelteryItem(name, new BlockItem(block, new Item.Settings().group(TConstruct.SMELTERY_TAB)));
	}
}
