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
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EverythingRegistry {
	
	public static void registerAll() {
		SoundRegistry.registerAll();
		
		GeneralRegistry.registerAllGeneralBlocks();
		GeneralRegistry.registerAllGeneralItems();
		
		SmelteryRegistry.registerAllSmelteryBlocks();
		SmelteryRegistry.registerAllSmelteryItems();
		
		GadgetsRegistry.registerAllGadgetsBlocks();
		GadgetsRegistry.registerAllGadgetsItems();
		
		EntityRegistry.registerAllBlockEntityTypes();
		EntityRegistry.registerAllEntityTypes();
	}
	
	// ---End of registration--- \\
	
	static Block registerBlock (String name, Block entry) {
		final Identifier id = TConstruct.makeID(name.toLowerCase());
		if (Registry.BLOCK.get(id).equals(Blocks.AIR)) {
			TConstruct.logger.debug("REGISTERING " + name);
			return Registry.register(Registry.BLOCK, id, entry);
		}
		else return Blocks.AIR;
	}
	
	public static Block getBlock(String name) {
		return Registry.BLOCK.get(TConstruct.makeID(name));
	}
	
	// ~~~~~ ITEMS ~~~~~ \\
	
	static void registerGeneralItem(String name, Item entry) {
		registerItem(name, entry);
	}
	
	static void registerSmelteryItem(String name, Item entry) {
		registerItem(name, entry);
	}
	
	static void registerGadgetsItem(String name, Item entry) {
		registerItem(name, entry);
	}
	
	private static void registerItem(String name, Item entry) {
		final Identifier id = TConstruct.makeID(name.toLowerCase());
		if (Registry.ITEM.get(id).equals(Items.AIR)) {
			Item item = Registry.register(Registry.ITEM, id, entry);
		}
	}
	
	public static Item getItem(String name) {
		return Registry.ITEM.get(TConstruct.makeID(name));
	}
}
