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
		registerSmelteryItem(name, new BlockItem(
				registerBlock(name, entry),
				new Item.Settings().group(TConstruct.SMELTERY_TAB)));
	}
}
