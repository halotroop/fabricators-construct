package com.halotroop.tconstruct.registry.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import org.jetbrains.annotations.Nullable;

public class DecorStones {
	public final BlockStairSlabSet smooth, cobbled, cracked, fancy, square, road, triangle, small, tile, inscribed;
	
	public DecorStones(@Nullable String prefix, String baseName, Block.Settings blockSettings, Item.Settings itemSettings) {
		String fixedPrefix = (prefix != null) ? prefix+"_" : "";
		String fixedSuffix = "_" + baseName.toLowerCase();

		smooth = new BlockStairSlabSet(fixedPrefix + "smooth" + fixedSuffix, blockSettings, itemSettings);
		cobbled = new BlockStairSlabSet(fixedPrefix + "cobbled" + fixedSuffix, blockSettings, itemSettings);
		cracked = new BlockStairSlabSet(fixedPrefix + "cracked" + fixedSuffix, blockSettings, itemSettings);
		fancy = new BlockStairSlabSet(fixedPrefix + "fancy" + fixedSuffix, blockSettings, itemSettings);
		square = new BlockStairSlabSet(fixedPrefix + "square" + fixedSuffix, blockSettings, itemSettings);
		road = new BlockStairSlabSet(fixedPrefix + "road" + fixedSuffix, blockSettings, itemSettings);
		triangle = new BlockStairSlabSet(fixedPrefix + "triangle" + fixedSuffix, blockSettings, itemSettings);
		small = new BlockStairSlabSet(fixedPrefix + "small" + fixedSuffix, blockSettings, itemSettings);
		tile = new BlockStairSlabSet(fixedPrefix + "tile" + fixedSuffix, blockSettings, itemSettings);
		inscribed = new BlockStairSlabSet(fixedPrefix + "inscribed" + fixedSuffix, blockSettings, itemSettings);
	}
}
