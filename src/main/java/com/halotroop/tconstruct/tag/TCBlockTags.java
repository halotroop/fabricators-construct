package com.halotroop.tconstruct.tag;

import com.halotroop.tconstruct.TConstruct;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;

public class TCBlockTags {
	public static Tag<Block>
			METALS,
			TOOL_BENCHES,
			STENCIL_TABLES, TOOL_FORGES, TOOL_BUILDERS;
	
	static void registerAll() {
		METALS = register("metals");
		
		TOOL_BENCHES = register("tool_benches");
		STENCIL_TABLES = register("stencil_tables");
		TOOL_FORGES = register("tool_forges");
		TOOL_BUILDERS = register("tool_builders");
	}
	
	private static Tag<Block> register(String id) {
		return TagRegistry.block(TConstruct.makeID(id));
	}
}
