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

package com.halotroop.tconstruct;

import com.halotroop.tconstruct.registry.EverythingRegistry;
import com.halotroop.tconstruct.registry.block.BlockRegistry;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TConstruct implements ModInitializer {
	public static final String MODID = "tconstruct";
	
	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create("tconstruct:tcon");
	
	public static final ItemGroup
			GENERAL_TAB = FabricItemGroupBuilder.build(makeID("general"), () ->
			{return new ItemStack(EverythingRegistry.getItem("grout"));}),
			TOOLS = FabricItemGroupBuilder.build(makeID("tools"),  () ->
			{return new ItemStack(Items.ACACIA_PLANKS);}),
			TOOL_PARTS_TAB = FabricItemGroupBuilder.build(makeID("tool_parts"), () ->
			{return new ItemStack(Items.ACACIA_PLANKS);}),
			SMELTERY_TAB = FabricItemGroupBuilder.build(makeID("smeltery"),() ->
			{return new ItemStack(Items.ACACIA_PLANKS);}),
			WORLD = FabricItemGroupBuilder.build(makeID("world"), () ->
			{return new ItemStack(Items.ACACIA_PLANKS);}),
			GADGETS_TAB = FabricItemGroupBuilder.build(makeID("gadgets"), () ->
			{return new ItemStack(Items.ACACIA_PLANKS);});
	
	// Add this to VM arguments to see debug logs
	// -Dfabric.log.level=debug
	public static Logger logger = LogManager.getLogger(MODID);

	@Override
	public void onInitialize() {
		// Register everything first!
		new BlockRegistry();
		logger.info("Registry done!");
	}
	
	public static Identifier makeID(String name) {
		return new Identifier(MODID, name);
	}
}
