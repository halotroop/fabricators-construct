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
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class EverythingRegistry {
	private static Map<String, Block> BLOCKS = new HashMap<>();
	private static Map<String, Item> ITEMS = new HashMap<>();
	
	static Map<String, Block> GENERAL_BLOCKS = new HashMap<>();
	static Map<String, Block> SMELTERY_BLOCKS = new HashMap<>();
	static Map<String, Block> GADGETS_BLOCKS = new HashMap<>();
	
	static Map<String, Item> GENERAL_ITEMS = new HashMap<>();
	static Map<String, Item> SMELTERY_ITEMS = new HashMap<>();
	static Map<String, Item> GADGETS_ITEMS = new HashMap<>();
	
	static final String[] // Useful for stone-type and other fancy blocks
			block_types = new String[] {"", "slab", "stairs"},
			stone_styles = new String[] {"", "cobbled", "smooth"},
			stone_brick_styles = new String[] {
					"", "cracked", "fancy", "square","road","triangle", "small", "tile", "inscribed"
	};
	
	public static void registerAll() {
		SoundRegistry.registerAll();
		
		GeneralRegistry.registerAllGeneralBlocks();
		GeneralRegistry.registerAllGeneralItems();
		
		SmelteryRegistry.registerAllSmelteryBlocks();
		SmelteryRegistry.registerAllSmelteryItems();
		
		GadgetsRegistry.registerAllGadgetsBlocks();
		GadgetsRegistry.registerAllGadgetsItems();
		
		BLOCKS.putAll(GENERAL_BLOCKS);
		BLOCKS.putAll(SMELTERY_BLOCKS);
		BLOCKS.putAll(GADGETS_BLOCKS);
		
		ITEMS.putAll(GENERAL_ITEMS);
		ITEMS.putAll(SMELTERY_ITEMS);
		ITEMS.putAll(GADGETS_ITEMS);
		
		EntityRegistry.registerAllBlockEntityTypes();
		EntityRegistry.registerAllEntityTypes();
	}
	
	// ---End of registration--- \\
	
	static Block registerBlock (String name, Block entry, Map<String, Block> list) {
		final Identifier id = TConstruct.makeID(name.toLowerCase());
		if (Registry.BLOCK.get(id).equals(Blocks.AIR)) {
			TConstruct.logger.debug("REGISTERING " + name);
			Block block = Registry.register(Registry.BLOCK, id, entry);
			list.put(name, block);
			return block;
		}
		else return null;
	}
	
	public static Block getBlock(String name) {
		return BLOCKS.get(name);
	}
	
	// ~~~~~ ITEMS ~~~~~ \\
	
	static void registerGeneralItem(String name, Item entry) {
		registerItem(name, entry, GENERAL_ITEMS);
	}
	
	static void registerSmelteryItem(String name, Item entry) {
		registerItem(name, entry, SMELTERY_ITEMS);
	}
	
	static void registerGadgetsItem(String name, Item entry) {
		registerItem(name, entry, GADGETS_ITEMS);
	}
	
	private static void registerItem(String name, Item entry, Map<String, Item> list) {
		final Identifier id = TConstruct.makeID(name.toLowerCase());
		if (Registry.ITEM.get(id).equals(Items.AIR)) {
			Item item = Registry.register(Registry.ITEM, id, entry);
			list.put(name, item);
		}
	}
	
	public static Item getItem(String name) {
		return ITEMS.get(name);
	}
}
