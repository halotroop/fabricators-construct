package com.halotroop.tconstruct.registry.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.function.Supplier;

public class WoodenSet {
	public final BlockItemPair acacia, birch, dark_oak, oak, jungle;
	public final Block[] allBlocks;
	public final Item[] allBlockItems;
	
	public WoodenSet(String name, Supplier<Block> block, Item.Settings itemSettings) {
		acacia = new BlockItemPair("acacia_" + name, block.get(), itemSettings);
		birch = new BlockItemPair("birch_" + name, block.get(), itemSettings);
		dark_oak = new BlockItemPair("dark_oak_" + name, block.get(), itemSettings);
		oak = new BlockItemPair("oak_" + name, block.get(), itemSettings);
		jungle = new BlockItemPair("jungle_" + name, block.get(), itemSettings);
		// Note: For 1.16+ also add nether woods!
		
		// TODO: Terrestria woods
		allBlocks = new Block[] {acacia.block, birch.block, jungle.block, dark_oak.block, oak.block, jungle.block};
		allBlockItems = new Item[] {acacia.blockItem, birch.blockItem, jungle.blockItem, dark_oak.blockItem,
				oak.blockItem, jungle.blockItem};
	}
}
