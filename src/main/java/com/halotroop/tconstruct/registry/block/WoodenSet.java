package com.halotroop.tconstruct.registry.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class WoodenSet {
	public final BlockItemPair acacia, birch, dark_oak, oak, jungle;
	
	public WoodenSet(String name, Block block, Item.Settings itemSettings) {
		acacia = new BlockItemPair("acacia_" + name, block, itemSettings);
		birch = new BlockItemPair("birch_" + name, block, itemSettings);
		dark_oak = new BlockItemPair("dark_oak_" + name, block, itemSettings);
		oak = new BlockItemPair("oak_" + name, block, itemSettings);
		jungle = new BlockItemPair("jungle_" + name, block, itemSettings);
		// Note: For 1.16+ also add nether woods!
		
		// TODO: Terrestria woods
	}
}
