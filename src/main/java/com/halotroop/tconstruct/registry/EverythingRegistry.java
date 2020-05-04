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
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class EverythingRegistry {
	public static Map<String, Block> BLOCKS = new HashMap<>();
	public static Map<String, Item> ITEMS = new HashMap<>();
	
	public static Map<String, Block> GENERAL_BLOCKS = new HashMap<>();
	public static Map<String, Block> SMELTERY_BLOCKS = new HashMap<>();
	public static Map<String, Block> GADGETS_BLOCKS = new HashMap<>();
	
	public static Map<String, Item> GENERAL_ITEMS = new HashMap<>();
	public static Map<String, Item> SMELTERY_ITEMS = new HashMap<>();
	public static Map<String, Item> GADGETS_ITEMS = new HashMap<>();
	
	static final String[] // Useful for stone-type and other fancy blocks
			block_types = new String[] {"", "slab", "stairs"},
			stone_styles = new String[] {"", "cobbled", "smooth"},
			stone_brick_styles = new String[] {
					"", "cracked", "fancy", "square","road","triangle", "small", "tile", "inscribed"
	};
	
	public static void registerAll() {
		SoundRegistry.registerAll();
		ItemGroupsRegistry.init();
		
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
		ItemGroupsRegistry.init();
	}
	
	// ---End of registration--- \\

	static void registerGeneralBlock(String name, Block entry) {
		Block block = registerBlock(name, entry, GENERAL_BLOCKS);
		registerGeneralItem(name, new BlockItem(block, new Item.Settings().group(ItemGroupsRegistry.GENERAL.group)));
	}
	
	static void registerSmelteryBlock(String name, Block entry) {
		Block block = registerBlock(name, entry, SMELTERY_BLOCKS);
		registerSmelteryItem(name, new BlockItem(block, new Item.Settings().group(ItemGroupsRegistry.SMELTERY.group)));
	}
	
	static void registerGadgetsBlock(String name, Block entry) {
		Block block = registerBlock(name, entry, GADGETS_BLOCKS);
		registerGadgetsItem(name, new BlockItem(block, new Item.Settings().group(ItemGroupsRegistry.GADGETS.group)));
	}
	
	private static Block registerBlock (String name, Block entry, Map<String, Block> list) {
		Block block = Registry.register(Registry.BLOCK, new Identifier(TConstruct.MODID, name.toLowerCase()), entry);
		list.put(name, block);
		return block;
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
		Item item = Registry.register(Registry.ITEM, TConstruct.makeID(name), entry);
		list.put(name, item);
	}
}
