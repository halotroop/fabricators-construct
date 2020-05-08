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

package com.halotroop.registry;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistryMod implements ModInitializer {
	public static final String MODID = "registry";
	public static final Logger logger = LogManager.getLogger(MODID);
	
	public static Identifier makeID(String name) {
		return new Identifier(MODID, name);
	}
	
	public static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, makeID(name), item);
	}
	
	public static Block registerBlock(String name, Block block) {
		return Registry.register(Registry.BLOCK, makeID(name), block);
	}
	
	// Returns the cotton equivalent of the block requested.
	public static Block cottonBlock(String name) {
		return Registry.BLOCK.get(new Identifier("c", name));
	}
	
	// Returns the cotton equivalent of the item requested.
	public static Item cottonItem(String name) {
		return Registry.ITEM.get(new Identifier("c", name));
	}
	
	// Returns true if the block with the given name is NOT registered in the cotton namespace.
	public static boolean cottonBlockCheck(String name) {
		Identifier cotton = new Identifier("c", name);
		return (!FabricLoader.getInstance().isModLoaded("cotton-resources") || (Registry.BLOCK.get(cotton).equals(Blocks.AIR)));
	}
	
	// Returns true if the item with the given name is NOT registered in the cotton namespace.
	public static boolean cottonItemCheck(String name) {
		Identifier cotton = new Identifier("c", name);
		return (FabricLoader.getInstance().isModLoaded("cotton-resources")
				&& (Registry.ITEM.get(cotton).equals(Items.AIR)));
	}
	
	@Override
	public void onInitialize() {
		// TODO: ????
		logger.info("Initialized RegistryMod(TM)!");
	}
}
