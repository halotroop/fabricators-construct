package com.halotroop.tconstruct.registry;

import com.halotroop.tconstruct.TinkerItemGroups;
import com.halotroop.tconstruct.TConstruct;
import com.halotroop.tconstruct.block.CraftingStationBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class BlockRegistry {
	public static Block CRAFTING_STATION;
	public static List<Block> BLOCKS = new ArrayList<>();
	public static List<Item> BLOCK_ITEMS = new ArrayList<>();
	
	public static void registerAll() {
		registerBlock("grout", Block.Settings.of(Material.CLAY), true);
		
		CRAFTING_STATION = Registry.register(Registry.BLOCK, new Identifier(TConstruct.modid, "crafting_station"), new CraftingStationBlock());
		
		// Storage Blocks
		final String[] storage_block_names = new String[] {"cobalt", "ardite", "manyullyn", "knightslime", "pigiron", "silky_jewel"};
		for (String name : storage_block_names) {
			registerBlock(name + "_block", Block.Settings.copy(Blocks.DIAMOND_BLOCK), true);
		}
	}
	public static Block registerBlock(String name, Block.Settings blockSettings, Item.Settings itemSettings)
	{
		Block block = registerBlock(name, blockSettings);
		ItemRegistry.registerItem(name, new BlockItem(block, itemSettings));
		return block;
	}
	public static Block registerBlock(String name, Block.Settings settings) {
		Block block = Registry.register(Registry.BLOCK, new Identifier(TConstruct.modid, name.toLowerCase()), new Block(settings));
		BLOCKS.add(block);
		return block;
	}
	
	public static Block registerBlock(String name, Block.Settings settings, ItemGroup group) {
		Block block = registerBlock(name, settings);
		BLOCK_ITEMS.add(ItemRegistry.registerItem(name, new BlockItem(block, new Item.Settings().group(TinkerItemGroups.GENERAL_ITEMS))));
		return block;
	}
	
	public static Block registerBlock(String name, Block.Settings settings, boolean item) {
		return item ?
		registerBlock(name, settings, TinkerItemGroups.GENERAL_ITEMS) :
		registerBlock(name, settings);
	}
}
