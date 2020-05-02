package com.halotroop.tconstruct;

import com.halotroop.tconstruct.registry.BlockRegistry;
import com.halotroop.tconstruct.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;

public class TConstruct implements ModInitializer {
	public static String modid = "tconstruct";

	@Override
	public void onInitialize() {
		BlockRegistry.registerAll();
		ItemRegistry.registerAll();
	}
}
