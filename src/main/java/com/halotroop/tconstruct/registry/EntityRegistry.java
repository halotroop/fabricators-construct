package com.halotroop.tconstruct.registry;

import com.halotroop.tconstruct.block.entity.CraftingStationBlockEntity;
import net.minecraft.block.entity.BlockEntityType;

public class EntityRegistry {
	public static BlockEntityType<CraftingStationBlockEntity> CRAFTING_STATION_BLOCK_ENTITY;
	
	static void registerAllBlockEntityTypes() {
		CRAFTING_STATION_BLOCK_ENTITY = BlockEntityType.Builder.create(CraftingStationBlockEntity::new,
				EverythingRegistry.BLOCKS.get("crafting_station")).build(null);
	}
	
	static void registerAllEntityTypes() {
		// TODO: Slimes
	}
}
