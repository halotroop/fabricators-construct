/*
 * Copyright 2020 halotroop, SlimeKnights
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.halotroop.tconstruct;

import com.halotroop.tconstruct.registry.EntityRegistry;
import com.halotroop.tconstruct.registry.SoundRegistry;
import com.halotroop.tconstruct.registry.RegistryModImpl;
import net.devtech.arrp.api.RRPCallback;
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
	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create("tconstruct");
	
	public static final ItemGroup
			GENERAL_TAB = FabricItemGroupBuilder.build(makeID("general"),
			() -> new ItemStack(RegistryModImpl.GROUT.blockItem)),
			TOOLS_TAB = FabricItemGroupBuilder.build(makeID("tools"),
					() -> new ItemStack(Items.DIAMOND_AXE)),
			TOOL_PARTS_TAB = FabricItemGroupBuilder.build(makeID("tool_parts"),
					() -> new ItemStack(Items.STICK)),
			SMELTERY_TAB = FabricItemGroupBuilder.build(makeID("smeltery"),
					() -> new ItemStack(RegistryModImpl.SEARED_STONE.smooth.block.blockItem)),
			WORLD_TAB = FabricItemGroupBuilder.build(makeID("world"), () ->
					new ItemStack(Items.ACACIA_PLANKS)),
			GADGETS_TAB = FabricItemGroupBuilder.build(makeID("gadgets"),
					() -> new ItemStack(RegistryModImpl.stone_rod));
	
	// Add this to VM arguments to see debug logs
	// -Dfabric.log.level=debug
	public static final Logger logger = LogManager.getLogger(MODID);

	@Override
	public void onInitialize() {
		RRPCallback.EVENT.register(a -> a.add(0, RESOURCE_PACK));
		// Register everything first!
		SoundRegistry.registerAll();
		RegistryModImpl.initialize();
		
		EntityRegistry.registerAllBlockEntityTypes();
		EntityRegistry.registerAllEntityTypes();
		logger.info("Registry done!");
		RESOURCE_PACK.dump();
	}
	
	public static Identifier makeID(String name) {
		return new Identifier(MODID, name);
	}
}
