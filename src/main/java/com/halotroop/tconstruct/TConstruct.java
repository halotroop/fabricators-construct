package com.halotroop.tconstruct;

import com.halotroop.tconstruct.registry.EverythingRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TConstruct implements ModInitializer {
	public static final String MODID = "tconstruct";
	
	// Add this to VM arguments to see debug logs
	// -Dfabric.log.level=debug
	public static Logger logger = LogManager.getLogger(MODID);

	@Override
	public void onInitialize() {
		// Register everything first!
		EverythingRegistry.registerAll();
		logger.info("Registry done!");
	}
	
	public static Identifier makeID(String name) {
		return new Identifier(MODID, name);
	}
}
