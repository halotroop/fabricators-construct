package com.halotroop.tconstruct.registry;

import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.block.entity.CraftingStationBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityRegistry {
	public static BlockEntityType<CraftingStationBlockEntity> CRAFTING_STATION_BLOCK_ENTITY;
	
	public static void registerAll() {
		CRAFTING_STATION_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(TConstruct.modid, "crafting_station"),
				BlockEntityType.Builder.create(CraftingStationBlockEntity::new, BlockRegistry.CRAFTING_STATION).build(null));
	}
}
